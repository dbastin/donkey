package org.burroloco.shed.api.log;

import org.burroloco.shed.model.Environment;

public interface LogRetriever {
    String retrieve(Environment env, String filename);
}
