package net.troja.eve.crest;

public class GeneralType {
    private String id_str;
    private String href;
    private int id;
    private String name;

    public String getId_str() {
	return id_str;
    }

    public void setId_str(final String id_str) {
	this.id_str = id_str;
    }

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
