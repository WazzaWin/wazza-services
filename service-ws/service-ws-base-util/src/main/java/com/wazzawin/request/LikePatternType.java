package com.wazzawin.request;

/**
 * @author Nazzareno Sileno - WazzaWin Developer Group
 * @email nazzareno.sileno@gmail.com
 */
public enum LikePatternType {

    CONTAINS,
    STARTS_WITH,
    ENDS_WITH,
    CONTENT_EQUALS;
    //
    private static String PERCENT = "%";

    public String apply(String s) {
        if (s == null || s.trim().length() == 0) {
            return null;
        }
        if (this == LikePatternType.CONTAINS) {
            return PERCENT + s + PERCENT;
        } else if (this == LikePatternType.STARTS_WITH) {
            return s + PERCENT;
        } else if (this == LikePatternType.ENDS_WITH) {
            return PERCENT + s;
        }
        return s; // CONTENT_EQUALS
    }
}
