package org.burroloco.donkey.spit.https;

import au.net.netstorm.boost.sniper.marker.HasFixtures;
import edge.org.apache.http.client.methods.HttpPost;
import org.burroloco.donkey.data.core.DefaultTuple;
import org.burroloco.donkey.data.core.Tuple;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.spit.http.HttpPosts;

public class PostMasterAtomicTest extends DonkeyTestCase implements HasFixtures {

    public static final String URL = "http://whatever.com";
    private Tuple tuple;

    PostMaster subject;
    HttpPosts posts;

    public void fixtures() {
        tuple = new DefaultTuple();
        tuple.add(Tuple.UNIT_KEY, "whatevs");
    }

    public void testAddParameters() {
        HttpPost post = posts.nu(tuple, URL);
        subject.addParameter(post, "dingle", "dongle");
        assertEquals(URL + "?dingle=dongle", post.getURI().toString());
    }
}
