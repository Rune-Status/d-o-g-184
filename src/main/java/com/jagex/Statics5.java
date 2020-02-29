package com.jagex;

import java.io.File;

public class Statics5 {
    public static BufferedFile random;
    public static BufferedFile aBufferedFile_840;
    public static BufferedFile aBufferedFile_835;
    public static String aString839;
    public static int anInt834;
    public static int anInt838;
    static File aFile837;

    static {
        random = null;
        aBufferedFile_840 = null;
        aBufferedFile_835 = null;
    }

    public static DoublyLinkedNode_Sub17 method689(int var0) {
        DoublyLinkedNode_Sub17 var1 = (DoublyLinkedNode_Sub17) DoublyLinkedNode_Sub17.aReferenceCache385.get((long) var0);
        if (var1 != null) {
            return var1;
        }
        byte[] var2 = DoublyLinkedNode_Sub17.aReferenceTable383.unpack(34, var0);
        var1 = new DoublyLinkedNode_Sub17();
        if (var2 != null) {
            var1.method260(new Buffer(var2));
        }

        var1.method254();
        DoublyLinkedNode_Sub17.aReferenceCache385.put(var1, (long) var0);
        return var1;
    }
}
