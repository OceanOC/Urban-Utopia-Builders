package com.github.oceanoc.urbanutopiabuilders;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerAttributes {
    public Map<UUID, Integer> money = new HashMap<>();

    public Integer GetMoney(UUID uuid){
        return money.get(uuid);
    }
    public void SetMoney(UUID uuid, Integer val){
        money.put(uuid, val);
    }


}
