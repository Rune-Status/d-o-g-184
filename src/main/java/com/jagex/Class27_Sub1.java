package com.jagex;

public class Class27_Sub1 extends Class27 {
    static boolean aBoolean492;
    static int cameraY;
    static byte[][] aByteArrayArray493;
    final int anInt491;
    final Class7 aClass7_494;
    int anInt487;
    int anInt488;
    Class34 aClass34_489;
    int anInt490;

    Class27_Sub1(SceneOffset var1, SceneOffset var2, int var3, Class7 var4) {
        super(var1, var2);
        this.anInt491 = var3;
        this.aClass7_494 = var4;
        this.method341();
    }

    static void method342() {
        DoublyLinkedNode_Sub14.aReferenceCache385.method334();
        DoublyLinkedNode_Sub20.aReferenceCache385.method334();
        DoublyLinkedNode_Sub21.aReferenceCache700.method334();
        ObjectDefinition.aReferenceCache700.method334();
        ObjectDefinition.aReferenceCache1228.method334();
        ObjectDefinition.aReferenceCache1513.method334();
        ObjectDefinition.aReferenceCache1514.method334();
        NpcDefinition.cache.method334();
        NpcDefinition.modelCache.method334();
        InterfaceNode.method837();
        AnimationSequence.aReferenceCache700.method334();
        AnimationSequence.aReferenceCache1228.method334();
        Statics16.method887();
        Varpbit.aReferenceCache385.method334();
        Node_Sub16.method775();
        Class72.method389();
        HealthBarDefinition.cache.method334();
        HealthBarDefinition.aReferenceCache700.method334();
        DoublyLinkedNode_Sub17.aReferenceCache385.method334();
        TextureProviderImpl.method1513();
        DoublyLinkedNode_Sub15.aReferenceCache700.method334();
        Class223.method1341();
        InterfaceComponent.aReferenceCache1370.method334();
        InterfaceComponent.aReferenceCache1364.method334();
        InterfaceComponent.aReferenceCache1367.method334();
        InterfaceComponent.aReferenceCache1374.method334();
        ((TextureProviderImpl) JagGraphics3D.aTextureProvider783).method1514();
        RuneScript.aReferenceCache1647.method334();
        Class73.aCacheReferenceTable583.method902();
        Class65.aCacheReferenceTable526.method902();
        Boundary.aCacheReferenceTable1876.method902();
        Class74.aCacheReferenceTable586.method902();
        Class85.aCacheReferenceTable635.method902();
        Statics15.aCacheReferenceTable1234.method902();
        Class149.aCacheReferenceTable1188.method902();
        Class74.sprites.method902();
        ActionPrioritySetting.aCacheReferenceTable329.method902();
        client.aCacheReferenceTable948.method902();
        ClanMember.aCacheReferenceTable867.method902();
        Class38.aCacheReferenceTable348.method902();
    }

    Class34 method201() {
        return this.aClass34_489;
    }

    public int method199() {
        return this.anInt490;
    }

    void method341() {
        this.anInt490 = Class38.getObjectDefinition(this.anInt491).method1101().mapFunction;
        this.aClass34_489 = this.aClass7_494.method29(Class98.method545(this.anInt490));
        DoublyLinkedNode_Sub15 var1 = Class98.method545(this.method199());
        Sprite var2 = var1.method1083();
        if (var2 != null) {
            this.anInt488 = var2.width;
            this.anInt487 = var2.height;
        } else {
            this.anInt488 = 0;
            this.anInt487 = 0;
        }

    }

    int method198() {
        return this.anInt488;
    }

    int method197() {
        return this.anInt487;
    }
}
