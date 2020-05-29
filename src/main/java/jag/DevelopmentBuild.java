package jag;

public class DevelopmentBuild {

    public static final DevelopmentBuild LIVE;
    public static final DevelopmentBuild BUILDLIVE;
    public static final DevelopmentBuild RC;
    public static final DevelopmentBuild WIP;

    static {
        LIVE = new DevelopmentBuild("LIVE", 0);
        BUILDLIVE = new DevelopmentBuild("BUILDLIVE", 3);
        RC = new DevelopmentBuild("RC", 1);
        WIP = new DevelopmentBuild("WIP", 2);
    }

    public final String name;
    public final int index;

    DevelopmentBuild(String var1, int var2) {
        this.name = var1;
        this.index = var2;
    }

    public static DevelopmentBuild valueOf(int index) {
        for (DevelopmentBuild value : new DevelopmentBuild[]{BUILDLIVE, LIVE, RC, WIP}) {
            if (index == value.index) {
                return value;
            }
        }
        return null;
    }
}
