package com.ovuwork.im.common.dao;


import com.ovuwork.im.common.dao.BuildSql;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangruchao on 2018/4/8.
 */
public class SqlUtil {

    private static final String fileName = "sqls.js";
    private static final String funName = "getSql";

    public static String getSql(String sqlKey) {
        Map<String, Object> params = new HashMap<>();
        params.put("sqlKey", sqlKey);
        return BuildSql.run(fileName, funName, params).toString();
    }
}
