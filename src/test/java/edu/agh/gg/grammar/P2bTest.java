package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;

import static edu.agh.gg.EdgeDirection.*;
import static org.junit.Assert.*;

public class P2bTest {

    private Vertex prepareInitialGraph() {
        Vertex greenE = Vertex.withoutParent(VertexLabel.E);

        Vertex leftOrange = greenE.createChild(NE);
        Vertex rightOrange = greenE.createChild(SW);
        leftOrange.setLabel(VertexLabel.I);
        rightOrange.setLabel(VertexLabel.I);

        Vertex leftTopI = leftOrange.createChild(NE);
        Vertex leftBottomI = leftOrange.createChild(SE);
        Vertex rightTopI = rightOrange.createChild(NW);
        Vertex rightBottomI = rightOrange.createChild(SW);

        leftTopI.setLabel(VertexLabel.I);
        leftBottomI.setLabel(VertexLabel.I);
        rightTopI.setLabel(VertexLabel.I);
        rightBottomI.setLabel(VertexLabel.I);

        Vertex topE = Vertex.withoutParent(VertexLabel.E);
        Vertex leftMiddleE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightMiddleE = Vertex.withoutParent(VertexLabel.E);
        Vertex bottomE = Vertex.withoutParent(VertexLabel.E);

        leftTopI.connectToSibling(NE, topE);
        leftTopI.connectToSibling(SE, leftMiddleE);
        leftBottomI.connectToSibling(NE, leftMiddleE);
        leftBottomI.connectToSibling(SE, bottomE);
        topE.connectToSibling(NW, leftMiddleE);
        leftMiddleE.connectToSibling(NE, bottomE);

        rightTopI.connectToSibling(NW, topE);
        rightTopI.connectToSibling(SW, rightMiddleE);
        rightBottomI.connectToSibling(NW, rightMiddleE);
        rightBottomI.connectToSibling(SW, bottomE);
        topE.connectToSibling(NE, rightMiddleE);
        rightMiddleE.connectToSibling(NW, bottomE);

        return greenE;
    }

    @Test
    public void shouldBeApplicableTo() throws Exception {
        Production p2b = new P2b();
        Vertex rootVertex = this.prepareInitialGraph();

        assertTrue(p2b.applicableTo(rootVertex));
    }

    @Test
    public void shouldHaveCorrectLabels() throws Exception {
        Production p2b = new P2b();
        Vertex rootVertex = prepareInitialGraph();
        p2b.apply(rootVertex);

        Vertex leftOrange = rootVertex.getChild(NE);
        Vertex rightOrange = rootVertex.getChild(SW);
        Vertex leftTopI = leftOrange.getChild(NE);
        Vertex leftBottomI = leftOrange.getChild(SE);
        Vertex rightTopI = rightOrange.getChild(NW);
        Vertex rightBottomI = rightOrange.getChild(SW);
        Vertex topE = leftTopI.getSibling(NE);
        Vertex middleE = leftTopI.getSibling(SE);
        Vertex bottomE = leftBottomI.getSibling(SE);

        assertEquals(VertexLabel.I, leftOrange.getLabel());
        assertEquals(VertexLabel.I, rightOrange.getLabel());
        assertEquals(VertexLabel.I, leftTopI.getLabel());
        assertEquals(VertexLabel.I, leftBottomI.getLabel());
        assertEquals(VertexLabel.I, rightTopI.getLabel());
        assertEquals(VertexLabel.I, rightBottomI.getLabel());
        assertEquals(VertexLabel.E, topE.getLabel());
        assertEquals(VertexLabel.E, middleE.getLabel());
        assertEquals(VertexLabel.E, bottomE.getLabel());
    }

    @Test
    public void shouldHaveCorrectSiblingsDirections() throws Exception {
        Production p2b = new P2b();
        Vertex rootVertex = prepareInitialGraph();
        p2b.apply(rootVertex);

        Vertex leftOrange = rootVertex.getChild(NE);
        Vertex rightOrange = rootVertex.getChild(SW);
        Vertex leftTopI = leftOrange.getChild(NE);
        Vertex leftBottomI = leftOrange.getChild(SE);
        Vertex rightTopI = rightOrange.getChild(NW);
        Vertex rightBottomI = rightOrange.getChild(SW);
        Vertex topE = leftTopI.getSibling(NE);
        Vertex middleE = leftTopI.getSibling(SE);
        Vertex bottomE = leftBottomI.getSibling(SE);

        ConcurrentMap<EdgeDirection, Vertex> leftTopSiblings = leftTopI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> leftBottomSiblings = leftBottomI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> rightTopSiblings = rightTopI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> rightBottomSiblings = rightBottomI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> topESiblings = topE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> middleESiblings = middleE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> bottomESibilings = bottomE.getSiblingsEdges();

        assertNotNull(leftTopSiblings.get(EdgeDirection.NE));
        assertNotNull(leftTopSiblings.get(EdgeDirection.SE));

        assertNotNull(leftBottomSiblings.get(EdgeDirection.NE));
        assertNotNull(leftBottomSiblings.get(EdgeDirection.SE));

        assertNotNull(rightTopSiblings.get(EdgeDirection.NW));
        assertNotNull(rightTopSiblings.get(EdgeDirection.SW));

        assertNotNull(rightBottomSiblings.get(EdgeDirection.NW));
        assertNotNull(rightBottomSiblings.get(EdgeDirection.SW));

        assertNotNull(topESiblings.get(EdgeDirection.S));
        assertNotNull(topESiblings.get(EdgeDirection.SW));
        assertNotNull(topESiblings.get(EdgeDirection.SE));

        assertNotNull(middleESiblings.get(EdgeDirection.N));
        assertNotNull(middleESiblings.get(EdgeDirection.NE));
        assertNotNull(middleESiblings.get(EdgeDirection.SE));
        assertNotNull(middleESiblings.get(EdgeDirection.S));
        assertNotNull(middleESiblings.get(EdgeDirection.SW));
        assertNotNull(middleESiblings.get(EdgeDirection.NW));

        assertNotNull(bottomESibilings.get(EdgeDirection.NW));
        assertNotNull(bottomESibilings.get(EdgeDirection.NE));
        assertNotNull(bottomESibilings.get(EdgeDirection.N));
    }

    @Test
    public void shouldHaveCorrectSiblingsSize() {
        Production p2b = new P2b();
        Vertex rootVertex = prepareInitialGraph();
        p2b.apply(rootVertex);

        Vertex leftOrange = rootVertex.getChild(NE);
        Vertex rightOrange = rootVertex.getChild(SW);
        Vertex leftTopI = leftOrange.getChild(NE);
        Vertex leftBottomI = leftOrange.getChild(SE);
        Vertex rightTopI = rightOrange.getChild(NW);
        Vertex rightBottomI = rightOrange.getChild(SW);
        Vertex topE = leftTopI.getSibling(NE);
        Vertex middleE = leftTopI.getSibling(SE);
        Vertex bottomE = leftBottomI.getSibling(SE);

        assertEquals(2, leftTopI.getSiblingsEdges().size());
        assertEquals(2, leftBottomI.getSiblingsEdges().size());
        assertEquals(2, rightTopI.getSiblingsEdges().size());
        assertEquals(2, rightBottomI.getSiblingsEdges().size());
        assertEquals(3, topE.getSiblingsEdges().size());
        assertEquals(6, middleE.getSiblingsEdges().size());
        assertEquals(3, bottomE.getSiblingsEdges().size());
    }
}
