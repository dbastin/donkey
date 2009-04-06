package sweeper

import java.text.DateFormat
import java.text.SimpleDateFormat


final class Paleontologist implements LineProcessor {
    private final String pattern = /.*[F]IX \(([A-Za-z0-9].*)\) (.*[0-9]+) (.*)/
    private final DateFormat format = new SimpleDateFormat("MMM d, yyyy")
    private final Calendar oldCutOff = Calendar.getInstance()
    private final Calendar expiredCutOff = Calendar.getInstance()
    private final Calendar fixTime = Calendar.getInstance()

    Paleontologist(int oldDaysAgo, int expiredDaysAgo) {
        oldCutOff.add(Calendar.DAY_OF_YEAR, -oldDaysAgo)
        expiredCutOff.add(Calendar.DAY_OF_YEAR, -expiredDaysAgo)
    }

    boolean checkLine(String line) {
        def matcher = (line =~ pattern)
        return matcher.matches()
    }

    Fix getFix(File file, int lineNum, String ln) {
        def matcher = (ln =~ pattern)
        def result = matcher[0]
        String dateString = result[1]
        String story = result[2]
        String message = result[3].replace('-->', '')
        Date date = format.parse(dateString)
        String state = getState(date)
        def fix = new Fix(date: date, file: file, lineNum: lineNum, story: story, message: message, state: state)
    }

    private String getState(Date date) {
        fixTime.setTime(date)
        if (expiredCutOff.after(fixTime)) return "expired"
        if (oldCutOff.after(fixTime)) return "old"
        return "new"
    }
}
