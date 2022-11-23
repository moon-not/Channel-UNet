/**
 * Copyright 2015 JogAmp Community. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * The views and conclusions contained in the software and documentation are those of the
 * authors and should not be interpreted as representing official policies, either expressed
 * or implied, of JogAmp Community.
 */
package com.jogamp.gluegen.jcpp;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.jogamp.gluegen.ASTLocusTag;
import com.jogamp.gluegen.ConstantDefinition;
import com.jogamp.gluegen.GenericCPP;
import com.jogamp.gluegen.GlueGen;
import com.jogamp.gluegen.GlueGenException;
import com.jogamp.gluegen.Logging;
import com.jogamp.gluegen.Logging.LoggerIf;

public class JCPP implements GenericCPP {
    private final LoggerIf LOG;

    public final Preprocessor cpp;
    private OutputStream out;
    private final List<String> includePaths;
    private final boolean enableCopyOutput2Stderr;

    public JCPP(final List<String> includePaths, final boolean debug, final boolean copyOutput2Stderr) {
        LOG = Logging.getLogger(JCPP.class);
        setOut(System.out);
        this.includePaths = includePaths;
        this.enableCopyOutput2Stderr = copyOutput2Stderr;

        cpp = new Preprocessor();
        cpp.addFeature(Feature.DIGRAPHS);
        cpp.addFeature(Feature.TRIGRAPHS);
        cpp.addFeature(Feature.LINEMARKERS);
        cpp.addFeature(Feature.CSYNTAX);
        cpp.addFeature(Feature.KEEPCOMMENTS);
        cpp.addWarning(Warning.IMPORT);
        cpp.setListener(new DefaultPreprocessorListener() {
            @Override
            public void handleError(final Source source, final int line, final int column,
                                    final String msg) throws LexerException {
                super.handleError(source, line, column, msg);
                throw new GlueGenException(msg, new ASTLocusTag(source.getPath(), line, column, null));
            }
        });
        if (debug) {
            cpp.addFeature(Feature.DEBUG);
        }
        cpp.setSystemIncludePath(includePaths);
        cpp.setQuoteIncludePath(includePaths);

        if (cpp.getFeature(Feature.DEBUG)) {
            LOG.info("#" + "include \"...\" search starts here:");
            for (final String dir : cpp.getQuoteIncludePath())
                LOG.info("  " + dir);
            LOG.info("#" + "include <...> search starts here:");
            for (final String dir : cpp.getSystemIncludePath())
                LOG.info("  " + dir);
            LOG.info("End of search list.");
        }
    }

    @Override
    public void addDefine(final String name, final String value) throws LexerException {
        cpp.addMacro(name, value);
    }

    @Override
    public List<ConstantDefinition> getConstantDefinitions() throws GlueGenException {
        final List<ConstantDefinition> constants = new ArrayList<ConstantDefinition>();
        final List<Macro> macros;
        try {
            macros = cpp.getMacros(true);
        } catch (final Throwable t) {
            throw new GlueGenException(t);
        }
        final int count = macros.size();
        for(int i=0; i<count; i++) {
            final Macro macro = macros.get(i);
            final String name = macro.getName();
            if( !GlueGen.__GLUEGEN__.equals(name) ) {
                if( !macro.isFunctionLike() ) {
                    final String value = macro.getText();
                    if ( ConstantDefinition.isConstantExpression(value) ) {
                        final Source source = macro.getSource();
                        final ASTLocusTag locus = new ASTLocusTag(
                                                    null != source ? source.getPath() : "<programmatic>",
                                                    null != source ? source.getLine() : -1,
                                                    null != source ? source.getColumn() : -1,
                                                    macro.toString());
                        final ConstantDefinition c = new ConstantDefinition(macro.getName(), value, null, locus);
                        constants.add(c);
                    }
                }
            }
        }
        return constants;
    }

    @Override
    public String findFile(final String filename) {
        final String sep = File.separator;
        for (final String inclPath : includePaths) {
            final String fullPath = inclPath + sep + filename;
            final File file = new File(fullPath);
            if (file.exists()) {
                return fullPath;
            }
        }
        return null;
    }

    @Override
    public OutputStream out() {
        return out;
    }
    @Override
    public void setOut(final OutputStream out) {
        this.out = out;
    }

    @Override
    public void run(final Reader reader, final String filename) throws GlueGenException {
        final PrintWriter writer = new PrintWriter(out);
        cpp.addInput(new LexerSource(reader, true) {
                        @Override
                        public String getPath() { return filename; }
                        @Override
                        public String getName() { return filename; }
                        @Override
                        public String toString() { return "file " + filename; }
                   } );
        try {
            for (;;) {
                final Token tok = cpp.token();
                if (tok == null)
                    break;
                if (tok.getType() == Token.EOF)
                    break;
                final String s = tok.getText();
                writer.print(s);
                if (enableCopyOutput2Stderr) {
                    System.err.print(s);
                    System.err.flush();
                }
            }
            writer.flush();
        } catch (final Exception e) {
            final StringBuilder buf = new StringBuilder("Preprocessor failed:\n");
            Source s = cpp.getSource();
            while (s != null) {
                buf.append(" -> ").append(s).append("\n");
                s = s.getParent();
            }
            buf.append(" : {0}\n");
            LOG.log(Level.SEVERE, buf.toString(), e);
            if( e instanceof GlueGenException ) {
                throw (GlueGenException)e;
            } else {
                throw new GlueGenException("Preprocessor failed",
                                           new ASTLocusTag(null != s ? s.getPath() : "n/a",
                                                           null != s ? s.getLine() : -1,
                                                           null != s ? s.getColumn() : -1, null), e);
            }
        }
    }

}
