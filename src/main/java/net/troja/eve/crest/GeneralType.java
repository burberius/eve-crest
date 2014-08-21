package net.troja.eve.crest;

import java.io.Serializable;

public class GeneralType implements Serializable {
    private static final long serialVersionUID = 8952654062451756797L;

    private String href;
    private int id;
    private String name;

    public String getHref() {
	return href;
    }

    public void setHref(final String href) {
	this.href = href;
    }

    public int getId() {
	return id;
    }

    public void setId(final int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    @Override
    public String toString() {
	return "ItemType [href=" + href + ", id=" + id + ", name=" + name + "]";
    }
}
