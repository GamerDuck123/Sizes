package me.gamerduck.sizes.common.test;

import me.gamerduck.sizes.common.Config;
import me.gamerduck.sizes.common.config.ConfigDefinition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ConfigLoadingTest {
    private static Config config;

    @BeforeAll
    static void setUp() {
        config = new Config(Paths.get("src/test/resources/config.conf"));
    }

    @Test
    void testLoadTheConfig() {
        ConfigDefinition def = config.getConfigDefinition();

        assertNotNull(def, "Config definition should not be null");

        ConfigDefinition.PlayerDataDefinition playerDataOptions = def.getPlayerDataOptions();
        assertNotNull(playerDataOptions, "def.getPlayerDataOptions() should not be null");

        assertTrue(playerDataOptions.getStorageType().equalsIgnoreCase("mysql"), "Expected storage type to be mysql");

        ConfigDefinition.MySQLDefinition mysqlOptions = playerDataOptions.getMysql();
        assertNotNull(playerDataOptions, "playerDataOptions.getMysql() should not be null");

        assertTrue(mysqlOptions.getHost().equalsIgnoreCase("localhost"), "Expected host to be localhost");
        assertEquals(3306, mysqlOptions.getPort(), "Expected port to be 3306");
        assertTrue(mysqlOptions.getDatabase().equalsIgnoreCase("minecraft"), "Expected database to be minecraft");
        assertTrue(mysqlOptions.getUsername().equalsIgnoreCase("user"), "Expected username to be user");
        assertTrue(mysqlOptions.getPassword().equalsIgnoreCase("password"), "Expected password to be password");
        assertFalse(mysqlOptions.isUseSSL(), "Expected SSL connection to be false");

    }
}