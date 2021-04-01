package jag.opcode.handler;

import jag.opcode.PacketBuffer;

public interface IncomingPacketHandler {

    void processClassStructure(PacketBuffer buffer, int len);

    void processGc();
}
