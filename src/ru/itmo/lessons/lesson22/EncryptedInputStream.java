package ru.itmo.lessons.lesson22;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncryptedInputStream extends FilterInputStream {
    private  String key;

    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected EncryptedInputStream(InputStream in, String key) {
        super(in);
        this.key = key;
    }

    public int read (byte[] b) throws IOException {


        return 0;

    }
}
