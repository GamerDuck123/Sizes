package me.gamerduck.sizes.common.test;

import me.gamerduck.sizes.common.SizePool;
import me.gamerduck.sizes.common.records.SizeSettings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SizePoolTest {
    private static SizePool pool;

    @BeforeAll
    static void setUp() {
        pool = new SizePool(Paths.get("src/test/resources/size-pool.conf"));
    }

    @Test
    void testLoadSizePoolFromConfig() {
        Map<Double, SizeSettings> sizePool = pool.getSizePool();

        assertFalse(sizePool.isEmpty(), "Size pool should not be empty");

        assertTrue(sizePool.containsKey(0.5), "Expected size 0.5 in size pool");
        assertTrue(sizePool.containsKey(1.0), "Expected size 1.0 in size pool");

        SizeSettings settings = sizePool.get(1.0);
        assertNotNull(settings, "SizeSettings for 1.0 should not be null");
        assertEquals(1.0, settings.size());
        assertEquals(0.5, settings.chanceOnJoin());
        assertEquals(0.1, settings.reachMultiplier());
        assertEquals(0.5, settings.strengthMultiplier());
        assertEquals(2.0, settings.speedMultiplier());
    }
}