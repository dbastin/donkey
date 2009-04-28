package org.burroloco.donkey.input.database;

public class WrappingSqlBuilder implements SqlBuilder {
    private static final String SQL_TOKEN = "@PROD_SQL@";
    private String wrapTemplate;

    public WrappingSqlBuilder(String wrapTemplate) {
        this.wrapTemplate = wrapTemplate;
    }

    public String build(String sql) {
        return wrapTemplate.replaceAll(SQL_TOKEN, sql);
    }
}
