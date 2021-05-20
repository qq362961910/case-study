package com.jy.casestudy.jvm.datatype;

import cn.t.util.common.digital.FloatUtil;
import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.BytesDataType;

public class FloatInfo extends BytesDataType {
    public FloatInfo() {
        super(ConstantsPoolDataType.FLOAT, new byte[4]);
    }

    @Override
    public String javapPrint() {
        return String.valueOf(FloatUtil.bytesToFloat(getBytes()));
    }
}
