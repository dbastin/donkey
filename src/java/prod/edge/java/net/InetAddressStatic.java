package edge.java.net;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.net.InetAddress;

public interface InetAddressStatic extends Edge {
    InetAddress getLocalHost();
}
