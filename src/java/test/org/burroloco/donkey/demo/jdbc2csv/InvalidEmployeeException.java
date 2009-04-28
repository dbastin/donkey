package org.burroloco.donkey.demo.jdbc2csv;

public class InvalidEmployeeException extends RuntimeException {
    public InvalidEmployeeException(String name) {
        super("Sorry, " + name + " is not an employee.");
    }
}
