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
        this.date = dt.toLocalDate().toString();
        this.time = dt.getHour() + ":" + dt.getMinute();
    }

    public LocalDateTime getLocalDateTime() {
        String[] tmpDate = date.split("-");
        String[] tmpTime = time.split(":");
        return LocalDateTime.of(Integer.getInteger(tmpDate[0]),
                Integer.getInteger(tmpDate[1]),
                Integer.getInteger(tmpDate[2]),
                Integer.getInteger(tmpTime[0]),
                Integer.getInteger(tmpTime[1]));
    }
}
