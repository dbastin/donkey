package edge.org.pdfbox.util;

import au.net.netstorm.boost.bullet.scalpel.core.Edge;
import edge.org.pdfbox.pdmodel.PDDocument;

public interface PDFTextStripper extends Edge {
    String getText(PDDocument document);
}
