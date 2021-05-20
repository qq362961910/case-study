package com.jy.casestudy.springscan.entity;

public class Produces {
    private String mediaType;
    private Boolean negated;

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public Boolean getNegated() {
        return negated;
    }

    public void setNegated(Boolean negated) {
        this.negated = negated;
    }
}
