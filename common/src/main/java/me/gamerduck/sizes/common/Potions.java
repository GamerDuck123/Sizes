package me.gamerduck.sizes.common;

import me.gamerduck.sizes.common.config.PotionDefinition;
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

public class Potions {

    private final Path POTIONS_CONFIG;
    private final HashMap<Integer, Double> growthPotions = new HashMap<>();
    private final HashMap<Integer, Double> shrinkPotions = new HashMap<>();

    public Potions(Path configFilePath) {
        POTIONS_CONFIG = configFilePath;
        loadPotions();
    }

    public HashMap<Integer, Double> getGrowthPotions() {
        return growthPotions;
    }

    public HashMap<Integer, Double> getShrinkPotions() {
        return shrinkPotions;
    }

    public void addGrowthPotion(PotionDefinition settings) {
        growthPotions.put(settings.getLevel(), settings.getMultiplier());
    }

    public void addShrinkPotion(PotionDefinition settings) {
        shrinkPotions.put(settings.getLevel(), settings.getMultiplier());
    }

    public void reloadPotions() {
        growthPotions.clear();
        shrinkPotions.clear();
        loadPotions();
    }

    public void loadPotions() {
        if (Files.notExists(POTIONS_CONFIG)) {
            try {
                Files.createFile(POTIONS_CONFIG);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        HoconConfigurationLoader loader = HoconConfigurationLoader.builder()
                .setPath(POTIONS_CONFIG)
                .build();

        try {
            ConfigurationNode root = loader.load();
            ObjectMapperFactory factory = new DefaultObjectMapperFactory();
            ObjectMapper<PotionDefinition> mapper = factory.getMapper(PotionDefinition.class);

            List<? extends ConfigurationNode> growthNodes = root.getNode("growth").getChildrenList();

            for (ConfigurationNode growthNode : growthNodes) {
                PotionDefinition definition = mapper.bindToNew().populate(growthNode);
                addGrowthPotion(definition);
            }

            List<? extends ConfigurationNode> shrinkNodes = root.getNode("growth").getChildrenList();

            for (ConfigurationNode shrinkNode : shrinkNodes) {
                PotionDefinition definition = mapper.bindToNew().populate(shrinkNode);
                addShrinkPotion(definition);
            }
        } catch (IOException | ObjectMappingException e) {
            e.printStackTrace();
        }
    }
}