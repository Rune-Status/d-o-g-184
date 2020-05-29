package jag;

import jag.game.client;
import jag.game.relationship.AssociateComparatorByName;
import jag.game.relationship.RelationshipSystem;
import jag.js5.Bzip2Entry;
import jag.statics.Statics1;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SecureRandomService {

    public static int anInt457;
    public static int anInt458;
    public static SecureRandom aSecureRandom864;

    final Future<SecureRandom> future;
    ExecutorService executor;

    public SecureRandomService() {
        executor = Executors.newSingleThreadExecutor();
        future = executor.submit(new SecureRandomCallable());
    }

    public static void method317() {
        for (int var0 = 0; var0 < client.menuRowCount; ++var0) {
            if (Bzip2Entry.method1169(client.menuOpcodes[var0])) {
                if (var0 < client.menuRowCount - 1) {
                    for (int var1 = var0; var1 < client.menuRowCount - 1; ++var1) {
                        client.menuActions[var1] = client.menuActions[var1 + 1];
                        client.menuTargets[var1] = client.menuTargets[var1 + 1];
                        client.menuOpcodes[var1] = client.menuOpcodes[var1 + 1];
                        client.menuPrimaryArgs[var1] = client.menuPrimaryArgs[var1 + 1];
                        client.menuSecondaryArgs[var1] = client.menuSecondaryArgs[var1 + 1];
                        client.menuTertiaryArgs[var1] = client.menuTertiaryArgs[var1 + 1];
                        client.menuShiftClickActions[var1] = client.menuShiftClickActions[var1 + 1];
                    }
                }

                --var0;
                --client.menuRowCount;
            }
        }

        AssociateComparatorByName.openMenu(RelationshipSystem.anInt319 / 2 + URLRequestProcessor.anInt797, Statics1.anInt321);
    }

    public static SecureRandom provide() {
        SecureRandom random = new SecureRandom();
        random.nextInt();
        return random;
    }

    public boolean isDone() {
        return this.future.isDone();
    }

    public SecureRandom get() {
        try {
            return this.future.get();
        } catch (Exception var2) {
            return provide();
        }
    }

    public void kill() {
        this.executor.shutdown();
        this.executor = null;
    }
}
