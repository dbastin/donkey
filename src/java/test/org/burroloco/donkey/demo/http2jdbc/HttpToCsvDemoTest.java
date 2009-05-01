package org.burroloco.donkey.demo.http2jdbc;

import au.net.netstorm.boost.spider.api.runtime.Impl;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.burroloco.butcher.util.file.FileComparator;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.trebuchet.Trebuchet;
import org.burroloco.util.snooze.Snoozer;

import java.io.IOException;
import java.io.File;

public class HttpToCsvDemoTest extends DonkeyTestCase {
    private static final File EXPECTED = new File("data/expected/news.csv");
    private static final File ACTUAL = new File("gen/demo/out/news.csv");
    FileComparator comparator;
    Trebuchet trebuchet;
    Snoozer snoozer;
    Impl impl;

    public void testHttpToCsv() throws IOException {
        trebuchet.launch(HttpToCsvSpecification.class);
        snoozer.snooze(2000);
        sendMessage("This is the best thing since sliced bread");
        // FIX TSR-DONKEY WIP...
//        comparator.assertEquals(EXPECTED, ACTUAL);
    }

    private void sendMessage(String s) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://localhost:8090/http2jdbc");
        HttpEntity entity = impl.impl(StringEntity.class, s);
        post.setEntity(entity);
        client.execute(post);
    }
}
