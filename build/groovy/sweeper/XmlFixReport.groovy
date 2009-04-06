package sweeper

import groovy.xml.MarkupBuilder
import java.text.SimpleDateFormat


final class XmlFixReport {
    private final String projectName
    private final List fixes
    private final int jurassicDays
    private final int stoneAgeDays

    XmlFixReport(String projectName, List fixes, int jurassicDays, int stoneAgeDays) {
        this.projectName = projectName
        this.fixes = fixes
        this.jurassicDays = jurassicDays
        this.stoneAgeDays = stoneAgeDays
    }

    void write(Writer writer) {
        fixes.sort {it.file}
        def mkp = new MarkupBuilder(writer)
        doHtml(mkp)
    }

    private doHtml(MarkupBuilder builder) {
        def reportTime = now()
        builder.fixes(project: projectName, time: reportTime, old: stoneAgeDays, expired: jurassicDays) {
            doFixes(builder)
        }
    }

    private doFixes(MarkupBuilder mkp) {
        writeFiles(mkp, fixes)
    }

    private writeFiles(MarkupBuilder mkp, List fixes) {
        fixes.each {fix ->
            def date = formatDate(fix.date)
            mkp.fix(file: fix.file, line: fix.lineNum, story: fix.story, state: fix.state, date: date, fix.message)
        }
    }

    private String now() {
        def now = new Date()
        def df = new SimpleDateFormat("yyyy-MM-dd HH:mm")
        return df.format(now)
    }

    private String formatDate(date) {
        def df = new SimpleDateFormat("yyyy-MM-dd")
        return df.format(date)
    }
}