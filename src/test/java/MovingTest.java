import domain.model.Movement;
import domain.model.map.Direction;
import domain.model.map.Lawn;
import domain.model.map.Position;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovingTest {
    private final Lawn lawn = Lawn.builder().superiorCorner(new Pair<>(2, 2)).build();

    @Test
    public void moveToNorth() {

        Position position = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(0)
                .build();

        position.updateDirection(Movement.A, lawn);

        Position expectedPosition = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(1)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void moveToSouth() {
        Position position = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(1)
                .build();

        position.updateDirection(Movement.A, lawn);

        Position expectedPosition = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void moveToEst() {
        Position position = Position.builder()
                .direction(Direction.E)
                .x(0)
                .y(0)
                .build();

        position.updateDirection(Movement.A, lawn);

        Position expectedPosition = Position.builder()
                .direction(Direction.E)
                .x(1)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void moveToWest() {
        Position position = Position.builder()
                .direction(Direction.W)
                .x(1)
                .y(0)
                .build();

        position.updateDirection(Movement.A, lawn);

        Position expectedPosition = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void cornerLimits() {
        Position position = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();

        position.updateDirection(Movement.A, lawn);

        Position expectedPosition = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);

        position = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();

        position.updateDirection(Movement.A, lawn);

        expectedPosition = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();

        position = Position.builder()
                .direction(Direction.E)
                .x(2)
                .y(0)
                .build();

        position.updateDirection(Movement.A, lawn);

        expectedPosition = Position.builder()
                .direction(Direction.E)
                .x(2)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);

        position = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(2)
                .build();

        position.updateDirection(Movement.A, lawn);

        expectedPosition = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(2)
                .build();
        assertEquals(expectedPosition, position);
    }
}
