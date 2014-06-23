package com.hackbulgaria.corejava.exam1;

import java.util.logging.Level;

public class Logger {
    private static final int DEFAULT_LOG_LEVEL = 3;
    private static final int DEFAULT_MESSAGE_LEVEL = 3;
    private int logLevel;

    public Logger() {
        this(DEFAULT_LOG_LEVEL);
    }

    public Logger(int level) {
        setLevel(level);
    }
    public void setLevel(int level) {
        
        validateLevel(level);
        this.logLevel = level;
    }

    public void log(int msgLevel, String message) {
        validateLevel(msgLevel);
        if (msgLevel <= logLevel) {
            print(msgLevel, message);
        }
    }

    protected void print(int msgLevel, String message) {
        System.out.println(msgLevel + " => " + message);
    }

    private void validateLevel(int msgLevel) {
        if (msgLevel <= 0) {
            throw new InvalidLogLevelException(msgLevel);
        }
    }

    public void log(String message) {
        log(DEFAULT_MESSAGE_LEVEL, message);
    }

    public static class InvalidLogLevelException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public InvalidLogLevelException(int msgLevel) {
            super("Invalid level given! Level should be > 0, given " + msgLevel);
        }

    }
}
