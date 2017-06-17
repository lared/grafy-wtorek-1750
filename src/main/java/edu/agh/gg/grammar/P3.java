package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;

import java.util.concurrent.CyclicBarrier;

import static edu.agh.gg.EdgeDirection.*;
import static edu.agh.gg.VertexLabel.E;
import static edu.agh.gg.VertexLabel.I;


public class P3 extends Production {

    public P3(Vertex vertex, CyclicBarrier barrier) {
        super(vertex, barrier);
    }

    public P3(Vertex vertex) {
        super(vertex);
    }

    @Override
    public boolean applicableTo(Vertex vertex) {
        Vertex topOrangeI = vertex.getChild(NW);
        Vertex bottomOrangeI = vertex.getChild(SW);
        Vertex leftTopGrayI = topOrangeI.getChild(SW);
        Vertex rightTopGrayI = topOrangeI.getChild(SE);
        Vertex leftBottomGrayI = bottomOrangeI.getChild(NE);
        Vertex rightBottomGrayI = bottomOrangeI.getChild(NW);
        Vertex leftTopE = leftTopGrayI.getSibling(SW);
        Vertex middleTopE = leftTopGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(NW);
        Vertex middleBottomE = leftBottomGrayI.getSibling(NE);
        Vertex rightBottomE = rightBottomGrayI.getSibling(NE);
        return vertex.getLabel().equals(E)
                && topOrangeI.getLabel().equals(I)
                && bottomOrangeI.getLabel().equals(I)
                && leftTopGrayI.getLabel().equals(I)
                && rightTopGrayI.getLabel().equals(I)
                && leftTopE.getLabel().equals(E)
                && middleTopE.getLabel().equals(E)
                && rightTopGrayI.getSibling(SW) == middleTopE
                && rightTopE.getLabel().equals(E) //top done
                && leftBottomGrayI.getLabel().equals(I)
                && rightBottomGrayI.getLabel().equals(I)
                && leftBottomE.getLabel().equals(E)
                && middleBottomE.getLabel().equals(E)
                && rightBottomGrayI.getSibling(NW) == middleBottomE
                && rightBottomE.getLabel().equals(E) //bottom done
                && leftTopE.getSibling(EdgeDirection.E) == middleTopE
                && middleTopE.getSibling(W) == leftTopE
                && middleTopE.getSibling(EdgeDirection.E) == rightTopE
                && rightTopE.getSibling(W) == middleTopE
                && leftBottomE.getSibling(EdgeDirection.E) == middleBottomE
                && middleBottomE.getSibling(W) == leftBottomE
                && middleBottomE.getSibling(EdgeDirection.E) == rightBottomE
                && rightBottomE.getSibling(W) == middleBottomE;
    }

    @Override
    public void apply() {
        Vertex leftTopGrayI = vertex.getChild(NW).getChild(SW);
        Vertex rightTopGrayI = vertex.getChild(NW).getChild(SE);
        Vertex leftTopE = leftTopGrayI.getSibling(SW);
        Vertex middleTopE = leftTopGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(SE);

        leftTopGrayI.getSiblingsEdges().remove(SW, leftTopE);
        leftTopGrayI.getSiblingsEdges().remove(SE, middleTopE);
        rightTopGrayI.getSiblingsEdges().remove(SW, middleTopE);
        rightTopGrayI.getSiblingsEdges().remove(SE, rightTopE);

        leftTopE.getSiblingsEdges().remove(E, middleTopE);
        middleTopE.getSiblingsEdges().remove(W, leftTopE);
        middleTopE.getSiblingsEdges().remove(E, rightTopE);
        rightTopE.getSiblingsEdges().remove(W, middleTopE);

        Vertex leftBottomE = vertex.getChild(SW).getChild(NE).getSibling(NW);
        Vertex middleBottomE = vertex.getChild(SW).getChild(NE).getSibling(NE);
        Vertex rightBottomE = vertex.getChild(SW).getChild(NW).getSibling(NE);

        leftTopGrayI.connectToSibling(SW, leftBottomE);
        leftTopGrayI.connectToSibling(SE, middleBottomE);
        rightTopGrayI.connectToSibling(SW, middleBottomE);
        rightTopGrayI.connectToSibling(SE, rightBottomE);
    }
}
