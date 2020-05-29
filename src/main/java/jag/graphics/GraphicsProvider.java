package jag.graphics;

public abstract class GraphicsProvider {
    public static IndexedSprite aDoublyNode_Sub24_Sub4_1815;
    public int[] anIntArray1818;
    public int anInt1817;
    public int anInt1816;

    protected GraphicsProvider() {
    }

    public final void method1318() {
        JagGraphics.setTarget(this.anIntArray1818, this.anInt1817, this.anInt1816);
    }

    public abstract void method22(int var1, int var2);

    public abstract void method20(int var1, int var2, int var3, int var4);
}
