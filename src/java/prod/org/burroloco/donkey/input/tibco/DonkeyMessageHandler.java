package org.burroloco.donkey.input.tibco;

import edge.com.tibco.tibrv.TibrvListener;
import edge.com.tibco.tibrv.TibrvMsg;
import org.burroloco.donkey.data.cake.Cake;
import org.burroloco.donkey.transformation.gargler.Gargler;
import org.burroloco.tibco.handler.core.MessageHandler;
import org.burroloco.config.core.Config;

public class DonkeyMessageHandler implements MessageHandler {
    private final Config config;
    MessageConverter converter;
    Gargler gargler;

    public DonkeyMessageHandler(Config config) {
        this.config = config;
    }

    public void onMsg(TibrvListener listener, TibrvMsg message) {
        Cake cake = converter.convert(message);
        gargler.slosh(config, cake);
    }
}
