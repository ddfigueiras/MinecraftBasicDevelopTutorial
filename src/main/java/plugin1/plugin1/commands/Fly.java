package plugin1.plugin1.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Só é valido para jogadores.");
            return true;
        }

        Player player = (Player) sender;

        if(player.getAllowFlight())
        {
            player.setAllowFlight(false);
            player.sendMessage("O fly foi desátivado");
        }
        else
        {
            player.setAllowFlight(true);
            player.sendMessage("O fly foi ativado.");
        }

        return true;
    }
}
