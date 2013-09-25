package org.burroloco.butcher.fixture.http;

import java.util.List;

public interface TargetHttpServer {
    List<String> requests();

    void start();

    void stop();
}
