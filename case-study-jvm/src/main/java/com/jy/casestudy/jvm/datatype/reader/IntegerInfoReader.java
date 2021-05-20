package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.IntegerInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class IntegerInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        IntegerInfo integerInfo = new IntegerInfo();
        int len = dataInputStream.read(integerInfo.getBytes());
        if(len < integerInfo.getBytes().length) {
            throw new EOFException();
        }
        return integerInfo;
    }

    public IntegerInfoReader() {
        super(ConstantsPoolDataType.INTEGER);
    }
}
