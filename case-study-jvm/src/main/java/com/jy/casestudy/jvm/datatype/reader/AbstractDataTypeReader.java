package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;

public abstract class AbstractDataTypeReader implements DataTypeReader {

    private ConstantsPoolDataType constantsPoolDataType;

    @Override
    public boolean support(ConstantsPoolDataType dataType) {
        return constantsPoolDataType == dataType;
    }

    public AbstractDataTypeReader(ConstantsPoolDataType constantsPoolDataType) {
        this.constantsPoolDataType = constantsPoolDataType;
    }
}
