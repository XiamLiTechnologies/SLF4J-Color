package com.xiamli.slf4j_color;

import lombok.Getter;
import org.slf4j.ILoggerFactory;
import org.slf4j.IMarkerFactory;
import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.helpers.BasicMarkerFactory;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

@Getter
public class SLF4JColorServiceProvider implements SLF4JServiceProvider {

    private final String REQUESTED_API_VERSION = "2.0.99";
    private ILoggerFactory loggerFactory;
    private IMarkerFactory markerFactory;
    private MDCAdapter MDCAdapter;

    @Override
    public String getRequestedApiVersion() {
        return REQUESTED_API_VERSION;
    }

    @Override
    public void initialize() {
        markerFactory = new BasicMarkerFactory();
        loggerFactory = new SLF4JColorLoggingFactory();
        MDCAdapter = new BasicMDCAdapter();
    }
}
