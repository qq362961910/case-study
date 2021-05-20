package com.jy.casestudy.jvm.exception;

import com.jy.casestudy.jvm.ConstantsPoolDataType;

public class DataTypeReaderNotFoundException extends RuntimeException {

    private ConstantsPoolDataType constantsPoolDataType;

    public DataTypeReaderNotFoundException(ConstantsPoolDataType constantsPoolDataType) {
        super(constantsPoolDataType.toString());
    }

    public DataTypeReaderNotFoundException(String message) {
        super(message);
    }
}
