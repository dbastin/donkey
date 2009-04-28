package org.burroloco.butcher.util.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class DefaultStreamGobbler implements StreamGobbler {
    private boolean finished;
    private OutputStream os;
    private InputStream is;
    private Thread thread;

    public DefaultStreamGobbler(String name, InputStream is, OutputStream redirect) {
        this.is = is;
        this.os = redirect;
        this.thread = new Thread(new GobblerRunnable(), name);
    }

    public void start() {
        thread.start();
    }

    public synchronized void close() {
        finished = true;
    }

    private class GobblerRunnable implements Runnable {
        public void run() {
            try {
                PrintWriter pw = null;
                if (os != null) pw = new PrintWriter(os);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                print(pw, br);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        private void print(PrintWriter pw, BufferedReader br) throws IOException {
            while (!finished) {
                if (!readAndPrint(pw, br)) break;
            }
        }

        private synchronized boolean readAndPrint(PrintWriter pw, BufferedReader br) {
            try {
                if (br.ready()) {
                    if (!readLine(pw, br)) return false;
                }
            } catch (IOException e) {
                return false;
            }
            return true;
        }

        private boolean readLine(PrintWriter pw, BufferedReader br) throws IOException {
            String line = br.readLine();
            if (line == null) return false;
            pw.println(line);
            pw.flush();
            return true;
        }

    }
}
