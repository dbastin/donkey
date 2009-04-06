package org.burroloco.donkey.input.database;

import static org.burroloco.test.constants.DbTestConstants.SQL_TOKEN;

public class WrappingSqlBuilder implements SqlBuilder {
    private String wrapTemplate;

    public WrappingSqlBuilder(String wrapTemplate) {
        this.wrapTemplate = wrapTemplate;
    }

    public String build(String sql) {
        return wrapTemplate.replaceAll(SQL_TOKEN, sql);
    }
}
