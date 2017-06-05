package edu.agh.gg;

import edu.agh.gg.serialization.Serializable;

public enum EdgeDirection implements Serializable {
    N(1),
    NE(2),
    E(3),
    SE(4),
    S(-1),
    SW(-2),
    W(-3),
    NW(-4);

    private final int num;

    EdgeDirection(int num) {
        this.num = num;
    }

    public EdgeDirection opposite() {
        for (EdgeDirection edgeDirection : values()) {
            if (edgeDirection.num == -num) {
                return edgeDirection;
            }
        }
        throw new AssertionError("All directions should have opposite directions");
    }

    @Override
    public String serialize(){
        return this.name();
    }
}
