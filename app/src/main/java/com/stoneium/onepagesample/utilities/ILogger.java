package com.stoneium.onepagesample.utilities;

/**
 * Created by Michael Leighton on 11/17/15.
 * Used for logging throughout the application.
 */
public interface ILogger {

    /***
     * Write a message to the debug log.
     *
     * @param format The format string.
     * @param params Additional params.
     */
    void debug(String format, Object... params);

    /***
     * Write a error message to the log.
     *
     * @param format The format string.
     * @param params Additional params.
     */
    void error(String format, Object... params);
}
