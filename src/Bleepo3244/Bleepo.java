package Bleepo3244;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Bleepo extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        saveConfig();
        getLogger().info("AnarchySay by Bleepo has been loaded and enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("AnarchySay by Bleepo has been unloaded and disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equals("say")) {
            Player player = (Player) sender;
            if (player.hasPermission("server.say")) {
                String prefix = getConfig().getString("prefix");
                StringBuilder str = new StringBuilder();
                for (int i = 0; i < args.length; i++) {
                    str.append(args[i] + " ");
                }
                String msg = str.toString();
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', prefix.replace("{message}", msg)));
            } else {
                player.sendMessage(ChatColor.DARK_RED + "You do not have permission todo that!");
            }
        }
        return true;
    }
}
