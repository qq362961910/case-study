package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class InterfaceMethodrefInfo extends DataType {

    private short classInfoIndex;

    private ClassInfo classInfo;

    private short nameAndTypeInfoIndex;

    private NameAndTypeInfo nameAndTypeInfo;

    public InterfaceMethodrefInfo() {
        super(ConstantsPoolDataType.INTERFACEMETHODREF);
    }

    public InterfaceMethodrefInfo(ClassInfo classInfo, NameAndTypeInfo nameAndTypeInfo) {
        super(ConstantsPoolDataType.INTERFACEMETHODREF);
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
}
