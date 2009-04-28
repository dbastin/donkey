package org.burroloco.butcher.fixture.process;

import edge.java.lang.Runtime;
import edge.java.lang.RuntimeStatic;
import org.burroloco.butcher.util.io.DefaultStreamGobbler;
import org.burroloco.butcher.util.io.StreamGobbler;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

public class DefaultCommandController implements CommandController {
    private static final String[] NO_ENVP_VARS = null;
    private StreamGobbler outGobbler;
    private StreamGobbler errGobbler;
    RuntimeStatic runtime;

    public Process start(File workingDir, String... command) {
        // OK IllegalRegexp {
        return start(workingDir, System.out, System.err, command);
        // }
    }

    public Process start(File workingDir, OutputStream out, OutputStream err, String... command) {
        Runtime rt = runtime.getRuntime();
        Process proc = rt.exec(command, NO_ENVP_VARS, workingDir);
        outGobbler = gobble("OutGobbler", proc.getInputStream(), out);
        errGobbler = gobble("ErrGobbler", proc.getErrorStream(), err);
        return proc;
    }

    public void destroy(Process process) {
        if (notNull(outGobbler)) outGobbler.close();
        if (notNull(errGobbler)) errGobbler.close();
        if (notNull(process)) process.destroy();
    }

    private StreamGobbler gobble(String name, InputStream in, OutputStream out) {
        // NOTE: Do not nu.nu() here. It is returning old gobblers!
        StreamGobbler gobbler = new DefaultStreamGobbler(name, in, out);
        gobbler.start();
        return gobbler;
    }

    private boolean notNull(Object o) {
        return o != null;
    }

}
