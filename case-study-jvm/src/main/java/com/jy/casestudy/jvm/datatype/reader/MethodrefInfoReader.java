package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.MethodrefInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodrefInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        MethodrefInfo methodrefInfo = new MethodrefInfo();
        methodrefInfo.setClassInfoIndex(dataInputStream.readShort());
        methodrefInfo.setNameAndTypeInfoIndex(dataInputStream.readShort());
        return methodrefInfo;
    }

    public MethodrefInfoReader() {
        super(ConstantsPoolDataType.METHODREF);
    }
}
