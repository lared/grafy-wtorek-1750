package edu.agh.gg;

import edu.agh.gg.grammar.*;
import edu.agh.gg.visualization.GraphStreamVisualizer;
import edu.agh.gg.visualization.PositionCalc;
import edu.agh.gg.visualization.Visualizer;

import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Executor extends Thread {

    private final Visualizer visualizer;
    private final Vertex vertex;
    private CyclicBarrier barrier;

    public Executor(Visualizer visualizer) {
        this.visualizer = visualizer;
        vertex = Vertex.withoutParent(VertexLabel.I);
    }

    @Override
    public void run() {
        //[(P0)]
        barrier = new CyclicBarrier(1 + 1);
        Production p0 = new P0(vertex, barrier);
        apply(p0, "P0");

        //[(P1)]
        barrier = new CyclicBarrier(1 + 1);
        Production p1 = new P1(vertex, barrier);
        apply(p1, "P1");

        //[(P1)1(P1)2(P1)3] apply P1 to three children of initial vertex
        Map<EdgeDirection, Vertex> childrenEdges = vertex.getChildrenEdges();
        barrier = new CyclicBarrier(3 + 1);
        Production p1a3 = new P1(childrenEdges.get(EdgeDirection.NW), barrier);
        Production p1a1 = new P1(childrenEdges.get(EdgeDirection.NE), barrier);
        Production p1a2 = new P1(childrenEdges.get(EdgeDirection.SW), barrier);
        apply(Arrays.asList(p1a1, p1a2, p1a3), "P1X3");

        //[(P2)]
        barrier = new CyclicBarrier(1 + 1);
        Production p2 = new P2(vertex, barrier);
        apply(p2, "P2");

        //[(P3)]
        barrier = new CyclicBarrier(1 + 1);
        Production p3 = new P3(vertex, barrier);
        apply(p3, "P3");

        visualizeProduction();
    }

    private void apply(Production production, String name) {
        production.start();
        awaitBarrier();
    }

    private void apply(Collection<Production> productions, String name) {
        productions.forEach(Thread::start);
        awaitBarrier();
    }

    private void awaitBarrier() {
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void visualizeProduction(){
        PositionCalc.calculatePositions(vertex);
        visualizer.visualize("FinalProduction", vertex.serialize());
    }

    public static void main(String[] args) {
        Visualizer visualizer = new GraphStreamVisualizer();
        Executor executor = new Executor(visualizer);
        executor.start();
    }

}
