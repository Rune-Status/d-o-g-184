package jag;

import jag.commons.time.Clock;
import jag.game.type.VarcInteger;
import jag.js5.Archive;
import jag.js5.DiskFile;
import jag.opcode.Buffer;
import jag.opcode.RegionUpdateType;
import jag.statics.Statics55;

import java.io.EOFException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Varcs {

    public static int anInt614;
    final String[] strings;
    final Map<Integer, Object> values;
    final boolean[] persistentIntegers;
    boolean persistent;
    long lastUpdateTime;

    public Varcs() {
        persistent = false;
        int count = Archive.config.getFileCount(19);
        values = new HashMap<>();
        persistentIntegers = new boolean[count];

        for (int i = 0; i < count; ++i) {
            VarcInteger var3 = VarcInteger.cache.get(i);
            VarcInteger var4;
            if (var3 == null) {
                byte[] var5 = VarcInteger.aReferenceTable383.unpack(19, i);
                var3 = new VarcInteger();
                if (var5 != null) {
                    var3.decode(new Buffer(var5));
                }

                VarcInteger.cache.put(var3, i);
            }
            var4 = var3;

            persistentIntegers[i] = var4.aBoolean790;
        }

        int stringCount = 0;
        if (Archive.config.isPresent(15)) {
            stringCount = Archive.config.getFileCount(15);
        }

        strings = new String[stringCount];
        decode();
    }

    DiskFile getPreferences(boolean createNew) {
        return RegionUpdateType.method863("2", Statics55.gameType.name, createNew);
    }

    public boolean persist() {
        return persistent;
    }

    public void update() {
        DiskFile preferences = getPreferences(true);

        try {
            int payloadSize = 3;
            int entrySize = 0;

            for (Map.Entry<Integer, Object> entry : values.entrySet()) {
                int id = entry.getKey();
                if (persistentIntegers[id]) {
                    Object var7 = entry.getValue();
                    payloadSize += 3;
                    if (var7 instanceof Integer) {
                        payloadSize += 4;
                    } else if (var7 instanceof String) {
                        payloadSize += Buffer.stringLengthPlusOne((String) var7);
                    }

                    ++entrySize;
                }
            }

            Buffer buffer = new Buffer(payloadSize);
            buffer.p1(2);
            buffer.p2(entrySize);

            for (Map.Entry<Integer, Object> entry : values.entrySet()) {
                int id = entry.getKey();
                if (persistentIntegers[id]) {
                    buffer.p2(id);
                    Object obj = entry.getValue();
                    SerializableProcessor processor = SerializableProcessor.valueOf(obj.getClass());
                    buffer.p1(processor.ordinal);
                    Serializable value = processor.value;
                    value.encode(obj, buffer);
                }
            }

            preferences.write(buffer.payload, 0, buffer.pos);
        } catch (Exception ignored) {

        } finally {
            try {
                preferences.close();
            } catch (Exception ignored) {

            }
        }

        persistent = false;
        lastUpdateTime = Clock.now();
    }

    void decode() {
        DiskFile preferences = getPreferences(false);

        label227:
        {
            try {
                byte[] payload = new byte[(int) preferences.length()];

                int read;
                for (int i = 0; i < payload.length; i += read) {
                    read = preferences.read(payload, i, payload.length - i);
                    if (read == -1) {
                        throw new EOFException();
                    }
                }

                Buffer buffer = new Buffer(payload);
                if (buffer.payload.length - buffer.pos < 1) {
                    return;
                }

                int type = buffer.g1();
                if (type >= 0 && type <= 2) {
                    if (type >= 2) {
                        int count = buffer.g2();
                        int ptr = 0;

                        while (true) {
                            if (ptr >= count) {
                                break label227;
                            }

                            int index = buffer.g2();
                            int ordinal = buffer.g1();
                            SerializableProcessor processor = (SerializableProcessor) EnumType.getByOrdinal(SerializableProcessor.values(), ordinal);
                            Object value = processor.decode(buffer);
                            if (persistentIntegers[index]) {
                                values.put(index, value);
                            }

                            ++ptr;
                        }
                    } else {
                        int count = buffer.g2();
                        for (int i = 0; i < count; ++i) {
                            int key = buffer.g2();
                            int value = buffer.g4();
                            if (persistentIntegers[key]) {
                                values.put(key, value);
                            }
                        }

                        int var10 = buffer.g2();
                        int var11 = 0;
                        while (true) {
                            if (var11 >= var10) {
                                break label227;
                            }

                            buffer.g2();
                            buffer.gstr();
                            ++var11;
                        }
                    }
                }
            } catch (Exception e) {
                break label227;
            } finally {
                try {
                    preferences.close();
                } catch (Exception ignored) {
                }

            }

            return;
        }

        persistent = false;
    }

    public String getRawString(int var1) {
        return strings[var1];
    }

    public int getInt(int id) {
        Object value = values.get(id);
        return value instanceof Integer ? (Integer) value : -1;
    }

    public String getString(int id) {
        Object value = values.get(id);
        return value instanceof String ? (String) value : "";
    }

    public void put(int id, int value) {
        values.put(id, value);
        if (persistentIntegers[id]) {
            persistent = true;
        }

    }

    public void putRawString(int var1, String var2) {
        strings[var1] = var2;
    }

    public void put(int id, String value) {
        values.put(id, value);
    }

    public void clear() {
        for (int i = 0; i < persistentIntegers.length; ++i) {
            if (!persistentIntegers[i]) {
                values.remove(i);
            }
        }

        Arrays.fill(strings, null);

    }

    public void updateIfRequired() {
        if (persistent && lastUpdateTime < Clock.now() - 60000L) {
            update();
        }
    }
}