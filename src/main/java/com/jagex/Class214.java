package com.jagex;

public class Class214 {
    boolean aBoolean1810;
    int anInt1808;
    ReferenceTable aReferenceTable1807;
    String aString1809;

    Class214(ReferenceTable var1) {
        this.anInt1808 = 0;
        this.aBoolean1810 = false;
        this.aReferenceTable1807 = var1;
    }

    int method1310() {
        if (this.anInt1808 < 33) {
            if (!this.aReferenceTable1807.method893(Class23.aClass23_298.aString292, this.aString1809)) {
                return this.anInt1808;
            }

            this.anInt1808 = 33;
        }

        if (this.anInt1808 == 33) {
            if (this.aReferenceTable1807.method906(Class23.aClass23_295.aString292, this.aString1809) && !this.aReferenceTable1807.method893(Class23.aClass23_295.aString292, this.aString1809)) {
                return this.anInt1808;
            }

            this.anInt1808 = 66;
        }

        if (this.anInt1808 == 66) {
            if (!this.aReferenceTable1807.method893(this.aString1809, Class23.aClass23_293.aString292)) {
                return this.anInt1808;
            }

            this.anInt1808 = 100;
            this.aBoolean1810 = true;
        }

        return this.anInt1808;
    }

    boolean method1308() {
        return this.aBoolean1810;
    }

    void method1309(String var1) {
        if (var1 != null && !var1.isEmpty()) {
            if (var1 != this.aString1809) {
                this.aString1809 = var1;
                this.anInt1808 = 0;
                this.aBoolean1810 = false;
                this.method1310();
            }
        }
    }

    int method1307() {
        return this.anInt1808;
    }
}
