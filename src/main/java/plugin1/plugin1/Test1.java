package plugin1.plugin1;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import plugin1.plugin1.commands.Fly;
import plugin1.plugin1.commands.Menu;
import plugin1.plugin1.commands.SetSpawn;
import plugin1.plugin1.commands.Spawn;
import plugin1.plugin1.handler.PlayerHandler;
import plugin1.plugin1.handler.TorchHandler;
import plugin1.plugin1.util.ConfigUtil;
import plugin1.plugin1.util.DelayedTaks;
import plugin1.plugin1.util.SpawnUtil;

import java.util.List;
import java.util.Objects;

public final class Test1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Plugin ligado");

        saveDefaultConfig();

        List<String> kitItems = (List<String>) getConfig().getList("kit");

        for(String itemName : kitItems)
        {
            Bukkit.getLogger().info(itemName);
        }

        ConfigUtil config = new ConfigUtil(this, "configs.yml");
        config.getConfig().set("hello", "world");
        config.save();

        SpawnUtil spawnUtil = new SpawnUtil(this);

        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu(this));
        getCommand("spawn").setExecutor(new Spawn(spawnUtil));
        getCommand("setspawn").setExecutor(new SetSpawn(spawnUtil));

        new PlayerHandler(this);
        new TorchHandler(this);
        new DelayedTaks(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Plugin desligado.");
    }
}
