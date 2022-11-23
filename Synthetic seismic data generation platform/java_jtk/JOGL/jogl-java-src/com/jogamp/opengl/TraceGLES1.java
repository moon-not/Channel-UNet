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
public class TraceGLES1 implements com.jogamp.opengl.GL2ES1, com.jogamp.opengl.GLES1{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("TraceGLES1");
  public TraceGLES1(GLES1 downstreamGLES1, PrintStream stream)
  {
    if (downstreamGLES1 == null) {
      throw new IllegalArgumentException("null downstreamGLES1");
    }
    this.downstreamGLES1 = downstreamGLES1;
    this.stream = stream;
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
    printIndent();
    print(    "glActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glActiveTexture(arg0);
    println("");
  }
  @Override
  public void glAlphaFunc(int arg0,float arg1)
  {
    printIndent();
    print(    "glAlphaFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES1.glAlphaFunc(arg0,arg1);
    println("");
  }
  @Override
  public void glAlphaFuncx(int arg0,int arg1)
  {
    printIndent();
    print(    "glAlphaFuncx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glAlphaFuncx(arg0,arg1);
    println("");
  }
  @Override
  public void glBindBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glBindBuffer(arg0,arg1);
    println("");
  }
  @Override
  public void glBindFramebuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glBindFramebuffer(arg0,arg1);
    println("");
  }
  @Override
  public void glBindRenderbuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glBindRenderbuffer(arg0,arg1);
    println("");
  }
  @Override
  public void glBindTexture(int arg0,int arg1)
  {
    printIndent();
    print(    "glBindTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glBindTexture(arg0,arg1);
    println("");
  }
  @Override
  public void glBindVertexArrayOES(int arg0)
  {
    printIndent();
    print(    "glBindVertexArrayOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glBindVertexArrayOES(arg0);
    println("");
  }
  @Override
  public void glBlendEquation(int arg0)
  {
    printIndent();
    print(    "glBlendEquation("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glBlendEquation(arg0);
    println("");
  }
  @Override
  public void glBlendEquationSeparate(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendEquationSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glBlendEquationSeparate(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendFunc(int arg0,int arg1)
  {
    printIndent();
    print(    "glBlendFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glBlendFunc(arg0,arg1);
    println("");
  }
  @Override
  public void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glBlendFuncSeparate("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    printIndent();
    print(    "glBufferData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<java.nio.Buffer> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glBufferData(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glBufferSubData("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glBufferSubData(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public int glCheckFramebufferStatus(int arg0)
  {
    printIndent();
    print(    "glCheckFramebufferStatus("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    int _res = downstreamGLES1.glCheckFramebufferStatus(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glClear(int arg0)
  {
    printIndent();
    print(    "glClear("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glClear(arg0);
    println("");
  }
  @Override
  public void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glClearColor("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES1.glClearColor(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearColorx(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glClearColorx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glClearColorx(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glClearDepth(double arg0)
  {
    printIndent();
    print(    "glClearDepth("+"<double> "+arg0+")");
    downstreamGLES1.glClearDepth(arg0);
    println("");
  }
  @Override
  public void glClearDepthf(float arg0)
  {
    printIndent();
    print(    "glClearDepthf("+"<float> "+arg0+")");
    downstreamGLES1.glClearDepthf(arg0);
    println("");
  }
  @Override
  public void glClearDepthx(int arg0)
  {
    printIndent();
    print(    "glClearDepthx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glClearDepthx(arg0);
    println("");
  }
  @Override
  public void glClearStencil(int arg0)
  {
    printIndent();
    print(    "glClearStencil("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glClearStencil(arg0);
    println("");
  }
  @Override
  public void glClientActiveTexture(int arg0)
  {
    printIndent();
    print(    "glClientActiveTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glClientActiveTexture(arg0);
    println("");
  }
  @Override
  public void glClipPlanef(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glClipPlanef("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glClipPlanef(arg0,arg1);
    println("");
  }
  @Override
  public void glClipPlanef(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glClipPlanef("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glClipPlanef(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glClipPlanefIMG(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glClipPlanefIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glClipPlanefIMG(arg0,arg1);
    println("");
  }
  @Override
  public void glClipPlanefIMG(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glClipPlanefIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glClipPlanefIMG(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glClipPlanex(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glClipPlanex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glClipPlanex(arg0,arg1);
    println("");
  }
  @Override
  public void glClipPlanex(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glClipPlanex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glClipPlanex(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glClipPlanexIMG(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glClipPlanexIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glClipPlanexIMG(arg0,arg1);
    println("");
  }
  @Override
  public void glClipPlanexIMG(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glClipPlanexIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glClipPlanexIMG(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glColor4f(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glColor4f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES1.glColor4f(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3)
  {
    printIndent();
    print(    "glColor4ub("+"<byte> "+arg0+", "+"<byte> "+arg1+", "+"<byte> "+arg2+", "+"<byte> "+arg3+")");
    downstreamGLES1.glColor4ub(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glColor4x(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glColor4x("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glColor4x(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    printIndent();
    print(    "glColorMask("+"<boolean> "+arg0+", "+"<boolean> "+arg1+", "+"<boolean> "+arg2+", "+"<boolean> "+arg3+")");
    downstreamGLES1.glColorMask(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glColorPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glColorPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glColorPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glColorPointer("+"<com.jogamp.opengl.GLArrayData> "+arg0+")");
    downstreamGLES1.glColorPointer(arg0);
    println("");
  }
  @Override
  public void glColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glColorPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
    downstreamGLES1.glColorPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
    downstreamGLES1.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    printIndent();
    print(    "glCompressedTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<long> "+arg7+")");
    downstreamGLES1.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES1.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glCompressedTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES1.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES1.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    printIndent();
    print(    "glCopyTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+")");
    downstreamGLES1.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glCopyTextureLevelsAPPLE(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glCopyTextureLevelsAPPLE("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glCopyTextureLevelsAPPLE(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glCullFace(int arg0)
  {
    printIndent();
    print(    "glCullFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glCullFace(arg0);
    println("");
  }
  @Override
  public void glCurrentPaletteMatrixOES(int arg0)
  {
    printIndent();
    print(    "glCurrentPaletteMatrixOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glCurrentPaletteMatrixOES(arg0);
    println("");
  }
  @Override
  public void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glDeleteBuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glDeleteBuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glDeleteFramebuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glDeleteFramebuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glDeleteRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glDeleteRenderbuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glDeleteTextures(arg0,arg1);
    println("");
  }
  @Override
  public void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glDeleteTextures(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glDeleteVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glDeleteVertexArraysOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDeleteVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glDeleteVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glDeleteVertexArraysOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDepthFunc(int arg0)
  {
    printIndent();
    print(    "glDepthFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glDepthFunc(arg0);
    println("");
  }
  @Override
  public void glDepthMask(boolean arg0)
  {
    printIndent();
    print(    "glDepthMask("+"<boolean> "+arg0+")");
    downstreamGLES1.glDepthMask(arg0);
    println("");
  }
  @Override
  public void glDepthRange(double arg0,double arg1)
  {
    printIndent();
    print(    "glDepthRange("+"<double> "+arg0+", "+"<double> "+arg1+")");
    downstreamGLES1.glDepthRange(arg0,arg1);
    println("");
  }
  @Override
  public void glDepthRangef(float arg0,float arg1)
  {
    printIndent();
    print(    "glDepthRangef("+"<float> "+arg0+", "+"<float> "+arg1+")");
    downstreamGLES1.glDepthRangef(arg0,arg1);
    println("");
  }
  @Override
  public void glDepthRangex(int arg0,int arg1)
  {
    printIndent();
    print(    "glDepthRangex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glDepthRangex(arg0,arg1);
    println("");
  }
  @Override
  public void glDisable(int arg0)
  {
    printIndent();
    print(    "glDisable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glDisable(arg0);
    println("");
  }
  @Override
  public void glDisableClientState(int arg0)
  {
    printIndent();
    print(    "glDisableClientState("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glDisableClientState(arg0);
    println("");
  }
  @Override
  public void glDisableDriverControlQCOM(int arg0)
  {
    printIndent();
    print(    "glDisableDriverControlQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glDisableDriverControlQCOM(arg0);
    println("");
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glDiscardFramebufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glDiscardFramebufferEXT(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDiscardFramebufferEXT(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glDiscardFramebufferEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glDiscardFramebufferEXT(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawArrays(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glDrawArrays("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glDrawArrays(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
    downstreamGLES1.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glDrawElements("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glDrawElements(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glDrawTexfOES(float arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glDrawTexfOES("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
    downstreamGLES1.glDrawTexfOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawTexfvOES(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTexfvOES("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glDrawTexfvOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawTexfvOES(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glDrawTexfvOES("+"<java.nio.FloatBuffer> "+arg0+")");
    downstreamGLES1.glDrawTexfvOES(arg0);
    println("");
  }
  @Override
  public void glDrawTexiOES(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glDrawTexiOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glDrawTexiOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawTexivOES(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glDrawTexivOES("+"<java.nio.IntBuffer> "+arg0+")");
    downstreamGLES1.glDrawTexivOES(arg0);
    println("");
  }
  @Override
  public void glDrawTexivOES(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTexivOES("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glDrawTexivOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawTexsOES(short arg0,short arg1,short arg2,short arg3,short arg4)
  {
    printIndent();
    print(    "glDrawTexsOES("+"<short> "+arg0+", "+"<short> "+arg1+", "+"<short> "+arg2+", "+"<short> "+arg3+", "+"<short> "+arg4+")");
    downstreamGLES1.glDrawTexsOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawTexsvOES(short[] arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTexsvOES("+"<[S>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glDrawTexsvOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawTexsvOES(java.nio.ShortBuffer arg0)
  {
    printIndent();
    print(    "glDrawTexsvOES("+"<java.nio.ShortBuffer> "+arg0+")");
    downstreamGLES1.glDrawTexsvOES(arg0);
    println("");
  }
  @Override
  public void glDrawTexxOES(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glDrawTexxOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glDrawTexxOES(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glDrawTexxvOES(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glDrawTexxvOES("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glDrawTexxvOES(arg0,arg1);
    println("");
  }
  @Override
  public void glDrawTexxvOES(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glDrawTexxvOES("+"<java.nio.IntBuffer> "+arg0+")");
    downstreamGLES1.glDrawTexxvOES(arg0);
    println("");
  }
  @Override
  public void glEGLImageTargetRenderbufferStorageOES(int arg0,long arg1)
  {
    printIndent();
    print(    "glEGLImageTargetRenderbufferStorageOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
    downstreamGLES1.glEGLImageTargetRenderbufferStorageOES(arg0,arg1);
    println("");
  }
  @Override
  public void glEGLImageTargetTexture2DOES(int arg0,long arg1)
  {
    printIndent();
    print(    "glEGLImageTargetTexture2DOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+")");
    downstreamGLES1.glEGLImageTargetTexture2DOES(arg0,arg1);
    println("");
  }
  @Override
  public void glEnable(int arg0)
  {
    printIndent();
    print(    "glEnable("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glEnable(arg0);
    println("");
  }
  @Override
  public void glEnableClientState(int arg0)
  {
    printIndent();
    print(    "glEnableClientState("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glEnableClientState(arg0);
    println("");
  }
  @Override
  public void glEnableDriverControlQCOM(int arg0)
  {
    printIndent();
    print(    "glEnableDriverControlQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glEnableDriverControlQCOM(arg0);
    println("");
  }
  @Override
  public void glEndTilingQCOM(int arg0)
  {
    printIndent();
    print(    "glEndTilingQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glEndTilingQCOM(arg0);
    println("");
  }
  @Override
  public void glExtGetBufferPointervQCOM(int arg0,com.jogamp.common.nio.PointerBuffer arg1)
  {
    printIndent();
    print(    "glExtGetBufferPointervQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<com.jogamp.common.nio.PointerBuffer> "+arg1+")");
    downstreamGLES1.glExtGetBufferPointervQCOM(arg0,arg1);
    println("");
  }
  @Override
  public void glExtGetBuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetBuffersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glExtGetBuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetBuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetBuffersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glExtGetBuffersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetFramebuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetFramebuffersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glExtGetFramebuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetFramebuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetFramebuffersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glExtGetFramebuffersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,java.nio.ByteBuffer arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glExtGetProgramBinarySourceQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg2+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES1.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glExtGetProgramBinarySourceQCOM(int arg0,int arg1,byte[] arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glExtGetProgramBinarySourceQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glExtGetProgramBinarySourceQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glExtGetProgramsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetProgramsQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glExtGetProgramsQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetProgramsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetProgramsQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glExtGetProgramsQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetRenderbuffersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetRenderbuffersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glExtGetRenderbuffersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetRenderbuffersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetRenderbuffersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glExtGetRenderbuffersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetShadersQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetShadersQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glExtGetShadersQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetShadersQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetShadersQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glExtGetShadersQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,int[] arg4,int arg5)
  {
    printIndent();
    print(    "glExtGetTexLevelParameterivQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glExtGetTexLevelParameterivQCOM(int arg0,int arg1,int arg2,int arg3,java.nio.IntBuffer arg4)
  {
    printIndent();
    print(    "glExtGetTexLevelParameterivQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg4+")");
    downstreamGLES1.glExtGetTexLevelParameterivQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetTexSubImageQCOM(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,int arg8,int arg9,java.nio.Buffer arg10)
  {
    printIndent();
    print(    "glExtGetTexSubImageQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg8).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg9).toUpperCase()+", "+"<java.nio.Buffer> "+arg10+")");
    downstreamGLES1.glExtGetTexSubImageQCOM(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8,arg9,arg10);
    println("");
  }
  @Override
  public void glExtGetTexturesQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glExtGetTexturesQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glExtGetTexturesQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glExtGetTexturesQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glExtGetTexturesQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glExtGetTexturesQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public boolean glExtIsProgramBinaryQCOM(int arg0)
  {
    printIndent();
    print(    "glExtIsProgramBinaryQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glExtIsProgramBinaryQCOM(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glExtTexObjectStateOverrideiQCOM(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glExtTexObjectStateOverrideiQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glExtTexObjectStateOverrideiQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glFinish()
  {
    printIndent();
    print(    "glFinish("+")");
    downstreamGLES1.glFinish();
    println("");
  }
  @Override
  public void glFlush()
  {
    printIndent();
    print(    "glFlush("+")");
    downstreamGLES1.glFlush();
    println("");
  }
  @Override
  public void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
    printIndent();
    print(    "glFlushMappedBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+")");
    downstreamGLES1.glFlushMappedBufferRange(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glFogf(int arg0,float arg1)
  {
    printIndent();
    print(    "glFogf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES1.glFogf(arg0,arg1);
    println("");
  }
  @Override
  public void glFogfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glFogfv(arg0,arg1);
    println("");
  }
  @Override
  public void glFogfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glFogfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glFogx(int arg0,int arg1)
  {
    printIndent();
    print(    "glFogx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glFogx(arg0,arg1);
    println("");
  }
  @Override
  public void glFogxv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glFogxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glFogxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glFogxv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glFogxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glFogxv(arg0,arg1);
    println("");
  }
  @Override
  public void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glFramebufferRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glFramebufferTexture2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glFramebufferTexture2DMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture2DMultisampleEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glFramebufferTexture2DMultisampleEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFramebufferTexture2DMultisampleIMG(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFramebufferTexture2DMultisampleIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glFramebufferTexture2DMultisampleIMG(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFrontFace(int arg0)
  {
    printIndent();
    print(    "glFrontFace("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glFrontFace(arg0);
    println("");
  }
  @Override
  public void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glFrustum("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
    downstreamGLES1.glFrustum(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFrustumf(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glFrustumf("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
    downstreamGLES1.glFrustumf(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glFrustumx(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glFrustumx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glFrustumx(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGenBuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenBuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGenBuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGenFramebuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenFramebuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGenFramebuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGenRenderbuffers(arg0,arg1);
    println("");
  }
  @Override
  public void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenRenderbuffers("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGenRenderbuffers(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGenTextures(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenTextures("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGenTextures(arg0,arg1);
    println("");
  }
  @Override
  public void glGenVertexArraysOES(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGenVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGenVertexArraysOES(arg0,arg1);
    println("");
  }
  @Override
  public void glGenVertexArraysOES(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGenVertexArraysOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGenVertexArraysOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGenerateMipmap(int arg0)
  {
    printIndent();
    print(    "glGenerateMipmap("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glGenerateMipmap(arg0);
    println("");
  }
  @Override
  public void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGetBooleanv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    printIndent();
    print(    "glGetBooleanv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.ByteBuffer> "+arg1+")");
    downstreamGLES1.glGetBooleanv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetBufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetBufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetClipPlanef(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetClipPlanef("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glGetClipPlanef(arg0,arg1);
    println("");
  }
  @Override
  public void glGetClipPlanef(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetClipPlanef("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGetClipPlanef(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetClipPlanex(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetClipPlanex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGetClipPlanex(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetClipPlanex(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetClipPlanex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGetClipPlanex(arg0,arg1);
    println("");
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,java.nio.IntBuffer arg2,java.nio.ByteBuffer arg3)
  {
    printIndent();
    print(    "glGetDriverControlStringQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+", "+"<java.nio.ByteBuffer> "+arg3+")");
    downstreamGLES1.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetDriverControlStringQCOM(int arg0,int arg1,int[] arg2,int arg3,byte[] arg4,int arg5)
  {
    printIndent();
    print(    "glGetDriverControlStringQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<[B>"+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glGetDriverControlStringQCOM(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glGetDriverControlsQCOM(int[] arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetDriverControlsQCOM("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glGetDriverControlsQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetDriverControlsQCOM(java.nio.IntBuffer arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetDriverControlsQCOM("+"<java.nio.IntBuffer> "+arg0+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetDriverControlsQCOM(arg0,arg1,arg2);
    println("");
  }
  @Override
  public int glGetError()
  {
    printIndent();
    print(    "glGetError("+")");
    int _res = downstreamGLES1.glGetError();
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetFixedv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetFixedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGetFixedv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetFixedv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetFixedv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGetFixedv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glGetFloatv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetFloatv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGetFloatv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES1.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetFramebufferAttachmentParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public int glGetGraphicsResetStatus()
  {
    printIndent();
    print(    "glGetGraphicsResetStatus("+")");
    int _res = downstreamGLES1.glGetGraphicsResetStatus();
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glGetIntegerv(arg0,arg1);
    println("");
  }
  @Override
  public void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glGetIntegerv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glGetIntegerv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glGetLightfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetLightfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetLightxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetLightxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetLightxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetLightxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetLightxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetLightxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetMaterialfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glGetMaterialfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetMaterialxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetMaterialxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetMaterialxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetMaterialxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetMaterialxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetMaterialxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetRenderbufferParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetRenderbufferParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public java.lang.String glGetString(int arg0)
  {
    printIndent();
    print(    "glGetString("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    java.lang.String _res = downstreamGLES1.glGetString(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glGetTexEnvfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexEnvfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexEnviv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetTexEnviv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexEnvxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexEnvxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetTexEnvxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexEnvxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexEnvxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexEnvxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glGetTexGenfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexGenfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexGeniv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetTexGeniv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexGenxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexGenxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetTexGenxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexGenxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexGenxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexGenxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glGetTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameterxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glGetTexParameterxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glGetTexParameterxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glGetTexParameterxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glGetTexParameterxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glGetTexParameterxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg3+")");
    downstreamGLES1.glGetnUniformfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    printIndent();
    print(    "glGetnUniformiv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg3+")");
    downstreamGLES1.glGetnUniformiv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glHint(int arg0,int arg1)
  {
    printIndent();
    print(    "glHint("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glHint(arg0,arg1);
    println("");
  }
  @Override
  public boolean glIsBuffer(int arg0)
  {
    printIndent();
    print(    "glIsBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glIsBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsEnabled(int arg0)
  {
    printIndent();
    print(    "glIsEnabled("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glIsEnabled(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsFramebuffer(int arg0)
  {
    printIndent();
    print(    "glIsFramebuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glIsFramebuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsRenderbuffer(int arg0)
  {
    printIndent();
    print(    "glIsRenderbuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glIsRenderbuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsTexture(int arg0)
  {
    printIndent();
    print(    "glIsTexture("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glIsTexture(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public boolean glIsVertexArrayOES(int arg0)
  {
    printIndent();
    print(    "glIsVertexArrayOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glIsVertexArrayOES(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glLightModelf(int arg0,float arg1)
  {
    printIndent();
    print(    "glLightModelf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES1.glLightModelf(arg0,arg1);
    println("");
  }
  @Override
  public void glLightModelfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glLightModelfv(arg0,arg1);
    println("");
  }
  @Override
  public void glLightModelfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glLightModelfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glLightModelx(int arg0,int arg1)
  {
    printIndent();
    print(    "glLightModelx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glLightModelx(arg0,arg1);
    println("");
  }
  @Override
  public void glLightModelxv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glLightModelxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glLightModelxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glLightModelxv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glLightModelxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glLightModelxv(arg0,arg1);
    println("");
  }
  @Override
  public void glLightf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glLightf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES1.glLightf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glLightfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glLightfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glLightx(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glLightx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glLightx(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glLightxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glLightxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glLightxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glLightxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glLightxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glLightxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glLineWidth(float arg0)
  {
    printIndent();
    print(    "glLineWidth("+"<float> "+arg0+")");
    downstreamGLES1.glLineWidth(arg0);
    println("");
  }
  @Override
  public void glLineWidthx(int arg0)
  {
    printIndent();
    print(    "glLineWidthx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glLineWidthx(arg0);
    println("");
  }
  @Override
  public void glLoadIdentity()
  {
    printIndent();
    print(    "glLoadIdentity("+")");
    downstreamGLES1.glLoadIdentity();
    println("");
  }
  @Override
  public void glLoadMatrixf(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glLoadMatrixf("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glLoadMatrixf(arg0,arg1);
    println("");
  }
  @Override
  public void glLoadMatrixf(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glLoadMatrixf("+"<java.nio.FloatBuffer> "+arg0+")");
    downstreamGLES1.glLoadMatrixf(arg0);
    println("");
  }
  @Override
  public void glLoadMatrixx(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glLoadMatrixx("+"<java.nio.IntBuffer> "+arg0+")");
    downstreamGLES1.glLoadMatrixx(arg0);
    println("");
  }
  @Override
  public void glLoadMatrixx(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glLoadMatrixx("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glLoadMatrixx(arg0,arg1);
    println("");
  }
  @Override
  public void glLoadPaletteFromModelViewMatrixOES()
  {
    printIndent();
    print(    "glLoadPaletteFromModelViewMatrixOES("+")");
    downstreamGLES1.glLoadPaletteFromModelViewMatrixOES();
    println("");
  }
  @Override
  public void glLogicOp(int arg0)
  {
    printIndent();
    print(    "glLogicOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glLogicOp(arg0);
    println("");
  }
  @Override
  public java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    printIndent();
    print(    "glMapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGLES1.glMapBuffer(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "glMapBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    java.nio.ByteBuffer _res = downstreamGLES1.glMapBufferRange(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glMaterialf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glMaterialf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES1.glMaterialf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glMaterialfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glMaterialfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glMaterialx(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glMaterialx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glMaterialx(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glMaterialxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glMaterialxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glMaterialxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glMaterialxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glMaterialxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glMaterialxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glMatrixIndexPointerOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glMatrixIndexPointerOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glMatrixIndexPointerOES(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glMatrixMode(int arg0)
  {
    printIndent();
    print(    "glMatrixMode("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glMatrixMode(arg0);
    println("");
  }
  @Override
  public void glMultMatrixf(java.nio.FloatBuffer arg0)
  {
    printIndent();
    print(    "glMultMatrixf("+"<java.nio.FloatBuffer> "+arg0+")");
    downstreamGLES1.glMultMatrixf(arg0);
    println("");
  }
  @Override
  public void glMultMatrixf(float[] arg0,int arg1)
  {
    printIndent();
    print(    "glMultMatrixf("+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glMultMatrixf(arg0,arg1);
    println("");
  }
  @Override
  public void glMultMatrixx(java.nio.IntBuffer arg0)
  {
    printIndent();
    print(    "glMultMatrixx("+"<java.nio.IntBuffer> "+arg0+")");
    downstreamGLES1.glMultMatrixx(arg0);
    println("");
  }
  @Override
  public void glMultMatrixx(int[] arg0,int arg1)
  {
    printIndent();
    print(    "glMultMatrixx("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glMultMatrixx(arg0,arg1);
    println("");
  }
  @Override
  public void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")");
    downstreamGLES1.glMultiTexCoord4f(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glMultiTexCoord4x(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glMultiTexCoord4x("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glMultiTexCoord4x(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glNormal3f(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glNormal3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
    downstreamGLES1.glNormal3f(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glNormal3x(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glNormal3x("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glNormal3x(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glNormalPointer(int arg0,int arg1,long arg2)
  {
    printIndent();
    print(    "glNormalPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<long> "+arg2+")");
    downstreamGLES1.glNormalPointer(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glNormalPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glNormalPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
    downstreamGLES1.glNormalPointer(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glNormalPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glNormalPointer("+"<com.jogamp.opengl.GLArrayData> "+arg0+")");
    downstreamGLES1.glNormalPointer(arg0);
    println("");
  }
  @Override
  public void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
    printIndent();
    print(    "glOrtho("+"<double> "+arg0+", "+"<double> "+arg1+", "+"<double> "+arg2+", "+"<double> "+arg3+", "+"<double> "+arg4+", "+"<double> "+arg5+")");
    downstreamGLES1.glOrtho(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glOrthof(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
    printIndent();
    print(    "glOrthof("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+", "+"<float> "+arg5+")");
    downstreamGLES1.glOrthof(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glOrthox(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glOrthox("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glOrthox(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glPixelStorei(int arg0,int arg1)
  {
    printIndent();
    print(    "glPixelStorei("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glPixelStorei(arg0,arg1);
    println("");
  }
  @Override
  public void glPointParameterf(int arg0,float arg1)
  {
    printIndent();
    print(    "glPointParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")");
    downstreamGLES1.glPointParameterf(arg0,arg1);
    println("");
  }
  @Override
  public void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
    printIndent();
    print(    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")");
    downstreamGLES1.glPointParameterfv(arg0,arg1);
    println("");
  }
  @Override
  public void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
    printIndent();
    print(    "glPointParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glPointParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glPointParameterx(int arg0,int arg1)
  {
    printIndent();
    print(    "glPointParameterx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glPointParameterx(arg0,arg1);
    println("");
  }
  @Override
  public void glPointParameterxv(int arg0,int[] arg1,int arg2)
  {
    printIndent();
    print(    "glPointParameterxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glPointParameterxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glPointParameterxv(int arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glPointParameterxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg1+")");
    downstreamGLES1.glPointParameterxv(arg0,arg1);
    println("");
  }
  @Override
  public void glPointSize(float arg0)
  {
    printIndent();
    print(    "glPointSize("+"<float> "+arg0+")");
    downstreamGLES1.glPointSize(arg0);
    println("");
  }
  @Override
  public void glPointSizePointerOES(int arg0,int arg1,java.nio.Buffer arg2)
  {
    printIndent();
    print(    "glPointSizePointerOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.Buffer> "+arg2+")");
    downstreamGLES1.glPointSizePointerOES(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glPointSizex(int arg0)
  {
    printIndent();
    print(    "glPointSizex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glPointSizex(arg0);
    println("");
  }
  @Override
  public void glPolygonOffset(float arg0,float arg1)
  {
    printIndent();
    print(    "glPolygonOffset("+"<float> "+arg0+", "+"<float> "+arg1+")");
    downstreamGLES1.glPolygonOffset(arg0,arg1);
    println("");
  }
  @Override
  public void glPolygonOffsetx(int arg0,int arg1)
  {
    printIndent();
    print(    "glPolygonOffsetx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    downstreamGLES1.glPolygonOffsetx(arg0,arg1);
    println("");
  }
  @Override
  public void glPopMatrix()
  {
    printIndent();
    print(    "glPopMatrix("+")");
    downstreamGLES1.glPopMatrix();
    println("");
  }
  @Override
  public void glPushMatrix()
  {
    printIndent();
    print(    "glPushMatrix("+")");
    downstreamGLES1.glPushMatrix();
    println("");
  }
  @Override
  public int glQueryMatrixxOES(int[] arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glQueryMatrixxOES("+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    int _res = downstreamGLES1.glQueryMatrixxOES(arg0,arg1,arg2,arg3);
    println(" = "+_res);
    return _res;
  }
  @Override
  public int glQueryMatrixxOES(java.nio.IntBuffer arg0,java.nio.IntBuffer arg1)
  {
    printIndent();
    print(    "glQueryMatrixxOES("+"<java.nio.IntBuffer> "+arg0+", "+"<java.nio.IntBuffer> "+arg1+")");
    int _res = downstreamGLES1.glQueryMatrixxOES(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<long> "+arg6+")");
    downstreamGLES1.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    printIndent();
    print(    "glReadPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<java.nio.Buffer> "+arg6+")");
    downstreamGLES1.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    printIndent();
    print(    "glReadnPixels("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<java.nio.Buffer> "+arg7+")");
    downstreamGLES1.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
    println("");
  }
  @Override
  public void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRenderbufferStorage("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glRenderbufferStorage(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisample("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisampleEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisampleEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glRenderbufferStorageMultisampleEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glRenderbufferStorageMultisampleIMG(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glRenderbufferStorageMultisampleIMG("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glRenderbufferStorageMultisampleIMG(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glResolveMultisampleFramebuffer()
  {
    printIndent();
    print(    "glResolveMultisampleFramebuffer("+")");
    downstreamGLES1.glResolveMultisampleFramebuffer();
    println("");
  }
  @Override
  public void glRotatef(float arg0,float arg1,float arg2,float arg3)
  {
    printIndent();
    print(    "glRotatef("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+")");
    downstreamGLES1.glRotatef(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glRotatex(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glRotatex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glRotatex(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glSampleCoverage(float arg0,boolean arg1)
  {
    printIndent();
    print(    "glSampleCoverage("+"<float> "+arg0+", "+"<boolean> "+arg1+")");
    downstreamGLES1.glSampleCoverage(arg0,arg1);
    println("");
  }
  @Override
  public void glSampleCoveragex(int arg0,boolean arg1)
  {
    printIndent();
    print(    "glSampleCoveragex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<boolean> "+arg1+")");
    downstreamGLES1.glSampleCoveragex(arg0,arg1);
    println("");
  }
  @Override
  public void glScalef(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glScalef("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
    downstreamGLES1.glScalef(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glScalex(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glScalex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glScalex(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glScissor("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glScissor(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glShadeModel(int arg0)
  {
    printIndent();
    print(    "glShadeModel("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glShadeModel(arg0);
    println("");
  }
  @Override
  public void glStartTilingQCOM(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glStartTilingQCOM("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glStartTilingQCOM(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glStencilFunc(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilFunc("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glStencilFunc(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glStencilMask(int arg0)
  {
    printIndent();
    print(    "glStencilMask("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    downstreamGLES1.glStencilMask(arg0);
    println("");
  }
  @Override
  public void glStencilOp(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glStencilOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glStencilOp(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glTexCoordPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glTexCoordPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexCoordPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glTexCoordPointer("+"<com.jogamp.opengl.GLArrayData> "+arg0+")");
    downstreamGLES1.glTexCoordPointer(arg0);
    println("");
  }
  @Override
  public void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glTexCoordPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
    downstreamGLES1.glTexCoordPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexEnvf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexEnvf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES1.glTexEnvf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glTexEnvfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexEnvfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexEnvi(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexEnvi("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTexEnvi(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexEnviv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glTexEnviv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexEnvx(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexEnvx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTexEnvx(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexEnvxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexEnvxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glTexEnvxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexEnvxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexEnvxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexEnvxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexGenf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexGenf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES1.glTexGenf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexGenfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexGenfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexGenfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexGenfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glTexGenfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexGeni(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexGeni("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTexGeni(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexGeniv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexGeniv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexGeniv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexGeniv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glTexGeniv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexGenx(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexGenx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTexGenx(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexGenxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexGenxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glTexGenxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexGenxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexGenxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexGenxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES1.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES1.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexParameterf(int arg0,int arg1,float arg2)
  {
    printIndent();
    print(    "glTexParameterf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")");
    downstreamGLES1.glTexParameterf(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexParameterfv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")");
    downstreamGLES1.glTexParameterfv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameteri(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexParameteri("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTexParameteri(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glTexParameteriv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameteriv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexParameteriv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameterx(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTexParameterx("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTexParameterx(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexParameterxv(int arg0,int arg1,int[] arg2,int arg3)
  {
    printIndent();
    print(    "glTexParameterxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexParameterxv(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexParameterxv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    printIndent();
    print(    "glTexParameterxv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")");
    downstreamGLES1.glTexParameterxv(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glTexStorage1D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glTexStorage1D(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTexStorage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTexStorage3D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<java.nio.Buffer> "+arg8+")");
    downstreamGLES1.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    printIndent();
    print(    "glTexSubImage2D("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg7).toUpperCase()+", "+"<long> "+arg8+")");
    downstreamGLES1.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
    println("");
  }
  @Override
  public void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    printIndent();
    print(    "glTextureStorage1DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+")");
    downstreamGLES1.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
    println("");
  }
  @Override
  public void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    printIndent();
    print(    "glTextureStorage2DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+")");
    downstreamGLES1.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
    println("");
  }
  @Override
  public void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    printIndent();
    print(    "glTextureStorage3DEXT("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg4).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg5).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg6).toUpperCase()+")");
    downstreamGLES1.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
    println("");
  }
  @Override
  public void glTranslatef(float arg0,float arg1,float arg2)
  {
    printIndent();
    print(    "glTranslatef("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")");
    downstreamGLES1.glTranslatef(arg0,arg1,arg2);
    println("");
  }
  @Override
  public void glTranslatex(int arg0,int arg1,int arg2)
  {
    printIndent();
    print(    "glTranslatex("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")");
    downstreamGLES1.glTranslatex(arg0,arg1,arg2);
    println("");
  }
  @Override
  public boolean glUnmapBuffer(int arg0)
  {
    printIndent();
    print(    "glUnmapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")");
    boolean _res = downstreamGLES1.glUnmapBuffer(arg0);
    println(" = "+_res);
    return _res;
  }
  @Override
  public void glVertexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glVertexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glVertexPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glVertexPointer(com.jogamp.opengl.GLArrayData arg0)
  {
    printIndent();
    print(    "glVertexPointer("+"<com.jogamp.opengl.GLArrayData> "+arg0+")");
    downstreamGLES1.glVertexPointer(arg0);
    println("");
  }
  @Override
  public void glVertexPointer(int arg0,int arg1,int arg2,long arg3)
  {
    printIndent();
    print(    "glVertexPointer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<long> "+arg3+")");
    downstreamGLES1.glVertexPointer(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    printIndent();
    print(    "glViewport("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    downstreamGLES1.glViewport(arg0,arg1,arg2,arg3);
    println("");
  }
  @Override
  public void glWeightPointerOES(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
    printIndent();
    print(    "glWeightPointerOES("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+", "+"<java.nio.Buffer> "+arg3+")");
    downstreamGLES1.glWeightPointerOES(arg0,arg1,arg2,arg3);
    println("");
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
    printIndent();
    print(    "mapBuffer("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+")");
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES1.mapBuffer(arg0,arg1);
    println(" = "+_res);
    return _res;
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    printIndent();
    print(    "mapBufferRange("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<long> "+arg1+", "+"<long> "+arg2+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")");
    com.jogamp.opengl.GLBufferStorage _res = downstreamGLES1.mapBufferRange(arg0,arg1,arg2,arg3);
    println(" = "+_res);
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
    sb.append("TraceGLES1 [this 0x"+Integer.toHexString(hashCode())+" implementing com.jogamp.opengl.GLES1,\n\t");
    sb.append(" downstream: "+downstreamGLES1.toString()+"\n\t]");
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

  private GLES1 downstreamGLES1;
} // end class TraceGLES1
