package com.jy.casestudy.jvm.attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AnnotationAttributeInfo extends AttributeInfo {
    private List<Annotation> annotations = new ArrayList<>();
}

class Annotation {
    private String className;
    private List<Map<String, ElementValue>> valuePairList = new ArrayList<>();

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Map<String, ElementValue>> getValuePairList() {
        return valuePairList;
    }

    public void setValuePairList(List<Map<String, ElementValue>> valuePairList) {
        this.valuePairList = valuePairList;
    }
}

class ElementValue {
    private byte tag;

}
