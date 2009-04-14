package org.burroloco.tibco.factory;

import au.net.netstorm.boost.sniper.marker.Destroyable;
import au.net.netstorm.boost.spider.api.runtime.Nu;
import static com.tibco.tibrv.Tibrv.IMPL_NATIVE;
import edge.com.tibco.tibrv.TibrvDispatcher;
import edge.com.tibco.tibrv.TibrvQueue;
import edge.com.tibco.tibrv.TibrvStatic;
import org.burroloco.tibco.transport.TibcoTransport;
import org.burroloco.tibco.transport.TibcoTransportFactory;

import java.util.List;

public class DefaultLifecycleTibcoFactory implements LifecycleTibcoFactory {
    List<Destroyable> destroyables;
    TibcoTransportFactory transports;
    TibrvStatic tibrv;
    Nu nu;

    // FIX TSR-DONKEY Use or Lose
    public TibrvQueue queue() {
        open();
        TibrvQueue q = nu.nu(TibrvQueue.class);
        destroyables.add(q);
        return q;
    }

    // FIX TSR-DONKEY Use or Lose
    public TibrvDispatcher dispatcher(TibrvQueue queue) {
        open();
        TibrvDispatcher d = nu.nu(TibrvDispatcher.class, queue);
        destroyables.add(d);
        return d;
    }

    public TibcoTransport transport() {
        open();
        TibcoTransport transport = transports.nu();
        destroyables.add(transport.tibby());
        return transport;
    }

    public void destroy() {
        for (Destroyable d : destroyables) d.destroy();
        destroyables.clear();
        tibrv.close();
    }

    private void open() {
        if(destroyables.isEmpty()) tibrv.open(IMPL_NATIVE);
    }
}
