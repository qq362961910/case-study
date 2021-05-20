package com.jy.casestudy.springscan.entity;

import java.util.List;

public class RequestMappingConditions {
    private List<String> consumes;
    private List<String> headers;
    private List<String> methods;
    private List<String> params;
    private List<String> patterns;
    private List<Produces> produces;

    public List<String> getConsumes() {
        return consumes;
    }

    public void setConsumes(List<String> consumes) {
        this.consumes = consumes;
    }

    public List<String> getHeaders() {
        return headers;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    public List<String> getMethods() {
        return methods;
    }

    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public List<String> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<String> patterns) {
        this.patterns = patterns;
    }

    public List<Produces> getProduces() {
        return produces;
    }

    public void setProduces(List<Produces> produces) {
        this.produces = produces;
    }
}
