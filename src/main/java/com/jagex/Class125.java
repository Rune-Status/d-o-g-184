package com.jagex;

import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Class125 implements Runnable {
    public static String aString855;
    public static String aString856;
    protected static boolean aBoolean853;
    static ReferenceTable aReferenceTable854;
    boolean aBoolean849;
    OldConnectionTask aOldConnectionTask_852;
    Thread aThread850;
    OldConnectionTask aOldConnectionTask_851;

    public Class125() {
        this.aOldConnectionTask_852 = null;
        this.aOldConnectionTask_851 = null;
        this.aBoolean849 = false;
        aString855 = "Unknown";
        aString856 = "1.6";

        try {
            aString855 = System.getProperty("java.vendor");
            aString856 = System.getProperty("java.version");
        } catch (Exception ignored) {
        }

        this.aBoolean849 = false;
        this.aThread850 = new Thread(this);
        this.aThread850.setPriority(10);
        this.aThread850.setDaemon(true);
        this.aThread850.start();
    }

    static double method700(double var0, double var2, double var4) {
        double var6 = (var0 - var2) / var4;
        double var8 = Math.exp(-var6 * var6 / 2.0D) / Math.sqrt(6.283185307179586D);
        return var8 / var4;
    }

    final OldConnectionTask method701(int var1, int var2, Object var4) {
        OldConnectionTask var5 = new OldConnectionTask();
        var5.anInt883 = var1;
        var5.anInt884 = var2;
        var5.anObject888 = var4;
        synchronized (this) {
            if (this.aOldConnectionTask_851 != null) {
                this.aOldConnectionTask_851.aOldConnectionTask_887 = var5;
                this.aOldConnectionTask_851 = var5;
            } else {
                this.aOldConnectionTask_851 = this.aOldConnectionTask_852 = var5;
            }

            this.notify();
            return var5;
        }
    }

    public final OldConnectionTask method697(Runnable var1, int var2) {
        return this.method701(2, var2, var1);
    }

    public final void method699() {
        synchronized (this) {
            this.aBoolean849 = true;
            this.notifyAll();
        }

        try {
            this.aThread850.join();
        } catch (InterruptedException ignored) {
        }

    }

    public final OldConnectionTask method698(String var1, int var2) {
        return this.method701(1, var2, var1);
    }

    public final void run() {
        while (true) {
            OldConnectionTask var2;
            synchronized (this) {
                while (true) {
                    if (this.aBoolean849) {
                        return;
                    }

                    if (this.aOldConnectionTask_852 != null) {
                        var2 = this.aOldConnectionTask_852;
                        this.aOldConnectionTask_852 = this.aOldConnectionTask_852.aOldConnectionTask_887;
                        if (this.aOldConnectionTask_852 == null) {
                            this.aOldConnectionTask_851 = null;
                        }
                        break;
                    }

                    try {
                        this.wait();
                    } catch (InterruptedException ignored) {
                    }
                }
            }

            try {
                int var5 = var2.anInt883;
                if (var5 == 1) {
                    var2.anObject886 = new Socket(InetAddress.getByName((String) var2.anObject888), var2.anInt884);
                } else if (var5 == 2) {
                    Thread var3 = new Thread((Runnable) var2.anObject888);
                    var3.setDaemon(true);
                    var3.start();
                    var3.setPriority(var2.anInt884);
                    var2.anObject886 = var3;
                } else if (var5 == 4) {
                    var2.anObject886 = new DataInputStream(((URL) var2.anObject888).openStream());
                }

                var2.anInt885 = 1;
            } catch (ThreadDeath var6) {
                throw var6;
            } catch (Throwable var7) {
                var2.anInt885 = 2;
            }
        }
    }
}
