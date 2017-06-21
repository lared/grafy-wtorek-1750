package edu.agh.gg;

import edu.agh.gg.serialization.Serializable;

public enum EdgeDirection implements Serializable {
    SW(-2, Coordinates.of(-1.0, -1.0)),
    S(-1, Coordinates.of(0.0, -1.0)),
    N(1, Coordinates.of(0.0,1.0)),
    NE(2, Coordinates.of(1.0,1.0)),
    E(3, Coordinates.of(0.0, 1.0)),
    SE(4, Coordinates.of(1.0, -1.0)),
    W(-3, Coordinates.of(0.0, -1.0)),
    NW(-4, Coordinates.of(-1.0, 1.0));

    private final int num;
    private final Coordinates shift;

    EdgeDirection(int num, Coordinates shift) {
        this.num = num;
        this.shift = shift;
    }

    public EdgeDirection opposite() {
        for (EdgeDirection edgeDirection : values()) {
            if (edgeDirection.num == -num) {
                return edgeDirection;
            }
        }
        throw new AssertionError("All directions should have opposite directions");
    }

    public Coordinates shift(Coordinates position) {
        return position.shifted(shift);
    }

    @Override
    public String serialize(){
        return this.name();
    }
}
