package net.troja.eve.crest.industry.specialities;

/*
 * ========================================================================
 * Library for the Eve Online CREST API
 * ------------------------------------------------------------------------
 * Copyright (C) 2014 - 2015 Jens Oberender <j.obi@troja.net>
 * ------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================================
 */

import java.io.Serializable;
import java.util.List;

public class IndustrySpeciality implements Serializable {
    private static final long serialVersionUID = 6218032369921531179L;

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
