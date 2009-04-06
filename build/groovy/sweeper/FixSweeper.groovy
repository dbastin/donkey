package sweeper
public final class FixSweeper {
    private final int jurassicDaysAgo
    private final int stoneAgeDaysAgo
    private final Paleontologist samNeill

    public FixSweeper(int jurassicDaysAgo, int stoneAgeDaysAgo) {
        this.jurassicDaysAgo = jurassicDaysAgo
        this.stoneAgeDaysAgo = stoneAgeDaysAgo
        samNeill = new Paleontologist(stoneAgeDaysAgo, jurassicDaysAgo)
    }

    public boolean sweep(projectName, srcFiles, outputFile) {
        List fixes = examineFiles(srcFiles, samNeill)
        publishDiscoveries(projectName, outputFile, fixes)
        return !fixes.any {it.expired}
    }

    private List examineFiles(srcFiles, paleontologist) {
        def filer = new FileContentProcessor()
        return filer.processFiles(srcFiles, paleontologist);
    }

    private void publishDiscoveries(projectName, outputFile, fixes) {
        XmlFixReport report =
        new XmlFixReport(projectName, fixes, jurassicDaysAgo, stoneAgeDaysAgo)
        outputFile.withWriter {writer ->
            report.write(writer)
        }
    }
}