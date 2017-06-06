package edu.agh.gg.serialization;

import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.grammar.P0;
import edu.agh.gg.grammar.P1;
import org.junit.Test;

public class SerializerTest {
    @Test
    public void testSerialization() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);

        P0 p0 = new P0();
        p0.apply(vertex);

        P1 p1 = new P1();
        p1.apply(vertex);

        String expected = "an n1 label:i ui.class.i\n" +
                "ae e1 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class.E\n" +
                "ae e2 n2 n3 EdgeDirection=S\n" +
                "ae e3 n2 n1 EdgeDirection=SE\n" +
                "ae e4 n2 n4 EdgeDirection=E\n" +
                "ae e5 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class.E\n" +
                "ae e6 n5 n4 EdgeDirection=N\n" +
                "ae e7 n5 n1 EdgeDirection=NW\n" +
                "ae e8 n5 n3 EdgeDirection=W\n" +
                "ae e9 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class.E\n" +
                "ae e10 n4 n5 EdgeDirection=S\n" +
                "ae e11 n4 n1 EdgeDirection=SW\n" +
                "ae e12 n4 n2 EdgeDirection=W\n" +
                "ae e13 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class.E\n" +
                "ae e14 n3 n2 EdgeDirection=N\n" +
                "ae e15 n3 n1 EdgeDirection=NE\n" +
                "ae e16 n3 n5 EdgeDirection=E\n" +
                "ae e17 n1 n6 EdgeDirection=NW\n" +
                "an n6 label:I ui.class.I\n" +
                "ae e18 n6 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class.E\n" +
                "ae e19 n10 n13 EdgeDirection=S\n" +
                "ae e20 n10 n6 EdgeDirection=SE\n" +
                "ae e21 n10 n11 EdgeDirection=E\n" +
                "ae e22 n6 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class.E\n" +
                "ae e23 n14 n11 EdgeDirection=N\n" +
                "ae e24 n14 n17 EdgeDirection=S\n" +
                "ae e25 n14 n6 EdgeDirection=NW\n" +
                "ae e26 n14 n9 EdgeDirection=SE\n" +
                "ae e27 n14 n8 EdgeDirection=NE\n" +
                "ae e28 n14 n7 EdgeDirection=SW\n" +
                "ae e29 n14 n15 EdgeDirection=E\n" +
                "ae e30 n14 n13 EdgeDirection=W\n" +
                "ae e31 n6 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class.E\n" +
                "ae e32 n11 n14 EdgeDirection=S\n" +
                "ae e33 n11 n8 EdgeDirection=SE\n" +
                "ae e34 n11 n12 EdgeDirection=E\n" +
                "ae e35 n11 n6 EdgeDirection=SW\n" +
                "ae e36 n11 n10 EdgeDirection=W\n" +
                "ae e37 n6 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class.E\n" +
                "ae e38 n13 n10 EdgeDirection=N\n" +
                "ae e39 n13 n16 EdgeDirection=S\n" +
                "ae e40 n13 n7 EdgeDirection=SE\n" +
                "ae e41 n13 n6 EdgeDirection=NE\n" +
                "ae e42 n13 n14 EdgeDirection=E\n" +
                "ae e43 n1 n9 EdgeDirection=SE\n" +
                "an n9 label:I ui.class.I\n" +
                "ae e44 n9 n14 EdgeDirection=NW\n" +
                "an n14 label:E ui.class.i\n" +
                "ae e45 n14 n11 EdgeDirection=N\n" +
                "ae e46 n14 n17 EdgeDirection=S\n" +
                "ae e47 n14 n6 EdgeDirection=NW\n" +
                "ae e48 n14 n9 EdgeDirection=SE\n" +
                "ae e49 n14 n8 EdgeDirection=NE\n" +
                "ae e50 n14 n7 EdgeDirection=SW\n" +
                "ae e51 n14 n15 EdgeDirection=E\n" +
                "ae e52 n14 n13 EdgeDirection=W\n" +
                "ae e53 n9 n18 EdgeDirection=SE\n" +
                "an n18 label:E ui.class.E\n" +
                "ae e54 n18 n15 EdgeDirection=N\n" +
                "ae e55 n18 n9 EdgeDirection=NW\n" +
                "ae e56 n18 n17 EdgeDirection=W\n" +
                "ae e57 n9 n15 EdgeDirection=NE\n" +
                "an n15 label:E ui.class.E\n" +
                "ae e58 n15 n12 EdgeDirection=N\n" +
                "ae e59 n15 n18 EdgeDirection=S\n" +
                "ae e60 n15 n8 EdgeDirection=NW\n" +
                "ae e61 n15 n9 EdgeDirection=SW\n" +
                "ae e62 n15 n14 EdgeDirection=W\n" +
                "ae e63 n9 n17 EdgeDirection=SW\n" +
                "an n17 label:E ui.class.E\n" +
                "ae e64 n17 n14 EdgeDirection=N\n" +
                "ae e65 n17 n7 EdgeDirection=NW\n" +
                "ae e66 n17 n9 EdgeDirection=NE\n" +
                "ae e67 n17 n18 EdgeDirection=E\n" +
                "ae e68 n17 n16 EdgeDirection=W\n" +
                "ae e69 n1 n8 EdgeDirection=NE\n" +
                "an n8 label:I ui.class.I\n" +
                "ae e70 n8 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class.E\n" +
                "ae e71 n11 n14 EdgeDirection=S\n" +
                "ae e72 n11 n8 EdgeDirection=SE\n" +
                "ae e73 n11 n12 EdgeDirection=E\n" +
                "ae e74 n11 n6 EdgeDirection=SW\n" +
                "ae e75 n11 n10 EdgeDirection=W\n" +
                "ae e76 n8 n15 EdgeDirection=SE\n" +
                "an n15 label:E ui.class.E\n" +
                "ae e77 n15 n12 EdgeDirection=N\n" +
                "ae e78 n15 n18 EdgeDirection=S\n" +
                "ae e79 n15 n8 EdgeDirection=NW\n" +
                "ae e80 n15 n9 EdgeDirection=SW\n" +
                "ae e81 n15 n14 EdgeDirection=W\n" +
                "ae e82 n8 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class.E\n" +
                "ae e83 n12 n15 EdgeDirection=S\n" +
                "ae e84 n12 n8 EdgeDirection=SW\n" +
                "ae e85 n12 n11 EdgeDirection=W\n" +
                "ae e86 n8 n14 EdgeDirection=SW\n" +
                "an n14 label:E ui.class.E\n" +
                "ae e87 n14 n11 EdgeDirection=N\n" +
                "ae e88 n14 n17 EdgeDirection=S\n" +
                "ae e89 n14 n6 EdgeDirection=NW\n" +
                "ae e90 n14 n9 EdgeDirection=SE\n" +
                "ae e91 n14 n8 EdgeDirection=NE\n" +
                "ae e92 n14 n7 EdgeDirection=SW\n" +
                "ae e93 n14 n15 EdgeDirection=E\n" +
                "ae e94 n14 n13 EdgeDirection=W\n" +
                "ae e95 n1 n7 EdgeDirection=SW\n" +
                "an n7 label:I ui.class.I\n" +
                "ae e96 n7 n13 EdgeDirection=NW\n" +
                "an n13 label:E ui.class.E\n" +
                "ae e97 n13 n10 EdgeDirection=N\n" +
                "ae e98 n13 n16 EdgeDirection=S\n" +
                "ae e99 n13 n7 EdgeDirection=SE\n" +
                "ae e100 n13 n6 EdgeDirection=NE\n" +
                "ae e101 n13 n14 EdgeDirection=E\n" +
                "ae e102 n7 n17 EdgeDirection=SE\n" +
                "an n17 label:E ui.class.E\n" +
                "ae e103 n17 n14 EdgeDirection=N\n" +
                "ae e104 n17 n7 EdgeDirection=NW\n" +
                "ae e105 n17 n9 EdgeDirection=NE\n" +
                "ae e106 n17 n18 EdgeDirection=E\n" +
                "ae e107 n17 n16 EdgeDirection=W\n" +
                "ae e108 n7 n14 EdgeDirection=NE\n" +
                "an n14 label:E ui.class.E\n" +
                "ae e109 n14 n11 EdgeDirection=N\n" +
                "ae e110 n14 n17 EdgeDirection=S\n" +
                "ae e111 n14 n6 EdgeDirection=NW\n" +
                "ae e112 n14 n9 EdgeDirection=SE\n" +
                "ae e113 n14 n8 EdgeDirection=NE\n" +
                "ae e114 n14 n7 EdgeDirection=SW\n" +
                "ae e115 n14 n15 EdgeDirection=E\n" +
                "ae e116 n14 n13 EdgeDirection=W\n" +
                "ae e117 n7 n16 EdgeDirection=SW\n" +
                "an n16 label:E ui.class.E\n" +
                "ae e118 n16 n13 EdgeDirection=N\n" +
                "ae e119 n16 n7 EdgeDirection=NE\n" +
                "ae e120 n16 n17 EdgeDirection=E\n";

        System.out.println(vertex.serialize());

//        assertEquals(expected, vertex.serialize());
    }
}
