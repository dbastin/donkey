package org.burroloco.butcher.util.dbunit;

import edge.org.dbunit.database.IDatabaseConnection;

import java.io.File;
import java.util.regex.Pattern;

public interface Sqller {
    void process(IDatabaseConnection kondor, File file, Pattern[] allowedErrors);
}
