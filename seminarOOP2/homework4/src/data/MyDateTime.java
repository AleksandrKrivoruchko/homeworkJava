package data;

import java.time.LocalDateTime;

public class MyDateTime {
    private String date;
    private String time;

    public MyDateTime(String date, String time) {
        this.date = date;
        this.time = time;
    }

    public MyDateTime(LocalDateTime dt) {
        this.date = formatTime(dt.getDayOfMonth()) + "."
                + formatTime(dt.getMonthValue()) + "."
                + dt.getYear();
        this.time = formatTime(dt.getHour()) + ":"
                + formatTime(dt.getMinute());
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    private String formatTime(int t) {
        String tmp = Integer.toString(t);
        return tmp.length() > 1 ? tmp : "0" + tmp;
    }

    public LocalDateTime getLocalDateTime() {
        String[] tmpDate = date.split(".");
        String[] tmpTime = time.split(":");
        return LocalDateTime.of(Integer.getInteger(tmpDate[0]),
                Integer.getInteger(tmpDate[1]),
                Integer.getInteger(tmpDate[2]),
                Integer.getInteger(tmpTime[0]),
                Integer.getInteger(tmpTime[1]));
    }
}
