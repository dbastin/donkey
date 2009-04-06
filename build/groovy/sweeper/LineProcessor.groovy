package sweeper

interface LineProcessor {
    boolean checkLine(String line)

    Fix getFix(File file, int lineNum, String line)
}
