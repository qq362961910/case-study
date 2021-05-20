package com.jy.casestudy.jvm;

public enum AttributeType {

    ConstantValue("ConstantValue"),
    Code("Code"),
    StackMapTable("StackMapTable"),
    Exceptions("Exceptions"),
    InnerClasses("InnerClasses"),
    EnclosingMethod("EnclosingMethod"),
    Synthetic("Synthetic"),
    Signature("Signature"),
    SourceFile("SourceFile"),
    SourceDebugExtension("SourceDebugExtension"),
    LineNumberTable("LineNumberTable"),
    LocalVariableTable("LocalVariableTable"),
    LocalVariableTypeTable("LocalVariableTypeTable"),
    Deprecated("Deprecated"),
    RuntimeVisibleAnnotations("RuntimeVisibleAnnotations"),
    RuntimeInvisibleAnnotations("RuntimeInvisibleAnnotations"),
    RuntimeVisibleParameterAnnotations("RuntimeVisibleParameterAnnotations"),
    RuntimeInvisibleParameterAnnotations("RuntimeInvisibleParameterAnnotations"),
    AnnotationDefault("AnnotationDefault"),
    BootstrapMethods("BootstrapMethods")
    ;

    public static com.jy.casestudy.jvm.AttributeType getAttributeType(String value) {
        for(com.jy.casestudy.jvm.AttributeType type: values()) {
            if(type.value.equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }

    public String value;

    AttributeType(String value) {
        this.value = value;
    }
}
