package com.testdome.classes;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

/**
 * Implement methods in the DecoratorStream class:
 *
 * Write method should write the prefix into the underlying stream member only on the first write invocation. It should always write the bytes it receives to the underlying stream.
 * The prefix should be written in UTF-8 encoding.
 *
 * For example, if the DecoratorStream is instantiated with "First line: " as the prefix parameter and write method is called with UTF-8 byte representation of "Hello, world!", it should write "First line: Hello, world!" into the underlying stream.import java.io.BufferedReader;
 */
public class DecoratorStream extends OutputStream
{
    private OutputStream stream;
    private String prefix;
    private boolean prefixWritten;


    public DecoratorStream(OutputStream stream, String prefix) {
        super();
        this.stream = stream;
        this.prefix = prefix;
        this.prefixWritten = false;
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[]{(byte) b}, 0, 1);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        if (!prefixWritten) {
            stream.write(prefix.getBytes(StandardCharsets.UTF_8));
            prefixWritten = true;
        }
        stream.write(b, off, len);
    }

    @Override
    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public static void main(String[] args) throws IOException {

    }
}