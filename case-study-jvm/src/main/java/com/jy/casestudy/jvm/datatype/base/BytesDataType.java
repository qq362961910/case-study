package com.jy.casestudy.jvm.datatype.base;

import com.jy.casestudy.jvm.ConstantsPoolDataType;

public class BytesDataType extends DataType {

    protected final byte[] bytes;

    public byte[] getBytes() {
        return bytes;
    }

    public BytesDataType(ConstantsPoolDataType constantsPoolDataType, byte[] bytes) {
        super(constantsPoolDataType);
        this.bytes = bytes;
    }
}
