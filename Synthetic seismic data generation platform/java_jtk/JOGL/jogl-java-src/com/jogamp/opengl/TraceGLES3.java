package com.jogamp.opengl;

import java.io.*;
import com.jogamp.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import com.jogamp.opengl.GLES3;
import com.jogamp.opengl.GLES2;
import com.jogamp.opengl.GL4ES3;

/**
 * <p>
 * Composable pipeline which wraps an underlying {@link GL} implementation,
 * providing tracing information to a user-specified {@link java.io.PrintStream}
 * before and after each OpenGL method call.
 * </p>
 * <p>
 * Sample code which installs this pipeline:
 * <pre>
 *   gl = drawable.setGL(new TraceGL(drawable.getGL(), System.err));
 * </pre>
 * For automatic instantiation see {@link GLPipelineFactory#create(String, Class, GL, Object[])}
 * </p>
 */
public class TraceGLES3 implements com.jogamp.opengl.GLES2, com.jogamp.opengl.GL4ES3, com.jogamp.opengl.GLES3{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("TraceGLES3");
  public TraceGLES3(GLES3 downstreamGLES3, PrintStream stream)
  {
    if (downstreamGLES3 == null) {
      throw new IllegalArgumentException("null downstreamGLES3");
    }
    this.downstreamGLES3 = downstreamGLES3;
    this.stream = stream;
  }

  @Override
  public final GL getDownstreamGL() throws GLException {
    return downstreamGLES3;
  }
  @Override
  public int getBoundBuffer(int arg0)
  {
    return downstreamGLES3.getBoundBuffer(arg0);
  }
  @Override
  public int getBoundFramebuffer(int arg0)
  {
    return downstreamGLES3.getBoundFramebuffer(arg0);
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage getBufferStorage(int arg0)
  {
    return downstreamGLES3.getBufferStorage(arg0);
  }
  @Override
  public com.jogamp.opengl.GLContext getContext()
  {
    return downstreamGLES3.getContext();
  }
  @Override
  public int getDefaultDrawFramebuffer()
  {
    return downstreamGLES3.getDefaultDrawFramebuffer();
  }
  @Override
  public int getDefaultReadBuffer()
  {
    return downstreamGLES3.getDefaultReadBuffer();
  }
  @Override
  public int getDefaultReadFramebuffer()
  {
    return downstreamGLES3.getDefaultReadFramebuffer();
  }
  @Override
  public java.lang.Object getExtension(java.lang.String arg0)
  {
    return downstreamGLES3.getExtension(arg0);
  }
  @Override
  public com.jogamp.opengl.GL getGL()
  {
    return this;
  }
  @Override
  public com.jogamp.opengl.GL2 getGL2()
  {
    throw new GLException("Not a GL2 implementation");
  }
  @Override
  public com.jogamp.opengl.GL2ES1 getGL2ES1()
  {
    throw new GLException("Not a GL2ES1 implementation");
  }
  @Override
  public com.jogamp.opengl.GL2ES2 getGL2ES2()
  {
    if( isGL2ES2() ) { return this; }
    throw new GLException("Not a GL2ES2 implementation");
  }
  @Override
  public com.jogamp.opengl.GL2ES3 getGL2ES3()
  {
    if( isGL2ES3() ) { return this; }
    throw new GLException("Not a GL2ES3 implementation");
  }
  @Override
  public com.jogamp.opengl.GL2GL3 getGL2GL3()
  {
    throw new GLException("Not a GL2GL3 implementation");
  }
  @Override
  public com.jogamp.opengl.GL3 getGL3()
  {
    throw new GLException("Not a GL3 implementation");
  }
  @Override
  public com.jogamp.opengl.GL3ES3 getGL3ES3()
  {
    if( isGL3ES3() ) { return this; }
    throw new GLException("Not a GL3ES3 implementation");
  }
  @Override
  public com.jogamp.opengl.GL3bc getGL3bc()
  {
    throw new GLException("Not a GL3bc implementation");
  }
  @Override
  public com.jogamp.opengl.GL4 getGL4()
  {
    throw new GLException("Not a GL4 implementation");
  }
  @Override
  public com.jogamp.opengl.GL4ES3 getGL4ES3()
  {
    if( isGL4ES3() ) { return this; }
    throw new GLException("Not a GL4ES3 implementation");
  }
  @Override
  public com.jogamp.opengl.GL4bc getGL4bc()
  {
    throw new GLException("Not a GL4bc implementation");
  }
  @Override
  public com.jogamp.opengl.GLES1 getGLES1()
  {
    throw new GLException("Not a GLES1 implementation");
  }
  @Override
  public com.jogamp.opengl.GLES2 getGLES2()
  {
    if( isGLES2() ) { return this; }
    throw new GLException("Not a GLES2 implementation");
  }
  @Override
  public com.jogamp.opengl.GLES3 getGLES3()
  {
    if( isGLES3() ) { return this; }
    throw new GLException("Not a GLES3 implementation");
  }
  @Override
  public com.jogamp.opengl.GLProfile getGLProfile()
  {
    return downstreamGLES3.getGLProfile();
  }
  @Override
  public int getMaxRenderbufferSamples()
  {
    return downstreamGLES3.getMaxRenderbufferSamples();
  }
  @Override
  public java.lang.Object getPlatformGLExtensions()
  {
    return downstreamGLES3.getPlatformGLExtensions();
  }
  @Override
  public com.jogamp.opengl.GL getRootGL()
  {
    return downstreamGLES3.getRootGL();
  }
  @Override
  public int getSwapInterval()
  {
    return downstreamGLES3.getSwapInterval();
  }
  @Override
  public void glActiveShaderProgram(int arg0,int arg1)
  {
    printIndent();
    print(    "glActiveShaderProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glActiveShaderProgram(arg0,arg1);
    println("");
  }
  @Override
  public void glActiveTexture(int arg0)
  {
    printIndent();
    print(    "glActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glActiveTexture(arg0);
    println("");
  }
  @Override
  public void glAlphaFuncQCOM(int arg0,float arg1)
  {
    printIndent();
    print(    "glAlphaFuncQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES3.glAlphaFuncQCOM(arg0,arg1);
    println("");
  }
  @Override
  public void glApplyFramebufferAttachmentCMAAINTEL()
  {
    printIndent();
    print(    "glApplyFramebufferAttachmentCMAAINTEL("+")");
    downstreamGLES3.glApplyFramebufferAttachmentCMAAINTEL();
    println("");
  }
  @Override
  public void glAttachShader(int arg0,int arg1)
  {
    printIndent();
    print(    "glAttachShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glAttachShader(arg0,arg1);
    println("");
  }
  @Override
  public void glBeginConditionalRender(int arg0,int arg1)
  {
    printIndent();
    print(    "glBeginConditionalRender("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBeginConditionalRender(arg0,arg1);
    println("");
  }
  @Override
  public void glBeginQuery(int arg0,int arg1)
  {
    printIndent();
    print(    "glBeginQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBeginQuery(arg0,arg1);
    println("");
  }
  @Override
  public void glBeginTransformFeedback(int arg0)
  {
    printIndent();
    print(    "glBeginTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glBeginTransformFeedback(arg0);
    println("");
  }
  @Override
  public void glBindAttribLocation(int arg0,int arg1,java.lang.String arg2)
  {
    printIndent();
    print(    "glBindAttribLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.lang.String> "+arg2+")");
    downstreamGLES3.glBindAttribLocation(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBindBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBindBuffer(arg0,arg1);
    println("");
  }
  @Override
  public void glBindBufferBase(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBindBufferBase("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBindBufferBase(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBindBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glBindBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
    downstreamGLES3.glBindBufferRange(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glBindFragDataLocationEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glBindFragDataLocationEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glBindFragDataLocationEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBindFragDataLocationEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glBindFragDataLocationEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
    downstreamGLES3.glBindFragDataLocationEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBindFragDataLocationIndexedEXT(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glBindFragDataLocationIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glBindFragDataLocationIndexedEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBindFragDataLocationIndexedEXT(int arg0,int arg1,int arg2,byte[] arg3,int arg4)
  {
    printIndent();
    print(    "glBindFragDataLocationIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glBindFragDataLocationIndexedEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glBindFramebuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBindFramebuffer(arg0,arg1);
    println("");
  }
  @Override
  public void glBindImageTexture(int arg0,int arg1,int arg2,boolean arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glBindImageTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glBindImageTexture(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glBindProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glBindProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glBindProgramPipeline(arg0);
    println("");
  }
  @Override
  public void glBindRenderbuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBindRenderbuffer(arg0,arg1);
    println("");
  }
  @Override
  public void glBindSampler(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindSampler("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBindSampler(arg0,arg1);
    println("");
  }
  @Override
  public void glBindTexture(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBindTexture(arg0,arg1);
    println("");
  }
  @Override
  public void glBindTransformFeedback(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBindTransformFeedback(arg0,arg1);
    println("");
  }
  @Override
  public void glBindVertexArray(int arg0)
  {
    printIndent();
    print(    "glBindVertexArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glBindVertexArray(arg0);
    println("");
  }
  @Override
  public void glBindVertexArrayOES(int arg0)
  {
    printIndent();
    print(    "glBindVertexArrayOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glBindVertexArrayOES(arg0);
    println("");
  }
  @Override
  public void glBindVertexBuffer(int arg0,int arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "glBindVertexBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glBindVertexBuffer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBlendBarrier()
  {
    printIndent();
    print(    "glBlendBarrier("+")");
    downstreamGLES3.glBlendBarrier();
    println("");
  }
  @Override
  public void glBlendColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glBlendColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES3.glBlendColor(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBlendEquation(int arg0)
  {
    printIndent();
    print(    "glBlendEquation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glBlendEquation(arg0);
    println("");
  }
  @Override
  public void glBlendEquationSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBlendEquationSeparate(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendEquationSeparatei(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendEquationSeparatei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBlendEquationSeparatei(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBlendEquationSeparateiEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendEquationSeparateiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBlendEquationSeparateiEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBlendEquationSeparateiOES(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendEquationSeparateiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBlendEquationSeparateiOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBlendEquationi(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBlendEquationi(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendEquationiEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBlendEquationiEXT(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendEquationiOES(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBlendEquationiOES(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendFunc(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glBlendFunc(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glBlendFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBlendFuncSeparatei(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBlendFuncSeparatei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glBlendFuncSeparatei(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glBlendFuncSeparateiEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBlendFuncSeparateiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glBlendFuncSeparateiEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glBlendFuncSeparateiOES(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glBlendFuncSeparateiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glBlendFuncSeparateiOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glBlendFunci(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendFunci("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBlendFunci(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBlendFunciEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendFunciEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBlendFunciEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBlendFunciOES(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glBlendFunciOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glBlendFunciOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glBlitFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glBlitFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
    downstreamGLES3.glBlitFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  @Override
  public void glBlitFramebufferANGLE(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glBlitFramebufferANGLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
    downstreamGLES3.glBlitFramebufferANGLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  @Override
  public void glBlitFramebufferNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    printIndent();
    print(    "glBlitFramebufferNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+")");
    downstreamGLES3.glBlitFramebufferNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  @Override
  public void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glBufferData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glBufferData(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBufferStorageEXT(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glBufferStorageEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glBufferStorageEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES3.glBufferSubData(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public int glCheckFramebufferStatus(int arg0)
  {
    printIndent();
    print(    "glCheckFramebufferStatus("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGLES3.glCheckFramebufferStatus(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glClear(int arg0)
  {
    printIndent();
    print(    "glClear("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glClear(arg0);
    println("");
  }
  @Override
  public void glClearBufferfi(int arg0,int arg1,float arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferfi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glClearBufferfi(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearBufferfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glClearBufferfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glClearBufferfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glClearBufferfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearBufferiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glClearBufferiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glClearBufferiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glClearBufferiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearBufferuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glClearBufferuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glClearBufferuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearBufferuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glClearBufferuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glClearBufferuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glClearColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES3.glClearColor(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearDepth(double arg0)
  {
    printIndent();
    print(    "glClearDepth("+"<double> "+arg0+")");
    downstreamGLES3.glClearDepth(arg0);
    println("");
  }
  @Override
  public void glClearDepthf(float arg0)
  {
    printIndent();
    print(    "glClearDepthf("+"<float> "+arg0+")");
    downstreamGLES3.glClearDepthf(arg0);
    println("");
  }
  @Override
  public void glClearStencil(int arg0)
  {
    printIndent();
    print(    "glClearStencil("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glClearStencil(arg0);
    println("");
  }
  @Override
  public int glClientWaitSync(long arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glClientWaitSync("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
    int _res = downstreamGLES3.glClientWaitSync(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    printIndent();
    print(    "glColorMask("+"<boolean> "+arg0+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+")");
    downstreamGLES3.glColorMask(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glColorMaski(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    printIndent();
    print(    "glColorMaski("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+", "+"<boolean> "+arg4+")");
    downstreamGLES3.glColorMaski(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glColorMaskiEXT(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    printIndent();
    print(    "glColorMaskiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+", "+"<boolean> "+arg4+")");
    downstreamGLES3.glColorMaskiEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glColorMaskiOES(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    printIndent();
    print(    "glColorMaskiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+", "+"<boolean> "+arg4+")");
    downstreamGLES3.glColorMaskiOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glCompileShader(int arg0)
  {
    printIndent();
    print(    "glCompileShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glCompileShader(arg0);
    println("");
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
    downstreamGLES3.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<long> "+arg7+")");
    downstreamGLES3.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES3.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES3.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES3.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES3.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glCompressedTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
    downstreamGLES3.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    printIndent();
    print(    "glCompressedTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<long> "+arg10+")");
    downstreamGLES3.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glCopyBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glCopyBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
    downstreamGLES3.glCopyBufferSubData(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glCopyBufferSubDataNV(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glCopyBufferSubDataNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
    downstreamGLES3.glCopyBufferSubDataNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glCopyImageSubData(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,int arg11,int arg12,int arg13,int arg14)
  {
    printIndent();
    print(    "glCopyImageSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg12).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg13).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg14).toUpperCase()+")");
    downstreamGLES3.glCopyImageSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13,arg14);
    println("");
  }
  @Override
  public void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCopyTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    printIndent();
    print(    "glCopyTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+")");
    downstreamGLES3.glCopyTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCopyTextureLevelsAPPLE(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glCopyTextureLevelsAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glCopyTextureLevelsAPPLE(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glCoverageMaskNV(boolean arg0)
  {
    printIndent();
    print(    "glCoverageMaskNV("+"<boolean> "+arg0+")");
    downstreamGLES3.glCoverageMaskNV(arg0);
    println("");
  }
  @Override
  public void glCoverageModulationNV(int arg0)
  {
    printIndent();
    print(    "glCoverageModulationNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glCoverageModulationNV(arg0);
    println("");
  }
  @Override
  public void glCoverageModulationTableNV(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glCoverageModulationTableNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glCoverageModulationTableNV(arg0,arg1);
    println("");
  }
  @Override
  public void glCoverageModulationTableNV(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glCoverageModulationTableNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glCoverageModulationTableNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glCoverageOperationNV(int arg0)
  {
    printIndent();
    print(    "glCoverageOperationNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glCoverageOperationNV(arg0);
    println("");
  }
  @Override
  public int glCreateProgram()
  {
    printIndent();
    print(    "glCreateProgram("+")");
    int _res = downstreamGLES3.glCreateProgram();
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glCreateShader(int arg0)
  {
    printIndent();
    print(    "glCreateShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGLES3.glCreateShader(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glCreateShaderProgramv(int arg0,int arg1,java.lang.String[] arg2)
  {
    printIndent();
    print(    "glCreateShaderProgramv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+")");
    int _res = downstreamGLES3.glCreateShaderProgramv(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glCullFace(int arg0)
  {
    printIndent();
    print(    "glCullFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glCullFace(arg0);
    println("");
  }
  @Override
  public void glDebugMessageControl(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glDebugMessageControl("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
    downstreamGLES3.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glDebugMessageControl(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,boolean arg5)
  {
    printIndent();
    print(    "glDebugMessageControl("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<boolean> "+arg5+")");
    downstreamGLES3.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDebugMessageInsert(int arg0,int arg1,int arg2,int arg3,int arg4,java.lang.String arg5)
  {
    printIndent();
    print(    "glDebugMessageInsert("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.lang.String> "+arg5+")");
    downstreamGLES3.glDebugMessageInsert(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteBuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteBuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteFramebuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteFramebuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteProgram(int arg0)
  {
    printIndent();
    print(    "glDeleteProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glDeleteProgram(arg0);
    println("");
  }
  @Override
  public void glDeleteProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteProgramPipelines(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteProgramPipelines(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteQueries(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteQueries(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteQueries(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteQueries(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteRenderbuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteSamplers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteSamplers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteSamplers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteShader(int arg0)
  {
    printIndent();
    print(    "glDeleteShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glDeleteShader(arg0);
    println("");
  }
  @Override
  public void glDeleteSync(long arg0)
  {
    printIndent();
    print(    "glDeleteSync("+"<long> "+arg0+")");
    downstreamGLES3.glDeleteSync(arg0);
    println("");
  }
  @Override
  public void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteTextures(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteTextures(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteTransformFeedbacks(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteTransformFeedbacks(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteVertexArrays(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteVertexArrays(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteVertexArrays(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDeleteVertexArraysOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDeleteVertexArraysOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDepthFunc(int arg0)
  {
    printIndent();
    print(    "glDepthFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glDepthFunc(arg0);
    println("");
  }
  @Override
  public void glDepthMask(boolean arg0)
  {
    printIndent();
    print(    "glDepthMask("+"<boolean> "+arg0+")");
    downstreamGLES3.glDepthMask(arg0);
    println("");
  }
  @Override
  public void glDepthRange(double arg0,double arg1)
  {
    printIndent();
    print(    "glDepthRange("+"<double> "+arg0+", "+"<double> "+arg1+")");
    downstreamGLES3.glDepthRange(arg0,arg1);
    println("");
  }
  @Override
  public void glDepthRangeArrayfvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glDepthRangeArrayfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glDepthRangeArrayfvNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDepthRangeArrayfvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glDepthRangeArrayfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glDepthRangeArrayfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDepthRangeIndexedfNV(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glDepthRangeIndexedfNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
    downstreamGLES3.glDepthRangeIndexedfNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDepthRangef(float arg0,float arg1)
  {
    printIndent();
    print(    "glDepthRangef("+"<float> "+arg0+", "+"<float> "+arg1+")");
    downstreamGLES3.glDepthRangef(arg0,arg1);
    println("");
  }
  @Override
  public void glDetachShader(int arg0,int arg1)
  {
    printIndent();
    print(    "glDetachShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glDetachShader(arg0,arg1);
    println("");
  }
  @Override
  public void glDisable(int arg0)
  {
    printIndent();
    print(    "glDisable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glDisable(arg0);
    println("");
  }
  @Override
  public void glDisableDriverControlQCOM(int arg0)
  {
    printIndent();
    print(    "glDisableDriverControlQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glDisableDriverControlQCOM(arg0);
    println("");
  }
  @Override
  public void glDisableVertexAttribArray(int arg0)
  {
    printIndent();
    print(    "glDisableVertexAttribArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glDisableVertexAttribArray(arg0);
    println("");
  }
  @Override
  public void glDisablei(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisablei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glDisablei(arg0,arg1);
    println("");
  }
  @Override
  public void glDisableiEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisableiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glDisableiEXT(arg0,arg1);
    println("");
  }
  @Override
  public void glDisableiNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisableiNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glDisableiNV(arg0,arg1);
    println("");
  }
  @Override
  public void glDisableiOES(int arg0,int arg1)
  {
    printIndent();
    print(    "glDisableiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glDisableiOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glDiscardFramebufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glDiscardFramebufferEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glDiscardFramebufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glDiscardFramebufferEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDispatchCompute(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDispatchCompute("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDispatchCompute(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDispatchComputeIndirect(long arg0)
  {
    printIndent();
    print(    "glDispatchComputeIndirect("+"<long> "+arg0+")");
    downstreamGLES3.glDispatchComputeIndirect(arg0);
    println("");
  }
  @Override
  public void glDrawArrays(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDrawArrays(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawArraysIndirect(int arg0,long arg1)
  {
    printIndent();
    print(    "glDrawArraysIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
    downstreamGLES3.glDrawArraysIndirect(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawArraysIndirect(int arg0,java.nio.Buffer arg1)
  {
    printIndent();
    print(    "glDrawArraysIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+")");
    downstreamGLES3.glDrawArraysIndirect(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawArraysInstanced(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawArraysInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glDrawArraysInstanced(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawArraysInstancedANGLE(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawArraysInstancedANGLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glDrawArraysInstancedANGLE(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawArraysInstancedBaseInstance(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glDrawArraysInstancedBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawArraysInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawArraysInstancedNV(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glDrawArraysInstancedNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glDrawArraysInstancedNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDrawBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glDrawBuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDrawBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glDrawBuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawBuffersIndexedEXT(int arg0,int[] arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glDrawBuffersIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawBuffersIndexedEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawBuffersIndexedEXT(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glDrawBuffersIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glDrawBuffersIndexedEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
    downstreamGLES3.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES3.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsBaseVertexEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsBaseVertexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsBaseVertexOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsBaseVertexOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsIndirect(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glDrawElementsIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
    downstreamGLES3.glDrawElementsIndirect(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawElementsIndirect(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glDrawElementsIndirect("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
    downstreamGLES3.glDrawElementsIndirect(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawElementsInstanced(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsInstanced(int arg0,int arg1,int arg2,long arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsInstanced("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsInstancedANGLE(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsInstancedANGLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedANGLE(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertexBaseInstance("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glDrawElementsInstancedBaseVertexEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawElementsInstancedBaseVertexOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glDrawElementsInstancedBaseVertexOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawElementsInstancedNV(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glDrawElementsInstancedNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glDrawElementsInstancedNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glDrawRangeElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
    downstreamGLES3.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glDrawRangeElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
    downstreamGLES3.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5,int arg6)
  {
    printIndent();
    print(    "glDrawRangeElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    printIndent();
    print(    "glDrawRangeElementsBaseVertex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glDrawRangeElementsBaseVertexEXT(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    printIndent();
    print(    "glDrawRangeElementsBaseVertexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glDrawRangeElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glDrawRangeElementsBaseVertexOES(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    printIndent();
    print(    "glDrawRangeElementsBaseVertexOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glDrawRangeElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glEGLImageTargetRenderbufferStorageOES(int arg0,long arg1)
  {
    printIndent();
    print(    "glEGLImageTargetRenderbufferStorageOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
    downstreamGLES3.glEGLImageTargetRenderbufferStorageOES(arg0,arg1);
    println("");
  }
  @Override
  public void glEGLImageTargetTexture2DOES(int arg0,long arg1)
  {
    printIndent();
    print(    "glEGLImageTargetTexture2DOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
    downstreamGLES3.glEGLImageTargetTexture2DOES(arg0,arg1);
    println("");
  }
  @Override
  public void glEnable(int arg0)
  {
    printIndent();
    print(    "glEnable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glEnable(arg0);
    println("");
  }
  @Override
  public void glEnableDriverControlQCOM(int arg0)
  {
    printIndent();
    print(    "glEnableDriverControlQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glEnableDriverControlQCOM(arg0);
    println("");
  }
  @Override
  public void glEnableVertexAttribArray(int arg0)
  {
    printIndent();
    print(    "glEnableVertexAttribArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glEnableVertexAttribArray(arg0);
    println("");
  }
  @Override
  public void glEnablei(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnablei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glEnablei(arg0,arg1);
    println("");
  }
  @Override
  public void glEnableiEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnableiEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glEnableiEXT(arg0,arg1);
    println("");
  }
  @Override
  public void glEnableiNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnableiNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glEnableiNV(arg0,arg1);
    println("");
  }
  @Override
  public void glEnableiOES(int arg0,int arg1)
  {
    printIndent();
    print(    "glEnableiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glEnableiOES(arg0,arg1);
    println("");
  }
  @Override
  public void glEndConditionalRender()
  {
    printIndent();
    print(    "glEndConditionalRender("+")");
    downstreamGLES3.glEndConditionalRender();
    println("");
  }
  @Override
  public void glEndQuery(int arg0)
  {
    printIndent();
    print(    "glEndQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glEndQuery(arg0);
    println("");
  }
  @Override
  public void glEndTilingQCOM(int arg0)
  {
    printIndent();
    print(    "glEndTilingQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glEndTilingQCOM(arg0);
    println("");
  }
  @Override
  public void glEndTransformFeedback()
  {
    printIndent();
    print(    "glEndTransformFeedback("+")");
    downstreamGLES3.glEndTransformFeedback();
    println("");
  }
  @Override
  public void glExtGetBufferPointervQCOM(int arg0,com.jogamp.common.nio.PointerBuffer arg1)
  {
    printIndent();
    print(    "glExtGetBufferPointervQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg1+")");
    downstreamGLES3.glExtGetBufferPointervQCOM(arg0,arg1);
    println("");
  }
  @Override
  public void glExtGetBuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetBuffersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glExtGetBuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetBuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetBuffersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glExtGetBuffersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetFramebuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetFramebuffersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glExtGetFramebuffersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetFramebuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetFramebuffersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glExtGetFramebuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,java.nio.ByteBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glExtGetProgramBinarySourceQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,byte[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glExtGetProgramBinarySourceQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glExtGetProgramsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetProgramsQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glExtGetProgramsQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetProgramsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetProgramsQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glExtGetProgramsQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetRenderbuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetRenderbuffersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glExtGetRenderbuffersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetRenderbuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetRenderbuffersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glExtGetRenderbuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetShadersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetShadersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glExtGetShadersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetShadersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetShadersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glExtGetShadersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glExtGetTexLevelParameterivQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
    downstreamGLES3.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glExtGetTexLevelParameterivQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glExtGetTexSubImageQCOM(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glExtGetTexSubImageQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
    downstreamGLES3.glExtGetTexSubImageQCOM(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glExtGetTexturesQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetTexturesQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glExtGetTexturesQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetTexturesQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetTexturesQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glExtGetTexturesQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public boolean glExtIsProgramBinaryQCOM(int arg0)
  {
    printIndent();
    print(    "glExtIsProgramBinaryQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glExtIsProgramBinaryQCOM(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glExtTexObjectStateOverrideiQCOM(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glExtTexObjectStateOverrideiQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glExtTexObjectStateOverrideiQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public long glFenceSync(int arg0,int arg1)
  {
    printIndent();
    print(    "glFenceSync("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    long _res = downstreamGLES3.glFenceSync(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glFinish()
  {
    printIndent();
    print(    "glFinish("+")");
    downstreamGLES3.glFinish();
    println("");
  }
  @Override
  public void glFlush()
  {
    printIndent();
    print(    "glFlush("+")");
    downstreamGLES3.glFlush();
    println("");
  }
  @Override
  public void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glFlushMappedBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
    downstreamGLES3.glFlushMappedBufferRange(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glFragmentCoverageColorNV(int arg0)
  {
    printIndent();
    print(    "glFragmentCoverageColorNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glFragmentCoverageColorNV(arg0);
    println("");
  }
  @Override
  public void glFramebufferParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glFramebufferParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glFramebufferParameteri(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glFramebufferSampleLocationsfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferSampleLocationsfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glFramebufferTexture(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glFramebufferTexture(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTexture2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glFramebufferTexture2DMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture2DMultisampleEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glFramebufferTexture2DMultisampleEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFramebufferTexture2DMultisampleIMG(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture2DMultisampleIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glFramebufferTexture2DMultisampleIMG(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFramebufferTexture3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glFramebufferTexture3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFramebufferTextureEXT(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTextureEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glFramebufferTextureEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTextureLayer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glFramebufferTextureMultiviewOVR(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTextureMultiviewOVR("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glFramebufferTextureMultiviewOVR(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFramebufferTextureOES(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferTextureOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glFramebufferTextureOES(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glFrontFace(int arg0)
  {
    printIndent();
    print(    "glFrontFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glFrontFace(arg0);
    println("");
  }
  @Override
  public void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenBuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenBuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenFramebuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenFramebuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenProgramPipelines(arg0,arg1);
    println("");
  }
  @Override
  public void glGenProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenProgramPipelines("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenProgramPipelines(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenQueries(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenQueries(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenQueries(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenQueries("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenQueries(arg0,arg1);
    println("");
  }
  @Override
  public void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenRenderbuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenSamplers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenSamplers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenSamplers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenSamplers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenTextures(arg0,arg1);
    println("");
  }
  @Override
  public void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenTextures(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenTransformFeedbacks(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTransformFeedbacks("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenTransformFeedbacks(arg0,arg1);
    println("");
  }
  @Override
  public void glGenVertexArrays(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenVertexArrays(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenVertexArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenVertexArrays(arg0,arg1);
    println("");
  }
  @Override
  public void glGenVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGenVertexArraysOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGenVertexArraysOES(arg0,arg1);
    println("");
  }
  @Override
  public void glGenerateMipmap(int arg0)
  {
    printIndent();
    print(    "glGenerateMipmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glGenerateMipmap(arg0);
    println("");
  }
  @Override
  public void glGetActiveAttrib(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
    downstreamGLES3.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetActiveAttrib(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveAttrib("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
    downstreamGLES3.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glGetActiveUniform(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetActiveUniform("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
    downstreamGLES3.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetActiveUniform(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetActiveUniform("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
    downstreamGLES3.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformBlockName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformBlockName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
    downstreamGLES3.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetActiveUniformBlockiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetActiveUniformBlockiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetActiveUniformsiv(int arg0,int arg1,int[] arg2,int arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetActiveUniformsiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetActiveUniformsiv(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetActiveUniformsiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
    downstreamGLES3.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetAttachedShaders(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetAttachedShaders("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetAttachedShaders(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetAttachedShaders(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetAttachedShaders("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetAttachedShaders(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public int glGetAttribLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetAttribLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGLES3.glGetAttribLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetBooleani_v(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBooleani_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetBooleani_v(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetBooleani_v(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetBooleani_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
    downstreamGLES3.glGetBooleani_v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
    downstreamGLES3.glGetBooleanv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGetBooleanv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteri64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
    downstreamGLES3.glGetBufferParameteri64v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetBufferParameteri64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteri64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetBufferParameteri64v(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetBufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetCoverageModulationTableNV(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetCoverageModulationTableNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGetCoverageModulationTableNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetCoverageModulationTableNV(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetCoverageModulationTableNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glGetCoverageModulationTableNV(arg0,arg1);
    println("");
  }
  @Override
  public int glGetDebugMessageLog(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,int[] arg10,int arg11,byte[] arg12,int arg13)
  {
    printIndent();
    print(    "glGetDebugMessageLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg11).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg13).toUpperCase()+")");
    int _res = downstreamGLES3.glGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetDebugMessageLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.IntBuffer arg6,java.nio.ByteBuffer arg7)
  {
    printIndent();
    print(    "glGetDebugMessageLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.IntBuffer> "+arg6+", "+"<java.nio.ByteBuffer> "+arg7+")");
    int _res = downstreamGLES3.glGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetDriverControlStringQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetDriverControlStringQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetDriverControlsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetDriverControlsQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetDriverControlsQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetDriverControlsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetDriverControlsQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetDriverControlsQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public int glGetError()
  {
    printIndent();
    print(    "glGetError("+")");
    int _res = downstreamGLES3.glGetError();
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetFloati_vNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetFloati_vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glGetFloati_vNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetFloati_vNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFloati_vNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetFloati_vNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glGetFloatv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGetFloatv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public int glGetFragDataIndexEXT(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetFragDataIndexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
    int _res = downstreamGLES3.glGetFragDataIndexEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetFragDataIndexEXT(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetFragDataIndexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    int _res = downstreamGLES3.glGetFragDataIndexEXT(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetFragDataLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetFragDataLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGLES3.glGetFragDataLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetFramebufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetFramebufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetFramebufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetFramebufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetFramebufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetFramebufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public int glGetGraphicsResetStatus()
  {
    printIndent();
    print(    "glGetGraphicsResetStatus("+")");
    int _res = downstreamGLES3.glGetGraphicsResetStatus();
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetInteger64i_v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetInteger64i_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetInteger64i_v(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetInteger64i_v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetInteger64i_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
    downstreamGLES3.glGetInteger64i_v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetInteger64v(int arg0,java.nio.LongBuffer arg1)
  {
    printIndent();
    print(    "glGetInteger64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg1+")");
    downstreamGLES3.glGetInteger64v(arg0,arg1);
    println("");
  }
  @Override
  public void glGetInteger64v(int arg0,long[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetInteger64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGetInteger64v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetIntegeri_v(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegeri_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetIntegeri_v(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetIntegeri_v(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegeri_v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetIntegeri_v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetIntegeri_vEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetIntegeri_vEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetIntegeri_vEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetIntegeri_vEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetIntegeri_vEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetIntegeri_vEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glGetIntegerv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glGetIntegerv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetInternalformativ("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
    downstreamGLES3.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetInternalformativ("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetMultisamplefv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMultisamplefv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glGetMultisamplefv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetMultisamplefv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMultisamplefv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetMultisamplefv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetObjectLabel(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    printIndent();
    print(    "glGetObjectLabel("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.ByteBuffer> "+arg4+")");
    downstreamGLES3.glGetObjectLabel(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetObjectLabel(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetObjectLabel("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glGetObjectLabel(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetObjectPtrLabel(java.nio.Buffer arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetObjectPtrLabel("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetObjectPtrLabel(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetObjectPtrLabel(java.nio.Buffer arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetObjectPtrLabel("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetObjectPtrLabel(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetProgramBinary(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glGetProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.Buffer> "+arg4+")");
    downstreamGLES3.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetProgramBinary(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glGetProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
    downstreamGLES3.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetProgramInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetProgramInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetProgramInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetProgramInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetProgramInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetProgramInterfaceiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetProgramInterfaceiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetProgramInterfaceiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetProgramInterfaceiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramInterfaceiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetProgramInterfaceiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetProgramPipelineInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetProgramPipelineInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetProgramPipelineInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetProgramPipelineInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetProgramPipelineiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramPipelineiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetProgramPipelineiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetProgramPipelineiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramPipelineiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetProgramPipelineiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public int glGetProgramResourceIndex(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramResourceIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    int _res = downstreamGLES3.glGetProgramResourceIndex(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetProgramResourceIndex(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramResourceIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
    int _res = downstreamGLES3.glGetProgramResourceIndex(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetProgramResourceLocation(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramResourceLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
    int _res = downstreamGLES3.glGetProgramResourceLocation(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetProgramResourceLocation(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramResourceLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    int _res = downstreamGLES3.glGetProgramResourceLocation(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetProgramResourceLocationIndexEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramResourceLocationIndexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
    int _res = downstreamGLES3.glGetProgramResourceLocationIndexEXT(arg0,arg1,arg2);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glGetProgramResourceLocationIndexEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramResourceLocationIndexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    int _res = downstreamGLES3.glGetProgramResourceLocationIndexEXT(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetProgramResourceName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
    printIndent();
    print(    "glGetProgramResourceName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glGetProgramResourceName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glGetProgramResourceName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
    printIndent();
    print(    "glGetProgramResourceName("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.ByteBuffer> "+arg5+")");
    downstreamGLES3.glGetProgramResourceName(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetProgramResourceiv(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,int arg6,int[] arg7,int arg8,int[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetProgramResourceiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
    downstreamGLES3.glGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glGetProgramResourceiv(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,int arg5,java.nio.IntBuffer arg6,java.nio.IntBuffer arg7)
  {
    printIndent();
    print(    "glGetProgramResourceiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg6+", "+"<java.nio.IntBuffer> "+arg7+")");
    downstreamGLES3.glGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glGetProgramiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetProgramiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetProgramiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetProgramiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetProgramiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetProgramiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetQueryObjecti64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjecti64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetQueryObjecti64v(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetQueryObjecti64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjecti64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
    downstreamGLES3.glGetQueryObjecti64v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetQueryObjectiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetQueryObjectiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetQueryObjectiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetQueryObjectiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetQueryObjectui64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectui64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.LongBuffer> "+arg2+")");
    downstreamGLES3.glGetQueryObjectui64v(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetQueryObjectui64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectui64v("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[J>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetQueryObjectui64v(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetQueryObjectuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryObjectuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetQueryObjectuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetQueryObjectuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryObjectuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetQueryObjectuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetQueryiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetQueryiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetQueryiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetQueryiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetQueryiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetQueryiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetSamplerParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetSamplerParameterIiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetSamplerParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glGetSamplerParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetSamplerParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetSamplerParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetSamplerParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetShaderInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetShaderInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetShaderInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderInfoLog("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetShaderInfoLog(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetShaderPrecisionFormat(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderPrecisionFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderPrecisionFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetShaderSource(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetShaderSource(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetShaderSource(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetShaderSource(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetShaderiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetShaderiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetShaderiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetShaderiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetShaderiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetShaderiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public java.lang.String glGetString(int arg0)
  {
    printIndent();
    print(    "glGetString("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    java.lang.String _res = downstreamGLES3.glGetString(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public java.lang.String glGetStringi(int arg0,int arg1)
  {
    printIndent();
    print(    "glGetStringi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.lang.String _res = downstreamGLES3.glGetStringi(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetSynciv(long arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glGetSynciv("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+")");
    downstreamGLES3.glGetSynciv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetSynciv(long arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
    printIndent();
    print(    "glGetSynciv("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glGetSynciv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetTexLevelParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTexLevelParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetTexLevelParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetTexLevelParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetTexParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetTexParameterIiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetTexParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetTexParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glGetTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    printIndent();
    print(    "glGetTransformFeedbackVarying("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg10).toUpperCase()+")");
    downstreamGLES3.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    printIndent();
    print(    "glGetTransformFeedbackVarying("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+", "+"<java.nio.IntBuffer> "+arg4+", "+"<java.nio.IntBuffer> "+arg5+", "+"<java.nio.ByteBuffer> "+arg6+")");
    downstreamGLES3.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glGetTranslatedShaderSourceANGLE(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetTranslatedShaderSourceANGLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glGetTranslatedShaderSourceANGLE(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetTranslatedShaderSourceANGLE(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetTranslatedShaderSourceANGLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glGetTranslatedShaderSourceANGLE(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public int glGetUniformBlockIndex(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformBlockIndex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGLES3.glGetUniformBlockIndex(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetUniformIndices("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetUniformIndices(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetUniformIndices("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetUniformIndices(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public int glGetUniformLocation(int arg0,java.lang.String arg1)
  {
    printIndent();
    print(    "glGetUniformLocation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.lang.String> "+arg1+")");
    int _res = downstreamGLES3.glGetUniformLocation(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetUniformfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glGetUniformfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetUniformiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetUniformiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetUniformuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetUniformuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetUniformuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetVertexAttribIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetVertexAttribIiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetVertexAttribIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetVertexAttribIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetVertexAttribIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetVertexAttribIuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetVertexAttribIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetVertexAttribIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetVertexAttribfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glGetVertexAttribfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetVertexAttribfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetVertexAttribfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetVertexAttribiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetVertexAttribiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glGetVertexAttribiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetVertexAttribiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetVertexAttribiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glGetVertexAttribiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glGetnUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetnUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetnUniformuiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glGetnUniformuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetnUniformuiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glGetnUniformuiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glHint(int arg0,int arg1)
  {
    printIndent();
    print(    "glHint("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glHint(arg0,arg1);
    println("");
  }
  @Override
  public void glInvalidateFramebuffer(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glInvalidateFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glInvalidateFramebuffer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glInvalidateFramebuffer(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glInvalidateFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glInvalidateFramebuffer(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glInvalidateSubFramebuffer(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glInvalidateSubFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glInvalidateSubFramebuffer(int arg0,int arg1,int[] arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glInvalidateSubFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public boolean glIsBuffer(int arg0)
  {
    printIndent();
    print(    "glIsBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsEnabled(int arg0)
  {
    printIndent();
    print(    "glIsEnabled("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsEnabled(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsEnabledi(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnabledi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsEnabledi(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsEnablediEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnablediEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsEnablediEXT(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsEnablediNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnablediNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsEnablediNV(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsEnablediOES(int arg0,int arg1)
  {
    printIndent();
    print(    "glIsEnablediOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsEnablediOES(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsFramebuffer(int arg0)
  {
    printIndent();
    print(    "glIsFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsFramebuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsProgram(int arg0)
  {
    printIndent();
    print(    "glIsProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsProgram(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glIsProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsProgramPipeline(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsQuery(int arg0)
  {
    printIndent();
    print(    "glIsQuery("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsQuery(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsRenderbuffer(int arg0)
  {
    printIndent();
    print(    "glIsRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsRenderbuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsSampler(int arg0)
  {
    printIndent();
    print(    "glIsSampler("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsSampler(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsShader(int arg0)
  {
    printIndent();
    print(    "glIsShader("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsShader(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsSync(long arg0)
  {
    printIndent();
    print(    "glIsSync("+"<long> "+arg0+")");
    boolean _res = downstreamGLES3.glIsSync(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsTexture(int arg0)
  {
    printIndent();
    print(    "glIsTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsTexture(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsTransformFeedback(int arg0)
  {
    printIndent();
    print(    "glIsTransformFeedback("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsTransformFeedback(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsVertexArray(int arg0)
  {
    printIndent();
    print(    "glIsVertexArray("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsVertexArray(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsVertexArrayOES(int arg0)
  {
    printIndent();
    print(    "glIsVertexArrayOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glIsVertexArrayOES(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glLineWidth(float arg0)
  {
    printIndent();
    print(    "glLineWidth("+"<float> "+arg0+")");
    downstreamGLES3.glLineWidth(arg0);
    println("");
  }
  @Override
  public void glLinkProgram(int arg0)
  {
    printIndent();
    print(    "glLinkProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glLinkProgram(arg0);
    println("");
  }
  @Override
  public java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glMapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGLES3.glMapBuffer(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "glMapBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGLES3.glMapBufferRange(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glMemoryBarrier(int arg0)
  {
    printIndent();
    print(    "glMemoryBarrier("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glMemoryBarrier(arg0);
    println("");
  }
  @Override
  public void glMemoryBarrierByRegion(int arg0)
  {
    printIndent();
    print(    "glMemoryBarrierByRegion("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glMemoryBarrierByRegion(arg0);
    println("");
  }
  @Override
  public void glMinSampleShading(float arg0)
  {
    printIndent();
    print(    "glMinSampleShading("+"<float> "+arg0+")");
    downstreamGLES3.glMinSampleShading(arg0);
    println("");
  }
  @Override
  public void glMinSampleShadingOES(float arg0)
  {
    printIndent();
    print(    "glMinSampleShadingOES("+"<float> "+arg0+")");
    downstreamGLES3.glMinSampleShadingOES(arg0);
    println("");
  }
  @Override
  public void glMultiDrawArraysIndirectEXT(int arg0,java.nio.Buffer arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glMultiDrawArraysIndirectEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.Buffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glMultiDrawArraysIndirectEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glMultiDrawElementsBaseVertexEXT(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4,java.nio.IntBuffer arg5)
  {
    printIndent();
    print(    "glMultiDrawElementsBaseVertexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg5+")");
    downstreamGLES3.glMultiDrawElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glMultiDrawElementsBaseVertexEXT(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5,int[] arg6,int arg7)
  {
    printIndent();
    print(    "glMultiDrawElementsBaseVertexEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glMultiDrawElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glMultiDrawElementsBaseVertexOES(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5,int[] arg6,int arg7)
  {
    printIndent();
    print(    "glMultiDrawElementsBaseVertexOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glMultiDrawElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glMultiDrawElementsBaseVertexOES(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4,java.nio.IntBuffer arg5)
  {
    printIndent();
    print(    "glMultiDrawElementsBaseVertexOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg5+")");
    downstreamGLES3.glMultiDrawElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glMultiDrawElementsIndirectEXT(int arg0,int arg1,java.nio.Buffer arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glMultiDrawElementsIndirectEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glMultiDrawElementsIndirectEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glNamedFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glNamedFramebufferSampleLocationsfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glNamedFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glNamedFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glNamedFramebufferSampleLocationsfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glNamedFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glObjectLabel(int arg0,int arg1,int arg2,byte[] arg3,int arg4)
  {
    printIndent();
    print(    "glObjectLabel("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glObjectLabel(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glObjectLabel(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glObjectLabel("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glObjectLabel(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glObjectPtrLabel(java.nio.Buffer arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    printIndent();
    print(    "glObjectPtrLabel("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+")");
    downstreamGLES3.glObjectPtrLabel(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glObjectPtrLabel(java.nio.Buffer arg0,int arg1,byte[] arg2,int arg3)
  {
    printIndent();
    print(    "glObjectPtrLabel("+"<java.nio.Buffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glObjectPtrLabel(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glPatchParameteri(int arg0,int arg1)
  {
    printIndent();
    print(    "glPatchParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glPatchParameteri(arg0,arg1);
    println("");
  }
  @Override
  public void glPatchParameteriEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glPatchParameteriEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glPatchParameteriEXT(arg0,arg1);
    println("");
  }
  @Override
  public void glPatchParameteriOES(int arg0,int arg1)
  {
    printIndent();
    print(    "glPatchParameteriOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glPatchParameteriOES(arg0,arg1);
    println("");
  }
  @Override
  public void glPauseTransformFeedback()
  {
    printIndent();
    print(    "glPauseTransformFeedback("+")");
    downstreamGLES3.glPauseTransformFeedback();
    println("");
  }
  @Override
  public void glPixelStorei(int arg0,int arg1)
  {
    printIndent();
    print(    "glPixelStorei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glPixelStorei(arg0,arg1);
    println("");
  }
  @Override
  public void glPolygonModeNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glPolygonModeNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glPolygonModeNV(arg0,arg1);
    println("");
  }
  @Override
  public void glPolygonOffset(float arg0,float arg1)
  {
    printIndent();
    print(    "glPolygonOffset("+"<float> "+arg0+", "+"<float> "+arg1+")");
    downstreamGLES3.glPolygonOffset(arg0,arg1);
    println("");
  }
  @Override
  public void glPopDebugGroup()
  {
    printIndent();
    print(    "glPopDebugGroup("+")");
    downstreamGLES3.glPopDebugGroup();
    println("");
  }
  @Override
  public void glPrimitiveBoundingBox(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7)
  {
    printIndent();
    print(    "glPrimitiveBoundingBox("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<float> "+arg6+", "+"<float> "+arg7+")");
    downstreamGLES3.glPrimitiveBoundingBox(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glPrimitiveBoundingBoxEXT(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7)
  {
    printIndent();
    print(    "glPrimitiveBoundingBoxEXT("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<float> "+arg6+", "+"<float> "+arg7+")");
    downstreamGLES3.glPrimitiveBoundingBoxEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glPrimitiveBoundingBoxOES(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7)
  {
    printIndent();
    print(    "glPrimitiveBoundingBoxOES("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+", "+"<float> "+arg6+", "+"<float> "+arg7+")");
    downstreamGLES3.glPrimitiveBoundingBoxOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glProgramBinary(int arg0,int arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glProgramBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glProgramBinary(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glProgramParameteri(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glProgramUniform1f(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glProgramUniform1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES3.glProgramUniform1f(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glProgramUniform1fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform1fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform1fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform1fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform1i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glProgramUniform1i(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glProgramUniform1iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform1iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform1iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform1iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform1ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glProgramUniform1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glProgramUniform1ui(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glProgramUniform1uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform1uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform1uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform2f(int arg0,int arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glProgramUniform2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES3.glProgramUniform2f(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform2fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform2fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform2i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glProgramUniform2i(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform2iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform2iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform2iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform2iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform2ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glProgramUniform2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glProgramUniform2ui(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform2uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform2uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform2uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform3f(int arg0,int arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glProgramUniform3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
    downstreamGLES3.glProgramUniform3f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform3fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform3fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform3i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform3i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform3iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform3iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform3iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform3iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform3ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform3ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform3uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform3uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform3uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform4f(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glProgramUniform4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
    downstreamGLES3.glProgramUniform4f(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniform4fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform4fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniform4i(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniform4iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform4iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform4iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform4iv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniform4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniform4ui(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniform4uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glProgramUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glProgramUniform4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glProgramUniform4uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glProgramUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glProgramUniform4uiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    printIndent();
    print(    "glProgramUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<java.nio.FloatBuffer> "+arg4+")");
    downstreamGLES3.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glPushDebugGroup(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glPushDebugGroup("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES3.glPushDebugGroup(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glPushDebugGroup(int arg0,int arg1,int arg2,byte[] arg3,int arg4)
  {
    printIndent();
    print(    "glPushDebugGroup("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glPushDebugGroup(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glQueryCounter(int arg0,int arg1)
  {
    printIndent();
    print(    "glQueryCounter("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glQueryCounter(arg0,arg1);
    println("");
  }
  @Override
  public void glRasterSamplesEXT(int arg0,boolean arg1)
  {
    printIndent();
    print(    "glRasterSamplesEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+")");
    downstreamGLES3.glRasterSamplesEXT(arg0,arg1);
    println("");
  }
  @Override
  public void glReadBuffer(int arg0)
  {
    printIndent();
    print(    "glReadBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glReadBuffer(arg0);
    println("");
  }
  @Override
  public void glReadBufferIndexedEXT(int arg0,int arg1)
  {
    printIndent();
    print(    "glReadBufferIndexedEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glReadBufferIndexedEXT(arg0,arg1);
    println("");
  }
  @Override
  public void glReadBufferNV(int arg0)
  {
    printIndent();
    print(    "glReadBufferNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glReadBufferNV(arg0);
    println("");
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
    downstreamGLES3.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
    downstreamGLES3.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glReadnPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
    downstreamGLES3.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glReleaseShaderCompiler()
  {
    printIndent();
    print(    "glReleaseShaderCompiler("+")");
    downstreamGLES3.glReleaseShaderCompiler();
    println("");
  }
  @Override
  public void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRenderbufferStorage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisampleEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glRenderbufferStorageMultisampleEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisampleIMG(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisampleIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glRenderbufferStorageMultisampleIMG(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisampleNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glRenderbufferStorageMultisampleNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glResolveDepthValuesNV()
  {
    printIndent();
    print(    "glResolveDepthValuesNV("+")");
    downstreamGLES3.glResolveDepthValuesNV();
    println("");
  }
  @Override
  public void glResolveMultisampleFramebuffer()
  {
    printIndent();
    print(    "glResolveMultisampleFramebuffer("+")");
    downstreamGLES3.glResolveMultisampleFramebuffer();
    println("");
  }
  @Override
  public void glResumeTransformFeedback()
  {
    printIndent();
    print(    "glResumeTransformFeedback("+")");
    downstreamGLES3.glResumeTransformFeedback();
    println("");
  }
  @Override
  public void glSampleCoverage(float arg0,boolean arg1)
  {
    printIndent();
    print(    "glSampleCoverage("+"<float> "+arg0+", "+"<boolean> "+arg1+")");
    downstreamGLES3.glSampleCoverage(arg0,arg1);
    println("");
  }
  @Override
  public void glSampleMaski(int arg0,int arg1)
  {
    printIndent();
    print(    "glSampleMaski("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glSampleMaski(arg0,arg1);
    println("");
  }
  @Override
  public void glSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glSamplerParameterIiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glSamplerParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glSamplerParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glSamplerParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glSamplerParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES3.glSamplerParameterf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glSamplerParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glSamplerParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glSamplerParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glSamplerParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glSamplerParameteri(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glSamplerParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glSamplerParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glSamplerParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glScissor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glScissor(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glScissorArrayvNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glScissorArrayvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glScissorArrayvNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glScissorArrayvNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glScissorArrayvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glScissorArrayvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glScissorIndexedNV(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glScissorIndexedNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glScissorIndexedNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glScissorIndexedvNV(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glScissorIndexedvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glScissorIndexedvNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glScissorIndexedvNV(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glScissorIndexedvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glScissorIndexedvNV(arg0,arg1);
    println("");
  }
  @Override
  public void glShaderBinary(int arg0,int[] arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5)
  {
    printIndent();
    print(    "glShaderBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glShaderBinary(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glShaderBinary(int arg0,java.nio.IntBuffer arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    printIndent();
    print(    "glShaderBinary("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glShaderBinary(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES3.glShaderSource(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glShaderSource("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glShaderSource(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glStartTilingQCOM(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glStartTilingQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glStartTilingQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glStencilFunc(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glStencilFunc(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glStencilFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glStencilFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glStencilFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glStencilMask(int arg0)
  {
    printIndent();
    print(    "glStencilMask("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glStencilMask(arg0);
    println("");
  }
  @Override
  public void glStencilMaskSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glStencilMaskSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glStencilMaskSeparate(arg0,arg1);
    println("");
  }
  @Override
  public void glStencilOp(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glStencilOp(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glStencilOpSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glStencilOpSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glStencilOpSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glSubpixelPrecisionBiasNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glSubpixelPrecisionBiasNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glSubpixelPrecisionBiasNV(arg0,arg1);
    println("");
  }
  @Override
  public void glTexBuffer(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glTexBuffer(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexBufferEXT(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexBufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glTexBufferEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexBufferOES(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexBufferOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glTexBufferOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glTexBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
    downstreamGLES3.glTexBufferRange(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTexBufferRangeEXT(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glTexBufferRangeEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
    downstreamGLES3.glTexBufferRangeEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTexBufferRangeOES(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    printIndent();
    print(    "glTexBufferRangeOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+", "+"<long> "+arg4+")");
    downstreamGLES3.glTexBufferRangeOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES3.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES3.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexImage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
    printIndent();
    print(    "glTexImage2DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+")");
    downstreamGLES3.glTexImage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    printIndent();
    print(    "glTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<java.nio.Buffer> "+arg9+")");
    downstreamGLES3.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  @Override
  public void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9)
  {
    printIndent();
    print(    "glTexImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<long> "+arg9+")");
    downstreamGLES3.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    println("");
  }
  @Override
  public void glTexImage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexImage3DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
    downstreamGLES3.glTexImage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glTexPageCommitmentEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,boolean arg8)
  {
    printIndent();
    print(    "glTexPageCommitmentEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<boolean> "+arg8+")");
    downstreamGLES3.glTexPageCommitmentEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glTexParameterIiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterIiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glTexParameterIiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glTexParameterIuiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterIuiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glTexParameterIuiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES3.glTexParameterf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glTexParameteri(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTexStorage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glTexStorage1D(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTexStorage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTexStorage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
    printIndent();
    print(    "glTexStorage2DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<boolean> "+arg5+")");
    downstreamGLES3.glTexStorage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTexStorage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glTexStorage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexStorage3DMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
    downstreamGLES3.glTexStorage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glTexStorage3DMultisampleOES(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    printIndent();
    print(    "glTexStorage3DMultisampleOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<boolean> "+arg6+")");
    downstreamGLES3.glTexStorage3DMultisampleOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES3.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES3.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
    downstreamGLES3.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    printIndent();
    print(    "glTexSubImage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<long> "+arg10+")");
    downstreamGLES3.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTextureStorage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTextureStorage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES3.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glTextureStorage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES3.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glTextureView(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glTextureView("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES3.glTextureView(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glTransformFeedbackVaryings(int arg0,int arg1,java.lang.String[] arg2,int arg3)
  {
    printIndent();
    print(    "glTransformFeedbackVaryings("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[Ljava.lang.String;>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glTransformFeedbackVaryings(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform(com.jogamp.opengl.GLUniformData arg0)
  {
    printIndent();
    print(    "glUniform("+"<com.jogamp.opengl.GLUniformData> "+arg0+")");
    downstreamGLES3.glUniform(arg0);
    println("");
  }
  @Override
  public void glUniform1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glUniform1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES3.glUniform1f(arg0,arg1);
    println("");
  }
  @Override
  public void glUniform1fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform1fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform1fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glUniform1fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform1i(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glUniform1i(arg0,arg1);
    println("");
  }
  @Override
  public void glUniform1iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform1iv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform1iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform1iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform1ui(int arg0,int arg1)
  {
    printIndent();
    print(    "glUniform1ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glUniform1ui(arg0,arg1);
    println("");
  }
  @Override
  public void glUniform1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform1uiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform1uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform1uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glUniform2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
    downstreamGLES3.glUniform2f(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform2fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glUniform2fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform2fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform2i(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glUniform2i(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform2iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform2iv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform2iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform2iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform2ui(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniform2ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glUniform2ui(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform2uiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform2uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform2uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glUniform3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES3.glUniform3f(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform3fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform3fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glUniform3fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform3i(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform3i(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform3iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform3iv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform3iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform3iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform3ui(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform3ui(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform3uiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform3uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform3uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glUniform4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
    downstreamGLES3.glUniform4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniform4fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glUniform4fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform4fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniform4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniform4iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform4iv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform4iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform4iv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glUniform4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniform4ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniform4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES3.glUniform4uiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniform4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glUniform4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glUniform4uiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformBlockBinding(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUniformBlockBinding("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glUniformBlockBinding(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix2x3fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x3fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix2x3fvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix2x3fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x3fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix2x3fvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix2x4fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix2x4fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix2x4fvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix2x4fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix2x4fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix2x4fvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix3x2fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x2fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix3x2fvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix3x2fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x2fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix3x2fvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix3x4fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix3x4fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix3x4fvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix3x4fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix3x4fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix3x4fvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix4fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix4x2fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x2fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix4x2fvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix4x2fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x2fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix4x2fvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glUniformMatrix4x3fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glUniformMatrix4x3fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glUniformMatrix4x3fvNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glUniformMatrix4x3fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glUniformMatrix4x3fvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<boolean> "+arg2+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES3.glUniformMatrix4x3fvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public boolean glUnmapBuffer(int arg0)
  {
    printIndent();
    print(    "glUnmapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES3.glUnmapBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glUseProgram(int arg0)
  {
    printIndent();
    print(    "glUseProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glUseProgram(arg0);
    println("");
  }
  @Override
  public void glUseProgramStages(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glUseProgramStages("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glUseProgramStages(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glValidateProgram(int arg0)
  {
    printIndent();
    print(    "glValidateProgram("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glValidateProgram(arg0);
    println("");
  }
  @Override
  public void glValidateProgramPipeline(int arg0)
  {
    printIndent();
    print(    "glValidateProgramPipeline("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES3.glValidateProgramPipeline(arg0);
    println("");
  }
  @Override
  public void glVertexAttrib1f(int arg0,float arg1)
  {
    printIndent();
    print(    "glVertexAttrib1f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES3.glVertexAttrib1f(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttrib1fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glVertexAttrib1fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttrib1fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib1fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glVertexAttrib1fv(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttrib2f(int arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glVertexAttrib2f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
    downstreamGLES3.glVertexAttrib2f(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttrib2fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glVertexAttrib2fv(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttrib2fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib2fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glVertexAttrib2fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttrib3f(int arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glVertexAttrib3f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES3.glVertexAttrib3f(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glVertexAttrib3fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glVertexAttrib3fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttrib3fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib3fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glVertexAttrib3fv(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttrib4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glVertexAttrib4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
    downstreamGLES3.glVertexAttrib4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glVertexAttrib4fv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttrib4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glVertexAttrib4fv(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttrib4fv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttrib4fv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glVertexAttrib4fv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttribBinding(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribBinding("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glVertexAttribBinding(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttribDivisor(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribDivisor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glVertexAttribDivisor(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttribDivisorANGLE(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribDivisorANGLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glVertexAttribDivisorANGLE(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttribDivisorNV(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexAttribDivisorNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glVertexAttribDivisorNV(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttribFormat(int arg0,int arg1,int arg2,boolean arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glVertexAttribFormat(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glVertexAttribI4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4i("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glVertexAttribI4i(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glVertexAttribI4iv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glVertexAttribI4iv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttribI4iv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4iv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glVertexAttribI4iv(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttribI4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glVertexAttribI4ui("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES3.glVertexAttribI4ui(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glVertexAttribI4uiv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glVertexAttribI4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glVertexAttribI4uiv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glVertexAttribI4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glVertexAttribI4uiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES3.glVertexAttribI4uiv(arg0,arg1);
    println("");
  }
  @Override
  public void glVertexAttribIFormat(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glVertexAttribIFormat("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glVertexAttribIFormat(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<long> "+arg4+")");
    downstreamGLES3.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    printIndent();
    print(    "glVertexAttribIPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.Buffer> "+arg4+")");
    downstreamGLES3.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.Buffer arg5)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<java.nio.Buffer> "+arg5+")");
    downstreamGLES3.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<boolean> "+arg3+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<long> "+arg5+")");
    downstreamGLES3.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glVertexAttribPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glVertexAttribPointer("+"<com.jogamp.opengl.GLArrayData> "+arg0+")");
    downstreamGLES3.glVertexAttribPointer(arg0);
    println("");
  }
  @Override
  public void glVertexBindingDivisor(int arg0,int arg1)
  {
    printIndent();
    print(    "glVertexBindingDivisor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES3.glVertexBindingDivisor(arg0,arg1);
    println("");
  }
  @Override
  public void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glViewport("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glViewport(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glViewportArrayvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glViewportArrayvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES3.glViewportArrayvNV(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glViewportArrayvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glViewportArrayvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES3.glViewportArrayvNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glViewportIndexedfNV(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glViewportIndexedfNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
    downstreamGLES3.glViewportIndexedfNV(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glViewportIndexedfvNV(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glViewportIndexedfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES3.glViewportIndexedfvNV(arg0,arg1);
    println("");
  }
  @Override
  public void glViewportIndexedfvNV(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glViewportIndexedfvNV("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES3.glViewportIndexedfvNV(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glWaitSync(long arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glWaitSync("+"<long> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
    downstreamGLES3.glWaitSync(arg0,arg1,arg2);
    println("");
  }
  @Override
  public boolean hasBasicFBOSupport()
  {
    return downstreamGLES3.hasBasicFBOSupport();
  }
  @Override
  public boolean hasFullFBOSupport()
  {
    return downstreamGLES3.hasFullFBOSupport();
  }
  @Override
  public boolean hasGLSL()
  {
    return downstreamGLES3.hasGLSL();
  }
  @Override
  public boolean isExtensionAvailable(java.lang.String arg0)
  {
    return downstreamGLES3.isExtensionAvailable(arg0);
  }
  @Override
  public boolean isFunctionAvailable(java.lang.String arg0)
  {
    return downstreamGLES3.isFunctionAvailable(arg0);
  }
  @Override
  public boolean isGL()
  {
    return true;
  }
  @Override
  public boolean isGL2()
  {
    return downstreamGLES3.isGL2();
  }
  @Override
  public boolean isGL2ES1()
  {
    return downstreamGLES3.isGL2ES1();
  }
  @Override
  public boolean isGL2ES2()
  {
    return downstreamGLES3.isGL2ES2();
  }
  @Override
  public boolean isGL2ES3()
  {
    return downstreamGLES3.isGL2ES3();
  }
  @Override
  public boolean isGL2GL3()
  {
    return downstreamGLES3.isGL2GL3();
  }
  @Override
  public boolean isGL3()
  {
    return downstreamGLES3.isGL3();
  }
  @Override
  public boolean isGL3ES3()
  {
    return downstreamGLES3.isGL3ES3();
  }
  @Override
  public boolean isGL3bc()
  {
    return downstreamGLES3.isGL3bc();
  }
  @Override
  public boolean isGL3core()
  {
    return downstreamGLES3.isGL3core();
  }
  @Override
  public boolean isGL4()
  {
    return downstreamGLES3.isGL4();
  }
  @Override
  public boolean isGL4ES3()
  {
    return downstreamGLES3.isGL4ES3();
  }
  @Override
  public boolean isGL4bc()
  {
    return downstreamGLES3.isGL4bc();
  }
  @Override
  public boolean isGL4core()
  {
    return downstreamGLES3.isGL4core();
  }
  @Override
  public boolean isGLES()
  {
    return downstreamGLES3.isGLES();
  }
  @Override
  public boolean isGLES1()
  {
    return downstreamGLES3.isGLES1();
  }
  @Override
  public boolean isGLES2()
  {
    return downstreamGLES3.isGLES2();
  }
  @Override
  public boolean isGLES2Compatible()
  {
    return downstreamGLES3.isGLES2Compatible();
  }
  @Override
  public boolean isGLES3()
  {
    return downstreamGLES3.isGLES3();
  }
  @Override
  public boolean isGLES31Compatible()
  {
    return downstreamGLES3.isGLES31Compatible();
  }
  @Override
  public boolean isGLES32Compatible()
  {
    return downstreamGLES3.isGLES32Compatible();
  }
  @Override
  public boolean isGLES3Compatible()
  {
    return downstreamGLES3.isGLES3Compatible();
  }
  @Override
  public boolean isGLcore()
  {
    return downstreamGLES3.isGLcore();
  }
  @Override
  public boolean isNPOTTextureAvailable()
  {
    return downstreamGLES3.isNPOTTextureAvailable();
  }
  @Override
  public boolean isPBOPackBound()
  {
    return downstreamGLES3.isPBOPackBound();
  }
  @Override
  public boolean isPBOUnpackBound()
  {
    return downstreamGLES3.isPBOUnpackBound();
  }
  @Override
  public boolean isTextureFormatBGRA8888Available()
  {
    return downstreamGLES3.isTextureFormatBGRA8888Available();
  }
  @Override
  public boolean isVBOArrayBound()
  {
    return downstreamGLES3.isVBOArrayBound();
  }
  @Override
  public boolean isVBOElementArrayBound()
  {
    return downstreamGLES3.isVBOElementArrayBound();
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "mapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES3.mapBuffer(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "mapBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES3.mapBufferRange(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void setSwapInterval(int arg0)
  {
    downstreamGLES3.setSwapInterval(arg0);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("TraceGLES3 [this 0x"+Integer.toHexString(hashCode())+" implementing com.jogamp.opengl.GLES3,\n\t");
    sb.append(" downstream: "+downstreamGLES3.toString()+"\n\t]");
    return sb.toString();
  }
private PrintStream stream;
private int indent = 0;
protected String dumpArray(Object obj)
{
  if (obj == null) return "[null]";
  StringBuilder sb = new StringBuilder("[");
  int len  = java.lang.reflect.Array.getLength(obj);
  int count = Math.min(len,16);
  for ( int i =0; i < count; i++ ) {
    sb.append(java.lang.reflect.Array.get(obj,i));
    if (i < count-1)
      sb.append(',');
  }
  if ( len > 16 )
    sb.append("...").append(len);
  sb.append(']');
  return sb.toString();
}
protected void print(String str)
{
  stream.print(str);
}
protected void println(String str)
{
  stream.println(str);
}
protected void printIndent()
{
  for( int i =0; i < indent; i++) {stream.print(' ');}
}

  private GLES3 downstreamGLES3;
} // end class TraceGLES3
