package net.troja.eve.crest.industry.specialities;

import java.util.List;

public class IndustrySpeciality {
    private int id;
    private String name;
    private List<Id> groups;

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

    public List<Id> getGroups() {
	return groups;
    }

    public void setGroups(final List<Id> groups) {
	this.groups = groups;
    }

    @Override
    public String toString() {
	return "Speciality [id=" + id + ", name=" + name + ", groups=" + groups + "]";
    }

}
