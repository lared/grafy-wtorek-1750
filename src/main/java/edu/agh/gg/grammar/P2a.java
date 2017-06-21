package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;

import java.util.concurrent.CyclicBarrier;

import static edu.agh.gg.EdgeDirection.*;
import static edu.agh.gg.VertexLabel.E;
import static edu.agh.gg.VertexLabel.I;

public class P2a extends Production {

    public P2a(Vertex vertex, CyclicBarrier barrier) {
        super(vertex, barrier);
    }

    public P2a(Vertex vertex) {
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

        Vertex topE = leftTopGrayI.getSibling(NE);

        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(SE);
//        Vertex rightTopE = rightTopGrayI.getSibling(NW); // == leftTopE A
        Vertex rightMiddleE = rightTopGrayI.getSibling(SW); // == leftMiddleE
        Vertex rightBottomE = rightBottomGrayI.getSibling(SW);

        return vertex.getLabel().equals(E)
                && leftOrangeI.getLabel().equals(I)
                && rightOrangeI.getLabel().equals(I)
                && vertex.getChildrenEdges().size() == 2
                && leftOrangeI.getChildrenEdges().size() == 2
                && rightOrangeI.getChildrenEdges().size() == 2 //orange done

                && leftTopGrayI.getLabel().equals(I)
                && leftBottomGrayI.getLabel().equals(I)

                && rightTopGrayI.getLabel().equals(I)
                && rightBottomGrayI.getLabel().equals(I)

                && topE.getLabel().equals(E)
                && topE.equals(rightTopGrayI.getSibling(NW))

                && leftMiddleE.getLabel().equals(E)
                && leftMiddleE.equals(leftBottomGrayI.getSibling(NE))
                && leftBottomE.getLabel().equals(E)//left done
                && rightMiddleE.getLabel().equals(E)
                && rightMiddleE.equals(rightBottomGrayI.getSibling(NW))
                && rightBottomE.getLabel().equals(E)//right done

                && topE.getSibling(NW) == leftMiddleE

                && leftMiddleE.getSibling(S) == leftBottomE

                && topE.getSibling(NE) == rightMiddleE

                && rightMiddleE.getSibling(S) == rightBottomE;
    }

    @Override
    public void apply() {
        Vertex leftTopGrayI = vertex.getChild(NE).getChild(NE);
        Vertex leftBottomGrayI = vertex.getChild(NE).getChild(SE);

        Vertex topE = leftTopGrayI.getSibling(NE);

        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(SE);

        leftTopGrayI.getSiblingsEdges().remove(SE, leftMiddleE);
        leftBottomGrayI.getSiblingsEdges().remove(NE, leftMiddleE);
        leftBottomGrayI.getSiblingsEdges().remove(SE, leftBottomE);

        topE.getSiblingsEdges().remove(NW, leftMiddleE);
        leftMiddleE.getSiblingsEdges().remove(S, leftBottomE);

        Vertex rightMiddleE = vertex.getChild(SW).getChild(NW).getSibling(SW);
        Vertex rightBottomE = vertex.getChild(SW).getChild(SW).getSibling(SW);

        topE.getSiblingsEdges().remove(NE, rightMiddleE);
        topE.connectToSibling(S, rightMiddleE);

        leftTopGrayI.connectToSibling(SE, rightMiddleE);
        leftBottomGrayI.connectToSibling(NE, rightMiddleE);
        leftBottomGrayI.connectToSibling(SE, rightBottomE);
    }
}

