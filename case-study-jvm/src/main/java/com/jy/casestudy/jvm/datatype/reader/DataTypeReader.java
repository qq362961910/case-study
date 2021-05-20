package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public interface DataTypeReader {
    DataType read(DataInputStream dataInputStream) throws IOException;
    boolean support(ConstantsPoolDataType dataType);
}
