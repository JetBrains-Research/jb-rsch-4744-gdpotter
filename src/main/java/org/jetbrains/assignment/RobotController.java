package org.jetbrains.assignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RobotController {

    @PostMapping("/locations")
    public List<Position> processLocations(@RequestBody List<LocationRequest> requests) {
        List<Position> positions = new ArrayList<>();
        Position position = Position.START;
        positions.add(position);
        for (LocationRequest request : requests) {
            position = position.move(request);
            positions.add(position);
        }

        return positions;
    }
}
