package jag.opcode;

import jag.commons.collection.Node;
import jag.graphics.DefaultMaterialProvider;
import jag.graphics.Sprite;
import jag.statics.Statics43;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassStructure extends Node {

    public static Sprite[] hitmarks;
    public static int anInt748;
    public int size;
    public int elementCount;
    public int[] errors;
    public int[] types;
    public Field[] fields;
    public int[] fieldIntValues;
    public Method[] methods;
    public byte[][][] methodArgs;

    public ClassStructure() {
    }

    public static void decode(Buffer buffer) {
        ClassStructure struc = new ClassStructure();
        struc.elementCount = buffer.readUByte();
        struc.size = buffer.readInt();
        struc.types = new int[struc.elementCount];
        struc.errors = new int[struc.elementCount];
        struc.fields = new Field[struc.elementCount];
        struc.fieldIntValues = new int[struc.elementCount];
        struc.methods = new Method[struc.elementCount];
        struc.methodArgs = new byte[struc.elementCount][][];

        for (int var3 = 0; var3 < struc.elementCount; ++var3) {
            try {
                int var4 = buffer.readUByte();
                String var5;
                String var6;
                int var7;
                if (var4 != 0 && var4 != 1 && var4 != 2) {
                    if (var4 == 3 || var4 == 4) {
                        var5 = buffer.readString();
                        var6 = buffer.readString();
                        var7 = buffer.readUByte();
                        String[] var8 = new String[var7];

                        for (int var9 = 0; var9 < var7; ++var9) {
                            var8[var9] = buffer.readString();
                        }

                        String var10 = buffer.readString();
                        byte[][] var11 = new byte[var7][];
                        int var13;
                        if (var4 == 3) {
                            for (int var12 = 0; var12 < var7; ++var12) {
                                var13 = buffer.readInt();
                                var11[var12] = new byte[var13];
                                buffer.readBytes(var11[var12], 0, var13);
                            }
                        }

                        struc.types[var3] = var4;
                        Class[] var14 = new Class[var7];

                        for (var13 = 0; var13 < var7; ++var13) {
                            var14[var13] = DefaultMaterialProvider.method1515(var8[var13]);
                        }

                        Class var15 = DefaultMaterialProvider.method1515(var10);
                        if (DefaultMaterialProvider.method1515(var5).getClassLoader() == null) {
                            throw new SecurityException();
                        }

                        for (Method var19 : DefaultMaterialProvider.method1515(var5).getDeclaredMethods()) {
                            if (var19.getName().equals(var6)) {
                                Class[] var20 = var19.getParameterTypes();
                                if (var14.length == var20.length) {
                                    boolean var21 = true;

                                    for (int var22 = 0; var22 < var14.length; ++var22) {
                                        if (var20[var22] != var14[var22]) {
                                            var21 = false;
                                            break;
                                        }
                                    }

                                    if (var21 && var15 == var19.getReturnType()) {
                                        struc.methods[var3] = var19;
                                    }
                                }
                            }
                        }

                        struc.methodArgs[var3] = var11;
                    }
                } else {
                    var5 = buffer.readString();
                    var6 = buffer.readString();
                    var7 = 0;
                    if (var4 == 1) {
                        var7 = buffer.readInt();
                    }

                    struc.types[var3] = var4;
                    struc.fieldIntValues[var3] = var7;
                    if (DefaultMaterialProvider.method1515(var5).getClassLoader() == null) {
                        throw new SecurityException();
                    }

                    struc.fields[var3] = DefaultMaterialProvider.method1515(var5).getDeclaredField(var6);
                }
            } catch (ClassNotFoundException var24) {
                struc.errors[var3] = -1;
            } catch (SecurityException var25) {
                struc.errors[var3] = -2;
            } catch (NullPointerException var26) {
                struc.errors[var3] = -3;
            } catch (Exception var27) {
                struc.errors[var3] = -4;
            } catch (Throwable var28) {
                struc.errors[var3] = -5;
            }
        }

        Statics43.classStructures.pushBack(struc);
    }

    public static void process(PacketBuffer var0) {
        ClassStructure var2 = (ClassStructure) Statics43.classStructures.head();
        if (var2 != null) {
            int var3 = var0.caret;
            var0.writeInt(var2.size);

            for (int var4 = 0; var4 < var2.elementCount; ++var4) {
                if (var2.errors[var4] != 0) {
                    var0.writeByte(var2.errors[var4]);
                } else {
                    try {
                        int var5 = var2.types[var4];
                        Field var6;
                        int var7;
                        if (var5 == 0) {
                            var6 = var2.fields[var4];
                            var7 = var6.getInt(null);
                            var0.writeByte(0);
                            var0.writeInt(var7);
                        } else if (var5 == 1) {
                            var6 = var2.fields[var4];
                            var6.setInt(null, var2.fieldIntValues[var4]);
                            var0.writeByte(0);
                        } else if (var5 == 2) {
                            var6 = var2.fields[var4];
                            var7 = var6.getModifiers();
                            var0.writeByte(0);
                            var0.writeInt(var7);
                        }

                        Method var26;
                        if (var5 != 3) {
                            if (var5 == 4) {
                                var26 = var2.methods[var4];
                                var7 = var26.getModifiers();
                                var0.writeByte(0);
                                var0.writeInt(var7);
                            }
                        } else {
                            var26 = var2.methods[var4];
                            byte[][] var8 = var2.methodArgs[var4];
                            Object[] var9 = new Object[var8.length];

                            for (int var10 = 0; var10 < var8.length; ++var10) {
                                ObjectInputStream var11 = new ObjectInputStream(new ByteArrayInputStream(var8[var10]));
                                var9[var10] = var11.readObject();
                            }

                            Object var12 = var26.invoke(null, var9);
                            if (var12 == null) {
                                var0.writeByte(0);
                            } else if (var12 instanceof Number) {
                                var0.writeByte(1);
                                var0.writeLong(((Number) var12).longValue());
                            } else if (var12 instanceof String) {
                                var0.writeByte(2);
                                var0.writeCString((String) var12);
                            } else {
                                var0.writeByte(4);
                            }
                        }
                    } catch (ClassNotFoundException var14) {
                        var0.writeByte(-10);
                    } catch (InvalidClassException var15) {
                        var0.writeByte(-11);
                    } catch (StreamCorruptedException var16) {
                        var0.writeByte(-12);
                    } catch (OptionalDataException var17) {
                        var0.writeByte(-13);
                    } catch (IllegalAccessException var18) {
                        var0.writeByte(-14);
                    } catch (IllegalArgumentException var19) {
                        var0.writeByte(-15);
                    } catch (InvocationTargetException var20) {
                        var0.writeByte(-16);
                    } catch (SecurityException var21) {
                        var0.writeByte(-17);
                    } catch (IOException var22) {
                        var0.writeByte(-18);
                    } catch (NullPointerException var23) {
                        var0.writeByte(-19);
                    } catch (Exception var24) {
                        var0.writeByte(-20);
                    } catch (Throwable var25) {
                        var0.writeByte(-21);
                    }
                }
            }

            var0.writeCrc(var3);
            var2.unlink();
        }
    }
}
