package io.mocks.xavier.model;

import java.util.List;

public class SearchResult<T> {

    private Integer totalElements;
    private List<T> content;

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
