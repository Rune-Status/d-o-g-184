package jag.js5;

import java.io.*;

public final class DiskFile {

    public final long length;
    public long caret;
    public RandomAccessFile file;

    public DiskFile(File file, String mode, long length) throws IOException {
        if (-1L == length) {
            length = Long.MAX_VALUE;
        }

        if (file.length() > length) {
            file.delete();
        }

        this.file = new RandomAccessFile(file, mode);
        this.length = length;
        this.caret = 0L;
        int var5 = this.file.read();
        if (var5 != -1 && !mode.equals("r")) {
            this.file.seek(0L);
            this.file.write(var5);
        }

        this.file.seek(0L);
    }

    public final void close(boolean sync) throws IOException {
        if (this.file != null) {
            if (sync) {
                try {
                    this.file.getFD().sync();
                } catch (SyncFailedException ignored) {
                }
            }

            this.file.close();
            this.file = null;
        }

    }

    public final long length() throws IOException {
        return this.file.length();
    }

    public final void close() throws IOException {
        this.close(false);
    }

    public final int read(byte[] buffer, int caret, int length) throws IOException {
        int read = this.file.read(buffer, caret, length);
        if (read > 0) {
            this.caret += read;
        }

        return read;
    }

    final void seek(long caret) throws IOException {
        this.file.seek(caret);
        this.caret = caret;
    }

    public final void write(byte[] buffer, int caret, int length) throws IOException {
        if ((long) length + this.caret > this.length) {
            this.file.seek(this.length);
            this.file.write(1);
            throw new EOFException();
        }
        this.file.write(buffer, caret, length);
        this.caret += length;
    }

    protected void finalize() throws Throwable {
        if (this.file != null) {
            this.close();
        }

    }
}
