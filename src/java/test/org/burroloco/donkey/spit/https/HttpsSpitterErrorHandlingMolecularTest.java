package org.burroloco.donkey.spit.https;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.OverlaysWeb;
import edge.org.apache.commons.io.FileUtilsStatic;
import org.burroloco.butcher.fixture.harness.Harness;
import org.burroloco.butcher.fixture.http.TargetHttpServer;
import org.burroloco.config.core.Config;
import org.burroloco.config.loader.ConfigLoader;
import org.burroloco.donkey.data.core.Data;
import org.burroloco.donkey.gargle.XmlGargler;
import org.burroloco.donkey.glue.testcase.DonkeyTestCase;
import org.burroloco.donkey.spit.core.Spitter;
import org.burroloco.donkey.spit.http.HttpsSpitter;
import org.junit.Assert;

import java.io.File;
import java.util.Collection;

import static org.apache.commons.io.filefilter.CanReadFileFilter.CAN_READ;
import static org.apache.commons.io.filefilter.FileFileFilter.FILE;
import static org.burroloco.butcher.fixture.checker.log.LogChecker.*;

public class HttpsSpitterErrorHandlingMolecularTest extends DonkeyTestCase implements HasFixtures, OverlaysWeb, Destroyable {

    private static final File EXPECTED = new File("./data/expected/employee-1.xml");
    private static final File ERROR_DIR = new File("./gen/demo/error");

    private String expected;
    private Data requests;
    private Config c;

    TargetHttpServer server;
    FileUtilsStatic files;
    ConfigLoader loader;
    XmlGargler gargler;
    Harness harness;
    Spitter subject;

    public void overlay() {
        wire.cls(HttpsSpitter.class).to(Spitter.class);
    }

    public void fixtures() {
        c = loader.load("./config/spit/https.properties");
        setUpHttpRequests();
        expected = files.readFileToString(EXPECTED);
        server.start();
    }

    public void testServerErrorHandling() {
        subject.spit(c, requests);
        checkErrorFileCreated();
        checkErrorLogged();
    }

    private void checkErrorFileCreated() {
        Collection<File> errorFiles = files.listFiles(ERROR_DIR, FILE, CAN_READ);
        check(errorFiles);
    }
    private void checkErrorLogged() {
        checkLogContains(".*URL: https://.*");
        checkLogContains(".*Response Code: 500.*");
        checkLogContains("Sent.*\\<\\?xml.*");
    }

    private void check(Collection<File> errors) {
        boolean found = findError(errors);
        String onFailure = "Can't find the error file in " + ERROR_DIR.getName();
        Assert.assertTrue(onFailure, found);
    }

    private boolean findError(Collection<File> errors) {
        for (File f : errors) {
            String actual = files.readFileToString(f);
            if (expected.equals(actual)) return true;
        }
        return false;
    }

    private void setUpHttpRequests() {
        Data rows = harness.rows();
        requests = gargler.gargle(c, rows);
    }

    public void destroy() {
        files.cleanDirectory(ERROR_DIR);
        server.stop();
    }
}
