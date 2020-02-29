package com.jagex;

import java.io.File;
import java.util.Comparator;

public class Class38 implements Comparator {
    public static File aFile346;
    public static ReferenceTable aReferenceTable350;
    static int cameraX;
    static Font aFont345;
    static InterfaceComponent anInterfaceComponent351;
    static int anInt347;
    static CacheReferenceTable aCacheReferenceTable348;
    boolean aBoolean349;

    Class38() {
    }

    public static ObjectDefinition getObjectDefinition(int var0) {
        ObjectDefinition var2 = (ObjectDefinition) ObjectDefinition.aReferenceCache700.get((long) var0);
        if (var2 != null) {
            return var2;
        }
        byte[] var3 = ObjectDefinition.aReferenceTable697.unpack(6, var0);
        var2 = new ObjectDefinition();
        var2.anInt693 = var0;
        if (var3 != null) {
            var2.method260(new Buffer(var3));
        }

        var2.method254();
        if (var2.solid) {
            var2.anInt791 = 0;
            var2.impenetrable = false;
        }

        ObjectDefinition.aReferenceCache700.put(var2, (long) var0);
        return var2;
    }

    static Chatline method246(int var0) {
        return (Chatline) Class64.A_ITERABLE_NODE_TABLE_523.lookup((long) var0);
    }

    int method247(Class72 var1, Class72 var2) {
        if (var2.anInt552 == var1.anInt552) {
            return 0;
        }
        if (this.aBoolean349) {
            if (client.currentWorld == var1.anInt552) {
                return -1;
            }

            if (var2.anInt552 == client.currentWorld) {
                return 1;
            }
        }

        return var1.anInt552 < var2.anInt552 ? -1 : 1;
    }

    public int compare(Object var1, Object var2) {
        return this.method247((Class72) var1, (Class72) var2);
    }

    public boolean equals(Object var1) {
        return super.equals(var1);
    }
}
