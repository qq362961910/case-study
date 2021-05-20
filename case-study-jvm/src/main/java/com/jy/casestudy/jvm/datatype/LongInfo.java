package com.jy.casestudy.jvm.datatype;

import cn.t.util.common.digital.LongUtil;
import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.BytesDataType;

public class LongInfo extends BytesDataType {
    public LongInfo() {
        super(ConstantsPoolDataType.LONG, new byte[8]);
    }

    @Override
    public String javapPrint() {
        return String.valueOf(LongUtil.bytesToLong(getBytes()));
    }
}
