package me.gamerduck.sizes.common.config;

import ninja.leaping.configurate.objectmapping.Setting;
import ninja.leaping.configurate.objectmapping.serialize.ConfigSerializable;

@ConfigSerializable
public class ConfigDefinition {

    @Setting("player-data")
    private PlayerDataDefinition playerDataOptions;

    public ConfigDefinition() {}

    public PlayerDataDefinition getPlayerDataOptions() {
        return playerDataOptions;
    }

    public void setPlayerDataOptions(PlayerDataDefinition playerDataOptions) {
        this.playerDataOptions = playerDataOptions;
    }

    @ConfigSerializable
    public static class PlayerDataDefinition {
        @Setting("storage-type")
        private String storageType;

        @Setting("mysql")
        private MySQLDefinition mysql;

        public PlayerDataDefinition() {}

        public String getStorageType() {
            return storageType;
        }

        public void setStorageType(String storagetype) {
            this.storageType = storagetype;
        }

        public MySQLDefinition getMysql() {
            return mysql;
        }

        public void setMysql(MySQLDefinition mysql) {
            this.mysql = mysql;
        }
    }

    @ConfigSerializable
    public static class MySQLDefinition {
        @Setting("host")
        private String host;

        @Setting("port")
        private int port;

        @Setting("database")
        private String database;

        @Setting("username")
        private String username;

        @Setting("password")
        private String password;

        @Setting("use-ssl")
        private boolean useSSL;

        public MySQLDefinition() {}

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public int getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isUseSSL() {
            return useSSL;
        }

        public void setUseSSL(boolean useSSL) {
            this.useSSL = useSSL;
        }
    }

}
