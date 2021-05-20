package com.jy.casestudy.springscan.entity;

import java.util.List;

public class ServletFilter {
    private String className;
    private String name;
    private List<String> servletNameMappings;
    private List<String> urlPatternMappings;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getServletNameMappings() {
        return servletNameMappings;
    }

    public void setServletNameMappings(List<String> servletNameMappings) {
        this.servletNameMappings = servletNameMappings;
    }

    public List<String> getUrlPatternMappings() {
        return urlPatternMappings;
    }

    public void setUrlPatternMappings(List<String> urlPatternMappings) {
        this.urlPatternMappings = urlPatternMappings;
    }
}
