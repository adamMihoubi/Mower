package domain.model.map;

import domain.model.Movement;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class Position {
    private static final String SPACE = " ";
    private Integer x;
    private Integer y;
    private Direction direction;

    private void move(Lawn lawn) {
        if (direction.isOnX())
            updateX(direction, lawn);
        else
            updateY(direction, lawn);
    }

    public void updateDirection(Movement movement, Lawn lawn) {
        switch (movement) {
            case A:
                move(lawn);
                break;
            case D:
                direction = Direction.valueOf(direction.getRightDirection());
                break;
            case G:
                direction = Direction.valueOf(direction.getLeftDirection());
                break;
        }
    }

    private void updateX(Direction direction, Lawn lawn) {
        x = lawn.isOnRightLimit(x) ? updateCoordinate(x, direction) : x;
    }

    private void updateY(Direction direction, Lawn lawn) {
        y = lawn.isOnTopLimit(y) ? updateCoordinate(y, direction) : y;
    }

    private Integer updateCoordinate(Integer coordinate, Direction direction) {
        int newCoordinate = coordinate + direction.getValue();
        if (newCoordinate >= 0) return newCoordinate;
        return coordinate;
    }

    @Override
    public String toString() {
        return String.join(SPACE, x.toString(), y.toString(), direction.name());
    }
}
