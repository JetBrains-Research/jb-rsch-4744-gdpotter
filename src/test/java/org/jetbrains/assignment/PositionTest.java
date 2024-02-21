package org.jetbrains.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void move_goesToCorrectPosition() {
        assertEquals(new Position(0, 5), new Position(0, 4).move(new Movement(Direction.NORTH ,1)));
        assertEquals(new Position(0, 5), new Position(0, 8).move(new Movement(Direction.SOUTH ,3)));
        assertEquals(new Position(2, 5), new Position(2, 4).move(new Movement(Direction.NORTH ,1)));
        assertEquals(new Position(2, 5), new Position(2, 8).move(new Movement(Direction.SOUTH ,3)));

        assertEquals(new Position(5, 0), new Position(4, 0).move(new Movement(Direction.EAST ,1)));
        assertEquals(new Position(5, 0), new Position(8, 0).move(new Movement(Direction.WEST ,3)));
        assertEquals(new Position(5, 2), new Position(4, 2).move(new Movement(Direction.EAST ,1)));
        assertEquals(new Position(5, 2), new Position(8, 2).move(new Movement(Direction.WEST ,3)));
    }
}
