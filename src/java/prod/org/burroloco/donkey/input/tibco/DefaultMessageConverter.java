package org.burroloco.donkey.input.tibco;

import au.net.netstorm.boost.spider.api.runtime.Nu;
import com.tibco.tibrv.TibrvMsgField;
import edge.com.tibco.tibrv.TibrvMsg;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.data.cake.Slice;

public class DefaultMessageConverter implements MessageConverter {
    Nu nu;

    public Cake convert(TibrvMsg message) {
        Cake result = nu.nu(Cake.class);
        for (int i = 0; i < message.getNumFields(); ++i) {
            TibrvMsgField field = message.getFieldByIndex(i);
            add(result, field);
        }
        return result;
    }

    private void add(Cake result, TibrvMsgField field) {
        Slice s = nu.nu(Slice.class);
        s.add("NAME", field.name);
        s.add("DATA", field.data);
        result.add(s);
    }
}
