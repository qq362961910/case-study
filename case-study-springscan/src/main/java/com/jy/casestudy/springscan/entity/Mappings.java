package com.jy.casestudy.springscan.entity;

import java.util.List;

public class Mappings {
    private DispatcherServlets dispatcherServlets;
    private List<ServletFilter> servletFilters;
    private List<Servlet> servlets;

    public DispatcherServlets getDispatcherServlets() {
        return dispatcherServlets;
    }

    public void setDispatcherServlets(DispatcherServlets dispatcherServlets) {
        this.dispatcherServlets = dispatcherServlets;
    }

    public List<ServletFilter> getServletFilters() {
        return servletFilters;
    }

    public void setServletFilters(List<ServletFilter> servletFilters) {
        this.servletFilters = servletFilters;
    }

    public List<Servlet> getServlets() {
        return servlets;
    }

    public void setServlets(List<Servlet> servlets) {
        this.servlets = servlets;
    }
}
