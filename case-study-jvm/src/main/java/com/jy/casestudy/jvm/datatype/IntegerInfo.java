package com.jy.casestudy.jvm.datatype;

import cn.t.util.common.digital.IntUtil;
import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.BytesDataType;

public class IntegerInfo extends BytesDataType {
    public IntegerInfo() {
        super(ConstantsPoolDataType.INTEGER, new byte[4]);
    }

    @Override
    public String javapPrint() {
        return String.valueOf(IntUtil.bytesToInt(getBytes()));
    }
}
