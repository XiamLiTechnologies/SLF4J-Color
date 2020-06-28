package com.xiamli.slf4j_color;

import com.xiamli.slf4j_color.misc.AbstractEnumLogger;
import com.xiamli.slf4j_color.misc.LogLevel;
import lombok.val;
import org.fusesource.jansi.Ansi;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.MessageFormatter;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public final class SLF4JColorLogger extends AbstractEnumLogger {


    SLF4JColorLogger(String name) {
        super(name);
    }

    @Override
    protected void handleNormalizedLoggingCall(Level level, Marker marker, String message, Object[] arguments, Throwable throwable) {
        val logLevel = LogLevel.get(level);
        val stringBuilder = new StringBuilder(32);

        // date
        stringBuilder.append(SLF4JColor.getDate()).append(' ');

        // thread
        stringBuilder.append('[').append(Thread.currentThread().getName()).append("] ");

        // level
        stringBuilder.append('[').append(logLevel.name()).append("] ");

        // logger
        stringBuilder.append(getName()).append(" - ");

        // message itself
        stringBuilder.append(MessageFormatter.basicArrayFormat(message, arguments));

        // throwable
        if (throwable != null) {
            val byteArrayOutputStream = new ByteArrayOutputStream();
            throwable.printStackTrace(new PrintStream(byteArrayOutputStream));
            stringBuilder.append(System.getProperty("line.separator")).append(new String(byteArrayOutputStream.toByteArray()));
        }

        PrintStream targetStream = logLevel.compare(LogLevel.WARN) ? System.err : System.out;

        targetStream.println(Ansi.ansi().fg(logLevel.getColor()).a(stringBuilder.toString()).reset());
        targetStream.flush();
    }
}
