package jag;

public class DefaultOperatingSystemProvider implements OperatingSystemProvider {

    public static String aString845;
    public static String aString407;

    int anInt1866;
    int anInt1865;
    int anInt1864;

    void parseOldVersion(String var1) {
        String[] var2 = var1.split("\\.");

        try {
            anInt1866 = Integer.parseInt(var2[1]);
            var2 = var2[2].split("_");
            anInt1865 = Integer.parseInt(var2[0]);
            anInt1864 = Integer.parseInt(var2[1]);
        } catch (Exception ignored) {
        }

    }

    void parseNewVersion(String var1) {
        String[] var2 = var1.split("\\.");

        try {
            anInt1866 = Integer.parseInt(var2[0]);
            anInt1865 = Integer.parseInt(var2[1]);
            anInt1864 = Integer.parseInt(var2[2]);
        } catch (Exception ignored) {
        }

    }

    void parseVersion(String var1) {
        if (var1.startsWith("1.")) {
            parseOldVersion(var1);
        } else {
            parseNewVersion(var1);
        }
    }

    public OperatingSystemNode provide() {
        byte var1;
        if (aString845.startsWith("win")) {
            var1 = 1;
        } else if (aString845.startsWith("mac")) {
            var1 = 2;
        } else if (aString845.startsWith("linux")) {
            var1 = 3;
        } else {
            var1 = 4;
        }

        String var2;
        try {
            var2 = System.getProperty("os.arch").toLowerCase();
        } catch (Exception var22) {
            var2 = "";
        }

        String var4;
        try {
            var4 = System.getProperty("os.version").toLowerCase();
        } catch (Exception var21) {
            var4 = "";
        }

        String var3 = "Unknown";
        String var5 = "1.1";

        try {
            var3 = System.getProperty("java.vendor");
            var5 = System.getProperty("java.version");
        } catch (Exception ignored) {
        }

        boolean var7 = var2.startsWith("amd64") || var2.startsWith("x86_64");

        byte var8 = 0;
        if (var1 == 1) {
            if (var4.contains("4.0")) {
                var8 = 1;
            } else if (var4.contains("4.1")) {
                var8 = 2;
            } else if (var4.contains("4.9")) {
                var8 = 3;
            } else if (var4.contains("5.0")) {
                var8 = 4;
            } else if (var4.contains("5.1")) {
                var8 = 5;
            } else if (var4.contains("5.2")) {
                var8 = 8;
            } else if (var4.contains("6.0")) {
                var8 = 6;
            } else if (var4.contains("6.1")) {
                var8 = 7;
            } else if (var4.contains("6.2")) {
                var8 = 9;
            } else if (var4.contains("6.3")) {
                var8 = 10;
            } else if (var4.contains("10.0")) {
                var8 = 11;
            }
        } else if (var1 == 2) {
            if (var4.contains("10.4")) {
                var8 = 20;
            } else if (var4.contains("10.5")) {
                var8 = 21;
            } else if (var4.contains("10.6")) {
                var8 = 22;
            } else if (var4.contains("10.7")) {
                var8 = 23;
            } else if (var4.contains("10.8")) {
                var8 = 24;
            } else if (var4.contains("10.9")) {
                var8 = 25;
            } else if (var4.contains("10.10")) {
                var8 = 26;
            } else if (var4.contains("10.11")) {
                var8 = 27;
            } else if (var4.contains("10.12")) {
                var8 = 28;
            } else if (var4.contains("10.13")) {
                var8 = 29;
            }
        }

        byte var9;
        if (var3.toLowerCase().contains("sun")) {
            var9 = 1;
        } else if (var3.toLowerCase().contains("microsoft")) {
            var9 = 2;
        } else if (var3.toLowerCase().contains("apple")) {
            var9 = 3;
        } else if (var3.toLowerCase().contains("oracle")) {
            var9 = 5;
        } else {
            var9 = 4;
        }

        parseVersion(var5);
        int var10 = (int) (Runtime.getRuntime().maxMemory() / 1048576L) + 1;
        int var11;
        if (anInt1866 > 3) {
            var11 = Runtime.getRuntime().availableProcessors();
        } else {
            var11 = 0;
        }

        byte var12 = 0;
        String var13 = "";
        String var14 = "";
        String var15 = "";
        String var16 = "";
        String var17 = "";
        String var18 = "";
        int[] var19 = new int[3];
        return new OperatingSystemNode(var1, var7, var8, var9, anInt1866, anInt1865, anInt1864, var10, var11, var12, var13, var14, var15, var16, var17, var18, var19);
    }
}
