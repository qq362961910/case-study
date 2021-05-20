package com.jy.casestudy.jvm.datatype.base;

import com.jy.casestudy.jvm.ConstantsPoolDataType;

public class LengthBytesDataType extends BytesDataType {

    /**
     * 字符数
     * */
    protected short length;

    public LengthBytesDataType(ConstantsPoolDataType constantsPoolDataType, short length) {
        super(constantsPoolDataType, new byte[length]);
        this.length = length;
    }
}
