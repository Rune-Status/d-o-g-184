package jag.opcode;

import jag.game.Server;
import jag.game.client;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;

public class AsyncConnection extends Connection {

    public static int anInt1210;
    final Socket socket;
    AsyncOutputStream output;
    AsyncInputStream input;

    public AsyncConnection(Socket socket, int inputCapacity, int outputCapacity) throws IOException {
        this.socket = socket;
        socket.setSoTimeout(30000);
        socket.setTcpNoDelay(true);
        socket.setReceiveBufferSize(65536);
        socket.setSendBufferSize(65536);
        input = new AsyncInputStream(socket.getInputStream(), inputCapacity);
        output = new AsyncOutputStream(socket.getOutputStream(), outputCapacity);
    }

    public static boolean loadServers() {
        try {
            if (Server.request == null) {
                Server.request = client.urlRequestProcessor.enqueue(new URL(Server.slu));
            } else if (Server.request.isComplete()) {
                byte[] data = Server.request.getData();
                Buffer buffer = new Buffer(data);
                buffer.g4();
                Server.count = buffer.g2();
                Server.servers = new Server[Server.count];

                int i = 0;
                while (i < Server.count) {
                    Server server = Server.servers[i] = new Server();
                    server.id = buffer.g2();
                    server.mask = buffer.g4();
                    server.domain = buffer.gstr();
                    server.activity = buffer.gstr();
                    server.location = buffer.g1();
                    server.population = buffer.g2b();
                    server.index = i++;
                }

                Server.sort(Server.servers, 0, Server.servers.length - 1, Server.indexComparator, Server.populationComparator);
                Server.request = null;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Server.request = null;
        }

        return false;
    }

    public void stop() {
        output.close();

        try {
            socket.close();
        } catch (IOException ignored) {
        }

        input.close();
    }

    public boolean available(int amount) throws IOException {
        return input.available(amount);
    }

    public int read(byte[] payload, int caret, int length) throws IOException {
        return input.read(payload, caret, length);
    }

    public void write(byte[] payload, int caret, int length) throws IOException {
        output.write(payload, caret, length);
    }

    public int available() throws IOException {
        return input.available();
    }

    public int read() throws IOException {
        return input.read();
    }

    protected void finalize() {
        stop();
    }
}
