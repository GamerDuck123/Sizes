package me.gamerduck.sizes.common.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

//chance = 1.0
//reach = 1.0
//strength = 0.5
//speed = 2.0
@ConfigSerializable
public class SizeDefinition {

    @Setting("size")
    private double size;

    @Setting("chance")
    private double chance;

    @Setting("reach")
    private double reach = 1;

    @Setting("strength")
    private double strength;

    @Setting("speed")
    private double speed;


    public SizeDefinition() {}

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public double getReach() {
        return reach;
    }

    public void setReach(double reach) {
        this.reach = reach;
    }

    public double getStrength() {
        return strength;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}
