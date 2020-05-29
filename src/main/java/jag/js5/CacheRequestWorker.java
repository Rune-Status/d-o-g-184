package jag.js5;

import jag.commons.collection.NodeDeque;
import jag.game.GameEngine;
import jag.game.client;
import jag.opcode.Buffer;

public class CacheRequestWorker implements Runnable {

    public static final NodeDeque<CacheRequest> requests;
    public static final NodeDeque<CacheRequest> read;
    public static final Object anObject1463;
    public static int anInt1464;
    public static Thread thread;
    public static Buffer buffer;

    static {
        requests = new NodeDeque<>();
        read = new NodeDeque<>();
        anInt1464 = 0;
        anObject1463 = new Object();
    }

    public CacheRequestWorker() {

    }

    public static void method1006(String var0, boolean var1, boolean var2) {
        GameEngine.method192(var0, var1, var2);
    }

    public static void release() {
        synchronized (anObject1463) {
            if (anInt1464 != 0) {
                anInt1464 = 1;

                try {
                    anObject1463.wait();
                } catch (InterruptedException ignored) {

                }
            }

        }
    }

    public void run() {
        try {
            while (true) {
                CacheRequest request;
                synchronized (requests) {
                    request = requests.head();
                }

                if (request != null) {
                    if (request.type == 0) {
                        request.cache.write((int) request.key, request.data, request.data.length);
                        synchronized (requests) {
                            request.unlink();
                        }
                    } else if (request.type == 1) {
                        request.data = request.cache.read((int) request.key);
                        synchronized (requests) {
                            read.add(request);
                        }
                    }

                    synchronized (anObject1463) {
                        if (anInt1464 <= 1) {
                            anInt1464 = 0;
                            anObject1463.notifyAll();
                            return;
                        }

                        anInt1464 = 600;
                    }
                } else {
                    long var7 = 99L;

                    try {
                        Thread.sleep(var7);
                    } catch (InterruptedException ignored) {
                    }

                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException ignored) {
                    }

                    synchronized (anObject1463) {
                        if (anInt1464 <= 1) {
                            anInt1464 = 0;
                            anObject1463.notifyAll();
                            return;
                        }

                        --anInt1464;
                    }
                }
            }
        } catch (Exception var17) {
            client.sendError(null, var17);
        }
    }
}
