package com.wazzawin.shared.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public class WazzaUtils {

    public static <T> List<T> safeList(List<T> list) {
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public static <T> Collection<T> safeCollection(Collection<T> collection) {
        return collection == null ? Collections.EMPTY_SET : collection;
    }

    public static <TK, TV> Map<TK, TV> safeMap(Map<TK, TV> map) {
        return map == null ? Collections.EMPTY_MAP : map;
    }
}
