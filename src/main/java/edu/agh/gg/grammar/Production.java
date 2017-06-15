package edu.agh.gg.grammar;

import edu.agh.gg.Vertex;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public abstract class Production extends Thread {

    protected final Vertex vertex;
    private final CyclicBarrier barrier;

    public Production(Vertex vertex, CyclicBarrier barrier) {
        this.vertex = vertex;
        this.barrier = barrier;
    }

    public Production(Vertex vertex) {
        this.barrier = new CyclicBarrier(1);
        this.vertex = vertex;
    }

    public abstract void apply();

    public abstract boolean applicableTo(Vertex vertex);

    @Override
    public void run() {
        apply();
    }

    protected void awaitBarrier(){
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
