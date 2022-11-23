package com.jogamp.opengl;

import java.io.*;
import com.jogamp.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import com.jogamp.opengl.GLES1;
import com.jogamp.opengl.GL2ES1;

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
public class DebugGLES1 implements com.jogamp.opengl.GL2ES1, com.jogamp.opengl.GLES1{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("DebugGLES1");
  public DebugGLES1(GLES1 downstreamGLES1)
  {
    if (downstreamGLES1 == null) {
      throw new IllegalArgumentException("null downstreamGLES1");
    }
    this.downstreamGLES1 = downstreamGLES1;
    // Fetch GLContext object for better error checking (if possible)
    _context = downstreamGLES1.getContext();
  }

  @Override
  public final GL getDownstreamGL() throws GLException {
    return downstreamGLES1;
  }
  @Override
  public int getBoundBuffer(int arg0)
  {
    return downstreamGLES1.getBoundBuffer(arg0);
  }
  @Override
  public int getBoundFramebuffer(int arg0)
  {
    return downstreamGLES1.getBoundFramebuffer(arg0);
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage getBufferStorage(int arg0)
  {
    return downstreamGLES1.getBufferStorage(arg0);
  }
  @Override
  public com.jogamp.opengl.GLContext getContext()
  {
    return downstreamGLES1.getContext();
  }
  @Override
  public int getDefaultDrawFramebuffer()
  {
    return downstreamGLES1.getDefaultDrawFramebuffer();
  }
  @Override
  public int getDefaultReadBuffer()
  {
    return downstreamGLES1.getDefaultReadBuffer();
  }
  @Override
  public int getDefaultReadFramebuffer()
  {
    return downstreamGLES1.getDefaultReadFramebuffer();
  }
  @Override
  public java.lang.Object getExtension(java.lang.String arg0)
  {
    return downstreamGLES1.getExtension(arg0);
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
    if( isGL2ES1() ) { return this; }
    throw new GLException("Not a GL2ES1 implementation");
  }
  @Override
  public com.jogamp.opengl.GL2ES2 getGL2ES2()
  {
    throw new GLException("Not a GL2ES2 implementation");
  }
  @Override
  public com.jogamp.opengl.GL2ES3 getGL2ES3()
  {
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
    if( isGLES1() ) { return this; }
    throw new GLException("Not a GLES1 implementation");
  }
  @Override
  public com.jogamp.opengl.GLES2 getGLES2()
  {
    throw new GLException("Not a GLES2 implementation");
  }
  @Override
  public com.jogamp.opengl.GLES3 getGLES3()
  {
    throw new GLException("Not a GLES3 implementation");
  }
  @Override
  public com.jogamp.opengl.GLProfile getGLProfile()
  {
    return downstreamGLES1.getGLProfile();
  }
  @Override
  public int getMaxRenderbufferSamples()
  {
    return downstreamGLES1.getMaxRenderbufferSamples();
  }
  @Override
  public java.lang.Object getPlatformGLExtensions()
  {
    return downstreamGLES1.getPlatformGLExtensions();
  }
  @Override
  public com.jogamp.opengl.GL getRootGL()
  {
    return downstreamGLES1.getRootGL();
  }
  @Override
  public int getSwapInterval()
  {
    return downstreamGLES1.getSwapInterval();
  }
  @Override
  public void glActiveTexture(int arg0)
  {
    checkContext();
    downstreamGLES1.glActiveTexture(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glActiveTexture", arg0);
    }
  }
  @Override
  public void glAlphaFunc(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES1.glAlphaFunc(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glAlphaFunc", arg0, arg1);
    }
  }
  @Override
  public void glAlphaFuncx(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glAlphaFuncx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glAlphaFuncx", arg0, arg1);
    }
  }
  @Override
  public void glBindBuffer(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glBindBuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindBuffer", arg0, arg1);
    }
  }
  @Override
  public void glBindFramebuffer(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glBindFramebuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindFramebuffer", arg0, arg1);
    }
  }
  @Override
  public void glBindRenderbuffer(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glBindRenderbuffer(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindRenderbuffer", arg0, arg1);
    }
  }
  @Override
  public void glBindTexture(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glBindTexture(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBindTexture", arg0, arg1);
    }
  }
  @Override
  public void glBindVertexArrayOES(int arg0)
  {
    checkContext();
    downstreamGLES1.glBindVertexArrayOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glBindVertexArrayOES", arg0);
    }
  }
  @Override
  public void glBlendEquation(int arg0)
  {
    checkContext();
    downstreamGLES1.glBlendEquation(arg0);
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
    downstreamGLES1.glBlendEquationSeparate(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glBlendEquationSeparate", arg0, arg1);
    }
  }
  @Override
  public void glBlendFunc(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glBlendFunc(arg0,arg1);
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
    downstreamGLES1.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glBlendFuncSeparate", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glBufferData(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <java.nio.Buffer> %s, <int> 0x%X)",
                   "glBufferData", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES1.glBufferSubData(arg0,arg1,arg2,arg3);
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
    int _res = downstreamGLES1.glCheckFramebufferStatus(arg0);
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
    downstreamGLES1.glClear(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glClear", arg0);
    }
  }
  @Override
  public void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES1.glClearColor(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s)",
                   "glClearColor", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glClearColorx(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glClearColorx(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glClearColorx", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glClearDepth(double arg0)
  {
    checkContext();
    downstreamGLES1.glClearDepth(arg0);
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
    downstreamGLES1.glClearDepthf(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glClearDepthf", arg0);
    }
  }
  @Override
  public void glClearDepthx(int arg0)
  {
    checkContext();
    downstreamGLES1.glClearDepthx(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glClearDepthx", arg0);
    }
  }
  @Override
  public void glClearStencil(int arg0)
  {
    checkContext();
    downstreamGLES1.glClearStencil(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glClearStencil", arg0);
    }
  }
  @Override
  public void glClientActiveTexture(int arg0)
  {
    checkContext();
    downstreamGLES1.glClientActiveTexture(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glClientActiveTexture", arg0);
    }
  }
  @Override
  public void glClipPlanef(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glClipPlanef(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glClipPlanef", arg0, arg1);
    }
  }
  @Override
  public void glClipPlanef(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glClipPlanef(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glClipPlanef", arg0, arg2);
    }
  }
  @Override
  public void glClipPlanefIMG(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glClipPlanefIMG(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glClipPlanefIMG", arg0, arg1);
    }
  }
  @Override
  public void glClipPlanefIMG(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glClipPlanefIMG(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glClipPlanefIMG", arg0, arg2);
    }
  }
  @Override
  public void glClipPlanex(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glClipPlanex(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glClipPlanex", arg0, arg1);
    }
  }
  @Override
  public void glClipPlanex(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glClipPlanex(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glClipPlanex", arg0, arg2);
    }
  }
  @Override
  public void glClipPlanexIMG(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glClipPlanexIMG(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glClipPlanexIMG", arg0, arg1);
    }
  }
  @Override
  public void glClipPlanexIMG(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glClipPlanexIMG(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glClipPlanexIMG", arg0, arg2);
    }
  }
  @Override
  public void glColor4f(float arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES1.glColor4f(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s)",
                   "glColor4f", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3)
  {
    checkContext();
    downstreamGLES1.glColor4ub(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<byte> %s, <byte> %s, <byte> %s, <byte> %s)",
                   "glColor4ub", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glColor4x(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glColor4x(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glColor4x", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    checkContext();
    downstreamGLES1.glColorMask(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<boolean> %s, <boolean> %s, <boolean> %s, <boolean> %s)",
                   "glColorMask", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES1.glColorPointer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glColorPointer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glColorPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    checkContext();
    downstreamGLES1.glColorPointer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<com.jogamp.opengl.GLArrayData> %s)",
                   "glColorPointer", arg0);
    }
  }
  @Override
  public void glColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
    checkContext();
    downstreamGLES1.glColorPointer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glColorPointer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    checkContext();
    downstreamGLES1.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
    downstreamGLES1.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glCompressedTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    checkContext();
    downstreamGLES1.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
    downstreamGLES1.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glCompressedTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    checkContext();
    downstreamGLES1.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
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
    downstreamGLES1.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glCopyTextureLevelsAPPLE(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glCopyTextureLevelsAPPLE(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glCopyTextureLevelsAPPLE", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glCullFace(int arg0)
  {
    checkContext();
    downstreamGLES1.glCullFace(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCullFace", arg0);
    }
  }
  @Override
  public void glCurrentPaletteMatrixOES(int arg0)
  {
    checkContext();
    downstreamGLES1.glCurrentPaletteMatrixOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glCurrentPaletteMatrixOES", arg0);
    }
  }
  @Override
  public void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glDeleteBuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteBuffers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glDeleteBuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteBuffers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glDeleteFramebuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteFramebuffers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glDeleteFramebuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteFramebuffers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glDeleteRenderbuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteRenderbuffers", arg0, arg2);
    }
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glDeleteRenderbuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteRenderbuffers", arg0, arg1);
    }
  }
  @Override
  public void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glDeleteTextures(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteTextures", arg0, arg1);
    }
  }
  @Override
  public void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glDeleteTextures(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteTextures", arg0, arg2);
    }
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glDeleteVertexArraysOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glDeleteVertexArraysOES", arg0, arg2);
    }
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glDeleteVertexArraysOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDeleteVertexArraysOES", arg0, arg1);
    }
  }
  @Override
  public void glDepthFunc(int arg0)
  {
    checkContext();
    downstreamGLES1.glDepthFunc(arg0);
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
    downstreamGLES1.glDepthMask(arg0);
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
    downstreamGLES1.glDepthRange(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<double> %s, <double> %s)",
                   "glDepthRange", arg0, arg1);
    }
  }
  @Override
  public void glDepthRangef(float arg0,float arg1)
  {
    checkContext();
    downstreamGLES1.glDepthRangef(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s)",
                   "glDepthRangef", arg0, arg1);
    }
  }
  @Override
  public void glDepthRangex(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glDepthRangex(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glDepthRangex", arg0, arg1);
    }
  }
  @Override
  public void glDisable(int arg0)
  {
    checkContext();
    downstreamGLES1.glDisable(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDisable", arg0);
    }
  }
  @Override
  public void glDisableClientState(int arg0)
  {
    checkContext();
    downstreamGLES1.glDisableClientState(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDisableClientState", arg0);
    }
  }
  @Override
  public void glDisableDriverControlQCOM(int arg0)
  {
    checkContext();
    downstreamGLES1.glDisableDriverControlQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glDisableDriverControlQCOM", arg0);
    }
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glDiscardFramebufferEXT(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glDiscardFramebufferEXT", arg0, arg1, arg3);
    }
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glDiscardFramebufferEXT(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glDiscardFramebufferEXT", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDrawArrays(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glDrawArrays(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawArrays", arg0, arg1, arg2);
    }
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    checkContext();
    downstreamGLES1.glDrawElements(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glDrawElements(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glDrawElements", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glDrawTexfOES(float arg0,float arg1,float arg2,float arg3,float arg4)
  {
    checkContext();
    downstreamGLES1.glDrawTexfOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glDrawTexfOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawTexfvOES(float[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glDrawTexfvOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[F>, <int> 0x%X)",
                   "glDrawTexfvOES", arg1);
    }
  }
  @Override
  public void glDrawTexfvOES(java.nio.FloatBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glDrawTexfvOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.FloatBuffer> %s)",
                   "glDrawTexfvOES", arg0);
    }
  }
  @Override
  public void glDrawTexiOES(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glDrawTexiOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawTexiOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawTexivOES(java.nio.IntBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glDrawTexivOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s)",
                   "glDrawTexivOES", arg0);
    }
  }
  @Override
  public void glDrawTexivOES(int[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glDrawTexivOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X)",
                   "glDrawTexivOES", arg1);
    }
  }
  @Override
  public void glDrawTexsOES(short arg0,short arg1,short arg2,short arg3,short arg4)
  {
    checkContext();
    downstreamGLES1.glDrawTexsOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<short> %s, <short> %s, <short> %s, <short> %s, <short> %s)",
                   "glDrawTexsOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawTexsvOES(short[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glDrawTexsvOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[S>, <int> 0x%X)",
                   "glDrawTexsvOES", arg1);
    }
  }
  @Override
  public void glDrawTexsvOES(java.nio.ShortBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glDrawTexsvOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.ShortBuffer> %s)",
                   "glDrawTexsvOES", arg0);
    }
  }
  @Override
  public void glDrawTexxOES(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glDrawTexxOES(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glDrawTexxOES", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glDrawTexxvOES(int[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glDrawTexxvOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X)",
                   "glDrawTexxvOES", arg1);
    }
  }
  @Override
  public void glDrawTexxvOES(java.nio.IntBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glDrawTexxvOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s)",
                   "glDrawTexxvOES", arg0);
    }
  }
  @Override
  public void glEGLImageTargetRenderbufferStorageOES(int arg0,long arg1)
  {
    checkContext();
    downstreamGLES1.glEGLImageTargetRenderbufferStorageOES(arg0,arg1);
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
    downstreamGLES1.glEGLImageTargetTexture2DOES(arg0,arg1);
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
    downstreamGLES1.glEnable(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEnable", arg0);
    }
  }
  @Override
  public void glEnableClientState(int arg0)
  {
    checkContext();
    downstreamGLES1.glEnableClientState(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEnableClientState", arg0);
    }
  }
  @Override
  public void glEnableDriverControlQCOM(int arg0)
  {
    checkContext();
    downstreamGLES1.glEnableDriverControlQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEnableDriverControlQCOM", arg0);
    }
  }
  @Override
  public void glEndTilingQCOM(int arg0)
  {
    checkContext();
    downstreamGLES1.glEndTilingQCOM(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glEndTilingQCOM", arg0);
    }
  }
  @Override
  public void glExtGetBufferPointervQCOM(int arg0,com.jogamp.common.nio.PointerBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glExtGetBufferPointervQCOM(arg0,arg1);
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
    downstreamGLES1.glExtGetBuffersQCOM(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glExtGetBuffersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetBuffersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetFramebuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glExtGetFramebuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetFramebuffersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetFramebuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glExtGetFramebuffersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetFramebuffersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,java.nio.ByteBuffer arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES1.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[B>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetProgramBinarySourceQCOM", arg0, arg1, arg3, arg5);
    }
  }
  @Override
  public void glExtGetProgramsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glExtGetProgramsQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetProgramsQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetProgramsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glExtGetProgramsQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetProgramsQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetRenderbuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glExtGetRenderbuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetRenderbuffersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetRenderbuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glExtGetRenderbuffersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetRenderbuffersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetShadersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glExtGetShadersQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetShadersQCOM", arg1, arg2, arg4);
    }
  }
  @Override
  public void glExtGetShadersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glExtGetShadersQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetShadersQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    checkContext();
    downstreamGLES1.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glExtGetTexLevelParameterivQCOM", arg0, arg1, arg2, arg3, arg5);
    }
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    checkContext();
    downstreamGLES1.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glExtGetTexLevelParameterivQCOM", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glExtGetTexSubImageQCOM(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    checkContext();
    downstreamGLES1.glExtGetTexSubImageQCOM(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
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
    downstreamGLES1.glExtGetTexturesQCOM(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glExtGetTexturesQCOM(arg0,arg1,arg2);
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
    boolean _res = downstreamGLES1.glExtIsProgramBinaryQCOM(arg0);
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
    downstreamGLES1.glExtTexObjectStateOverrideiQCOM(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glExtTexObjectStateOverrideiQCOM", arg0, arg1, arg2);
    }
  }
  @Override
  public void glFinish()
  {
    checkContext();
    downstreamGLES1.glFinish();
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
    downstreamGLES1.glFlush();
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
    downstreamGLES1.glFlushMappedBufferRange(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <long> %s)",
                   "glFlushMappedBufferRange", arg0, arg1, arg2);
    }
  }
  @Override
  public void glFogf(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES1.glFogf(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glFogf", arg0, arg1);
    }
  }
  @Override
  public void glFogfv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glFogfv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glFogfv", arg0, arg1);
    }
  }
  @Override
  public void glFogfv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glFogfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glFogfv", arg0, arg2);
    }
  }
  @Override
  public void glFogx(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glFogx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glFogx", arg0, arg1);
    }
  }
  @Override
  public void glFogxv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glFogxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glFogxv", arg0, arg2);
    }
  }
  @Override
  public void glFogxv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glFogxv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glFogxv", arg0, arg1);
    }
  }
  @Override
  public void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferRenderbuffer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glFramebufferTexture2DMultisampleEXT(arg0,arg1,arg2,arg3,arg4,arg5);
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
    downstreamGLES1.glFramebufferTexture2DMultisampleIMG(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFramebufferTexture2DMultisampleIMG", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFrontFace(int arg0)
  {
    checkContext();
    downstreamGLES1.glFrontFace(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glFrontFace", arg0);
    }
  }
  @Override
  public void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
    checkContext();
    downstreamGLES1.glFrustum(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<double> %s, <double> %s, <double> %s, <double> %s, <double> %s, <double> %s)",
                   "glFrustum", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFrustumf(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    checkContext();
    downstreamGLES1.glFrustumf(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glFrustumf", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glFrustumx(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES1.glFrustumx(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glFrustumx", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGenBuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenBuffers", arg0, arg2);
    }
  }
  @Override
  public void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGenBuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenBuffers", arg0, arg1);
    }
  }
  @Override
  public void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGenFramebuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenFramebuffers", arg0, arg1);
    }
  }
  @Override
  public void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGenFramebuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenFramebuffers", arg0, arg2);
    }
  }
  @Override
  public void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGenRenderbuffers(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenRenderbuffers", arg0, arg1);
    }
  }
  @Override
  public void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGenRenderbuffers(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenRenderbuffers", arg0, arg2);
    }
  }
  @Override
  public void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGenTextures(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenTextures", arg0, arg2);
    }
  }
  @Override
  public void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGenTextures(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenTextures", arg0, arg1);
    }
  }
  @Override
  public void glGenVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGenVertexArraysOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGenVertexArraysOES", arg0, arg1);
    }
  }
  @Override
  public void glGenVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGenVertexArraysOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGenVertexArraysOES", arg0, arg2);
    }
  }
  @Override
  public void glGenerateMipmap(int arg0)
  {
    checkContext();
    downstreamGLES1.glGenerateMipmap(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glGenerateMipmap", arg0);
    }
  }
  @Override
  public void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGetBooleanv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[B>, <int> 0x%X)",
                   "glGetBooleanv", arg0, arg2);
    }
  }
  @Override
  public void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGetBooleanv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.ByteBuffer> %s)",
                   "glGetBooleanv", arg0, arg1);
    }
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetBufferParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetBufferParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetBufferParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetClipPlanef(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGetClipPlanef(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetClipPlanef", arg0, arg1);
    }
  }
  @Override
  public void glGetClipPlanef(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGetClipPlanef(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetClipPlanef", arg0, arg2);
    }
  }
  @Override
  public void glGetClipPlanex(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGetClipPlanex(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetClipPlanex", arg0, arg2);
    }
  }
  @Override
  public void glGetClipPlanex(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGetClipPlanex(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetClipPlanex", arg0, arg1);
    }
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    checkContext();
    downstreamGLES1.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
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
    downstreamGLES1.glGetDriverControlsQCOM(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glGetDriverControlsQCOM(arg0,arg1,arg2);
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
    int _res = downstreamGLES1.glGetError();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glGetError");
    }
    return _res;
  }
  @Override
  public void glGetFixedv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGetFixedv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetFixedv", arg0, arg1);
    }
  }
  @Override
  public void glGetFixedv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGetFixedv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetFixedv", arg0, arg2);
    }
  }
  @Override
  public void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGetFloatv(arg0,arg1);
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
    downstreamGLES1.glGetFloatv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetFloatv", arg0, arg2);
    }
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES1.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetFramebufferAttachmentParameteriv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetFramebufferAttachmentParameteriv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public int glGetGraphicsResetStatus()
  {
    checkContext();
    int _res = downstreamGLES1.glGetGraphicsResetStatus();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glGetGraphicsResetStatus");
    }
    return _res;
  }
  @Override
  public void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glGetIntegerv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetIntegerv", arg0, arg1);
    }
  }
  @Override
  public void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glGetIntegerv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetIntegerv", arg0, arg2);
    }
  }
  @Override
  public void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetLightfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetLightfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetLightfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetLightfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetLightxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetLightxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetLightxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetLightxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetLightxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetLightxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetMaterialfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetMaterialfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetMaterialfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetMaterialfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetMaterialxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetMaterialxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetMaterialxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetMaterialxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetMaterialxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetMaterialxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetRenderbufferParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetRenderbufferParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public java.lang.String glGetString(int arg0)
  {
    checkContext();
    java.lang.String _res = downstreamGLES1.glGetString(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glGetString", arg0);
    }
    return _res;
  }
  @Override
  public void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexEnvfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetTexEnvfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexEnvfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetTexEnvfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexEnviv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexEnviv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexEnviv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexEnviv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexEnvxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexEnvxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexEnvxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexEnvxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexEnvxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexEnvxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexGenfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetTexGenfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexGenfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetTexGenfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexGeniv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexGeniv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexGeniv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexGeniv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexGenxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexGenxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexGenxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexGenxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexGenxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexGenxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetTexParameterfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexParameterfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glGetTexParameterfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameterxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glGetTexParameterxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetTexParameterxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glGetTexParameterxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glGetTexParameterxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetTexParameterxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    checkContext();
    downstreamGLES1.glGetnUniformfv(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glGetnUniformfv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glGetnUniformiv", arg0, arg1, arg2, arg4);
    }
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    checkContext();
    downstreamGLES1.glGetnUniformiv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glGetnUniformiv", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glHint(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glHint(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glHint", arg0, arg1);
    }
  }
  @Override
  public boolean glIsBuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES1.glIsBuffer(arg0);
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
    boolean _res = downstreamGLES1.glIsEnabled(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsEnabled", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsFramebuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES1.glIsFramebuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsFramebuffer", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsRenderbuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES1.glIsRenderbuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsRenderbuffer", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsTexture(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES1.glIsTexture(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsTexture", arg0);
    }
    return _res;
  }
  @Override
  public boolean glIsVertexArrayOES(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES1.glIsVertexArrayOES(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glIsVertexArrayOES", arg0);
    }
    return _res;
  }
  @Override
  public void glLightModelf(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES1.glLightModelf(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glLightModelf", arg0, arg1);
    }
  }
  @Override
  public void glLightModelfv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glLightModelfv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glLightModelfv", arg0, arg1);
    }
  }
  @Override
  public void glLightModelfv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glLightModelfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glLightModelfv", arg0, arg2);
    }
  }
  @Override
  public void glLightModelx(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glLightModelx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glLightModelx", arg0, arg1);
    }
  }
  @Override
  public void glLightModelxv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glLightModelxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glLightModelxv", arg0, arg2);
    }
  }
  @Override
  public void glLightModelxv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glLightModelxv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glLightModelxv", arg0, arg1);
    }
  }
  @Override
  public void glLightf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glLightf(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glLightf", arg0, arg1, arg2);
    }
  }
  @Override
  public void glLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glLightfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glLightfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glLightfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glLightfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glLightx(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glLightx(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glLightx", arg0, arg1, arg2);
    }
  }
  @Override
  public void glLightxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glLightxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glLightxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glLightxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glLightxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glLightxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glLineWidth(float arg0)
  {
    checkContext();
    downstreamGLES1.glLineWidth(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glLineWidth", arg0);
    }
  }
  @Override
  public void glLineWidthx(int arg0)
  {
    checkContext();
    downstreamGLES1.glLineWidthx(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glLineWidthx", arg0);
    }
  }
  @Override
  public void glLoadIdentity()
  {
    checkContext();
    downstreamGLES1.glLoadIdentity();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glLoadIdentity");
    }
  }
  @Override
  public void glLoadMatrixf(float[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glLoadMatrixf(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[F>, <int> 0x%X)",
                   "glLoadMatrixf", arg1);
    }
  }
  @Override
  public void glLoadMatrixf(java.nio.FloatBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glLoadMatrixf(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.FloatBuffer> %s)",
                   "glLoadMatrixf", arg0);
    }
  }
  @Override
  public void glLoadMatrixx(java.nio.IntBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glLoadMatrixx(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s)",
                   "glLoadMatrixx", arg0);
    }
  }
  @Override
  public void glLoadMatrixx(int[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glLoadMatrixx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X)",
                   "glLoadMatrixx", arg1);
    }
  }
  @Override
  public void glLoadPaletteFromModelViewMatrixOES()
  {
    checkContext();
    downstreamGLES1.glLoadPaletteFromModelViewMatrixOES();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glLoadPaletteFromModelViewMatrixOES");
    }
  }
  @Override
  public void glLogicOp(int arg0)
  {
    checkContext();
    downstreamGLES1.glLogicOp(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glLogicOp", arg0);
    }
  }
  @Override
  public java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    checkContext();
    java.nio.ByteBuffer _res = downstreamGLES1.glMapBuffer(arg0,arg1);
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
    java.nio.ByteBuffer _res = downstreamGLES1.glMapBufferRange(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <long> %s, <long> %s, <int> 0x%X)",
                   "glMapBufferRange", arg0, arg1, arg2, arg3);
    }
    return _res;
  }
  @Override
  public void glMaterialf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glMaterialf(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glMaterialf", arg0, arg1, arg2);
    }
  }
  @Override
  public void glMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glMaterialfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glMaterialfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glMaterialfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glMaterialfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glMaterialx(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glMaterialx(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glMaterialx", arg0, arg1, arg2);
    }
  }
  @Override
  public void glMaterialxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glMaterialxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glMaterialxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glMaterialxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glMaterialxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glMaterialxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glMatrixIndexPointerOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES1.glMatrixIndexPointerOES(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glMatrixIndexPointerOES", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glMatrixMode(int arg0)
  {
    checkContext();
    downstreamGLES1.glMatrixMode(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glMatrixMode", arg0);
    }
  }
  @Override
  public void glMultMatrixf(java.nio.FloatBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glMultMatrixf(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.FloatBuffer> %s)",
                   "glMultMatrixf", arg0);
    }
  }
  @Override
  public void glMultMatrixf(float[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glMultMatrixf(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[F>, <int> 0x%X)",
                   "glMultMatrixf", arg1);
    }
  }
  @Override
  public void glMultMatrixx(java.nio.IntBuffer arg0)
  {
    checkContext();
    downstreamGLES1.glMultMatrixx(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s)",
                   "glMultMatrixx", arg0);
    }
  }
  @Override
  public void glMultMatrixx(int[] arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glMultMatrixx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X)",
                   "glMultMatrixx", arg1);
    }
  }
  @Override
  public void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    checkContext();
    downstreamGLES1.glMultiTexCoord4f(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glMultiTexCoord4f", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glMultiTexCoord4x(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glMultiTexCoord4x(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glMultiTexCoord4x", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glNormal3f(float arg0,float arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glNormal3f(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s)",
                   "glNormal3f", arg0, arg1, arg2);
    }
  }
  @Override
  public void glNormal3x(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glNormal3x(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glNormal3x", arg0, arg1, arg2);
    }
  }
  @Override
  public void glNormalPointer(int arg0,int arg1,long arg2)
  {
    checkContext();
    downstreamGLES1.glNormalPointer(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <long> %s)",
                   "glNormalPointer", arg0, arg1, arg2);
    }
  }
  @Override
  public void glNormalPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
    checkContext();
    downstreamGLES1.glNormalPointer(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glNormalPointer", arg0, arg1, arg2);
    }
  }
  @Override
  public void glNormalPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    checkContext();
    downstreamGLES1.glNormalPointer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<com.jogamp.opengl.GLArrayData> %s)",
                   "glNormalPointer", arg0);
    }
  }
  @Override
  public void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
    checkContext();
    downstreamGLES1.glOrtho(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<double> %s, <double> %s, <double> %s, <double> %s, <double> %s, <double> %s)",
                   "glOrtho", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glOrthof(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    checkContext();
    downstreamGLES1.glOrthof(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s, <float> %s, <float> %s)",
                   "glOrthof", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glOrthox(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES1.glOrthox(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glOrthox", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glPixelStorei(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glPixelStorei(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPixelStorei", arg0, arg1);
    }
  }
  @Override
  public void glPointParameterf(int arg0,float arg1)
  {
    checkContext();
    downstreamGLES1.glPointParameterf(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <float> %s)",
                   "glPointParameterf", arg0, arg1);
    }
  }
  @Override
  public void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glPointParameterfv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glPointParameterfv", arg0, arg1);
    }
  }
  @Override
  public void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glPointParameterfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[F>, <int> 0x%X)",
                   "glPointParameterfv", arg0, arg2);
    }
  }
  @Override
  public void glPointParameterx(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glPointParameterx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPointParameterx", arg0, arg1);
    }
  }
  @Override
  public void glPointParameterxv(int arg0,int[] arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glPointParameterxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <[I>, <int> 0x%X)",
                   "glPointParameterxv", arg0, arg2);
    }
  }
  @Override
  public void glPointParameterxv(int arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    downstreamGLES1.glPointParameterxv(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glPointParameterxv", arg0, arg1);
    }
  }
  @Override
  public void glPointSize(float arg0)
  {
    checkContext();
    downstreamGLES1.glPointSize(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s)",
                   "glPointSize", arg0);
    }
  }
  @Override
  public void glPointSizePointerOES(int arg0,int arg1,java.nio.Buffer arg2)
  {
    checkContext();
    downstreamGLES1.glPointSizePointerOES(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glPointSizePointerOES", arg0, arg1, arg2);
    }
  }
  @Override
  public void glPointSizex(int arg0)
  {
    checkContext();
    downstreamGLES1.glPointSizex(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glPointSizex", arg0);
    }
  }
  @Override
  public void glPolygonOffset(float arg0,float arg1)
  {
    checkContext();
    downstreamGLES1.glPolygonOffset(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s)",
                   "glPolygonOffset", arg0, arg1);
    }
  }
  @Override
  public void glPolygonOffsetx(int arg0,int arg1)
  {
    checkContext();
    downstreamGLES1.glPolygonOffsetx(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X)",
                   "glPolygonOffsetx", arg0, arg1);
    }
  }
  @Override
  public void glPopMatrix()
  {
    checkContext();
    downstreamGLES1.glPopMatrix();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glPopMatrix");
    }
  }
  @Override
  public void glPushMatrix()
  {
    checkContext();
    downstreamGLES1.glPushMatrix();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glPushMatrix");
    }
  }
  @Override
  public int glQueryMatrixxOES(int[] arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    int _res = downstreamGLES1.glQueryMatrixxOES(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<[I>, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glQueryMatrixxOES", arg1, arg3);
    }
    return _res;
  }
  @Override
  public int glQueryMatrixxOES(java.nio.IntBuffer arg0,java.nio.IntBuffer arg1)
  {
    checkContext();
    int _res = downstreamGLES1.glQueryMatrixxOES(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<java.nio.IntBuffer> %s, <java.nio.IntBuffer> %s)",
                   "glQueryMatrixxOES", arg0, arg1);
    }
    return _res;
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    checkContext();
    downstreamGLES1.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
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
    downstreamGLES1.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
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
    downstreamGLES1.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glReadnPixels", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
    }
  }
  @Override
  public void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glRenderbufferStorage(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glRenderbufferStorageMultisampleEXT(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glRenderbufferStorageMultisampleIMG(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRenderbufferStorageMultisampleIMG", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glResolveMultisampleFramebuffer()
  {
    checkContext();
    downstreamGLES1.glResolveMultisampleFramebuffer();
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s()",
                   "glResolveMultisampleFramebuffer");
    }
  }
  @Override
  public void glRotatef(float arg0,float arg1,float arg2,float arg3)
  {
    checkContext();
    downstreamGLES1.glRotatef(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s, <float> %s)",
                   "glRotatef", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glRotatex(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glRotatex(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glRotatex", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glSampleCoverage(float arg0,boolean arg1)
  {
    checkContext();
    downstreamGLES1.glSampleCoverage(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <boolean> %s)",
                   "glSampleCoverage", arg0, arg1);
    }
  }
  @Override
  public void glSampleCoveragex(int arg0,boolean arg1)
  {
    checkContext();
    downstreamGLES1.glSampleCoveragex(arg0,arg1);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <boolean> %s)",
                   "glSampleCoveragex", arg0, arg1);
    }
  }
  @Override
  public void glScalef(float arg0,float arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glScalef(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s)",
                   "glScalef", arg0, arg1, arg2);
    }
  }
  @Override
  public void glScalex(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glScalex(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glScalex", arg0, arg1, arg2);
    }
  }
  @Override
  public void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glScissor(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glScissor", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glShadeModel(int arg0)
  {
    checkContext();
    downstreamGLES1.glShadeModel(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glShadeModel", arg0);
    }
  }
  @Override
  public void glStartTilingQCOM(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glStartTilingQCOM(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glStencilFunc(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStencilFunc", arg0, arg1, arg2);
    }
  }
  @Override
  public void glStencilMask(int arg0)
  {
    checkContext();
    downstreamGLES1.glStencilMask(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glStencilMask", arg0);
    }
  }
  @Override
  public void glStencilOp(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glStencilOp(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glStencilOp", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES1.glTexCoordPointer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glTexCoordPointer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glTexCoordPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    checkContext();
    downstreamGLES1.glTexCoordPointer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<com.jogamp.opengl.GLArrayData> %s)",
                   "glTexCoordPointer", arg0);
    }
  }
  @Override
  public void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3)
  {
    checkContext();
    downstreamGLES1.glTexCoordPointer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glTexCoordPointer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glTexEnvf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glTexEnvf(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glTexEnvf", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexEnvfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glTexEnvfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexEnvfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glTexEnvfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexEnvi(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glTexEnvi(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexEnvi", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexEnviv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexEnviv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexEnviv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexEnviv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexEnvx(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glTexEnvx(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexEnvx", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexEnvxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexEnvxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexEnvxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexEnvxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexEnvxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexEnvxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexGenf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glTexGenf(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <float> %s)",
                   "glTexGenf", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexGenfv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[F>, <int> 0x%X)",
                   "glTexGenfv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexGenfv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.FloatBuffer> %s)",
                   "glTexGenfv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexGeni(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glTexGeni(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexGeni", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexGeniv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexGeniv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexGeniv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexGeniv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexGenx(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glTexGenx(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexGenx", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexGenxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexGenxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexGenxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexGenxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexGenxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexGenxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    checkContext();
    downstreamGLES1.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
    downstreamGLES1.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glTexImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTexParameterf(int arg0,int arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glTexParameterf(arg0,arg1,arg2);
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
    downstreamGLES1.glTexParameterfv(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glTexParameterfv(arg0,arg1,arg2);
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
    downstreamGLES1.glTexParameteri(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexParameteri", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexParameteriv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexParameteriv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexParameteriv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexParameteriv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexParameterx(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glTexParameterx(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexParameterx", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexParameterxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexParameterxv(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <[I>, <int> 0x%X)",
                   "glTexParameterxv", arg0, arg1, arg3);
    }
  }
  @Override
  public void glTexParameterxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    checkContext();
    downstreamGLES1.glTexParameterxv(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <java.nio.IntBuffer> %s)",
                   "glTexParameterxv", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glTexStorage1D(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexStorage2D", arg0, arg1, arg2, arg3, arg4);
    }
  }
  @Override
  public void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    checkContext();
    downstreamGLES1.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTexStorage3D", arg0, arg1, arg2, arg3, arg4, arg5);
    }
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    checkContext();
    downstreamGLES1.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
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
    downstreamGLES1.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glTexSubImage2D", arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }
  }
  @Override
  public void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    checkContext();
    downstreamGLES1.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
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
    downstreamGLES1.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
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
    downstreamGLES1.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTextureStorage3DEXT", arg0, arg1, arg2, arg3, arg4, arg5, arg6);
    }
  }
  @Override
  public void glTranslatef(float arg0,float arg1,float arg2)
  {
    checkContext();
    downstreamGLES1.glTranslatef(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<float> %s, <float> %s, <float> %s)",
                   "glTranslatef", arg0, arg1, arg2);
    }
  }
  @Override
  public void glTranslatex(int arg0,int arg1,int arg2)
  {
    checkContext();
    downstreamGLES1.glTranslatex(arg0,arg1,arg2);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glTranslatex", arg0, arg1, arg2);
    }
  }
  @Override
  public boolean glUnmapBuffer(int arg0)
  {
    checkContext();
    boolean _res = downstreamGLES1.glUnmapBuffer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X)",
                   "glUnmapBuffer", arg0);
    }
    return _res;
  }
  @Override
  public void glVertexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES1.glVertexPointer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glVertexPointer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glVertexPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    checkContext();
    downstreamGLES1.glVertexPointer(arg0);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<com.jogamp.opengl.GLArrayData> %s)",
                   "glVertexPointer", arg0);
    }
  }
  @Override
  public void glVertexPointer(int arg0,int arg1,int arg2,long arg3)
  {
    checkContext();
    downstreamGLES1.glVertexPointer(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <long> %s)",
                   "glVertexPointer", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    checkContext();
    downstreamGLES1.glViewport(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <int> 0x%X)",
                   "glViewport", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public void glWeightPointerOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    checkContext();
    downstreamGLES1.glWeightPointerOES(arg0,arg1,arg2,arg3);
    final int err = checkGLError();
    if (err != GL_NO_ERROR) {
      writeGLError(err, "%s(<int> 0x%X, <int> 0x%X, <int> 0x%X, <java.nio.Buffer> %s)",
                   "glWeightPointerOES", arg0, arg1, arg2, arg3);
    }
  }
  @Override
  public boolean hasBasicFBOSupport()
  {
    return downstreamGLES1.hasBasicFBOSupport();
  }
  @Override
  public boolean hasFullFBOSupport()
  {
    return downstreamGLES1.hasFullFBOSupport();
  }
  @Override
  public boolean hasGLSL()
  {
    return downstreamGLES1.hasGLSL();
  }
  @Override
  public boolean isExtensionAvailable(java.lang.String arg0)
  {
    return downstreamGLES1.isExtensionAvailable(arg0);
  }
  @Override
  public boolean isFunctionAvailable(java.lang.String arg0)
  {
    return downstreamGLES1.isFunctionAvailable(arg0);
  }
  @Override
  public boolean isGL()
  {
    return true;
  }
  @Override
  public boolean isGL2()
  {
    return downstreamGLES1.isGL2();
  }
  @Override
  public boolean isGL2ES1()
  {
    return downstreamGLES1.isGL2ES1();
  }
  @Override
  public boolean isGL2ES2()
  {
    return downstreamGLES1.isGL2ES2();
  }
  @Override
  public boolean isGL2ES3()
  {
    return downstreamGLES1.isGL2ES3();
  }
  @Override
  public boolean isGL2GL3()
  {
    return downstreamGLES1.isGL2GL3();
  }
  @Override
  public boolean isGL3()
  {
    return downstreamGLES1.isGL3();
  }
  @Override
  public boolean isGL3ES3()
  {
    return downstreamGLES1.isGL3ES3();
  }
  @Override
  public boolean isGL3bc()
  {
    return downstreamGLES1.isGL3bc();
  }
  @Override
  public boolean isGL3core()
  {
    return downstreamGLES1.isGL3core();
  }
  @Override
  public boolean isGL4()
  {
    return downstreamGLES1.isGL4();
  }
  @Override
  public boolean isGL4ES3()
  {
    return downstreamGLES1.isGL4ES3();
  }
  @Override
  public boolean isGL4bc()
  {
    return downstreamGLES1.isGL4bc();
  }
  @Override
  public boolean isGL4core()
  {
    return downstreamGLES1.isGL4core();
  }
  @Override
  public boolean isGLES()
  {
    return downstreamGLES1.isGLES();
  }
  @Override
  public boolean isGLES1()
  {
    return downstreamGLES1.isGLES1();
  }
  @Override
  public boolean isGLES2()
  {
    return downstreamGLES1.isGLES2();
  }
  @Override
  public boolean isGLES2Compatible()
  {
    return downstreamGLES1.isGLES2Compatible();
  }
  @Override
  public boolean isGLES3()
  {
    return downstreamGLES1.isGLES3();
  }
  @Override
  public boolean isGLES31Compatible()
  {
    return downstreamGLES1.isGLES31Compatible();
  }
  @Override
  public boolean isGLES32Compatible()
  {
    return downstreamGLES1.isGLES32Compatible();
  }
  @Override
  public boolean isGLES3Compatible()
  {
    return downstreamGLES1.isGLES3Compatible();
  }
  @Override
  public boolean isGLcore()
  {
    return downstreamGLES1.isGLcore();
  }
  @Override
  public boolean isNPOTTextureAvailable()
  {
    return downstreamGLES1.isNPOTTextureAvailable();
  }
  @Override
  public boolean isTextureFormatBGRA8888Available()
  {
    return downstreamGLES1.isTextureFormatBGRA8888Available();
  }
  @Override
  public boolean isVBOArrayBound()
  {
    return downstreamGLES1.isVBOArrayBound();
  }
  @Override
  public boolean isVBOElementArrayBound()
  {
    return downstreamGLES1.isVBOElementArrayBound();
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBuffer(int arg0,int arg1)
  {
    checkContext();
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES1.mapBuffer(arg0,arg1);
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
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES1.mapBufferRange(arg0,arg1,arg2,arg3);
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
    downstreamGLES1.setSwapInterval(arg0);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("DebugGLES1 [this 0x"+Integer.toHexString(hashCode())+" implementing com.jogamp.opengl.GLES1,\n\t");
    sb.append(" downstream: "+downstreamGLES1.toString()+"\n\t]");
    return sb.toString();
  }
  private int checkGLError() {
    return downstreamGLES1.glGetError();
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
    } while ((--recursionDepth >= 0) && (err = downstreamGLES1.glGetError()) != GL_NO_ERROR);
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

  private GLES1 downstreamGLES1;
} // end class DebugGLES1
