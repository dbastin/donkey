package org.burroloco.donkey.input.tibco;

import org.burroloco.donkey.data.cake.Cake;
import edge.com.tibco.tibrv.TibrvMsg;

public interface MessageConverter {
    Cake convert(TibrvMsg msg);
}
