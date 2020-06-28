package com.xiamli.slf4j_color;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SLF4JColorLoggingFactory implements ILoggerFactory {

    private Map<String, Logger> cachedLoggers = new ConcurrentHashMap<>();

    @Override
    public Logger getLogger(String name) {
        return cachedLoggers.computeIfAbsent(name, SLF4JColorLogger::new);
    }
}
