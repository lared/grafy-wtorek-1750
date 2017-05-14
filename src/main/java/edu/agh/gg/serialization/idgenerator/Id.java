package edu.agh.gg.serialization.idgenerator;

public class Id {

    private static final String EDGE = "e";
    private static final String NODE = "n";

    private static long edgeID = 0;
    private static long nodeID = 0;


    public static String getEdgeID(){
        return EDGE + edgeID++;
    }

    public static String getNodeID(){
        return NODE + nodeID++;
    }

}
