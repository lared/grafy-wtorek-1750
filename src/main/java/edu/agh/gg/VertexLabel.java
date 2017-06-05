package edu.agh.gg;

import edu.agh.gg.serialization.Serializable;

public enum VertexLabel implements Serializable{
    I, E, S, i;

    @Override
    public String serialize(){
        return this.name();
    }

}
