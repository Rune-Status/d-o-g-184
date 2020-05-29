package jag;

import jag.game.GameEngine;
import jag.game.type.VarcInteger;
import jag.js5.DiskFile;
import jag.opcode.Buffer;
import jag.opcode.OldConnection;
import jag.opcode.RegionUpdateType;
import jag.statics.Statics55;

import java.io.EOFException;
import java.util.HashMap;
import java.util.Map;

public class Varcs {
    public static int cameraZ;
    public static int anInt614;
    final String[] aStringArray613;
    final Map<Integer, Object> aMap615;
    final boolean[] aBooleanArray616;
    boolean aBoolean611;
    long aLong612;

    public Varcs() {
        this.aBoolean611 = false;
        int var1 = Face.aArchive773.method901(19);
        this.aMap615 = new HashMap<>();
        this.aBooleanArray616 = new boolean[var1];

        int var2;
        for (var2 = 0; var2 < var1; ++var2) {
            VarcInteger var3 = (VarcInteger) VarcInteger.aReferenceCache385.get(var2);
            VarcInteger var4;
            if (var3 == null) {
                byte[] var5 = VarcInteger.aReferenceTable383.unpack(19, var2);
                var3 = new VarcInteger();
                if (var5 != null) {
                    var3.decode(new Buffer(var5));
                }

                VarcInteger.aReferenceCache385.put(var3, var2);
            }
            var4 = var3;

            this.aBooleanArray616[var2] = var4.aBoolean790;
        }

        var2 = 0;
        if (Face.aArchive773.method496(15)) {
            var2 = Face.aArchive773.method901(15);
        }

        this.aStringArray613 = new String[var2];
        this.method426();
    }

    DiskFile method427(boolean createNew) {
        return RegionUpdateType.method863("2", Statics55.anGameType_629.name, createNew);
    }

    public boolean persist() {
        return this.aBoolean611;
    }

    public void update() {
        DiskFile var1 = this.method427(true);

        try {
            int var2 = 3;
            int var3 = 0;

            for (Map.Entry<Integer, Object> entry : this.aMap615.entrySet()) {
                int id = entry.getKey();
                if (this.aBooleanArray616[id]) {
                    Object var7 = entry.getValue();
                    var2 += 3;
                    if (var7 instanceof Integer) {
                        var2 += 4;
                    } else if (var7 instanceof String) {
                        var2 += Buffer.stringLengthPlusOne((String) var7);
                    }

                    ++var3;
                }
            }

            Buffer var26 = new Buffer(var2);
            var26.writeByte(2);
            var26.writeShort(var3);

            for (Map.Entry<Integer, Object> entry : this.aMap615.entrySet()) {
                int id = entry.getKey();
                if (this.aBooleanArray616[id]) {
                    var26.writeShort(id);
                    Object var10 = entry.getValue();
                    SerializableProcessor processor = SerializableProcessor.valueOf(var10.getClass());
                    var26.writeByte(processor.anInt619);
                    Class<?> var12 = var10.getClass();

                    SerializableProcessor var13 = SerializableProcessor.valueOf(var12);
                    if (var13 == null) {
                        throw new IllegalArgumentException();
                    }

                    Serializable var14 = var13.value;
                    var14.method408(var10, var26);
                }
            }

            var1.write(var26.payload, 0, var26.caret);
        } catch (Exception ignored) {

        } finally {
            try {
                var1.close();
            } catch (Exception ignored) {

            }
        }

        this.aBoolean611 = false;
        this.aLong612 = GameEngine.currentTime();
    }

    void method426() {
        DiskFile var1 = this.method427(false);

        label227:
        {
            try {
                byte[] var2 = new byte[(int) var1.length()];

                int var4;
                for (int var3 = 0; var3 < var2.length; var3 += var4) {
                    var4 = var1.read(var2, var3, var2.length - var3);
                    if (var4 == -1) {
                        throw new EOFException();
                    }
                }

                Buffer var5 = new Buffer(var2);
                if (var5.payload.length - var5.caret < 1) {
                    return;
                }

                int var7 = var5.readUByte();
                if (var7 >= 0 && var7 <= 2) {
                    int var9;
                    int var10;
                    int var11;
                    int var12;
                    if (var7 >= 2) {
                        var9 = var5.readUShort();
                        var10 = 0;

                        while (true) {
                            if (var10 >= var9) {
                                break label227;
                            }

                            var11 = var5.readUShort();
                            var12 = var5.readUByte();
                            SerializableProcessor var13 = (SerializableProcessor) OldConnection.method716(SerializableProcessor.values(), var12);
                            Object var14 = var13.method454(var5);
                            if (this.aBooleanArray616[var11]) {
                                this.aMap615.put(var11, var14);
                            }

                            ++var10;
                        }
                    } else {
                        var9 = var5.readUShort();

                        for (var10 = 0; var10 < var9; ++var10) {
                            var11 = var5.readUShort();
                            var12 = var5.readInt();
                            if (this.aBooleanArray616[var11]) {
                                this.aMap615.put(var11, var12);
                            }
                        }

                        var10 = var5.readUShort();
                        var11 = 0;

                        while (true) {
                            if (var11 >= var10) {
                                break label227;
                            }

                            var5.readUShort();
                            var5.readString();
                            ++var11;
                        }
                    }
                }
            } catch (Exception var25) {
                break label227;
            } finally {
                try {
                    var1.close();
                } catch (Exception ignored) {
                }

            }

            return;
        }

        this.aBoolean611 = false;
    }

    public String method429(int var1) {
        return this.aStringArray613[var1];
    }

    public int getInt(int id) {
        Object value = this.aMap615.get(id);
        return value instanceof Integer ? (Integer) value : -1;
    }

    public String getString(int id) {
        Object value = this.aMap615.get(id);
        return value instanceof String ? (String) value : "";
    }

    public void put(int id, int value) {
        this.aMap615.put(id, value);
        if (this.aBooleanArray616[id]) {
            this.aBoolean611 = true;
        }

    }

    public void method431(int var1, String var2) {
        this.aStringArray613[var1] = var2;
    }

    public void put(int id, String value) {
        this.aMap615.put(id, value);
    }

    public void method430() {
        for (int i = 0; i < this.aBooleanArray616.length; ++i) {
            if (!this.aBooleanArray616[i]) {
                this.aMap615.remove(i);
            }
        }

        for (int i = 0; i < this.aStringArray613.length; ++i) {
            this.aStringArray613[i] = null;
        }

    }

    public void method425() {
        if (this.aBoolean611 && this.aLong612 < GameEngine.currentTime() - 60000L) {
            this.update();
        }

    }
}
