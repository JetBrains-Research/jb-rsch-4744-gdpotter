package org.jetbrains.assignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

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
        Queue<Position> queue = new ArrayDeque<>(positions);
        if (queue.isEmpty()) {
            return Collections.emptyList();
        }

        List<Movement> movements = new ArrayList<>();

        Position last = queue.remove();
        while (!queue.isEmpty()) {
            Position nextPosition = queue.remove();
            movements.addAll(last.movementTo(nextPosition));
            last = nextPosition;
        }

        return movements;
    }
}
