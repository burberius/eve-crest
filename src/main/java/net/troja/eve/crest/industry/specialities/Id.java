package net.troja.eve.crest.industry.specialities;

import java.io.Serializable;

public class Id implements Serializable {
    private static final long serialVersionUID = 8298981713160356328L;

    private int id;

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "Id [id=" + id + "]";
    }
}
