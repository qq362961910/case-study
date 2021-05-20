package com.jy.casestudy.jvm.datatype.reader;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.InvokeDynamicInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;

public class InvokeDynamicInfoReader extends AbstractDataTypeReader {

    @Override
    public DataType read(DataInputStream dataInputStream) throws IOException {
        InvokeDynamicInfo invokeDynamicInfo = new InvokeDynamicInfo();
        invokeDynamicInfo.setBootstrapMethodAttrIndex(dataInputStream.readShort());
        invokeDynamicInfo.setNameAndTypeIndex(dataInputStream.readShort());
        return invokeDynamicInfo;
    }

    public InvokeDynamicInfoReader() {
        super(ConstantsPoolDataType.INVOKEDYNAMIC);
    }
}
