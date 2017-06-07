package edu.agh.gg.serialization.builder;

import edu.agh.gg.EdgeDirection;
import edu.agh.gg.Vertex;
import edu.agh.gg.VertexLabel;
import edu.agh.gg.serialization.idgenerator.Id;

import java.util.Map;

public class DGSBuilder implements Builder{

    private static final String NODE_DGS_PREFIX = "an";
    private static final String EDGE_DGS_PREFIX = "ae";
    private static final String ATTRIBUTE_LABEL = "label:";
    private static final String ATTRIBUTE_CLASS = "ui.class:";
    private static final String ATTRIBUTE_EDGE_DIRECTION = "EdgeDirection=";
    private static final String NEW_LINE = "\n";
    private static final String SPACE = " ";

    private String nodeUniqueID;
    private String dgsBuilderOutput;

    public DGSBuilder(String nodeUniqueID){
        this.nodeUniqueID = nodeUniqueID;
        this.dgsBuilderOutput = "";
    }

    @Override
    public void appendNode(VertexLabel label) {
        append(NODE_DGS_PREFIX + SPACE + nodeUniqueID + SPACE + ATTRIBUTE_LABEL + label.serialize()
                + SPACE + ATTRIBUTE_CLASS + label.serialize() + NEW_LINE);
    }

    @Override
    public void appendEdgeToNode(EdgeDirection edgeDirection, Vertex vertex) {
        append(EDGE_DGS_PREFIX + SPACE + Id.getEdgeID() + SPACE + nodeUniqueID
                + SPACE + vertex.getUniqueID()
                + SPACE + ATTRIBUTE_EDGE_DIRECTION + edgeDirection.serialize()+ NEW_LINE);
    }

    @Override
    public void append(String value) {
        dgsBuilderOutput += value;
    }

    @Override
    public String getBuilt() {
        return dgsBuilderOutput;
    }
}
