package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.ClassInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class ClassInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        ClassInfo type = new ClassInfo();
        type.setQualifiedNameIndex(dataInputStream.readShort());
        return type;
    }

    public ClassInfoReader() {
        super(ConstantsPoolDataType.CLASS);
    }
}
