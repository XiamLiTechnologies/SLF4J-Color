package com.xiamli.slf4j_color.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.fusesource.jansi.Ansi;
import org.slf4j.event.Level;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@AllArgsConstructor
@Getter
public enum LogLevel {

    OFF(-10, null, Ansi.Color.BLACK),
    TRACE(0, Level.TRACE, Ansi.Color.BLUE),
    DEBUG(10, Level.DEBUG, Ansi.Color.CYAN),
    INFO(20, Level.INFO, Ansi.Color.GREEN),
    WARN(30, Level.WARN, Ansi.Color.YELLOW),
    ERROR(40, Level.ERROR, Ansi.Color.RED);

    private final static Map<Level, LogLevel> slf4jMap;

    static {
        slf4jMap = new ConcurrentHashMap<>();

        for (LogLevel value : values())
            if (value.getEventLevel() != null)
                slf4jMap.put(value.getEventLevel(), value);
    }

    private int level;
    private Level eventLevel;
    private Ansi.Color color;

    public static LogLevel get(Level level) {
        return slf4jMap.get(level);
    }

    public boolean compare(LogLevel other) {
        return getLevel() <= other.getLevel();
    }
}
