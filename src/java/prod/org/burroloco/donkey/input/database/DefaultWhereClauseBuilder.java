package org.burroloco.donkey.input.database;

import au.net.netstorm.boost.gunge.collection.StrictMap;
import org.burroloco.config.loader.PropertiesLoader;

import java.util.Set;

// FIX TSR-4239 Name.
public class DefaultWhereClauseBuilder implements WhereClauseBuilder {
    private static final String WHERE_CLAUSE_TOKEN = "@WHERE_CLAUSE@";
    private String filteredField;
    private String propertyFile;
    PropertiesLoader loader;

    public DefaultWhereClauseBuilder(String propertyFile, String filteredField) {
        this.propertyFile = propertyFile;
        this.filteredField = filteredField;
    }

    public String build(String sql) {
        String keys = convertKeysToSqlSet(propertyFile);
        String filterToken = " where " + filteredField + " in " + keys;
        return sql.replace(WHERE_CLAUSE_TOKEN, filterToken);
    }

    private String convertKeysToSqlSet(String propFile) {
        StrictMap<String, String> props = loader.load(propFile);
        Set keys = props.keySet();
        return keys.toString().replaceAll(", ", "', '").replaceAll("\\[", "('").replaceAll("\\]", "')");
    }
}
