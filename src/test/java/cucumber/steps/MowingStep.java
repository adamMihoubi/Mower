package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.expected.ExpectedMowers;
import cucumber.inputs.MowerInput;
import domain.model.Movement;
import domain.model.Mower;
import domain.model.Mowing;
import domain.model.map.Direction;
import domain.model.map.Lawn;
import domain.model.map.Position;
import javafx.util.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MowingStep {
    Lawn lawn;
    List<Mower> mowers;

    @Given("^the following mowers are given as an input with the lawn coordinate \\((\\d+),(\\d+)\\)$")
    public void the_following_mowers_are_given_as_an_input_with_the_lawn_coordinate(int x, int y, List<MowerInput> inputMowers) {
        lawn = Lawn.builder().superiorCorner(new Pair<>(x, y)).build();
        mowers = inputMowers.stream().map(mowerInput ->
                Mower.builder()
                        .position(buildPosition(mowerInput))
                        .movements(buildMovements(mowerInput.getMovements()))
                        .build())
                .collect(Collectors.toList());
    }

    @When("^the application is called$")
    public void the_application_is_called() {
        Mowing.INSTANCE.mow(lawn, mowers);
    }

    @Then("^the expected positions of the mowers are$")
    public void the_expected_positions_of_the_mowers_are(List<ExpectedMowers> expectedMowers) {
        List<ExpectedMowers> realMowers = mowers.stream().map(mower -> ExpectedMowers.builder().finalPosition(mower.toString()).build()).collect(Collectors.toList());
        assertThat(realMowers).containsExactlyInAnyOrderElementsOf(expectedMowers);
    }

    private List<Movement> buildMovements(String movements) {
        return Arrays.stream(movements.split("")).map(Movement::valueOf).collect(Collectors.toList());
    }

    private Position buildPosition(MowerInput mowerInput) {
        return Position.builder().x(mowerInput.getX()).y(mowerInput.getY()).direction(Direction.valueOf(mowerInput.getOrientation())).build();
    }

}
