package si.f5.mirage.elements.expressions.link;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import me.iblitzkriegi.vixio.Vixio;
import net.dv8tion.jda.api.entities.User;
import org.bukkit.event.Event;
import si.f5.mirage.elements.effects.link.EffLink;

public class ExprLastLinkDiscordAccount extends SimpleExpression<User> {

    static {

        Vixio.getInstance().registerExpression(ExprLastLinkDiscordAccount.class, User.class, ExpressionType.SIMPLE, "[the] last link[ed] discord account")
                .setName("Last Linked Error")
                .setDesc("Get the last linked error");
    }

    @Override
    protected User[] get(Event event) {

        return new User[]{EffLink.getLastLinkedDiscordAccount()};
    }

    @Override
    public boolean isSingle() {

        return true;
    }

    @Override
    public Class<? extends User> getReturnType() {

        return User.class;
    }

    @Override
    public String toString(Event event, boolean b) {

        return "the last linked discord account";
    }

    @Override
    public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {

        return true;
    }
}