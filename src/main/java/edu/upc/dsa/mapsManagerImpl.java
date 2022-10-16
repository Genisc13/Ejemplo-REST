package edu.upc.dsa;

import edu.upc.dsa.models.Map;

import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class mapsManagerImpl implements mapsManager {
    private static mapsManager instance;
    protected List<Map> maps;
    final static Logger logger = Logger.getLogger(mapsManagerImpl.class);

    private mapsManagerImpl() {
        this.maps = new LinkedList<>();
    }

    public static mapsManager getInstance() {
        if (instance==null) instance = new mapsManagerImpl();
        return instance;
    }

    public int size() {
        int ret = this.maps.size();
        logger.info("size " + ret);

        return ret;
    }

    public Map addMap(Map t) {
        logger.info("new Track " + t);

        this.maps.add (t);
        logger.info("new Track added");
        return t;
    }

    public Map addMap(String name, String type) {
        return this.addMap(new Map(name, type));
    }

    public Map getMap(String id) {
        logger.info("getTrack("+id+")");

        for (Map t: this.maps) {
            if (t.getId().equals(id)) {
                logger.info("getTrack("+id+"): "+t);

                return t;
            }
        }

        logger.warn("not found " + id);
        return null;
    }

    public List<Map> findAll() {
        return this.maps;
    }

    @Override
    public void deleteMap(String id) {

        Map t = this.getMap(id);
        if (t==null) {
            logger.warn("not found " + t);
        }
        else logger.info(t+" deleted ");

        this.maps.remove(t);

    }

    @Override
    public Map updateMap(Map p) {
        Map t = this.getMap(p.getId());

        if (t!=null) {
            logger.info(p+" rebut!!!! ");

            t.setType(p.getType());
            t.setName(p.getName());

            logger.info(t+" updated ");
        }
        else {
            logger.warn("not found "+p);
        }

        return t;
    }
}