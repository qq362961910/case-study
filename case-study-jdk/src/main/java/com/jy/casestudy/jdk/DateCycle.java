package com.jy.casestudy.jdk;


import cn.t.util.common.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateCycle {

    private static final Logger logger = LoggerFactory.getLogger(DateCycle.class);

    public static void main(String[] args) throws Exception {
        m1();
//        m2();
    }

    /**
     * 循环每一天
     */
    private static void m1() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
        Date startTime = simpleDateFormat.parse("2010-01-20");
        Date endTime = simpleDateFormat.parse("2010-03-15");
        Calendar calStart = Calendar.getInstance();
        Calendar calEnd = Calendar.getInstance();
        calStart.setTime(startTime);
        calEnd.setTime(endTime);
        while (!calStart.after(calEnd)) {
            Date current = calStart.getTime();
            logger.info(simpleDateFormat.format(current));
            calStart.add(Calendar.DAY_OF_YEAR, 1);
        }
    }

    private static void m2() {
        String dateStrBegin = "2010-01-20";
        String dateStrEnd = "2010-03-16";
        LocalDate begin = DateUtil.parseLocalDate(dateStrBegin);
        LocalDate end = DateUtil.parseLocalDate(dateStrEnd);
        while (!begin.isAfter(end)) {
            logger.info(DateUtil.formatLocalDate(begin));
            begin = begin.plusDays(1);
        }
    }
}
