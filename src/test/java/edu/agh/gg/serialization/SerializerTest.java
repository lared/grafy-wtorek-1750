package edu.agh.gg.serialization;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.grammar.P0;
import edu.agh.gg.grammar.P1;
import edu.agh.gg.grammar.P2;
import edu.agh.gg.grammar.P3;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SerializerTest {
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

        List<String> serializedLines = Arrays.asList(vertex.serialize().split("\n"));
        List<String> expectedLines = Arrays.asList(
                ("an n1 label:i ui.class:i\n" +
                "ae e1 n1 n2 EdgeDirection=NW\n" +
                "an n2 label:E ui.class:E\n" +
                "ae e2 n2 n4 EdgeDirection=E\n" +
                "ae e3 n2 n1 EdgeDirection=SE\n" +
                "ae e4 n2 n3 EdgeDirection=S\n" +
                "ae e5 n1 n4 EdgeDirection=NE\n" +
                "an n4 label:E ui.class:E\n" +
                "ae e6 n4 n1 EdgeDirection=SW\n" +
                "ae e7 n4 n5 EdgeDirection=S\n" +
                "ae e8 n4 n2 EdgeDirection=W\n" +
                "ae e9 n1 n3 EdgeDirection=SW\n" +
                "an n3 label:E ui.class:E\n" +
                "ae e10 n3 n1 EdgeDirection=NE\n" +
                "ae e11 n3 n5 EdgeDirection=E\n" +
                "ae e12 n3 n2 EdgeDirection=N\n" +
                "ae e13 n1 n5 EdgeDirection=SE\n" +
                "an n5 label:E ui.class:E\n" +
                "ae e14 n5 n1 EdgeDirection=NW\n" +
                "ae e15 n5 n3 EdgeDirection=W\n" +
                "ae e16 n5 n4 EdgeDirection=N\n" +
                "ae e17 n1 n6 EdgeDirection=NW\n" +
                "an n6 label:i ui.class:i\n" +
                "ae e18 n6 n10 EdgeDirection=NW\n" +
                "an n10 label:E ui.class:E\n" +
                "ae e19 n10 n11 EdgeDirection=E\n" +
                "ae e20 n10 n6 EdgeDirection=SE\n" +
                "ae e21 n10 n13 EdgeDirection=S\n" +
                "ae e22 n6 n11 EdgeDirection=NE\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e23 n11 n12 EdgeDirection=E\n" +
                "ae e24 n11 n6 EdgeDirection=SW\n" +
                "ae e25 n11 n8 EdgeDirection=SE\n" +
                "ae e26 n11 n14 EdgeDirection=S\n" +
                "ae e27 n11 n10 EdgeDirection=W\n" +
                "ae e28 n6 n13 EdgeDirection=SW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e29 n13 n6 EdgeDirection=NE\n" +
                "ae e30 n13 n14 EdgeDirection=E\n" +
                "ae e31 n13 n7 EdgeDirection=SE\n" +
                "ae e32 n13 n16 EdgeDirection=S\n" +
                "ae e33 n13 n10 EdgeDirection=N\n" +
                "ae e34 n6 n14 EdgeDirection=SE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e35 n14 n6 EdgeDirection=NW\n" +
                "ae e36 n14 n8 EdgeDirection=NE\n" +
                "ae e37 n14 n7 EdgeDirection=SW\n" +
                "ae e38 n14 n15 EdgeDirection=E\n" +
                "ae e39 n14 n9 EdgeDirection=SE\n" +
                "ae e40 n14 n17 EdgeDirection=S\n" +
                "ae e41 n14 n13 EdgeDirection=W\n" +
                "ae e42 n14 n11 EdgeDirection=N\n" +
                "ae e43 n6 n19 EdgeDirection=NW\n" +
                "an n19 label:I ui.class:I\n" +
                "ae e44 n19 n23 EdgeDirection=NW\n" +
                "an n23 label:E ui.class:E\n" +
                "ae e45 n23 n24 EdgeDirection=E\n" +
                "ae e46 n23 n19 EdgeDirection=SE\n" +
                "ae e47 n23 n26 EdgeDirection=S\n" +
                "ae e48 n19 n24 EdgeDirection=NE\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e49 n24 n25 EdgeDirection=E\n" +
                "ae e50 n24 n19 EdgeDirection=SW\n" +
                "ae e51 n24 n21 EdgeDirection=SE\n" +
                "ae e52 n24 n27 EdgeDirection=S\n" +
                "ae e53 n24 n23 EdgeDirection=W\n" +
                "ae e54 n19 n26 EdgeDirection=SW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e55 n26 n19 EdgeDirection=NE\n" +
                "ae e56 n26 n27 EdgeDirection=E\n" +
                "ae e57 n26 n20 EdgeDirection=SE\n" +
                "ae e58 n26 n29 EdgeDirection=S\n" +
                "ae e59 n26 n23 EdgeDirection=N\n" +
                "ae e60 n19 n27 EdgeDirection=SE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e61 n27 n19 EdgeDirection=NW\n" +
                "ae e62 n27 n21 EdgeDirection=NE\n" +
                "ae e63 n27 n20 EdgeDirection=SW\n" +
                "ae e64 n27 n28 EdgeDirection=E\n" +
                "ae e65 n27 n22 EdgeDirection=SE\n" +
                "ae e66 n27 n30 EdgeDirection=S\n" +
                "ae e67 n27 n26 EdgeDirection=W\n" +
                "ae e68 n27 n24 EdgeDirection=N\n" +
                "ae e69 n6 n21 EdgeDirection=NE\n" +
                "an n21 label:I ui.class:I\n" +
                "ae e70 n21 n24 EdgeDirection=NW\n" +
                "an n24 label:E ui.class:E\n" +
                "ae e71 n24 n25 EdgeDirection=E\n" +
                "ae e72 n24 n19 EdgeDirection=SW\n" +
                "ae e73 n24 n21 EdgeDirection=SE\n" +
                "ae e74 n24 n27 EdgeDirection=S\n" +
                "ae e75 n24 n23 EdgeDirection=W\n" +
                "ae e76 n21 n25 EdgeDirection=NE\n" +
                "an n25 label:E ui.class:E\n" +
                "ae e77 n25 n21 EdgeDirection=SW\n" +
                "ae e78 n25 n28 EdgeDirection=S\n" +
                "ae e79 n25 n24 EdgeDirection=W\n" +
                "ae e80 n21 n27 EdgeDirection=SW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e81 n27 n19 EdgeDirection=NW\n" +
                "ae e82 n27 n21 EdgeDirection=NE\n" +
                "ae e83 n27 n20 EdgeDirection=SW\n" +
                "ae e84 n27 n28 EdgeDirection=E\n" +
                "ae e85 n27 n22 EdgeDirection=SE\n" +
                "ae e86 n27 n30 EdgeDirection=S\n" +
                "ae e87 n27 n26 EdgeDirection=W\n" +
                "ae e88 n27 n24 EdgeDirection=N\n" +
                "ae e89 n21 n28 EdgeDirection=SE\n" +
                "an n28 label:E ui.class:E\n" +
                "ae e90 n28 n21 EdgeDirection=NW\n" +
                "ae e91 n28 n22 EdgeDirection=SW\n" +
                "ae e92 n28 n31 EdgeDirection=S\n" +
                "ae e93 n28 n27 EdgeDirection=W\n" +
                "ae e94 n28 n25 EdgeDirection=N\n" +
                "ae e95 n6 n20 EdgeDirection=SW\n" +
                "an n20 label:I ui.class:I\n" +
                "ae e96 n20 n26 EdgeDirection=NW\n" +
                "an n26 label:E ui.class:E\n" +
                "ae e97 n26 n19 EdgeDirection=NE\n" +
                "ae e98 n26 n27 EdgeDirection=E\n" +
                "ae e99 n26 n20 EdgeDirection=SE\n" +
                "ae e100 n26 n29 EdgeDirection=S\n" +
                "ae e101 n26 n23 EdgeDirection=N\n" +
                "ae e102 n20 n27 EdgeDirection=NE\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e103 n27 n19 EdgeDirection=NW\n" +
                "ae e104 n27 n21 EdgeDirection=NE\n" +
                "ae e105 n27 n20 EdgeDirection=SW\n" +
                "ae e106 n27 n28 EdgeDirection=E\n" +
                "ae e107 n27 n22 EdgeDirection=SE\n" +
                "ae e108 n27 n30 EdgeDirection=S\n" +
                "ae e109 n27 n26 EdgeDirection=W\n" +
                "ae e110 n27 n24 EdgeDirection=N\n" +
                "ae e111 n20 n50 EdgeDirection=SW\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e112 n50 n22 EdgeDirection=NW\n" +
                "ae e113 n50 n20 EdgeDirection=NE\n" +
                "ae e114 n50 n51 EdgeDirection=E\n" +
                "ae e115 n50 n45 EdgeDirection=SW\n" +
                "ae e116 n50 n47 EdgeDirection=SE\n" +
                "ae e117 n50 n53 EdgeDirection=S\n" +
                "ae e118 n50 n49 EdgeDirection=W\n" +
                "ae e119 n20 n51 EdgeDirection=SE\n" +
                "an n51 label:E ui.class:E\n" +
                "ae e120 n51 n20 EdgeDirection=NW\n" +
                "ae e121 n51 n22 EdgeDirection=NE\n" +
                "ae e122 n51 n47 EdgeDirection=SW\n" +
                "ae e123 n51 n54 EdgeDirection=S\n" +
                "ae e124 n51 n50 EdgeDirection=W\n" +
                "ae e125 n6 n22 EdgeDirection=SE\n" +
                "an n22 label:I ui.class:I\n" +
                "ae e126 n22 n27 EdgeDirection=NW\n" +
                "an n27 label:E ui.class:E\n" +
                "ae e127 n27 n19 EdgeDirection=NW\n" +
                "ae e128 n27 n21 EdgeDirection=NE\n" +
                "ae e129 n27 n20 EdgeDirection=SW\n" +
                "ae e130 n27 n28 EdgeDirection=E\n" +
                "ae e131 n27 n22 EdgeDirection=SE\n" +
                "ae e132 n27 n30 EdgeDirection=S\n" +
                "ae e133 n27 n26 EdgeDirection=W\n" +
                "ae e134 n27 n24 EdgeDirection=N\n" +
                "ae e135 n22 n28 EdgeDirection=NE\n" +
                "an n28 label:E ui.class:E\n" +
                "ae e136 n28 n21 EdgeDirection=NW\n" +
                "ae e137 n28 n22 EdgeDirection=SW\n" +
                "ae e138 n28 n31 EdgeDirection=S\n" +
                "ae e139 n28 n27 EdgeDirection=W\n" +
                "ae e140 n28 n25 EdgeDirection=N\n" +
                "ae e141 n22 n51 EdgeDirection=SW\n" +
                "an n51 label:E ui.class:E\n" +
                "ae e142 n51 n20 EdgeDirection=NW\n" +
                "ae e143 n51 n22 EdgeDirection=NE\n" +
                "ae e144 n51 n47 EdgeDirection=SW\n" +
                "ae e145 n51 n54 EdgeDirection=S\n" +
                "ae e146 n51 n50 EdgeDirection=W\n" +
                "ae e147 n22 n50 EdgeDirection=SE\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e148 n50 n22 EdgeDirection=NW\n" +
                "ae e149 n50 n20 EdgeDirection=NE\n" +
                "ae e150 n50 n51 EdgeDirection=E\n" +
                "ae e151 n50 n45 EdgeDirection=SW\n" +
                "ae e152 n50 n47 EdgeDirection=SE\n" +
                "ae e153 n50 n53 EdgeDirection=S\n" +
                "ae e154 n50 n49 EdgeDirection=W\n" +
                "ae e155 n1 n8 EdgeDirection=NE\n" +
                "an n8 label:i ui.class:i\n" +
                "ae e156 n8 n11 EdgeDirection=NW\n" +
                "an n11 label:E ui.class:E\n" +
                "ae e157 n11 n12 EdgeDirection=E\n" +
                "ae e158 n11 n6 EdgeDirection=SW\n" +
                "ae e159 n11 n8 EdgeDirection=SE\n" +
                "ae e160 n11 n14 EdgeDirection=S\n" +
                "ae e161 n11 n10 EdgeDirection=W\n" +
                "ae e162 n8 n12 EdgeDirection=NE\n" +
                "an n12 label:E ui.class:E\n" +
                "ae e163 n12 n8 EdgeDirection=SW\n" +
                "ae e164 n12 n15 EdgeDirection=S\n" +
                "ae e165 n12 n11 EdgeDirection=W\n" +
                "ae e166 n8 n14 EdgeDirection=SW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e167 n14 n6 EdgeDirection=NW\n" +
                "ae e168 n14 n8 EdgeDirection=NE\n" +
                "ae e169 n14 n7 EdgeDirection=SW\n" +
                "ae e170 n14 n15 EdgeDirection=E\n" +
                "ae e171 n14 n9 EdgeDirection=SE\n" +
                "ae e172 n14 n17 EdgeDirection=S\n" +
                "ae e173 n14 n13 EdgeDirection=W\n" +
                "ae e174 n14 n11 EdgeDirection=N\n" +
                "ae e175 n8 n15 EdgeDirection=SE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e176 n15 n8 EdgeDirection=NW\n" +
                "ae e177 n15 n9 EdgeDirection=SW\n" +
                "ae e178 n15 n18 EdgeDirection=S\n" +
                "ae e179 n15 n14 EdgeDirection=W\n" +
                "ae e180 n15 n12 EdgeDirection=N\n" +
                "ae e181 n8 n32 EdgeDirection=NW\n" +
                "an n32 label:I ui.class:I\n" +
                "ae e182 n32 n36 EdgeDirection=NW\n" +
                "an n36 label:E ui.class:E\n" +
                "ae e183 n36 n37 EdgeDirection=E\n" +
                "ae e184 n36 n32 EdgeDirection=SE\n" +
                "ae e185 n36 n39 EdgeDirection=S\n" +
                "ae e186 n32 n37 EdgeDirection=NE\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e187 n37 n38 EdgeDirection=E\n" +
                "ae e188 n37 n32 EdgeDirection=SW\n" +
                "ae e189 n37 n34 EdgeDirection=SE\n" +
                "ae e190 n37 n40 EdgeDirection=S\n" +
                "ae e191 n37 n36 EdgeDirection=W\n" +
                "ae e192 n32 n39 EdgeDirection=SW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e193 n39 n32 EdgeDirection=NE\n" +
                "ae e194 n39 n40 EdgeDirection=E\n" +
                "ae e195 n39 n33 EdgeDirection=SE\n" +
                "ae e196 n39 n42 EdgeDirection=S\n" +
                "ae e197 n39 n36 EdgeDirection=N\n" +
                "ae e198 n32 n40 EdgeDirection=SE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e199 n40 n32 EdgeDirection=NW\n" +
                "ae e200 n40 n34 EdgeDirection=NE\n" +
                "ae e201 n40 n33 EdgeDirection=SW\n" +
                "ae e202 n40 n41 EdgeDirection=E\n" +
                "ae e203 n40 n35 EdgeDirection=SE\n" +
                "ae e204 n40 n43 EdgeDirection=S\n" +
                "ae e205 n40 n39 EdgeDirection=W\n" +
                "ae e206 n40 n37 EdgeDirection=N\n" +
                "ae e207 n8 n34 EdgeDirection=NE\n" +
                "an n34 label:I ui.class:I\n" +
                "ae e208 n34 n37 EdgeDirection=NW\n" +
                "an n37 label:E ui.class:E\n" +
                "ae e209 n37 n38 EdgeDirection=E\n" +
                "ae e210 n37 n32 EdgeDirection=SW\n" +
                "ae e211 n37 n34 EdgeDirection=SE\n" +
                "ae e212 n37 n40 EdgeDirection=S\n" +
                "ae e213 n37 n36 EdgeDirection=W\n" +
                "ae e214 n34 n49 EdgeDirection=NE\n" +
                "an n49 label:E ui.class:E\n" +
                "ae e215 n49 n50 EdgeDirection=E\n" +
                "ae e216 n49 n34 EdgeDirection=SW\n" +
                "ae e217 n49 n45 EdgeDirection=SE\n" +
                "ae e218 n49 n52 EdgeDirection=S\n" +
                "ae e219 n34 n40 EdgeDirection=SW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e220 n40 n32 EdgeDirection=NW\n" +
                "ae e221 n40 n34 EdgeDirection=NE\n" +
                "ae e222 n40 n33 EdgeDirection=SW\n" +
                "ae e223 n40 n41 EdgeDirection=E\n" +
                "ae e224 n40 n35 EdgeDirection=SE\n" +
                "ae e225 n40 n43 EdgeDirection=S\n" +
                "ae e226 n40 n39 EdgeDirection=W\n" +
                "ae e227 n40 n37 EdgeDirection=N\n" +
                "ae e228 n34 n52 EdgeDirection=SE\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e229 n52 n34 EdgeDirection=NW\n" +
                "ae e230 n52 n45 EdgeDirection=NE\n" +
                "ae e231 n52 n53 EdgeDirection=E\n" +
                "ae e232 n52 n35 EdgeDirection=SW\n" +
                "ae e233 n52 n46 EdgeDirection=SE\n" +
                "ae e234 n52 n55 EdgeDirection=S\n" +
                "ae e235 n52 n49 EdgeDirection=N\n" +
                "ae e236 n8 n33 EdgeDirection=SW\n" +
                "an n33 label:I ui.class:I\n" +
                "ae e237 n33 n39 EdgeDirection=NW\n" +
                "an n39 label:E ui.class:E\n" +
                "ae e238 n39 n32 EdgeDirection=NE\n" +
                "ae e239 n39 n40 EdgeDirection=E\n" +
                "ae e240 n39 n33 EdgeDirection=SE\n" +
                "ae e241 n39 n42 EdgeDirection=S\n" +
                "ae e242 n39 n36 EdgeDirection=N\n" +
                "ae e243 n33 n40 EdgeDirection=NE\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e244 n40 n32 EdgeDirection=NW\n" +
                "ae e245 n40 n34 EdgeDirection=NE\n" +
                "ae e246 n40 n33 EdgeDirection=SW\n" +
                "ae e247 n40 n41 EdgeDirection=E\n" +
                "ae e248 n40 n35 EdgeDirection=SE\n" +
                "ae e249 n40 n43 EdgeDirection=S\n" +
                "ae e250 n40 n39 EdgeDirection=W\n" +
                "ae e251 n40 n37 EdgeDirection=N\n" +
                "ae e252 n33 n42 EdgeDirection=SW\n" +
                "an n42 label:E ui.class:E\n" +
                "ae e253 n42 n33 EdgeDirection=NE\n" +
                "ae e254 n42 n43 EdgeDirection=E\n" +
                "ae e255 n42 n39 EdgeDirection=N\n" +
                "ae e256 n33 n43 EdgeDirection=SE\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e257 n43 n33 EdgeDirection=NW\n" +
                "ae e258 n43 n35 EdgeDirection=NE\n" +
                "ae e259 n43 n44 EdgeDirection=E\n" +
                "ae e260 n43 n42 EdgeDirection=W\n" +
                "ae e261 n43 n40 EdgeDirection=N\n" +
                "ae e262 n8 n35 EdgeDirection=SE\n" +
                "an n35 label:I ui.class:I\n" +
                "ae e263 n35 n40 EdgeDirection=NW\n" +
                "an n40 label:E ui.class:E\n" +
                "ae e264 n40 n32 EdgeDirection=NW\n" +
                "ae e265 n40 n34 EdgeDirection=NE\n" +
                "ae e266 n40 n33 EdgeDirection=SW\n" +
                "ae e267 n40 n41 EdgeDirection=E\n" +
                "ae e268 n40 n35 EdgeDirection=SE\n" +
                "ae e269 n40 n43 EdgeDirection=S\n" +
                "ae e270 n40 n39 EdgeDirection=W\n" +
                "ae e271 n40 n37 EdgeDirection=N\n" +
                "ae e272 n35 n52 EdgeDirection=NE\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e273 n52 n34 EdgeDirection=NW\n" +
                "ae e274 n52 n45 EdgeDirection=NE\n" +
                "ae e275 n52 n53 EdgeDirection=E\n" +
                "ae e276 n52 n35 EdgeDirection=SW\n" +
                "ae e277 n52 n46 EdgeDirection=SE\n" +
                "ae e278 n52 n55 EdgeDirection=S\n" +
                "ae e279 n52 n49 EdgeDirection=N\n" +
                "ae e280 n35 n43 EdgeDirection=SW\n" +
                "an n43 label:E ui.class:E\n" +
                "ae e281 n43 n33 EdgeDirection=NW\n" +
                "ae e282 n43 n35 EdgeDirection=NE\n" +
                "ae e283 n43 n44 EdgeDirection=E\n" +
                "ae e284 n43 n42 EdgeDirection=W\n" +
                "ae e285 n43 n40 EdgeDirection=N\n" +
                "ae e286 n35 n55 EdgeDirection=SE\n" +
                "an n55 label:E ui.class:E\n" +
                "ae e287 n55 n35 EdgeDirection=NW\n" +
                "ae e288 n55 n46 EdgeDirection=NE\n" +
                "ae e289 n55 n56 EdgeDirection=E\n" +
                "ae e290 n55 n52 EdgeDirection=N\n" +
                "ae e291 n1 n7 EdgeDirection=SW\n" +
                "an n7 label:i ui.class:i\n" +
                "ae e292 n7 n13 EdgeDirection=NW\n" +
                "an n13 label:E ui.class:E\n" +
                "ae e293 n13 n6 EdgeDirection=NE\n" +
                "ae e294 n13 n14 EdgeDirection=E\n" +
                "ae e295 n13 n7 EdgeDirection=SE\n" +
                "ae e296 n13 n16 EdgeDirection=S\n" +
                "ae e297 n13 n10 EdgeDirection=N\n" +
                "ae e298 n7 n14 EdgeDirection=NE\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e299 n14 n6 EdgeDirection=NW\n" +
                "ae e300 n14 n8 EdgeDirection=NE\n" +
                "ae e301 n14 n7 EdgeDirection=SW\n" +
                "ae e302 n14 n15 EdgeDirection=E\n" +
                "ae e303 n14 n9 EdgeDirection=SE\n" +
                "ae e304 n14 n17 EdgeDirection=S\n" +
                "ae e305 n14 n13 EdgeDirection=W\n" +
                "ae e306 n14 n11 EdgeDirection=N\n" +
                "ae e307 n7 n16 EdgeDirection=SW\n" +
                "an n16 label:E ui.class:E\n" +
                "ae e308 n16 n7 EdgeDirection=NE\n" +
                "ae e309 n16 n17 EdgeDirection=E\n" +
                "ae e310 n16 n13 EdgeDirection=N\n" +
                "ae e311 n7 n17 EdgeDirection=SE\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e312 n17 n7 EdgeDirection=NW\n" +
                "ae e313 n17 n9 EdgeDirection=NE\n" +
                "ae e314 n17 n18 EdgeDirection=E\n" +
                "ae e315 n17 n16 EdgeDirection=W\n" +
                "ae e316 n17 n14 EdgeDirection=N\n" +
                "ae e317 n7 n45 EdgeDirection=NW\n" +
                "an n45 label:I ui.class:I\n" +
                "ae e318 n45 n49 EdgeDirection=NW\n" +
                "an n49 label:E ui.class:E\n" +
                "ae e319 n49 n50 EdgeDirection=E\n" +
                "ae e320 n49 n34 EdgeDirection=SW\n" +
                "ae e321 n49 n45 EdgeDirection=SE\n" +
                "ae e322 n49 n52 EdgeDirection=S\n" +
                "ae e323 n45 n50 EdgeDirection=NE\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e324 n50 n22 EdgeDirection=NW\n" +
                "ae e325 n50 n20 EdgeDirection=NE\n" +
                "ae e326 n50 n51 EdgeDirection=E\n" +
                "ae e327 n50 n45 EdgeDirection=SW\n" +
                "ae e328 n50 n47 EdgeDirection=SE\n" +
                "ae e329 n50 n53 EdgeDirection=S\n" +
                "ae e330 n50 n49 EdgeDirection=W\n" +
                "ae e331 n45 n52 EdgeDirection=SW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e332 n52 n34 EdgeDirection=NW\n" +
                "ae e333 n52 n45 EdgeDirection=NE\n" +
                "ae e334 n52 n53 EdgeDirection=E\n" +
                "ae e335 n52 n35 EdgeDirection=SW\n" +
                "ae e336 n52 n46 EdgeDirection=SE\n" +
                "ae e337 n52 n55 EdgeDirection=S\n" +
                "ae e338 n52 n49 EdgeDirection=N\n" +
                "ae e339 n45 n53 EdgeDirection=SE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e340 n53 n45 EdgeDirection=NW\n" +
                "ae e341 n53 n47 EdgeDirection=NE\n" +
                "ae e342 n53 n46 EdgeDirection=SW\n" +
                "ae e343 n53 n54 EdgeDirection=E\n" +
                "ae e344 n53 n48 EdgeDirection=SE\n" +
                "ae e345 n53 n56 EdgeDirection=S\n" +
                "ae e346 n53 n52 EdgeDirection=W\n" +
                "ae e347 n53 n50 EdgeDirection=N\n" +
                "ae e348 n7 n47 EdgeDirection=NE\n" +
                "an n47 label:I ui.class:I\n" +
                "ae e349 n47 n50 EdgeDirection=NW\n" +
                "an n50 label:E ui.class:E\n" +
                "ae e350 n50 n22 EdgeDirection=NW\n" +
                "ae e351 n50 n20 EdgeDirection=NE\n" +
                "ae e352 n50 n51 EdgeDirection=E\n" +
                "ae e353 n50 n45 EdgeDirection=SW\n" +
                "ae e354 n50 n47 EdgeDirection=SE\n" +
                "ae e355 n50 n53 EdgeDirection=S\n" +
                "ae e356 n50 n49 EdgeDirection=W\n" +
                "ae e357 n47 n51 EdgeDirection=NE\n" +
                "an n51 label:E ui.class:E\n" +
                "ae e358 n51 n20 EdgeDirection=NW\n" +
                "ae e359 n51 n22 EdgeDirection=NE\n" +
                "ae e360 n51 n47 EdgeDirection=SW\n" +
                "ae e361 n51 n54 EdgeDirection=S\n" +
                "ae e362 n51 n50 EdgeDirection=W\n" +
                "ae e363 n47 n53 EdgeDirection=SW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e364 n53 n45 EdgeDirection=NW\n" +
                "ae e365 n53 n47 EdgeDirection=NE\n" +
                "ae e366 n53 n46 EdgeDirection=SW\n" +
                "ae e367 n53 n54 EdgeDirection=E\n" +
                "ae e368 n53 n48 EdgeDirection=SE\n" +
                "ae e369 n53 n56 EdgeDirection=S\n" +
                "ae e370 n53 n52 EdgeDirection=W\n" +
                "ae e371 n53 n50 EdgeDirection=N\n" +
                "ae e372 n47 n54 EdgeDirection=SE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e373 n54 n47 EdgeDirection=NW\n" +
                "ae e374 n54 n48 EdgeDirection=SW\n" +
                "ae e375 n54 n57 EdgeDirection=S\n" +
                "ae e376 n54 n53 EdgeDirection=W\n" +
                "ae e377 n54 n51 EdgeDirection=N\n" +
                "ae e378 n7 n46 EdgeDirection=SW\n" +
                "an n46 label:I ui.class:I\n" +
                "ae e379 n46 n52 EdgeDirection=NW\n" +
                "an n52 label:E ui.class:E\n" +
                "ae e380 n52 n34 EdgeDirection=NW\n" +
                "ae e381 n52 n45 EdgeDirection=NE\n" +
                "ae e382 n52 n53 EdgeDirection=E\n" +
                "ae e383 n52 n35 EdgeDirection=SW\n" +
                "ae e384 n52 n46 EdgeDirection=SE\n" +
                "ae e385 n52 n55 EdgeDirection=S\n" +
                "ae e386 n52 n49 EdgeDirection=N\n" +
                "ae e387 n46 n53 EdgeDirection=NE\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e388 n53 n45 EdgeDirection=NW\n" +
                "ae e389 n53 n47 EdgeDirection=NE\n" +
                "ae e390 n53 n46 EdgeDirection=SW\n" +
                "ae e391 n53 n54 EdgeDirection=E\n" +
                "ae e392 n53 n48 EdgeDirection=SE\n" +
                "ae e393 n53 n56 EdgeDirection=S\n" +
                "ae e394 n53 n52 EdgeDirection=W\n" +
                "ae e395 n53 n50 EdgeDirection=N\n" +
                "ae e396 n46 n55 EdgeDirection=SW\n" +
                "an n55 label:E ui.class:E\n" +
                "ae e397 n55 n35 EdgeDirection=NW\n" +
                "ae e398 n55 n46 EdgeDirection=NE\n" +
                "ae e399 n55 n56 EdgeDirection=E\n" +
                "ae e400 n55 n52 EdgeDirection=N\n" +
                "ae e401 n46 n56 EdgeDirection=SE\n" +
                "an n56 label:E ui.class:E\n" +
                "ae e402 n56 n46 EdgeDirection=NW\n" +
                "ae e403 n56 n48 EdgeDirection=NE\n" +
                "ae e404 n56 n57 EdgeDirection=E\n" +
                "ae e405 n56 n55 EdgeDirection=W\n" +
                "ae e406 n56 n53 EdgeDirection=N\n" +
                "ae e407 n7 n48 EdgeDirection=SE\n" +
                "an n48 label:I ui.class:I\n" +
                "ae e408 n48 n53 EdgeDirection=NW\n" +
                "an n53 label:E ui.class:E\n" +
                "ae e409 n53 n45 EdgeDirection=NW\n" +
                "ae e410 n53 n47 EdgeDirection=NE\n" +
                "ae e411 n53 n46 EdgeDirection=SW\n" +
                "ae e412 n53 n54 EdgeDirection=E\n" +
                "ae e413 n53 n48 EdgeDirection=SE\n" +
                "ae e414 n53 n56 EdgeDirection=S\n" +
                "ae e415 n53 n52 EdgeDirection=W\n" +
                "ae e416 n53 n50 EdgeDirection=N\n" +
                "ae e417 n48 n54 EdgeDirection=NE\n" +
                "an n54 label:E ui.class:E\n" +
                "ae e418 n54 n47 EdgeDirection=NW\n" +
                "ae e419 n54 n48 EdgeDirection=SW\n" +
                "ae e420 n54 n57 EdgeDirection=S\n" +
                "ae e421 n54 n53 EdgeDirection=W\n" +
                "ae e422 n54 n51 EdgeDirection=N\n" +
                "ae e423 n48 n56 EdgeDirection=SW\n" +
                "an n56 label:E ui.class:E\n" +
                "ae e424 n56 n46 EdgeDirection=NW\n" +
                "ae e425 n56 n48 EdgeDirection=NE\n" +
                "ae e426 n56 n57 EdgeDirection=E\n" +
                "ae e427 n56 n55 EdgeDirection=W\n" +
                "ae e428 n56 n53 EdgeDirection=N\n" +
                "ae e429 n48 n57 EdgeDirection=SE\n" +
                "an n57 label:E ui.class:E\n" +
                "ae e430 n57 n48 EdgeDirection=NW\n" +
                "ae e431 n57 n56 EdgeDirection=W\n" +
                "ae e432 n57 n54 EdgeDirection=N\n" +
                "ae e433 n1 n9 EdgeDirection=SE\n" +
                "an n9 label:I ui.class:I\n" +
                "ae e434 n9 n14 EdgeDirection=NW\n" +
                "an n14 label:E ui.class:E\n" +
                "ae e435 n14 n6 EdgeDirection=NW\n" +
                "ae e436 n14 n8 EdgeDirection=NE\n" +
                "ae e437 n14 n7 EdgeDirection=SW\n" +
                "ae e438 n14 n15 EdgeDirection=E\n" +
                "ae e439 n14 n9 EdgeDirection=SE\n" +
                "ae e440 n14 n17 EdgeDirection=S\n" +
                "ae e441 n14 n13 EdgeDirection=W\n" +
                "ae e442 n14 n11 EdgeDirection=N\n" +
                "ae e443 n9 n15 EdgeDirection=NE\n" +
                "an n15 label:E ui.class:E\n" +
                "ae e444 n15 n8 EdgeDirection=NW\n" +
                "ae e445 n15 n9 EdgeDirection=SW\n" +
                "ae e446 n15 n18 EdgeDirection=S\n" +
                "ae e447 n15 n14 EdgeDirection=W\n" +
                "ae e448 n15 n12 EdgeDirection=N\n" +
                "ae e449 n9 n17 EdgeDirection=SW\n" +
                "an n17 label:E ui.class:E\n" +
                "ae e450 n17 n7 EdgeDirection=NW\n" +
                "ae e451 n17 n9 EdgeDirection=NE\n" +
                "ae e452 n17 n18 EdgeDirection=E\n" +
                "ae e453 n17 n16 EdgeDirection=W\n" +
                "ae e454 n17 n14 EdgeDirection=N\n" +
                "ae e455 n9 n18 EdgeDirection=SE\n" +
                "an n18 label:E ui.class:E\n" +
                "ae e456 n18 n9 EdgeDirection=NW\n" +
                "ae e457 n18 n17 EdgeDirection=W\n" +
                "ae e458 n18 n15 EdgeDirection=N\n").split("\n"));

        assertListsAreEqualIgnoringOrder(expectedLines, serializedLines);
    }

    private static void assertListsAreEqualIgnoringOrder(List<String> expectedLines, List<String> serializedLines) {
        assertTrue(expectedLines.size() == serializedLines.size());
        Collections.sort(expectedLines);
        Collections.sort(serializedLines);
        assertTrue(expectedLines.equals(serializedLines));
    }
}
