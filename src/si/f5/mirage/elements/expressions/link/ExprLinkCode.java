package si.f5.mirage.elements.expressions.link;

import ch.njol.skript.classes.Changer;
import ch.njol.skript.expressions.base.SimplePropertyExpression;
import ch.njol.util.coll.CollectionUtils;
import me.iblitzkriegi.vixio.Vixio;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import si.f5.mirage.misc.LinkManager;

public class ExprLinkCode extends SimplePropertyExpression<Player, String> {

    static {

        Vixio.getInstance().registerPropertyExpression(ExprLinkCode.class, String.class, "discord link code", "player")
                .setName("Discord link code of player")
                .setDesc("Generate/Edit Discord link code of player");
    }

    @Override
    protected String getPropertyName() {

        return "discord link code";
    }

    @Override
    public String convert(Player player) {

        String uuid = player.getUniqueId().toString();

        if (LinkManager.getLinkCodeMap().containsKey(uuid))
            return LinkManager.getLinkCodeMap().get(uuid);

        return null;
    }

    @Override
    public Class<? extends String> getReturnType() {

        return String.class;
    }

    @Override
    public Class<?>[] acceptChange(final Changer.ChangeMode mode) {

        if (mode == Changer.ChangeMode.SET || mode == Changer.ChangeMode.DELETE || mode == Changer.ChangeMode.RESET)
            return CollectionUtils.array(String.class);

        return null;
    }

    @Override
    public void change(Event event, Object[] delta, Changer.ChangeMode mode){

        Player player = getExpr().getSingle(event);
        if (player == null)
            return;

        String changeTo = null;
        if (delta != null)
            changeTo = (String) delta[0];

        switch (mode) {

            case SET:
                LinkManager.set(player, changeTo);
                break;
            case DELETE:
                LinkManager.getLinkCodeMap().remove(player.getUniqueId().toString());
                break;
        }
    }
}