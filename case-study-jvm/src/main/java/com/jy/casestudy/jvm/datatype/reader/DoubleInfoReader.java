package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.DoubleInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class DoubleInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        DoubleInfo doubleInfo = new DoubleInfo();
        int len = dataInputStream.read(doubleInfo.getBytes());
        if(len != doubleInfo.getBytes().length) {
            throw new EOFException();
        }
        return doubleInfo;
    }

    public DoubleInfoReader() {
        super(ConstantsPoolDataType.DOUBLE);
    }
}
