package jag;

public class ClientParameter {

    public static final ClientParameter A_CLIENT_PARAMETER___1801;
    public static final ClientParameter A_CLIENT_PARAMETER___1799;
    static final ClientParameter A_CLIENT_PARAMETER___1803;
    static final ClientParameter A_CLIENT_PARAMETER___1798;
    static final ClientParameter A_CLIENT_PARAMETER___1797;
    static final ClientParameter A_CLIENT_PARAMETER___1795;
    static final ClientParameter A_CLIENT_PARAMETER___1793;
    static final ClientParameter A_CLIENT_PARAMETER___1794;
    static final ClientParameter A_CLIENT_PARAMETER___1802;

    static {
        A_CLIENT_PARAMETER___1801 = new ClientParameter(7);
        A_CLIENT_PARAMETER___1803 = new ClientParameter(5);
        A_CLIENT_PARAMETER___1798 = new ClientParameter(6);
        A_CLIENT_PARAMETER___1797 = new ClientParameter(2);
        A_CLIENT_PARAMETER___1795 = new ClientParameter(4);
        A_CLIENT_PARAMETER___1793 = new ClientParameter(0);
        A_CLIENT_PARAMETER___1794 = new ClientParameter(8);
        A_CLIENT_PARAMETER___1802 = new ClientParameter(3);
        A_CLIENT_PARAMETER___1799 = new ClientParameter();
    }

    public final int anInt1800;
    final String name;

    ClientParameter(int var1) {
        this.anInt1800 = var1;
        this.name = "";
    }

    ClientParameter() {
        this.anInt1800 = 1;
        this.name = "";
    }

    public String toString() {
        return this.name;
    }
}
