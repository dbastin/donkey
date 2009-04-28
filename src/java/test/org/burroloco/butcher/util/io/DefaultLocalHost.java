package org.burroloco.butcher.util.io;

import edge.java.net.InetAddressStatic;

import java.net.InetAddress;

public class DefaultLocalHost implements LocalHost {
    InetAddressStatic inetAddress;

    public String shortName() {
        InetAddress localHost = inetAddress.getLocalHost();
        String hostName = localHost.getHostName();
        String[] splitNames = hostName.split("\\.", 2);
        return splitNames[0];
    }
}
