package org.jetbrains.assignment;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RobotControllerTest {

    @Autowired
    private RobotController controller;

    @Test
    void locations_shouldReturnLocationsFromReadme() {
        List<Position> result = controller.processLocations(List.of(
            new Movement(Direction.EAST, 1),
            new Movement(Direction.NORTH, 3),
            new Movement(Direction.EAST, 3),
            new Movement(Direction.SOUTH, 5),
            new Movement(Direction.WEST, 2)
        ));
        assertEquals(
            List.of(
                new Position(0, 0),
                new Position(1, 0),
                new Position(1, 3),
                new Position(4, 3),
                new Position(4, -2),
                new Position(2, -2)
            ),
            result
        );
    }

    @Test
    void moves_shouldReturnLocationsFromReadme() {
        List<Movement> result = controller.processMoves(List.of(
            new Position(0, 0),
            new Position(1, 0),
            new Position(1, 3),
            new Position(0, 3),
            new Position(0, 0)
        ));
        assertEquals(
            List.of(
                new Movement(Direction.EAST, 1),
                new Movement(Direction.NORTH, 3),
                new Movement(Direction.WEST, 1),
                new Movement(Direction.SOUTH, 3)
            ),
            result
        );
    }
}
