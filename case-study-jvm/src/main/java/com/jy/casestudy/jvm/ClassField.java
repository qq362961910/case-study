package com.jy.casestudy.jvm;

import com.jy.casestudy.jvm.attribute.AttributeInfo;

import java.util.ArrayList;
import java.util.List;

public class ClassField {
    private List<com.jy.casestudy.jvm.AccessFlag> accessFlagList = new ArrayList<>();
    private String name;
    private String descriptor;
    private List<AttributeInfo> fieldAttributeList = new ArrayList<>();

    public List<com.jy.casestudy.jvm.AccessFlag> getAccessFlagList() {
        return accessFlagList;
    }

    public void setAccessFlagList(List<com.jy.casestudy.jvm.AccessFlag> accessFlagList) {
        this.accessFlagList = accessFlagList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }

    public List<AttributeInfo> getFieldAttributeList() {
        return fieldAttributeList;
    }

    public void setFieldAttributeList(List<AttributeInfo> fieldAttributeList) {
        this.fieldAttributeList = fieldAttributeList;
    }
}
