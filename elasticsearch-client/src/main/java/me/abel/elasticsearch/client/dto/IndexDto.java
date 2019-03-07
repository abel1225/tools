package me.abel.elasticsearch.client.dto;

/**
 * @description:
 * @author: able.li
 * @create: 2019/2/12 13:48
 */
public class IndexDto {

    private String index;
    private String docId;
    private Object source;

    public IndexDto() {
    }

    public IndexDto(String index, String docId, Object source) {
        this.index = index;
        this.docId = docId;
        this.source = source;
    }

    public final String getIndex() {
        return index;
    }

    public final void setIndex(String index) {
        this.index = index;
    }

    public final String getDocId() {
        return docId;
    }

    public final void setDocId(String docId) {
        this.docId = docId;
    }

    public final Object getSource() {
        return source;
    }

    public final void setSource(Object source) {
        this.source = source;
    }
}
