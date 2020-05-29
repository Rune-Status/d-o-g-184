package jag.js5;

import jag.commons.collection.Node;

public class CacheRequest extends Node {

    public ResourceCache cache;
    public byte[] data;
    public Archive archive;
    public int type;

    public CacheRequest() {

    }

    public static void write(int file, byte[] data, ResourceCache cache) {
        CacheRequest request = new CacheRequest();
        request.type = 0;
        request.key = file;
        request.data = data;
        request.cache = cache;

        synchronized (CacheRequestWorker.requests) {
            CacheRequestWorker.requests.add(request);
        }

        synchronized (CacheRequestWorker.anObject1463) {
            if (CacheRequestWorker.anInt1464 == 0) {
                CacheRequestWorker.thread = new Thread(new CacheRequestWorker());
                CacheRequestWorker.thread.setDaemon(true);
                CacheRequestWorker.thread.start();
                CacheRequestWorker.thread.setPriority(5);
            }

            CacheRequestWorker.anInt1464 = 600;
        }
    }
}
