package edu.agh.gg.serialization;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.grammar.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class SerializerTest {
    @Before
    public void setUp() throws Exception {
        Serializer.reset();
    }

    @Test
    public void testP0Serialization() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);
        P0 p0 = new P0(vertex);
        p0.apply();

        String expected = "an n1 label:I ui.class:I\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class:E\n" +
                "ae e2 n3 n2 EdgeDirection=N\n" +
                "ae e3 n3 n1 EdgeDirection=NE\n" +
                "ae e4 n3 n5 EdgeDirection=E\n" +
                "ae e5 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e6 n4 n1 EdgeDirection=SW\n" +
                "ae e7 n4 n5 EdgeDirection=S\n" +
                "ae e8 n4 n2 EdgeDirection=W\n" +
                "ae e9 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e10 n5 n4 EdgeDirection=N\n" +
                "ae e11 n5 n3 EdgeDirection=W\n" +
                "ae e12 n5 n1 EdgeDirection=NW\n" +
                "ae e13 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class:E\n" +
                "ae e14 n2 n3 EdgeDirection=S\n" +
                "ae e15 n2 n4 EdgeDirection=E\n" +
                "ae e16 n2 n1 EdgeDirection=SE\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testP1Serialization() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);
        P1 p1 = new P1(vertex);
        p1.apply();

        String expected = "an n1 label:i ui.class:i\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:I ui.class:I\n" +
                "ae e2 n3 n12 EdgeDirection=SW\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e3 n12 n9 EdgeDirection=N\n" +
                "ae e4 n12 n3 EdgeDirection=NE\n" +
                "ae e5 n12 n13 EdgeDirection=E\n" +
                "ae e6 n3 n10 EdgeDirection=NE\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e7 n10 n3 EdgeDirection=SW\n" +
                "ae e8 n10 n13 EdgeDirection=S\n" +
                "ae e9 n10 n7 EdgeDirection=N\n" +
                "ae e10 n10 n4 EdgeDirection=NE\n" +
                "ae e11 n10 n11 EdgeDirection=E\n" +
                "ae e12 n10 n5 EdgeDirection=SE\n" +
                "ae e13 n10 n9 EdgeDirection=W\n" +
                "ae e14 n10 n2 EdgeDirection=NW\n" +
                "ae e15 n3 n13 EdgeDirection=SE\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e16 n13 n10 EdgeDirection=N\n" +
                "ae e17 n13 n5 EdgeDirection=NE\n" +
                "ae e18 n13 n14 EdgeDirection=E\n" +
                "ae e19 n13 n12 EdgeDirection=W\n" +
                "ae e20 n13 n3 EdgeDirection=NW\n" +
                "ae e21 n3 n9 EdgeDirection=NW\n" +
                "an n9 label:E ui.class:E\n" +
                "ae e22 n9 n12 EdgeDirection=S\n" +
                "ae e23 n9 n6 EdgeDirection=N\n" +
                "ae e24 n9 n2 EdgeDirection=NE\n" +
                "ae e25 n9 n10 EdgeDirection=E\n" +
                "ae e26 n9 n3 EdgeDirection=SE\n" +
                "ae e27 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:I ui.class:I\n" +
                "ae e28 n4 n10 EdgeDirection=SW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e29 n10 n3 EdgeDirection=SW\n" +
                "ae e30 n10 n13 EdgeDirection=S\n" +
                "ae e31 n10 n7 EdgeDirection=N\n" +
                "ae e32 n10 n4 EdgeDirection=NE\n" +
                "ae e33 n10 n11 EdgeDirection=E\n" +
                "ae e34 n10 n5 EdgeDirection=SE\n" +
                "ae e35 n10 n9 EdgeDirection=W\n" +
                "ae e36 n10 n2 EdgeDirection=NW\n" +
                "ae e37 n4 n8 EdgeDirection=NE\n" +
                "an n8 label:E ui.class:E\n" +
                "ae e38 n8 n4 EdgeDirection=SW\n" +
                "ae e39 n8 n11 EdgeDirection=S\n" +
                "ae e40 n8 n7 EdgeDirection=W\n" +
                "ae e41 n4 n11 EdgeDirection=SE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e42 n11 n5 EdgeDirection=SW\n" +
                "ae e43 n11 n14 EdgeDirection=S\n" +
                "ae e44 n11 n8 EdgeDirection=N\n" +
                "ae e45 n11 n10 EdgeDirection=W\n" +
                "ae e46 n11 n4 EdgeDirection=NW\n" +
                "ae e47 n4 n7 EdgeDirection=NW\n" +
                "an n7 label:E ui.class:E\n" +
                "ae e48 n7 n2 EdgeDirection=SW\n" +
                "ae e49 n7 n10 EdgeDirection=S\n" +
                "ae e50 n7 n8 EdgeDirection=E\n" +
                "ae e51 n7 n4 EdgeDirection=SE\n" +
                "ae e52 n7 n6 EdgeDirection=W\n" +
                "ae e53 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:I ui.class:I\n" +
                "ae e54 n5 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e55 n13 n10 EdgeDirection=N\n" +
                "ae e56 n13 n5 EdgeDirection=NE\n" +
                "ae e57 n13 n14 EdgeDirection=E\n" +
                "ae e58 n13 n12 EdgeDirection=W\n" +
                "ae e59 n13 n3 EdgeDirection=NW\n" +
                "ae e60 n5 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e61 n11 n5 EdgeDirection=SW\n" +
                "ae e62 n11 n14 EdgeDirection=S\n" +
                "ae e63 n11 n8 EdgeDirection=N\n" +
                "ae e64 n11 n10 EdgeDirection=W\n" +
                "ae e65 n11 n4 EdgeDirection=NW\n" +
                "ae e66 n5 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e67 n14 n11 EdgeDirection=N\n" +
                "ae e68 n14 n13 EdgeDirection=W\n" +
                "ae e69 n14 n5 EdgeDirection=NW\n" +
                "ae e70 n5 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e71 n10 n3 EdgeDirection=SW\n" +
                "ae e72 n10 n13 EdgeDirection=S\n" +
                "ae e73 n10 n7 EdgeDirection=N\n" +
                "ae e74 n10 n4 EdgeDirection=NE\n" +
                "ae e75 n10 n11 EdgeDirection=E\n" +
                "ae e76 n10 n5 EdgeDirection=SE\n" +
                "ae e77 n10 n9 EdgeDirection=W\n" +
                "ae e78 n10 n2 EdgeDirection=NW\n" +
                "ae e79 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:I ui.class:I\n" +
                "ae e80 n2 n9 EdgeDirection=SW\n" +
                "an n9 label:E ui.class:E\n" +
                "ae e81 n9 n12 EdgeDirection=S\n" +
                "ae e82 n9 n6 EdgeDirection=N\n" +
                "ae e83 n9 n2 EdgeDirection=NE\n" +
                "ae e84 n9 n10 EdgeDirection=E\n" +
                "ae e85 n9 n3 EdgeDirection=SE\n" +
                "ae e86 n2 n7 EdgeDirection=NE\n" +
                "an n7 label:E ui.class:E\n" +
                "ae e87 n7 n2 EdgeDirection=SW\n" +
                "ae e88 n7 n10 EdgeDirection=S\n" +
                "ae e89 n7 n8 EdgeDirection=E\n" +
                "ae e90 n7 n4 EdgeDirection=SE\n" +
                "ae e91 n7 n6 EdgeDirection=W\n" +
                "ae e92 n2 n10 EdgeDirection=SE\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e93 n10 n3 EdgeDirection=SW\n" +
                "ae e94 n10 n13 EdgeDirection=S\n" +
                "ae e95 n10 n7 EdgeDirection=N\n" +
                "ae e96 n10 n4 EdgeDirection=NE\n" +
                "ae e97 n10 n11 EdgeDirection=E\n" +
                "ae e98 n10 n5 EdgeDirection=SE\n" +
                "ae e99 n10 n9 EdgeDirection=W\n" +
                "ae e100 n10 n2 EdgeDirection=NW\n" +
                "ae e101 n2 n6 EdgeDirection=NW\n" +
                "an n6 label:E ui.class:E\n" +
                "ae e102 n6 n9 EdgeDirection=S\n" +
                "ae e103 n6 n7 EdgeDirection=E\n" +
                "ae e104 n6 n2 EdgeDirection=SE\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testP2Serialization() throws Exception {
        Vertex vertex = P2Test.prepareInitialGraph();
        P2 p2 = new P2(vertex);
        p2.apply();

        String expected = "an n1 label:E ui.class:E\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:I ui.class:I\n" +
                "ae e2 n3 n7 EdgeDirection=SW\n" +
                "an n7 label:I ui.class:I\n" +
                "ae e3 n7 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e4 n13 n12 EdgeDirection=N\n" +
                "ae e5 n13 n7 EdgeDirection=NE\n" +
                "ae e6 n13 n5 EdgeDirection=NW\n" +
                "ae e7 n7 n12 EdgeDirection=NW\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e8 n12 n5 EdgeDirection=SW\n" +
                "ae e9 n12 n13 EdgeDirection=S\n" +
                "ae e10 n12 n11 EdgeDirection=N\n" +
                "ae e11 n12 n6 EdgeDirection=NE\n" +
                "ae e12 n12 n7 EdgeDirection=SE\n" +
                "ae e13 n12 n4 EdgeDirection=NW\n" +
                "ae e14 n3 n6 EdgeDirection=NW\n" +
                "an n6 label:I ui.class:I\n" +
                "ae e15 n6 n12 EdgeDirection=SW\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e16 n12 n5 EdgeDirection=SW\n" +
                "ae e17 n12 n13 EdgeDirection=S\n" +
                "ae e18 n12 n11 EdgeDirection=N\n" +
                "ae e19 n12 n6 EdgeDirection=NE\n" +
                "ae e20 n12 n7 EdgeDirection=SE\n" +
                "ae e21 n12 n4 EdgeDirection=NW\n" +
                "ae e22 n6 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e23 n11 n4 EdgeDirection=SW\n" +
                "ae e24 n11 n12 EdgeDirection=S\n" +
                "ae e25 n11 n6 EdgeDirection=SE\n" +
                "ae e26 n1 n2 EdgeDirection=NE\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testP3Serialization() throws Exception {
        Vertex vertex = P3Test.prepareInitialGraph();
        P3 p3 = new P3(vertex);
        p3.apply();

        String expected = "an n1 label:E ui.class:E\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:I ui.class:I\n" +
                "ae e2 n3 n6 EdgeDirection=NE\n" +
                "an n6 label:I ui.class:I\n" +
                "ae e3 n6 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e4 n12 n6 EdgeDirection=SW\n" +
                "ae e5 n12 n5 EdgeDirection=NE\n" +
                "ae e6 n12 n13 EdgeDirection=E\n" +
                "ae e7 n12 n7 EdgeDirection=SE\n" +
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
                "ae e20 n12 n6 EdgeDirection=SW\n" +
                "ae e21 n12 n5 EdgeDirection=NE\n" +
                "ae e22 n12 n13 EdgeDirection=E\n" +
                "ae e23 n12 n7 EdgeDirection=SE\n" +
                "ae e24 n12 n11 EdgeDirection=W\n" +
                "ae e25 n12 n4 EdgeDirection=NW\n" +
                "ae e26 n1 n2 EdgeDirection=NW\n";

        assertEquals(expected, vertex.serialize());
    }

    @Test
    public void testMultipleProductions() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);

        Production p0 = new P0(vertex);
        Production p1 = new P1(vertex);
        Production p2 = new P2(vertex);
        Production p3 = new P3(vertex);

        p0.apply();
        p1.apply();

        Map<EdgeDirection, Vertex> childrenEdges = vertex.getChildrenEdges();
        Production p1a3 = new P1(childrenEdges.get(EdgeDirection.NW));
        Production p1a1 = new P1(childrenEdges.get(EdgeDirection.NE));
        Production p1a2 = new P1(childrenEdges.get(EdgeDirection.SW));

        p1a1.apply();
        p1a2.apply();
        p1a3.apply();

        p2.apply();
        p3.apply();

        String expected = "an n1 label:i ui.class:i\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class:E\n" +
                "ae e2 n3 n2 EdgeDirection=N\n" +
                "ae e3 n3 n1 EdgeDirection=NE\n" +
                "ae e4 n3 n5 EdgeDirection=E\n" +
                "ae e5 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e6 n4 n1 EdgeDirection=SW\n" +
                "ae e7 n4 n5 EdgeDirection=S\n" +
                "ae e8 n4 n2 EdgeDirection=W\n" +
                "ae e9 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e10 n5 n4 EdgeDirection=N\n" +
                "ae e11 n5 n3 EdgeDirection=W\n" +
                "ae e12 n5 n1 EdgeDirection=NW\n" +
                "ae e13 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class:E\n" +
                "ae e14 n2 n3 EdgeDirection=S\n" +
                "ae e15 n2 n4 EdgeDirection=E\n" +
                "ae e16 n2 n1 EdgeDirection=SE\n" +
                "ae e17 n1 n7 EdgeDirection=SW\n" +
                "an n7 label:i ui.class:i\n" +
                "ae e18 n7 n16 EdgeDirection=SW\n" +
                "an n16 label:E ui.class:E\n" +
                "ae e19 n16 n13 EdgeDirection=N\n" +
                "ae e20 n16 n7 EdgeDirection=NE\n" +
                "ae e21 n16 n17 EdgeDirection=E\n" +
                "ae e22 n7 n14 EdgeDirection=NE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e23 n14 n7 EdgeDirection=SW\n" +
                "ae e24 n14 n17 EdgeDirection=S\n" +
                "ae e25 n14 n11 EdgeDirection=N\n" +
                "ae e26 n14 n8 EdgeDirection=NE\n" +
                "ae e27 n14 n15 EdgeDirection=E\n" +
                "ae e28 n14 n9 EdgeDirection=SE\n" +
                "ae e29 n14 n13 EdgeDirection=W\n" +
                "ae e30 n14 n6 EdgeDirection=NW\n" +
                "ae e31 n7 n17 EdgeDirection=SE\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e32 n17 n14 EdgeDirection=N\n" +
                "ae e33 n17 n9 EdgeDirection=NE\n" +
                "ae e34 n17 n18 EdgeDirection=E\n" +
                "ae e35 n17 n16 EdgeDirection=W\n" +
                "ae e36 n17 n7 EdgeDirection=NW\n" +
                "ae e37 n7 n13 EdgeDirection=NW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e38 n13 n16 EdgeDirection=S\n" +
                "ae e39 n13 n10 EdgeDirection=N\n" +
                "ae e40 n13 n6 EdgeDirection=NE\n" +
                "ae e41 n13 n14 EdgeDirection=E\n" +
                "ae e42 n13 n7 EdgeDirection=SE\n" +
                "ae e43 n7 n33 EdgeDirection=SW\n" +
                "an n33 label:I ui.class:I\n" +
                "ae e44 n33 n42 EdgeDirection=SW\n" +
                "an n42 label:E ui.class:E\n" +
                "ae e45 n42 n39 EdgeDirection=N\n" +
                "ae e46 n42 n33 EdgeDirection=NE\n" +
                "ae e47 n42 n43 EdgeDirection=E\n" +
                "ae e48 n42 n22 EdgeDirection=NW\n" +
                "ae e49 n33 n40 EdgeDirection=NE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e50 n40 n33 EdgeDirection=SW\n" +
                "ae e51 n40 n43 EdgeDirection=S\n" +
                "ae e52 n40 n37 EdgeDirection=N\n" +
                "ae e53 n40 n34 EdgeDirection=NE\n" +
                "ae e54 n40 n41 EdgeDirection=E\n" +
                "ae e55 n40 n35 EdgeDirection=SE\n" +
                "ae e56 n40 n39 EdgeDirection=W\n" +
                "ae e57 n40 n32 EdgeDirection=NW\n" +
                "ae e58 n33 n43 EdgeDirection=SE\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e59 n43 n40 EdgeDirection=N\n" +
                "ae e60 n43 n35 EdgeDirection=NE\n" +
                "ae e61 n43 n44 EdgeDirection=E\n" +
                "ae e62 n43 n42 EdgeDirection=W\n" +
                "ae e63 n43 n33 EdgeDirection=NW\n" +
                "ae e64 n33 n39 EdgeDirection=NW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e65 n39 n22 EdgeDirection=SW\n" +
                "ae e66 n39 n42 EdgeDirection=S\n" +
                "ae e67 n39 n36 EdgeDirection=N\n" +
                "ae e68 n39 n32 EdgeDirection=NE\n" +
                "ae e69 n39 n40 EdgeDirection=E\n" +
                "ae e70 n39 n33 EdgeDirection=SE\n" +
                "ae e71 n39 n21 EdgeDirection=NW\n" +
                "ae e72 n7 n34 EdgeDirection=NE\n" +
                "an n34 label:I ui.class:I\n" +
                "ae e73 n34 n40 EdgeDirection=SW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e74 n40 n33 EdgeDirection=SW\n" +
                "ae e75 n40 n43 EdgeDirection=S\n" +
                "ae e76 n40 n37 EdgeDirection=N\n" +
                "ae e77 n40 n34 EdgeDirection=NE\n" +
                "ae e78 n40 n41 EdgeDirection=E\n" +
                "ae e79 n40 n35 EdgeDirection=SE\n" +
                "ae e80 n40 n39 EdgeDirection=W\n" +
                "ae e81 n40 n32 EdgeDirection=NW\n" +
                "ae e82 n34 n38 EdgeDirection=NE\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e83 n38 n34 EdgeDirection=SW\n" +
                "ae e84 n38 n41 EdgeDirection=S\n" +
                "ae e85 n38 n48 EdgeDirection=NE\n" +
                "ae e86 n38 n37 EdgeDirection=W\n" +
                "ae e87 n38 n46 EdgeDirection=NW\n" +
                "ae e88 n34 n41 EdgeDirection=SE\n" +
                "an n41 label:E ui.class:E\n" +
                "ae e89 n41 n35 EdgeDirection=SW\n" +
                "ae e90 n41 n44 EdgeDirection=S\n" +
                "ae e91 n41 n38 EdgeDirection=N\n" +
                "ae e92 n41 n40 EdgeDirection=W\n" +
                "ae e93 n41 n34 EdgeDirection=NW\n" +
                "ae e94 n34 n37 EdgeDirection=NW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e95 n37 n32 EdgeDirection=SW\n" +
                "ae e96 n37 n40 EdgeDirection=S\n" +
                "ae e97 n37 n46 EdgeDirection=NE\n" +
                "ae e98 n37 n38 EdgeDirection=E\n" +
                "ae e99 n37 n34 EdgeDirection=SE\n" +
                "ae e100 n37 n36 EdgeDirection=W\n" +
                "ae e101 n37 n48 EdgeDirection=NW\n" +
                "ae e102 n7 n35 EdgeDirection=SE\n" +
                "an n35 label:I ui.class:I\n" +
                "ae e103 n35 n43 EdgeDirection=SW\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e104 n43 n40 EdgeDirection=N\n" +
                "ae e105 n43 n35 EdgeDirection=NE\n" +
                "ae e106 n43 n44 EdgeDirection=E\n" +
                "ae e107 n43 n42 EdgeDirection=W\n" +
                "ae e108 n43 n33 EdgeDirection=NW\n" +
                "ae e109 n35 n41 EdgeDirection=NE\n" +
                "an n41 label:E ui.class:E\n" +
                "ae e110 n41 n35 EdgeDirection=SW\n" +
                "ae e111 n41 n44 EdgeDirection=S\n" +
                "ae e112 n41 n38 EdgeDirection=N\n" +
                "ae e113 n41 n40 EdgeDirection=W\n" +
                "ae e114 n41 n34 EdgeDirection=NW\n" +
                "ae e115 n35 n44 EdgeDirection=SE\n" +
                "an n44 label:E ui.class:E\n" +
                "ae e116 n44 n41 EdgeDirection=N\n" +
                "ae e117 n44 n43 EdgeDirection=W\n" +
                "ae e118 n44 n35 EdgeDirection=NW\n" +
                "ae e119 n35 n40 EdgeDirection=NW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e120 n40 n33 EdgeDirection=SW\n" +
                "ae e121 n40 n43 EdgeDirection=S\n" +
                "ae e122 n40 n37 EdgeDirection=N\n" +
                "ae e123 n40 n34 EdgeDirection=NE\n" +
                "ae e124 n40 n41 EdgeDirection=E\n" +
                "ae e125 n40 n35 EdgeDirection=SE\n" +
                "ae e126 n40 n39 EdgeDirection=W\n" +
                "ae e127 n40 n32 EdgeDirection=NW\n" +
                "ae e128 n7 n32 EdgeDirection=NW\n" +
                "an n32 label:I ui.class:I\n" +
                "ae e129 n32 n39 EdgeDirection=SW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e130 n39 n22 EdgeDirection=SW\n" +
                "ae e131 n39 n42 EdgeDirection=S\n" +
                "ae e132 n39 n36 EdgeDirection=N\n" +
                "ae e133 n39 n32 EdgeDirection=NE\n" +
                "ae e134 n39 n40 EdgeDirection=E\n" +
                "ae e135 n39 n33 EdgeDirection=SE\n" +
                "ae e136 n39 n21 EdgeDirection=NW\n" +
                "ae e137 n32 n37 EdgeDirection=NE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e138 n37 n32 EdgeDirection=SW\n" +
                "ae e139 n37 n40 EdgeDirection=S\n" +
                "ae e140 n37 n46 EdgeDirection=NE\n" +
                "ae e141 n37 n38 EdgeDirection=E\n" +
                "ae e142 n37 n34 EdgeDirection=SE\n" +
                "ae e143 n37 n36 EdgeDirection=W\n" +
                "ae e144 n37 n48 EdgeDirection=NW\n" +
                "ae e145 n32 n40 EdgeDirection=SE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e146 n40 n33 EdgeDirection=SW\n" +
                "ae e147 n40 n43 EdgeDirection=S\n" +
                "ae e148 n40 n37 EdgeDirection=N\n" +
                "ae e149 n40 n34 EdgeDirection=NE\n" +
                "ae e150 n40 n41 EdgeDirection=E\n" +
                "ae e151 n40 n35 EdgeDirection=SE\n" +
                "ae e152 n40 n39 EdgeDirection=W\n" +
                "ae e153 n40 n32 EdgeDirection=NW\n" +
                "ae e154 n32 n36 EdgeDirection=NW\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e155 n36 n21 EdgeDirection=SW\n" +
                "ae e156 n36 n39 EdgeDirection=S\n" +
                "ae e157 n36 n37 EdgeDirection=E\n" +
                "ae e158 n36 n32 EdgeDirection=SE\n" +
                "ae e159 n1 n8 EdgeDirection=NE\n" +
                "an n8 label:i ui.class:i\n" +
                "ae e160 n8 n14 EdgeDirection=SW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e161 n14 n7 EdgeDirection=SW\n" +
                "ae e162 n14 n17 EdgeDirection=S\n" +
                "ae e163 n14 n11 EdgeDirection=N\n" +
                "ae e164 n14 n8 EdgeDirection=NE\n" +
                "ae e165 n14 n15 EdgeDirection=E\n" +
                "ae e166 n14 n9 EdgeDirection=SE\n" +
                "ae e167 n14 n13 EdgeDirection=W\n" +
                "ae e168 n14 n6 EdgeDirection=NW\n" +
                "ae e169 n8 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e170 n12 n8 EdgeDirection=SW\n" +
                "ae e171 n12 n15 EdgeDirection=S\n" +
                "ae e172 n12 n11 EdgeDirection=W\n" +
                "ae e173 n8 n15 EdgeDirection=SE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e174 n15 n9 EdgeDirection=SW\n" +
                "ae e175 n15 n18 EdgeDirection=S\n" +
                "ae e176 n15 n12 EdgeDirection=N\n" +
                "ae e177 n15 n14 EdgeDirection=W\n" +
                "ae e178 n15 n8 EdgeDirection=NW\n" +
                "ae e179 n8 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e180 n11 n6 EdgeDirection=SW\n" +
                "ae e181 n11 n14 EdgeDirection=S\n" +
                "ae e182 n11 n12 EdgeDirection=E\n" +
                "ae e183 n11 n8 EdgeDirection=SE\n" +
                "ae e184 n11 n10 EdgeDirection=W\n" +
                "ae e185 n8 n20 EdgeDirection=SW\n" +
                "an n20 label:I ui.class:I\n" +
                "ae e186 n20 n29 EdgeDirection=SW\n" +
                "an n29 label:E ui.class:E\n" +
                "ae e187 n29 n26 EdgeDirection=N\n" +
                "ae e188 n29 n20 EdgeDirection=NE\n" +
                "ae e189 n29 n30 EdgeDirection=E\n" +
                "ae e190 n20 n27 EdgeDirection=NE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e191 n27 n20 EdgeDirection=SW\n" +
                "ae e192 n27 n30 EdgeDirection=S\n" +
                "ae e193 n27 n24 EdgeDirection=N\n" +
                "ae e194 n27 n21 EdgeDirection=NE\n" +
                "ae e195 n27 n28 EdgeDirection=E\n" +
                "ae e196 n27 n22 EdgeDirection=SE\n" +
                "ae e197 n27 n26 EdgeDirection=W\n" +
                "ae e198 n27 n19 EdgeDirection=NW\n" +
                "ae e199 n20 n30 EdgeDirection=SE\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e200 n30 n27 EdgeDirection=N\n" +
                "ae e201 n30 n22 EdgeDirection=NE\n" +
                "ae e202 n30 n31 EdgeDirection=E\n" +
                "ae e203 n30 n29 EdgeDirection=W\n" +
                "ae e204 n30 n20 EdgeDirection=NW\n" +
                "ae e205 n20 n26 EdgeDirection=NW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e206 n26 n29 EdgeDirection=S\n" +
                "ae e207 n26 n23 EdgeDirection=N\n" +
                "ae e208 n26 n19 EdgeDirection=NE\n" +
                "ae e209 n26 n27 EdgeDirection=E\n" +
                "ae e210 n26 n20 EdgeDirection=SE\n" +
                "ae e211 n8 n21 EdgeDirection=NE\n" +
                "an n21 label:I ui.class:I\n" +
                "ae e212 n21 n27 EdgeDirection=SW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e213 n27 n20 EdgeDirection=SW\n" +
                "ae e214 n27 n30 EdgeDirection=S\n" +
                "ae e215 n27 n24 EdgeDirection=N\n" +
                "ae e216 n27 n21 EdgeDirection=NE\n" +
                "ae e217 n27 n28 EdgeDirection=E\n" +
                "ae e218 n27 n22 EdgeDirection=SE\n" +
                "ae e219 n27 n26 EdgeDirection=W\n" +
                "ae e220 n27 n19 EdgeDirection=NW\n" +
                "ae e221 n21 n36 EdgeDirection=NE\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e222 n36 n21 EdgeDirection=SW\n" +
                "ae e223 n36 n39 EdgeDirection=S\n" +
                "ae e224 n36 n37 EdgeDirection=E\n" +
                "ae e225 n36 n32 EdgeDirection=SE\n" +
                "ae e226 n21 n39 EdgeDirection=SE\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e227 n39 n22 EdgeDirection=SW\n" +
                "ae e228 n39 n42 EdgeDirection=S\n" +
                "ae e229 n39 n36 EdgeDirection=N\n" +
                "ae e230 n39 n32 EdgeDirection=NE\n" +
                "ae e231 n39 n40 EdgeDirection=E\n" +
                "ae e232 n39 n33 EdgeDirection=SE\n" +
                "ae e233 n39 n21 EdgeDirection=NW\n" +
                "ae e234 n21 n24 EdgeDirection=NW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e235 n24 n19 EdgeDirection=SW\n" +
                "ae e236 n24 n27 EdgeDirection=S\n" +
                "ae e237 n24 n25 EdgeDirection=E\n" +
                "ae e238 n24 n21 EdgeDirection=SE\n" +
                "ae e239 n24 n23 EdgeDirection=W\n" +
                "ae e240 n8 n22 EdgeDirection=SE\n" +
                "an n22 label:I ui.class:I\n" +
                "ae e241 n22 n30 EdgeDirection=SW\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e242 n30 n27 EdgeDirection=N\n" +
                "ae e243 n30 n22 EdgeDirection=NE\n" +
                "ae e244 n30 n31 EdgeDirection=E\n" +
                "ae e245 n30 n29 EdgeDirection=W\n" +
                "ae e246 n30 n20 EdgeDirection=NW\n" +
                "ae e247 n22 n39 EdgeDirection=NE\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e248 n39 n22 EdgeDirection=SW\n" +
                "ae e249 n39 n42 EdgeDirection=S\n" +
                "ae e250 n39 n36 EdgeDirection=N\n" +
                "ae e251 n39 n32 EdgeDirection=NE\n" +
                "ae e252 n39 n40 EdgeDirection=E\n" +
                "ae e253 n39 n33 EdgeDirection=SE\n" +
                "ae e254 n39 n21 EdgeDirection=NW\n" +
                "ae e255 n22 n42 EdgeDirection=SE\n" +
                "an n42 label:E ui.class:E\n" +
                "ae e256 n42 n39 EdgeDirection=N\n" +
                "ae e257 n42 n33 EdgeDirection=NE\n" +
                "ae e258 n42 n43 EdgeDirection=E\n" +
                "ae e259 n42 n22 EdgeDirection=NW\n" +
                "ae e260 n22 n27 EdgeDirection=NW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e261 n27 n20 EdgeDirection=SW\n" +
                "ae e262 n27 n30 EdgeDirection=S\n" +
                "ae e263 n27 n24 EdgeDirection=N\n" +
                "ae e264 n27 n21 EdgeDirection=NE\n" +
                "ae e265 n27 n28 EdgeDirection=E\n" +
                "ae e266 n27 n22 EdgeDirection=SE\n" +
                "ae e267 n27 n26 EdgeDirection=W\n" +
                "ae e268 n27 n19 EdgeDirection=NW\n" +
                "ae e269 n8 n19 EdgeDirection=NW\n" +
                "an n19 label:I ui.class:I\n" +
                "ae e270 n19 n26 EdgeDirection=SW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e271 n26 n29 EdgeDirection=S\n" +
                "ae e272 n26 n23 EdgeDirection=N\n" +
                "ae e273 n26 n19 EdgeDirection=NE\n" +
                "ae e274 n26 n27 EdgeDirection=E\n" +
                "ae e275 n26 n20 EdgeDirection=SE\n" +
                "ae e276 n19 n24 EdgeDirection=NE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e277 n24 n19 EdgeDirection=SW\n" +
                "ae e278 n24 n27 EdgeDirection=S\n" +
                "ae e279 n24 n25 EdgeDirection=E\n" +
                "ae e280 n24 n21 EdgeDirection=SE\n" +
                "ae e281 n24 n23 EdgeDirection=W\n" +
                "ae e282 n19 n27 EdgeDirection=SE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e283 n27 n20 EdgeDirection=SW\n" +
                "ae e284 n27 n30 EdgeDirection=S\n" +
                "ae e285 n27 n24 EdgeDirection=N\n" +
                "ae e286 n27 n21 EdgeDirection=NE\n" +
                "ae e287 n27 n28 EdgeDirection=E\n" +
                "ae e288 n27 n22 EdgeDirection=SE\n" +
                "ae e289 n27 n26 EdgeDirection=W\n" +
                "ae e290 n27 n19 EdgeDirection=NW\n" +
                "ae e291 n19 n23 EdgeDirection=NW\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e292 n23 n26 EdgeDirection=S\n" +
                "ae e293 n23 n24 EdgeDirection=E\n" +
                "ae e294 n23 n19 EdgeDirection=SE\n" +
                "ae e295 n1 n9 EdgeDirection=SE\n" +
                "an n9 label:I ui.class:I\n" +
                "ae e296 n9 n17 EdgeDirection=SW\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e297 n17 n14 EdgeDirection=N\n" +
                "ae e298 n17 n9 EdgeDirection=NE\n" +
                "ae e299 n17 n18 EdgeDirection=E\n" +
                "ae e300 n17 n16 EdgeDirection=W\n" +
                "ae e301 n17 n7 EdgeDirection=NW\n" +
                "ae e302 n9 n15 EdgeDirection=NE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e303 n15 n9 EdgeDirection=SW\n" +
                "ae e304 n15 n18 EdgeDirection=S\n" +
                "ae e305 n15 n12 EdgeDirection=N\n" +
                "ae e306 n15 n14 EdgeDirection=W\n" +
                "ae e307 n15 n8 EdgeDirection=NW\n" +
                "ae e308 n9 n18 EdgeDirection=SE\n" +
                "an n18 label:E ui.class:E\n" +
                "ae e309 n18 n15 EdgeDirection=N\n" +
                "ae e310 n18 n17 EdgeDirection=W\n" +
                "ae e311 n18 n9 EdgeDirection=NW\n" +
                "ae e312 n9 n14 EdgeDirection=NW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e313 n14 n7 EdgeDirection=SW\n" +
                "ae e314 n14 n17 EdgeDirection=S\n" +
                "ae e315 n14 n11 EdgeDirection=N\n" +
                "ae e316 n14 n8 EdgeDirection=NE\n" +
                "ae e317 n14 n15 EdgeDirection=E\n" +
                "ae e318 n14 n9 EdgeDirection=SE\n" +
                "ae e319 n14 n13 EdgeDirection=W\n" +
                "ae e320 n14 n6 EdgeDirection=NW\n" +
                "ae e321 n1 n6 EdgeDirection=NW\n" +
                "an n6 label:i ui.class:i\n" +
                "ae e322 n6 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e323 n13 n16 EdgeDirection=S\n" +
                "ae e324 n13 n10 EdgeDirection=N\n" +
                "ae e325 n13 n6 EdgeDirection=NE\n" +
                "ae e326 n13 n14 EdgeDirection=E\n" +
                "ae e327 n13 n7 EdgeDirection=SE\n" +
                "ae e328 n6 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e329 n11 n6 EdgeDirection=SW\n" +
                "ae e330 n11 n14 EdgeDirection=S\n" +
                "ae e331 n11 n12 EdgeDirection=E\n" +
                "ae e332 n11 n8 EdgeDirection=SE\n" +
                "ae e333 n11 n10 EdgeDirection=W\n" +
                "ae e334 n6 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e335 n14 n7 EdgeDirection=SW\n" +
                "ae e336 n14 n17 EdgeDirection=S\n" +
                "ae e337 n14 n11 EdgeDirection=N\n" +
                "ae e338 n14 n8 EdgeDirection=NE\n" +
                "ae e339 n14 n15 EdgeDirection=E\n" +
                "ae e340 n14 n9 EdgeDirection=SE\n" +
                "ae e341 n14 n13 EdgeDirection=W\n" +
                "ae e342 n14 n6 EdgeDirection=NW\n" +
                "ae e343 n6 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e344 n10 n13 EdgeDirection=S\n" +
                "ae e345 n10 n11 EdgeDirection=E\n" +
                "ae e346 n10 n6 EdgeDirection=SE\n" +
                "ae e347 n6 n46 EdgeDirection=SW\n" +
                "an n46 label:I ui.class:I\n" +
                "ae e348 n46 n37 EdgeDirection=SW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e349 n37 n32 EdgeDirection=SW\n" +
                "ae e350 n37 n40 EdgeDirection=S\n" +
                "ae e351 n37 n46 EdgeDirection=NE\n" +
                "ae e352 n37 n38 EdgeDirection=E\n" +
                "ae e353 n37 n34 EdgeDirection=SE\n" +
                "ae e354 n37 n36 EdgeDirection=W\n" +
                "ae e355 n37 n48 EdgeDirection=NW\n" +
                "ae e356 n46 n53 EdgeDirection=NE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e357 n53 n46 EdgeDirection=SW\n" +
                "ae e358 n53 n56 EdgeDirection=S\n" +
                "ae e359 n53 n50 EdgeDirection=N\n" +
                "ae e360 n53 n47 EdgeDirection=NE\n" +
                "ae e361 n53 n54 EdgeDirection=E\n" +
                "ae e362 n53 n48 EdgeDirection=SE\n" +
                "ae e363 n53 n52 EdgeDirection=W\n" +
                "ae e364 n53 n45 EdgeDirection=NW\n" +
                "ae e365 n46 n38 EdgeDirection=SE\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e366 n38 n34 EdgeDirection=SW\n" +
                "ae e367 n38 n41 EdgeDirection=S\n" +
                "ae e368 n38 n48 EdgeDirection=NE\n" +
                "ae e369 n38 n37 EdgeDirection=W\n" +
                "ae e370 n38 n46 EdgeDirection=NW\n" +
                "ae e371 n46 n52 EdgeDirection=NW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e372 n52 n55 EdgeDirection=S\n" +
                "ae e373 n52 n49 EdgeDirection=N\n" +
                "ae e374 n52 n45 EdgeDirection=NE\n" +
                "ae e375 n52 n53 EdgeDirection=E\n" +
                "ae e376 n52 n46 EdgeDirection=SE\n" +
                "ae e377 n6 n47 EdgeDirection=NE\n" +
                "an n47 label:I ui.class:I\n" +
                "ae e378 n47 n53 EdgeDirection=SW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e379 n53 n46 EdgeDirection=SW\n" +
                "ae e380 n53 n56 EdgeDirection=S\n" +
                "ae e381 n53 n50 EdgeDirection=N\n" +
                "ae e382 n53 n47 EdgeDirection=NE\n" +
                "ae e383 n53 n54 EdgeDirection=E\n" +
                "ae e384 n53 n48 EdgeDirection=SE\n" +
                "ae e385 n53 n52 EdgeDirection=W\n" +
                "ae e386 n53 n45 EdgeDirection=NW\n" +
                "ae e387 n47 n51 EdgeDirection=NE\n" +
                "an n51 label:E ui.class:E\n" +
                "ae e388 n51 n47 EdgeDirection=SW\n" +
                "ae e389 n51 n54 EdgeDirection=S\n" +
                "ae e390 n51 n50 EdgeDirection=W\n" +
                "ae e391 n47 n54 EdgeDirection=SE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e392 n54 n48 EdgeDirection=SW\n" +
                "ae e393 n54 n57 EdgeDirection=S\n" +
                "ae e394 n54 n51 EdgeDirection=N\n" +
                "ae e395 n54 n53 EdgeDirection=W\n" +
                "ae e396 n54 n47 EdgeDirection=NW\n" +
                "ae e397 n47 n50 EdgeDirection=NW\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e398 n50 n45 EdgeDirection=SW\n" +
                "ae e399 n50 n53 EdgeDirection=S\n" +
                "ae e400 n50 n51 EdgeDirection=E\n" +
                "ae e401 n50 n47 EdgeDirection=SE\n" +
                "ae e402 n50 n49 EdgeDirection=W\n" +
                "ae e403 n6 n48 EdgeDirection=SE\n" +
                "an n48 label:I ui.class:I\n" +
                "ae e404 n48 n38 EdgeDirection=SW\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e405 n38 n34 EdgeDirection=SW\n" +
                "ae e406 n38 n41 EdgeDirection=S\n" +
                "ae e407 n38 n48 EdgeDirection=NE\n" +
                "ae e408 n38 n37 EdgeDirection=W\n" +
                "ae e409 n38 n46 EdgeDirection=NW\n" +
                "ae e410 n48 n54 EdgeDirection=NE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e411 n54 n48 EdgeDirection=SW\n" +
                "ae e412 n54 n57 EdgeDirection=S\n" +
                "ae e413 n54 n51 EdgeDirection=N\n" +
                "ae e414 n54 n53 EdgeDirection=W\n" +
                "ae e415 n54 n47 EdgeDirection=NW\n" +
                "ae e416 n48 n37 EdgeDirection=SE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e417 n37 n32 EdgeDirection=SW\n" +
                "ae e418 n37 n40 EdgeDirection=S\n" +
                "ae e419 n37 n46 EdgeDirection=NE\n" +
                "ae e420 n37 n38 EdgeDirection=E\n" +
                "ae e421 n37 n34 EdgeDirection=SE\n" +
                "ae e422 n37 n36 EdgeDirection=W\n" +
                "ae e423 n37 n48 EdgeDirection=NW\n" +
                "ae e424 n48 n53 EdgeDirection=NW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e425 n53 n46 EdgeDirection=SW\n" +
                "ae e426 n53 n56 EdgeDirection=S\n" +
                "ae e427 n53 n50 EdgeDirection=N\n" +
                "ae e428 n53 n47 EdgeDirection=NE\n" +
                "ae e429 n53 n54 EdgeDirection=E\n" +
                "ae e430 n53 n48 EdgeDirection=SE\n" +
                "ae e431 n53 n52 EdgeDirection=W\n" +
                "ae e432 n53 n45 EdgeDirection=NW\n" +
                "ae e433 n6 n45 EdgeDirection=NW\n" +
                "an n45 label:I ui.class:I\n" +
                "ae e434 n45 n52 EdgeDirection=SW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e435 n52 n55 EdgeDirection=S\n" +
                "ae e436 n52 n49 EdgeDirection=N\n" +
                "ae e437 n52 n45 EdgeDirection=NE\n" +
                "ae e438 n52 n53 EdgeDirection=E\n" +
                "ae e439 n52 n46 EdgeDirection=SE\n" +
                "ae e440 n45 n50 EdgeDirection=NE\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e441 n50 n45 EdgeDirection=SW\n" +
                "ae e442 n50 n53 EdgeDirection=S\n" +
                "ae e443 n50 n51 EdgeDirection=E\n" +
                "ae e444 n50 n47 EdgeDirection=SE\n" +
                "ae e445 n50 n49 EdgeDirection=W\n" +
                "ae e446 n45 n53 EdgeDirection=SE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e447 n53 n46 EdgeDirection=SW\n" +
                "ae e448 n53 n56 EdgeDirection=S\n" +
                "ae e449 n53 n50 EdgeDirection=N\n" +
                "ae e450 n53 n47 EdgeDirection=NE\n" +
                "ae e451 n53 n54 EdgeDirection=E\n" +
                "ae e452 n53 n48 EdgeDirection=SE\n" +
                "ae e453 n53 n52 EdgeDirection=W\n" +
                "ae e454 n53 n45 EdgeDirection=NW\n" +
                "ae e455 n45 n49 EdgeDirection=NW\n" +
                "an n49 label:E ui.class:E\n" +
                "ae e456 n49 n52 EdgeDirection=S\n" +
                "ae e457 n49 n50 EdgeDirection=E\n" +
                "ae e458 n49 n45 EdgeDirection=SE\n";

        assertEquals(expected, vertex.serialize());
    }
}
