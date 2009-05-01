package org.burroloco.donkey.demo.http2jdbc;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;
import java.io.IOException;

public class HttpToCsvDemoTest extends DonkeyTestCase {
    private static final File EXPECTED = new File("data/expected/news.csv");
    private static final File ACTUAL = new File("gen/demo/out/news.csv");
    FileComparator comparator;
    Trebuchet trebuchet;
    Snoozer snoozer;
    Impl impl;

    public void testHttpToCsv() throws IOException {
        trebuchet.launch(HttpToCsvSpecification.class);
        snoozer.snooze(1000);
        sendMessage();
        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    private void sendMessage() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet post = new HttpGet("http://localhost:8090/http2jdbc?Date=2009-01-01&Message=Hello%20World");
        client.execute(post);
    }
}
