package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.Utf8Info;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class Utf8InfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        Utf8Info utf8Info = new Utf8Info(dataInputStream.readShort());
        dataInputStream.read(utf8Info.getBytes());
        return utf8Info;
    }

    public Utf8InfoReader() {
        super(ConstantsPoolDataType.UTF8);
    }
}
