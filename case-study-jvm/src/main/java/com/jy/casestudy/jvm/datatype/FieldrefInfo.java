package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class FieldrefInfo extends DataType {

    private short classInfoIndex;

    private ClassInfo classInfo;

    private short nameAndTypeInfoIndex;

    private NameAndTypeInfo nameAndTypeInfo;

    public FieldrefInfo() {
        super(ConstantsPoolDataType.FIELDREF);
    }

    public FieldrefInfo(ClassInfo classInfo, NameAndTypeInfo nameAndTypeInfo) {
        super(ConstantsPoolDataType.FIELDREF);
        this.classInfo = classInfo;
        this.nameAndTypeInfo = nameAndTypeInfo;
    }

    public short getClassInfoIndex() {
        return classInfoIndex;
    }

    public void setClassInfoIndex(short classInfoIndex) {
        this.classInfoIndex = classInfoIndex;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public short getNameAndTypeInfoIndex() {
        return nameAndTypeInfoIndex;
    }

    public void setNameAndTypeInfoIndex(short nameAndTypeInfoIndex) {
        this.nameAndTypeInfoIndex = nameAndTypeInfoIndex;
    }

    public NameAndTypeInfo getNameAndTypeInfo() {
        return nameAndTypeInfo;
    }

    public void setNameAndTypeInfo(NameAndTypeInfo nameAndTypeInfo) {
        this.nameAndTypeInfo = nameAndTypeInfo;
    }

    @Override
    public String javapSupplement() {
        StringBuilder sb = new StringBuilder(String.format("#%d.#%d", classInfoIndex, nameAndTypeInfoIndex));
        for(int i=0; i< (14-sb.length()); i++) {
            sb.append(" ");
        }
        sb.append("// ").
            append(new String(classInfo.getQualifiedName().getBytes())).append(".").
            append(new String(nameAndTypeInfo.getName().getBytes())).append(":").append(new String(nameAndTypeInfo.getType().getBytes()));
        return sb.toString();
    }
}
