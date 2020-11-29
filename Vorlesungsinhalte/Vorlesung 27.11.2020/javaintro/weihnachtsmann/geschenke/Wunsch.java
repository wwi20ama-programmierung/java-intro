package javaintro.weihnachtsmann.geschenke;

import javaintro.weihnachtsmann.lebewesen.Kind;

public class Wunsch {
    private String name;
    private String art;
    private Kind kind;

    public Wunsch(String name, String art, Kind kind) {
        this.name = name;
        this.art = art;
        this.kind = kind;
    }

    public Kind getKind() {
        return this.kind;
    }

    public String getArt() {
        return this.art;
    }
}