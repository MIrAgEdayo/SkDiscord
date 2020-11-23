package si.f5.mirage;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SkDiscord extends JavaPlugin {

    static SkDiscord instance;
    SkriptAddon addon;
    final String PREFIX = "[SkDiscord]";

    @Override
    public void onEnable() {

        instance = this;
        addon = Skript.registerAddon(this);
        try {

            addon.loadClasses("si.f5.mirage", "elements");
        } catch (IOException ignored) {}

        Bukkit.getLogger().info(getPrefix() + " §bEnabled");
    }

    public static SkDiscord getInstance() {

        return instance;
    }

    public SkriptAddon getAddon() {

        return addon;
    }

    public String getPrefix() {

        return PREFIX;
    }
}