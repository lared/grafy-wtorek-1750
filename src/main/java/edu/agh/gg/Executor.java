package edu.agh.gg;

import edu.agh.gg.grammar.*;
import edu.agh.gg.visualization.GraphStreamVisualizer;
import edu.agh.gg.visualization.Visualizer;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Executor extends Thread {

    private final Visualizer visualizer;
    private final Vertex vertex;
    private CyclicBarrier barrier;

    Executor(Visualizer visualizer) {
        this.visualizer = visualizer;
        vertex = Vertex.withoutParent(VertexLabel.I);
    }

    @Override
    public void run() {
        barrier = new CyclicBarrier(1 + 1);
        Production p0 = new P0(vertex, barrier);
        apply(p0, "P0");

        barrier = new CyclicBarrier(1 + 1);
        Production p1 = new P1(vertex, barrier);
        apply(p1, "P1");

        // apply P1 to three children of initial vertex concurrently
        Map<EdgeDirection, Vertex> childrenEdges = vertex.getChildrenEdges();
        barrier = new CyclicBarrier(3 + 1);
        Production p1a3 = new P1(childrenEdges.get(EdgeDirection.NW), barrier);
        Production p1a1 = new P1(childrenEdges.get(EdgeDirection.NE), barrier);
        Production p1a2 = new P1(childrenEdges.get(EdgeDirection.SW), barrier);
        apply(Arrays.asList(p1a1, p1a2, p1a3), "P1X3");

        barrier = new CyclicBarrier(1 + 1);
        Production p2 = new P2(vertex, barrier);
        apply(p2, "P2");

        barrier = new CyclicBarrier(1 + 1);
        Production p3 = new P3(vertex, barrier);
        apply(p3, "P3");
    }

    private void apply(Production production, String name) {
        try {
            production.start();
            barrier.await();
            visualizer.visualize(name, vertex.serialize());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    private void apply(Collection<Production> productions, String name) {
        try {
            productions.forEach(Thread::start);
            barrier.await();
            visualizer.visualize(name, vertex.serialize());
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Visualizer visualizer = new GraphStreamVisualizer();
        Executor executor = new Executor(visualizer);
        executor.start();
    }

}
