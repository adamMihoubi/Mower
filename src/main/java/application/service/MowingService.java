package application.service;

import adapter.Instructions;
import adapter.InstructionsRepository;
import domain.model.Loader;
import domain.model.Mower;
import domain.model.Mowing;

import java.util.List;

public enum MowingService {
    INSTANCE;
    private final Loader<Instructions> instructionsLoader = InstructionsRepository.getInstance();
    private final Mowing mowing = Mowing.INSTANCE;

    public void mowing() {
        Instructions instructions = instructionsLoader.load();
        List<Mower> mowers = instructions.getMowers();
        mowing.mow(instructions.getLawn(), mowers);
        mowers.forEach(System.out::println);
    }
}
