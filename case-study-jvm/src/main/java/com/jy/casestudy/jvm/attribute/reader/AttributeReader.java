package com.jy.casestudy.jvm.attribute.reader;

import com.jy.casestudy.jvm.AttributeType;
import com.jy.casestudy.jvm.attribute.AttributeInfo;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public interface AttributeReader<T extends AttributeInfo> {

    T readAttribute(DataInputStream dis, List<DataType> constantsPool) throws IOException;

    boolean support(AttributeType attributeType);
}
