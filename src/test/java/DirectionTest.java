import domain.model.Movement;
import domain.model.map.Direction;
import domain.model.map.Lawn;
import domain.model.map.Position;
import javafx.geometry.Pos;
import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DirectionTest {
    private Lawn lawn = Lawn.builder().superiorCorner(new Pair<>(2, 2)).build();

    @Test
    public void testNorthToRight() {
        Position position = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.D, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.E)
                .x(0)
                .y(0)
                .build();

        assertEquals(expectedPosition, position);
    }

    @Test
    public void testNorthToLeft() {
        Position position = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.G, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void testSouthToLeft() {
        Position position = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.G, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.E)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void testSouthToRight() {
        Position position = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.D, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void testEastToRight() {
        Position position = Position.builder()
                .direction(Direction.E)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.D, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }
    @Test
    public void testEastToLeft() {
        Position position = Position.builder()
                .direction(Direction.E)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.G, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void testWestToLeft() {
        Position position = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.G, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.S)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }

    @Test
    public void testWestToRight() {
        Position position = Position.builder()
                .direction(Direction.W)
                .x(0)
                .y(0)
                .build();
        position.updateDirection(Movement.D, lawn);
        Position expectedPosition = Position.builder()
                .direction(Direction.N)
                .x(0)
                .y(0)
                .build();
        assertEquals(expectedPosition, position);
    }




}
