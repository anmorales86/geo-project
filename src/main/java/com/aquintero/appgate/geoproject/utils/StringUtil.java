package com.aquintero.appgate.geoproject.utils;

import java.util.Objects;

public class StringUtil
{

    public static Boolean isNullOrEmpty(String t)
    {
        if (Objects.isNull(t) || t.isEmpty()) { return true; }
        return false;

    }

}
