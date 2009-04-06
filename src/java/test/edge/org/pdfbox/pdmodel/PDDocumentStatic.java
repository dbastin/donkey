package edge.org.pdfbox.pdmodel;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;

import java.io.InputStream;

public interface PDDocumentStatic extends Edge {
    PDDocument load(InputStream inputStream);
}
