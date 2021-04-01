package jag.game.type;

import jag.commons.collection.Node;
import jag.opcode.Buffer;

public class Skeleton extends Node {

    public final int id;
    public final int count;
    public final int[] types;
    public final int[][] labels;

    Skeleton(int id, byte[] data) {
        this.id = id;

        Buffer buffer = new Buffer(data);
        count = buffer.g1();
        types = new int[count];
        labels = new int[count][];

        for (int i = 0; i < count; ++i) {
            types[i] = buffer.g1();
        }

        for (int i = 0; i < count; ++i) {
            labels[i] = new int[buffer.g1()];
        }

        for (int i = 0; i < count; ++i) {
            for (int j = 0; j < labels[i].length; ++j) {
                labels[i][j] = buffer.g1();
            }
        }
    }
}
