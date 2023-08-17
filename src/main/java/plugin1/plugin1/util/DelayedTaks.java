package plugin1.plugin1.util;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class DelayedTaks implements Listener {
    private static Plugin plugin = null;
    private int id = -1;
    public DelayedTaks(Plugin instance)
    {
        plugin = instance;
    }
    public DelayedTaks(Runnable runnable)
    {
        this(runnable, 0);
    }
    public DelayedTaks(Runnable runnable, long delay)
    {
        if(plugin.isEnabled())
        {
            id = Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, runnable, delay);
        }
        else
        {
            runnable.run();
        }
    }
    public int getId()
    {
        return id;
    }
}
