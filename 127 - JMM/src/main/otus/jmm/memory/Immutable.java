package main.otus.jmm.memory;

public class Immutable {
    private final int x; //effectively final

    public Immutable(int x){
        this.x = x; // im immutable and dont need volatile
    }

    public Immutable setX(int x){
        return new Immutable(x);
    }

}
