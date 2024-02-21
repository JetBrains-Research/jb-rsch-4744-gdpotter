package org.jetbrains.assignment;

import java.util.ArrayList;
import java.util.List;

public record Position(int x, int y) {

    static Position START = new Position(0, 0);

    Position move(Movement request) {
        return switch (request.direction()) {
            case NORTH -> new Position(x, y + request.steps());
            case SOUTH -> new Position(x, y - request.steps());
            case EAST -> new Position(x + request.steps(), y);
            case WEST -> new Position(x - request.steps(), y);
        };
    }

    List<Movement> movementTo(Position other) {
        int xDiff = other.x - x;
        int yDiff = other.y - y;
        List<Movement> movements = new ArrayList<>();
        if (xDiff > 0) {
            movements.add(new Movement(Direction.EAST, xDiff));
        } else if (xDiff < 0) {
            movements.add(new Movement(Direction.WEST, -xDiff));
        }

        if (yDiff > 0) {
            movements.add(new Movement(Direction.NORTH, yDiff));
        } else if (yDiff < 0) {
            movements.add(new Movement(Direction.SOUTH, -yDiff));
        }

        return movements;
    }

    int manhattanDistanceTo(Position other) {
        return Math.abs(other.x - x) + Math.abs(other.y - y);
    }
}
