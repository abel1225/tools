package me.abel.elasticsearch.client.exception;

/**
 * @description:
 * @author: able.li
 * @create: 2019/2/11 11:17
 */
public class ElasticsearchConnectException extends RuntimeException {

    public ElasticsearchConnectException() {
        super();
    }

    public ElasticsearchConnectException(String message) {
        super(message);
    }

    public ElasticsearchConnectException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElasticsearchConnectException(Throwable cause) {
        super(cause);
    }
}
