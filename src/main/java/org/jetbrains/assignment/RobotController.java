package org.jetbrains.assignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class RobotController {

    @PostMapping("/locations")
    public List<Position> processLocations(@RequestBody List<Movement> requests) {
        List<Position> positions = new ArrayList<>();
        Position position = Position.START;
        positions.add(position);
        for (Movement request : requests) {
            position = position.move(request);
            positions.add(position);
        }

        return positions;
    }

    @PostMapping("/moves")
    public List<Movement> processMoves(@RequestBody List<Position> positions) {
        if (positions.isEmpty()) {
            return Collections.emptyList();
        }

        List<Movement> movements = new ArrayList<>();

        Position last = positions.remove(0);
        while (!positions.isEmpty()) {
            Position nextPosition = positions.remove(0);
            movements.addAll(last.movementTo(nextPosition));
            last = nextPosition;
        }

        return movements;
    }
}
