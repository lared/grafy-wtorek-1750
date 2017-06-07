package edu.agh.gg.serialization;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.serialization.builder.Builder;
import edu.agh.gg.serialization.builder.DGSBuilder;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public class Serializer {

    private Builder builder;
    private Vertex vertex;

    public Serializer(Vertex vertex) {
        this.vertex = vertex;
        this.builder = new DGSBuilder(vertex.getUniqueID());
    }

    public String serialize() {

        builder.appendNode(vertex.getLabel());
        addToBuilder(vertex.getSiblingsEdges());
        addToBuilder(vertex.getChildrenEdges());

        return builder.getBuilt();
    }

    private void addToBuilder(ConcurrentMap<EdgeDirection, Vertex> map) {
        for (EdgeDirection edgeDirection : EdgeDirection.values()) {
            if (map.containsKey(edgeDirection)) {
                builder.appendEdgeToNode(edgeDirection, map.get(edgeDirection));
                if (shouldAppendDeeply()) {
                    builder.append(map.get(edgeDirection).serialize());
                }
            }
        }
    }

    private boolean shouldAppendDeeply() {
        return vertex.getLabel() != VertexLabel.E;
    }
}
