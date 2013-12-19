package org.burroloco.donkey.mapper;

public class DefaultUpperCarriageCaseMapper implements UpperCarriageCaseMapper {
    private static final String REGEX = "([a-z])([A-Z])";
    private static final String REPLACEMENT = "$1_$2";

    public String map(String name) {
        return name.replaceAll(REGEX, REPLACEMENT).toUpperCase();
    }
}
