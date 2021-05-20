package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class InvokeDynamicInfo extends DataType {

    private short bootstrapMethodAttrIndex;

    private short nameAndTypeIndex;

    private NameAndTypeInfo nameAndTypeInfo;

    public InvokeDynamicInfo() {
        super(ConstantsPoolDataType.INVOKEDYNAMIC);
    }

    public InvokeDynamicInfo(short bootstrapMethodAttrIndex, short nameAndTypeIndex) {
        super(ConstantsPoolDataType.INVOKEDYNAMIC);
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public short getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public void setBootstrapMethodAttrIndex(short bootstrapMethodAttrIndex) {
        this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
    }

    public short getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    public void setNameAndTypeIndex(short nameAndTypeIndex) {
        this.nameAndTypeIndex = nameAndTypeIndex;
    }

    public NameAndTypeInfo getNameAndTypeInfo() {
        return nameAndTypeInfo;
    }

    public void setNameAndTypeInfo(NameAndTypeInfo nameAndTypeInfo) {
        this.nameAndTypeInfo = nameAndTypeInfo;
    }
}
