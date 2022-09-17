/**
 * DANA
 * Copyright (c) 2018‐2022 All Rights Reserved.
 */
package com.irfaan.movies.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author irfaanhibatullah
 * @version $Id: SortEnum.java, v 0.1 2022‐09‐18 05.18 irfaanhibatullah Exp $$
 */
public enum SortEnum {

    NEWEST_MOVIES("newest"),

    OLDEST_MOVIES("oldest");

    SortEnum(String code) {
        this.code = code;
    }

    private String code;

    public static SortEnum getByCode(String code) {
        for (SortEnum item : values()) {
            if (StringUtils.equals(item.getCode(), code)) {
                return item;
            }
        }
        return null;
    }
    public String getCode() {
        return code;
    }
}