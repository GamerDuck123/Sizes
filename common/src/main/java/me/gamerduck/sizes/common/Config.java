package me.gamerduck.sizes.common;

import me.gamerduck.sizes.common.config.ConfigDefinition;
import me.gamerduck.sizes.common.config.SizeDefinition;
import me.gamerduck.sizes.common.records.SizeSettings;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.objectmapping.DefaultObjectMapperFactory;
import ninja.leaping.configurate.objectmapping.ObjectMapper;
import ninja.leaping.configurate.objectmapping.ObjectMapperFactory;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

public class Config {

    private final Path CONFIG_PATH;
    private ConfigDefinition configDefinition;

    public Config(Path configFilePath) {
        CONFIG_PATH = configFilePath;
        loadConfig();
    }

    public ConfigDefinition getConfigDefinition() {
        return configDefinition;
    }

    public void reloadConfig() {
        loadConfig();
    }

    public void loadConfig() {
        if (Files.notExists(CONFIG_PATH)) {
            try {
                Files.createFile(CONFIG_PATH);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
                .setPath(CONFIG_PATH)
                .build();

        try {
            ConfigurationNode root = loader.load();
            ObjectMapperFactory factory = new DefaultObjectMapperFactory();
            ObjectMapper<ConfigDefinition> mapper = factory.getMapper(ConfigDefinition.class);
            configDefinition = mapper.bindToNew().populate(root);
        } catch (IOException | ObjectMappingException e) {
            e.printStackTrace();
        }
    }

}
