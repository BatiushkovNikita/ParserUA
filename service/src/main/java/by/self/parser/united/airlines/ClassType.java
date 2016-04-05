package by.self.parser.united.airlines;

public enum ClassType {
    E,
    B_SAVER,
    B_FULL,
    F_SAVER,
    F_FULL;

    public String getToString() {
        return this.toString().substring(0, 1);
    }

    public String getAwardType() {
        return this.toString().substring(2);
    }
}
