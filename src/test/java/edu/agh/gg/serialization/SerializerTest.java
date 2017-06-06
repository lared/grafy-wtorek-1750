package edu.agh.gg.serialization;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.grammar.P0;
import edu.agh.gg.grammar.P1;
import edu.agh.gg.grammar.P2;
import edu.agh.gg.grammar.P3;
import edu.agh.gg.serialization.idgenerator.Id;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SerializerTest {
    @Before
    public void setUp() throws Exception {
        Id.resetIds();
    }

    @Test
    public void testSerialization() throws Exception {
        Vertex vertex = Vertex.withoutParent(VertexLabel.I);

        P0 p0 = new P0();
        p0.apply(vertex);
        P1 p1 = new P1();
        p1.apply(vertex);
        for (Vertex childVertex : vertex.getChildrenEdges().values()) {
            if (childVertex.getParentDirection().equals(EdgeDirection.NW)) continue;
            p1.apply(childVertex);
        }
        P2 p2 = new P2();
        p2.apply(vertex);
        P3 p3 = new P3();
        p3.apply(vertex);

        String expected = "an n1 label:i ui.class:i\n" +
                "ae e1 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class:E\n" +
                "ae e2 n3 n2 EdgeDirection=N\n" +
                "ae e3 n3 n5 EdgeDirection=E\n" +
                "ae e4 n3 n1 EdgeDirection=NE\n" +
                "ae e5 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e6 n4 n5 EdgeDirection=S\n" +
                "ae e7 n4 n1 EdgeDirection=SW\n" +
                "ae e8 n4 n2 EdgeDirection=W\n" +
                "ae e9 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e10 n5 n4 EdgeDirection=N\n" +
                "ae e11 n5 n1 EdgeDirection=NW\n" +
                "ae e12 n5 n3 EdgeDirection=W\n" +
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
                "ae e20 n16 n17 EdgeDirection=E\n" +
                "ae e21 n16 n7 EdgeDirection=NE\n" +
                "ae e22 n7 n14 EdgeDirection=NE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e23 n14 n17 EdgeDirection=S\n" +
                "ae e24 n14 n7 EdgeDirection=SW\n" +
                "ae e25 n14 n8 EdgeDirection=NE\n" +
                "ae e26 n14 n9 EdgeDirection=SE\n" +
                "ae e27 n14 n11 EdgeDirection=N\n" +
                "ae e28 n14 n15 EdgeDirection=E\n" +
                "ae e29 n14 n6 EdgeDirection=NW\n" +
                "ae e30 n14 n13 EdgeDirection=W\n" +
                "ae e31 n7 n17 EdgeDirection=SE\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e32 n17 n18 EdgeDirection=E\n" +
                "ae e33 n17 n9 EdgeDirection=NE\n" +
                "ae e34 n17 n14 EdgeDirection=N\n" +
                "ae e35 n17 n7 EdgeDirection=NW\n" +
                "ae e36 n17 n16 EdgeDirection=W\n" +
                "ae e37 n7 n13 EdgeDirection=NW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e38 n13 n16 EdgeDirection=S\n" +
                "ae e39 n13 n10 EdgeDirection=N\n" +
                "ae e40 n13 n6 EdgeDirection=NE\n" +
                "ae e41 n13 n7 EdgeDirection=SE\n" +
                "ae e42 n13 n14 EdgeDirection=E\n" +
                "ae e43 n7 n20 EdgeDirection=SW\n" +
                "an n20 label:I ui.class:I\n" +
                "ae e44 n20 n29 EdgeDirection=SW\n" +
                "an n29 label:E ui.class:E\n" +
                "ae e45 n29 n26 EdgeDirection=N\n" +
                "ae e46 n29 n30 EdgeDirection=E\n" +
                "ae e47 n29 n20 EdgeDirection=NE\n" +
                "ae e48 n29 n35 EdgeDirection=NW\n" +
                "ae e49 n20 n27 EdgeDirection=NE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e50 n27 n30 EdgeDirection=S\n" +
                "ae e51 n27 n20 EdgeDirection=SW\n" +
                "ae e52 n27 n21 EdgeDirection=NE\n" +
                "ae e53 n27 n22 EdgeDirection=SE\n" +
                "ae e54 n27 n24 EdgeDirection=N\n" +
                "ae e55 n27 n28 EdgeDirection=E\n" +
                "ae e56 n27 n19 EdgeDirection=NW\n" +
                "ae e57 n27 n26 EdgeDirection=W\n" +
                "ae e58 n20 n30 EdgeDirection=SE\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e59 n30 n31 EdgeDirection=E\n" +
                "ae e60 n30 n22 EdgeDirection=NE\n" +
                "ae e61 n30 n27 EdgeDirection=N\n" +
                "ae e62 n30 n20 EdgeDirection=NW\n" +
                "ae e63 n30 n29 EdgeDirection=W\n" +
                "ae e64 n20 n26 EdgeDirection=NW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e65 n26 n29 EdgeDirection=S\n" +
                "ae e66 n26 n35 EdgeDirection=SW\n" +
                "ae e67 n26 n23 EdgeDirection=N\n" +
                "ae e68 n26 n19 EdgeDirection=NE\n" +
                "ae e69 n26 n20 EdgeDirection=SE\n" +
                "ae e70 n26 n27 EdgeDirection=E\n" +
                "ae e71 n26 n34 EdgeDirection=NW\n" +
                "ae e72 n7 n21 EdgeDirection=NE\n" +
                "an n21 label:I ui.class:I\n" +
                "ae e73 n21 n27 EdgeDirection=SW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e74 n27 n30 EdgeDirection=S\n" +
                "ae e75 n27 n20 EdgeDirection=SW\n" +
                "ae e76 n27 n21 EdgeDirection=NE\n" +
                "ae e77 n27 n22 EdgeDirection=SE\n" +
                "ae e78 n27 n24 EdgeDirection=N\n" +
                "ae e79 n27 n28 EdgeDirection=E\n" +
                "ae e80 n27 n19 EdgeDirection=NW\n" +
                "ae e81 n27 n26 EdgeDirection=W\n" +
                "ae e82 n21 n25 EdgeDirection=NE\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e83 n25 n28 EdgeDirection=S\n" +
                "ae e84 n25 n21 EdgeDirection=SW\n" +
                "ae e85 n25 n48 EdgeDirection=NE\n" +
                "ae e86 n25 n46 EdgeDirection=NW\n" +
                "ae e87 n25 n24 EdgeDirection=W\n" +
                "ae e88 n21 n28 EdgeDirection=SE\n" +
                "an n28 label:E ui.class:E\n" +
                "ae e89 n28 n31 EdgeDirection=S\n" +
                "ae e90 n28 n22 EdgeDirection=SW\n" +
                "ae e91 n28 n25 EdgeDirection=N\n" +
                "ae e92 n28 n21 EdgeDirection=NW\n" +
                "ae e93 n28 n27 EdgeDirection=W\n" +
                "ae e94 n21 n24 EdgeDirection=NW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e95 n24 n27 EdgeDirection=S\n" +
                "ae e96 n24 n19 EdgeDirection=SW\n" +
                "ae e97 n24 n25 EdgeDirection=E\n" +
                "ae e98 n24 n21 EdgeDirection=SE\n" +
                "ae e99 n24 n46 EdgeDirection=NE\n" +
                "ae e100 n24 n48 EdgeDirection=NW\n" +
                "ae e101 n24 n23 EdgeDirection=W\n" +
                "ae e102 n7 n22 EdgeDirection=SE\n" +
                "an n22 label:I ui.class:I\n" +
                "ae e103 n22 n30 EdgeDirection=SW\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e104 n30 n31 EdgeDirection=E\n" +
                "ae e105 n30 n22 EdgeDirection=NE\n" +
                "ae e106 n30 n27 EdgeDirection=N\n" +
                "ae e107 n30 n20 EdgeDirection=NW\n" +
                "ae e108 n30 n29 EdgeDirection=W\n" +
                "ae e109 n22 n28 EdgeDirection=NE\n" +
                "an n28 label:E ui.class:E\n" +
                "ae e110 n28 n31 EdgeDirection=S\n" +
                "ae e111 n28 n22 EdgeDirection=SW\n" +
                "ae e112 n28 n25 EdgeDirection=N\n" +
                "ae e113 n28 n21 EdgeDirection=NW\n" +
                "ae e114 n28 n27 EdgeDirection=W\n" +
                "ae e115 n22 n31 EdgeDirection=SE\n" +
                "an n31 label:E ui.class:E\n" +
                "ae e116 n31 n28 EdgeDirection=N\n" +
                "ae e117 n31 n22 EdgeDirection=NW\n" +
                "ae e118 n31 n30 EdgeDirection=W\n" +
                "ae e119 n22 n27 EdgeDirection=NW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e120 n27 n30 EdgeDirection=S\n" +
                "ae e121 n27 n20 EdgeDirection=SW\n" +
                "ae e122 n27 n21 EdgeDirection=NE\n" +
                "ae e123 n27 n22 EdgeDirection=SE\n" +
                "ae e124 n27 n24 EdgeDirection=N\n" +
                "ae e125 n27 n28 EdgeDirection=E\n" +
                "ae e126 n27 n19 EdgeDirection=NW\n" +
                "ae e127 n27 n26 EdgeDirection=W\n" +
                "ae e128 n7 n19 EdgeDirection=NW\n" +
                "an n19 label:I ui.class:I\n" +
                "ae e129 n19 n26 EdgeDirection=SW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e130 n26 n29 EdgeDirection=S\n" +
                "ae e131 n26 n35 EdgeDirection=SW\n" +
                "ae e132 n26 n23 EdgeDirection=N\n" +
                "ae e133 n26 n19 EdgeDirection=NE\n" +
                "ae e134 n26 n20 EdgeDirection=SE\n" +
                "ae e135 n26 n27 EdgeDirection=E\n" +
                "ae e136 n26 n34 EdgeDirection=NW\n" +
                "ae e137 n19 n24 EdgeDirection=NE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e138 n24 n27 EdgeDirection=S\n" +
                "ae e139 n24 n19 EdgeDirection=SW\n" +
                "ae e140 n24 n25 EdgeDirection=E\n" +
                "ae e141 n24 n21 EdgeDirection=SE\n" +
                "ae e142 n24 n46 EdgeDirection=NE\n" +
                "ae e143 n24 n48 EdgeDirection=NW\n" +
                "ae e144 n24 n23 EdgeDirection=W\n" +
                "ae e145 n19 n27 EdgeDirection=SE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e146 n27 n30 EdgeDirection=S\n" +
                "ae e147 n27 n20 EdgeDirection=SW\n" +
                "ae e148 n27 n21 EdgeDirection=NE\n" +
                "ae e149 n27 n22 EdgeDirection=SE\n" +
                "ae e150 n27 n24 EdgeDirection=N\n" +
                "ae e151 n27 n28 EdgeDirection=E\n" +
                "ae e152 n27 n19 EdgeDirection=NW\n" +
                "ae e153 n27 n26 EdgeDirection=W\n" +
                "ae e154 n19 n23 EdgeDirection=NW\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e155 n23 n26 EdgeDirection=S\n" +
                "ae e156 n23 n34 EdgeDirection=SW\n" +
                "ae e157 n23 n24 EdgeDirection=E\n" +
                "ae e158 n23 n19 EdgeDirection=SE\n" +
                "ae e159 n1 n8 EdgeDirection=NE\n" +
                "an n8 label:i ui.class:i\n" +
                "ae e160 n8 n14 EdgeDirection=SW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e161 n14 n17 EdgeDirection=S\n" +
                "ae e162 n14 n7 EdgeDirection=SW\n" +
                "ae e163 n14 n8 EdgeDirection=NE\n" +
                "ae e164 n14 n9 EdgeDirection=SE\n" +
                "ae e165 n14 n11 EdgeDirection=N\n" +
                "ae e166 n14 n15 EdgeDirection=E\n" +
                "ae e167 n14 n6 EdgeDirection=NW\n" +
                "ae e168 n14 n13 EdgeDirection=W\n" +
                "ae e169 n8 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e170 n12 n15 EdgeDirection=S\n" +
                "ae e171 n12 n8 EdgeDirection=SW\n" +
                "ae e172 n12 n11 EdgeDirection=W\n" +
                "ae e173 n8 n15 EdgeDirection=SE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e174 n15 n18 EdgeDirection=S\n" +
                "ae e175 n15 n9 EdgeDirection=SW\n" +
                "ae e176 n15 n12 EdgeDirection=N\n" +
                "ae e177 n15 n8 EdgeDirection=NW\n" +
                "ae e178 n15 n14 EdgeDirection=W\n" +
                "ae e179 n8 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e180 n11 n14 EdgeDirection=S\n" +
                "ae e181 n11 n6 EdgeDirection=SW\n" +
                "ae e182 n11 n12 EdgeDirection=E\n" +
                "ae e183 n11 n8 EdgeDirection=SE\n" +
                "ae e184 n11 n10 EdgeDirection=W\n" +
                "ae e185 n8 n33 EdgeDirection=SW\n" +
                "an n33 label:I ui.class:I\n" +
                "ae e186 n33 n42 EdgeDirection=SW\n" +
                "an n42 label:E ui.class:E\n" +
                "ae e187 n42 n39 EdgeDirection=N\n" +
                "ae e188 n42 n43 EdgeDirection=E\n" +
                "ae e189 n42 n33 EdgeDirection=NE\n" +
                "ae e190 n33 n40 EdgeDirection=NE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e191 n40 n43 EdgeDirection=S\n" +
                "ae e192 n40 n33 EdgeDirection=SW\n" +
                "ae e193 n40 n34 EdgeDirection=NE\n" +
                "ae e194 n40 n35 EdgeDirection=SE\n" +
                "ae e195 n40 n37 EdgeDirection=N\n" +
                "ae e196 n40 n41 EdgeDirection=E\n" +
                "ae e197 n40 n32 EdgeDirection=NW\n" +
                "ae e198 n40 n39 EdgeDirection=W\n" +
                "ae e199 n33 n43 EdgeDirection=SE\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e200 n43 n44 EdgeDirection=E\n" +
                "ae e201 n43 n35 EdgeDirection=NE\n" +
                "ae e202 n43 n40 EdgeDirection=N\n" +
                "ae e203 n43 n33 EdgeDirection=NW\n" +
                "ae e204 n43 n42 EdgeDirection=W\n" +
                "ae e205 n33 n39 EdgeDirection=NW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e206 n39 n42 EdgeDirection=S\n" +
                "ae e207 n39 n36 EdgeDirection=N\n" +
                "ae e208 n39 n32 EdgeDirection=NE\n" +
                "ae e209 n39 n33 EdgeDirection=SE\n" +
                "ae e210 n39 n40 EdgeDirection=E\n" +
                "ae e211 n8 n34 EdgeDirection=NE\n" +
                "an n34 label:I ui.class:I\n" +
                "ae e212 n34 n40 EdgeDirection=SW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e213 n40 n43 EdgeDirection=S\n" +
                "ae e214 n40 n33 EdgeDirection=SW\n" +
                "ae e215 n40 n34 EdgeDirection=NE\n" +
                "ae e216 n40 n35 EdgeDirection=SE\n" +
                "ae e217 n40 n37 EdgeDirection=N\n" +
                "ae e218 n40 n41 EdgeDirection=E\n" +
                "ae e219 n40 n32 EdgeDirection=NW\n" +
                "ae e220 n40 n39 EdgeDirection=W\n" +
                "ae e221 n34 n23 EdgeDirection=NE\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e222 n23 n26 EdgeDirection=S\n" +
                "ae e223 n23 n34 EdgeDirection=SW\n" +
                "ae e224 n23 n24 EdgeDirection=E\n" +
                "ae e225 n23 n19 EdgeDirection=SE\n" +
                "ae e226 n34 n26 EdgeDirection=SE\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e227 n26 n29 EdgeDirection=S\n" +
                "ae e228 n26 n35 EdgeDirection=SW\n" +
                "ae e229 n26 n23 EdgeDirection=N\n" +
                "ae e230 n26 n19 EdgeDirection=NE\n" +
                "ae e231 n26 n20 EdgeDirection=SE\n" +
                "ae e232 n26 n27 EdgeDirection=E\n" +
                "ae e233 n26 n34 EdgeDirection=NW\n" +
                "ae e234 n34 n37 EdgeDirection=NW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e235 n37 n40 EdgeDirection=S\n" +
                "ae e236 n37 n32 EdgeDirection=SW\n" +
                "ae e237 n37 n38 EdgeDirection=E\n" +
                "ae e238 n37 n34 EdgeDirection=SE\n" +
                "ae e239 n37 n36 EdgeDirection=W\n" +
                "ae e240 n8 n35 EdgeDirection=SE\n" +
                "an n35 label:I ui.class:I\n" +
                "ae e241 n35 n43 EdgeDirection=SW\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e242 n43 n44 EdgeDirection=E\n" +
                "ae e243 n43 n35 EdgeDirection=NE\n" +
                "ae e244 n43 n40 EdgeDirection=N\n" +
                "ae e245 n43 n33 EdgeDirection=NW\n" +
                "ae e246 n43 n42 EdgeDirection=W\n" +
                "ae e247 n35 n26 EdgeDirection=NE\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e248 n26 n29 EdgeDirection=S\n" +
                "ae e249 n26 n35 EdgeDirection=SW\n" +
                "ae e250 n26 n23 EdgeDirection=N\n" +
                "ae e251 n26 n19 EdgeDirection=NE\n" +
                "ae e252 n26 n20 EdgeDirection=SE\n" +
                "ae e253 n26 n27 EdgeDirection=E\n" +
                "ae e254 n26 n34 EdgeDirection=NW\n" +
                "ae e255 n35 n29 EdgeDirection=SE\n" +
                "an n29 label:E ui.class:E\n" +
                "ae e256 n29 n26 EdgeDirection=N\n" +
                "ae e257 n29 n30 EdgeDirection=E\n" +
                "ae e258 n29 n20 EdgeDirection=NE\n" +
                "ae e259 n29 n35 EdgeDirection=NW\n" +
                "ae e260 n35 n40 EdgeDirection=NW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e261 n40 n43 EdgeDirection=S\n" +
                "ae e262 n40 n33 EdgeDirection=SW\n" +
                "ae e263 n40 n34 EdgeDirection=NE\n" +
                "ae e264 n40 n35 EdgeDirection=SE\n" +
                "ae e265 n40 n37 EdgeDirection=N\n" +
                "ae e266 n40 n41 EdgeDirection=E\n" +
                "ae e267 n40 n32 EdgeDirection=NW\n" +
                "ae e268 n40 n39 EdgeDirection=W\n" +
                "ae e269 n8 n32 EdgeDirection=NW\n" +
                "an n32 label:I ui.class:I\n" +
                "ae e270 n32 n39 EdgeDirection=SW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e271 n39 n42 EdgeDirection=S\n" +
                "ae e272 n39 n36 EdgeDirection=N\n" +
                "ae e273 n39 n32 EdgeDirection=NE\n" +
                "ae e274 n39 n33 EdgeDirection=SE\n" +
                "ae e275 n39 n40 EdgeDirection=E\n" +
                "ae e276 n32 n37 EdgeDirection=NE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e277 n37 n40 EdgeDirection=S\n" +
                "ae e278 n37 n32 EdgeDirection=SW\n" +
                "ae e279 n37 n38 EdgeDirection=E\n" +
                "ae e280 n37 n34 EdgeDirection=SE\n" +
                "ae e281 n37 n36 EdgeDirection=W\n" +
                "ae e282 n32 n40 EdgeDirection=SE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e283 n40 n43 EdgeDirection=S\n" +
                "ae e284 n40 n33 EdgeDirection=SW\n" +
                "ae e285 n40 n34 EdgeDirection=NE\n" +
                "ae e286 n40 n35 EdgeDirection=SE\n" +
                "ae e287 n40 n37 EdgeDirection=N\n" +
                "ae e288 n40 n41 EdgeDirection=E\n" +
                "ae e289 n40 n32 EdgeDirection=NW\n" +
                "ae e290 n40 n39 EdgeDirection=W\n" +
                "ae e291 n32 n36 EdgeDirection=NW\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e292 n36 n39 EdgeDirection=S\n" +
                "ae e293 n36 n37 EdgeDirection=E\n" +
                "ae e294 n36 n32 EdgeDirection=SE\n" +
                "ae e295 n1 n9 EdgeDirection=SE\n" +
                "an n9 label:I ui.class:I\n" +
                "ae e296 n9 n17 EdgeDirection=SW\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e297 n17 n18 EdgeDirection=E\n" +
                "ae e298 n17 n9 EdgeDirection=NE\n" +
                "ae e299 n17 n14 EdgeDirection=N\n" +
                "ae e300 n17 n7 EdgeDirection=NW\n" +
                "ae e301 n17 n16 EdgeDirection=W\n" +
                "ae e302 n9 n15 EdgeDirection=NE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e303 n15 n18 EdgeDirection=S\n" +
                "ae e304 n15 n9 EdgeDirection=SW\n" +
                "ae e305 n15 n12 EdgeDirection=N\n" +
                "ae e306 n15 n8 EdgeDirection=NW\n" +
                "ae e307 n15 n14 EdgeDirection=W\n" +
                "ae e308 n9 n18 EdgeDirection=SE\n" +
                "an n18 label:E ui.class:E\n" +
                "ae e309 n18 n15 EdgeDirection=N\n" +
                "ae e310 n18 n9 EdgeDirection=NW\n" +
                "ae e311 n18 n17 EdgeDirection=W\n" +
                "ae e312 n9 n14 EdgeDirection=NW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e313 n14 n17 EdgeDirection=S\n" +
                "ae e314 n14 n7 EdgeDirection=SW\n" +
                "ae e315 n14 n8 EdgeDirection=NE\n" +
                "ae e316 n14 n9 EdgeDirection=SE\n" +
                "ae e317 n14 n11 EdgeDirection=N\n" +
                "ae e318 n14 n15 EdgeDirection=E\n" +
                "ae e319 n14 n6 EdgeDirection=NW\n" +
                "ae e320 n14 n13 EdgeDirection=W\n" +
                "ae e321 n1 n6 EdgeDirection=NW\n" +
                "an n6 label:i ui.class:i\n" +
                "ae e322 n6 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e323 n13 n16 EdgeDirection=S\n" +
                "ae e324 n13 n10 EdgeDirection=N\n" +
                "ae e325 n13 n6 EdgeDirection=NE\n" +
                "ae e326 n13 n7 EdgeDirection=SE\n" +
                "ae e327 n13 n14 EdgeDirection=E\n" +
                "ae e328 n6 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e329 n11 n14 EdgeDirection=S\n" +
                "ae e330 n11 n6 EdgeDirection=SW\n" +
                "ae e331 n11 n12 EdgeDirection=E\n" +
                "ae e332 n11 n8 EdgeDirection=SE\n" +
                "ae e333 n11 n10 EdgeDirection=W\n" +
                "ae e334 n6 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e335 n14 n17 EdgeDirection=S\n" +
                "ae e336 n14 n7 EdgeDirection=SW\n" +
                "ae e337 n14 n8 EdgeDirection=NE\n" +
                "ae e338 n14 n9 EdgeDirection=SE\n" +
                "ae e339 n14 n11 EdgeDirection=N\n" +
                "ae e340 n14 n15 EdgeDirection=E\n" +
                "ae e341 n14 n6 EdgeDirection=NW\n" +
                "ae e342 n14 n13 EdgeDirection=W\n" +
                "ae e343 n6 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e344 n10 n13 EdgeDirection=S\n" +
                "ae e345 n10 n11 EdgeDirection=E\n" +
                "ae e346 n10 n6 EdgeDirection=SE\n" +
                "ae e347 n6 n46 EdgeDirection=SW\n" +
                "an n46 label:I ui.class:I\n" +
                "ae e348 n46 n24 EdgeDirection=SW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e349 n24 n27 EdgeDirection=S\n" +
                "ae e350 n24 n19 EdgeDirection=SW\n" +
                "ae e351 n24 n25 EdgeDirection=E\n" +
                "ae e352 n24 n21 EdgeDirection=SE\n" +
                "ae e353 n24 n46 EdgeDirection=NE\n" +
                "ae e354 n24 n48 EdgeDirection=NW\n" +
                "ae e355 n24 n23 EdgeDirection=W\n" +
                "ae e356 n46 n53 EdgeDirection=NE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e357 n53 n56 EdgeDirection=S\n" +
                "ae e358 n53 n46 EdgeDirection=SW\n" +
                "ae e359 n53 n47 EdgeDirection=NE\n" +
                "ae e360 n53 n48 EdgeDirection=SE\n" +
                "ae e361 n53 n50 EdgeDirection=N\n" +
                "ae e362 n53 n54 EdgeDirection=E\n" +
                "ae e363 n53 n45 EdgeDirection=NW\n" +
                "ae e364 n53 n52 EdgeDirection=W\n" +
                "ae e365 n46 n25 EdgeDirection=SE\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e366 n25 n28 EdgeDirection=S\n" +
                "ae e367 n25 n21 EdgeDirection=SW\n" +
                "ae e368 n25 n48 EdgeDirection=NE\n" +
                "ae e369 n25 n46 EdgeDirection=NW\n" +
                "ae e370 n25 n24 EdgeDirection=W\n" +
                "ae e371 n46 n52 EdgeDirection=NW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e372 n52 n55 EdgeDirection=S\n" +
                "ae e373 n52 n49 EdgeDirection=N\n" +
                "ae e374 n52 n45 EdgeDirection=NE\n" +
                "ae e375 n52 n46 EdgeDirection=SE\n" +
                "ae e376 n52 n53 EdgeDirection=E\n" +
                "ae e377 n6 n47 EdgeDirection=NE\n" +
                "an n47 label:I ui.class:I\n" +
                "ae e378 n47 n53 EdgeDirection=SW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e379 n53 n56 EdgeDirection=S\n" +
                "ae e380 n53 n46 EdgeDirection=SW\n" +
                "ae e381 n53 n47 EdgeDirection=NE\n" +
                "ae e382 n53 n48 EdgeDirection=SE\n" +
                "ae e383 n53 n50 EdgeDirection=N\n" +
                "ae e384 n53 n54 EdgeDirection=E\n" +
                "ae e385 n53 n45 EdgeDirection=NW\n" +
                "ae e386 n53 n52 EdgeDirection=W\n" +
                "ae e387 n47 n51 EdgeDirection=NE\n" +
                "an n51 label:E ui.class:E\n" +
                "ae e388 n51 n54 EdgeDirection=S\n" +
                "ae e389 n51 n47 EdgeDirection=SW\n" +
                "ae e390 n51 n50 EdgeDirection=W\n" +
                "ae e391 n47 n54 EdgeDirection=SE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e392 n54 n57 EdgeDirection=S\n" +
                "ae e393 n54 n48 EdgeDirection=SW\n" +
                "ae e394 n54 n51 EdgeDirection=N\n" +
                "ae e395 n54 n47 EdgeDirection=NW\n" +
                "ae e396 n54 n53 EdgeDirection=W\n" +
                "ae e397 n47 n50 EdgeDirection=NW\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e398 n50 n53 EdgeDirection=S\n" +
                "ae e399 n50 n45 EdgeDirection=SW\n" +
                "ae e400 n50 n51 EdgeDirection=E\n" +
                "ae e401 n50 n47 EdgeDirection=SE\n" +
                "ae e402 n50 n49 EdgeDirection=W\n" +
                "ae e403 n6 n48 EdgeDirection=SE\n" +
                "an n48 label:I ui.class:I\n" +
                "ae e404 n48 n25 EdgeDirection=SW\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e405 n25 n28 EdgeDirection=S\n" +
                "ae e406 n25 n21 EdgeDirection=SW\n" +
                "ae e407 n25 n48 EdgeDirection=NE\n" +
                "ae e408 n25 n46 EdgeDirection=NW\n" +
                "ae e409 n25 n24 EdgeDirection=W\n" +
                "ae e410 n48 n54 EdgeDirection=NE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e411 n54 n57 EdgeDirection=S\n" +
                "ae e412 n54 n48 EdgeDirection=SW\n" +
                "ae e413 n54 n51 EdgeDirection=N\n" +
                "ae e414 n54 n47 EdgeDirection=NW\n" +
                "ae e415 n54 n53 EdgeDirection=W\n" +
                "ae e416 n48 n24 EdgeDirection=SE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e417 n24 n27 EdgeDirection=S\n" +
                "ae e418 n24 n19 EdgeDirection=SW\n" +
                "ae e419 n24 n25 EdgeDirection=E\n" +
                "ae e420 n24 n21 EdgeDirection=SE\n" +
                "ae e421 n24 n46 EdgeDirection=NE\n" +
                "ae e422 n24 n48 EdgeDirection=NW\n" +
                "ae e423 n24 n23 EdgeDirection=W\n" +
                "ae e424 n48 n53 EdgeDirection=NW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e425 n53 n56 EdgeDirection=S\n" +
                "ae e426 n53 n46 EdgeDirection=SW\n" +
                "ae e427 n53 n47 EdgeDirection=NE\n" +
                "ae e428 n53 n48 EdgeDirection=SE\n" +
                "ae e429 n53 n50 EdgeDirection=N\n" +
                "ae e430 n53 n54 EdgeDirection=E\n" +
                "ae e431 n53 n45 EdgeDirection=NW\n" +
                "ae e432 n53 n52 EdgeDirection=W\n" +
                "ae e433 n6 n45 EdgeDirection=NW\n" +
                "an n45 label:I ui.class:I\n" +
                "ae e434 n45 n52 EdgeDirection=SW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e435 n52 n55 EdgeDirection=S\n" +
                "ae e436 n52 n49 EdgeDirection=N\n" +
                "ae e437 n52 n45 EdgeDirection=NE\n" +
                "ae e438 n52 n46 EdgeDirection=SE\n" +
                "ae e439 n52 n53 EdgeDirection=E\n" +
                "ae e440 n45 n50 EdgeDirection=NE\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e441 n50 n53 EdgeDirection=S\n" +
                "ae e442 n50 n45 EdgeDirection=SW\n" +
                "ae e443 n50 n51 EdgeDirection=E\n" +
                "ae e444 n50 n47 EdgeDirection=SE\n" +
                "ae e445 n50 n49 EdgeDirection=W\n" +
                "ae e446 n45 n53 EdgeDirection=SE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e447 n53 n56 EdgeDirection=S\n" +
                "ae e448 n53 n46 EdgeDirection=SW\n" +
                "ae e449 n53 n47 EdgeDirection=NE\n" +
                "ae e450 n53 n48 EdgeDirection=SE\n" +
                "ae e451 n53 n50 EdgeDirection=N\n" +
                "ae e452 n53 n54 EdgeDirection=E\n" +
                "ae e453 n53 n45 EdgeDirection=NW\n" +
                "ae e454 n53 n52 EdgeDirection=W\n" +
                "ae e455 n45 n49 EdgeDirection=NW\n" +
                "an n49 label:E ui.class:E\n" +
                "ae e456 n49 n52 EdgeDirection=S\n" +
                "ae e457 n49 n50 EdgeDirection=E\n" +
                "ae e458 n49 n45 EdgeDirection=SE\n";

        assertEquals(expected, vertex.serialize());
    }
}
