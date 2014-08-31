package net.troja.eve.crest;

import java.io.Serializable;

public class Reference implements Serializable {
    private static final long serialVersionUID = 6888618792030528710L;

    private String href;

    public String getHref() {
	return href;
    }

    public void setHref(final String href) {
	this.href = href;
    }

    @Override
    public String toString() {
	return "Reference [href=" + href + "]";
    }
}
