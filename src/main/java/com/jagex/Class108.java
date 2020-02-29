package com.jagex;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class Class108 implements Runnable {
    static int anInt797;
    static String[] aStringArray794;
    final Thread aThread796;
    volatile boolean aBoolean798;
    java.util.Queue aQueue795;

    public Class108() {
        this.aQueue795 = new java.util.LinkedList();
        this.aThread796 = new Thread(this);
        this.aThread796.setPriority(1);
        this.aThread796.start();
    }

    static char method646(char var0) {
        return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
    }

    public Class105 method647(URL var1) {
        Class105 var2 = new Class105(var1);
        synchronized (this) {
            this.aQueue795.add(var2);
            this.notify();
            return var2;
        }
    }

    public void method648() {
        this.aBoolean798 = true;

        try {
            synchronized (this) {
                this.notify();
            }

            this.aThread796.join();
        } catch (InterruptedException ignored) {
        }

    }

    public void run() {
        while (!this.aBoolean798) {
            try {
                Class105 var2;
                synchronized (this) {
                    var2 = (Class105) this.aQueue795.poll();
                    if (var2 == null) {
                        try {
                            this.wait();
                        } catch (InterruptedException ignored) {
                        }
                        continue;
                    }
                }

                DataInputStream var1 = null;
                URLConnection var3 = null;

                try {
                    var3 = var2.anURL778.openConnection();
                    var3.setConnectTimeout(5000);
                    var3.setReadTimeout(5000);
                    var3.setUseCaches(false);
                    var3.setRequestProperty("Connection", "close");
                    int var5 = var3.getContentLength();
                    if (var5 >= 0) {
                        byte[] var6 = new byte[var5];
                        var1 = new DataInputStream(var3.getInputStream());
                        var1.readFully(var6);
                        var2.aByteArray776 = var6;
                    }

                    var2.aBoolean779 = true;
                } catch (IOException var14) {
                    var2.aBoolean779 = true;
                } finally {
                    if (var1 != null) {
                        var1.close();
                    }

                    if (var3 instanceof HttpURLConnection) {
                        ((HttpURLConnection) var3).disconnect();
                    }

                }
            } catch (Exception var17) {
                Class8.method65(null, var17);
            }
        }

    }
}
