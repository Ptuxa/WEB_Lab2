package by.bsuir.lab2Servlet.controller.util;

import by.bsuir.lab2Servlet.controller.command.Command;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

public class UrlUtil {
    public static final Logger LOGGER = LogManager.getLogger(Command.class);

    private static final String REFERER_HEADER = "referer";

    private UrlUtil() {
    }

    public static String getRefererPage(HttpServletRequest request) {
        String refererPage = request.getHeader(REFERER_HEADER);
        return refererPage;
    }

    public static URI addParameterToUri(String uri, String paramName, String paramValue) {
        try {
            return new URIBuilder(uri).setParameter(paramName, paramValue).build();
        } catch (URISyntaxException e) {
            LOGGER.error("Exception during parsing URI string", e);
            throw new RuntimeException(e);
        }
    }

    public static URI addParameterToRefererPage(HttpServletRequest request, String paramName, String paramValue) {
        return addParameterToUri(getRefererPage(request), paramName, paramValue);
    }
}
