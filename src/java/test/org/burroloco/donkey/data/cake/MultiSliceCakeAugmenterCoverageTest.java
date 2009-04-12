package org.burroloco.donkey.data.cake;

import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.LazyFields;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import org.burroloco.config.core.Config;
import org.burroloco.test.glue.testcase.DonkeyTestCase;

import java.util.List;

public class MultiSliceCakeAugmenterCoverageTest extends DonkeyTestCase implements LazyFields, InjectableSubject {
    private CakeAugmenter subject = new MultiSliceCakeAugmenter();
    List<Slice> slices;
    Config configMock;
    Cake cakeMock;
    String key;
    Nu nu;

    public void testHandleNoRejects() {
        expect.oneCall(cakeMock, slices, "slices");
        expect.oneCall(configMock, configMock, "flatten", "opics");
        subject.augment(configMock, cakeMock, key);
    }
}
