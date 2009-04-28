package org.burroloco.test.butcher.util.dbunit;

import au.net.netstorm.boost.bullet.log.Log;
import edge.org.apache.commons.io.FileUtilsStatic;
import edge.org.dbunit.database.IDatabaseConnection;
import edge.org.dbunit.database.statement.IBatchStatement;
import edge.org.dbunit.database.statement.IStatementFactory;
import org.burroloco.test.butcher.util.string.StringGroupFinder;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.*;

public class DefaultDbScriptRunner implements DbScriptRunner {
    private static final Pattern STATEMENT = compile("(.*?)go(\\n|\\z)", DOTALL | CASE_INSENSITIVE);
    StringGroupFinder groupFinder;
    FileUtilsStatic fileUtil;
    List<String> errors;
    Log log;

    public List<String> run(File file, IDatabaseConnection connection, Pattern... expectedErrors) {
        errors.clear();
        execute(parse(file), connection, expectedErrors);
        return errors;
    }

    public List<String> errors() {
        return errors;
    }

    private List<String> parse(File file) {
        String sqlText = fileUtil.readFileToString(file);
        return groupFinder.find(sqlText, STATEMENT, 1);
    }

    private void execute(List<String> statements, IDatabaseConnection connection, Pattern[] expectedErrors) {
        IStatementFactory iStatementFactory = connection.getStatementFactory();
        IBatchStatement statement = iStatementFactory.createBatchStatement(connection);
        log.info("Found " + statements.size() + " statements to execute...");
        for (String sql : statements) tryExecute(statement, sql, expectedErrors);
        statement.close();
    }

    private void tryExecute(IBatchStatement statement, String sql, Pattern[] expectedErrors) {
        try {
            sql(statement, sql);
        } catch (RuntimeException e) {
            handleError(sql, e, expectedErrors);
        } finally {
            statement.clearBatch();
        }
    }

    private void sql(IBatchStatement statement, String sql) {
        log.info("Executing SQL...");
        statement.addBatch(sql);
        int count = statement.executeBatch();
        log.info("Updated " + count + " rows in the database");
    }

    private void handleError(String sql, RuntimeException e, Pattern[] expectedErrors) {
        Throwable error = e.getCause();
        if (error instanceof SQLException) {
            log.error("Failed to execute statement: " + sql, error);
            checkError(error.getMessage(), expectedErrors);
        } else {
            throw e;
        }
    }

    private void checkError(String errorMessage, Pattern[] expectedErrors) {
        for (Pattern pattern : expectedErrors) {
            if (pattern.matcher(errorMessage).find()) return;
        }
        errors.add(errorMessage);
    }
}
