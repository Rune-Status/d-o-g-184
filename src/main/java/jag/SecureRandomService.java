package jag;

import jag.game.menu.ContextMenu;
import jag.js5.Bzip2Entry;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecureRandomService {

    public static int anInt457;
    public static int anInt458;
    public static SecureRandom instance;

    final Future<SecureRandom> future;
    ExecutorService executor;

    public SecureRandomService() {
        executor = Executors.newSingleThreadExecutor();
        future = executor.submit(new SecureRandomCallable());
    }

    public static void method317() {
        for (int i = 0; i < ContextMenu.rowCount; ++i) {
            if (Bzip2Entry.method1169(ContextMenu.opcodes[i])) {
                if (i < ContextMenu.rowCount - 1) {
                    for (int j = i; j < ContextMenu.rowCount - 1; ++j) {
                        ContextMenu.actions[j] = ContextMenu.actions[j + 1];
                        ContextMenu.targets[j] = ContextMenu.targets[j + 1];
                        ContextMenu.opcodes[j] = ContextMenu.opcodes[j + 1];
                        ContextMenu.primaryArgs[j] = ContextMenu.primaryArgs[j + 1];
                        ContextMenu.secondaryArgs[j] = ContextMenu.secondaryArgs[j + 1];
                        ContextMenu.tertiaryArgs[j] = ContextMenu.tertiaryArgs[j + 1];
                        ContextMenu.shiftClickActions[j] = ContextMenu.shiftClickActions[j + 1];
                    }
                }

                --i;
                --ContextMenu.rowCount;
            }
        }

        ContextMenu.open(ContextMenu.width / 2 + ContextMenu.x, ContextMenu.y);
    }

    public static SecureRandom provide() {
        SecureRandom random = new SecureRandom();
        random.nextInt();
        return random;
    }

    public boolean isDone() {
        return future.isDone();
    }

    public SecureRandom get() {
        try {
            return future.get();
        } catch (Exception e) {
            return provide();
        }
    }

    public void kill() {
        executor.shutdown();
        executor = null;
    }
}
