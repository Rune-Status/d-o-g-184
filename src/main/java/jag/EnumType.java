package jag;

public interface EnumType {
    static EnumType getByOrdinal(EnumType[] var0, int var1) {

        for (EnumType var4 : var0) {
            if (var1 == var4.getOrdinal()) {
                return var4;
            }
        }

        return null;
    }

    int getOrdinal();
}
