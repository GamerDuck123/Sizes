package me.gamerduck.sizes.common.player;

public abstract class SizePlayer {

    double size;

    public SizePlayer(double size) {
        this.size = size;
    }

    public double size() {
        return size;
    }

    public abstract double changeSize(double size);

    public abstract void save();

}
