package si.f5.mirage.elements.effects.link;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.iblitzkriegi.vixio.Vixio;
import net.dv8tion.jda.api.entities.User;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import si.f5.mirage.misc.LinkManager;

import java.util.UUID;

public class EffLink extends Effect {

    static String linkError = null;
    static Player lastLinkedMinecraftAccount = null;
    static User lastLinkedDiscordAccount = null;
    Expression<User> user;
    Expression<String> code;

    static {

        Vixio.getInstance().registerEffect(EffLink.class, "[discord[ ]]link %user% with [the] code %string%")
                .setName("Discord Link")
                .setDesc("Link between Discord and Minecraft using secret code");
    }

    @Override
    protected void execute(Event event) {

        linkError = null;
        User user = this.user.getSingle(event);
        String code = this.code.getSingle(event);
        String uuid = null;

        if (user == null || code == null) {

            linkError = "Invalid Code";
            return;
        }

        if (!LinkManager.getLinkCodeMap().containsValue(code)) {

            linkError = "Invalid Code";
            return;
        }

        for (String key : LinkManager.getLinkCodeMap().keySet()) {

            if (LinkManager.getLinkCodeMap().get(key).equals(code)) {

                uuid = key;
                break;
            }
        }
        
        lastLinkedMinecraftAccount = Bukkit.getPlayer(UUID.fromString(uuid));
        lastLinkedDiscordAccount = user;
        LinkManager.getLinkCodeMap().remove(uuid);
    }

    @Override
    public String toString(Event event, boolean b) {

        return "discord link %user% with the code %string%";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {

        this.user = (Expression<User>) expressions[0];
        this.code = (Expression<String>) expressions[1];

        return true;
    }

    public static String getLastLinkError() {

        return linkError;
    }

    public static Player getLastLinkMCAccount() {

        return lastLinkedMinecraftAccount;
    }

    public static User getLastLinkedDiscordAccount() {

        return lastLinkedDiscordAccount;
    }
}