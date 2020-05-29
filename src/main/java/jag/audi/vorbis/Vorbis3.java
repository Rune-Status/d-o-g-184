package jag.audi.vorbis;

public class Vorbis3 {
    final int anInt707;
    final int[] anIntArray706;
    final int[] anIntArray705;
    int anInt708;

    Vorbis3() {
        Vorbis9.method396(16);
        anInt707 = Vorbis9.method397() != 0 ? Vorbis9.method396(4) + 1 : 1;
        if (Vorbis9.method397() != 0) {
            Vorbis9.method396(8);
        }

        Vorbis9.method396(2);
        if (anInt707 > 1) {
            anInt708 = Vorbis9.method396(4);
        }

        anIntArray706 = new int[anInt707];
        anIntArray705 = new int[anInt707];

        for (int i = 0; i < anInt707; ++i) {
            Vorbis9.method396(8);
            anIntArray706[i] = Vorbis9.method396(8);
            anIntArray705[i] = Vorbis9.method396(8);
        }

    }
}
