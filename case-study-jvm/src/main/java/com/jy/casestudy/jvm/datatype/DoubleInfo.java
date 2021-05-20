package com.jy.casestudy.jvm.datatype;

import cn.t.util.common.digital.DoubleUtil;
import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.BytesDataType;

public class DoubleInfo extends BytesDataType {
    public DoubleInfo() {
        super(ConstantsPoolDataType.DOUBLE, new byte[8]);
    }

    @Override
    public String javapPrint() {
        return String.valueOf(DoubleUtil.bytesToDouble(getBytes()));
    }
}
