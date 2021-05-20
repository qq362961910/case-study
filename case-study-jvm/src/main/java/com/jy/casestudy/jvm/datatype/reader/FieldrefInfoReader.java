package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.FieldrefInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class FieldrefInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        FieldrefInfo fieldrefInfo = new FieldrefInfo();
        fieldrefInfo.setClassInfoIndex(dataInputStream.readShort());
        fieldrefInfo.setNameAndTypeInfoIndex(dataInputStream.readShort());
        return fieldrefInfo;
    }

    public FieldrefInfoReader() {
        super(ConstantsPoolDataType.FIELDREF);
    }
}
