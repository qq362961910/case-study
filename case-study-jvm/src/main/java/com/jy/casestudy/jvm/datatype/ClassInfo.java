package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class ClassInfo extends DataType {

    private short qualifiedNameIndex;
    private Utf8Info qualifiedName;

    public ClassInfo() {
        super(ConstantsPoolDataType.CLASS);
    }

    public ClassInfo(Utf8Info qualifiedName) {
        super(ConstantsPoolDataType.CLASS);
        this.qualifiedName = qualifiedName;
    }

    public short getQualifiedNameIndex() {
        return qualifiedNameIndex;
    }

    public void setQualifiedNameIndex(short qualifiedNameIndex) {
        this.qualifiedNameIndex = qualifiedNameIndex;
    }

    public Utf8Info getQualifiedName() {
        return qualifiedName;
    }

    public void setQualifiedName(Utf8Info qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    @Override
    public String javapSupplement() {
        StringBuilder sb = new StringBuilder(String.format("#%d", qualifiedNameIndex));
        for(int i=0; i< (14-sb.length()); i++) {
            sb.append(" ");
        }
        sb.append("// ").append(new String(qualifiedName.getBytes()));
        return sb.toString();
    }
}
