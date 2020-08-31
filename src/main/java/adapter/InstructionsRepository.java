package adapter;

import domain.model.Loader;
import domain.model.Movement;
import domain.model.Mower;
import domain.model.map.Direction;
import domain.model.map.Lawn;
import domain.model.map.Position;
import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InstructionsRepository implements Loader<Instructions> {
    private static String SPACE = " ";
    private static InstructionsRepository INSTANCE;

    private InstructionsRepository() {
    }

    public static InstructionsRepository getInstance() {
        return INSTANCE == null ? INSTANCE = new InstructionsRepository() : INSTANCE;
    }

    @Override
    public Instructions load() {
        LinkedList<String> instructions = readTheInputFile();
        return Instructions.builder()
                .lawn(createLawn(instructions))
                .mowers(createMowers(instructions))
                .build();
    }

    private LinkedList<String> readTheInputFile() {
        LinkedList<String> instructions = new LinkedList<>();
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream resourceAsStream = classLoader.getResourceAsStream("inputFile.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                instructions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("failed to read the file", e);
        }
        return instructions;
    }

    private Lawn createLawn(LinkedList<String> instructions) {
        String lawnSize = instructions.remove();
        String[] positions = lawnSize.split(SPACE);
        int x = Integer.parseInt(positions[0]);
        int y = Integer.parseInt(positions[1]);
        return Lawn.builder().superiorCorner(new Pair<>(x, y)).build();
    }

    private List<Mower> createMowers(LinkedList<String> instructions) {
        List<Mower> mowers = new ArrayList<>();
        while (instructions.size() > 0) {
            mowers.add(createMower(instructions));
        }
        return mowers;
    }

    private Mower createMower(LinkedList<String> instructions) {
        String[] positions = instructions.remove().split(SPACE);
        int x = Integer.parseInt(positions[0]);
        int y = Integer.parseInt(positions[1]);
        Direction direction = Direction.valueOf(positions[2]);
        Position position = Position.builder()
                .x(x)
                .y(y)
                .direction(direction)
                .build();
        List<Movement> movements = Arrays.stream(instructions.remove().split("")).map(Movement::valueOf).collect(Collectors.toList());
        return Mower.builder()
                .position(position)
                .movements(movements)
                .build();
    }

}
