package edu.agh.gg.grammar;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentMap;

import static edu.agh.gg.EdgeDirection.*;
import static edu.agh.gg.VertexLabel.I;
import static org.junit.Assert.*;

public class P3Test {
    private Vertex rootVertex;

    public static Vertex prepareInitialGraph() {
        Vertex vertex = Vertex.withoutParent(VertexLabel.E);

        Vertex topOrangeI = vertex.createChild(NW);
        Vertex bottomOrangeI = vertex.createChild(SW);
        topOrangeI.setLabel(I);
        bottomOrangeI.setLabel(I);

        Vertex leftTopGrayI = topOrangeI.createChild(SW);
        Vertex rightTopGrayI = topOrangeI.createChild(SE);
        Vertex leftBottomGrayI = bottomOrangeI.createChild(NE);
        Vertex rightBottomGrayI = bottomOrangeI.createChild(NW);

        Vertex leftTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex middleTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightTopE = Vertex.withoutParent(VertexLabel.E);
        Vertex leftBottomE = Vertex.withoutParent(VertexLabel.E);
        Vertex middleBottomE = Vertex.withoutParent(VertexLabel.E);
        Vertex rightBottomE = Vertex.withoutParent(VertexLabel.E);

        leftTopGrayI.connectToSibling(SE, middleTopE);
        leftTopGrayI.connectToSibling(SW, leftTopE);

        rightTopGrayI.connectToSibling(SE, rightTopE);
        rightTopGrayI.connectToSibling(SW, middleTopE);

        leftBottomGrayI.connectToSibling(NW, leftBottomE);
        leftBottomGrayI.connectToSibling(NE, middleBottomE);

        rightBottomGrayI.connectToSibling(NE, rightBottomE);
        rightBottomGrayI.connectToSibling(NW, middleBottomE);

        leftTopE.connectToSibling(E, middleTopE);
        leftTopE.connectToSibling(W, middleTopE);
        middleTopE.connectToSibling(E, rightTopE);
        leftBottomE.connectToSibling(E, middleBottomE);
        middleBottomE.connectToSibling(E, rightBottomE);

        return vertex;
    }

    @Before
    public void prepare() {
        rootVertex = prepareInitialGraph();
    }

    @Test
    public void shouldBeApplicableTo() {
        Production p3 = new P3();
        assertTrue(p3.applicableTo(rootVertex));
    }

    @Test
    public void shouldHaveCorrectLabels() {
        Production p3 = new P3();
        p3.apply(rootVertex);

        Vertex leftOrange = rootVertex.getChild(NW);
        Vertex bottomOrangeI = rootVertex.getChild(SW);
        Vertex leftTopGrayI = leftOrange.getChild(SW);
        Vertex rightTopGrayI = leftOrange.getChild(SE);
        Vertex leftBottomGrayI = bottomOrangeI.getChild(NE);
        Vertex rightBottomGrayI = bottomOrangeI.getChild(NW);

        Vertex leftTopE = leftTopGrayI.getSibling(SW);
        Vertex middleTopE = leftTopGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(NW);
        Vertex middleBottomE = leftBottomGrayI.getSibling(NE);
        Vertex rightBottomE = rightBottomGrayI.getSibling(NE);

        assertEquals(I, leftOrange.getLabel());
        assertEquals(I, bottomOrangeI.getLabel());
        assertEquals(I, leftTopGrayI.getLabel());
        assertEquals(I, rightTopGrayI.getLabel());
        assertEquals(I, leftBottomGrayI.getLabel());
        assertEquals(I, rightBottomGrayI.getLabel());
        assertEquals(VertexLabel.E, leftTopE.getLabel());
        assertEquals(VertexLabel.E, middleTopE.getLabel());
        assertEquals(VertexLabel.E, rightTopE.getLabel());
        assertEquals(VertexLabel.E, leftBottomE.getLabel());
        assertEquals(VertexLabel.E, middleBottomE.getLabel());
        assertEquals(VertexLabel.E, rightBottomE.getLabel());
    }

    @Test
    public void shouldHaveCorrectSiblingsDirections() {
        Production p3 = new P3();
        p3.apply(rootVertex);

        Vertex leftOrange = rootVertex.getChild(NW);
        Vertex bottomOrangeI = rootVertex.getChild(SW);

        Vertex leftTopGrayI = leftOrange.getChild(SW);
        Vertex rightTopGrayI = leftOrange.getChild(SE);
        Vertex leftBottomGrayI = bottomOrangeI.getChild(NE);
        Vertex rightBottomGrayI = bottomOrangeI.getChild(NW);

        Vertex leftTopE = leftTopGrayI.getSibling(SW);
        Vertex middleTopE = leftTopGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(NW);
        Vertex middleBottomE = leftBottomGrayI.getSibling(NE);
        Vertex rightBottomE = rightBottomGrayI.getSibling(NE);

        ConcurrentMap<EdgeDirection, Vertex> leftTopGrayISiblings = leftTopGrayI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> rightTopGrayISiblings = rightTopGrayI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> leftBottomGrayISiblings = leftBottomGrayI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> rightBottomGrayISiblings = rightBottomGrayI.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> leftTopESiblings = leftTopE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> middleTopESiblings = middleTopE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> rightTopESiblings = rightTopE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> leftBottomESiblings = leftBottomE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> middleBottomESiblings = middleBottomE.getSiblingsEdges();
        ConcurrentMap<EdgeDirection, Vertex> rightBottomESiblings = rightBottomE.getSiblingsEdges();

        assertNotNull(leftTopGrayISiblings.get(EdgeDirection.SW));
        assertNotNull(leftTopGrayISiblings.get(EdgeDirection.SE));

        assertNotNull(rightTopGrayISiblings.get(EdgeDirection.SW));
        assertNotNull(rightTopGrayISiblings.get(EdgeDirection.SE));

        assertNotNull(leftBottomGrayISiblings.get(EdgeDirection.NW));
        assertNotNull(leftBottomGrayISiblings.get(EdgeDirection.NE));

        assertNotNull(rightBottomGrayISiblings.get(EdgeDirection.NW));
        assertNotNull(rightBottomGrayISiblings.get(EdgeDirection.NE));

        assertNotNull(leftTopESiblings.get(EdgeDirection.NE));
        assertNotNull(leftTopESiblings.get(EdgeDirection.E));
        assertNotNull(leftTopESiblings.get(EdgeDirection.SE));

        assertNotNull(middleTopESiblings.get(EdgeDirection.NW));
        assertNotNull(middleTopESiblings.get(EdgeDirection.SW));
        assertNotNull(middleTopESiblings.get(EdgeDirection.W));
        assertNotNull(middleTopESiblings.get(EdgeDirection.NE));
        assertNotNull(middleTopESiblings.get(EdgeDirection.E));
        assertNotNull(middleTopESiblings.get(EdgeDirection.SE));

        assertNotNull(rightTopESiblings.get(EdgeDirection.NW));
        assertNotNull(rightTopESiblings.get(EdgeDirection.SW));
        assertNotNull(rightTopESiblings.get(EdgeDirection.W));

        assertNotNull(leftBottomESiblings.get(EdgeDirection.NE));
        assertNotNull(leftBottomESiblings.get(EdgeDirection.E));
        assertNotNull(leftBottomESiblings.get(EdgeDirection.SE));

        assertNotNull(middleBottomESiblings.get(EdgeDirection.NW));
        assertNotNull(middleBottomESiblings.get(EdgeDirection.SW));
        assertNotNull(middleBottomESiblings.get(EdgeDirection.W));
        assertNotNull(middleBottomESiblings.get(EdgeDirection.NE));
        assertNotNull(middleBottomESiblings.get(EdgeDirection.E));
        assertNotNull(middleBottomESiblings.get(EdgeDirection.SE));

        assertNotNull(rightBottomESiblings.get(EdgeDirection.NW));
        assertNotNull(rightBottomESiblings.get(EdgeDirection.SW));
        assertNotNull(rightBottomESiblings.get(EdgeDirection.W));
    }

    @Test
    public void shouldHaveCorrectSiblingsSize() {
        Production p3 = new P3();
        p3.apply(rootVertex);

        Vertex leftOrange = rootVertex.getChild(NW);
        Vertex bottomOrangeI = rootVertex.getChild(SW);

        Vertex leftTopGrayI = leftOrange.getChild(SW);
        Vertex rightTopGrayI = leftOrange.getChild(SE);
        Vertex leftBottomGrayI = bottomOrangeI.getChild(NE);
        Vertex rightBottomGrayI = bottomOrangeI.getChild(NW);

        Vertex leftTopE = leftTopGrayI.getSibling(SW);
        Vertex middleTopE = leftTopGrayI.getSibling(SE);
        Vertex rightTopE = rightTopGrayI.getSibling(SE);
        Vertex leftBottomE = leftBottomGrayI.getSibling(NW);
        Vertex middleBottomE = leftBottomGrayI.getSibling(NE);
        Vertex rightBottomE = rightBottomGrayI.getSibling(NE);

        assertTrue(leftOrange.getSiblingsEdges().size() >= 0);
        assertTrue(bottomOrangeI.getSiblingsEdges().size() >= 0);
        assertTrue(leftTopGrayI.getSiblingsEdges().size() >= 2);
        assertTrue(rightTopGrayI.getSiblingsEdges().size() >= 2);
        assertTrue(leftBottomGrayI.getSiblingsEdges().size() >= 2);
        assertTrue(rightBottomGrayI.getSiblingsEdges().size() >= 2);
        assertTrue(leftTopE.getSiblingsEdges().size() >= 3);
        assertTrue(middleTopE.getSiblingsEdges().size() >= 6);
        assertTrue(rightTopE.getSiblingsEdges().size() >= 3);
        assertTrue(leftBottomE.getSiblingsEdges().size() >= 3);
        assertTrue(middleBottomE.getSiblingsEdges().size() >= 6);
        assertTrue(rightBottomE.getSiblingsEdges().size() >= 3);
    }

}
