package me.abel.elasticsearch.client.exception;

/**
 * @description:
 * @author: able.li
 * @create: 2019/2/11 11:17
 */
public class ElasticsearchSearchException extends RuntimeException {

    public ElasticsearchSearchException() {
        super();
    }

    public ElasticsearchSearchException(String message) {
        super(message);
    }

    public ElasticsearchSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElasticsearchSearchException(Throwable cause) {
        super(cause);
    }

}
