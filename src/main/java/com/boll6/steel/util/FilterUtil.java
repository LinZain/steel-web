package com.boll6.steel.util;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterUtil implements Filter {
    public void destroy() {
        // TODO Auto-generated method stub
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }

    public void doFilter(ServletRequest args0, ServletResponse args1, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) args0;
        Enumeration<?> params = req.getParameterNames();
        String sql = "";
        while (params.hasMoreElements()) {
            String name = params.nextElement().toString();
            String[] value = req.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                sql = sql + value[i];
            }
        }
        if (sqlValidate(sql)) {
            throw new IOException("Illegal param");
        } else {
            chain.doFilter(args0, args1);
        }
    }

    protected static boolean sqlValidate(String str) {
        str = str.toLowerCase();
        String badStr = "'|exec|execute|insert|select|delete|drop|master|truncate|"
                + "declare|sitename|net user|xp_cmdshell|like'|exec|execute|insert|create|drop|"
                + "table|from|grant|use|group_concat|column_name|"
                + "information_schema.columns|table_schema|union|where|select|delete|order|"
                + "master|truncate|declare|";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }
}
