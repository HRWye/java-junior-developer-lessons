package ru.itmo.lessons.lesson22;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptedOutputStream extends FilterOutputStream {
    private  String key;

    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public EncryptedOutputStream(OutputStream out, String key) {
        super(out);
        this.key = key;
    }

    public void write (byte[] b) throws IOException{

    }
}
