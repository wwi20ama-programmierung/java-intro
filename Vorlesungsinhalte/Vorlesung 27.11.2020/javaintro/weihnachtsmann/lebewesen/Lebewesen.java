package javaintro.weihnachtsmann.lebewesen;

public abstract class Lebewesen {
    protected int energie = 0;
    protected String name;

    public abstract void regenerieren();

    public abstract void bewegen();
}