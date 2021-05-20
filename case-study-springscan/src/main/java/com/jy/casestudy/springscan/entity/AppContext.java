package com.jy.casestudy.springscan.entity;

public class AppContext {
    private Long parentId;
    private Mappings mappings;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Mappings getMappings() {
        return mappings;
    }

    public void setMappings(Mappings mappings) {
        this.mappings = mappings;
    }
}
