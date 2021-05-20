package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.StringInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class StringInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        StringInfo stringInfo = new StringInfo();
        stringInfo.setValueIndex(dataInputStream.readShort());
        return stringInfo;
    }

    public StringInfoReader() {
        super(ConstantsPoolDataType.STRING);
    }
}
