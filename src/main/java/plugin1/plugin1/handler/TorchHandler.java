package plugin1.plugin1.handler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import plugin1.plugin1.Test1;

public class TorchHandler implements Listener {
    public TorchHandler(Test1 plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void OnTorchPlace_low(BlockPlaceEvent event) {
        if(!event.getPlayer().hasPermission("teste.teste1")) {
            if(event.getBlock().getType() == Material.TORCH) {
                event.setCancelled(true);
            }
        }
    }


//    @EventHandler(ignoreCancelled = true)
//    public void onTorchPlace(BlockPlaceEvent event) {
//
//
//        Block block = event.getBlock();
//
//        if (block.getType() != Material.TORCH) {
//            return;
//        }
//
//        Bukkit.getLogger().info("Foi colocada uma tocha");
//    }
}
