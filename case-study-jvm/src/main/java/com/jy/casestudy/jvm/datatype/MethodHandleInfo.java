package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class MethodHandleInfo extends DataType {

    private byte referenceKind;

    private short referenceIndex;

    public MethodHandleInfo() {
        super(ConstantsPoolDataType.METHODHANDLE);
    }

    public MethodHandleInfo(byte referenceKind, short referenceIndex) {
        super(ConstantsPoolDataType.METHODHANDLE);
        this.referenceKind = referenceKind;
        this.referenceIndex = referenceIndex;
    }

    public byte getReferenceKind() {
        return referenceKind;
    }

    public void setReferenceKind(byte referenceKind) {
        this.referenceKind = referenceKind;
    }

    public short getReferenceIndex() {
        return referenceIndex;
    }

    public void setReferenceIndex(short referenceIndex) {
        this.referenceIndex = referenceIndex;
    }
}
