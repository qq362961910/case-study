package com.jy.casestudy.jvm;

import java.util.ArrayList;
import java.util.List;

public enum  AccessFlag {

    PUBLIC((short)0X0001),

    FINAL((short)0X0010),

    SUPER((short)0X0020),

    INTERFACE((short)0X0200),

    ABSTRACT((short)0X0400),

    SYNTHETIC((short)0X1000),

    ANNOTATION((short)0X2000),

    ENUM((short)0X4000),

    ;

    public static List<AccessFlag> getAccessFlag(short value) {
        List<AccessFlag> accessFlagList = new ArrayList<>();
        for(com.jy.casestudy.jvm.AccessFlag flag: values()) {
            if((flag.value & value) == flag.value) {
                accessFlagList.add(flag);
            }
        }
        return accessFlagList;
    }

    private short value;

    AccessFlag(short value) {
        this.value = value;
    }
}
