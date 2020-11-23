package si.f5.mirage.elements.expressions.link;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.iblitzkriegi.vixio.Vixio;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import si.f5.mirage.elements.effects.link.EffLink;

public class ExprLastLinkMCAccount extends SimpleExpression<Player> {

    static {

        Vixio.getInstance().registerExpression(ExprLastLinkMCAccount.class, Player.class, ExpressionType.SIMPLE, "[the] last link[ed] (mc|minecraft) account")
                .setName("Last Linked Error")
                .setDesc("Get the last linked error");
    }

    @Override
    protected Player[] get(Event event) {

        return new Player[]{EffLink.getLastLinkMCAccount()};
    }

    @Override
    public boolean isSingle() {

        return true;
    }

    @Override
    public Class<? extends Player> getReturnType() {

        return Player.class;
    }

    @Override
    public String toString(Event event, boolean b) {

        return "the last linked minecraft account";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {

        return true;
    }
}