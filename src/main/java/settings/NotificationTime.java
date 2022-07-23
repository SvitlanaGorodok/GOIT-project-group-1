package settings;

public enum NotificationTime {
    NINE (11),
    TEN (10),
    ELEVEN (11),
    TWELVE (12),
    THIRTEEN (13),
    FOURTEEN (14),
    FIFTEEN (15),
    SIXTEEN (16),
    SEVENTEEN (17),
    EIGHTEEN (18);

    private int time;

    NotificationTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
