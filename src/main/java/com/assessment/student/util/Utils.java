package com.assessment.student.util;

import java.util.List;
import java.util.Map;

public class Utils {

    public static boolean isNullOrEmpty(Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    public static boolean isEmptyList(List<?> list) {
        return list == null || list.isEmpty();
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }


}
