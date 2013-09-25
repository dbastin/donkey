package org.burroloco.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

import static junit.framework.Assert.fail;

public class DefaultSqller implements Sqller {
    DbScriptRunner dbScriptRunner;

    public void process(IDatabaseConnection connection, File file, Pattern[] allowedErrors) {
        List<String> errors = dbScriptRunner.run(file, connection, allowedErrors);
        if (!errors.isEmpty()) fail(failureMessage(errors));
    }

    private String failureMessage(List<String> errors) {
        StringBuilder b = new StringBuilder();
        b.append("Unexpected migration errors: ");
        for (String error : errors) {
            b.append("[");
            b.append(error);
            b.append("]");
        }
        return b.toString();
    }}
