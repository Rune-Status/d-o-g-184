package jag;

import jag.game.client;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLRequestProcessor implements Runnable {
    public static int anInt797;
    public static String[] aStringArray794;
    final Thread aThread796;
    final java.util.Queue aQueue795;
    volatile boolean aBoolean798;

    public URLRequestProcessor() {
        this.aQueue795 = new java.util.LinkedList();
        this.aThread796 = new Thread(this);
        this.aThread796.setPriority(1);
        this.aThread796.start();
    }

    public static char method646(char var0) {
        return var0 != 181 && var0 != 402 ? Character.toTitleCase(var0) : var0;
    }

    public URLRequest method647(URL var1) {
        URLRequest var2 = new URLRequest(var1);
        synchronized (this) {
            this.aQueue795.add(var2);
            this.notify();
            return var2;
        }
    }

    public void release() {
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
                URLRequest var2;
                synchronized (this) {
                    var2 = (URLRequest) this.aQueue795.poll();
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
                client.sendError(null, var17);
            }
        }

    }
}
