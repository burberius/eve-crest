package net.troja.eve.crest;

import java.io.Serializable;

public class IdType implements Serializable {
    private static final long serialVersionUID = -261253619607021341L;

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
	return "IdType [id=" + id + "]";
    }
}
