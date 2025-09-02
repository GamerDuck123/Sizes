package me.gamerduck.sizes.common;

import me.gamerduck.sizes.common.config.SizeDefinition;
import me.gamerduck.sizes.common.records.SizeSettings;
import ninja.leaping.configurate.ConfigurationNode;
import ninja.leaping.configurate.hocon.HoconConfigurationLoader;
import ninja.leaping.configurate.objectmapping.DefaultObjectMapperFactory;
import ninja.leaping.configurate.objectmapping.ObjectMapper;
import ninja.leaping.configurate.objectmapping.ObjectMapperFactory;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;
import ninja.leaping.configurate.objectmapping.serialize.TypeSerializerCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class SizePool {

    private final Path SIZE_POOL_CONFIG;
    private final HashMap<Double, SizeSettings> sizePool = new HashMap<>();

    public SizePool(Path configFilePath) {
        SIZE_POOL_CONFIG = configFilePath;
        loadSizes();
    }

    public HashMap<Double, SizeSettings> getSizePool() {
        return sizePool;
    }

    public void addSize(SizeSettings settings) {
        sizePool.put(settings.getSize(), settings);
    }

    public void reloadSizes() {
        sizePool.clear();
        loadSizes();
    }

    public void loadSizes() {
        if (Files.notExists(SIZE_POOL_CONFIG)) {
            try {
                Files.createFile(SIZE_POOL_CONFIG);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
                .setPath(SIZE_POOL_CONFIG)
                .build();

        try {
            ConfigurationNode root = loader.load();
            ObjectMapperFactory factory = new DefaultObjectMapperFactory();
            ObjectMapper<SizeDefinition> mapper = factory.getMapper(SizeDefinition.class);

            List<? extends ConfigurationNode> sizeNodes = root.getNode("sizes").getChildrenList();

            for (ConfigurationNode sizeNode : sizeNodes) {
                SizeDefinition definition = mapper.bindToNew().populate(sizeNode);
                addSize(SizeSettings.fromDefinition(definition));
            }
        } catch (IOException | ObjectMappingException e) {
            e.printStackTrace();
        }
    }

}
