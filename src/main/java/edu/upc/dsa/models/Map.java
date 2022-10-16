package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Map {

    String id;
    String name;
    String type;
    static int lastId;

    public Map() {
        this.id = RandomUtils.getId();
    }

    public Map(String name, String type) {
        this();
        this.setType(type);
        this.setName(name);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id=id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Map [id="+id+", name=" + name + ", type=" + type +"]";
    }

}