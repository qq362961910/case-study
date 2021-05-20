package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.InterfaceMethodrefInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class InterfaceMethodrefInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        InterfaceMethodrefInfo interfaceMethodrefInfo = new InterfaceMethodrefInfo();
        interfaceMethodrefInfo.setClassInfoIndex(dataInputStream.readShort());
        interfaceMethodrefInfo.setNameAndTypeInfoIndex(dataInputStream.readShort());
        return interfaceMethodrefInfo;
    }

    public InterfaceMethodrefInfoReader() {
        super(ConstantsPoolDataType.INTERFACEMETHODREF);
    }
}
