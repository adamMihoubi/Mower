package domain.model;

import domain.model.map.Lawn;
import domain.model.map.Position;
import lombok.Builder;

import java.util.List;

@Builder
public class Mower {

    private final Position position;
    private List<Movement> movements;

    void move(Lawn lawn) {
        movements.forEach(movement -> position.updateDirection(movement, lawn));
    }

    @Override
    public String toString() {
        return position.toString();
    }
}
