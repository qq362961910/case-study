package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.LongInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class LongInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        LongInfo longInfo = new LongInfo();
        int len = dataInputStream.read(longInfo.getBytes());
        if(len < longInfo.getBytes().length) {
            throw new EOFException();
        }
        return longInfo;
    }

    public LongInfoReader() {
        super(ConstantsPoolDataType.LONG);
    }
}
