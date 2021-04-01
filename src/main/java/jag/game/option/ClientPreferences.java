package jag.game.option;

import jag.opcode.Buffer;

import java.util.LinkedHashMap;
import java.util.Map;

public class ClientPreferences {

    public static final int CAPACITY;

    static {
        CAPACITY = 6;
    }

    public int resizable;
    public String rememberedUsername;
    public boolean roofsHidden;
    public boolean rememberMe;
    public LinkedHashMap<Integer, Integer> properties;
    public boolean loginScreenAudioDisabled;

    public ClientPreferences() {
        resizable = 1;
        rememberedUsername = null;
        rememberMe = false;
        properties = new LinkedHashMap<>();
    }

    public ClientPreferences(Buffer buffer) {
        resizable = 1;
        rememberedUsername = null;
        rememberMe = false;
        properties = new LinkedHashMap<>();

        if (buffer != null && buffer.payload != null) {
            int size = buffer.g1();
            if (size >= 0 && size <= ClientPreferences.CAPACITY) {
                if (buffer.g1() == 1) {
                    roofsHidden = true;
                }

                if (size > 1) {
                    loginScreenAudioDisabled = buffer.g1() == 1;
                }

                if (size > 3) {
                    resizable = buffer.g1();
                }

                if (size > 2) {
                    int pcount = buffer.g1();

                    for (int i = 0; i < pcount; ++i) {
                        int k = buffer.g4();
                        int v = buffer.g4();
                        properties.put(k, v);
                    }
                }

                if (size > 4) {
                    rememberedUsername = buffer.fastgstr();
                }

                if (size > 5) {
                    rememberMe = buffer.gbool();
                }
            }
        }
    }

    public Buffer createOutputBuffer() {
        Buffer buffer = new Buffer(100);
        buffer.p1(CAPACITY);
        buffer.p1(roofsHidden ? 1 : 0);
        buffer.p1(loginScreenAudioDisabled ? 1 : 0);
        buffer.p1(resizable);
        buffer.p1(properties.size());

        for (Map.Entry<Integer, Integer> entry : properties.entrySet()) {
            buffer.p4(entry.getKey());
            buffer.p4(entry.getValue());
        }

        buffer.pcstr(rememberedUsername != null ? rememberedUsername : "");
        buffer.pbool(rememberMe);
        return buffer;
    }
}
