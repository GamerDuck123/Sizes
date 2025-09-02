package me.gamerduck.sizes.common.test;

import me.gamerduck.sizes.common.Potions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PotionsTests {
    private static Potions potions;

    @BeforeAll
    static void setUp() {
        potions = new Potions(Paths.get("src/test/resources/potions.conf"));
    }

    @Test
    void testLoadGrowthPotionsFromConfig() {
        Map<Integer, Double> growthPotions = potions.getGrowthPotions();

        assertFalse(growthPotions.isEmpty(), "Growth potions should not be empty");

        assertTrue(growthPotions.containsKey(1), "Expected potion 1 in growth potions");
        assertTrue(growthPotions.containsKey(2), "Expected potion 2 in growth potions");

        Double multiplier = growthPotions.get(1);
        assertNotNull(multiplier, "Multiplier for 1 should not be null");
        assertEquals(1, multiplier);
    }

    @Test
    void testLoadShrinkPotionsFromConfig() {
        Map<Integer, Double> shrinkPotions = potions.getShrinkPotions();

        assertFalse(shrinkPotions.isEmpty(), "Shrink potions should not be empty");

        assertTrue(shrinkPotions.containsKey(1), "Expected potion 1 in shrink potions");
        assertTrue(shrinkPotions.containsKey(2), "Expected potion 2 in shrink potions");

        Double multiplier = shrinkPotions.get(1);
        assertNotNull(multiplier, "Multiplier for 1 should not be null");
        assertEquals(1, multiplier);
    }
}