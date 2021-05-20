package com.jy.casestudy.jvm;

import cn.t.util.common.digital.HexUtil;
import com.jy.casestudy.jvm.datatype.base.DataType;

import java.util.ArrayList;
import java.util.List;

public class ClassFile {

    /**
     * 4 bytes
     * */
    private byte[] magicNumber;

    /**
     * 次版本
     * */
    private short minor;

    /**
     * 主版本
     * */
    private short majorVersion;

    /**
     * 常量池
     * */
    private final List<DataType> constantsPool = new ArrayList<DataType>(){{add(null);}};

    /**
     * 类访问标志
     * */
    private List<com.jy.casestudy.jvm.AccessFlag> classAccessFlagList = new ArrayList<>();

    /**
     * 全限定类名
     * */
    private String qualifiedClassName;

    /**
     * 全限定父类名
     * */
    private String qualifiedSuperClassName;

    /**
     * 全限定接口名称
     * */
    private List<String> qualifiedInterfaceClassNameList = new ArrayList<>();

    /**
     * field列表
     * */
    private List<com.jy.casestudy.jvm.ClassField> fieldList = new ArrayList<>();

    public byte[] getMagicNumber() {
        return magicNumber;
    }

    public void setMagicNumber(byte[] magicNumber) {
        this.magicNumber = magicNumber;
    }

    public short getMinor() {
        return minor;
    }

    public void setMinor(short minor) {
        this.minor = minor;
    }

    public short getMajorVersion() {
        return majorVersion;
    }

    public void setMajorVersion(short majorVersion) {
        this.majorVersion = majorVersion;
    }

    public List<DataType> getConstantsPool() {
        return constantsPool;
    }

    public void setConstantsPool(List<DataType> constantsPool) {
        if(constantsPool!= null && constantsPool.size() > 0) {
            this.constantsPool.addAll(constantsPool);
        }
    }

    public void addConstantsPool(DataType dataType) {
        this.constantsPool.add(dataType);
    }

    public List<com.jy.casestudy.jvm.AccessFlag> getClassAccessFlagList() {
        return classAccessFlagList;
    }

    public void setClassAccessFlagList(List<com.jy.casestudy.jvm.AccessFlag> classAccessFlagList) {
        this.classAccessFlagList = classAccessFlagList;
    }

    public String getQualifiedClassName() {
        return qualifiedClassName;
    }

    public void setQualifiedClassName(String qualifiedClassName) {
        this.qualifiedClassName = qualifiedClassName;
    }

    public String getQualifiedSuperClassName() {
        return qualifiedSuperClassName;
    }

    public void setQualifiedSuperClassName(String qualifiedSuperClassName) {
        this.qualifiedSuperClassName = qualifiedSuperClassName;
    }

    public List<String> getQualifiedInterfaceClassNameList() {
        return qualifiedInterfaceClassNameList;
    }

    public void setQualifiedInterfaceClassNameList(List<String> qualifiedInterfaceClassNameList) {
        this.qualifiedInterfaceClassNameList = qualifiedInterfaceClassNameList;
    }

    public List<com.jy.casestudy.jvm.ClassField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<com.jy.casestudy.jvm.ClassField> fieldList) {
        this.fieldList = fieldList;
    }

    @Override
    public String toString() {
        return "ClassFile{" +
            "magicNumber=" + HexUtil.bytesToHex(magicNumber) +
            ", minor=" + minor +
            ", majorVersion=" + majorVersion +
            '}';
    }

    public String javapPrint() {
        StringBuilder sb = new StringBuilder("Constant pool:\n");
        for(int i=1; i< constantsPool.size(); i++) {
            DataType dataType = constantsPool.get(i);
            String str = String.valueOf(i);
            for(int k=0; k<(6-1-str.length()); k++) {
                sb.append(" ");
            }
            sb.append("#").append(i).append(" = ").append(dataType.javapPrint()).append("\n");
        }
        sb.append("{\n");
        for(com.jy.casestudy.jvm.AccessFlag flag: classAccessFlagList) {
            sb.append("  ").append(flag.toString().toLowerCase());
        }
        sb.append(qualifiedClassName).append("();").append("\n");
        sb.append("}");
        return sb.toString();
    }

}
