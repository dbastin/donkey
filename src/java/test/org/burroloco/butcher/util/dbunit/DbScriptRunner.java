package org.burroloco.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public interface DbScriptRunner {
    List<String> run(File file, IDatabaseConnection connection, Pattern... allowedErrors);
}
