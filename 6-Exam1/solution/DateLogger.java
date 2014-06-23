package com.hackbulgaria.corejava.exam1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateLogger extends Logger {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm:ss dd.mm.yyyy");

    public DateLogger() {
        this(Integer.MAX_VALUE);
    }

    public DateLogger(int logLevel) {
        super(logLevel);
    }

    @Override
    protected void print(int msgLevel, String message) {
        String date = DATE_FORMAT.format(new Date());
        System.out.print(String.format("|%s| ", date));
        super.print(msgLevel, message);
    }
}
