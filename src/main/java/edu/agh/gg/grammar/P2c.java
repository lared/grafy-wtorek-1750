package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;

import java.util.concurrent.CyclicBarrier;

import static edu.agh.gg.EdgeDirection.*;
import static edu.agh.gg.EdgeDirection.NE;
import static edu.agh.gg.EdgeDirection.SE;
import static edu.agh.gg.VertexLabel.E;
import static edu.agh.gg.VertexLabel.I;

public class P2c extends Production {

    public P2c(Vertex vertex, CyclicBarrier barrier) {
        super(vertex, barrier);
    }

    public P2c(Vertex vertex) {
        super(vertex);
    }

    @Override
    public boolean applicableTo(Vertex vertex) {
        Vertex leftOrangeI = vertex.getChild(NE);
        Vertex rightOrangeI = vertex.getChild(SW);
        Vertex leftTopGrayI = leftOrangeI.getChild(NE);
        Vertex leftBottomGrayI = leftOrangeI.getChild(SE);
        Vertex rightTopGrayI = rightOrangeI.getChild(NW);
        Vertex rightBottomGrayI = rightOrangeI.getChild(SW);
        Vertex leftTopE = leftTopGrayI.getSibling(NE);
        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(NW);
        Vertex rightMiddleE = rightTopGrayI.getSibling(SW);
        Vertex bottomE = leftBottomGrayI.getSibling(SE);

        return vertex.getLabel().equals(E)
                && leftOrangeI.getLabel().equals(I)
                && rightOrangeI.getLabel().equals(I) //orange's labels done

                && leftTopGrayI.getLabel().equals(I)
                && leftBottomGrayI.getLabel().equals(I)
                && rightTopGrayI.getLabel().equals(I)
                && rightBottomGrayI.getLabel().equals(I) //gray's labels done

                && leftTopE.getLabel().equals(E)
                && leftMiddleE.getLabel().equals(E)
                && rightTopE.getLabel().equals(E)
                && rightMiddleE.getLabel().equals(E)
                && bottomE.getLabel().equals(E) //yellow label's done

                && leftTopGrayI.getSibling(NE).equals(leftTopE)
                && leftTopGrayI.getSibling(SE).equals(leftMiddleE)
                && leftBottomGrayI.getSibling(NE).equals(leftMiddleE)
                && leftBottomGrayI.getSibling(SE).equals(bottomE)

                && rightTopGrayI.getSibling(NW).equals(rightTopE)
                && rightTopGrayI.getSibling(SW).equals(rightMiddleE)
                && rightBottomGrayI.getSibling(NW).equals(rightMiddleE)
                && rightBottomGrayI.getSibling(SW).equals(bottomE) //gray done

                && leftTopE.getSibling(S) == leftMiddleE
                && leftMiddleE.getSibling(NE) == bottomE
                && rightTopE.getSibling(S) == rightMiddleE
                && rightMiddleE.getSibling(NW) == bottomE; // yellow done //TODO: Shouldn't be checked the direction from child to parent??
    }

    @Override
    public void apply() {
        Vertex leftTopGrayI = vertex.getChild(NE).getChild(NE);
        Vertex leftBottomGrayI = vertex.getChild(NE).getChild(SE);
        Vertex leftTopE = leftTopGrayI.getSibling(NE);
        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex bottomE = leftBottomGrayI.getSibling(SE);

        leftTopGrayI.getSiblingsEdges().remove(NE, leftTopE);
        leftTopGrayI.getSiblingsEdges().remove(SE, leftMiddleE);
        leftBottomGrayI.getSiblingsEdges().remove(NE, leftMiddleE);

        leftTopE.getSiblingsEdges().remove(S, leftMiddleE);
        leftMiddleE.getSiblingsEdges().remove(N, leftTopE);
        leftMiddleE.getSiblingsEdges().remove(NE, bottomE);
        bottomE.getSiblingsEdges().remove(SW, leftMiddleE);

        Vertex rightTopE = vertex.getChild(SW).getChild(NW).getSibling(NW);
        Vertex rightMiddleE = vertex.getChild(SW).getChild(NW).getSibling(SW);

        rightMiddleE.getSiblingsEdges().remove(NW, bottomE);
        bottomE.getSiblingsEdges().remove(SE, rightMiddleE);

        rightMiddleE.connectToSibling(S, bottomE);
        leftTopGrayI.connectToSibling(NE, rightTopE);
        leftTopGrayI.connectToSibling(SE, rightMiddleE);
        leftBottomGrayI.connectToSibling(NE, rightMiddleE);

        awaitBarrier();
    }
}
