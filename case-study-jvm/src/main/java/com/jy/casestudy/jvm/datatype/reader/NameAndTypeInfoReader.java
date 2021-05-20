package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.NameAndTypeInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class NameAndTypeInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        NameAndTypeInfo nameAndTypeInfo = new NameAndTypeInfo();
        nameAndTypeInfo.setNameIndex(dataInputStream.readShort());
        nameAndTypeInfo.setTypeIndex(dataInputStream.readShort());
        return nameAndTypeInfo;
    }

    public NameAndTypeInfoReader() {
        super(ConstantsPoolDataType.NAMEANDTYPE);
    }
}
