package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.MethodHandleInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class MethodHandleInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        MethodHandleInfo methodHandleInfo = new MethodHandleInfo();
        methodHandleInfo.setReferenceKind(dataInputStream.readByte());
        methodHandleInfo.setReferenceIndex(dataInputStream.readShort());
        return methodHandleInfo;
    }

    public MethodHandleInfoReader() {
        super(ConstantsPoolDataType.METHODHANDLE);
    }
}
