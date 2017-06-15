package edu.agh.gg.visualization;

import edu.agh.gg.Coordinates;
import edu.agh.gg.Vertex;

public class PositionCalc {

    private static final double T_FACTOR = 4.0;
    private static final double T_SHIFT = 5.0;
    private static final double LENGTH = 1.0;
    private static final Transformer TRANSFORMER = new Transformer(T_SHIFT, T_FACTOR, LENGTH);

    public static Coordinates CHILD_SHIFT = Coordinates.of(7.0, 0.0);

    public static void calculatePositions(Vertex vertex) {
        vertex.setPosition(Coordinates.start());
        calculate(vertex, CHILD_SHIFT);
    }

    private static void calculate(Vertex vertex, Coordinates shift) {
        System.out.println(vertex.getUniqueID() + " " + vertex.getLabel() + " " + vertex.getPosition());
        vertex.getSiblingsEdges().forEach((d, v) -> {
            if(v.getPosition() == null) {
                v.setPosition(d.shift(vertex.getPosition()));
            }
        });

        vertex.getChildrenEdges().forEach((d, v) -> {
            if(v.getPosition() == null) {
                v.setPosition(d.shift(vertex.getPosition()).shifted(shift));
                calculate(v, TRANSFORMER.transform(shift, d));
            }
        });
    }

}
