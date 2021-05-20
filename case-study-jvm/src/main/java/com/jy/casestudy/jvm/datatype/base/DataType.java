package com.jy.casestudy.jvm.datatype.base;

import com.jy.casestudy.jvm.ConstantsPoolDataType;

public class DataType {

    protected ConstantsPoolDataType constantsPoolDataType;

    public DataType(ConstantsPoolDataType constantsPoolDataType) {
        this.constantsPoolDataType = constantsPoolDataType;
    }

    public String javapPrint() {
        StringBuilder sb = new StringBuilder(String.valueOf(constantsPoolDataType));
        int len = sb.length();
        for(int i=0; i<19-len; i++) {
            sb.append(" ");
        }
        return sb.append(javapSupplement()).toString();
    }

    public String javapSupplement() {
        return "";
    }

    public ConstantsPoolDataType getConstantsPoolDataType() {
        return constantsPoolDataType;
    }

    public void setConstantsPoolDataType(ConstantsPoolDataType constantsPoolDataType) {
        this.constantsPoolDataType = constantsPoolDataType;
    }
}
