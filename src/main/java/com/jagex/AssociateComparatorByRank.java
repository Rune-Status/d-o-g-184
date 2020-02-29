package com.jagex;

public class AssociateComparatorByRank extends AssociateComparator {
    final boolean aBoolean764;

    public AssociateComparatorByRank(boolean var1) {
        this.aBoolean764 = var1;
    }

    static int method679() {
        return client.menuRowCount - 1;
    }

    int method604(Associate var1, Associate var2) {
        if (var2.rank != var1.rank) {
            return this.aBoolean764 ? var1.rank - var2.rank : var2.rank - var1.rank;
        }
        return this.method1135(var1, var2);
    }

    public int compare(Associate var1, Associate var2) {
        return this.method604(var1, var2);
    }
}
