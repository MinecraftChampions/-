package org.example;

public enum Type {
    Red("255 0 0"),
    Blue("0 0 255"),
    Yellow("255 255 0"),
    Green("0 255 0"),
    Gray("207 207 207"),
    Black("0 0 0"),
    Purple("160 32 240"),
    LtGoldenrodYellow("250 250 210"),
    Gold("139 117 0"),
    Orange("255 165 0"),
    Pink("255 20 147");
    final String type;
    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
