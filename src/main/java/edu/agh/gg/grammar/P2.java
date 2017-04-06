package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;

import static edu.agh.gg.EdgeDirection.*;
import static edu.agh.gg.VertexLabel.E;
import static edu.agh.gg.VertexLabel.I;

public class P2 implements Production {
    @Override
    public boolean applicableTo(Vertex vertex) {
        Vertex leftOrangeI = vertex.getChild(NE);
        Vertex rightOrangeI = vertex.getChild(SW);
        Vertex leftTopGrayI = leftOrangeI.getChild(NE);
        Vertex leftBottomGrayI = leftOrangeI.getChild(SW);
        Vertex rightTopGrayI = rightOrangeI.getChild(NW);
        Vertex rightBottomGrayI = rightOrangeI.getChild(SW);
        Vertex leftTopE = leftTopGrayI.getSibling(NE);
        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(NW);
        Vertex rightMiddleE = rightTopGrayI.getSibling(SW);
        Vertex rightBottomE = rightBottomGrayI.getSibling(SW);
        return vertex.getLabel().equals(E)
                && leftOrangeI.getLabel().equals(I)
                && rightOrangeI.getLabel().equals(I)
                && leftTopGrayI.getLabel().equals(I)
                && leftBottomGrayI.getLabel().equals(I)
                && leftTopE.getLabel().equals(E)
                && leftMiddleE.getLabel().equals(E)
                && leftBottomGrayI.getSibling(NE) == leftMiddleE
                && leftBottomE.getLabel().equals(E) //left done
                && rightTopGrayI.getLabel().equals(I)
                && rightBottomGrayI.getLabel().equals(I)
                && rightTopE.getLabel().equals(E)
                && rightMiddleE.getLabel().equals(E)
                && rightBottomGrayI.getSibling(NW) == rightMiddleE
                && rightBottomE.getLabel().equals(E) //right done
                && leftTopE.getSibling(S) == leftMiddleE
                && leftMiddleE.getSibling(N) == leftTopE
                && leftMiddleE.getSibling(S) == leftBottomE
                && leftBottomE.getSibling(N) == leftMiddleE
                && rightTopE.getSibling(S) == rightMiddleE
                && rightMiddleE.getSibling(N) == rightTopE
                && rightMiddleE.getSibling(S) == rightBottomE
                && rightBottomE.getSibling(N) == rightMiddleE;
    }

    @Override
    public void apply(Vertex vertex) {
        Vertex leftTopGrayI = vertex.getChild(NE).getChild(NE);
        Vertex leftBottomGrayI = vertex.getChild(NE).getChild(SW);
        Vertex leftTopE = leftTopGrayI.getSibling(NE);
        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(SE);

        leftTopGrayI.getSiblingsEdges().remove(NE, leftTopE);
        leftTopGrayI.getSiblingsEdges().remove(SE, leftMiddleE);
        leftBottomGrayI.getSiblingsEdges().remove(NE, leftMiddleE);
        leftBottomGrayI.getSiblingsEdges().remove(SE, leftBottomE);

        leftTopE.getSiblingsEdges().remove(S, leftMiddleE);
        leftMiddleE.getSiblingsEdges().remove(N, leftTopE);
        leftMiddleE.getSiblingsEdges().remove(S, leftBottomE);
        leftBottomE.getSiblingsEdges().remove(N, leftMiddleE);

        Vertex rightTopE = vertex.getChild(SW).getChild(NW).getSibling(NW);
        Vertex rightMiddleE = vertex.getChild(SW).getChild(NW).getSibling(SW);
        Vertex rightBottomE = vertex.getChild(SW).getChild(SW).getSibling(SW);

        leftTopGrayI.connectToSibling(NE, rightTopE);
        leftTopGrayI.connectToSibling(SE, rightMiddleE);
        leftBottomGrayI.connectToSibling(NE, rightMiddleE);
        leftBottomGrayI.connectToSibling(SE, rightBottomE);
    }
}
