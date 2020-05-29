package jag;

public enum ComponentFillType implements EnumType {

    anEnum_Sub11_1862(0, 0),
    anEnum_Sub11_1863(1, 1),
    anEnum_Sub11_1861(2, 2);

    public final int anInt633;
    final int anInt619;

    ComponentFillType(int var3, int var4) {
        this.anInt633 = var3;
        this.anInt619 = var4;
    }

    public static ComponentFillType[] getValues() {
        return new ComponentFillType[]{anEnum_Sub11_1863, anEnum_Sub11_1862, anEnum_Sub11_1861};
    }

    public int getOrdinal() {
        return this.anInt619;
    }
}
