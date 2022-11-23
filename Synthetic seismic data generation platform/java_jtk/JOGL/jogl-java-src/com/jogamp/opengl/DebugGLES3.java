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
 * providing error checking after each OpenGL method call. If an error occurs,
 * causes a {@link GLException} to be thrown at exactly the point of failure.
 * </p>
 * <p>
 * Sample code which installs this pipeline:
 * <pre>
 *   gl = drawable.setGL(new DebugGL(drawable.getGL()));
 * </pre>
 * For automatic instantiation see {@link GLPipelineFactory#create(String, Class, GL, Object[])}
 * </p>
 */
public class DebugGLES3 implements com.jogamp.opengl.GLES2, com.jogamp.opengl.GL4ES3, com.jogamp.opengl.GLES3{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("DebugGLES3");
  public DebugGLES3(GLES3 downstreamGLES3)
  {
    if (downstreamGLES3 == null) {
      throw new IllegalArgumentException("null downstreamGLES3");
    }
    this.downstreamGLES3 = downstreamGLES3;
    // Fetch GLContext object for better error checking (if possible)
    _context = downstreamGLES3.getContext();
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
    checkContext();
    downstreamGLES3.glActiveShaderProgram(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glActiveShaderProgram", arg0, arg1);
    }
  }
  @Override
  public void glActiveTexture(int arg0)
  {
    checkContext();
    downstreamGLES3.glActiveTexture(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glActiveTexture", arg0);
    }
  }
  @Override
  public void glAlphaFuncQCOM(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES3.glAlphaFuncQCOM(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glAlphaFuncQCOM", arg0, arg1);
    }
  }
  @Override
  public void glApplyFramebufferAttachmentCMAAINTEL()
  {
    checkContext();
    downstreamGLES3.glApplyFramebufferAttachmentCMAAINTEL();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glApplyFramebufferAttachmentCMAAINTEL");
    }
  }
  @Override
  public void glAttachShader(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glAttachShader(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glAttachShader", arg0, arg1);
    }
  }
  @Override
  public void glBeginConditionalRender(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBeginConditionalRender(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBeginConditionalRender", arg0, arg1);
    }
  }
  @Override
  public void glBeginQuery(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBeginQuery(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBeginQuery", arg0, arg1);
    }
  }
  @Override
  public void glBeginTransformFeedback(int arg0)
  {
    checkContext();
    downstreamGLES3.glBeginTransformFeedback(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glBeginTransformFeedback", arg0);
    }
  }
  @Override
  public void glBindAttribLocation(int arg0,int arg1,java.lang.String arg2)
  {
    checkContext();
    downstreamGLES3.glBindAttribLocation(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.lang.String> %s)",
                   "glBindAttribLocation", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBindBuffer(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBindBuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindBuffer", arg0, arg1);
    }
  }
  @Override
  public void glBindBufferBase(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBindBufferBase(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBindBufferBase", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBindBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glBindBufferRange(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <long> %s)",
                   "glBindBufferRange", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glBindFragDataLocationEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glBindFragDataLocationEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glBindFragDataLocationEXT", arg0, arg1, arg3);
    }
  }
  @Override
  public void glBindFragDataLocationEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glBindFragDataLocationEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glBindFragDataLocationEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBindFragDataLocationIndexedEXT(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glBindFragDataLocationIndexedEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glBindFragDataLocationIndexedEXT", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBindFragDataLocationIndexedEXT(int arg0,int arg1,int arg2,byte[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glBindFragDataLocationIndexedEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glBindFragDataLocationIndexedEXT", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glBindFramebuffer(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBindFramebuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindFramebuffer", arg0, arg1);
    }
  }
  @Override
  public void glBindImageTexture(int arg0,int arg1,int arg2,boolean arg3,int arg4,int arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glBindImageTexture(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBindImageTexture", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glBindProgramPipeline(int arg0)
  {
    checkContext();
    downstreamGLES3.glBindProgramPipeline(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glBindProgramPipeline", arg0);
    }
  }
  @Override
  public void glBindRenderbuffer(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBindRenderbuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindRenderbuffer", arg0, arg1);
    }
  }
  @Override
  public void glBindSampler(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBindSampler(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindSampler", arg0, arg1);
    }
  }
  @Override
  public void glBindTexture(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBindTexture(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindTexture", arg0, arg1);
    }
  }
  @Override
  public void glBindTransformFeedback(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBindTransformFeedback(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindTransformFeedback", arg0, arg1);
    }
  }
  @Override
  public void glBindVertexArray(int arg0)
  {
    checkContext();
    downstreamGLES3.glBindVertexArray(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glBindVertexArray", arg0);
    }
  }
  @Override
  public void glBindVertexArrayOES(int arg0)
  {
    checkContext();
    downstreamGLES3.glBindVertexArrayOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glBindVertexArrayOES", arg0);
    }
  }
  @Override
  public void glBindVertexBuffer(int arg0,int arg1,long arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glBindVertexBuffer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X)",
                   "glBindVertexBuffer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBlendBarrier()
  {
    checkContext();
    downstreamGLES3.glBlendBarrier();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glBlendBarrier");
    }
  }
  @Override
  public void glBlendColor(float arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES3.glBlendColor(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s)",
                   "glBlendColor", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBlendEquation(int arg0)
  {
    checkContext();
    downstreamGLES3.glBlendEquation(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glBlendEquation", arg0);
    }
  }
  @Override
  public void glBlendEquationSeparate(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBlendEquationSeparate(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBlendEquationSeparate", arg0, arg1);
    }
  }
  @Override
  public void glBlendEquationSeparatei(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBlendEquationSeparatei(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendEquationSeparatei", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBlendEquationSeparateiEXT(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBlendEquationSeparateiEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendEquationSeparateiEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBlendEquationSeparateiOES(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBlendEquationSeparateiOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendEquationSeparateiOES", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBlendEquationi(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBlendEquationi(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBlendEquationi", arg0, arg1);
    }
  }
  @Override
  public void glBlendEquationiEXT(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBlendEquationiEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBlendEquationiEXT", arg0, arg1);
    }
  }
  @Override
  public void glBlendEquationiOES(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBlendEquationiOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBlendEquationiOES", arg0, arg1);
    }
  }
  @Override
  public void glBlendFunc(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glBlendFunc(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBlendFunc", arg0, arg1);
    }
  }
  @Override
  public void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFuncSeparate", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBlendFuncSeparatei(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glBlendFuncSeparatei(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFuncSeparatei", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glBlendFuncSeparateiEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glBlendFuncSeparateiEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFuncSeparateiEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glBlendFuncSeparateiOES(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glBlendFuncSeparateiOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFuncSeparateiOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glBlendFunci(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBlendFunci(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFunci", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBlendFunciEXT(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBlendFunciEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFunciEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBlendFunciOES(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glBlendFunciOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFunciOES", arg0, arg1, arg2);
    }
  }
  @Override
  public void glBlitFramebuffer(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    checkContext();
    downstreamGLES3.glBlitFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlitFramebuffer", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
  }
  @Override
  public void glBlitFramebufferANGLE(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    checkContext();
    downstreamGLES3.glBlitFramebufferANGLE(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlitFramebufferANGLE", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
  }
  @Override
  public void glBlitFramebufferNV(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9)
  {
    checkContext();
    downstreamGLES3.glBlitFramebufferNV(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlitFramebufferNV", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
  }
  @Override
  public void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glBufferData(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glBufferData", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBufferStorageEXT(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glBufferStorageEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glBufferStorageEXT", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES3.glBufferSubData(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <long> %s, <java.nio.Buffer> %s)",
                   "glBufferSubData", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public int glCheckFramebufferStatus(int arg0)
  {
    checkContext();
    int _res = downstreamGLES3.glCheckFramebufferStatus(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCheckFramebufferStatus", arg0);
    }
    return _res;
  }
  @Override
  public void glClear(int arg0)
  {
    checkContext();
    downstreamGLES3.glClear(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glClear", arg0);
    }
  }
  @Override
  public void glClearBufferfi(int arg0,int arg1,float arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glClearBufferfi(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s, <int> 0x%X)",
                   "glClearBufferfi", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glClearBufferfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glClearBufferfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glClearBufferfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glClearBufferfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glClearBufferfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glClearBufferfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glClearBufferiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glClearBufferiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glClearBufferiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glClearBufferiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glClearBufferiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glClearBufferiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glClearBufferuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glClearBufferuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glClearBufferuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glClearBufferuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glClearBufferuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glClearBufferuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES3.glClearColor(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s)",
                   "glClearColor", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glClearDepth(double arg0)
  {
    checkContext();
    downstreamGLES3.glClearDepth(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<double> %s)",
                   "glClearDepth", arg0);
    }
  }
  @Override
  public void glClearDepthf(float arg0)
  {
    checkContext();
    downstreamGLES3.glClearDepthf(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glClearDepthf", arg0);
    }
  }
  @Override
  public void glClearStencil(int arg0)
  {
    checkContext();
    downstreamGLES3.glClearStencil(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glClearStencil", arg0);
    }
  }
  @Override
  public int glClientWaitSync(long arg0,int arg1,long arg2)
  {
    checkContext();
    int _res = downstreamGLES3.glClientWaitSync(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s, <int> 0x%X, <long> %s)",
                   "glClientWaitSync", arg0, arg1, arg2);
    }
    return _res;
  }
  @Override
  public void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    checkContext();
    downstreamGLES3.glColorMask(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<boolean> %s, <boolean> %s, <boolean> %s, <boolean> %s)",
                   "glColorMask", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glColorMaski(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    checkContext();
    downstreamGLES3.glColorMaski(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <boolean> %s, <boolean> %s, <boolean> %s, <boolean> %s)",
                   "glColorMaski", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glColorMaskiEXT(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    checkContext();
    downstreamGLES3.glColorMaskiEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <boolean> %s, <boolean> %s, <boolean> %s, <boolean> %s)",
                   "glColorMaskiEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glColorMaskiOES(int arg0,boolean arg1,boolean arg2,boolean arg3,boolean arg4)
  {
    checkContext();
    downstreamGLES3.glColorMaskiOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <boolean> %s, <boolean> %s, <boolean> %s, <boolean> %s)",
                   "glColorMaskiOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glCompileShader(int arg0)
  {
    checkContext();
    downstreamGLES3.glCompileShader(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCompileShader", arg0);
    }
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    checkContext();
    downstreamGLES3.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glCompressedTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    checkContext();
    downstreamGLES3.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glCompressedTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    checkContext();
    downstreamGLES3.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glCompressedTexImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glCompressedTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    checkContext();
    downstreamGLES3.glCompressedTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glCompressedTexImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    checkContext();
    downstreamGLES3.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glCompressedTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    checkContext();
    downstreamGLES3.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glCompressedTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    checkContext();
    downstreamGLES3.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glCompressedTexSubImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }
  }
  @Override
  public void glCompressedTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    checkContext();
    downstreamGLES3.glCompressedTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glCompressedTexSubImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }
  }
  @Override
  public void glCopyBufferSubData(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glCopyBufferSubData(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <long> %s, <long> %s, <long> %s)",
                   "glCopyBufferSubData", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glCopyBufferSubDataNV(int arg0,int arg1,long arg2,long arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glCopyBufferSubDataNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <long> %s, <long> %s, <long> %s)",
                   "glCopyBufferSubDataNV", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glCopyImageSubData(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,int arg10,int arg11,int arg12,int arg13,int arg14)
  {
    checkContext();
    downstreamGLES3.glCopyImageSubData(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13,arg14);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyImageSubData", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12, arg13, arg14);
    }
  }
  @Override
  public void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glCopyTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8)
  {
    checkContext();
    downstreamGLES3.glCopyTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyTexSubImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glCopyTextureLevelsAPPLE(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glCopyTextureLevelsAPPLE(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyTextureLevelsAPPLE", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glCoverageMaskNV(boolean arg0)
  {
    checkContext();
    downstreamGLES3.glCoverageMaskNV(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<boolean> %s)",
                   "glCoverageMaskNV", arg0);
    }
  }
  @Override
  public void glCoverageModulationNV(int arg0)
  {
    checkContext();
    downstreamGLES3.glCoverageModulationNV(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCoverageModulationNV", arg0);
    }
  }
  @Override
  public void glCoverageModulationTableNV(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glCoverageModulationTableNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glCoverageModulationTableNV", arg0, arg1);
    }
  }
  @Override
  public void glCoverageModulationTableNV(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glCoverageModulationTableNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glCoverageModulationTableNV", arg0, arg2);
    }
  }
  @Override
  public void glCoverageOperationNV(int arg0)
  {
    checkContext();
    downstreamGLES3.glCoverageOperationNV(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCoverageOperationNV", arg0);
    }
  }
  @Override
  public int glCreateProgram()
  {
    checkContext();
    int _res = downstreamGLES3.glCreateProgram();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glCreateProgram");
    }
    return _res;
  }
  @Override
  public int glCreateShader(int arg0)
  {
    checkContext();
    int _res = downstreamGLES3.glCreateShader(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCreateShader", arg0);
    }
    return _res;
  }
  @Override
  public int glCreateShaderProgramv(int arg0,int arg1,java.lang.String[] arg2)
  {
    checkContext();
    int _res = downstreamGLES3.glCreateShaderProgramv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[Ljava.lang.String;>)",
                   "glCreateShaderProgramv", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glCullFace(int arg0)
  {
    checkContext();
    downstreamGLES3.glCullFace(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCullFace", arg0);
    }
  }
  @Override
  public void glDebugMessageControl(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,boolean arg6)
  {
    checkContext();
    downstreamGLES3.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <boolean> %s)",
                   "glDebugMessageControl", arg0, arg1, arg2, arg3, arg5, arg6);
    }
  }
  @Override
  public void glDebugMessageControl(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,boolean arg5)
  {
    checkContext();
    downstreamGLES3.glDebugMessageControl(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <boolean> %s)",
                   "glDebugMessageControl", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDebugMessageInsert(int arg0,int arg1,int arg2,int arg3,int arg4,java.lang.String arg5)
  {
    checkContext();
    downstreamGLES3.glDebugMessageInsert(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.lang.String> %s)",
                   "glDebugMessageInsert", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteBuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteBuffers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteBuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteBuffers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteFramebuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteFramebuffers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteFramebuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteFramebuffers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteProgram(int arg0)
  {
    checkContext();
    downstreamGLES3.glDeleteProgram(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDeleteProgram", arg0);
    }
  }
  @Override
  public void glDeleteProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteProgramPipelines(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteProgramPipelines", arg0, arg1);
    }
  }
  @Override
  public void glDeleteProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteProgramPipelines(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteProgramPipelines", arg0, arg2);
    }
  }
  @Override
  public void glDeleteQueries(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteQueries(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteQueries", arg0, arg2);
    }
  }
  @Override
  public void glDeleteQueries(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteQueries(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteQueries", arg0, arg1);
    }
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteRenderbuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteRenderbuffers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteRenderbuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteRenderbuffers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteSamplers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteSamplers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteSamplers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteSamplers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteSamplers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteShader(int arg0)
  {
    checkContext();
    downstreamGLES3.glDeleteShader(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDeleteShader", arg0);
    }
  }
  @Override
  public void glDeleteSync(long arg0)
  {
    checkContext();
    downstreamGLES3.glDeleteSync(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s)",
                   "glDeleteSync", arg0);
    }
  }
  @Override
  public void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteTextures(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteTextures", arg0, arg2);
    }
  }
  @Override
  public void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteTextures(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteTextures", arg0, arg1);
    }
  }
  @Override
  public void glDeleteTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteTransformFeedbacks(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteTransformFeedbacks", arg0, arg2);
    }
  }
  @Override
  public void glDeleteTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteTransformFeedbacks(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteTransformFeedbacks", arg0, arg1);
    }
  }
  @Override
  public void glDeleteVertexArrays(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteVertexArrays(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteVertexArrays", arg0, arg2);
    }
  }
  @Override
  public void glDeleteVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteVertexArrays(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteVertexArrays", arg0, arg1);
    }
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDeleteVertexArraysOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteVertexArraysOES", arg0, arg1);
    }
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDeleteVertexArraysOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteVertexArraysOES", arg0, arg2);
    }
  }
  @Override
  public void glDepthFunc(int arg0)
  {
    checkContext();
    downstreamGLES3.glDepthFunc(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDepthFunc", arg0);
    }
  }
  @Override
  public void glDepthMask(boolean arg0)
  {
    checkContext();
    downstreamGLES3.glDepthMask(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<boolean> %s)",
                   "glDepthMask", arg0);
    }
  }
  @Override
  public void glDepthRange(double arg0,double arg1)
  {
    checkContext();
    downstreamGLES3.glDepthRange(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<double> %s, <double> %s)",
                   "glDepthRange", arg0, arg1);
    }
  }
  @Override
  public void glDepthRangeArrayfvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glDepthRangeArrayfvNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glDepthRangeArrayfvNV", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDepthRangeArrayfvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glDepthRangeArrayfvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glDepthRangeArrayfvNV", arg0, arg1, arg3);
    }
  }
  @Override
  public void glDepthRangeIndexedfNV(int arg0,float arg1,float arg2)
  {
    checkContext();
    downstreamGLES3.glDepthRangeIndexedfNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s)",
                   "glDepthRangeIndexedfNV", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDepthRangef(float arg0,float arg1)
  {
    checkContext();
    downstreamGLES3.glDepthRangef(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s)",
                   "glDepthRangef", arg0, arg1);
    }
  }
  @Override
  public void glDetachShader(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glDetachShader(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glDetachShader", arg0, arg1);
    }
  }
  @Override
  public void glDisable(int arg0)
  {
    checkContext();
    downstreamGLES3.glDisable(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDisable", arg0);
    }
  }
  @Override
  public void glDisableDriverControlQCOM(int arg0)
  {
    checkContext();
    downstreamGLES3.glDisableDriverControlQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDisableDriverControlQCOM", arg0);
    }
  }
  @Override
  public void glDisableVertexAttribArray(int arg0)
  {
    checkContext();
    downstreamGLES3.glDisableVertexAttribArray(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDisableVertexAttribArray", arg0);
    }
  }
  @Override
  public void glDisablei(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glDisablei(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glDisablei", arg0, arg1);
    }
  }
  @Override
  public void glDisableiEXT(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glDisableiEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glDisableiEXT", arg0, arg1);
    }
  }
  @Override
  public void glDisableiNV(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glDisableiNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glDisableiNV", arg0, arg1);
    }
  }
  @Override
  public void glDisableiOES(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glDisableiOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glDisableiOES", arg0, arg1);
    }
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glDiscardFramebufferEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDiscardFramebufferEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glDiscardFramebufferEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glDiscardFramebufferEXT", arg0, arg1, arg3);
    }
  }
  @Override
  public void glDispatchCompute(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDispatchCompute(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDispatchCompute", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDispatchComputeIndirect(long arg0)
  {
    checkContext();
    downstreamGLES3.glDispatchComputeIndirect(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s)",
                   "glDispatchComputeIndirect", arg0);
    }
  }
  @Override
  public void glDrawArrays(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDrawArrays(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawArrays", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDrawArraysIndirect(int arg0,long arg1)
  {
    checkContext();
    downstreamGLES3.glDrawArraysIndirect(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s)",
                   "glDrawArraysIndirect", arg0, arg1);
    }
  }
  @Override
  public void glDrawArraysIndirect(int arg0,java.nio.Buffer arg1)
  {
    checkContext();
    downstreamGLES3.glDrawArraysIndirect(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.Buffer> %s)",
                   "glDrawArraysIndirect", arg0, arg1);
    }
  }
  @Override
  public void glDrawArraysInstanced(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glDrawArraysInstanced(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawArraysInstanced", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glDrawArraysInstancedANGLE(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glDrawArraysInstancedANGLE(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawArraysInstancedANGLE", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glDrawArraysInstancedBaseInstance(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawArraysInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawArraysInstancedBaseInstance", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawArraysInstancedNV(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glDrawArraysInstancedNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawArraysInstancedNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glDrawBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glDrawBuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDrawBuffers", arg0, arg1);
    }
  }
  @Override
  public void glDrawBuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glDrawBuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDrawBuffers", arg0, arg2);
    }
  }
  @Override
  public void glDrawBuffersIndexedEXT(int arg0,int[] arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawBuffersIndexedEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glDrawBuffersIndexedEXT", arg0, arg2, arg4);
    }
  }
  @Override
  public void glDrawBuffersIndexedEXT(int arg0,java.nio.IntBuffer arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glDrawBuffersIndexedEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glDrawBuffersIndexedEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    checkContext();
    downstreamGLES3.glDrawElements(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glDrawElements", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES3.glDrawElements(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glDrawElements", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawElementsBaseVertex", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsBaseVertex(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X)",
                   "glDrawElementsBaseVertex", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsBaseVertexEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawElementsBaseVertexEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsBaseVertexOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawElementsBaseVertexOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsIndirect(int arg0,int arg1,java.nio.Buffer arg2)
  {
    checkContext();
    downstreamGLES3.glDrawElementsIndirect(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glDrawElementsIndirect", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDrawElementsIndirect(int arg0,int arg1,long arg2)
  {
    checkContext();
    downstreamGLES3.glDrawElementsIndirect(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <long> %s)",
                   "glDrawElementsIndirect", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDrawElementsInstanced(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawElementsInstanced", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsInstanced(int arg0,int arg1,int arg2,long arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstanced(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X)",
                   "glDrawElementsInstanced", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsInstancedANGLE(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedANGLE(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawElementsInstancedANGLE", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawElementsInstancedBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X, <int> 0x%X)",
                   "glDrawElementsInstancedBaseInstance", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X, <int> 0x%X)",
                   "glDrawElementsInstancedBaseVertex", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawElementsInstancedBaseVertex(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X, <int> 0x%X)",
                   "glDrawElementsInstancedBaseVertex", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawElementsInstancedBaseVertexBaseInstance(int arg0,int arg1,int arg2,long arg3,int arg4,int arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedBaseVertexBaseInstance(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawElementsInstancedBaseVertexBaseInstance", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glDrawElementsInstancedBaseVertexEXT(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X, <int> 0x%X)",
                   "glDrawElementsInstancedBaseVertexEXT", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawElementsInstancedBaseVertexOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X, <int> 0x%X)",
                   "glDrawElementsInstancedBaseVertexOES", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawElementsInstancedNV(int arg0,int arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glDrawElementsInstancedNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawElementsInstancedNV", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5)
  {
    checkContext();
    downstreamGLES3.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glDrawRangeElements", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawRangeElements(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5)
  {
    checkContext();
    downstreamGLES3.glDrawRangeElements(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glDrawRangeElements", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,long arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <int> 0x%X)",
                   "glDrawRangeElementsBaseVertex", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glDrawRangeElementsBaseVertex(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glDrawRangeElementsBaseVertex(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawRangeElementsBaseVertex", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glDrawRangeElementsBaseVertexEXT(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glDrawRangeElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawRangeElementsBaseVertexEXT", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glDrawRangeElementsBaseVertexOES(int arg0,int arg1,int arg2,int arg3,int arg4,java.nio.Buffer arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glDrawRangeElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glDrawRangeElementsBaseVertexOES", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glEGLImageTargetRenderbufferStorageOES(int arg0,long arg1)
  {
    checkContext();
    downstreamGLES3.glEGLImageTargetRenderbufferStorageOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s)",
                   "glEGLImageTargetRenderbufferStorageOES", arg0, arg1);
    }
  }
  @Override
  public void glEGLImageTargetTexture2DOES(int arg0,long arg1)
  {
    checkContext();
    downstreamGLES3.glEGLImageTargetTexture2DOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s)",
                   "glEGLImageTargetTexture2DOES", arg0, arg1);
    }
  }
  @Override
  public void glEnable(int arg0)
  {
    checkContext();
    downstreamGLES3.glEnable(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEnable", arg0);
    }
  }
  @Override
  public void glEnableDriverControlQCOM(int arg0)
  {
    checkContext();
    downstreamGLES3.glEnableDriverControlQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEnableDriverControlQCOM", arg0);
    }
  }
  @Override
  public void glEnableVertexAttribArray(int arg0)
  {
    checkContext();
    downstreamGLES3.glEnableVertexAttribArray(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEnableVertexAttribArray", arg0);
    }
  }
  @Override
  public void glEnablei(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glEnablei(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glEnablei", arg0, arg1);
    }
  }
  @Override
  public void glEnableiEXT(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glEnableiEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glEnableiEXT", arg0, arg1);
    }
  }
  @Override
  public void glEnableiNV(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glEnableiNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glEnableiNV", arg0, arg1);
    }
  }
  @Override
  public void glEnableiOES(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glEnableiOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glEnableiOES", arg0, arg1);
    }
  }
  @Override
  public void glEndConditionalRender()
  {
    checkContext();
    downstreamGLES3.glEndConditionalRender();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glEndConditionalRender");
    }
  }
  @Override
  public void glEndQuery(int arg0)
  {
    checkContext();
    downstreamGLES3.glEndQuery(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEndQuery", arg0);
    }
  }
  @Override
  public void glEndTilingQCOM(int arg0)
  {
    checkContext();
    downstreamGLES3.glEndTilingQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEndTilingQCOM", arg0);
    }
  }
  @Override
  public void glEndTransformFeedback()
  {
    checkContext();
    downstreamGLES3.glEndTransformFeedback();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glEndTransformFeedback");
    }
  }
  @Override
  public void glExtGetBufferPointervQCOM(int arg0,com.jogamp.common.nio.PointerBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glExtGetBufferPointervQCOM(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <com.jogamp.common.nio.PointerBuffer> %s)",
                   "glExtGetBufferPointervQCOM", arg0, arg1);
    }
  }
  @Override
  public void glExtGetBuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetBuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetBuffersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetBuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glExtGetBuffersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetBuffersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetFramebuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glExtGetFramebuffersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetFramebuffersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetFramebuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetFramebuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetFramebuffersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,java.nio.ByteBuffer arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glExtGetProgramBinarySourceQCOM", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,byte[] arg2,int arg3,int[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetProgramBinarySourceQCOM", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glExtGetProgramsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glExtGetProgramsQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetProgramsQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetProgramsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetProgramsQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetProgramsQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetRenderbuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glExtGetRenderbuffersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetRenderbuffersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetRenderbuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetRenderbuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetRenderbuffersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetShadersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glExtGetShadersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetShadersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetShadersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetShadersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetShadersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetTexLevelParameterivQCOM", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetTexLevelParameterivQCOM", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glExtGetTexSubImageQCOM(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    checkContext();
    downstreamGLES3.glExtGetTexSubImageQCOM(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glExtGetTexSubImageQCOM", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }
  }
  @Override
  public void glExtGetTexturesQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glExtGetTexturesQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetTexturesQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetTexturesQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glExtGetTexturesQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetTexturesQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public boolean glExtIsProgramBinaryQCOM(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glExtIsProgramBinaryQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glExtIsProgramBinaryQCOM", arg0);
    }
    return _res;
  }
  @Override
  public void glExtTexObjectStateOverrideiQCOM(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glExtTexObjectStateOverrideiQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glExtTexObjectStateOverrideiQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public long glFenceSync(int arg0,int arg1)
  {
    checkContext();
    long _res = downstreamGLES3.glFenceSync(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glFenceSync", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glFinish()
  {
    checkContext();
    downstreamGLES3.glFinish();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glFinish");
    }
  }
  @Override
  public void glFlush()
  {
    checkContext();
    downstreamGLES3.glFlush();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glFlush");
    }
  }
  @Override
  public void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
    checkContext();
    downstreamGLES3.glFlushMappedBufferRange(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <long> %s)",
                   "glFlushMappedBufferRange", arg0, arg1, arg2);
    }
  }
  @Override
  public void glFragmentCoverageColorNV(int arg0)
  {
    checkContext();
    downstreamGLES3.glFragmentCoverageColorNV(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glFragmentCoverageColorNV", arg0);
    }
  }
  @Override
  public void glFramebufferParameteri(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glFramebufferParameteri(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferParameteri", arg0, arg1, arg2);
    }
  }
  @Override
  public void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferRenderbuffer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glFramebufferSampleLocationsfvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glFramebufferSampleLocationsfvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glFramebufferTexture(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glFramebufferTexture(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTexture", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTexture2D", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glFramebufferTexture2DMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glFramebufferTexture2DMultisampleEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTexture2DMultisampleEXT", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFramebufferTexture2DMultisampleIMG(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glFramebufferTexture2DMultisampleIMG(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTexture2DMultisampleIMG", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFramebufferTexture3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glFramebufferTexture3D(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTexture3D", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFramebufferTextureEXT(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glFramebufferTextureEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTextureEXT", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glFramebufferTextureLayer(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glFramebufferTextureLayer(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTextureLayer", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glFramebufferTextureMultiviewOVR(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glFramebufferTextureMultiviewOVR(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTextureMultiviewOVR", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFramebufferTextureOES(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glFramebufferTextureOES(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTextureOES", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glFrontFace(int arg0)
  {
    checkContext();
    downstreamGLES3.glFrontFace(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glFrontFace", arg0);
    }
  }
  @Override
  public void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenBuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenBuffers", arg0, arg1);
    }
  }
  @Override
  public void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenBuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenBuffers", arg0, arg2);
    }
  }
  @Override
  public void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenFramebuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenFramebuffers", arg0, arg2);
    }
  }
  @Override
  public void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenFramebuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenFramebuffers", arg0, arg1);
    }
  }
  @Override
  public void glGenProgramPipelines(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenProgramPipelines(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenProgramPipelines", arg0, arg1);
    }
  }
  @Override
  public void glGenProgramPipelines(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenProgramPipelines(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenProgramPipelines", arg0, arg2);
    }
  }
  @Override
  public void glGenQueries(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenQueries(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenQueries", arg0, arg2);
    }
  }
  @Override
  public void glGenQueries(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenQueries(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenQueries", arg0, arg1);
    }
  }
  @Override
  public void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenRenderbuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenRenderbuffers", arg0, arg2);
    }
  }
  @Override
  public void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenRenderbuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenRenderbuffers", arg0, arg1);
    }
  }
  @Override
  public void glGenSamplers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenSamplers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenSamplers", arg0, arg1);
    }
  }
  @Override
  public void glGenSamplers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenSamplers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenSamplers", arg0, arg2);
    }
  }
  @Override
  public void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenTextures(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenTextures", arg0, arg1);
    }
  }
  @Override
  public void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenTextures(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenTextures", arg0, arg2);
    }
  }
  @Override
  public void glGenTransformFeedbacks(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenTransformFeedbacks(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenTransformFeedbacks", arg0, arg2);
    }
  }
  @Override
  public void glGenTransformFeedbacks(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenTransformFeedbacks(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenTransformFeedbacks", arg0, arg1);
    }
  }
  @Override
  public void glGenVertexArrays(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenVertexArrays(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenVertexArrays", arg0, arg2);
    }
  }
  @Override
  public void glGenVertexArrays(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenVertexArrays(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenVertexArrays", arg0, arg1);
    }
  }
  @Override
  public void glGenVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGenVertexArraysOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenVertexArraysOES", arg0, arg2);
    }
  }
  @Override
  public void glGenVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGenVertexArraysOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenVertexArraysOES", arg0, arg1);
    }
  }
  @Override
  public void glGenerateMipmap(int arg0)
  {
    checkContext();
    downstreamGLES3.glGenerateMipmap(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glGenerateMipmap", arg0);
    }
  }
  @Override
  public void glGetActiveAttrib(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    checkContext();
    downstreamGLES3.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetActiveAttrib", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glGetActiveAttrib(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    checkContext();
    downstreamGLES3.glGetActiveAttrib(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetActiveAttrib", arg0, arg1, arg2, arg4, arg6, arg8, arg10);
    }
  }
  @Override
  public void glGetActiveUniform(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetActiveUniform", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glGetActiveUniform(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniform(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetActiveUniform", arg0, arg1, arg2, arg4, arg6, arg8, arg10);
    }
  }
  @Override
  public void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetActiveUniformBlockName", arg0, arg1, arg2, arg4, arg6);
    }
  }
  @Override
  public void glGetActiveUniformBlockName(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniformBlockName(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetActiveUniformBlockName", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetActiveUniformBlockiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetActiveUniformBlockiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniformBlockiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetActiveUniformBlockiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetActiveUniformsiv(int arg0,int arg1,int[] arg2,int arg3,int arg4,int[] arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetActiveUniformsiv", arg0, arg1, arg3, arg4, arg6);
    }
  }
  @Override
  public void glGetActiveUniformsiv(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,java.nio.IntBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glGetActiveUniformsiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetActiveUniformsiv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glGetAttachedShaders(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetAttachedShaders(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetAttachedShaders", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetAttachedShaders(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetAttachedShaders(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glGetAttachedShaders", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public int glGetAttribLocation(int arg0,java.lang.String arg1)
  {
    checkContext();
    int _res = downstreamGLES3.glGetAttribLocation(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.lang.String> %s)",
                   "glGetAttribLocation", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glGetBooleani_v(int arg0,int arg1,byte[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetBooleani_v(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetBooleani_v", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetBooleani_v(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetBooleani_v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetBooleani_v", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGetBooleanv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetBooleanv", arg0, arg1);
    }
  }
  @Override
  public void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGetBooleanv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetBooleanv", arg0, arg2);
    }
  }
  @Override
  public void glGetBufferParameteri64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetBufferParameteri64v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.LongBuffer> %s)",
                   "glGetBufferParameteri64v", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetBufferParameteri64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetBufferParameteri64v(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[J>, <int> 0x%X)",
                   "glGetBufferParameteri64v", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetBufferParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetBufferParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetBufferParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetCoverageModulationTableNV(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGetCoverageModulationTableNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetCoverageModulationTableNV", arg0, arg2);
    }
  }
  @Override
  public void glGetCoverageModulationTableNV(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGetCoverageModulationTableNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetCoverageModulationTableNV", arg0, arg1);
    }
  }
  @Override
  public int glGetDebugMessageLog(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,int[] arg6,int arg7,int[] arg8,int arg9,int[] arg10,int arg11,byte[] arg12,int arg13)
  {
    checkContext();
    int _res = downstreamGLES3.glGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10,arg11,arg12,arg13);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetDebugMessageLog", arg0, arg1, arg3, arg5, arg7, arg9, arg11, arg13);
    }
    return _res;
  }
  @Override
  public int glGetDebugMessageLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.IntBuffer arg6,java.nio.ByteBuffer arg7)
  {
    checkContext();
    int _res = downstreamGLES3.glGetDebugMessageLog(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetDebugMessageLog", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
    return _res;
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetDriverControlStringQCOM", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetDriverControlStringQCOM", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetDriverControlsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetDriverControlsQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetDriverControlsQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetDriverControlsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetDriverControlsQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetDriverControlsQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public int glGetError()
  {
    checkContext();
    int _res = downstreamGLES3.glGetError();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glGetError");
    }
    return _res;
  }
  @Override
  public void glGetFloati_vNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetFloati_vNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetFloati_vNV", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetFloati_vNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetFloati_vNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetFloati_vNV", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGetFloatv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetFloatv", arg0, arg1);
    }
  }
  @Override
  public void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGetFloatv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetFloatv", arg0, arg2);
    }
  }
  @Override
  public int glGetFragDataIndexEXT(int arg0,java.nio.ByteBuffer arg1)
  {
    checkContext();
    int _res = downstreamGLES3.glGetFragDataIndexEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetFragDataIndexEXT", arg0, arg1);
    }
    return _res;
  }
  @Override
  public int glGetFragDataIndexEXT(int arg0,byte[] arg1,int arg2)
  {
    checkContext();
    int _res = downstreamGLES3.glGetFragDataIndexEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetFragDataIndexEXT", arg0, arg2);
    }
    return _res;
  }
  @Override
  public int glGetFragDataLocation(int arg0,java.lang.String arg1)
  {
    checkContext();
    int _res = downstreamGLES3.glGetFragDataLocation(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.lang.String> %s)",
                   "glGetFragDataLocation", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetFramebufferAttachmentParameteriv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetFramebufferAttachmentParameteriv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetFramebufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetFramebufferParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetFramebufferParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetFramebufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetFramebufferParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetFramebufferParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public int glGetGraphicsResetStatus()
  {
    checkContext();
    int _res = downstreamGLES3.glGetGraphicsResetStatus();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glGetGraphicsResetStatus");
    }
    return _res;
  }
  @Override
  public void glGetInteger64i_v(int arg0,int arg1,long[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetInteger64i_v(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[J>, <int> 0x%X)",
                   "glGetInteger64i_v", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetInteger64i_v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetInteger64i_v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.LongBuffer> %s)",
                   "glGetInteger64i_v", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetInteger64v(int arg0,java.nio.LongBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGetInteger64v(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.LongBuffer> %s)",
                   "glGetInteger64v", arg0, arg1);
    }
  }
  @Override
  public void glGetInteger64v(int arg0,long[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGetInteger64v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[J>, <int> 0x%X)",
                   "glGetInteger64v", arg0, arg2);
    }
  }
  @Override
  public void glGetIntegeri_v(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetIntegeri_v(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetIntegeri_v", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetIntegeri_v(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetIntegeri_v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetIntegeri_v", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetIntegeri_vEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetIntegeri_vEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetIntegeri_vEXT", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetIntegeri_vEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetIntegeri_vEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetIntegeri_vEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glGetIntegerv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetIntegerv", arg0, arg2);
    }
  }
  @Override
  public void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glGetIntegerv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetIntegerv", arg0, arg1);
    }
  }
  @Override
  public void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetInternalformativ", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glGetInternalformativ(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetInternalformativ(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetInternalformativ", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glGetMultisamplefv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetMultisamplefv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetMultisamplefv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetMultisamplefv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetMultisamplefv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetMultisamplefv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetObjectLabel(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.ByteBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glGetObjectLabel(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetObjectLabel", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glGetObjectLabel(int arg0,int arg1,int arg2,int[] arg3,int arg4,byte[] arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glGetObjectLabel(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetObjectLabel", arg0, arg1, arg2, arg4, arg6);
    }
  }
  @Override
  public void glGetObjectPtrLabel(java.nio.Buffer arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetObjectPtrLabel(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.Buffer> %s, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetObjectPtrLabel", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetObjectPtrLabel(java.nio.Buffer arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetObjectPtrLabel(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.Buffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetObjectPtrLabel", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetProgramBinary(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3,java.nio.Buffer arg4)
  {
    checkContext();
    downstreamGLES3.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.Buffer> %s)",
                   "glGetProgramBinary", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glGetProgramBinary(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5,java.nio.Buffer arg6)
  {
    checkContext();
    downstreamGLES3.glGetProgramBinary(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glGetProgramBinary", arg0, arg1, arg3, arg5, arg6);
    }
  }
  @Override
  public void glGetProgramInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetProgramInfoLog(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetProgramInfoLog", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetProgramInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetProgramInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetProgramInfoLog", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetProgramInterfaceiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetProgramInterfaceiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetProgramInterfaceiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetProgramInterfaceiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetProgramInterfaceiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetProgramInterfaceiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetProgramPipelineInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetProgramPipelineInfoLog", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetProgramPipelineInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetProgramPipelineInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetProgramPipelineInfoLog", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetProgramPipelineiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetProgramPipelineiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetProgramPipelineiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetProgramPipelineiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetProgramPipelineiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetProgramPipelineiv", arg0, arg1, arg2);
    }
  }
  @Override
  public int glGetProgramResourceIndex(int arg0,int arg1,byte[] arg2,int arg3)
  {
    checkContext();
    int _res = downstreamGLES3.glGetProgramResourceIndex(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetProgramResourceIndex", arg0, arg1, arg3);
    }
    return _res;
  }
  @Override
  public int glGetProgramResourceIndex(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    checkContext();
    int _res = downstreamGLES3.glGetProgramResourceIndex(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetProgramResourceIndex", arg0, arg1, arg2);
    }
    return _res;
  }
  @Override
  public int glGetProgramResourceLocation(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    checkContext();
    int _res = downstreamGLES3.glGetProgramResourceLocation(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetProgramResourceLocation", arg0, arg1, arg2);
    }
    return _res;
  }
  @Override
  public int glGetProgramResourceLocation(int arg0,int arg1,byte[] arg2,int arg3)
  {
    checkContext();
    int _res = downstreamGLES3.glGetProgramResourceLocation(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetProgramResourceLocation", arg0, arg1, arg3);
    }
    return _res;
  }
  @Override
  public int glGetProgramResourceLocationIndexEXT(int arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    checkContext();
    int _res = downstreamGLES3.glGetProgramResourceLocationIndexEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetProgramResourceLocationIndexEXT", arg0, arg1, arg2);
    }
    return _res;
  }
  @Override
  public int glGetProgramResourceLocationIndexEXT(int arg0,int arg1,byte[] arg2,int arg3)
  {
    checkContext();
    int _res = downstreamGLES3.glGetProgramResourceLocationIndexEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetProgramResourceLocationIndexEXT", arg0, arg1, arg3);
    }
    return _res;
  }
  @Override
  public void glGetProgramResourceName(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,byte[] arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glGetProgramResourceName(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetProgramResourceName", arg0, arg1, arg2, arg3, arg5, arg7);
    }
  }
  @Override
  public void glGetProgramResourceName(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,java.nio.ByteBuffer arg5)
  {
    checkContext();
    downstreamGLES3.glGetProgramResourceName(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetProgramResourceName", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glGetProgramResourceiv(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5,int arg6,int[] arg7,int arg8,int[] arg9,int arg10)
  {
    checkContext();
    downstreamGLES3.glGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetProgramResourceiv", arg0, arg1, arg2, arg3, arg5, arg6, arg8, arg10);
    }
  }
  @Override
  public void glGetProgramResourceiv(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4,int arg5,java.nio.IntBuffer arg6,java.nio.IntBuffer arg7)
  {
    checkContext();
    downstreamGLES3.glGetProgramResourceiv(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glGetProgramResourceiv", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glGetProgramiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetProgramiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetProgramiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetProgramiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetProgramiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetProgramiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetQueryObjecti64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjecti64v(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[J>, <int> 0x%X)",
                   "glGetQueryObjecti64v", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetQueryObjecti64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjecti64v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.LongBuffer> %s)",
                   "glGetQueryObjecti64v", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetQueryObjectiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjectiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetQueryObjectiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetQueryObjectiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjectiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetQueryObjectiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetQueryObjectui64v(int arg0,int arg1,java.nio.LongBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjectui64v(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.LongBuffer> %s)",
                   "glGetQueryObjectui64v", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetQueryObjectui64v(int arg0,int arg1,long[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjectui64v(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[J>, <int> 0x%X)",
                   "glGetQueryObjectui64v", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetQueryObjectuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjectuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetQueryObjectuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetQueryObjectuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetQueryObjectuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetQueryObjectuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetQueryiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetQueryiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetQueryiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetQueryiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetQueryiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetQueryiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetRenderbufferParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetRenderbufferParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameterIiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetSamplerParameterIiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameterIiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetSamplerParameterIiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetSamplerParameterIuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameterIuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetSamplerParameterIuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameterfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetSamplerParameterfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameterfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetSamplerParameterfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetSamplerParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetSamplerParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetSamplerParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetShaderInfoLog(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetShaderInfoLog(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetShaderInfoLog", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetShaderInfoLog(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetShaderInfoLog(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetShaderInfoLog", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetShaderPrecisionFormat(int arg0,int arg1,int[] arg2,int arg3,int[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetShaderPrecisionFormat", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetShaderPrecisionFormat(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetShaderPrecisionFormat(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glGetShaderPrecisionFormat", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetShaderSource(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetShaderSource(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetShaderSource", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetShaderSource(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetShaderSource(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetShaderSource", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetShaderiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetShaderiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetShaderiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetShaderiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetShaderiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetShaderiv", arg0, arg1, arg3);
    }
  }
  @Override
  public java.lang.String glGetString(int arg0)
  {
    checkContext();
    java.lang.String _res = downstreamGLES3.glGetString(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glGetString", arg0);
    }
    return _res;
  }
  @Override
  public java.lang.String glGetStringi(int arg0,int arg1)
  {
    checkContext();
    java.lang.String _res = downstreamGLES3.glGetStringi(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glGetStringi", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glGetSynciv(long arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glGetSynciv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glGetSynciv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glGetSynciv(long arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glGetSynciv(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetSynciv", arg0, arg1, arg2, arg4, arg6);
    }
  }
  @Override
  public void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetTexLevelParameterfv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetTexLevelParameterfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetTexLevelParameterfv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetTexLevelParameterfv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexLevelParameteriv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetTexLevelParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetTexLevelParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexLevelParameteriv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetTexParameterIiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexParameterIiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetTexParameterIiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexParameterIiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetTexParameterIuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexParameterIuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetTexParameterIuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexParameterIuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetTexParameterfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetTexParameterfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetTexParameterfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetTexParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,int[] arg3,int arg4,int[] arg5,int arg6,int[] arg7,int arg8,byte[] arg9,int arg10)
  {
    checkContext();
    downstreamGLES3.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetTransformFeedbackVarying", arg0, arg1, arg2, arg4, arg6, arg8, arg10);
    }
  }
  @Override
  public void glGetTransformFeedbackVarying(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3,java.nio.IntBuffer arg4,java.nio.IntBuffer arg5,java.nio.ByteBuffer arg6)
  {
    checkContext();
    downstreamGLES3.glGetTransformFeedbackVarying(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetTransformFeedbackVarying", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glGetTranslatedShaderSourceANGLE(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glGetTranslatedShaderSourceANGLE(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetTranslatedShaderSourceANGLE", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glGetTranslatedShaderSourceANGLE(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetTranslatedShaderSourceANGLE(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <java.nio.ByteBuffer> %s)",
                   "glGetTranslatedShaderSourceANGLE", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public int glGetUniformBlockIndex(int arg0,java.lang.String arg1)
  {
    checkContext();
    int _res = downstreamGLES3.glGetUniformBlockIndex(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.lang.String> %s)",
                   "glGetUniformBlockIndex", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetUniformIndices(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[Ljava.lang.String;>, <[I>, <int> 0x%X)",
                   "glGetUniformIndices", arg0, arg1, arg4);
    }
  }
  @Override
  public void glGetUniformIndices(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetUniformIndices(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[Ljava.lang.String;>, <java.nio.IntBuffer> %s)",
                   "glGetUniformIndices", arg0, arg1, arg3);
    }
  }
  @Override
  public int glGetUniformLocation(int arg0,java.lang.String arg1)
  {
    checkContext();
    int _res = downstreamGLES3.glGetUniformLocation(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.lang.String> %s)",
                   "glGetUniformLocation", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glGetUniformfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetUniformfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetUniformfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetUniformfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetUniformfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetUniformfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetUniformiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetUniformiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetUniformiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetUniformiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetUniformiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetUniformiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetUniformuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetUniformuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetUniformuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetUniformuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetUniformuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetUniformuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetVertexAttribIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribIiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetVertexAttribIiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetVertexAttribIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribIiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetVertexAttribIiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetVertexAttribIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribIuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetVertexAttribIuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetVertexAttribIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribIuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetVertexAttribIuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetVertexAttribfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetVertexAttribfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetVertexAttribfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetVertexAttribfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetVertexAttribiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetVertexAttribiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetVertexAttribiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glGetVertexAttribiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetVertexAttribiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetnUniformfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetnUniformfv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetnUniformfv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetnUniformiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetnUniformiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetnUniformiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetnUniformuiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glGetnUniformuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetnUniformuiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetnUniformuiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glGetnUniformuiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetnUniformuiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glHint(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glHint(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glHint", arg0, arg1);
    }
  }
  @Override
  public void glInvalidateFramebuffer(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glInvalidateFramebuffer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glInvalidateFramebuffer", arg0, arg1, arg3);
    }
  }
  @Override
  public void glInvalidateFramebuffer(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glInvalidateFramebuffer(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glInvalidateFramebuffer", arg0, arg1, arg2);
    }
  }
  @Override
  public void glInvalidateSubFramebuffer(int arg0,int arg1,java.nio.IntBuffer arg2,int arg3,int arg4,int arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glInvalidateSubFramebuffer", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glInvalidateSubFramebuffer(int arg0,int arg1,int[] arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glInvalidateSubFramebuffer(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glInvalidateSubFramebuffer", arg0, arg1, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public boolean glIsBuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsBuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsBuffer", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsEnabled(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsEnabled(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsEnabled", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsEnabledi(int arg0,int arg1)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsEnabledi(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glIsEnabledi", arg0, arg1);
    }
    return _res;
  }
  @Override
  public boolean glIsEnablediEXT(int arg0,int arg1)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsEnablediEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glIsEnablediEXT", arg0, arg1);
    }
    return _res;
  }
  @Override
  public boolean glIsEnablediNV(int arg0,int arg1)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsEnablediNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glIsEnablediNV", arg0, arg1);
    }
    return _res;
  }
  @Override
  public boolean glIsEnablediOES(int arg0,int arg1)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsEnablediOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glIsEnablediOES", arg0, arg1);
    }
    return _res;
  }
  @Override
  public boolean glIsFramebuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsFramebuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsFramebuffer", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsProgram(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsProgram(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsProgram", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsProgramPipeline(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsProgramPipeline(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsProgramPipeline", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsQuery(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsQuery(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsQuery", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsRenderbuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsRenderbuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsRenderbuffer", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsSampler(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsSampler(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsSampler", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsShader(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsShader(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsShader", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsSync(long arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsSync(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s)",
                   "glIsSync", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsTexture(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsTexture(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsTexture", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsTransformFeedback(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsTransformFeedback(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsTransformFeedback", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsVertexArray(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsVertexArray(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsVertexArray", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsVertexArrayOES(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glIsVertexArrayOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsVertexArrayOES", arg0);
    }
    return _res;
  }
  @Override
  public void glLineWidth(float arg0)
  {
    checkContext();
    downstreamGLES3.glLineWidth(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glLineWidth", arg0);
    }
  }
  @Override
  public void glLinkProgram(int arg0)
  {
    checkContext();
    downstreamGLES3.glLinkProgram(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glLinkProgram", arg0);
    }
  }
  @Override
  public java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    checkContext();
    java.nio.ByteBuffer _res = downstreamGLES3.glMapBuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glMapBuffer", arg0, arg1);
    }
    return _res;
  }
  @Override
  public java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    checkContext();
    java.nio.ByteBuffer _res = downstreamGLES3.glMapBufferRange(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <long> %s, <int> 0x%X)",
                   "glMapBufferRange", arg0, arg1, arg2, arg3);
    }
    return _res;
  }
  @Override
  public void glMemoryBarrier(int arg0)
  {
    checkContext();
    downstreamGLES3.glMemoryBarrier(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glMemoryBarrier", arg0);
    }
  }
  @Override
  public void glMemoryBarrierByRegion(int arg0)
  {
    checkContext();
    downstreamGLES3.glMemoryBarrierByRegion(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glMemoryBarrierByRegion", arg0);
    }
  }
  @Override
  public void glMinSampleShading(float arg0)
  {
    checkContext();
    downstreamGLES3.glMinSampleShading(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glMinSampleShading", arg0);
    }
  }
  @Override
  public void glMinSampleShadingOES(float arg0)
  {
    checkContext();
    downstreamGLES3.glMinSampleShadingOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glMinSampleShadingOES", arg0);
    }
  }
  @Override
  public void glMultiDrawArraysIndirectEXT(int arg0,java.nio.Buffer arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glMultiDrawArraysIndirectEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X, <int> 0x%X)",
                   "glMultiDrawArraysIndirectEXT", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glMultiDrawElementsBaseVertexEXT(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4,java.nio.IntBuffer arg5)
  {
    checkContext();
    downstreamGLES3.glMultiDrawElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s, <int> 0x%X, <com.jogamp.common.nio.PointerBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glMultiDrawElementsBaseVertexEXT", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glMultiDrawElementsBaseVertexEXT(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5,int[] arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glMultiDrawElementsBaseVertexEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X, <int> 0x%X, <com.jogamp.common.nio.PointerBuffer> %s, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glMultiDrawElementsBaseVertexEXT", arg0, arg2, arg3, arg4, arg5, arg7);
    }
  }
  @Override
  public void glMultiDrawElementsBaseVertexOES(int arg0,int[] arg1,int arg2,int arg3,com.jogamp.common.nio.PointerBuffer arg4,int arg5,int[] arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glMultiDrawElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X, <int> 0x%X, <com.jogamp.common.nio.PointerBuffer> %s, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glMultiDrawElementsBaseVertexOES", arg0, arg2, arg3, arg4, arg5, arg7);
    }
  }
  @Override
  public void glMultiDrawElementsBaseVertexOES(int arg0,java.nio.IntBuffer arg1,int arg2,com.jogamp.common.nio.PointerBuffer arg3,int arg4,java.nio.IntBuffer arg5)
  {
    checkContext();
    downstreamGLES3.glMultiDrawElementsBaseVertexOES(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s, <int> 0x%X, <com.jogamp.common.nio.PointerBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glMultiDrawElementsBaseVertexOES", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glMultiDrawElementsIndirectEXT(int arg0,int arg1,java.nio.Buffer arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glMultiDrawElementsIndirectEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X, <int> 0x%X)",
                   "glMultiDrawElementsIndirectEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glNamedFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glNamedFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glNamedFramebufferSampleLocationsfvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glNamedFramebufferSampleLocationsfvNV(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glNamedFramebufferSampleLocationsfvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glNamedFramebufferSampleLocationsfvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glObjectLabel(int arg0,int arg1,int arg2,byte[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glObjectLabel(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glObjectLabel", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glObjectLabel(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glObjectLabel(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glObjectLabel", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glObjectPtrLabel(java.nio.Buffer arg0,int arg1,java.nio.ByteBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glObjectPtrLabel(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.Buffer> %s, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glObjectPtrLabel", arg0, arg1, arg2);
    }
  }
  @Override
  public void glObjectPtrLabel(java.nio.Buffer arg0,int arg1,byte[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glObjectPtrLabel(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.Buffer> %s, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glObjectPtrLabel", arg0, arg1, arg3);
    }
  }
  @Override
  public void glPatchParameteri(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glPatchParameteri(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPatchParameteri", arg0, arg1);
    }
  }
  @Override
  public void glPatchParameteriEXT(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glPatchParameteriEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPatchParameteriEXT", arg0, arg1);
    }
  }
  @Override
  public void glPatchParameteriOES(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glPatchParameteriOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPatchParameteriOES", arg0, arg1);
    }
  }
  @Override
  public void glPauseTransformFeedback()
  {
    checkContext();
    downstreamGLES3.glPauseTransformFeedback();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glPauseTransformFeedback");
    }
  }
  @Override
  public void glPixelStorei(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glPixelStorei(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPixelStorei", arg0, arg1);
    }
  }
  @Override
  public void glPolygonModeNV(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glPolygonModeNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPolygonModeNV", arg0, arg1);
    }
  }
  @Override
  public void glPolygonOffset(float arg0,float arg1)
  {
    checkContext();
    downstreamGLES3.glPolygonOffset(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s)",
                   "glPolygonOffset", arg0, arg1);
    }
  }
  @Override
  public void glPopDebugGroup()
  {
    checkContext();
    downstreamGLES3.glPopDebugGroup();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glPopDebugGroup");
    }
  }
  @Override
  public void glPrimitiveBoundingBox(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7)
  {
    checkContext();
    downstreamGLES3.glPrimitiveBoundingBox(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glPrimitiveBoundingBox", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glPrimitiveBoundingBoxEXT(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7)
  {
    checkContext();
    downstreamGLES3.glPrimitiveBoundingBoxEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glPrimitiveBoundingBoxEXT", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glPrimitiveBoundingBoxOES(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5,float arg6,float arg7)
  {
    checkContext();
    downstreamGLES3.glPrimitiveBoundingBoxOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glPrimitiveBoundingBoxOES", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glProgramBinary(int arg0,int arg1,java.nio.Buffer arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glProgramBinary(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glProgramBinary", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramParameteri(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glProgramParameteri(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramParameteri", arg0, arg1, arg2);
    }
  }
  @Override
  public void glProgramUniform1f(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1f(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glProgramUniform1f", arg0, arg1, arg2);
    }
  }
  @Override
  public void glProgramUniform1fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glProgramUniform1fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform1fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glProgramUniform1fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform1i(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1i(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform1i", arg0, arg1, arg2);
    }
  }
  @Override
  public void glProgramUniform1iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1iv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform1iv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform1iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform1iv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform1ui(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1ui(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform1ui", arg0, arg1, arg2);
    }
  }
  @Override
  public void glProgramUniform1uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1uiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform1uiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform1uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform1uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform1uiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform2f(int arg0,int arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2f(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s, <float> %s)",
                   "glProgramUniform2f", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform2fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glProgramUniform2fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform2fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glProgramUniform2fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform2i(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2i(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform2i", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform2iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform2iv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform2iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2iv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform2iv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform2ui(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2ui(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform2ui", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform2uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2uiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform2uiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform2uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform2uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform2uiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform3f(int arg0,int arg1,float arg2,float arg3,float arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3f(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s, <float> %s, <float> %s)",
                   "glProgramUniform3f", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniform3fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glProgramUniform3fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform3fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glProgramUniform3fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform3i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3i(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform3i", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniform3iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform3iv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform3iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3iv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform3iv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform3ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3ui(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform3ui", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniform3uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3uiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform3uiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform3uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform3uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform3uiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform4f(int arg0,int arg1,float arg2,float arg3,float arg4,float arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4f(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glProgramUniform4f", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glProgramUniform4fv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glProgramUniform4fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform4fv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glProgramUniform4fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4i(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform4i", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glProgramUniform4iv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform4iv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform4iv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4iv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform4iv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4ui(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glProgramUniform4ui", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glProgramUniform4uiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glProgramUniform4uiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glProgramUniform4uiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniform4uiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glProgramUniform4uiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix2fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix2fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix2x3fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix2x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix2x3fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix2x4fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix2x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix2x4fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix3fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix3fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix3x2fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix3x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix3x2fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix3x4fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix3x4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix3x4fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix4fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix4fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix4fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix4x2fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glProgramUniformMatrix4x2fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix4x2fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,float[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glProgramUniformMatrix4x3fv", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glProgramUniformMatrix4x3fv(int arg0,int arg1,int arg2,boolean arg3,java.nio.FloatBuffer arg4)
  {
    checkContext();
    downstreamGLES3.glProgramUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glProgramUniformMatrix4x3fv", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glPushDebugGroup(int arg0,int arg1,int arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glPushDebugGroup(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glPushDebugGroup", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glPushDebugGroup(int arg0,int arg1,int arg2,byte[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glPushDebugGroup(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X)",
                   "glPushDebugGroup", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glQueryCounter(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glQueryCounter(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glQueryCounter", arg0, arg1);
    }
  }
  @Override
  public void glRasterSamplesEXT(int arg0,boolean arg1)
  {
    checkContext();
    downstreamGLES3.glRasterSamplesEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <boolean> %s)",
                   "glRasterSamplesEXT", arg0, arg1);
    }
  }
  @Override
  public void glReadBuffer(int arg0)
  {
    checkContext();
    downstreamGLES3.glReadBuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glReadBuffer", arg0);
    }
  }
  @Override
  public void glReadBufferIndexedEXT(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glReadBufferIndexedEXT(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glReadBufferIndexedEXT", arg0, arg1);
    }
  }
  @Override
  public void glReadBufferNV(int arg0)
  {
    checkContext();
    downstreamGLES3.glReadBufferNV(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glReadBufferNV", arg0);
    }
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    checkContext();
    downstreamGLES3.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glReadPixels", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    checkContext();
    downstreamGLES3.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glReadPixels", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    checkContext();
    downstreamGLES3.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glReadnPixels", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glReleaseShaderCompiler()
  {
    checkContext();
    downstreamGLES3.glReleaseShaderCompiler();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glReleaseShaderCompiler");
    }
  }
  @Override
  public void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRenderbufferStorage", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRenderbufferStorageMultisample", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glRenderbufferStorageMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glRenderbufferStorageMultisampleEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRenderbufferStorageMultisampleEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glRenderbufferStorageMultisampleIMG(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glRenderbufferStorageMultisampleIMG(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRenderbufferStorageMultisampleIMG", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glRenderbufferStorageMultisampleNV(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glRenderbufferStorageMultisampleNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRenderbufferStorageMultisampleNV", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glResolveDepthValuesNV()
  {
    checkContext();
    downstreamGLES3.glResolveDepthValuesNV();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glResolveDepthValuesNV");
    }
  }
  @Override
  public void glResolveMultisampleFramebuffer()
  {
    checkContext();
    downstreamGLES3.glResolveMultisampleFramebuffer();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glResolveMultisampleFramebuffer");
    }
  }
  @Override
  public void glResumeTransformFeedback()
  {
    checkContext();
    downstreamGLES3.glResumeTransformFeedback();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glResumeTransformFeedback");
    }
  }
  @Override
  public void glSampleCoverage(float arg0,boolean arg1)
  {
    checkContext();
    downstreamGLES3.glSampleCoverage(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <boolean> %s)",
                   "glSampleCoverage", arg0, arg1);
    }
  }
  @Override
  public void glSampleMaski(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glSampleMaski(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glSampleMaski", arg0, arg1);
    }
  }
  @Override
  public void glSamplerParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterIiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glSamplerParameterIiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glSamplerParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterIiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glSamplerParameterIiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glSamplerParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterIuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glSamplerParameterIuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glSamplerParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterIuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glSamplerParameterIuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glSamplerParameterf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterf(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glSamplerParameterf", arg0, arg1, arg2);
    }
  }
  @Override
  public void glSamplerParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glSamplerParameterfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glSamplerParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glSamplerParameterfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glSamplerParameterfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glSamplerParameteri(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glSamplerParameteri(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glSamplerParameteri", arg0, arg1, arg2);
    }
  }
  @Override
  public void glSamplerParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glSamplerParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glSamplerParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glSamplerParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glSamplerParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glSamplerParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glScissor(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glScissor", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glScissorArrayvNV(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glScissorArrayvNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glScissorArrayvNV", arg0, arg1, arg2);
    }
  }
  @Override
  public void glScissorArrayvNV(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glScissorArrayvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glScissorArrayvNV", arg0, arg1, arg3);
    }
  }
  @Override
  public void glScissorIndexedNV(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glScissorIndexedNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glScissorIndexedNV", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glScissorIndexedvNV(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glScissorIndexedvNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glScissorIndexedvNV", arg0, arg2);
    }
  }
  @Override
  public void glScissorIndexedvNV(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glScissorIndexedvNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glScissorIndexedvNV", arg0, arg1);
    }
  }
  @Override
  public void glShaderBinary(int arg0,int[] arg1,int arg2,int arg3,java.nio.Buffer arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glShaderBinary(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glShaderBinary", arg0, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glShaderBinary(int arg0,java.nio.IntBuffer arg1,int arg2,java.nio.Buffer arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glShaderBinary(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glShaderBinary", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glShaderSource(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[Ljava.lang.String;>, <java.nio.IntBuffer> %s)",
                   "glShaderSource", arg0, arg1, arg3);
    }
  }
  @Override
  public void glShaderSource(int arg0,int arg1,java.lang.String[] arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glShaderSource(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[Ljava.lang.String;>, <[I>, <int> 0x%X)",
                   "glShaderSource", arg0, arg1, arg4);
    }
  }
  @Override
  public void glStartTilingQCOM(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glStartTilingQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStartTilingQCOM", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glStencilFunc(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glStencilFunc(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStencilFunc", arg0, arg1, arg2);
    }
  }
  @Override
  public void glStencilFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glStencilFuncSeparate(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStencilFuncSeparate", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glStencilMask(int arg0)
  {
    checkContext();
    downstreamGLES3.glStencilMask(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glStencilMask", arg0);
    }
  }
  @Override
  public void glStencilMaskSeparate(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glStencilMaskSeparate(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glStencilMaskSeparate", arg0, arg1);
    }
  }
  @Override
  public void glStencilOp(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glStencilOp(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStencilOp", arg0, arg1, arg2);
    }
  }
  @Override
  public void glStencilOpSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glStencilOpSeparate(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStencilOpSeparate", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glSubpixelPrecisionBiasNV(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glSubpixelPrecisionBiasNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glSubpixelPrecisionBiasNV", arg0, arg1);
    }
  }
  @Override
  public void glTexBuffer(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glTexBuffer(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexBuffer", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexBufferEXT(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glTexBufferEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexBufferEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexBufferOES(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glTexBufferOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexBufferOES", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexBufferRange(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glTexBufferRange(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <long> %s)",
                   "glTexBufferRange", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glTexBufferRangeEXT(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glTexBufferRangeEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <long> %s)",
                   "glTexBufferRangeEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glTexBufferRangeOES(int arg0,int arg1,int arg2,long arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glTexBufferRangeOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s, <long> %s)",
                   "glTexBufferRangeOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    checkContext();
    downstreamGLES3.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    checkContext();
    downstreamGLES3.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTexImage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
    checkContext();
    downstreamGLES3.glTexImage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s)",
                   "glTexImage2DMultisample", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,java.nio.Buffer arg9)
  {
    checkContext();
    downstreamGLES3.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glTexImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
  }
  @Override
  public void glTexImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,long arg9)
  {
    checkContext();
    downstreamGLES3.glTexImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glTexImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
    }
  }
  @Override
  public void glTexImage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    checkContext();
    downstreamGLES3.glTexImage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s)",
                   "glTexImage3DMultisample", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glTexPageCommitmentEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,boolean arg8)
  {
    checkContext();
    downstreamGLES3.glTexPageCommitmentEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s)",
                   "glTexPageCommitmentEXT", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTexParameterIiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glTexParameterIiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexParameterIiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexParameterIiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glTexParameterIiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexParameterIiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameterIuiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glTexParameterIuiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexParameterIuiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexParameterIuiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glTexParameterIuiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexParameterIuiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameterf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES3.glTexParameterf(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glTexParameterf", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glTexParameterfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glTexParameterfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glTexParameterfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glTexParameterfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameteri(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glTexParameteri(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexParameteri", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glTexParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glTexParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glTexStorage1D(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexStorage1D", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexStorage2D", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glTexStorage2DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,boolean arg5)
  {
    checkContext();
    downstreamGLES3.glTexStorage2DMultisample(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s)",
                   "glTexStorage2DMultisample", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexStorage3D", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glTexStorage3DMultisample(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    checkContext();
    downstreamGLES3.glTexStorage3DMultisample(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s)",
                   "glTexStorage3DMultisample", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glTexStorage3DMultisampleOES(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,boolean arg6)
  {
    checkContext();
    downstreamGLES3.glTexStorage3DMultisampleOES(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s)",
                   "glTexStorage3DMultisampleOES", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    checkContext();
    downstreamGLES3.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    checkContext();
    downstreamGLES3.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    checkContext();
    downstreamGLES3.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glTexSubImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }
  }
  @Override
  public void glTexSubImage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,long arg10)
  {
    checkContext();
    downstreamGLES3.glTexSubImage3D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glTexSubImage3D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }
  }
  @Override
  public void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTextureStorage1DEXT", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES3.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTextureStorage2DEXT", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    checkContext();
    downstreamGLES3.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTextureStorage3DEXT", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glTextureView(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    checkContext();
    downstreamGLES3.glTextureView(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTextureView", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glTransformFeedbackVaryings(int arg0,int arg1,java.lang.String[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glTransformFeedbackVaryings(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[Ljava.lang.String;>, <int> 0x%X)",
                   "glTransformFeedbackVaryings", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform(com.jogamp.opengl.GLUniformData arg0)
  {
    checkContext();
    downstreamGLES3.glUniform(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<com.jogamp.opengl.GLUniformData> %s)",
                   "glUniform", arg0);
    }
  }
  @Override
  public void glUniform1f(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES3.glUniform1f(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glUniform1f", arg0, arg1);
    }
  }
  @Override
  public void glUniform1fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform1fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glUniform1fv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform1fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform1fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glUniform1fv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform1i(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glUniform1i(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glUniform1i", arg0, arg1);
    }
  }
  @Override
  public void glUniform1iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform1iv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform1iv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform1iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform1iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform1iv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform1ui(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glUniform1ui(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glUniform1ui", arg0, arg1);
    }
  }
  @Override
  public void glUniform1uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform1uiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform1uiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform1uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform1uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform1uiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform2f(int arg0,float arg1,float arg2)
  {
    checkContext();
    downstreamGLES3.glUniform2f(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s)",
                   "glUniform2f", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform2fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform2fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glUniform2fv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform2fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform2fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glUniform2fv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform2i(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glUniform2i(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniform2i", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform2iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform2iv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform2iv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform2iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform2iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform2iv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform2ui(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glUniform2ui(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniform2ui", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform2uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform2uiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform2uiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform2uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform2uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform2uiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform3f(int arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES3.glUniform3f(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s, <float> %s)",
                   "glUniform3f", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniform3fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform3fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glUniform3fv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform3fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform3fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glUniform3fv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform3i(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform3i(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniform3i", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniform3iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform3iv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform3iv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform3iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform3iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform3iv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform3ui(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform3ui(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniform3ui", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniform3uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform3uiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform3uiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform3uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform3uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform3uiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    checkContext();
    downstreamGLES3.glUniform4f(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glUniform4f", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glUniform4fv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform4fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glUniform4fv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform4fv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform4fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glUniform4fv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniform4i(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniform4i", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glUniform4iv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform4iv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform4iv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform4iv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform4iv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform4iv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniform4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniform4ui(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniform4ui", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glUniform4uiv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glUniform4uiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glUniform4uiv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniform4uiv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glUniform4uiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glUniform4uiv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glUniformBlockBinding(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glUniformBlockBinding(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUniformBlockBinding", arg0, arg1, arg2);
    }
  }
  @Override
  public void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix2fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix2fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix2x3fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix2x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix2x3fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix2x3fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x3fvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix2x3fvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix2x3fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x3fvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix2x3fvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix2x4fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix2x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x4fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix2x4fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix2x4fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x4fvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix2x4fvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix2x4fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix2x4fvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix2x4fvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix3fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix3fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix3x2fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix3x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x2fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix3x2fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix3x2fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x2fvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix3x2fvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix3x2fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x2fvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix3x2fvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix3x4fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix3x4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix3x4fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix3x4fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x4fvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix3x4fvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix3x4fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix3x4fvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix3x4fvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix4fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix4fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix4fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix4x2fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix4x2fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x2fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix4x2fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix4x2fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x2fvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix4x2fvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix4x2fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x2fvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix4x2fvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix4x3fv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix4x3fv(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x3fv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix4x3fv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glUniformMatrix4x3fvNV(int arg0,int arg1,boolean arg2,float[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x3fvNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <[F>, <int> 0x%X)",
                   "glUniformMatrix4x3fvNV", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glUniformMatrix4x3fvNV(int arg0,int arg1,boolean arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES3.glUniformMatrix4x3fvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <boolean> %s, <java.nio.FloatBuffer> %s)",
                   "glUniformMatrix4x3fvNV", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public boolean glUnmapBuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES3.glUnmapBuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glUnmapBuffer", arg0);
    }
    return _res;
  }
  @Override
  public void glUseProgram(int arg0)
  {
    checkContext();
    downstreamGLES3.glUseProgram(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glUseProgram", arg0);
    }
  }
  @Override
  public void glUseProgramStages(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glUseProgramStages(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glUseProgramStages", arg0, arg1, arg2);
    }
  }
  @Override
  public void glValidateProgram(int arg0)
  {
    checkContext();
    downstreamGLES3.glValidateProgram(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glValidateProgram", arg0);
    }
  }
  @Override
  public void glValidateProgramPipeline(int arg0)
  {
    checkContext();
    downstreamGLES3.glValidateProgramPipeline(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glValidateProgramPipeline", arg0);
    }
  }
  @Override
  public void glVertexAttrib1f(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib1f(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glVertexAttrib1f", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttrib1fv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib1fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glVertexAttrib1fv", arg0, arg2);
    }
  }
  @Override
  public void glVertexAttrib1fv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib1fv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glVertexAttrib1fv", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttrib2f(int arg0,float arg1,float arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib2f(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s)",
                   "glVertexAttrib2f", arg0, arg1, arg2);
    }
  }
  @Override
  public void glVertexAttrib2fv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib2fv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glVertexAttrib2fv", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttrib2fv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib2fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glVertexAttrib2fv", arg0, arg2);
    }
  }
  @Override
  public void glVertexAttrib3f(int arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib3f(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s, <float> %s)",
                   "glVertexAttrib3f", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glVertexAttrib3fv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib3fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glVertexAttrib3fv", arg0, arg2);
    }
  }
  @Override
  public void glVertexAttrib3fv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib3fv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glVertexAttrib3fv", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttrib4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib4f(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glVertexAttrib4f", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glVertexAttrib4fv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib4fv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glVertexAttrib4fv", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttrib4fv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttrib4fv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glVertexAttrib4fv", arg0, arg2);
    }
  }
  @Override
  public void glVertexAttribBinding(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttribBinding(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glVertexAttribBinding", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttribDivisor(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttribDivisor(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glVertexAttribDivisor", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttribDivisorANGLE(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttribDivisorANGLE(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glVertexAttribDivisorANGLE", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttribDivisorNV(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttribDivisorNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glVertexAttribDivisorNV", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttribFormat(int arg0,int arg1,int arg2,boolean arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glVertexAttribFormat(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <int> 0x%X)",
                   "glVertexAttribFormat", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glVertexAttribI4i(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glVertexAttribI4i(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glVertexAttribI4i", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glVertexAttribI4iv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttribI4iv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glVertexAttribI4iv", arg0, arg2);
    }
  }
  @Override
  public void glVertexAttribI4iv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttribI4iv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glVertexAttribI4iv", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttribI4ui(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES3.glVertexAttribI4ui(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glVertexAttribI4ui", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glVertexAttribI4uiv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glVertexAttribI4uiv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glVertexAttribI4uiv", arg0, arg2);
    }
  }
  @Override
  public void glVertexAttribI4uiv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glVertexAttribI4uiv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glVertexAttribI4uiv", arg0, arg1);
    }
  }
  @Override
  public void glVertexAttribIFormat(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glVertexAttribIFormat(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glVertexAttribIFormat", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,long arg4)
  {
    checkContext();
    downstreamGLES3.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glVertexAttribIPointer", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glVertexAttribIPointer(int arg0,int arg1,int arg2,int arg3,java.nio.Buffer arg4)
  {
    checkContext();
    downstreamGLES3.glVertexAttribIPointer(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glVertexAttribIPointer", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,java.nio.Buffer arg5)
  {
    checkContext();
    downstreamGLES3.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glVertexAttribPointer", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glVertexAttribPointer(int arg0,int arg1,int arg2,boolean arg3,int arg4,long arg5)
  {
    checkContext();
    downstreamGLES3.glVertexAttribPointer(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <boolean> %s, <int> 0x%X, <long> %s)",
                   "glVertexAttribPointer", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glVertexAttribPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    checkContext();
    downstreamGLES3.glVertexAttribPointer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<com.jogamp.opengl.GLArrayData> %s)",
                   "glVertexAttribPointer", arg0);
    }
  }
  @Override
  public void glVertexBindingDivisor(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES3.glVertexBindingDivisor(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glVertexBindingDivisor", arg0, arg1);
    }
  }
  @Override
  public void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glViewport(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glViewport", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glViewportArrayvNV(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES3.glViewportArrayvNV(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glViewportArrayvNV", arg0, arg1, arg3);
    }
  }
  @Override
  public void glViewportArrayvNV(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES3.glViewportArrayvNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glViewportArrayvNV", arg0, arg1, arg2);
    }
  }
  @Override
  public void glViewportIndexedfNV(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    checkContext();
    downstreamGLES3.glViewportIndexedfNV(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glViewportIndexedfNV", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glViewportIndexedfvNV(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES3.glViewportIndexedfvNV(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glViewportIndexedfvNV", arg0, arg1);
    }
  }
  @Override
  public void glViewportIndexedfvNV(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES3.glViewportIndexedfvNV(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glViewportIndexedfvNV", arg0, arg2);
    }
  }
  @Override
  public void glWaitSync(long arg0,int arg1,long arg2)
  {
    checkContext();
    downstreamGLES3.glWaitSync(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<long> %s, <int> 0x%X, <long> %s)",
                   "glWaitSync", arg0, arg1, arg2);
    }
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
    checkContext();
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES3.mapBuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "mapBuffer", arg0, arg1);
    }
    return _res;
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    checkContext();
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES3.mapBufferRange(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <long> %s, <int> 0x%X)",
                   "mapBufferRange", arg0, arg1, arg2, arg3);
    }
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
    sb.append("DebugGLES3 [this 0x"+Integer.toHexString(hashCode())+" implementing com.jogamp.opengl.GLES3,\n\t");
    sb.append(" downstream: "+downstreamGLES3.toString()+"\n\t]");
    return sb.toString();
  }
  private int checkGLError() {
    return downstreamGLES3.glGetError();
  }
  private void writeGLError(int err, String fmt, Object... args)
  {
    StringBuilder buf = new StringBuilder();
    buf.append(Thread.currentThread().toString());
    buf.append(" glGetError() returned the following error codes after a call to ");
    buf.append(String.format(fmt, args));
    buf.append(": ");

    // Loop repeatedly to allow for distributed GL implementations,
    // as detailed in the glGetError() specification
    int recursionDepth = 10;
    do {
      switch (err) {
        case GL_INVALID_ENUM: buf.append("GL_INVALID_ENUM "); break;
        case GL_INVALID_VALUE: buf.append("GL_INVALID_VALUE "); break;
        case GL_INVALID_OPERATION: buf.append("GL_INVALID_OPERATION "); break;
        case GL_OUT_OF_MEMORY: buf.append("GL_OUT_OF_MEMORY "); break;
        case GL_NO_ERROR: throw new InternalError("Should not be treating GL_NO_ERROR as error");
        default: buf.append("Unknown glGetError() return value: ");
      }
      buf.append("( " + err + " 0x"+Integer.toHexString(err).toUpperCase() + "), ");
    } while ((--recursionDepth >= 0) && (err = downstreamGLES3.glGetError()) != GL_NO_ERROR);
    throw new GLException(buf.toString());
  }
  private void checkContext() {
    GLContext currentContext = GLContext.getCurrent();
    if (currentContext == null) {
      throw new GLException("No OpenGL context is current on this thread");
    }
    if ((_context != null) && (_context != currentContext)) {
      throw new GLException("This GL object is being incorrectly used with a different GLContext than that which created it");
    }
  }
  private GLContext _context;

  private GLES3 downstreamGLES3;
} // end class DebugGLES3
