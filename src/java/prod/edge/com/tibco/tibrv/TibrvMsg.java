package edge.com.tibco.tibrv;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import au.net.netstorm.boost.bullet.scalpel.core.Unedgable;
import com.tibco.tibrv.TibrvMsgField;

public interface TibrvMsg extends Edge, Unedgable {
    short STRING = com.tibco.tibrv.TibrvMsg.STRING;
    short I32 = com.tibco.tibrv.TibrvMsg.I32;

    void setSendSubject(String subject);

    void add(String s, Object o);

    String toString();

    Object get(java.lang.String s);

    String getSendSubject();

    int getNumFields();

    TibrvMsgField getFieldByIndex(int fieldIndex);
}
