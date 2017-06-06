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
                "ae e2 n3 n5 EdgeDirection=E\n" +
                "ae e3 n3 n2 EdgeDirection=N\n" +
                "ae e4 n3 n1 EdgeDirection=NE\n" +
                "ae e5 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class:E\n" +
                "ae e6 n2 n4 EdgeDirection=E\n" +
                "ae e7 n2 n3 EdgeDirection=S\n" +
                "ae e8 n2 n1 EdgeDirection=SE\n" +
                "ae e9 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e10 n5 n4 EdgeDirection=N\n" +
                "ae e11 n5 n3 EdgeDirection=W\n" +
                "ae e12 n5 n1 EdgeDirection=NW\n" +
                "ae e13 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e14 n4 n5 EdgeDirection=S\n" +
                "ae e15 n4 n2 EdgeDirection=W\n" +
                "ae e16 n4 n1 EdgeDirection=SW\n" +
                "ae e17 n1 n7 EdgeDirection=SW\n" +
                "an n7 label:i ui.class:i\n" +
                "ae e18 n7 n16 EdgeDirection=SW\n" +
                "an n16 label:E ui.class:E\n" +
                "ae e19 n16 n17 EdgeDirection=E\n" +
                "ae e20 n16 n13 EdgeDirection=N\n" +
                "ae e21 n16 n7 EdgeDirection=NE\n" +
                "ae e22 n7 n13 EdgeDirection=NW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e23 n13 n14 EdgeDirection=E\n" +
                "ae e24 n13 n10 EdgeDirection=N\n" +
                "ae e25 n13 n16 EdgeDirection=S\n" +
                "ae e26 n13 n7 EdgeDirection=SE\n" +
                "ae e27 n13 n6 EdgeDirection=NE\n" +
                "ae e28 n7 n17 EdgeDirection=SE\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e29 n17 n18 EdgeDirection=E\n" +
                "ae e30 n17 n14 EdgeDirection=N\n" +
                "ae e31 n17 n16 EdgeDirection=W\n" +
                "ae e32 n17 n7 EdgeDirection=NW\n" +
                "ae e33 n17 n9 EdgeDirection=NE\n" +
                "ae e34 n7 n14 EdgeDirection=NE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e35 n14 n15 EdgeDirection=E\n" +
                "ae e36 n14 n11 EdgeDirection=N\n" +
                "ae e37 n14 n17 EdgeDirection=S\n" +
                "ae e38 n14 n13 EdgeDirection=W\n" +
                "ae e39 n14 n7 EdgeDirection=SW\n" +
                "ae e40 n14 n6 EdgeDirection=NW\n" +
                "ae e41 n14 n9 EdgeDirection=SE\n" +
                "ae e42 n14 n8 EdgeDirection=NE\n" +
                "ae e43 n7 n20 EdgeDirection=SW\n" +
                "an n20 label:I ui.class:I\n" +
                "ae e44 n20 n29 EdgeDirection=SW\n" +
                "an n29 label:E ui.class:E\n" +
                "ae e45 n29 n30 EdgeDirection=E\n" +
                "ae e46 n29 n26 EdgeDirection=N\n" +
                "ae e47 n29 n48 EdgeDirection=NW\n" +
                "ae e48 n29 n20 EdgeDirection=NE\n" +
                "ae e49 n20 n26 EdgeDirection=NW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e50 n26 n27 EdgeDirection=E\n" +
                "ae e51 n26 n23 EdgeDirection=N\n" +
                "ae e52 n26 n29 EdgeDirection=S\n" +
                "ae e53 n26 n48 EdgeDirection=SW\n" +
                "ae e54 n26 n20 EdgeDirection=SE\n" +
                "ae e55 n26 n47 EdgeDirection=NW\n" +
                "ae e56 n26 n19 EdgeDirection=NE\n" +
                "ae e57 n20 n30 EdgeDirection=SE\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e58 n30 n31 EdgeDirection=E\n" +
                "ae e59 n30 n27 EdgeDirection=N\n" +
                "ae e60 n30 n29 EdgeDirection=W\n" +
                "ae e61 n30 n20 EdgeDirection=NW\n" +
                "ae e62 n30 n22 EdgeDirection=NE\n" +
                "ae e63 n20 n27 EdgeDirection=NE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e64 n27 n28 EdgeDirection=E\n" +
                "ae e65 n27 n24 EdgeDirection=N\n" +
                "ae e66 n27 n30 EdgeDirection=S\n" +
                "ae e67 n27 n26 EdgeDirection=W\n" +
                "ae e68 n27 n20 EdgeDirection=SW\n" +
                "ae e69 n27 n19 EdgeDirection=NW\n" +
                "ae e70 n27 n22 EdgeDirection=SE\n" +
                "ae e71 n27 n21 EdgeDirection=NE\n" +
                "ae e72 n7 n19 EdgeDirection=NW\n" +
                "an n19 label:I ui.class:I\n" +
                "ae e73 n19 n26 EdgeDirection=SW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e74 n26 n27 EdgeDirection=E\n" +
                "ae e75 n26 n23 EdgeDirection=N\n" +
                "ae e76 n26 n29 EdgeDirection=S\n" +
                "ae e77 n26 n48 EdgeDirection=SW\n" +
                "ae e78 n26 n20 EdgeDirection=SE\n" +
                "ae e79 n26 n47 EdgeDirection=NW\n" +
                "ae e80 n26 n19 EdgeDirection=NE\n" +
                "ae e81 n19 n23 EdgeDirection=NW\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e82 n23 n24 EdgeDirection=E\n" +
                "ae e83 n23 n26 EdgeDirection=S\n" +
                "ae e84 n23 n47 EdgeDirection=SW\n" +
                "ae e85 n23 n19 EdgeDirection=SE\n" +
                "ae e86 n19 n27 EdgeDirection=SE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e87 n27 n28 EdgeDirection=E\n" +
                "ae e88 n27 n24 EdgeDirection=N\n" +
                "ae e89 n27 n30 EdgeDirection=S\n" +
                "ae e90 n27 n26 EdgeDirection=W\n" +
                "ae e91 n27 n20 EdgeDirection=SW\n" +
                "ae e92 n27 n19 EdgeDirection=NW\n" +
                "ae e93 n27 n22 EdgeDirection=SE\n" +
                "ae e94 n27 n21 EdgeDirection=NE\n" +
                "ae e95 n19 n24 EdgeDirection=NE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e96 n24 n25 EdgeDirection=E\n" +
                "ae e97 n24 n27 EdgeDirection=S\n" +
                "ae e98 n24 n23 EdgeDirection=W\n" +
                "ae e99 n24 n19 EdgeDirection=SW\n" +
                "ae e100 n24 n21 EdgeDirection=SE\n" +
                "ae e101 n24 n35 EdgeDirection=NW\n" +
                "ae e102 n24 n33 EdgeDirection=NE\n" +
                "ae e103 n7 n22 EdgeDirection=SE\n" +
                "an n22 label:I ui.class:I\n" +
                "ae e104 n22 n30 EdgeDirection=SW\n" +
                "an n30 label:E ui.class:E\n" +
                "ae e105 n30 n31 EdgeDirection=E\n" +
                "ae e106 n30 n27 EdgeDirection=N\n" +
                "ae e107 n30 n29 EdgeDirection=W\n" +
                "ae e108 n30 n20 EdgeDirection=NW\n" +
                "ae e109 n30 n22 EdgeDirection=NE\n" +
                "ae e110 n22 n27 EdgeDirection=NW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e111 n27 n28 EdgeDirection=E\n" +
                "ae e112 n27 n24 EdgeDirection=N\n" +
                "ae e113 n27 n30 EdgeDirection=S\n" +
                "ae e114 n27 n26 EdgeDirection=W\n" +
                "ae e115 n27 n20 EdgeDirection=SW\n" +
                "ae e116 n27 n19 EdgeDirection=NW\n" +
                "ae e117 n27 n22 EdgeDirection=SE\n" +
                "ae e118 n27 n21 EdgeDirection=NE\n" +
                "ae e119 n22 n31 EdgeDirection=SE\n" +
                "an n31 label:E ui.class:E\n" +
                "ae e120 n31 n28 EdgeDirection=N\n" +
                "ae e121 n31 n30 EdgeDirection=W\n" +
                "ae e122 n31 n22 EdgeDirection=NW\n" +
                "ae e123 n22 n28 EdgeDirection=NE\n" +
                "an n28 label:E ui.class:E\n" +
                "ae e124 n28 n25 EdgeDirection=N\n" +
                "ae e125 n28 n31 EdgeDirection=S\n" +
                "ae e126 n28 n27 EdgeDirection=W\n" +
                "ae e127 n28 n22 EdgeDirection=SW\n" +
                "ae e128 n28 n21 EdgeDirection=NW\n" +
                "ae e129 n7 n21 EdgeDirection=NE\n" +
                "an n21 label:I ui.class:I\n" +
                "ae e130 n21 n27 EdgeDirection=SW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e131 n27 n28 EdgeDirection=E\n" +
                "ae e132 n27 n24 EdgeDirection=N\n" +
                "ae e133 n27 n30 EdgeDirection=S\n" +
                "ae e134 n27 n26 EdgeDirection=W\n" +
                "ae e135 n27 n20 EdgeDirection=SW\n" +
                "ae e136 n27 n19 EdgeDirection=NW\n" +
                "ae e137 n27 n22 EdgeDirection=SE\n" +
                "ae e138 n27 n21 EdgeDirection=NE\n" +
                "ae e139 n21 n24 EdgeDirection=NW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e140 n24 n25 EdgeDirection=E\n" +
                "ae e141 n24 n27 EdgeDirection=S\n" +
                "ae e142 n24 n23 EdgeDirection=W\n" +
                "ae e143 n24 n19 EdgeDirection=SW\n" +
                "ae e144 n24 n21 EdgeDirection=SE\n" +
                "ae e145 n24 n35 EdgeDirection=NW\n" +
                "ae e146 n24 n33 EdgeDirection=NE\n" +
                "ae e147 n21 n28 EdgeDirection=SE\n" +
                "an n28 label:E ui.class:E\n" +
                "ae e148 n28 n25 EdgeDirection=N\n" +
                "ae e149 n28 n31 EdgeDirection=S\n" +
                "ae e150 n28 n27 EdgeDirection=W\n" +
                "ae e151 n28 n22 EdgeDirection=SW\n" +
                "ae e152 n28 n21 EdgeDirection=NW\n" +
                "ae e153 n21 n25 EdgeDirection=NE\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e154 n25 n28 EdgeDirection=S\n" +
                "ae e155 n25 n24 EdgeDirection=W\n" +
                "ae e156 n25 n21 EdgeDirection=SW\n" +
                "ae e157 n25 n33 EdgeDirection=NW\n" +
                "ae e158 n25 n35 EdgeDirection=NE\n" +
                "ae e159 n1 n6 EdgeDirection=NW\n" +
                "an n6 label:i ui.class:i\n" +
                "ae e160 n6 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e161 n13 n14 EdgeDirection=E\n" +
                "ae e162 n13 n10 EdgeDirection=N\n" +
                "ae e163 n13 n16 EdgeDirection=S\n" +
                "ae e164 n13 n7 EdgeDirection=SE\n" +
                "ae e165 n13 n6 EdgeDirection=NE\n" +
                "ae e166 n6 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e167 n10 n11 EdgeDirection=E\n" +
                "ae e168 n10 n13 EdgeDirection=S\n" +
                "ae e169 n10 n6 EdgeDirection=SE\n" +
                "ae e170 n6 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e171 n14 n15 EdgeDirection=E\n" +
                "ae e172 n14 n11 EdgeDirection=N\n" +
                "ae e173 n14 n17 EdgeDirection=S\n" +
                "ae e174 n14 n13 EdgeDirection=W\n" +
                "ae e175 n14 n7 EdgeDirection=SW\n" +
                "ae e176 n14 n6 EdgeDirection=NW\n" +
                "ae e177 n14 n9 EdgeDirection=SE\n" +
                "ae e178 n14 n8 EdgeDirection=NE\n" +
                "ae e179 n6 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e180 n11 n12 EdgeDirection=E\n" +
                "ae e181 n11 n14 EdgeDirection=S\n" +
                "ae e182 n11 n10 EdgeDirection=W\n" +
                "ae e183 n11 n6 EdgeDirection=SW\n" +
                "ae e184 n11 n8 EdgeDirection=SE\n" +
                "ae e185 n6 n33 EdgeDirection=SW\n" +
                "an n33 label:I ui.class:I\n" +
                "ae e186 n33 n24 EdgeDirection=SW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e187 n24 n25 EdgeDirection=E\n" +
                "ae e188 n24 n27 EdgeDirection=S\n" +
                "ae e189 n24 n23 EdgeDirection=W\n" +
                "ae e190 n24 n19 EdgeDirection=SW\n" +
                "ae e191 n24 n21 EdgeDirection=SE\n" +
                "ae e192 n24 n35 EdgeDirection=NW\n" +
                "ae e193 n24 n33 EdgeDirection=NE\n" +
                "ae e194 n33 n39 EdgeDirection=NW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e195 n39 n40 EdgeDirection=E\n" +
                "ae e196 n39 n36 EdgeDirection=N\n" +
                "ae e197 n39 n42 EdgeDirection=S\n" +
                "ae e198 n39 n33 EdgeDirection=SE\n" +
                "ae e199 n39 n32 EdgeDirection=NE\n" +
                "ae e200 n33 n25 EdgeDirection=SE\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e201 n25 n28 EdgeDirection=S\n" +
                "ae e202 n25 n24 EdgeDirection=W\n" +
                "ae e203 n25 n21 EdgeDirection=SW\n" +
                "ae e204 n25 n33 EdgeDirection=NW\n" +
                "ae e205 n25 n35 EdgeDirection=NE\n" +
                "ae e206 n33 n40 EdgeDirection=NE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e207 n40 n41 EdgeDirection=E\n" +
                "ae e208 n40 n37 EdgeDirection=N\n" +
                "ae e209 n40 n43 EdgeDirection=S\n" +
                "ae e210 n40 n39 EdgeDirection=W\n" +
                "ae e211 n40 n33 EdgeDirection=SW\n" +
                "ae e212 n40 n32 EdgeDirection=NW\n" +
                "ae e213 n40 n35 EdgeDirection=SE\n" +
                "ae e214 n40 n34 EdgeDirection=NE\n" +
                "ae e215 n6 n32 EdgeDirection=NW\n" +
                "an n32 label:I ui.class:I\n" +
                "ae e216 n32 n39 EdgeDirection=SW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e217 n39 n40 EdgeDirection=E\n" +
                "ae e218 n39 n36 EdgeDirection=N\n" +
                "ae e219 n39 n42 EdgeDirection=S\n" +
                "ae e220 n39 n33 EdgeDirection=SE\n" +
                "ae e221 n39 n32 EdgeDirection=NE\n" +
                "ae e222 n32 n36 EdgeDirection=NW\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e223 n36 n37 EdgeDirection=E\n" +
                "ae e224 n36 n39 EdgeDirection=S\n" +
                "ae e225 n36 n32 EdgeDirection=SE\n" +
                "ae e226 n32 n40 EdgeDirection=SE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e227 n40 n41 EdgeDirection=E\n" +
                "ae e228 n40 n37 EdgeDirection=N\n" +
                "ae e229 n40 n43 EdgeDirection=S\n" +
                "ae e230 n40 n39 EdgeDirection=W\n" +
                "ae e231 n40 n33 EdgeDirection=SW\n" +
                "ae e232 n40 n32 EdgeDirection=NW\n" +
                "ae e233 n40 n35 EdgeDirection=SE\n" +
                "ae e234 n40 n34 EdgeDirection=NE\n" +
                "ae e235 n32 n37 EdgeDirection=NE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e236 n37 n38 EdgeDirection=E\n" +
                "ae e237 n37 n40 EdgeDirection=S\n" +
                "ae e238 n37 n36 EdgeDirection=W\n" +
                "ae e239 n37 n32 EdgeDirection=SW\n" +
                "ae e240 n37 n34 EdgeDirection=SE\n" +
                "ae e241 n6 n35 EdgeDirection=SE\n" +
                "an n35 label:I ui.class:I\n" +
                "ae e242 n35 n25 EdgeDirection=SW\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e243 n25 n28 EdgeDirection=S\n" +
                "ae e244 n25 n24 EdgeDirection=W\n" +
                "ae e245 n25 n21 EdgeDirection=SW\n" +
                "ae e246 n25 n33 EdgeDirection=NW\n" +
                "ae e247 n25 n35 EdgeDirection=NE\n" +
                "ae e248 n35 n40 EdgeDirection=NW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e249 n40 n41 EdgeDirection=E\n" +
                "ae e250 n40 n37 EdgeDirection=N\n" +
                "ae e251 n40 n43 EdgeDirection=S\n" +
                "ae e252 n40 n39 EdgeDirection=W\n" +
                "ae e253 n40 n33 EdgeDirection=SW\n" +
                "ae e254 n40 n32 EdgeDirection=NW\n" +
                "ae e255 n40 n35 EdgeDirection=SE\n" +
                "ae e256 n40 n34 EdgeDirection=NE\n" +
                "ae e257 n35 n24 EdgeDirection=SE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e258 n24 n25 EdgeDirection=E\n" +
                "ae e259 n24 n27 EdgeDirection=S\n" +
                "ae e260 n24 n23 EdgeDirection=W\n" +
                "ae e261 n24 n19 EdgeDirection=SW\n" +
                "ae e262 n24 n21 EdgeDirection=SE\n" +
                "ae e263 n24 n35 EdgeDirection=NW\n" +
                "ae e264 n24 n33 EdgeDirection=NE\n" +
                "ae e265 n35 n41 EdgeDirection=NE\n" +
                "an n41 label:E ui.class:E\n" +
                "ae e266 n41 n38 EdgeDirection=N\n" +
                "ae e267 n41 n44 EdgeDirection=S\n" +
                "ae e268 n41 n40 EdgeDirection=W\n" +
                "ae e269 n41 n35 EdgeDirection=SW\n" +
                "ae e270 n41 n34 EdgeDirection=NW\n" +
                "ae e271 n6 n34 EdgeDirection=NE\n" +
                "an n34 label:I ui.class:I\n" +
                "ae e272 n34 n40 EdgeDirection=SW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e273 n40 n41 EdgeDirection=E\n" +
                "ae e274 n40 n37 EdgeDirection=N\n" +
                "ae e275 n40 n43 EdgeDirection=S\n" +
                "ae e276 n40 n39 EdgeDirection=W\n" +
                "ae e277 n40 n33 EdgeDirection=SW\n" +
                "ae e278 n40 n32 EdgeDirection=NW\n" +
                "ae e279 n40 n35 EdgeDirection=SE\n" +
                "ae e280 n40 n34 EdgeDirection=NE\n" +
                "ae e281 n34 n37 EdgeDirection=NW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e282 n37 n38 EdgeDirection=E\n" +
                "ae e283 n37 n40 EdgeDirection=S\n" +
                "ae e284 n37 n36 EdgeDirection=W\n" +
                "ae e285 n37 n32 EdgeDirection=SW\n" +
                "ae e286 n37 n34 EdgeDirection=SE\n" +
                "ae e287 n34 n41 EdgeDirection=SE\n" +
                "an n41 label:E ui.class:E\n" +
                "ae e288 n41 n38 EdgeDirection=N\n" +
                "ae e289 n41 n44 EdgeDirection=S\n" +
                "ae e290 n41 n40 EdgeDirection=W\n" +
                "ae e291 n41 n35 EdgeDirection=SW\n" +
                "ae e292 n41 n34 EdgeDirection=NW\n" +
                "ae e293 n34 n38 EdgeDirection=NE\n" +
                "an n38 label:E ui.class:E\n" +
                "ae e294 n38 n41 EdgeDirection=S\n" +
                "ae e295 n38 n37 EdgeDirection=W\n" +
                "ae e296 n38 n34 EdgeDirection=SW\n" +
                "ae e297 n1 n9 EdgeDirection=SE\n" +
                "an n9 label:I ui.class:I\n" +
                "ae e298 n9 n17 EdgeDirection=SW\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e299 n17 n18 EdgeDirection=E\n" +
                "ae e300 n17 n14 EdgeDirection=N\n" +
                "ae e301 n17 n16 EdgeDirection=W\n" +
                "ae e302 n17 n7 EdgeDirection=NW\n" +
                "ae e303 n17 n9 EdgeDirection=NE\n" +
                "ae e304 n9 n14 EdgeDirection=NW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e305 n14 n15 EdgeDirection=E\n" +
                "ae e306 n14 n11 EdgeDirection=N\n" +
                "ae e307 n14 n17 EdgeDirection=S\n" +
                "ae e308 n14 n13 EdgeDirection=W\n" +
                "ae e309 n14 n7 EdgeDirection=SW\n" +
                "ae e310 n14 n6 EdgeDirection=NW\n" +
                "ae e311 n14 n9 EdgeDirection=SE\n" +
                "ae e312 n14 n8 EdgeDirection=NE\n" +
                "ae e313 n9 n18 EdgeDirection=SE\n" +
                "an n18 label:E ui.class:E\n" +
                "ae e314 n18 n15 EdgeDirection=N\n" +
                "ae e315 n18 n17 EdgeDirection=W\n" +
                "ae e316 n18 n9 EdgeDirection=NW\n" +
                "ae e317 n9 n15 EdgeDirection=NE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e318 n15 n12 EdgeDirection=N\n" +
                "ae e319 n15 n18 EdgeDirection=S\n" +
                "ae e320 n15 n14 EdgeDirection=W\n" +
                "ae e321 n15 n9 EdgeDirection=SW\n" +
                "ae e322 n15 n8 EdgeDirection=NW\n" +
                "ae e323 n1 n8 EdgeDirection=NE\n" +
                "an n8 label:i ui.class:i\n" +
                "ae e324 n8 n14 EdgeDirection=SW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e325 n14 n15 EdgeDirection=E\n" +
                "ae e326 n14 n11 EdgeDirection=N\n" +
                "ae e327 n14 n17 EdgeDirection=S\n" +
                "ae e328 n14 n13 EdgeDirection=W\n" +
                "ae e329 n14 n7 EdgeDirection=SW\n" +
                "ae e330 n14 n6 EdgeDirection=NW\n" +
                "ae e331 n14 n9 EdgeDirection=SE\n" +
                "ae e332 n14 n8 EdgeDirection=NE\n" +
                "ae e333 n8 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e334 n11 n12 EdgeDirection=E\n" +
                "ae e335 n11 n14 EdgeDirection=S\n" +
                "ae e336 n11 n10 EdgeDirection=W\n" +
                "ae e337 n11 n6 EdgeDirection=SW\n" +
                "ae e338 n11 n8 EdgeDirection=SE\n" +
                "ae e339 n8 n15 EdgeDirection=SE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e340 n15 n12 EdgeDirection=N\n" +
                "ae e341 n15 n18 EdgeDirection=S\n" +
                "ae e342 n15 n14 EdgeDirection=W\n" +
                "ae e343 n15 n9 EdgeDirection=SW\n" +
                "ae e344 n15 n8 EdgeDirection=NW\n" +
                "ae e345 n8 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e346 n12 n15 EdgeDirection=S\n" +
                "ae e347 n12 n11 EdgeDirection=W\n" +
                "ae e348 n12 n8 EdgeDirection=SW\n" +
                "ae e349 n8 n46 EdgeDirection=SW\n" +
                "an n46 label:I ui.class:I\n" +
                "ae e350 n46 n55 EdgeDirection=SW\n" +
                "an n55 label:E ui.class:E\n" +
                "ae e351 n55 n56 EdgeDirection=E\n" +
                "ae e352 n55 n52 EdgeDirection=N\n" +
                "ae e353 n55 n46 EdgeDirection=NE\n" +
                "ae e354 n46 n52 EdgeDirection=NW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e355 n52 n53 EdgeDirection=E\n" +
                "ae e356 n52 n49 EdgeDirection=N\n" +
                "ae e357 n52 n55 EdgeDirection=S\n" +
                "ae e358 n52 n46 EdgeDirection=SE\n" +
                "ae e359 n52 n45 EdgeDirection=NE\n" +
                "ae e360 n46 n56 EdgeDirection=SE\n" +
                "an n56 label:E ui.class:E\n" +
                "ae e361 n56 n57 EdgeDirection=E\n" +
                "ae e362 n56 n53 EdgeDirection=N\n" +
                "ae e363 n56 n55 EdgeDirection=W\n" +
                "ae e364 n56 n46 EdgeDirection=NW\n" +
                "ae e365 n56 n48 EdgeDirection=NE\n" +
                "ae e366 n46 n53 EdgeDirection=NE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e367 n53 n54 EdgeDirection=E\n" +
                "ae e368 n53 n50 EdgeDirection=N\n" +
                "ae e369 n53 n56 EdgeDirection=S\n" +
                "ae e370 n53 n52 EdgeDirection=W\n" +
                "ae e371 n53 n46 EdgeDirection=SW\n" +
                "ae e372 n53 n45 EdgeDirection=NW\n" +
                "ae e373 n53 n48 EdgeDirection=SE\n" +
                "ae e374 n53 n47 EdgeDirection=NE\n" +
                "ae e375 n8 n45 EdgeDirection=NW\n" +
                "an n45 label:I ui.class:I\n" +
                "ae e376 n45 n52 EdgeDirection=SW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e377 n52 n53 EdgeDirection=E\n" +
                "ae e378 n52 n49 EdgeDirection=N\n" +
                "ae e379 n52 n55 EdgeDirection=S\n" +
                "ae e380 n52 n46 EdgeDirection=SE\n" +
                "ae e381 n52 n45 EdgeDirection=NE\n" +
                "ae e382 n45 n49 EdgeDirection=NW\n" +
                "an n49 label:E ui.class:E\n" +
                "ae e383 n49 n50 EdgeDirection=E\n" +
                "ae e384 n49 n52 EdgeDirection=S\n" +
                "ae e385 n49 n45 EdgeDirection=SE\n" +
                "ae e386 n45 n53 EdgeDirection=SE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e387 n53 n54 EdgeDirection=E\n" +
                "ae e388 n53 n50 EdgeDirection=N\n" +
                "ae e389 n53 n56 EdgeDirection=S\n" +
                "ae e390 n53 n52 EdgeDirection=W\n" +
                "ae e391 n53 n46 EdgeDirection=SW\n" +
                "ae e392 n53 n45 EdgeDirection=NW\n" +
                "ae e393 n53 n48 EdgeDirection=SE\n" +
                "ae e394 n53 n47 EdgeDirection=NE\n" +
                "ae e395 n45 n50 EdgeDirection=NE\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e396 n50 n51 EdgeDirection=E\n" +
                "ae e397 n50 n53 EdgeDirection=S\n" +
                "ae e398 n50 n49 EdgeDirection=W\n" +
                "ae e399 n50 n45 EdgeDirection=SW\n" +
                "ae e400 n50 n47 EdgeDirection=SE\n" +
                "ae e401 n8 n48 EdgeDirection=SE\n" +
                "an n48 label:I ui.class:I\n" +
                "ae e402 n48 n56 EdgeDirection=SW\n" +
                "an n56 label:E ui.class:E\n" +
                "ae e403 n56 n57 EdgeDirection=E\n" +
                "ae e404 n56 n53 EdgeDirection=N\n" +
                "ae e405 n56 n55 EdgeDirection=W\n" +
                "ae e406 n56 n46 EdgeDirection=NW\n" +
                "ae e407 n56 n48 EdgeDirection=NE\n" +
                "ae e408 n48 n53 EdgeDirection=NW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e409 n53 n54 EdgeDirection=E\n" +
                "ae e410 n53 n50 EdgeDirection=N\n" +
                "ae e411 n53 n56 EdgeDirection=S\n" +
                "ae e412 n53 n52 EdgeDirection=W\n" +
                "ae e413 n53 n46 EdgeDirection=SW\n" +
                "ae e414 n53 n45 EdgeDirection=NW\n" +
                "ae e415 n53 n48 EdgeDirection=SE\n" +
                "ae e416 n53 n47 EdgeDirection=NE\n" +
                "ae e417 n48 n29 EdgeDirection=SE\n" +
                "an n29 label:E ui.class:E\n" +
                "ae e418 n29 n30 EdgeDirection=E\n" +
                "ae e419 n29 n26 EdgeDirection=N\n" +
                "ae e420 n29 n48 EdgeDirection=NW\n" +
                "ae e421 n29 n20 EdgeDirection=NE\n" +
                "ae e422 n48 n26 EdgeDirection=NE\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e423 n26 n27 EdgeDirection=E\n" +
                "ae e424 n26 n23 EdgeDirection=N\n" +
                "ae e425 n26 n29 EdgeDirection=S\n" +
                "ae e426 n26 n48 EdgeDirection=SW\n" +
                "ae e427 n26 n20 EdgeDirection=SE\n" +
                "ae e428 n26 n47 EdgeDirection=NW\n" +
                "ae e429 n26 n19 EdgeDirection=NE\n" +
                "ae e430 n8 n47 EdgeDirection=NE\n" +
                "an n47 label:I ui.class:I\n" +
                "ae e431 n47 n53 EdgeDirection=SW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e432 n53 n54 EdgeDirection=E\n" +
                "ae e433 n53 n50 EdgeDirection=N\n" +
                "ae e434 n53 n56 EdgeDirection=S\n" +
                "ae e435 n53 n52 EdgeDirection=W\n" +
                "ae e436 n53 n46 EdgeDirection=SW\n" +
                "ae e437 n53 n45 EdgeDirection=NW\n" +
                "ae e438 n53 n48 EdgeDirection=SE\n" +
                "ae e439 n53 n47 EdgeDirection=NE\n" +
                "ae e440 n47 n50 EdgeDirection=NW\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e441 n50 n51 EdgeDirection=E\n" +
                "ae e442 n50 n53 EdgeDirection=S\n" +
                "ae e443 n50 n49 EdgeDirection=W\n" +
                "ae e444 n50 n45 EdgeDirection=SW\n" +
                "ae e445 n50 n47 EdgeDirection=SE\n" +
                "ae e446 n47 n26 EdgeDirection=SE\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e447 n26 n27 EdgeDirection=E\n" +
                "ae e448 n26 n23 EdgeDirection=N\n" +
                "ae e449 n26 n29 EdgeDirection=S\n" +
                "ae e450 n26 n48 EdgeDirection=SW\n" +
                "ae e451 n26 n20 EdgeDirection=SE\n" +
                "ae e452 n26 n47 EdgeDirection=NW\n" +
                "ae e453 n26 n19 EdgeDirection=NE\n" +
                "ae e454 n47 n23 EdgeDirection=NE\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e455 n23 n24 EdgeDirection=E\n" +
                "ae e456 n23 n26 EdgeDirection=S\n" +
                "ae e457 n23 n47 EdgeDirection=SW\n" +
                "ae e458 n23 n19 EdgeDirection=SE\n";

        System.out.println(vertex.serialize());

//        assertEquals(expected, vertex.serialize());
    }
}
