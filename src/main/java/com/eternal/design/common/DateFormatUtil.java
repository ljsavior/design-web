package com.eternal.design.common;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DateFormatUtil {
    private static Map<String, ThreadLocal<DateFormat>> dateFormatThreadLocal = new ConcurrentHashMap<>();


    public static String format(Date date, String pattern) {
        ThreadLocal<DateFormat> dateFormatThreadLocal = DateFormatUtil.dateFormatThreadLocal.computeIfAbsent(pattern, (p) -> ThreadLocal.withInitial(() -> new SimpleDateFormat(p)));
        return dateFormatThreadLocal.get().format(date);
    }
}
