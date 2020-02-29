package com.jagex;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassStructure extends Node {
    static Sprite[] hitmarks;
    static int anInt748;
    int size;
    int elementCount;
    int[] errors;
    int[] types;
    Field[] fields;
    int[] fieldIntValues;
    Method[] methods;
    byte[][][] methodArgs;

    ClassStructure() {
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
                            var14[var13] = TextureProviderImpl.method1515(var8[var13]);
                        }

                        Class var15 = TextureProviderImpl.method1515(var10);
                        if (TextureProviderImpl.method1515(var5).getClassLoader() == null) {
                            throw new SecurityException();
                        }

                        for (Method var19 : TextureProviderImpl.method1515(var5).getDeclaredMethods()) {
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
                    if (TextureProviderImpl.method1515(var5).getClassLoader() == null) {
                        throw new SecurityException();
                    }

                    struc.fields[var3] = TextureProviderImpl.method1515(var5).getDeclaredField(var6);
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
}
