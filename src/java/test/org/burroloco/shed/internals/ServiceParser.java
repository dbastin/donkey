package org.burroloco.shed.internals;

import org.burroloco.shed.model.ServiceStatus;

import java.util.List;

public interface ServiceParser {
    List<ServiceStatus> parse(String user, String text);
}
