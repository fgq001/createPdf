package com.bwjf.createpdf.test;

/**
 * Created by user01 on 2019/7/26.
 */

/**
 * Compression level
 */
public  enum Level {

    /**
     * Compression level for no compression.
     */
    NO_COMPRESSION(0),

    /**
     * Compression level for fastest compression.
     */
    BEST_SPEED(1),

    /**
     * Compression level for best compression.
     */
    BEST_COMPRESSION(9),

    /**
     * Default compression level.
     */
    DEFAULT_COMPRESSION(-1);

    private int level;

    Level(

            int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}

