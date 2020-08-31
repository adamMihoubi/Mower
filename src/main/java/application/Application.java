package application;

import adapter.Instructions;
import adapter.InstructionsRepository;
import application.service.MowingService;
import domain.model.Loader;
import domain.model.Mower;
import domain.model.Mowing;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        MowingService.INSTANCE.mowing();
    }
}
