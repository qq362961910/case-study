package com.jy.casestudy.jvm;

import com.jy.casestudy.jvm.attribute.AttributeInfo;
import com.jy.casestudy.jvm.attribute.reader.AttributeReaderManager;
import com.jy.casestudy.jvm.datatype.*;
import com.jy.casestudy.jvm.datatype.base.DataType;
import com.jy.casestudy.jvm.exception.InvalidClassFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ClassFileUtil {

    private static final Logger logger = LoggerFactory.getLogger(com.jy.casestudy.jvm.ClassFileUtil.class);

    private static final com.jy.casestudy.jvm.ConstantsReader constantsReader = new com.jy.casestudy.jvm.ConstantsReader();

    public static com.jy.casestudy.jvm.ClassFile readClassFile(String path) throws IOException {
        File file = new File(path);
        com.jy.casestudy.jvm.ClassFile classFile = new com.jy.casestudy.jvm.ClassFile();
        try(
            DataInputStream dis = new DataInputStream(new FileInputStream(file))
        ) {
            List<DataType> constantsPool =  classFile.getConstantsPool();
            byte[] magicNumber = new byte[4];
            int len = dis.read(magicNumber);
            if(len < magicNumber.length) {
                throw new InvalidClassFileException(path);
            }
            //magic number
            classFile.setMagicNumber(magicNumber);
            //secondary version
            classFile.setMinor(dis.readShort());
            //major version
            classFile.setMajorVersion(dis.readShort());
            short constantsCount = dis.readShort();
            constantsCount--;
            logger.info("常量池数量: {}", constantsCount);
            for(int i=0; i< constantsCount; i++) {
                classFile.addConstantsPool(constantsReader.readDataType(dis));
            }
            autoWireConstantsPool(constantsPool);
            short classAccessFlagNumber = dis.readShort();
            //类的访问标识
            classFile.getClassAccessFlagList().addAll(com.jy.casestudy.jvm.AccessFlag.getAccessFlag(classAccessFlagNumber));
            ClassInfo classInfo = (ClassInfo)constantsPool.get(dis.readShort());
            //类的全限定名
            classFile.setQualifiedClassName(new String(((Utf8Info)(constantsPool.get(classInfo.getQualifiedNameIndex()))).getBytes()).replaceAll("/", "\\."));
            ClassInfo superClassInfo = (ClassInfo)constantsPool.get(dis.readShort());
            //父类全限定名
            classFile.setQualifiedSuperClassName(new String(((Utf8Info)(constantsPool.get(superClassInfo.getQualifiedNameIndex()))).getBytes()).replaceAll("/", "\\."));
            //接口列表
            short interfaceCount = dis.readShort();
            if(interfaceCount > 0) {
                for(int i=0; i<interfaceCount; i++) {
                    ClassInfo interfaceName = (ClassInfo)constantsPool.get(dis.readShort());
                    classFile.getQualifiedInterfaceClassNameList().add(new String(((Utf8Info)constantsPool.get(interfaceName.getQualifiedNameIndex())).getBytes()));
                }
            }
            //属性列表
            short fieldCount = dis.readShort();
            if(fieldCount > 0) {
                for (int i = 0; i < fieldCount; i++) {
                    com.jy.casestudy.jvm.ClassField field = new com.jy.casestudy.jvm.ClassField();
                    short fieldAccessFlagNumber = dis.readShort();
                    field.setAccessFlagList(com.jy.casestudy.jvm.AccessFlag.getAccessFlag(fieldAccessFlagNumber));
                    String fieldName = new String(((Utf8Info)constantsPool.get(dis.readShort())).getBytes());
                    field.setName(fieldName);
                    String descriptor = new String(((Utf8Info)constantsPool.get(dis.readShort())).getBytes()).replaceAll("/", "\\.");
                    field.setDescriptor(descriptor);
                    short attributeCount = dis.readShort();
                    if(attributeCount > 0) {
                        AttributeReaderManager attributeReaderManager = new AttributeReaderManager();
                        for(int k=0; k< attributeCount; k++) {
                            AttributeInfo attributeInfo = attributeReaderManager.readAttribute(dis, constantsPool);
                            field.getFieldAttributeList().add(attributeInfo);
                        }
                    }
                    classFile.getFieldList().add(field);
                }
            }

        }
        return classFile;
    }
    private static void autoWireConstantsPool(List<DataType> dataTypeList) {
        for(int i=0; i< dataTypeList.size(); i++) {
            DataType dataType = dataTypeList.get(i);
            if(dataType instanceof ClassInfo) {
                ClassInfo classInfo = ((ClassInfo)dataType);
                classInfo.setQualifiedName((Utf8Info)dataTypeList.get(classInfo.getQualifiedNameIndex()));
            } else if(dataType instanceof StringInfo) {
                StringInfo stringInfo = ((StringInfo)dataType);
                stringInfo.setValue((Utf8Info)dataTypeList.get(stringInfo.getValueIndex()));
            } else if(dataType instanceof MethodrefInfo) {
                MethodrefInfo methodrefInfo = ((MethodrefInfo)dataType);
                methodrefInfo.setClassInfo((ClassInfo)dataTypeList.get(methodrefInfo.getClassInfoIndex()));
                methodrefInfo.setNameAndTypeInfo((NameAndTypeInfo)dataTypeList.get(methodrefInfo.getNameAndTypeInfoIndex()));
            } else if(dataType instanceof NameAndTypeInfo) {
                NameAndTypeInfo nameAndTypeInfo = ((NameAndTypeInfo)dataType);
                nameAndTypeInfo.setName((Utf8Info)dataTypeList.get(nameAndTypeInfo.getNameIndex()));
                nameAndTypeInfo.setType((Utf8Info)dataTypeList.get(nameAndTypeInfo.getTypeIndex()));
            } else if(dataType instanceof FieldrefInfo) {
                FieldrefInfo fieldrefInfo = ((FieldrefInfo)dataType);
                fieldrefInfo.setClassInfo((ClassInfo)dataTypeList.get(fieldrefInfo.getClassInfoIndex()));
                fieldrefInfo.setNameAndTypeInfo((NameAndTypeInfo)dataTypeList.get(fieldrefInfo.getNameAndTypeInfoIndex()));
            } else if(dataType instanceof InterfaceMethodrefInfo) {
                InterfaceMethodrefInfo interfaceMethodrefInfo = ((InterfaceMethodrefInfo)dataType);
                interfaceMethodrefInfo.setClassInfo((ClassInfo)dataTypeList.get(interfaceMethodrefInfo.getClassInfoIndex()));
                interfaceMethodrefInfo.setNameAndTypeInfo((NameAndTypeInfo)dataTypeList.get(interfaceMethodrefInfo.getNameAndTypeInfoIndex()));
            } else if(dataType instanceof InvokeDynamicInfo) {
                InvokeDynamicInfo invokeDynamicInfo = ((InvokeDynamicInfo)dataType);
                invokeDynamicInfo.setNameAndTypeInfo((NameAndTypeInfo)dataTypeList.get(invokeDynamicInfo.getNameAndTypeIndex()));
            } else if(dataType instanceof MethodHandleInfo) {
            } else if(dataType instanceof MethodTypeInfo) {
                MethodTypeInfo methodTypeInfo = ((MethodTypeInfo)dataType);
            }
        }
    }
}
