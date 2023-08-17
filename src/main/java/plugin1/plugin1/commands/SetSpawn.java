package plugin1.plugin1.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin1.plugin1.util.SpawnUtil;

public class SetSpawn implements CommandExecutor {
    private SpawnUtil spawnUtil;

    public SetSpawn(SpawnUtil spawnUtil)
    {
        this.spawnUtil = spawnUtil;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args)
    {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Só é valido para jogadores.");
            return true;
        }

        Player player = (Player) sender;
        spawnUtil.set(player.getLocation());

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aO spawn foi setado!"));

        return true;
    }
}
