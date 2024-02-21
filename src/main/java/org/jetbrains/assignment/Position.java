package org.jetbrains.assignment;

public record Position(int x, int y) {

    static Position START = new Position(0, 0);

    Position move(LocationRequest request) {
        return switch (request.direction()) {
            case NORTH -> new Position(x, y + request.steps());
            case SOUTH -> new Position(x, y - request.steps());
            case EAST -> new Position(x + request.steps(), y);
            case WEST -> new Position(x - request.steps(), y);
        };
    }
}
