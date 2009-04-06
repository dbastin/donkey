package org.burroloco.test.glue.block;

public class MasterDatabaseProtectionException extends RuntimeException {
    public MasterDatabaseProtectionException() {
        super("You can not run this code on the master database!");
    }
}
