package me.gamerduck.sizes.common.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

//level = 1
//change = 1
@ConfigSerializable
public class PotionDefinition {

    @Setting("level")
    private int level;

    @Setting("multiplier")
    private double multiplier;

    public PotionDefinition() {}

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }
}
