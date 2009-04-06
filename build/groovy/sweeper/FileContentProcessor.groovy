package sweeper

import org.codehaus.groovy.ant.FileScanner

class FileContentProcessor {

    List processFiles(FileScanner files, LineProcessor checker) {
        def fixes = []
        for (file in files) {
            checkLine(fixes, file, checker)
        }
        return fixes
    }

    private void checkLine(List fixes, File file, LineProcessor checker) {
        int lineNumber = 0
        file.eachLine {ln ->
            lineNumber++
            boolean matches = checker.checkLine(ln)
            if (matches) fixes << checker.getFix(file, lineNumber, ln)
        }
    }
}
