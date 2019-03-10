package com.omertron.bgg;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.LogManager;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {

    private static final Logger LOG = LoggerFactory.getLogger(TestLogger.class);
    private static final String CRLF = "\n";

    private TestLogger() {
        throw new UnsupportedOperationException("Class can not be instantiated");
    }

    /**
     * configure the logger with a simple in-memory file for the required log level
     *
     * @param level The logging level required
     * @return True if successful
     */
    public static boolean configure(String level) {
        StringBuilder config = new StringBuilder("handlers = java.util.logging.ConsoleHandler\n");
        config.append(".level = ").append(level).append(CRLF);
        config.append("java.util.logging.ConsoleHandler.level = ").append(level).append(CRLF);
        // Only works with Java 7 or later
        config.append("java.util.logging.SimpleFormatter.format = [%1$tH:%1$tM:%1$tS %4$6s] %2$s - %5$s %6$s%n").append(CRLF);
        // Exclude http logging
        config.append("sun.net.www.protocol.http.HttpURLConnection.level = OFF").append(CRLF);
        config.append("org.apache.http.level = SEVERE").append(CRLF);

        try (InputStream ins = new ByteArrayInputStream(config.toString().getBytes())) {
            LogManager.getLogManager().readConfiguration(ins);
        } catch (IOException e) {
            LOG.warn("Failed to configure log manager due to an IO problem", e);
            return Boolean.FALSE;
        }
        LOG.debug("Logger initialized to '{}' level", level);
        return Boolean.TRUE;
    }

    /**
     * Set the logging level to "ALL"
     *
     * @return True if successful
     */
    public static boolean configure() {
        return TestLogger.configure("ALL");
    }

    /**
     * Load properties from a file
     *
     * @param props Properties
     * @param propertyFile File
     */
    public static void loadProperties(Properties props, File propertyFile) {
        InputStream is = null;
        try {
            is = new FileInputStream(propertyFile);
            props.load(is);
        } catch (IOException ex) {
            LOG.warn("Failed to load properties file", ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    LOG.warn("Failed to close properties file", ex);
                }
            }
        }
    }

    /**
     * Save properties to a file
     *
     * @param props Properties
     * @param propertyFile File
     * @param headerText Header
     */
    public static void saveProperties(Properties props, File propertyFile, String headerText) {
        OutputStream out = null;

        try {
            out = new FileOutputStream(propertyFile);
            if (StringUtils.isNotBlank(headerText)) {
                props.store(out, headerText);
            }
        } catch (FileNotFoundException ex) {
            LOG.warn("Failed to find properties file", ex);
        } catch (IOException ex) {
            LOG.warn("Failed to read properties file", ex);
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException ex) {
                    LOG.warn("Failed to close properties file", ex);
                }
            }
        }
    }
}