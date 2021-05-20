package com.jy.casestudy.jvm.datatype;

import com.jy.casestudy.jvm.ConstantsPoolDataType;
import com.jy.casestudy.jvm.datatype.base.DataType;

public class StringInfo extends DataType {

    private short valueIndex;
    private Utf8Info value;

    public StringInfo() {
        super(ConstantsPoolDataType.STRING);
    }

    public StringInfo(Utf8Info value) {
        super(ConstantsPoolDataType.STRING);
        this.value = value;
    }

    public short getValueIndex() {
        return valueIndex;
    }

    public void setValueIndex(short valueIndex) {
        this.valueIndex = valueIndex;
    }

    public Utf8Info getValue() {
        return value;
    }

    public void setValue(Utf8Info value) {
        this.value = value;
    }

    @Override
    public String javapSupplement() {
        StringBuilder sb = new StringBuilder(String.format("#%d", valueIndex));
        for(int i=0; i< (14-sb.length()); i++) {
            sb.append(" ");
        }
        sb.append("// ").append(new String(value.getBytes()));
        return sb.toString();
    }
}
