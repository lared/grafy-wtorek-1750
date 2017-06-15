package edu.agh.gg.visualization;

import edu.agh.gg.Coordinates;
import edu.agh.gg.EdgeDirection;

class Transformer {

    private final double shiftLength;
    private final double factor;
    private final double length;

    public Transformer(double shiftLength, double factor, double length) {
        this.shiftLength = shiftLength;
        this.factor = factor;
        this.length = length;
    }

    Coordinates transform(Coordinates coordinates, EdgeDirection edgeDirection) {
        switch (edgeDirection) {
            case SW: return sw(coordinates);
            case SE: return se(coordinates);
            case NW: return nw(coordinates);
            case NE: return ne(coordinates);
            default: throw new IllegalArgumentException("Unsupported edge direction");
        }
    }

    Coordinates nw(Coordinates coordinates) {
        return Coordinates.of(coordinates.getX() + shiftLength, coordinates.getY() + (factor - 1) * length);
    }

    Coordinates ne(Coordinates coordinates) {
        return Coordinates.of(coordinates.getX() + shiftLength + (factor - 1) * length,coordinates.getY() + (factor - 1) * length);
    }

    Coordinates se(Coordinates coordinates) {
        return Coordinates.of(coordinates.getX() + shiftLength + (factor - 1) * length, coordinates.getY());
    }

    Coordinates sw(Coordinates coordinates) {
        return Coordinates.of(coordinates.getX() + shiftLength, coordinates.getY());
    }
}
