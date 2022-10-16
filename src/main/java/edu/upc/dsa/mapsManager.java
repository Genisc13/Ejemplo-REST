package edu.upc.dsa;

import edu.upc.dsa.models.Map;

import java.util.List;

public interface mapsManager {


    public Map addMap(String title, String singer);
    public Map addMap(Map t);
    public Map getMap(String id);
    public List<Map> findAll();
    public void deleteMap(String id);
    public Map updateMap(Map t);

    public int size();
}
