package edu.agh.gg;

import edu.agh.gg.grammar.P0;
import edu.agh.gg.grammar.P1;
import edu.agh.gg.grammar.P2;
import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDGS;

import javax.swing.text.html.StyleSheet;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Visualizer {

    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new MultiGraph("Paszyn");

        StyleSheet styleSheet = new StyleSheet();
        styleSheet.setBase(Visualizer.class.getResource("/style.css"));
        graph.addAttribute("ui.stylesheet", "url('src//main//resources//style.css')");

        FileSinkImages pic = new FileSinkImages(FileSinkImages.OutputType.PNG, FileSinkImages.Resolutions.VGA);
        pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);

        FileSource fs = new FileSourceDGS();
        fs.addSink(graph);

        P0 p0 = new P0();
        P1 p1 = new P1();
//        P2 p2 = new P2(); //not working for now

        Vertex vertex = Vertex.withoutParent(VertexLabel.I);
        p0.apply(vertex);
        p1.apply(vertex);
//        p2.apply(vertex);

        try {
//            fs.readAll("src/main/resources/po.dgs");
            String string = withMagicHeader(nodesFirst(split(vertex.serialize())));
            fs.readAll(toInputStream(string));
            graph.display();
            pic.writeAll(graph, "graph.png");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fs.removeSink(graph);
        }
    }

    private static String withMagicHeader(String string) {
        return String.format("DGS004\ntriangle 0 0\n%s", string);
    }

    private static InputStream toInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }

    private static List<String> split(String string) {
        return Arrays.asList(string.split("\\n"));
    }

    private static String nodesFirst(List<String> lines) {
        List<String> nodes = new ArrayList<>(nodes(lines));
        nodes.addAll(edges(lines));
        return nodes.stream()
                .collect(Collectors.joining("\n"));
    }

    private static Set<String> nodes(List<String> lines) {
        return lines.stream()
                .filter(e -> e.startsWith("an"))
                .collect(Collectors.toSet());
    }

    private static Set<String> edges(List<String> lines) {
        return lines.stream()
                .filter(e -> e.startsWith("ae"))
                .collect((Collectors.toSet()));
    }

}
