package com.jy.casestudy.springscan.entity;

import java.util.Map;

public class Context {
    private Map<String, AppContext> contexts;

    public Map<String, AppContext> getContexts() {
        return contexts;
    }

    public void setContexts(Map<String, AppContext> contexts) {
        this.contexts = contexts;
    }
}
