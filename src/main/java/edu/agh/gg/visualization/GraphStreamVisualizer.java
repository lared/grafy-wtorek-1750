package edu.agh.gg.visualization;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.stream.file.FileSinkImages;
import org.graphstream.stream.file.FileSource;
import org.graphstream.stream.file.FileSourceDGS;

import javax.swing.text.html.StyleSheet;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class GraphStreamVisualizer implements Visualizer {

    @Override
    public void visualize(String graphName, String serialization) {
        Graph graph = new MultiGraph(graphName);

        StyleSheet styleSheet = new StyleSheet();
        styleSheet.setBase(GraphStreamVisualizer.class.getResource("/style.css"));
        graph.addAttribute("ui.stylesheet", "url('src//main//resources//style.css')");

        FileSinkImages pic = new FileSinkImages(FileSinkImages.OutputType.PNG, FileSinkImages.Resolutions.VGA);
        pic.setLayoutPolicy(FileSinkImages.LayoutPolicy.COMPUTED_FULLY_AT_NEW_IMAGE);

        FileSource fs = new FileSourceDGS();
        fs.addSink(graph);

        try {
            String dgsFormat = withMagicHeader(nodesFirst(split(serialization)));
            fs.readAll(toInputStream(dgsFormat));
            graph.display();
            pic.writeAll(graph, graphName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fs.removeSink(graph);
        }
    }

    private static String withMagicHeader(String string) {
        return String.format("DGS004\nnull 0 0\n%s", string);
    }

    private static InputStream toInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }

    private static List<String> split(String string) {
        return Arrays.asList(string.split("\\n"));
    }

    private static String nodesFirst(List<String> lines) {
        List<String> nodes = new ArrayList<>(nodes(lines));
        Set<String> edges = removeInvalid(edges(lines), nodes);

        nodes.addAll(edges);
        return nodes.stream()
                .collect(Collectors.joining("\n"));
    }

    private static Set<String> removeInvalid(Set<String> edges, List<String> nodes) {
        Set<String> nodeLabels = nodes.stream()
                .map(string -> string.split(" ")[1])
                .collect(Collectors.toSet());

        Set<String> edgesCopy = new HashSet<>(edges);

        for (String edge : edges) {
            String[] split = edge.split(" ");
            String nodeA = split[2];
            String nodeB = split[3];
            if (!nodeLabels.contains(nodeA) || !nodeLabels.contains(nodeB)) {
                edgesCopy.remove(edge);
            }
        }
        return edgesCopy;
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
