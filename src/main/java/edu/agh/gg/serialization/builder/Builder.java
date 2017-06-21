package edu.agh.gg.serialization.builder;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;

import java.util.Map;


public interface Builder {
    void appendNode(Vertex vertex);

    void appendEdgeToNode(EdgeDirection edgeDirection, Vertex vertex);

    void append(String serialize);

    String getBuilt();
}
