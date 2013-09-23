package org.burroloco.butcher.fixture.http;

public interface TargetHttpServer {
    String payload();

    void start();

    void stop();
}
