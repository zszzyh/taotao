package com.cwb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 字符串日期转data类型
* */

public class StringToDate {
    public static Date test(String string) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(string);
    }
}
