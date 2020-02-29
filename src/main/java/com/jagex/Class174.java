package com.jagex;

public class Class174 implements Runnable {
    public static NodeDeque aNodeDeque1465;
    public static NodeDeque aNodeDeque1466;
    static Object anObject1463;
    static int anInt1464;

    static {
        aNodeDeque1465 = new NodeDeque();
        aNodeDeque1466 = new NodeDeque();
        anInt1464 = 0;
        anObject1463 = new Object();
    }

    Class174() {
    }

    public static void method1006(String var0, boolean var1, boolean var2) {
        Class26.method192(var0, var1, var2);
    }

    public void run() {
        try {
            while (true) {
                FileSystem var2;
                synchronized (aNodeDeque1465) {
                    var2 = (FileSystem) aNodeDeque1465.head();
                }

                if (var2 != null) {
                    if (var2.anInt380 == 0) {
                        var2.index.method1492((int) var2.key, var2.buffer, var2.buffer.length);
                        synchronized (aNodeDeque1465) {
                            var2.unlink();
                        }
                    } else if (var2.anInt380 == 1) {
                        var2.buffer = var2.index.method1490((int) var2.key);
                        synchronized (aNodeDeque1465) {
                            aNodeDeque1466.add(var2);
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
            Class8.method65(null, var17);
        }
    }
}
