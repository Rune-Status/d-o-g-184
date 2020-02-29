package com.jagex;

import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Class53 {
    public static int anInt457;
    static int anInt458;
    Future aFuture456;
    ExecutorService anExecutorService455;

    Class53() {
        this.anExecutorService455 = Executors.newSingleThreadExecutor();
        this.aFuture456 = this.anExecutorService455.submit(new Class42());
    }

    static void method317() {
        for (int var0 = 0; var0 < client.menuRowCount; ++var0) {
            if (Bzip2Context.method1169(client.menuOpcodes[var0])) {
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

        AssociateComparatorByName.openMenu(SocialSystem.anInt319 / 2 + Class108.anInt797, Statics1.anInt321);
    }

    boolean method319() {
        return this.aFuture456.isDone();
    }

    SecureRandom method316() {
        try {
            return (SecureRandom) this.aFuture456.get();
        } catch (Exception var2) {
            return ActionPrioritySetting.method226();
        }
    }

    void method318() {
        this.anExecutorService455.shutdown();
        this.anExecutorService455 = null;
    }
}
