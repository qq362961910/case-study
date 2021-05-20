package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.MethodTypeInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodTypeInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        MethodTypeInfo methodTypeInfo = new MethodTypeInfo();
        methodTypeInfo.setDescriptorIndex(dataInputStream.readShort());
        return methodTypeInfo;
    }

    public MethodTypeInfoReader() {
        super(ConstantsPoolDataType.METHODTYPE);
    }
}
