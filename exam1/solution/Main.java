package com.hackbulgaria.corejava.exam1;

public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger();
        logger.log("This should get printed");
        logger.log(4, "This should not get printed");
        
        logger.log(1, "This is very important");
        
        DateLogger dateLogger = new DateLogger();
        dateLogger.log("prints everything, so I get printed");
        
        dateLogger.setLevel(1);
        dateLogger.log(2,"won't get printed");
    }
}
