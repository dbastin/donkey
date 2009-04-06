package org.burroloco.shed.internals;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.shed.model.Service;
import org.burroloco.shed.model.ServiceStatus;
import org.burroloco.shed.model.Status;
import static org.burroloco.shed.model.Status.RUNNING;
import static org.burroloco.shed.model.Status.STOPPED;

import java.util.ArrayList;
import java.util.List;

public class DefaultServiceParser implements ServiceParser {
    Nu nu;

    public List<ServiceStatus> parse(String user, String text) {
        List<ServiceStatus> services = new ArrayList<ServiceStatus>();
        String[] lines = lines(text);
        for (String line : lines) parse(services, user, line);
        return services;
    }

    private String[] lines(String text) {
        return text.split("\n");
    }

    private void parse(List<ServiceStatus> services, String user, String line) {
        if (ignore(line)) return;
        String name = line.replaceAll("([\\w/\\$]+).*", "$1");
        Status status = stopped(line) ? STOPPED : RUNNING;
        add(services, user, name, status);
    }

    private boolean ignore(String line) {
        return line.matches(".*-{20,}.*") || line.matches("WARNING! LOG DIRECTORY.*") || line.matches("INFO : LOG DIRECTORY SIZE.*");
    }

    private boolean stopped(String line) {
        return line.contains("NOT RUNNING") || line.contains("NOT FOUND");
    }

    private void add(List<ServiceStatus> services, String user, String name,  Status status) {
        Service service = nu.nu(Service.class, user, name);
        ServiceStatus ss  = nu.nu(ServiceStatus.class, service, status);
        services.add(ss);
    }
}
