package si.f5.mirage.elements.effects.link;

import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;
import me.iblitzkriegi.vixio.Vixio;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import si.f5.mirage.misc.LinkManager;

public class EffGenerateLinkCode extends Effect {

    static {

        Vixio.getInstance().registerEffect(EffGenerateLinkCode.class, "generate [[discord] link] code of %player% with length %integer%")
                .setName("Generate Discord Link Code")
                .setDesc("Generate link code between Discord and Minecraft for player");
    }

    private Expression<Player> player;
    private Expression<Integer> length;

    @Override
    protected void execute(Event event) {

        if (this.player == null || this.length == null)
            return;

        Player player = this.player.getSingle(event);
        Integer length = this.length.getSingle(event);

        LinkManager.generate(player, length);
    }

    @Override
    public String toString(Event event, boolean b) {

        return "generate discord link code of %player% with length %integer%";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {

        this.player = (Expression<Player>) expressions[0];
        this.length = (Expression<Integer>) expressions[1];

        return true;
    }
}