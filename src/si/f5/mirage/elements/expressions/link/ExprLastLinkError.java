package si.f5.mirage.elements.expressions.link;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.iblitzkriegi.vixio.Vixio;
import org.bukkit.event.Event;
import si.f5.mirage.elements.effects.link.EffLink;

public class ExprLastLinkError extends SimpleExpression<String> {

    static {

        Vixio.getInstance().registerExpression(ExprLastLinkError.class, String.class, ExpressionType.SIMPLE, "[the] last link[ed] error")
                .setName("Last Linked Error")
                .setDesc("Get the last linked error");
    }

    @Override
    protected String[] get(Event event) {

        return new String[]{EffLink.getLastLinkError()};
    }

    @Override
    public boolean isSingle() {

        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {

        return String.class;
    }

    @Override
    public String toString(Event event, boolean b) {

        return "the last linked error";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {

        return true;
    }
}