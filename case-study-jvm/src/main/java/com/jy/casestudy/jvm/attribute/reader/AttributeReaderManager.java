package com.jy.casestudy.jvm.attribute.reader;

import com.jy.casestudy.jvm.AttributeType;
import com.jy.casestudy.jvm.attribute.AttributeInfo;
import com.jy.casestudy.jvm.datatype.Utf8Info;
import com.jy.casestudy.jvm.datatype.base.DataType;
import com.jy.casestudy.jvm.exception.NoAttributeReaderFoundException;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AttributeReaderManager {

    private List<AttributeReader<?>> attributeReaderList = new ArrayList<>();

    public AttributeInfo readAttribute(DataInputStream dis, List<DataType> constantsPool) throws IOException {
        String attributeName = new String(((Utf8Info)constantsPool.get(dis.readShort())).getBytes());
        AttributeType attributeType = AttributeType.getAttributeType(attributeName);
        int attributeLength = dis.readInt();
        AttributeReader<?> attributeReader = selectAttributeReader(attributeType);
        if(attributeReader == null) {
            throw new NoAttributeReaderFoundException(attributeName);
        }
        return attributeReader.readAttribute(dis, constantsPool);
    }

    private AttributeReader<?> selectAttributeReader(AttributeType attributeType) {
        for(AttributeReader<?> attributeReader: attributeReaderList) {
            if(attributeReader.support(attributeType)) {
                return attributeReader;
            }
        }
        return null;
    }

    {
        attributeReaderList.add(new RuntimeVisibleAnnotationsReader());
    }
}
