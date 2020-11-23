package si.f5.mirage.misc;

import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public class LinkManager {

    static Map<String, String> linkCodeMap = new HashMap<>();

    public static Map<String, String> getLinkCodeMap() {

        return linkCodeMap;
    }

    public static void generate(Player player, Integer length) {

        String uuid = player.getUniqueId().toString();
        String code = RandomStringUtils.randomAlphanumeric(length);

        if (linkCodeMap.containsKey(uuid))
            return;

        linkCodeMap.put(uuid, code);
    }

    public static void set(Player player, String newCode) {

        if (player == null || newCode == null)
            return;

        String uuid = player.getUniqueId().toString();

        if (linkCodeMap.containsKey(uuid)) {

            linkCodeMap.replace(uuid, newCode);
            return;
        }

        linkCodeMap.put(uuid, newCode);
    }
}