package com.xiamli.slf4j_color.misc;

import com.xiamli.slf4j_color.SLF4JColor;
import lombok.Setter;
import lombok.val;
import org.slf4j.Marker;
import org.slf4j.helpers.AbstractLogger;

public abstract class AbstractEnumLogger extends AbstractLogger {

    @Setter
    private LogLevel logLevel;

    public AbstractEnumLogger(String name) {
        this.name = name;
    }

    @Override
    protected String getFullyQualifiedCallerName() {
        return null;
    }

    @Override
    public final boolean isTraceEnabled() {
        return isEnabled(LogLevel.TRACE);
    }

    @Override
    public boolean isTraceEnabled(Marker marker) {
        return isEnabled(LogLevel.TRACE);
    }

    @Override
    public final boolean isDebugEnabled() {
        return isEnabled(LogLevel.DEBUG);
    }

    @Override
    public boolean isDebugEnabled(Marker marker) {
        return isEnabled(LogLevel.DEBUG);
    }

    @Override
    public final boolean isInfoEnabled() {
        return isEnabled(LogLevel.INFO);
    }

    @Override
    public boolean isInfoEnabled(Marker marker) {
        return isEnabled(LogLevel.INFO);
    }

    @Override
    public final boolean isWarnEnabled() {
        return isEnabled(LogLevel.WARN);
    }

    @Override
    public boolean isWarnEnabled(Marker marker) {
        return isEnabled(LogLevel.WARN);
    }

    @Override
    public final boolean isErrorEnabled() {
        return isEnabled(LogLevel.ERROR);
    }

    @Override
    public boolean isErrorEnabled(Marker marker) {
        return isEnabled(LogLevel.ERROR);
    }

    public LogLevel getLogLevel() {
        val tmp = logLevel == null ? SLF4JColor.getDefaultLogLevel() : logLevel;
        return tmp == LogLevel.OFF ? null : tmp;
    }

    public boolean isEnabled(LogLevel logLevel) {
        return getLogLevel() != null && getLogLevel().compare(logLevel);
    }
}
