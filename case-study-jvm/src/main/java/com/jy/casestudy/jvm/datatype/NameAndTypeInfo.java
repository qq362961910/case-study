package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class NameAndTypeInfo extends DataType {

    private short nameIndex;
    private Utf8Info name;
    private short typeIndex;
    private Utf8Info type;

    public NameAndTypeInfo() {
        super(ConstantsPoolDataType.NAMEANDTYPE);
    }

    public NameAndTypeInfo(short nameIndex, short typeIndex) {
        super(ConstantsPoolDataType.NAMEANDTYPE);
        this.nameIndex = nameIndex;
        this.typeIndex = typeIndex;
    }

    public short getNameIndex() {
        return nameIndex;
    }

    public void setNameIndex(short nameIndex) {
        this.nameIndex = nameIndex;
    }

    public Utf8Info getName() {
        return name;
    }

    public void setName(Utf8Info name) {
        this.name = name;
    }

    public short getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(short typeIndex) {
        this.typeIndex = typeIndex;
    }

    public Utf8Info getType() {
        return type;
    }

    public void setType(Utf8Info type) {
        this.type = type;
    }

    @Override
    public String javapSupplement() {
        StringBuilder sb = new StringBuilder(String.format("#%d.#%d", nameIndex, typeIndex));
        for(int i=0; i< (14-sb.length()); i++) {
            sb.append(" ");
        }
        sb.append("// ").
            append(new String(name.getBytes())).append(":").append(new String(type.getBytes()));
        return sb.toString();
    }
}
