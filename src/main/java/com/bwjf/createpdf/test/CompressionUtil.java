package com.bwjf.createpdf.test;

/**
 * Created by user01 on 2019/7/26.
 */

import cn.hutool.core.lang.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

/**
 * util for compress/decompress data
 *
 * @author lichengwu
 * @version 1.0
 * @created 2013-02-07 10:14 AM
 */
public final class CompressionUtil {

    private static final int BUFFER_SIZE = 4 * 1024;

    /**
     * compress data by {@linkplain Level}
     *
     * @param data
     * @param level see {@link Level}
     * @return
     * @throws IOException
     * @author lichengwu
     * @created 2013-02-07
     */
    public static byte[] compress(byte[] data, Level level) throws IOException {

        Assert.notNull(data);
        Assert.notNull(level);

        Deflater deflater = new Deflater();
        // set compression level
        deflater.setLevel(level.getLevel());
        deflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);

        deflater.finish();
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer); // returns the generated
            // code... index
            outputStream.write(buffer, 0, count);
        }
        byte[] output = outputStream.toByteArray();
        outputStream.close();
        return output;
    }

    /**
     * decompress data
     *
     * @param data
     * @return
     * @throws IOException
     * @throws DataFormatException
     * @author lichengwu
     * @created 2013-02-07
     */
    public static byte[] decompress(byte[] data) throws IOException, DataFormatException {

        Assert.notNull(data);

        Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[BUFFER_SIZE];
        while (!inflater.finished()) {
            int count = inflater.inflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        byte[] output = outputStream.toByteArray();
        outputStream.close();
        return output;
    }
}
