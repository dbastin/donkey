package org.burroloco.interfaces.common.checker;

public interface FailureExpectation extends IncomingExpectation {
    Exception exception();
}
