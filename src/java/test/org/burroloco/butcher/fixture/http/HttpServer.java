package org.burroloco.butcher.fixture.http;

public interface HttpServer {
    String payload();

    void start();

    void stop();
}
