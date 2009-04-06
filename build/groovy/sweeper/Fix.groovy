package sweeper

class Fix {
    Date date
    File file
    int lineNum
    String story
    String message
    String state

    boolean isExpired() {
        return 'expired' == state;
    }
}