package org.burroloco.tibco.inbox;

import edge.java.net.InetAddressStatic;

public class DefaultLocalHost implements LocalHost {
    InetAddressStatic inetAddress;

    public String shortName() {
        String hostName = inetAddress.getLocalHost().getHostName();
        String[] splitNames = hostName.split("\\.", 2);
        return splitNames[0];
    }
}

