package edu.agh.gg.serialization;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.grammar.*;
import edu.agh.gg.serialization.idgenerator.Id;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SerializerTest {
    @Before
    public void setUp() throws Exception {
        Id.resetIds();
    }

    @Test
    public void testP0Serialization() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);
        P0 p0 = new P0();
        p0.apply(vertex);

        String expected = "an n1 label:I ui.class:I\n" +
                "ae e1 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e2 n4 n5 EdgeDirection=S\n" +
                "ae e3 n4 n1 EdgeDirection=SW\n" +
                "ae e4 n4 n2 EdgeDirection=W\n" +
                "ae e5 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e6 n5 n4 EdgeDirection=N\n" +
                "ae e7 n5 n3 EdgeDirection=W\n" +
                "ae e8 n5 n1 EdgeDirection=NW\n" +
                "ae e9 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class:E\n" +
                "ae e10 n3 n2 EdgeDirection=N\n" +
                "ae e11 n3 n1 EdgeDirection=NE\n" +
                "ae e12 n3 n5 EdgeDirection=E\n" +
                "ae e13 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class:E\n" +
                "ae e14 n2 n4 EdgeDirection=E\n" +
                "ae e15 n2 n1 EdgeDirection=SE\n" +
                "ae e16 n2 n3 EdgeDirection=S\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testP1Serialization() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);
        P1 p1 = new P1();
        p1.apply(vertex);

        String expected = "an n1 label:i ui.class:i\n" +
                "ae e1 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:I ui.class:I\n" +
                "ae e2 n4 n8 EdgeDirection=NE\n" +
                "an n8 label:E ui.class:E\n" +
                "ae e3 n8 n11 EdgeDirection=S\n" +
                "ae e4 n8 n4 EdgeDirection=SW\n" +
                "ae e5 n8 n7 EdgeDirection=W\n" +
                "ae e6 n4 n11 EdgeDirection=SE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e7 n11 n8 EdgeDirection=N\n" +
                "ae e8 n11 n14 EdgeDirection=S\n" +
                "ae e9 n11 n5 EdgeDirection=SW\n" +
                "ae e10 n11 n10 EdgeDirection=W\n" +
                "ae e11 n11 n4 EdgeDirection=NW\n" +
                "ae e12 n4 n10 EdgeDirection=SW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e13 n10 n7 EdgeDirection=N\n" +
                "ae e14 n10 n4 EdgeDirection=NE\n" +
                "ae e15 n10 n11 EdgeDirection=E\n" +
                "ae e16 n10 n5 EdgeDirection=SE\n" +
                "ae e17 n10 n13 EdgeDirection=S\n" +
                "ae e18 n10 n3 EdgeDirection=SW\n" +
                "ae e19 n10 n9 EdgeDirection=W\n" +
                "ae e20 n10 n2 EdgeDirection=NW\n" +
                "ae e21 n4 n7 EdgeDirection=NW\n" +
                "an n7 label:E ui.class:E\n" +
                "ae e22 n7 n8 EdgeDirection=E\n" +
                "ae e23 n7 n4 EdgeDirection=SE\n" +
                "ae e24 n7 n10 EdgeDirection=S\n" +
                "ae e25 n7 n2 EdgeDirection=SW\n" +
                "ae e26 n7 n6 EdgeDirection=W\n" +
                "ae e27 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:I ui.class:I\n" +
                "ae e28 n5 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e29 n11 n8 EdgeDirection=N\n" +
                "ae e30 n11 n14 EdgeDirection=S\n" +
                "ae e31 n11 n5 EdgeDirection=SW\n" +
                "ae e32 n11 n10 EdgeDirection=W\n" +
                "ae e33 n11 n4 EdgeDirection=NW\n" +
                "ae e34 n5 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e35 n14 n11 EdgeDirection=N\n" +
                "ae e36 n14 n13 EdgeDirection=W\n" +
                "ae e37 n14 n5 EdgeDirection=NW\n" +
                "ae e38 n5 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e39 n13 n10 EdgeDirection=N\n" +
                "ae e40 n13 n5 EdgeDirection=NE\n" +
                "ae e41 n13 n14 EdgeDirection=E\n" +
                "ae e42 n13 n12 EdgeDirection=W\n" +
                "ae e43 n13 n3 EdgeDirection=NW\n" +
                "ae e44 n5 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e45 n10 n7 EdgeDirection=N\n" +
                "ae e46 n10 n4 EdgeDirection=NE\n" +
                "ae e47 n10 n11 EdgeDirection=E\n" +
                "ae e48 n10 n5 EdgeDirection=SE\n" +
                "ae e49 n10 n13 EdgeDirection=S\n" +
                "ae e50 n10 n3 EdgeDirection=SW\n" +
                "ae e51 n10 n9 EdgeDirection=W\n" +
                "ae e52 n10 n2 EdgeDirection=NW\n" +
                "ae e53 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:I ui.class:I\n" +
                "ae e54 n3 n10 EdgeDirection=NE\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e55 n10 n7 EdgeDirection=N\n" +
                "ae e56 n10 n4 EdgeDirection=NE\n" +
                "ae e57 n10 n11 EdgeDirection=E\n" +
                "ae e58 n10 n5 EdgeDirection=SE\n" +
                "ae e59 n10 n13 EdgeDirection=S\n" +
                "ae e60 n10 n3 EdgeDirection=SW\n" +
                "ae e61 n10 n9 EdgeDirection=W\n" +
                "ae e62 n10 n2 EdgeDirection=NW\n" +
                "ae e63 n3 n13 EdgeDirection=SE\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e64 n13 n10 EdgeDirection=N\n" +
                "ae e65 n13 n5 EdgeDirection=NE\n" +
                "ae e66 n13 n14 EdgeDirection=E\n" +
                "ae e67 n13 n12 EdgeDirection=W\n" +
                "ae e68 n13 n3 EdgeDirection=NW\n" +
                "ae e69 n3 n12 EdgeDirection=SW\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e70 n12 n9 EdgeDirection=N\n" +
                "ae e71 n12 n3 EdgeDirection=NE\n" +
                "ae e72 n12 n13 EdgeDirection=E\n" +
                "ae e73 n3 n9 EdgeDirection=NW\n" +
                "an n9 label:E ui.class:E\n" +
                "ae e74 n9 n6 EdgeDirection=N\n" +
                "ae e75 n9 n2 EdgeDirection=NE\n" +
                "ae e76 n9 n10 EdgeDirection=E\n" +
                "ae e77 n9 n3 EdgeDirection=SE\n" +
                "ae e78 n9 n12 EdgeDirection=S\n" +
                "ae e79 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:I ui.class:I\n" +
                "ae e80 n2 n7 EdgeDirection=NE\n" +
                "an n7 label:E ui.class:E\n" +
                "ae e81 n7 n8 EdgeDirection=E\n" +
                "ae e82 n7 n4 EdgeDirection=SE\n" +
                "ae e83 n7 n10 EdgeDirection=S\n" +
                "ae e84 n7 n2 EdgeDirection=SW\n" +
                "ae e85 n7 n6 EdgeDirection=W\n" +
                "ae e86 n2 n10 EdgeDirection=SE\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e87 n10 n7 EdgeDirection=N\n" +
                "ae e88 n10 n4 EdgeDirection=NE\n" +
                "ae e89 n10 n11 EdgeDirection=E\n" +
                "ae e90 n10 n5 EdgeDirection=SE\n" +
                "ae e91 n10 n13 EdgeDirection=S\n" +
                "ae e92 n10 n3 EdgeDirection=SW\n" +
                "ae e93 n10 n9 EdgeDirection=W\n" +
                "ae e94 n10 n2 EdgeDirection=NW\n" +
                "ae e95 n2 n9 EdgeDirection=SW\n" +
                "an n9 label:E ui.class:E\n" +
                "ae e96 n9 n6 EdgeDirection=N\n" +
                "ae e97 n9 n2 EdgeDirection=NE\n" +
                "ae e98 n9 n10 EdgeDirection=E\n" +
                "ae e99 n9 n3 EdgeDirection=SE\n" +
                "ae e100 n9 n12 EdgeDirection=S\n" +
                "ae e101 n2 n6 EdgeDirection=NW\n" +
                "an n6 label:E ui.class:E\n" +
                "ae e102 n6 n7 EdgeDirection=E\n" +
                "ae e103 n6 n2 EdgeDirection=SE\n" +
                "ae e104 n6 n9 EdgeDirection=S\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testP2Serialization() throws Exception {
        Vertex vertex = P2Test.prepareInitialGraph();
        P2 p2 = new P2();
        p2.apply(vertex);

        String expected = "an n1 label:E ui.class:E\n" +
                "ae e1 n1 n2 EdgeDirection=NE\n" +
                "an n2 label:I ui.class:I\n" +
                "ae e2 n2 n4 EdgeDirection=NE\n" +
                "an n4 label:I ui.class:I\n" +
                "ae e3 n4 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e4 n11 n6 EdgeDirection=SE\n" +
                "ae e5 n11 n12 EdgeDirection=S\n" +
                "ae e6 n11 n4 EdgeDirection=SW\n" +
                "ae e7 n4 n12 EdgeDirection=SE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e8 n12 n11 EdgeDirection=N\n" +
                "ae e9 n12 n6 EdgeDirection=NE\n" +
                "ae e10 n12 n7 EdgeDirection=SE\n" +
                "ae e11 n12 n13 EdgeDirection=S\n" +
                "ae e12 n12 n5 EdgeDirection=SW\n" +
                "ae e13 n12 n4 EdgeDirection=NW\n" +
                "ae e14 n2 n5 EdgeDirection=SE\n" +
                "an n5 label:I ui.class:I\n" +
                "ae e15 n5 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e16 n12 n11 EdgeDirection=N\n" +
                "ae e17 n12 n6 EdgeDirection=NE\n" +
                "ae e18 n12 n7 EdgeDirection=SE\n" +
                "ae e19 n12 n13 EdgeDirection=S\n" +
                "ae e20 n12 n5 EdgeDirection=SW\n" +
                "ae e21 n12 n4 EdgeDirection=NW\n" +
                "ae e22 n5 n13 EdgeDirection=SE\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e23 n13 n12 EdgeDirection=N\n" +
                "ae e24 n13 n7 EdgeDirection=NE\n" +
                "ae e25 n13 n5 EdgeDirection=NW\n" +
                "ae e26 n1 n3 EdgeDirection=SW\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testP3Serialization() throws Exception {
        Vertex vertex = P3Test.prepareInitialGraph();
        P3 p3 = new P3();
        p3.apply(vertex);

        String expected = "an n1 label:E ui.class:E\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:I ui.class:I\n" +
                "ae e2 n3 n6 EdgeDirection=NE\n" +
                "an n6 label:I ui.class:I\n" +
                "ae e3 n6 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e4 n12 n5 EdgeDirection=NE\n" +
                "ae e5 n12 n13 EdgeDirection=E\n" +
                "ae e6 n12 n7 EdgeDirection=SE\n" +
                "ae e7 n12 n6 EdgeDirection=SW\n" +
                "ae e8 n12 n11 EdgeDirection=W\n" +
                "ae e9 n12 n4 EdgeDirection=NW\n" +
                "ae e10 n6 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e11 n11 n4 EdgeDirection=NE\n" +
                "ae e12 n11 n12 EdgeDirection=E\n" +
                "ae e13 n11 n6 EdgeDirection=SE\n" +
                "ae e14 n3 n7 EdgeDirection=NW\n" +
                "an n7 label:I ui.class:I\n" +
                "ae e15 n7 n13 EdgeDirection=NE\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e16 n13 n7 EdgeDirection=SW\n" +
                "ae e17 n13 n12 EdgeDirection=W\n" +
                "ae e18 n13 n5 EdgeDirection=NW\n" +
                "ae e19 n7 n12 EdgeDirection=NW\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e20 n12 n5 EdgeDirection=NE\n" +
                "ae e21 n12 n13 EdgeDirection=E\n" +
                "ae e22 n12 n7 EdgeDirection=SE\n" +
                "ae e23 n12 n6 EdgeDirection=SW\n" +
                "ae e24 n12 n11 EdgeDirection=W\n" +
                "ae e25 n12 n4 EdgeDirection=NW\n" +
                "ae e26 n1 n2 EdgeDirection=NW\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testMultipleProductions() throws Exception {
        Production p0 = new P0();
        Production p1 = new P1();
        Production p2 = new P2();
        Production p3 = new P3();

        Vertex vertex = Vertex.withoutParent(VertexLabel.I);
        p0.apply(vertex);
        p1.apply(vertex);

        Map<EdgeDirection, Vertex> vertexChildrenEdges = vertex.getChildrenEdges();
        for (EdgeDirection edgeDirection : EdgeDirection.values()) {
            if (vertexChildrenEdges.containsKey(edgeDirection)) {
                Vertex childVertex = vertexChildrenEdges.get(edgeDirection);

                if (childVertex.getParentDirection() != EdgeDirection.NW) {
                    p1.apply(childVertex);
                }
            }
        }

        p2.apply(vertex);
        p3.apply(vertex);

        String expected = "an n1 label:i ui.class:i\n" +
                "ae e1 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e2 n4 n5 EdgeDirection=S\n" +
                "ae e3 n4 n1 EdgeDirection=SW\n" +
                "ae e4 n4 n2 EdgeDirection=W\n" +
                "ae e5 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e6 n5 n4 EdgeDirection=N\n" +
                "ae e7 n5 n3 EdgeDirection=W\n" +
                "ae e8 n5 n1 EdgeDirection=NW\n" +
                "ae e9 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class:E\n" +
                "ae e10 n3 n2 EdgeDirection=N\n" +
                "ae e11 n3 n1 EdgeDirection=NE\n" +
                "ae e12 n3 n5 EdgeDirection=E\n" +
                "ae e13 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class:E\n" +
                "ae e14 n2 n4 EdgeDirection=E\n" +
                "ae e15 n2 n1 EdgeDirection=SE\n" +
                "ae e16 n2 n3 EdgeDirection=S\n" +
                "ae e17 n1 n8 EdgeDirection=NE\n" +
                "an n8 label:i ui.class:i\n" +
                "ae e18 n8 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e19 n12 n15 EdgeDirection=S\n" +
                "ae e20 n12 n8 EdgeDirection=SW\n" +
                "ae e21 n12 n11 EdgeDirection=W\n" +
                "ae e22 n8 n15 EdgeDirection=SE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e23 n15 n12 EdgeDirection=N\n" +
                "ae e24 n15 n18 EdgeDirection=S\n" +
                "ae e25 n15 n9 EdgeDirection=SW\n" +
                "ae e26 n15 n14 EdgeDirection=W\n" +
                "ae e27 n15 n8 EdgeDirection=NW\n" +
                "ae e28 n8 n14 EdgeDirection=SW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e29 n14 n11 EdgeDirection=N\n" +
                "ae e30 n14 n8 EdgeDirection=NE\n" +
                "ae e31 n14 n15 EdgeDirection=E\n" +
                "ae e32 n14 n9 EdgeDirection=SE\n" +
                "ae e33 n14 n17 EdgeDirection=S\n" +
                "ae e34 n14 n7 EdgeDirection=SW\n" +
                "ae e35 n14 n13 EdgeDirection=W\n" +
                "ae e36 n14 n6 EdgeDirection=NW\n" +
                "ae e37 n8 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e38 n11 n12 EdgeDirection=E\n" +
                "ae e39 n11 n8 EdgeDirection=SE\n" +
                "ae e40 n11 n14 EdgeDirection=S\n" +
                "ae e41 n11 n6 EdgeDirection=SW\n" +
                "ae e42 n11 n10 EdgeDirection=W\n" +
                "ae e43 n8 n21 EdgeDirection=NE\n" +
                "an n21 label:I ui.class:I\n" +
                "ae e44 n21 n36 EdgeDirection=NE\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e45 n36 n37 EdgeDirection=E\n" +
                "ae e46 n36 n32 EdgeDirection=SE\n" +
                "ae e47 n36 n39 EdgeDirection=S\n" +
                "ae e48 n36 n21 EdgeDirection=SW\n" +
                "ae e49 n21 n39 EdgeDirection=SE\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e50 n39 n36 EdgeDirection=N\n" +
                "ae e51 n39 n32 EdgeDirection=NE\n" +
                "ae e52 n39 n40 EdgeDirection=E\n" +
                "ae e53 n39 n33 EdgeDirection=SE\n" +
                "ae e54 n39 n42 EdgeDirection=S\n" +
                "ae e55 n39 n22 EdgeDirection=SW\n" +
                "ae e56 n39 n21 EdgeDirection=NW\n" +
                "ae e57 n21 n27 EdgeDirection=SW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e58 n27 n24 EdgeDirection=N\n" +
                "ae e59 n27 n21 EdgeDirection=NE\n" +
                "ae e60 n27 n28 EdgeDirection=E\n" +
                "ae e61 n27 n22 EdgeDirection=SE\n" +
                "ae e62 n27 n30 EdgeDirection=S\n" +
                "ae e63 n27 n20 EdgeDirection=SW\n" +
                "ae e64 n27 n26 EdgeDirection=W\n" +
                "ae e65 n27 n19 EdgeDirection=NW\n" +
                "ae e66 n21 n24 EdgeDirection=NW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e67 n24 n25 EdgeDirection=E\n" +
                "ae e68 n24 n21 EdgeDirection=SE\n" +
                "ae e69 n24 n27 EdgeDirection=S\n" +
                "ae e70 n24 n19 EdgeDirection=SW\n" +
                "ae e71 n24 n23 EdgeDirection=W\n" +
                "ae e72 n8 n22 EdgeDirection=SE\n" +
                "an n22 label:I ui.class:I\n" +
                "ae e73 n22 n39 EdgeDirection=NE\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e74 n39 n36 EdgeDirection=N\n" +
                "ae e75 n39 n32 EdgeDirection=NE\n" +
                "ae e76 n39 n40 EdgeDirection=E\n" +
                "ae e77 n39 n33 EdgeDirection=SE\n" +
                "ae e78 n39 n42 EdgeDirection=S\n" +
                "ae e79 n39 n22 EdgeDirection=SW\n" +
                "ae e80 n39 n21 EdgeDirection=NW\n" +
                "ae e81 n22 n42 EdgeDirection=SE\n" +
                "an n42 label:E ui.class:E\n" +
                "ae e82 n42 n39 EdgeDirection=N\n" +
                "ae e83 n42 n33 EdgeDirection=NE\n" +
                "ae e84 n42 n43 EdgeDirection=E\n" +
                "ae e85 n42 n22 EdgeDirection=NW\n" +
                "ae e86 n22 n30 EdgeDirection=SW\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e87 n30 n27 EdgeDirection=N\n" +
                "ae e88 n30 n22 EdgeDirection=NE\n" +
                "ae e89 n30 n31 EdgeDirection=E\n" +
                "ae e90 n30 n29 EdgeDirection=W\n" +
                "ae e91 n30 n20 EdgeDirection=NW\n" +
                "ae e92 n22 n27 EdgeDirection=NW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e93 n27 n24 EdgeDirection=N\n" +
                "ae e94 n27 n21 EdgeDirection=NE\n" +
                "ae e95 n27 n28 EdgeDirection=E\n" +
                "ae e96 n27 n22 EdgeDirection=SE\n" +
                "ae e97 n27 n30 EdgeDirection=S\n" +
                "ae e98 n27 n20 EdgeDirection=SW\n" +
                "ae e99 n27 n26 EdgeDirection=W\n" +
                "ae e100 n27 n19 EdgeDirection=NW\n" +
                "ae e101 n8 n20 EdgeDirection=SW\n" +
                "an n20 label:I ui.class:I\n" +
                "ae e102 n20 n27 EdgeDirection=NE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e103 n27 n24 EdgeDirection=N\n" +
                "ae e104 n27 n21 EdgeDirection=NE\n" +
                "ae e105 n27 n28 EdgeDirection=E\n" +
                "ae e106 n27 n22 EdgeDirection=SE\n" +
                "ae e107 n27 n30 EdgeDirection=S\n" +
                "ae e108 n27 n20 EdgeDirection=SW\n" +
                "ae e109 n27 n26 EdgeDirection=W\n" +
                "ae e110 n27 n19 EdgeDirection=NW\n" +
                "ae e111 n20 n30 EdgeDirection=SE\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e112 n30 n27 EdgeDirection=N\n" +
                "ae e113 n30 n22 EdgeDirection=NE\n" +
                "ae e114 n30 n31 EdgeDirection=E\n" +
                "ae e115 n30 n29 EdgeDirection=W\n" +
                "ae e116 n30 n20 EdgeDirection=NW\n" +
                "ae e117 n20 n29 EdgeDirection=SW\n" +
                "an n29 label:E ui.class:E\n" +
                "ae e118 n29 n26 EdgeDirection=N\n" +
                "ae e119 n29 n20 EdgeDirection=NE\n" +
                "ae e120 n29 n30 EdgeDirection=E\n" +
                "ae e121 n20 n26 EdgeDirection=NW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e122 n26 n23 EdgeDirection=N\n" +
                "ae e123 n26 n19 EdgeDirection=NE\n" +
                "ae e124 n26 n27 EdgeDirection=E\n" +
                "ae e125 n26 n20 EdgeDirection=SE\n" +
                "ae e126 n26 n29 EdgeDirection=S\n" +
                "ae e127 n8 n19 EdgeDirection=NW\n" +
                "an n19 label:I ui.class:I\n" +
                "ae e128 n19 n24 EdgeDirection=NE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e129 n24 n25 EdgeDirection=E\n" +
                "ae e130 n24 n21 EdgeDirection=SE\n" +
                "ae e131 n24 n27 EdgeDirection=S\n" +
                "ae e132 n24 n19 EdgeDirection=SW\n" +
                "ae e133 n24 n23 EdgeDirection=W\n" +
                "ae e134 n19 n27 EdgeDirection=SE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e135 n27 n24 EdgeDirection=N\n" +
                "ae e136 n27 n21 EdgeDirection=NE\n" +
                "ae e137 n27 n28 EdgeDirection=E\n" +
                "ae e138 n27 n22 EdgeDirection=SE\n" +
                "ae e139 n27 n30 EdgeDirection=S\n" +
                "ae e140 n27 n20 EdgeDirection=SW\n" +
                "ae e141 n27 n26 EdgeDirection=W\n" +
                "ae e142 n27 n19 EdgeDirection=NW\n" +
                "ae e143 n19 n26 EdgeDirection=SW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e144 n26 n23 EdgeDirection=N\n" +
                "ae e145 n26 n19 EdgeDirection=NE\n" +
                "ae e146 n26 n27 EdgeDirection=E\n" +
                "ae e147 n26 n20 EdgeDirection=SE\n" +
                "ae e148 n26 n29 EdgeDirection=S\n" +
                "ae e149 n19 n23 EdgeDirection=NW\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e150 n23 n24 EdgeDirection=E\n" +
                "ae e151 n23 n19 EdgeDirection=SE\n" +
                "ae e152 n23 n26 EdgeDirection=S\n" +
                "ae e153 n1 n9 EdgeDirection=SE\n" +
                "an n9 label:I ui.class:I\n" +
                "ae e154 n9 n15 EdgeDirection=NE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e155 n15 n12 EdgeDirection=N\n" +
                "ae e156 n15 n18 EdgeDirection=S\n" +
                "ae e157 n15 n9 EdgeDirection=SW\n" +
                "ae e158 n15 n14 EdgeDirection=W\n" +
                "ae e159 n15 n8 EdgeDirection=NW\n" +
                "ae e160 n9 n18 EdgeDirection=SE\n" +
                "an n18 label:E ui.class:E\n" +
                "ae e161 n18 n15 EdgeDirection=N\n" +
                "ae e162 n18 n17 EdgeDirection=W\n" +
                "ae e163 n18 n9 EdgeDirection=NW\n" +
                "ae e164 n9 n17 EdgeDirection=SW\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e165 n17 n14 EdgeDirection=N\n" +
                "ae e166 n17 n9 EdgeDirection=NE\n" +
                "ae e167 n17 n18 EdgeDirection=E\n" +
                "ae e168 n17 n16 EdgeDirection=W\n" +
                "ae e169 n17 n7 EdgeDirection=NW\n" +
                "ae e170 n9 n14 EdgeDirection=NW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e171 n14 n11 EdgeDirection=N\n" +
                "ae e172 n14 n8 EdgeDirection=NE\n" +
                "ae e173 n14 n15 EdgeDirection=E\n" +
                "ae e174 n14 n9 EdgeDirection=SE\n" +
                "ae e175 n14 n17 EdgeDirection=S\n" +
                "ae e176 n14 n7 EdgeDirection=SW\n" +
                "ae e177 n14 n13 EdgeDirection=W\n" +
                "ae e178 n14 n6 EdgeDirection=NW\n" +
                "ae e179 n1 n7 EdgeDirection=SW\n" +
                "an n7 label:i ui.class:i\n" +
                "ae e180 n7 n14 EdgeDirection=NE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e181 n14 n11 EdgeDirection=N\n" +
                "ae e182 n14 n8 EdgeDirection=NE\n" +
                "ae e183 n14 n15 EdgeDirection=E\n" +
                "ae e184 n14 n9 EdgeDirection=SE\n" +
                "ae e185 n14 n17 EdgeDirection=S\n" +
                "ae e186 n14 n7 EdgeDirection=SW\n" +
                "ae e187 n14 n13 EdgeDirection=W\n" +
                "ae e188 n14 n6 EdgeDirection=NW\n" +
                "ae e189 n7 n17 EdgeDirection=SE\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e190 n17 n14 EdgeDirection=N\n" +
                "ae e191 n17 n9 EdgeDirection=NE\n" +
                "ae e192 n17 n18 EdgeDirection=E\n" +
                "ae e193 n17 n16 EdgeDirection=W\n" +
                "ae e194 n17 n7 EdgeDirection=NW\n" +
                "ae e195 n7 n16 EdgeDirection=SW\n" +
                "an n16 label:E ui.class:E\n" +
                "ae e196 n16 n13 EdgeDirection=N\n" +
                "ae e197 n16 n7 EdgeDirection=NE\n" +
                "ae e198 n16 n17 EdgeDirection=E\n" +
                "ae e199 n7 n13 EdgeDirection=NW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e200 n13 n10 EdgeDirection=N\n" +
                "ae e201 n13 n6 EdgeDirection=NE\n" +
                "ae e202 n13 n14 EdgeDirection=E\n" +
                "ae e203 n13 n7 EdgeDirection=SE\n" +
                "ae e204 n13 n16 EdgeDirection=S\n" +
                "ae e205 n7 n34 EdgeDirection=NE\n" +
                "an n34 label:I ui.class:I\n" +
                "ae e206 n34 n38 EdgeDirection=NE\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e207 n38 n48 EdgeDirection=NE\n" +
                "ae e208 n38 n41 EdgeDirection=S\n" +
                "ae e209 n38 n34 EdgeDirection=SW\n" +
                "ae e210 n38 n37 EdgeDirection=W\n" +
                "ae e211 n38 n46 EdgeDirection=NW\n" +
                "ae e212 n34 n41 EdgeDirection=SE\n" +
                "an n41 label:E ui.class:E\n" +
                "ae e213 n41 n38 EdgeDirection=N\n" +
                "ae e214 n41 n44 EdgeDirection=S\n" +
                "ae e215 n41 n35 EdgeDirection=SW\n" +
                "ae e216 n41 n40 EdgeDirection=W\n" +
                "ae e217 n41 n34 EdgeDirection=NW\n" +
                "ae e218 n34 n40 EdgeDirection=SW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e219 n40 n37 EdgeDirection=N\n" +
                "ae e220 n40 n34 EdgeDirection=NE\n" +
                "ae e221 n40 n41 EdgeDirection=E\n" +
                "ae e222 n40 n35 EdgeDirection=SE\n" +
                "ae e223 n40 n43 EdgeDirection=S\n" +
                "ae e224 n40 n33 EdgeDirection=SW\n" +
                "ae e225 n40 n39 EdgeDirection=W\n" +
                "ae e226 n40 n32 EdgeDirection=NW\n" +
                "ae e227 n34 n37 EdgeDirection=NW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e228 n37 n46 EdgeDirection=NE\n" +
                "ae e229 n37 n38 EdgeDirection=E\n" +
                "ae e230 n37 n34 EdgeDirection=SE\n" +
                "ae e231 n37 n40 EdgeDirection=S\n" +
                "ae e232 n37 n32 EdgeDirection=SW\n" +
                "ae e233 n37 n36 EdgeDirection=W\n" +
                "ae e234 n37 n48 EdgeDirection=NW\n" +
                "ae e235 n7 n35 EdgeDirection=SE\n" +
                "an n35 label:I ui.class:I\n" +
                "ae e236 n35 n41 EdgeDirection=NE\n" +
                "an n41 label:E ui.class:E\n" +
                "ae e237 n41 n38 EdgeDirection=N\n" +
                "ae e238 n41 n44 EdgeDirection=S\n" +
                "ae e239 n41 n35 EdgeDirection=SW\n" +
                "ae e240 n41 n40 EdgeDirection=W\n" +
                "ae e241 n41 n34 EdgeDirection=NW\n" +
                "ae e242 n35 n44 EdgeDirection=SE\n" +
                "an n44 label:E ui.class:E\n" +
                "ae e243 n44 n41 EdgeDirection=N\n" +
                "ae e244 n44 n43 EdgeDirection=W\n" +
                "ae e245 n44 n35 EdgeDirection=NW\n" +
                "ae e246 n35 n43 EdgeDirection=SW\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e247 n43 n40 EdgeDirection=N\n" +
                "ae e248 n43 n35 EdgeDirection=NE\n" +
                "ae e249 n43 n44 EdgeDirection=E\n" +
                "ae e250 n43 n42 EdgeDirection=W\n" +
                "ae e251 n43 n33 EdgeDirection=NW\n" +
                "ae e252 n35 n40 EdgeDirection=NW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e253 n40 n37 EdgeDirection=N\n" +
                "ae e254 n40 n34 EdgeDirection=NE\n" +
                "ae e255 n40 n41 EdgeDirection=E\n" +
                "ae e256 n40 n35 EdgeDirection=SE\n" +
                "ae e257 n40 n43 EdgeDirection=S\n" +
                "ae e258 n40 n33 EdgeDirection=SW\n" +
                "ae e259 n40 n39 EdgeDirection=W\n" +
                "ae e260 n40 n32 EdgeDirection=NW\n" +
                "ae e261 n7 n33 EdgeDirection=SW\n" +
                "an n33 label:I ui.class:I\n" +
                "ae e262 n33 n40 EdgeDirection=NE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e263 n40 n37 EdgeDirection=N\n" +
                "ae e264 n40 n34 EdgeDirection=NE\n" +
                "ae e265 n40 n41 EdgeDirection=E\n" +
                "ae e266 n40 n35 EdgeDirection=SE\n" +
                "ae e267 n40 n43 EdgeDirection=S\n" +
                "ae e268 n40 n33 EdgeDirection=SW\n" +
                "ae e269 n40 n39 EdgeDirection=W\n" +
                "ae e270 n40 n32 EdgeDirection=NW\n" +
                "ae e271 n33 n43 EdgeDirection=SE\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e272 n43 n40 EdgeDirection=N\n" +
                "ae e273 n43 n35 EdgeDirection=NE\n" +
                "ae e274 n43 n44 EdgeDirection=E\n" +
                "ae e275 n43 n42 EdgeDirection=W\n" +
                "ae e276 n43 n33 EdgeDirection=NW\n" +
                "ae e277 n33 n42 EdgeDirection=SW\n" +
                "an n42 label:E ui.class:E\n" +
                "ae e278 n42 n39 EdgeDirection=N\n" +
                "ae e279 n42 n33 EdgeDirection=NE\n" +
                "ae e280 n42 n43 EdgeDirection=E\n" +
                "ae e281 n42 n22 EdgeDirection=NW\n" +
                "ae e282 n33 n39 EdgeDirection=NW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e283 n39 n36 EdgeDirection=N\n" +
                "ae e284 n39 n32 EdgeDirection=NE\n" +
                "ae e285 n39 n40 EdgeDirection=E\n" +
                "ae e286 n39 n33 EdgeDirection=SE\n" +
                "ae e287 n39 n42 EdgeDirection=S\n" +
                "ae e288 n39 n22 EdgeDirection=SW\n" +
                "ae e289 n39 n21 EdgeDirection=NW\n" +
                "ae e290 n7 n32 EdgeDirection=NW\n" +
                "an n32 label:I ui.class:I\n" +
                "ae e291 n32 n37 EdgeDirection=NE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e292 n37 n46 EdgeDirection=NE\n" +
                "ae e293 n37 n38 EdgeDirection=E\n" +
                "ae e294 n37 n34 EdgeDirection=SE\n" +
                "ae e295 n37 n40 EdgeDirection=S\n" +
                "ae e296 n37 n32 EdgeDirection=SW\n" +
                "ae e297 n37 n36 EdgeDirection=W\n" +
                "ae e298 n37 n48 EdgeDirection=NW\n" +
                "ae e299 n32 n40 EdgeDirection=SE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e300 n40 n37 EdgeDirection=N\n" +
                "ae e301 n40 n34 EdgeDirection=NE\n" +
                "ae e302 n40 n41 EdgeDirection=E\n" +
                "ae e303 n40 n35 EdgeDirection=SE\n" +
                "ae e304 n40 n43 EdgeDirection=S\n" +
                "ae e305 n40 n33 EdgeDirection=SW\n" +
                "ae e306 n40 n39 EdgeDirection=W\n" +
                "ae e307 n40 n32 EdgeDirection=NW\n" +
                "ae e308 n32 n39 EdgeDirection=SW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e309 n39 n36 EdgeDirection=N\n" +
                "ae e310 n39 n32 EdgeDirection=NE\n" +
                "ae e311 n39 n40 EdgeDirection=E\n" +
                "ae e312 n39 n33 EdgeDirection=SE\n" +
                "ae e313 n39 n42 EdgeDirection=S\n" +
                "ae e314 n39 n22 EdgeDirection=SW\n" +
                "ae e315 n39 n21 EdgeDirection=NW\n" +
                "ae e316 n32 n36 EdgeDirection=NW\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e317 n36 n37 EdgeDirection=E\n" +
                "ae e318 n36 n32 EdgeDirection=SE\n" +
                "ae e319 n36 n39 EdgeDirection=S\n" +
                "ae e320 n36 n21 EdgeDirection=SW\n" +
                "ae e321 n1 n6 EdgeDirection=NW\n" +
                "an n6 label:i ui.class:i\n" +
                "ae e322 n6 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e323 n11 n12 EdgeDirection=E\n" +
                "ae e324 n11 n8 EdgeDirection=SE\n" +
                "ae e325 n11 n14 EdgeDirection=S\n" +
                "ae e326 n11 n6 EdgeDirection=SW\n" +
                "ae e327 n11 n10 EdgeDirection=W\n" +
                "ae e328 n6 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e329 n14 n11 EdgeDirection=N\n" +
                "ae e330 n14 n8 EdgeDirection=NE\n" +
                "ae e331 n14 n15 EdgeDirection=E\n" +
                "ae e332 n14 n9 EdgeDirection=SE\n" +
                "ae e333 n14 n17 EdgeDirection=S\n" +
                "ae e334 n14 n7 EdgeDirection=SW\n" +
                "ae e335 n14 n13 EdgeDirection=W\n" +
                "ae e336 n14 n6 EdgeDirection=NW\n" +
                "ae e337 n6 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e338 n13 n10 EdgeDirection=N\n" +
                "ae e339 n13 n6 EdgeDirection=NE\n" +
                "ae e340 n13 n14 EdgeDirection=E\n" +
                "ae e341 n13 n7 EdgeDirection=SE\n" +
                "ae e342 n13 n16 EdgeDirection=S\n" +
                "ae e343 n6 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e344 n10 n11 EdgeDirection=E\n" +
                "ae e345 n10 n6 EdgeDirection=SE\n" +
                "ae e346 n10 n13 EdgeDirection=S\n" +
                "ae e347 n6 n47 EdgeDirection=NE\n" +
                "an n47 label:I ui.class:I\n" +
                "ae e348 n47 n51 EdgeDirection=NE\n" +
                "an n51 label:E ui.class:E\n" +
                "ae e349 n51 n54 EdgeDirection=S\n" +
                "ae e350 n51 n47 EdgeDirection=SW\n" +
                "ae e351 n51 n50 EdgeDirection=W\n" +
                "ae e352 n47 n54 EdgeDirection=SE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e353 n54 n51 EdgeDirection=N\n" +
                "ae e354 n54 n57 EdgeDirection=S\n" +
                "ae e355 n54 n48 EdgeDirection=SW\n" +
                "ae e356 n54 n53 EdgeDirection=W\n" +
                "ae e357 n54 n47 EdgeDirection=NW\n" +
                "ae e358 n47 n53 EdgeDirection=SW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e359 n53 n50 EdgeDirection=N\n" +
                "ae e360 n53 n47 EdgeDirection=NE\n" +
                "ae e361 n53 n54 EdgeDirection=E\n" +
                "ae e362 n53 n48 EdgeDirection=SE\n" +
                "ae e363 n53 n56 EdgeDirection=S\n" +
                "ae e364 n53 n46 EdgeDirection=SW\n" +
                "ae e365 n53 n52 EdgeDirection=W\n" +
                "ae e366 n53 n45 EdgeDirection=NW\n" +
                "ae e367 n47 n50 EdgeDirection=NW\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e368 n50 n51 EdgeDirection=E\n" +
                "ae e369 n50 n47 EdgeDirection=SE\n" +
                "ae e370 n50 n53 EdgeDirection=S\n" +
                "ae e371 n50 n45 EdgeDirection=SW\n" +
                "ae e372 n50 n49 EdgeDirection=W\n" +
                "ae e373 n6 n48 EdgeDirection=SE\n" +
                "an n48 label:I ui.class:I\n" +
                "ae e374 n48 n54 EdgeDirection=NE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e375 n54 n51 EdgeDirection=N\n" +
                "ae e376 n54 n57 EdgeDirection=S\n" +
                "ae e377 n54 n48 EdgeDirection=SW\n" +
                "ae e378 n54 n53 EdgeDirection=W\n" +
                "ae e379 n54 n47 EdgeDirection=NW\n" +
                "ae e380 n48 n37 EdgeDirection=SE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e381 n37 n46 EdgeDirection=NE\n" +
                "ae e382 n37 n38 EdgeDirection=E\n" +
                "ae e383 n37 n34 EdgeDirection=SE\n" +
                "ae e384 n37 n40 EdgeDirection=S\n" +
                "ae e385 n37 n32 EdgeDirection=SW\n" +
                "ae e386 n37 n36 EdgeDirection=W\n" +
                "ae e387 n37 n48 EdgeDirection=NW\n" +
                "ae e388 n48 n38 EdgeDirection=SW\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e389 n38 n48 EdgeDirection=NE\n" +
                "ae e390 n38 n41 EdgeDirection=S\n" +
                "ae e391 n38 n34 EdgeDirection=SW\n" +
                "ae e392 n38 n37 EdgeDirection=W\n" +
                "ae e393 n38 n46 EdgeDirection=NW\n" +
                "ae e394 n48 n53 EdgeDirection=NW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e395 n53 n50 EdgeDirection=N\n" +
                "ae e396 n53 n47 EdgeDirection=NE\n" +
                "ae e397 n53 n54 EdgeDirection=E\n" +
                "ae e398 n53 n48 EdgeDirection=SE\n" +
                "ae e399 n53 n56 EdgeDirection=S\n" +
                "ae e400 n53 n46 EdgeDirection=SW\n" +
                "ae e401 n53 n52 EdgeDirection=W\n" +
                "ae e402 n53 n45 EdgeDirection=NW\n" +
                "ae e403 n6 n46 EdgeDirection=SW\n" +
                "an n46 label:I ui.class:I\n" +
                "ae e404 n46 n53 EdgeDirection=NE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e405 n53 n50 EdgeDirection=N\n" +
                "ae e406 n53 n47 EdgeDirection=NE\n" +
                "ae e407 n53 n54 EdgeDirection=E\n" +
                "ae e408 n53 n48 EdgeDirection=SE\n" +
                "ae e409 n53 n56 EdgeDirection=S\n" +
                "ae e410 n53 n46 EdgeDirection=SW\n" +
                "ae e411 n53 n52 EdgeDirection=W\n" +
                "ae e412 n53 n45 EdgeDirection=NW\n" +
                "ae e413 n46 n38 EdgeDirection=SE\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e414 n38 n48 EdgeDirection=NE\n" +
                "ae e415 n38 n41 EdgeDirection=S\n" +
                "ae e416 n38 n34 EdgeDirection=SW\n" +
                "ae e417 n38 n37 EdgeDirection=W\n" +
                "ae e418 n38 n46 EdgeDirection=NW\n" +
                "ae e419 n46 n37 EdgeDirection=SW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e420 n37 n46 EdgeDirection=NE\n" +
                "ae e421 n37 n38 EdgeDirection=E\n" +
                "ae e422 n37 n34 EdgeDirection=SE\n" +
                "ae e423 n37 n40 EdgeDirection=S\n" +
                "ae e424 n37 n32 EdgeDirection=SW\n" +
                "ae e425 n37 n36 EdgeDirection=W\n" +
                "ae e426 n37 n48 EdgeDirection=NW\n" +
                "ae e427 n46 n52 EdgeDirection=NW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e428 n52 n49 EdgeDirection=N\n" +
                "ae e429 n52 n45 EdgeDirection=NE\n" +
                "ae e430 n52 n53 EdgeDirection=E\n" +
                "ae e431 n52 n46 EdgeDirection=SE\n" +
                "ae e432 n52 n55 EdgeDirection=S\n" +
                "ae e433 n6 n45 EdgeDirection=NW\n" +
                "an n45 label:I ui.class:I\n" +
                "ae e434 n45 n50 EdgeDirection=NE\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e435 n50 n51 EdgeDirection=E\n" +
                "ae e436 n50 n47 EdgeDirection=SE\n" +
                "ae e437 n50 n53 EdgeDirection=S\n" +
                "ae e438 n50 n45 EdgeDirection=SW\n" +
                "ae e439 n50 n49 EdgeDirection=W\n" +
                "ae e440 n45 n53 EdgeDirection=SE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e441 n53 n50 EdgeDirection=N\n" +
                "ae e442 n53 n47 EdgeDirection=NE\n" +
                "ae e443 n53 n54 EdgeDirection=E\n" +
                "ae e444 n53 n48 EdgeDirection=SE\n" +
                "ae e445 n53 n56 EdgeDirection=S\n" +
                "ae e446 n53 n46 EdgeDirection=SW\n" +
                "ae e447 n53 n52 EdgeDirection=W\n" +
                "ae e448 n53 n45 EdgeDirection=NW\n" +
                "ae e449 n45 n52 EdgeDirection=SW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e450 n52 n49 EdgeDirection=N\n" +
                "ae e451 n52 n45 EdgeDirection=NE\n" +
                "ae e452 n52 n53 EdgeDirection=E\n" +
                "ae e453 n52 n46 EdgeDirection=SE\n" +
                "ae e454 n52 n55 EdgeDirection=S\n" +
                "ae e455 n45 n49 EdgeDirection=NW\n" +
                "an n49 label:E ui.class:E\n" +
                "ae e456 n49 n50 EdgeDirection=E\n" +
                "ae e457 n49 n45 EdgeDirection=SE\n" +
                "ae e458 n49 n52 EdgeDirection=S\n";

        assertEquals(expected, vertex.serialize());
    }
}
