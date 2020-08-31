package domain.model.map;

import javafx.util.Pair;
import lombok.Builder;
import lombok.Getter;

@Builder
public class Lawn {
    @Getter
    private final Pair<Integer, Integer> superiorCorner;

    public Boolean isOnRightLimit(Integer x){
        return x < superiorCorner.getKey();
    }

    public Boolean isOnTopLimit(Integer y){
        return y < superiorCorner.getValue();
    }
}
