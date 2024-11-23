package oncall.domain.date;

public enum DayOfWeek {
    MONDAY("월"),
    TUESDAY("화"),
    WEDNESDAY("수"),
    THURSDAY("목"),
    FRIDAY("금"),
    SATURDAY("토"),
    SUNDAY("일");

    private final String label;

    DayOfWeek(String label) {
        this.label = label;
    }

    public String getName() {
        return label;
    }

    public static DayOfWeek fromName(String koreanName) {
        for (DayOfWeek day : DayOfWeek.values()) {
            if (day.getName().equals(koreanName)) {
                return day;
            }
        }
        throw new IllegalArgumentException("Invalid day: " + koreanName);
    }

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }

    public DayOfWeek nextDay() {
        return values()[(this.ordinal() + 1) % values().length];
    }
}
