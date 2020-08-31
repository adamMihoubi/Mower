package adapter;

import domain.model.Mower;
import domain.model.map.Lawn;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Instructions {
    private final Lawn lawn;
    private final List<Mower> mowers;
}
