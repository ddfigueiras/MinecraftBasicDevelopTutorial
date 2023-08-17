package plugin1.plugin1.handler;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import plugin1.plugin1.Test1;
import plugin1.plugin1.util.DelayedTaks;

public class PlayerHandler implements Listener {
    public PlayerHandler(Test1 plugin)
    {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();
        ItemStack item = new ItemStack(Material.DIAMOND_PICKAXE, 10);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Picareta dos deuses");
        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        inv.addItem(item);
        inv.setItem(8, item);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event)
    {
        if (!(event.getEntity() instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL))
        {
            return;
        }
        Player player = (Player) event.getEntity();
        DelayedTaks task = new  DelayedTaks(() ->
        {
            player.getInventory().addItem(new ItemStack(Material.DIAMOND));
        }, 20 * 5);

//        Bukkit.getScheduler().cancelTask(task.getId());
    }
}
