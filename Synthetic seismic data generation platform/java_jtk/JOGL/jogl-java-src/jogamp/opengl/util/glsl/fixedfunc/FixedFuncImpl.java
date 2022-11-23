package jogamp.opengl.util.glsl.fixedfunc;

import java.io.*;
import com.jogamp.opengl.*;
import com.jogamp.gluegen.runtime.*;
import java.nio.*;
import com.jogamp.opengl.GL2ES1;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2ES2;
import com.jogamp.opengl.fixedfunc.GLPointerFunc;
import jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook;
import com.jogamp.opengl.fixedfunc.GLMatrixFunc;
import com.jogamp.opengl.fixedfunc.GLLightingFunc;

/**
 * Composable pipeline {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncImpl}, implementing the interface
 * {@link com.jogamp.opengl.GL2ES1}
 * <p>
 * Each method follows the call graph <ul>
 *   <li> call <em>prolog</em> {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook} if available
 *   <li> call <em>downstream</em> {@link com.jogamp.opengl.GL2ES2} if available
 *        <strong>and</strong> if no call to {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook} is made
 * </ul><p>
 * 
 * <ul>
 *   <li> <em>Interface</em> {@link com.jogamp.opengl.GL2ES1}
 *   <li> <em>Prolog</em> {@link jogamp.opengl.util.glsl.fixedfunc.FixedFuncHook}
 *   <li> <em>Downstream</em> {@link com.jogamp.opengl.GL2ES2}
 * </ul><p>
 *  Sample code which installs this pipeline: </P>
 * 
<PRE>
     GL gl = drawable.setGL( new FixedFuncImpl( drawable.getGL().getGL2ES2(), new FixedFuncHook( drawable.getGL().getGL2ES2() ) ) );
</PRE>
*/
public class FixedFuncImpl implements com.jogamp.opengl.GL, com.jogamp.opengl.fixedfunc.GLMatrixFunc, com.jogamp.opengl.fixedfunc.GLPointerFunc, com.jogamp.opengl.fixedfunc.GLLightingFunc, com.jogamp.opengl.GL2ES1{
  public static final boolean DEBUG = jogamp.opengl.Debug.debug("FixedFuncImpl");
  public FixedFuncImpl(GL2ES2 downstreamGL2ES2, FixedFuncHook prologFixedFuncHook)
  {
    if (downstreamGL2ES2 == null) {
      throw new IllegalArgumentException("null downstreamGL2ES2");
    }
    this.downstreamGL2ES2 = downstreamGL2ES2;
    this.prologFixedFuncHook = prologFixedFuncHook;
  }

  @Override
  public final GL getDownstreamGL() throws GLException {
    return downstreamGL2ES2;
  }
  @Override
  public int getBoundBuffer(int arg0)
  {
    return downstreamGL2ES2.getBoundBuffer(arg0);
  }
  @Override
  public int getBoundFramebuffer(int arg0)
  {
    return downstreamGL2ES2.getBoundFramebuffer(arg0);
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage getBufferStorage(int arg0)
  {
    return downstreamGL2ES2.getBufferStorage(arg0);
  }
  @Override
  public com.jogamp.opengl.GLContext getContext()
  {
    return downstreamGL2ES2.getContext();
  }
  @Override
  public int getDefaultDrawFramebuffer()
  {
    return downstreamGL2ES2.getDefaultDrawFramebuffer();
  }
  @Override
  public int getDefaultReadBuffer()
  {
    return downstreamGL2ES2.getDefaultReadBuffer();
  }
  @Override
  public int getDefaultReadFramebuffer()
  {
    return downstreamGL2ES2.getDefaultReadFramebuffer();
  }
  @Override
  public java.lang.Object getExtension(java.lang.String arg0)
  {
    return downstreamGL2ES2.getExtension(arg0);
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
    return prologFixedFuncHook.getGLProfile();
  }
  @Override
  public int getMaxRenderbufferSamples()
  {
    return downstreamGL2ES2.getMaxRenderbufferSamples();
  }
  @Override
  public java.lang.Object getPlatformGLExtensions()
  {
    return downstreamGL2ES2.getPlatformGLExtensions();
  }
  @Override
  public com.jogamp.opengl.GL getRootGL()
  {
    return downstreamGL2ES2.getRootGL();
  }
  @Override
  public int getSwapInterval()
  {
    return downstreamGL2ES2.getSwapInterval();
  }
  @Override
  public void glActiveTexture(int arg0)
  {
prologFixedFuncHook.glActiveTexture(arg0);
  }
  @Override
  public void glAlphaFunc(int arg0,float arg1)
  {
prologFixedFuncHook.glAlphaFunc(arg0,arg1);
  }
  @Override
  public void glBindBuffer(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindBuffer(arg0,arg1);
  }
  @Override
  public void glBindFramebuffer(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindFramebuffer(arg0,arg1);
  }
  @Override
  public void glBindRenderbuffer(int arg0,int arg1)
  {
    downstreamGL2ES2.glBindRenderbuffer(arg0,arg1);
  }
  @Override
  public void glBindTexture(int arg0,int arg1)
  {
prologFixedFuncHook.glBindTexture(arg0,arg1);
  }
  @Override
  public void glBlendEquation(int arg0)
  {
    downstreamGL2ES2.glBlendEquation(arg0);
  }
  @Override
  public void glBlendEquationSeparate(int arg0,int arg1)
  {
    downstreamGL2ES2.glBlendEquationSeparate(arg0,arg1);
  }
  @Override
  public void glBlendFunc(int arg0,int arg1)
  {
    downstreamGL2ES2.glBlendFunc(arg0,arg1);
  }
  @Override
  public void glBlendFuncSeparate(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glBlendFuncSeparate(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glBufferData(int arg0,long arg1,java.nio.Buffer arg2,int arg3)
  {
    downstreamGL2ES2.glBufferData(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glBufferSubData(int arg0,long arg1,long arg2,java.nio.Buffer arg3)
  {
    downstreamGL2ES2.glBufferSubData(arg0,arg1,arg2,arg3);
  }
  @Override
  public int glCheckFramebufferStatus(int arg0)
  {
    return downstreamGL2ES2.glCheckFramebufferStatus(arg0);
  }
  @Override
  public void glClear(int arg0)
  {
    downstreamGL2ES2.glClear(arg0);
  }
  @Override
  public void glClearColor(float arg0,float arg1,float arg2,float arg3)
  {
    downstreamGL2ES2.glClearColor(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glClearDepth(double arg0)
  {
    downstreamGL2ES2.glClearDepth(arg0);
  }
  @Override
  public void glClearDepthf(float arg0)
  {
    downstreamGL2ES2.glClearDepthf(arg0);
  }
  @Override
  public void glClearStencil(int arg0)
  {
    downstreamGL2ES2.glClearStencil(arg0);
  }
  @Override
  public void glClientActiveTexture(int arg0)
  {
prologFixedFuncHook.glClientActiveTexture(arg0);
  }
  @Override
  public void glColor4f(float arg0,float arg1,float arg2,float arg3)
  {
prologFixedFuncHook.glColor4f(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glColor4ub(byte arg0,byte arg1,byte arg2,byte arg3)
  {
prologFixedFuncHook.glColor4ub(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glColorMask(boolean arg0,boolean arg1,boolean arg2,boolean arg3)
  {
    downstreamGL2ES2.glColorMask(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glColorPointer(int arg0,int arg1,int arg2,long arg3)
  {
prologFixedFuncHook.glColorPointer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glColorPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
prologFixedFuncHook.glColorPointer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glColorPointer(com.jogamp.opengl.GLArrayData arg0)
  {
prologFixedFuncHook.glColorPointer(arg0);
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,long arg7)
  {
    downstreamGL2ES2.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  @Override
  public void glCompressedTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    downstreamGL2ES2.glCompressedTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    downstreamGL2ES2.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  @Override
  public void glCompressedTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    downstreamGL2ES2.glCompressedTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  @Override
  public void glCopyTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    downstreamGL2ES2.glCopyTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  @Override
  public void glCopyTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7)
  {
    downstreamGL2ES2.glCopyTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  @Override
  public void glCullFace(int arg0)
  {
    downstreamGL2ES2.glCullFace(arg0);
  }
  @Override
  public void glDeleteBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteBuffers(arg0,arg1);
  }
  @Override
  public void glDeleteBuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteBuffers(arg0,arg1,arg2);
  }
  @Override
  public void glDeleteFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteFramebuffers(arg0,arg1);
  }
  @Override
  public void glDeleteFramebuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteFramebuffers(arg0,arg1,arg2);
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteRenderbuffers(arg0,arg1,arg2);
  }
  @Override
  public void glDeleteRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteRenderbuffers(arg0,arg1);
  }
  @Override
  public void glDeleteTextures(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glDeleteTextures(arg0,arg1,arg2);
  }
  @Override
  public void glDeleteTextures(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glDeleteTextures(arg0,arg1);
  }
  @Override
  public void glDepthFunc(int arg0)
  {
    downstreamGL2ES2.glDepthFunc(arg0);
  }
  @Override
  public void glDepthMask(boolean arg0)
  {
    downstreamGL2ES2.glDepthMask(arg0);
  }
  @Override
  public void glDepthRange(double arg0,double arg1)
  {
    downstreamGL2ES2.glDepthRange(arg0,arg1);
  }
  @Override
  public void glDepthRangef(float arg0,float arg1)
  {
    downstreamGL2ES2.glDepthRangef(arg0,arg1);
  }
  @Override
  public void glDisable(int arg0)
  {
prologFixedFuncHook.glDisable(arg0);
  }
  @Override
  public void glDisableClientState(int arg0)
  {
prologFixedFuncHook.glDisableClientState(arg0);
  }
  @Override
  public void glDrawArrays(int arg0,int arg1,int arg2)
  {
prologFixedFuncHook.glDrawArrays(arg0,arg1,arg2);
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,long arg3)
  {
prologFixedFuncHook.glDrawElements(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glDrawElements(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
prologFixedFuncHook.glDrawElements(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glEnable(int arg0)
  {
prologFixedFuncHook.glEnable(arg0);
  }
  @Override
  public void glEnableClientState(int arg0)
  {
prologFixedFuncHook.glEnableClientState(arg0);
  }
  @Override
  public void glFinish()
  {
    downstreamGL2ES2.glFinish();
  }
  @Override
  public void glFlush()
  {
    downstreamGL2ES2.glFlush();
  }
  @Override
  public void glFlushMappedBufferRange(int arg0,long arg1,long arg2)
  {
    downstreamGL2ES2.glFlushMappedBufferRange(arg0,arg1,arg2);
  }
  @Override
  public void glFogf(int arg0,float arg1)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFogf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")"); } 
  }
  @Override
  public void glFogfv(int arg0,java.nio.FloatBuffer arg1)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")"); } 
  }
  @Override
  public void glFogfv(int arg0,float[] arg1,int arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glFogfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  @Override
  public void glFramebufferRenderbuffer(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glFramebufferRenderbuffer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glFramebufferTexture2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glFramebufferTexture2D(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public void glFrontFace(int arg0)
  {
    downstreamGL2ES2.glFrontFace(arg0);
  }
  @Override
  public void glFrustum(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
prologFixedFuncHook.glFrustum(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  @Override
  public void glFrustumf(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
prologFixedFuncHook.glFrustumf(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  @Override
  public void glGenBuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenBuffers(arg0,arg1);
  }
  @Override
  public void glGenBuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenBuffers(arg0,arg1,arg2);
  }
  @Override
  public void glGenFramebuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenFramebuffers(arg0,arg1);
  }
  @Override
  public void glGenFramebuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenFramebuffers(arg0,arg1,arg2);
  }
  @Override
  public void glGenRenderbuffers(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenRenderbuffers(arg0,arg1);
  }
  @Override
  public void glGenRenderbuffers(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenRenderbuffers(arg0,arg1,arg2);
  }
  @Override
  public void glGenTextures(int arg0,int[] arg1,int arg2)
  {
    downstreamGL2ES2.glGenTextures(arg0,arg1,arg2);
  }
  @Override
  public void glGenTextures(int arg0,java.nio.IntBuffer arg1)
  {
    downstreamGL2ES2.glGenTextures(arg0,arg1);
  }
  @Override
  public void glGenerateMipmap(int arg0)
  {
    downstreamGL2ES2.glGenerateMipmap(arg0);
  }
  @Override
  public void glGetBooleanv(int arg0,byte[] arg1,int arg2)
  {
    downstreamGL2ES2.glGetBooleanv(arg0,arg1,arg2);
  }
  @Override
  public void glGetBooleanv(int arg0,java.nio.ByteBuffer arg1)
  {
    downstreamGL2ES2.glGetBooleanv(arg0,arg1);
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glGetBufferParameteriv(arg0,arg1,arg2);
  }
  @Override
  public void glGetBufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetBufferParameteriv(arg0,arg1,arg2,arg3);
  }
  @Override
  public int glGetError()
  {
    return downstreamGL2ES2.glGetError();
  }
  @Override
  public void glGetFloatv(int arg0,java.nio.FloatBuffer arg1)
  {
prologFixedFuncHook.glGetFloatv(arg0,arg1);
  }
  @Override
  public void glGetFloatv(int arg0,float[] arg1,int arg2)
  {
prologFixedFuncHook.glGetFloatv(arg0,arg1,arg2);
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    downstreamGL2ES2.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glGetFramebufferAttachmentParameteriv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    downstreamGL2ES2.glGetFramebufferAttachmentParameteriv(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public int glGetGraphicsResetStatus()
  {
    return downstreamGL2ES2.glGetGraphicsResetStatus();
  }
  @Override
  public void glGetIntegerv(int arg0,java.nio.IntBuffer arg1)
  {
prologFixedFuncHook.glGetIntegerv(arg0,arg1);
  }
  @Override
  public void glGetIntegerv(int arg0,int[] arg1,int arg2)
  {
prologFixedFuncHook.glGetIntegerv(arg0,arg1,arg2);
  }
  @Override
  public void glGetLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  @Override
  public void glGetLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetLightfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  @Override
  public void glGetMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  @Override
  public void glGetMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetMaterialfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glGetRenderbufferParameteriv(arg0,arg1,arg2);
  }
  @Override
  public void glGetRenderbufferParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetRenderbufferParameteriv(arg0,arg1,arg2,arg3);
  }
  @Override
  public java.lang.String glGetString(int arg0)
  {
    return downstreamGL2ES2.glGetString(arg0);
  }
  @Override
  public void glGetTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  @Override
  public void glGetTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glGetTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  @Override
  public void glGetTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
prologFixedFuncHook.glGetTexEnviv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glGetTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
prologFixedFuncHook.glGetTexEnviv(arg0,arg1,arg2);
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetTexParameterfv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glGetTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    downstreamGL2ES2.glGetTexParameterfv(arg0,arg1,arg2);
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glGetTexParameteriv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glGetTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glGetTexParameteriv(arg0,arg1,arg2);
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,float[] arg3,int arg4)
  {
    downstreamGL2ES2.glGetnUniformfv(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public void glGetnUniformfv(int arg0,int arg1,int arg2,java.nio.FloatBuffer arg3)
  {
    downstreamGL2ES2.glGetnUniformfv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,int[] arg3,int arg4)
  {
    downstreamGL2ES2.glGetnUniformiv(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public void glGetnUniformiv(int arg0,int arg1,int arg2,java.nio.IntBuffer arg3)
  {
    downstreamGL2ES2.glGetnUniformiv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glHint(int arg0,int arg1)
  {
    downstreamGL2ES2.glHint(arg0,arg1);
  }
  @Override
  public boolean glIsBuffer(int arg0)
  {
    return downstreamGL2ES2.glIsBuffer(arg0);
  }
  @Override
  public boolean glIsEnabled(int arg0)
  {
    return downstreamGL2ES2.glIsEnabled(arg0);
  }
  @Override
  public boolean glIsFramebuffer(int arg0)
  {
    return downstreamGL2ES2.glIsFramebuffer(arg0);
  }
  @Override
  public boolean glIsRenderbuffer(int arg0)
  {
    return downstreamGL2ES2.glIsRenderbuffer(arg0);
  }
  @Override
  public boolean glIsTexture(int arg0)
  {
    return downstreamGL2ES2.glIsTexture(arg0);
  }
  @Override
  public void glLightModelf(int arg0,float arg1)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightModelf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+")"); } 
  }
  @Override
  public void glLightModelfv(int arg0,java.nio.FloatBuffer arg1)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg1+")"); } 
  }
  @Override
  public void glLightModelfv(int arg0,float[] arg1,int arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightModelfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg2).toUpperCase()+")"); } 
  }
  @Override
  public void glLightf(int arg0,int arg1,float arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLightf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")"); } 
  }
  @Override
  public void glLightfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
prologFixedFuncHook.glLightfv(arg0,arg1,arg2);
  }
  @Override
  public void glLightfv(int arg0,int arg1,float[] arg2,int arg3)
  {
prologFixedFuncHook.glLightfv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glLineWidth(float arg0)
  {
    downstreamGL2ES2.glLineWidth(arg0);
  }
  @Override
  public void glLoadIdentity()
  {
prologFixedFuncHook.glLoadIdentity();
  }
  @Override
  public void glLoadMatrixf(java.nio.FloatBuffer arg0)
  {
prologFixedFuncHook.glLoadMatrixf(arg0);
  }
  @Override
  public void glLoadMatrixf(float[] arg0,int arg1)
  {
prologFixedFuncHook.glLoadMatrixf(arg0,arg1);
  }
  @Override
  public void glLogicOp(int arg0)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glLogicOp("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+")"); } 
  }
  @Override
  public java.nio.ByteBuffer glMapBuffer(int arg0,int arg1)
  {
    return downstreamGL2ES2.glMapBuffer(arg0,arg1);
  }
  @Override
  public java.nio.ByteBuffer glMapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    return downstreamGL2ES2.glMapBufferRange(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glMaterialf(int arg0,int arg1,float arg2)
  {
prologFixedFuncHook.glMaterialf(arg0,arg1,arg2);
  }
  @Override
  public void glMaterialfv(int arg0,int arg1,float[] arg2,int arg3)
  {
prologFixedFuncHook.glMaterialfv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glMaterialfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
prologFixedFuncHook.glMaterialfv(arg0,arg1,arg2);
  }
  @Override
  public void glMatrixMode(int arg0)
  {
prologFixedFuncHook.glMatrixMode(arg0);
  }
  @Override
  public void glMultMatrixf(java.nio.FloatBuffer arg0)
  {
prologFixedFuncHook.glMultMatrixf(arg0);
  }
  @Override
  public void glMultMatrixf(float[] arg0,int arg1)
  {
prologFixedFuncHook.glMultMatrixf(arg0,arg1);
  }
  @Override
  public void glMultiTexCoord4f(int arg0,float arg1,float arg2,float arg3,float arg4)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glMultiTexCoord4f("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<float> "+arg1+", "+"<float> "+arg2+", "+"<float> "+arg3+", "+"<float> "+arg4+")"); } 
  }
  @Override
  public void glNormal3f(float arg0,float arg1,float arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glNormal3f("+"<float> "+arg0+", "+"<float> "+arg1+", "+"<float> "+arg2+")"); } 
  }
  @Override
  public void glNormalPointer(com.jogamp.opengl.GLArrayData arg0)
  {
prologFixedFuncHook.glNormalPointer(arg0);
  }
  @Override
  public void glNormalPointer(int arg0,int arg1,java.nio.Buffer arg2)
  {
prologFixedFuncHook.glNormalPointer(arg0,arg1,arg2);
  }
  @Override
  public void glNormalPointer(int arg0,int arg1,long arg2)
  {
prologFixedFuncHook.glNormalPointer(arg0,arg1,arg2);
  }
  @Override
  public void glOrtho(double arg0,double arg1,double arg2,double arg3,double arg4,double arg5)
  {
prologFixedFuncHook.glOrtho(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  @Override
  public void glOrthof(float arg0,float arg1,float arg2,float arg3,float arg4,float arg5)
  {
prologFixedFuncHook.glOrthof(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  @Override
  public void glPixelStorei(int arg0,int arg1)
  {
    downstreamGL2ES2.glPixelStorei(arg0,arg1);
  }
  @Override
  public void glPointParameterf(int arg0,float arg1)
  {
prologFixedFuncHook.glPointParameterf(arg0,arg1);
  }
  @Override
  public void glPointParameterfv(int arg0,float[] arg1,int arg2)
  {
prologFixedFuncHook.glPointParameterfv(arg0,arg1,arg2);
  }
  @Override
  public void glPointParameterfv(int arg0,java.nio.FloatBuffer arg1)
  {
prologFixedFuncHook.glPointParameterfv(arg0,arg1);
  }
  @Override
  public void glPointSize(float arg0)
  {
prologFixedFuncHook.glPointSize(arg0);
  }
  @Override
  public void glPolygonOffset(float arg0,float arg1)
  {
    downstreamGL2ES2.glPolygonOffset(arg0,arg1);
  }
  @Override
  public void glPopMatrix()
  {
prologFixedFuncHook.glPopMatrix();
  }
  @Override
  public void glPushMatrix()
  {
prologFixedFuncHook.glPushMatrix();
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,java.nio.Buffer arg6)
  {
    downstreamGL2ES2.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
  }
  @Override
  public void glReadPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,long arg6)
  {
    downstreamGL2ES2.glReadPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
  }
  @Override
  public void glReadnPixels(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,java.nio.Buffer arg7)
  {
    downstreamGL2ES2.glReadnPixels(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7);
  }
  @Override
  public void glRenderbufferStorage(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glRenderbufferStorage(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glRenderbufferStorageMultisample(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glRenderbufferStorageMultisample(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public void glRotatef(float arg0,float arg1,float arg2,float arg3)
  {
prologFixedFuncHook.glRotatef(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glSampleCoverage(float arg0,boolean arg1)
  {
    downstreamGL2ES2.glSampleCoverage(arg0,arg1);
  }
  @Override
  public void glScalef(float arg0,float arg1,float arg2)
  {
prologFixedFuncHook.glScalef(arg0,arg1,arg2);
  }
  @Override
  public void glScissor(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glScissor(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glShadeModel(int arg0)
  {
prologFixedFuncHook.glShadeModel(arg0);
  }
  @Override
  public void glStencilFunc(int arg0,int arg1,int arg2)
  {
    downstreamGL2ES2.glStencilFunc(arg0,arg1,arg2);
  }
  @Override
  public void glStencilMask(int arg0)
  {
    downstreamGL2ES2.glStencilMask(arg0);
  }
  @Override
  public void glStencilOp(int arg0,int arg1,int arg2)
  {
    downstreamGL2ES2.glStencilOp(arg0,arg1,arg2);
  }
  @Override
  public void glTexCoordPointer(com.jogamp.opengl.GLArrayData arg0)
  {
prologFixedFuncHook.glTexCoordPointer(arg0);
  }
  @Override
  public void glTexCoordPointer(int arg0,int arg1,int arg2,long arg3)
  {
prologFixedFuncHook.glTexCoordPointer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glTexCoordPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
prologFixedFuncHook.glTexCoordPointer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glTexEnvf(int arg0,int arg1,float arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvf("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<float> "+arg2+")"); } 
  }
  @Override
  public void glTexEnvfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.FloatBuffer> "+arg2+")"); } 
  }
  @Override
  public void glTexEnvfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnvfv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[F>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  @Override
  public void glTexEnvi(int arg0,int arg1,int arg2)
  {
prologFixedFuncHook.glTexEnvi(arg0,arg1,arg2);
  }
  @Override
  public void glTexEnviv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<java.nio.IntBuffer> "+arg2+")"); } 
  }
  @Override
  public void glTexEnviv(int arg0,int arg1,int[] arg2,int arg3)
  {
    if(DEBUG) { System.out.println("WARNING: No prolog, no downstream, empty: "+    "glTexEnviv("+"<int> 0x"+Integer.toHexString(arg0).toUpperCase()+", "+"<int> 0x"+Integer.toHexString(arg1).toUpperCase()+", "+"<[I>"+", "+"<int> 0x"+Integer.toHexString(arg3).toUpperCase()+")"); } 
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
prologFixedFuncHook.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  @Override
  public void glTexImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
prologFixedFuncHook.glTexImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  @Override
  public void glTexParameterf(int arg0,int arg1,float arg2)
  {
    downstreamGL2ES2.glTexParameterf(arg0,arg1,arg2);
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,float[] arg2,int arg3)
  {
    downstreamGL2ES2.glTexParameterfv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glTexParameterfv(int arg0,int arg1,java.nio.FloatBuffer arg2)
  {
    downstreamGL2ES2.glTexParameterfv(arg0,arg1,arg2);
  }
  @Override
  public void glTexParameteri(int arg0,int arg1,int arg2)
  {
    downstreamGL2ES2.glTexParameteri(arg0,arg1,arg2);
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,java.nio.IntBuffer arg2)
  {
    downstreamGL2ES2.glTexParameteriv(arg0,arg1,arg2);
  }
  @Override
  public void glTexParameteriv(int arg0,int arg1,int[] arg2,int arg3)
  {
    downstreamGL2ES2.glTexParameteriv(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glTexStorage1D(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glTexStorage1D(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glTexStorage2D(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glTexStorage2D(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public void glTexStorage3D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    downstreamGL2ES2.glTexStorage3D(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,long arg8)
  {
    downstreamGL2ES2.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  @Override
  public void glTexSubImage2D(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6,int arg7,java.nio.Buffer arg8)
  {
    downstreamGL2ES2.glTexSubImage2D(arg0,arg1,arg2,arg3,arg4,arg5,arg6,arg7,arg8);
  }
  @Override
  public void glTextureStorage1DEXT(int arg0,int arg1,int arg2,int arg3,int arg4)
  {
    downstreamGL2ES2.glTextureStorage1DEXT(arg0,arg1,arg2,arg3,arg4);
  }
  @Override
  public void glTextureStorage2DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5)
  {
    downstreamGL2ES2.glTextureStorage2DEXT(arg0,arg1,arg2,arg3,arg4,arg5);
  }
  @Override
  public void glTextureStorage3DEXT(int arg0,int arg1,int arg2,int arg3,int arg4,int arg5,int arg6)
  {
    downstreamGL2ES2.glTextureStorage3DEXT(arg0,arg1,arg2,arg3,arg4,arg5,arg6);
  }
  @Override
  public void glTranslatef(float arg0,float arg1,float arg2)
  {
prologFixedFuncHook.glTranslatef(arg0,arg1,arg2);
  }
  @Override
  public boolean glUnmapBuffer(int arg0)
  {
    return downstreamGL2ES2.glUnmapBuffer(arg0);
  }
  @Override
  public void glVertexPointer(com.jogamp.opengl.GLArrayData arg0)
  {
prologFixedFuncHook.glVertexPointer(arg0);
  }
  @Override
  public void glVertexPointer(int arg0,int arg1,int arg2,long arg3)
  {
prologFixedFuncHook.glVertexPointer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glVertexPointer(int arg0,int arg1,int arg2,java.nio.Buffer arg3)
  {
prologFixedFuncHook.glVertexPointer(arg0,arg1,arg2,arg3);
  }
  @Override
  public void glViewport(int arg0,int arg1,int arg2,int arg3)
  {
    downstreamGL2ES2.glViewport(arg0,arg1,arg2,arg3);
  }
  @Override
  public boolean hasBasicFBOSupport()
  {
    return downstreamGL2ES2.hasBasicFBOSupport();
  }
  @Override
  public boolean hasFullFBOSupport()
  {
    return downstreamGL2ES2.hasFullFBOSupport();
  }
  @Override
  public boolean hasGLSL()
  {
    return downstreamGL2ES2.hasGLSL();
  }
  @Override
  public boolean isExtensionAvailable(java.lang.String arg0)
  {
    return downstreamGL2ES2.isExtensionAvailable(arg0);
  }
  @Override
  public boolean isFunctionAvailable(java.lang.String arg0)
  {
    return downstreamGL2ES2.isFunctionAvailable(arg0);
  }
  @Override
  public boolean isGL()
  {
    return true;
  }
  @Override
  public boolean isGL2()
  {
    return false;
  }
  @Override
  public boolean isGL2ES1()
  {
    return true;
  }
  @Override
  public boolean isGL2ES2()
  {
    return false;
  }
  @Override
  public boolean isGL2ES3()
  {
    return false;
  }
  @Override
  public boolean isGL2GL3()
  {
    return false;
  }
  @Override
  public boolean isGL3()
  {
    return false;
  }
  @Override
  public boolean isGL3ES3()
  {
    return false;
  }
  @Override
  public boolean isGL3bc()
  {
    return false;
  }
  @Override
  public boolean isGL3core()
  {
    return prologFixedFuncHook.isGL3core();
  }
  @Override
  public boolean isGL4()
  {
    return false;
  }
  @Override
  public boolean isGL4ES3()
  {
    return false;
  }
  @Override
  public boolean isGL4bc()
  {
    return false;
  }
  @Override
  public boolean isGL4core()
  {
    return prologFixedFuncHook.isGL4core();
  }
  @Override
  public boolean isGLES()
  {
    return downstreamGL2ES2.isGLES();
  }
  @Override
  public boolean isGLES1()
  {
    return false;
  }
  @Override
  public boolean isGLES2()
  {
    return false;
  }
  @Override
  public boolean isGLES2Compatible()
  {
    return prologFixedFuncHook.isGLES2Compatible();
  }
  @Override
  public boolean isGLES3()
  {
    return false;
  }
  @Override
  public boolean isGLES31Compatible()
  {
    return downstreamGL2ES2.isGLES31Compatible();
  }
  @Override
  public boolean isGLES32Compatible()
  {
    return downstreamGL2ES2.isGLES32Compatible();
  }
  @Override
  public boolean isGLES3Compatible()
  {
    return prologFixedFuncHook.isGLES3Compatible();
  }
  @Override
  public boolean isGLcore()
  {
    return prologFixedFuncHook.isGLcore();
  }
  @Override
  public boolean isNPOTTextureAvailable()
  {
    return downstreamGL2ES2.isNPOTTextureAvailable();
  }
  @Override
  public boolean isTextureFormatBGRA8888Available()
  {
    return downstreamGL2ES2.isTextureFormatBGRA8888Available();
  }
  @Override
  public boolean isVBOArrayBound()
  {
    return downstreamGL2ES2.isVBOArrayBound();
  }
  @Override
  public boolean isVBOElementArrayBound()
  {
    return downstreamGL2ES2.isVBOElementArrayBound();
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBuffer(int arg0,int arg1)
  {
    return downstreamGL2ES2.mapBuffer(arg0,arg1);
  }
  @Override
  public com.jogamp.opengl.GLBufferStorage mapBufferRange(int arg0,long arg1,long arg2,int arg3)
  {
    return downstreamGL2ES2.mapBufferRange(arg0,arg1,arg2,arg3);
  }
  @Override
  public void setSwapInterval(int arg0)
  {
    downstreamGL2ES2.setSwapInterval(arg0);
  }
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("FixedFuncImpl [this 0x"+Integer.toHexString(hashCode())+" implementing com.jogamp.opengl.GL2ES1,\n\t");
    sb.append(" prolog: "+prologFixedFuncHook.toString()+",\n\t");
    sb.append(" downstream: "+downstreamGL2ES2.toString()+"\n\t]");
    return sb.toString();
  }
  private FixedFuncHook prologFixedFuncHook;
  private GL2ES2 downstreamGL2ES2;
} // end class FixedFuncImpl
