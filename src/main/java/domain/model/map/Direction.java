package domain.model.map;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@AllArgsConstructor
public enum Direction {
    N(FALSE, 1, "W", "E"),
    S(FALSE, -1, "E", "W"),
    E(TRUE, 1, "N", "S"),
    W(TRUE, -1, "S", "N");

    private final Boolean onX;
    @Getter
    private final Integer value;
    @Getter
    private final String LeftDirection;
    @Getter
    private final String rightDirection;

    public Boolean isOnX() {
        return onX;
    }


}
