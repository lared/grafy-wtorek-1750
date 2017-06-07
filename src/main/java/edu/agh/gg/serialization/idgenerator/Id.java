package edu.agh.gg.serialization.idgenerator;

import java.util.concurrent.atomic.AtomicLong;

public class Id {

    private static final String EDGE = "e";
    private static final String NODE = "n";

    private static AtomicLong edgeID = new AtomicLong(0);
    private static AtomicLong nodeID = new AtomicLong(0);


    public static String getEdgeID(){
        return EDGE + edgeID.incrementAndGet();
    }

    public static String getNodeID(){
        return NODE + nodeID.incrementAndGet();
    }

    public static void resetIds() {
        edgeID.set(0);
        nodeID.set(0);
    }

}
