package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.LengthBytesDataType;

public class Utf8Info extends LengthBytesDataType {
    public Utf8Info(short length) {
        super(ConstantsPoolDataType.UTF8, length);
    }

    @Override
    public String javapSupplement() {
        return new String(getBytes());
    }
}
