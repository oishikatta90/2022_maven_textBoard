package com.lhw.project1.user.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getNowDateStr() {
        SimpleDateFormat format1 = new SimpleDateFormat();
        Date time = new Date();
        return format1.format(time);
    }

}
