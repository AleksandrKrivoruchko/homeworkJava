package homework;

public enum Gender {
    MALE("Мужской"), FEMALE("Женский");
    private String title;
    private Gender(String s) {
        title = s;
    }

    public String getTitle() {
        return title;
    }
}
