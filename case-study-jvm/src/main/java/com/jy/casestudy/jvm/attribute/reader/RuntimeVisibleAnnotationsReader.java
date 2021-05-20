package com.jy.casestudy.jvm.attribute.reader;

import com.jy.casestudy.jvm.AttributeType;
import com.jy.casestudy.jvm.attribute.AnnotationAttributeInfo;
import com.jy.casestudy.jvm.datatype.Utf8Info;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

public class RuntimeVisibleAnnotationsReader implements  AttributeReader<AnnotationAttributeInfo> {

    @Override
    public AnnotationAttributeInfo readAttribute(DataInputStream dis, List<DataType> constantsPool) throws IOException {
        AnnotationAttributeInfo annotationAttributeInfo = new AnnotationAttributeInfo();
        int annotationCount = dis.readShort();
        for(int i=0; i<annotationCount; i++) {
            short typeIndex = dis.readShort();
            Utf8Info utf8Info = (Utf8Info)constantsPool.get(typeIndex);
            String className = new String(utf8Info.getBytes());
            short elementValuePairsCount = dis.readShort();
            for(int k=0; k<elementValuePairsCount; k++) {
                String name = new String(((Utf8Info)constantsPool.get(dis.readShort())).getBytes());
                byte tag = dis.readByte();
                constantsPool.get(dis.readShort());
            }
        }
        return annotationAttributeInfo;
    }

    @Override
    public boolean support(AttributeType attributeType) {
        return AttributeType.RuntimeVisibleAnnotations == attributeType;
    }
}
