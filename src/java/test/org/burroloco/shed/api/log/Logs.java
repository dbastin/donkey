package org.burroloco.shed.api.log;

import org.burroloco.shed.model.Environment;

public interface Logs {
    String[] start(Environment env);

    String[] shutdown(Environment env);

    String[] refresh(Environment env);
}
