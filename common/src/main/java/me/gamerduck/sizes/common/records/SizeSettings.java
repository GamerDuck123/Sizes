package me.gamerduck.sizes.common.records;

import me.gamerduck.sizes.common.config.SizeDefinition;

public class SizeSettings {

    double size;
    double chanceOnJoin;
    double reachMultiplier;
    double strengthMultiplier;
    double speedMultiplier;

    public SizeSettings(double size, double chanceOnJoin, double reachMultiplier, double strengthMultiplier, double speedMultiplier ) {
        this.size = size;
        this.chanceOnJoin = chanceOnJoin;
        this.reachMultiplier = reachMultiplier;
        this.strengthMultiplier = strengthMultiplier;
        this.speedMultiplier = speedMultiplier;
    }

    public static SizeSettings fromDefinition(SizeDefinition definition) {
        Builder builder = new Builder();
        builder.setSize(definition.getSize());
        builder.setChanceOnJoin(definition.getChance());
        builder.setReachMultiplier(definition.getReach());
        builder.setStrengthMultiplier(definition.getStrength());
        builder.setSpeedMultiplier(definition.getSpeed());
        return builder.build();
    }

    public double getSize() {
        return size;
    }

    public double getChanceOnJoin() {
        return chanceOnJoin;
    }

    public double getReachMultiplier() {
        return reachMultiplier;
    }

    public double getStrengthMultiplier() {
        return strengthMultiplier;
    }

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    private static class Builder {
        private double size;
        private double chanceOnJoin;
        private double reachMultiplier;
        private double strengthMultiplier;
        private double speedMultiplier;

        public double getSize() {
            return size;
        }

        public Builder setSize(double size) {
            this.size = size;
            return this;
        }

        public double getChanceOnJoin() {
            return chanceOnJoin;
        }

        public Builder setChanceOnJoin(double chanceOnJoin) {
            this.chanceOnJoin = chanceOnJoin;
            return this;
        }

        public double getReachMultiplier() {
            return reachMultiplier;
        }

        public Builder setReachMultiplier(double reachMultiplier) {
            this.reachMultiplier = reachMultiplier;
            return this;
        }

        public double getStrengthMultiplier() {
            return strengthMultiplier;
        }

        public Builder setStrengthMultiplier(double strengthMultiplier) {
            this.strengthMultiplier = strengthMultiplier;
            return this;
        }

        public double getSpeedMultiplier() {
            return speedMultiplier;
        }

        public Builder setSpeedMultiplier(double speedMultiplier) {
            this.speedMultiplier = speedMultiplier;
            return this;
        }

        public SizeSettings build() {
            return new SizeSettings(size, chanceOnJoin, reachMultiplier, strengthMultiplier, speedMultiplier);
        }
    }



}
