package org.burroloco.donkey.mapper;

import static org.apache.commons.lang.WordUtils.capitalize;
import static org.apache.commons.lang.WordUtils.capitalizeFully;

public class DefaultSetterNameMapper implements SetterNameMapper {

    public String map(String name) {
        return "set" + capitalizeFully(capitalize(name), new char[]{'_'}).replaceAll("_", "");
    }
}
