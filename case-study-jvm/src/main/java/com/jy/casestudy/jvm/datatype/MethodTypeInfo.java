package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class MethodTypeInfo extends DataType {

    private short descriptorIndex;

    public MethodTypeInfo() {
        super(ConstantsPoolDataType.METHODTYPE);
    }

    public MethodTypeInfo(short descriptorIndex) {
        super(ConstantsPoolDataType.METHODTYPE);
        this.descriptorIndex = descriptorIndex;
    }

    public short getDescriptorIndex() {
        return descriptorIndex;
    }

    public void setDescriptorIndex(short descriptorIndex) {
        this.descriptorIndex = descriptorIndex;
    }
}
