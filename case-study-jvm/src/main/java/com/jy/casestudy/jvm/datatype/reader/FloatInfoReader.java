package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.FloatInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FloatInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        FloatInfo floatInfo = new FloatInfo();
        int len = dataInputStream.read(floatInfo.getBytes());
        if(len < floatInfo.getBytes().length) {
            throw new EOFException();
        }
        return floatInfo;
    }

    public FloatInfoReader() {
        super(ConstantsPoolDataType.FLOAT);
    }
}
