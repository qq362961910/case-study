package com.jy.casestudy.jvm;

import com.jy.casestudy.jvm.datatype.base.DataType;
import com.jy.casestudy.jvm.datatype.reader.*;
import com.jy.casestudy.jvm.exception.DataTypeReaderNotFoundException;
import com.jy.casestudy.jvm.exception.InvalidConstantsPoolDataTypeException;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConstantsReader {

    private List<DataTypeReader> dataTypeReaderList = new ArrayList<>();

    public DataType readDataType(DataInputStream dataInputStream) throws IOException {
        if(dataInputStream.available() > 0) {
            byte tag = dataInputStream.readByte();
            ConstantsPoolDataType poolDataType = ConstantsPoolDataType.getConstantsPoolDataType(tag);
            if(poolDataType == null) {
                throw new InvalidConstantsPoolDataTypeException(String.valueOf(tag));
            }
            return doReadDataType(poolDataType, dataInputStream);
        } else {
            return null;
        }
    }

    public DataType doReadDataType(ConstantsPoolDataType poolDataType, DataInputStream dataInputStream) throws IOException {
        return dataTypeReaderList.stream()
            .filter(dataTypeReader -> dataTypeReader.support(poolDataType))
            .findFirst().orElseThrow(() -> new DataTypeReaderNotFoundException(poolDataType))
            .read(dataInputStream);
    }
    public ConstantsReader() {
        this.dataTypeReaderList.add(new ClassInfoReader());
        this.dataTypeReaderList.add(new DoubleInfoReader());
        this.dataTypeReaderList.add(new FieldrefInfoReader());
        this.dataTypeReaderList.add(new FloatInfoReader());
        this.dataTypeReaderList.add(new IntegerInfoReader());
        this.dataTypeReaderList.add(new InterfaceMethodrefInfoReader());
        this.dataTypeReaderList.add(new InvokeDynamicInfoReader());
        this.dataTypeReaderList.add(new LongInfoReader());
        this.dataTypeReaderList.add(new MethodHandleInfoReader());
        this.dataTypeReaderList.add(new MethodrefInfoReader());
        this.dataTypeReaderList.add(new MethodTypeInfoReader());
        this.dataTypeReaderList.add(new NameAndTypeInfoReader());
        this.dataTypeReaderList.add(new StringInfoReader());
        this.dataTypeReaderList.add(new Utf8InfoReader());
    }
}
