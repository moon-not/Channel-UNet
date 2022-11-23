/* !---- DO NOT EDIT: This file autogenerated by com/jogamp/gluegen/JavaEmitter.java on Sat Oct 10 03:31:13 CEST 2015 ----! */


package com.jogamp.oculusvr;

import java.nio.*;

import com.jogamp.gluegen.runtime.*;
import com.jogamp.common.os.*;
import com.jogamp.common.nio.*;
import jogamp.common.os.MachineDataInfoRuntime;

import com.jogamp.oculusvr.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ovrTrackingState {

  StructAccessor accessor;

  private static final int mdIdx = MachineDataInfoRuntime.getStatic().ordinal();
  private final MachineDataInfo md;

  private static final int[] ovrTrackingState_size = new int[] { 200 /* ARM_MIPS_32 */, 200 /* X86_32_UNIX */, 200 /* X86_32_MACOS */, 200 /* PPC_32_UNIX */, 200 /* SPARC_32_SUNOS */, 200 /* X86_32_WINDOWS */, 200 /* LP64_UNIX */, 200 /* X86_64_WINDOWS */  };
  private static final int[] HeadPose_offset = new int[] { 0 /* ARM_MIPS_32 */, 0 /* X86_32_UNIX */, 0 /* X86_32_MACOS */, 0 /* PPC_32_UNIX */, 0 /* SPARC_32_SUNOS */, 0 /* X86_32_WINDOWS */, 0 /* LP64_UNIX */, 0 /* X86_64_WINDOWS */ };
  private static final int[] HeadPose_size = new int[] { 88 /* ARM_MIPS_32 */, 88 /* X86_32_UNIX */, 88 /* X86_32_MACOS */, 88 /* PPC_32_UNIX */, 88 /* SPARC_32_SUNOS */, 88 /* X86_32_WINDOWS */, 88 /* LP64_UNIX */, 88 /* X86_64_WINDOWS */  };
  private static final int[] CameraPose_offset = new int[] { 88 /* ARM_MIPS_32 */, 88 /* X86_32_UNIX */, 88 /* X86_32_MACOS */, 88 /* PPC_32_UNIX */, 88 /* SPARC_32_SUNOS */, 88 /* X86_32_WINDOWS */, 88 /* LP64_UNIX */, 88 /* X86_64_WINDOWS */ };
  private static final int[] CameraPose_size = new int[] { 28 /* ARM_MIPS_32 */, 28 /* X86_32_UNIX */, 28 /* X86_32_MACOS */, 28 /* PPC_32_UNIX */, 28 /* SPARC_32_SUNOS */, 28 /* X86_32_WINDOWS */, 28 /* LP64_UNIX */, 28 /* X86_64_WINDOWS */  };
  private static final int[] LeveledCameraPose_offset = new int[] { 116 /* ARM_MIPS_32 */, 116 /* X86_32_UNIX */, 116 /* X86_32_MACOS */, 116 /* PPC_32_UNIX */, 116 /* SPARC_32_SUNOS */, 116 /* X86_32_WINDOWS */, 116 /* LP64_UNIX */, 116 /* X86_64_WINDOWS */ };
  private static final int[] LeveledCameraPose_size = new int[] { 28 /* ARM_MIPS_32 */, 28 /* X86_32_UNIX */, 28 /* X86_32_MACOS */, 28 /* PPC_32_UNIX */, 28 /* SPARC_32_SUNOS */, 28 /* X86_32_WINDOWS */, 28 /* LP64_UNIX */, 28 /* X86_64_WINDOWS */  };
  private static final int[] RawSensorData_offset = new int[] { 144 /* ARM_MIPS_32 */, 144 /* X86_32_UNIX */, 144 /* X86_32_MACOS */, 144 /* PPC_32_UNIX */, 144 /* SPARC_32_SUNOS */, 144 /* X86_32_WINDOWS */, 144 /* LP64_UNIX */, 144 /* X86_64_WINDOWS */ };
  private static final int[] RawSensorData_size = new int[] { 44 /* ARM_MIPS_32 */, 44 /* X86_32_UNIX */, 44 /* X86_32_MACOS */, 44 /* PPC_32_UNIX */, 44 /* SPARC_32_SUNOS */, 44 /* X86_32_WINDOWS */, 44 /* LP64_UNIX */, 44 /* X86_64_WINDOWS */  };
  private static final int[] StatusFlags_offset = new int[] { 188 /* ARM_MIPS_32 */, 188 /* X86_32_UNIX */, 188 /* X86_32_MACOS */, 188 /* PPC_32_UNIX */, 188 /* SPARC_32_SUNOS */, 188 /* X86_32_WINDOWS */, 188 /* LP64_UNIX */, 188 /* X86_64_WINDOWS */ };
//private static final int[] StatusFlags_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };
  private static final int[] LastCameraFrameCounter_offset = new int[] { 192 /* ARM_MIPS_32 */, 192 /* X86_32_UNIX */, 192 /* X86_32_MACOS */, 192 /* PPC_32_UNIX */, 192 /* SPARC_32_SUNOS */, 192 /* X86_32_WINDOWS */, 192 /* LP64_UNIX */, 192 /* X86_64_WINDOWS */ };
//private static final int[] LastCameraFrameCounter_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };
  private static final int[] Pad_offset = new int[] { 196 /* ARM_MIPS_32 */, 196 /* X86_32_UNIX */, 196 /* X86_32_MACOS */, 196 /* PPC_32_UNIX */, 196 /* SPARC_32_SUNOS */, 196 /* X86_32_WINDOWS */, 196 /* LP64_UNIX */, 196 /* X86_64_WINDOWS */ };
//private static final int[] Pad_size = new int[] { 4 /* ARM_MIPS_32 */, 4 /* X86_32_UNIX */, 4 /* X86_32_MACOS */, 4 /* PPC_32_UNIX */, 4 /* SPARC_32_SUNOS */, 4 /* X86_32_WINDOWS */, 4 /* LP64_UNIX */, 4 /* X86_64_WINDOWS */  };

  public static int size() {
    return ovrTrackingState_size[mdIdx];
  }

  public static ovrTrackingState create() {
    return create(Buffers.newDirectByteBuffer(size()));
  }

  public static ovrTrackingState create(java.nio.ByteBuffer buf) {
      return new ovrTrackingState(buf);
  }

  ovrTrackingState(java.nio.ByteBuffer buf) {
    md = MachineDataInfo.StaticConfig.values()[mdIdx].md;
    accessor = new StructAccessor(buf);
  }

  public java.nio.ByteBuffer getBuffer() {
    return accessor.getBuffer();
  }

  /** Getter for native field <code>HeadPose</code>: CType[(StructType) typedef 'ovrPoseStatef', size [fixed false, lnx64 88], [const[false], struct{ovrPoseStatef_: 7, }]] */
  public ovrPoseStatef getHeadPose() {
    return ovrPoseStatef.create( accessor.slice( HeadPose_offset[mdIdx], HeadPose_size[mdIdx] ) );
 }

  /** Getter for native field <code>CameraPose</code>: CType[(StructType) typedef 'ovrPosef', size [fixed false, lnx64 28], [const[false], struct{ovrPosef_: 2, }]] */
  public ovrPosef getCameraPose() {
    return ovrPosef.create( accessor.slice( CameraPose_offset[mdIdx], CameraPose_size[mdIdx] ) );
 }

  /** Getter for native field <code>LeveledCameraPose</code>: CType[(StructType) typedef 'ovrPosef', size [fixed false, lnx64 28], [const[false], struct{ovrPosef_: 2, }]] */
  public ovrPosef getLeveledCameraPose() {
    return ovrPosef.create( accessor.slice( LeveledCameraPose_offset[mdIdx], LeveledCameraPose_size[mdIdx] ) );
 }

  /** Getter for native field <code>RawSensorData</code>: CType[(StructType) typedef 'ovrSensorData', size [fixed false, lnx64 44], [const[false], struct{ovrSensorData_: 5, }]] */
  public ovrSensorData getRawSensorData() {
    return ovrSensorData.create( accessor.slice( RawSensorData_offset[mdIdx], RawSensorData_size[mdIdx] ) );
 }

  /** Setter for native field <code>StatusFlags</code>: CType[(IntType) 'int', size [fixed false, lnx64 4], [const[false], int]] */
  public ovrTrackingState setStatusFlags(int val) {
    accessor.setIntAt(StatusFlags_offset[mdIdx], val, md.intSizeInBytes());
    return this;
  }

  /** Getter for native field <code>StatusFlags</code>: CType[(IntType) 'int', size [fixed false, lnx64 4], [const[false], int]] */
  public int getStatusFlags() {
    return accessor.getIntAt(StatusFlags_offset[mdIdx], md.intSizeInBytes());
  }

  /** Setter for native field <code>LastCameraFrameCounter</code>: CType[(IntType) typedef 'uint32_t', size [fixed true, lnx64 4], [const[false], int]] */
  public ovrTrackingState setLastCameraFrameCounter(int val) {
    accessor.setIntAt(LastCameraFrameCounter_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>LastCameraFrameCounter</code>: CType[(IntType) typedef 'uint32_t', size [fixed true, lnx64 4], [const[false], int]] */
  public int getLastCameraFrameCounter() {
    return accessor.getIntAt(LastCameraFrameCounter_offset[mdIdx]);
  }

  /** Setter for native field <code>Pad</code>: CType[(IntType) typedef 'uint32_t', size [fixed true, lnx64 4], [const[false], int]] */
  public ovrTrackingState setPad(int val) {
    accessor.setIntAt(Pad_offset[mdIdx], val);
    return this;
  }

  /** Getter for native field <code>Pad</code>: CType[(IntType) typedef 'uint32_t', size [fixed true, lnx64 4], [const[false], int]] */
  public int getPad() {
    return accessor.getIntAt(Pad_offset[mdIdx]);
  }
}
