package org.burroloco.donkey.demo.http2jdbc;

import au.net.netstorm.boost.gunge.lifecycle.Stop;
import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.job.Job;
import org.burroloco.donkey.trebuchet.TestTrebuchet;
import org.burroloco.util.snooze.Snoozer;

import java.io.File;
import java.io.IOException;

public class HttpToCsvDemoTest extends DonkeyTestCase implements Destroyable {
    private static final File EXPECTED = new File("data/expected/news.csv");
    private static final File ACTUAL = new File("gen/demo/out/news.csv");
    FileComparator comparator;
    TestTrebuchet trebuchet;
    Snoozer snoozer;
    Impl impl;

    public void testHttpToCsv() throws IOException {
        trebuchet.launch(HttpToCsvSpecification.class, TestServerWeb.class);
        snoozer.snooze(1000);
        sendMessage();
        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    private void sendMessage() throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpGet post = new HttpGet("http://localhost:8090/http2jdbc?Date=2009-01-01&Message=Hello%20World");
        client.execute(post);
    }

    public void destroy() {
        Job job = spider.resolve(Job.class);
        ((Stop)job).stop();
    }
}
