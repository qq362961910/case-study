package com.jy.casestudy.springscan.entity;

public class Details {
    private HandlerMethod handlerMethod;
    private RequestMappingConditions requestMappingConditions;

    public HandlerMethod getHandlerMethod() {
        return handlerMethod;
    }

    public void setHandlerMethod(HandlerMethod handlerMethod) {
        this.handlerMethod = handlerMethod;
    }

    public RequestMappingConditions getRequestMappingConditions() {
        return requestMappingConditions;
    }

    public void setRequestMappingConditions(RequestMappingConditions requestMappingConditions) {
        this.requestMappingConditions = requestMappingConditions;
    }
}
