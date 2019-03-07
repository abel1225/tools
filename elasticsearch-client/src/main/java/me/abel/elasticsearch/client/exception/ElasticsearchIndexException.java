package me.abel.elasticsearch.client.exception;

/**
 * @description:
 * @author: able.li
 * @create: 2019/2/11 11:17
 */
public class ElasticsearchIndexException extends ElasticsearchSearchException {

    public ElasticsearchIndexException() {
        super();
    }

    public ElasticsearchIndexException(String message) {
        super(message);
    }

    public ElasticsearchIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElasticsearchIndexException(Throwable cause) {
        super(cause);
    }
}
