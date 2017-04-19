package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;

import static edu.agh.gg.EdgeDirection.*;
import static edu.agh.gg.EdgeDirection.NE;
import static edu.agh.gg.EdgeDirection.SE;
import static edu.agh.gg.VertexLabel.E;
import static edu.agh.gg.VertexLabel.I;

public class P2b implements Production{

    @Override
    public boolean applicableTo(Vertex vertex) {
        Vertex leftOrangeI = vertex.getChild(NE);
        Vertex rightOrangeI = vertex.getChild(SW);

        Vertex leftTopGrayI = leftOrangeI.getChild(NE);
        Vertex leftBottomGrayI = leftOrangeI.getChild(SW); //TODO: shouldn't be SE?
        Vertex rightTopGrayI = rightOrangeI.getChild(NW);
        Vertex rightBottomGrayI = rightOrangeI.getChild(SW);

        Vertex topE = leftTopGrayI.getSibling(NE);

        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex rightMiddleE = rightTopGrayI.getSibling(SW);

        Vertex bottomE = leftBottomGrayI.getSibling(SE);

        return vertex.getLabel().equals(E)
                && leftOrangeI.getLabel().equals(I)
                && rightOrangeI.getLabel().equals(I) //orange done

                && leftTopGrayI.getLabel().equals(I)
                && leftBottomGrayI.getLabel().equals(I)
                && rightTopGrayI.getLabel().equals(I)
                && rightBottomGrayI.getLabel().equals(I) //gray done

                && topE.getLabel().equals(E)
                && topE.equals(rightTopGrayI.getSibling(NW))
                && topE.getSibling(NW) == leftMiddleE
                && topE.getSibling(NE) == rightMiddleE //topE done

                && leftMiddleE.getLabel().equals(E)
                && leftMiddleE.getSibling(NE) == bottomE //middle left done

                && rightMiddleE.getLabel().equals(E)
                && rightBottomGrayI.getSibling(NW) == rightMiddleE
                && rightMiddleE.getSibling(SW) == topE
                && rightMiddleE.getSibling(NW) == bottomE //middle right done

                && bottomE.getLabel().equals(E)
                && bottomE.equals(rightBottomGrayI.getSibling(SW))
                && bottomE.getSibling(SW).equals(leftMiddleE)
                && bottomE.getSibling(SE).equals(rightMiddleE); //bottom done
    }

    @Override
    public void apply(Vertex vertex) {
        Vertex leftTopGrayI = vertex.getChild(NE).getChild(NE);
        Vertex leftBottomGrayI = vertex.getChild(NE).getChild(SW);
        Vertex rightTopE = vertex.getChild(SW).getChild(NW);
        Vertex rightBottomE = vertex.getChild(SW).getChild(SW);

        Vertex topE = leftTopGrayI.getSibling(NE);

        Vertex leftMiddleE = leftTopGrayI.getSibling(SE);
        Vertex rightMiddleE = vertex.getChild(SW).getChild(NW).getSibling(SW);

        Vertex bottomE = leftBottomGrayI.getSibling(SE);

        leftTopGrayI.getSiblingsEdges().remove(SE, leftMiddleE);
        leftBottomGrayI.getSiblingsEdges().remove(NE, leftMiddleE);

        topE.getSiblingsEdges().remove(NW, leftMiddleE);
        bottomE.getSiblingsEdges().remove(SW, leftMiddleE);

        leftMiddleE.getSiblingsEdges().remove(SE, topE);
        leftMiddleE.getSiblingsEdges().remove(NE, bottomE);
        leftMiddleE.getSiblingsEdges().remove(NW, leftTopGrayI);
        leftMiddleE.getSiblingsEdges().remove(SW, leftBottomGrayI);

        topE.getSiblingsEdges().remove(NE, rightMiddleE);
        topE.connectToSibling(S, rightMiddleE);
        bottomE.getSiblingsEdges().remove(SE, rightMiddleE);
        bottomE.connectToSibling(N, rightMiddleE);

        rightMiddleE.getSiblingsEdges().remove(SE, topE);
        rightMiddleE.getSiblingsEdges().remove(NW, bottomE);

        rightMiddleE.connectToSibling(N, topE);
        rightMiddleE.connectToSibling(S, bottomE);

        leftTopGrayI.connectToSibling(SE, rightMiddleE);
        leftBottomGrayI.connectToSibling(NE, rightMiddleE);
    }
}
