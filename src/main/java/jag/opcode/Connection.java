package jag.opcode;

import jag.commons.time.Clock;
import jag.js5.Js5Worker;
import jag.js5.ResourceRequest;

import java.io.IOException;

public abstract class Connection {

    protected Connection() {

    }

    public static void destroy() {
        if (Js5Worker.connection != null) {
            Js5Worker.connection.stop();
        }

    }

    public static void method420(Connection var0, boolean var1) {
        if (Js5Worker.connection != null) {
            try {
                Js5Worker.connection.stop();
            } catch (Exception ignored) {
            }

            Js5Worker.connection = null;
        }

        Js5Worker.connection = var0;
        Js5Worker.kill(var1);
        Js5Worker.responseHeader.pos = 0;
        Js5Worker.current = null;
        Js5Worker.archiveBuffer = null;
        Js5Worker.anInt1499 = 0;

        while (true) {
            ResourceRequest var2 = Js5Worker.pendingPriorityRecv.head();
            if (var2 == null) {
                while (true) {
                    var2 = Js5Worker.pendingRecv.head();
                    if (var2 == null) {
                        if (Js5Worker.encryptionKey != 0) {
                            try {
                                Buffer var7 = new Buffer(4);
                                var7.p1(4);
                                var7.p1(Js5Worker.encryptionKey);
                                var7.p2(0);
                                Js5Worker.connection.write(var7.payload, 0, 4);
                            } catch (IOException var5) {
                                try {
                                    Js5Worker.connection.stop();
                                } catch (Exception ignored) {
                                }

                                ++Js5Worker.ioExceptionCount;
                                Js5Worker.connection = null;
                            }
                        }

                        Js5Worker.latency = 0;
                        Js5Worker.lastAttempt = Clock.now();
                        return;
                    }

                    Js5Worker.pendingQueue.add(var2);
                    Js5Worker.pending.put(var2, var2.key);
                    ++Js5Worker.pendingCount;
                    --Js5Worker.pendingResponseCount;
                }
            }

            Js5Worker.pendingPriority.put(var2, var2.key);
            ++Js5Worker.pendingPriorityCount;
            --Js5Worker.pendingPriorityResponseCount;
        }
    }

    public abstract void stop();

    public abstract boolean available(int amount) throws IOException;

    public abstract int read(byte[] payload, int caret, int length) throws IOException;

    public abstract void write(byte[] payload, int caret, int length) throws IOException;

    public abstract int available() throws IOException;

    public abstract int read() throws IOException;
}
