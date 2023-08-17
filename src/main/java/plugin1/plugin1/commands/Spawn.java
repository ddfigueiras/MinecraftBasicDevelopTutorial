package plugin1.plugin1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import plugin1.plugin1.util.SpawnUtil;

public class Spawn implements CommandExecutor {
    private SpawnUtil spawnUtil;

    public Spawn(SpawnUtil spawnUtil)
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
        spawnUtil.teleport(player);

        return true;
    }
}
