package me.abel.utils.http.exception;

/**
 * @description:
 * @author: able.li
 * @create: 2018/12/15 11:47
 */
public class HttpRequestException extends RuntimeException {

    public HttpRequestException() {
    }

    public HttpRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public HttpRequestException(Throwable cause) {
        super(cause);
    }
}
