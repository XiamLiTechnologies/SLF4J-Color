package com.xiamli.slf4j_color;

import com.xiamli.slf4j_color.misc.LogLevel;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SLF4JColor {

    private static DateFormat dateFormat;
    @Getter
    @Setter
    private static LogLevel defaultLogLevel;

    static {
        setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        setDefaultLogLevel(LogLevel.DEBUG);
    }

    public static void disableLogger(Class aClass) {
        setLogLevel(aClass, LogLevel.OFF);
    }

    public static void disableLogger(String name) {
        setLogLevel(name, LogLevel.OFF);
    }

    public static void setLogLevel(Class aClass, LogLevel logLevel) {
        setLogLevel(aClass.getCanonicalName(), logLevel);
    }

    public static void setLogLevel(String name, LogLevel logLevel) {
        ((SLF4JColorLogger) LoggerFactory.getLogger(name)).setLogLevel(logLevel);
    }

    public static void setDateFormat(String dateFormat) {
        SLF4JColor.dateFormat = new SimpleDateFormat(dateFormat);
    }

    static synchronized String getDate() {
        return dateFormat.format(new Date());
    }
}
