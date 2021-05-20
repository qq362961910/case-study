package com.jy.casestudy.jvm;

public enum ConstantsPoolDataType {

    /**
     * UTF-8编码的字符串
     * */
    UTF8((byte)1),

    /**
     * 整形字面量
     * */
    INTEGER((byte)3),

    /**
     * 单精度浮点型字面量
     * */
    FLOAT((byte)4),

    /**
     * 长整型字面量
     * */
    LONG((byte)5),

    /**
     * 双精度浮点型字面量
     * */
    DOUBLE((byte)6),

    /**
     * 类或接口的符号引用
     * */
    CLASS((byte)7),

    /**
     * 字符串类型字面量
     * */
    STRING((byte)8),

    /**
     * 字段的符号引用
     * */
    FIELDREF((byte)9),

    /**
     * 类中方法的符号引用
     * */
    METHODREF((byte)10),

    /**
     * 接口中方法的符号引用
     * */
    INTERFACEMETHODREF((byte)11),

    /**
     * 字段或方法的符号引用
     * */
    NAMEANDTYPE((byte)12),

    /**
     * 表示方法句柄
     * */
    METHODHANDLE((byte)15),

    /**
     * 标志方法类型
     * */
    METHODTYPE((byte)16),

    /**
     * 表示一个动态方法调用点
     * */
    INVOKEDYNAMIC((byte)18)
    ;

    public static com.jy.casestudy.jvm.ConstantsPoolDataType getConstantsPoolDataType(byte value) {
        for(com.jy.casestudy.jvm.ConstantsPoolDataType dataType: values()) {
            if(dataType.tag == value) {
                return dataType;
            }
        }
        return null;
    }

    ConstantsPoolDataType(byte tag) {
        this.tag = tag;
    }

    public byte tag;

}
