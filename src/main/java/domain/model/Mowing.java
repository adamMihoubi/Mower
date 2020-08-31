package domain.model;

import domain.model.map.Lawn;

import java.util.List;


public enum Mowing {
    INSTANCE;

    public void mow(Lawn lawn, List<Mower> mowers) {
        mowers.forEach(mower -> mower.move(lawn));
    }
}
