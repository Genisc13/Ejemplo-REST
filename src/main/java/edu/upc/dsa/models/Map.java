package edu.upc.dsa.models;


public class Map {

    String id;
    String name;
    String type;
    String size;

    public Map() {
    }

    public Map(String id,String name, String type,String size) {
        this();
        this.setId(id);
        this.setType(type);
        this.setName(name);
        this.setSize(size);
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
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Map [id="+id+", name=" + name + ", type=" + type +", size="+size+"]";
    }

}