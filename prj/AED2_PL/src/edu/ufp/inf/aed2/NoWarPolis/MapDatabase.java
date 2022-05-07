package edu.ufp.inf.aed2.NoWarPolis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapDatabase {

    private HashMap<String, HashMap<Tag, MapSymbol>> maps = new HashMap<String, HashMap<Tag, MapSymbol>>();
    private HashMap<Tag, MapSymbol> all_obj = new HashMap<Tag, MapSymbol>();

    public MapDatabase(){
    }

    public boolean insert(MapSymbol s){
        //Only add user
        if(s instanceof User)
            return insert_obj(s);

        //Add to master map object if not specified
        return insert("master",s);
    }

    public boolean insert(String map, MapSymbol s){

        //do not allow node or ways without in master map
        if(map != "master" && ( s instanceof Way || s instanceof Node))
            return false;

        //check if map exists
        if(this.maps.containsKey(map)== false)
            return false;

        //check if symbol is already in map
        if(this.maps.get(map).containsKey(s) == true)
            return false;

        //Add to map
        this.maps.get(map).put(s.getTag(),s);

        //insert object if do not exists
        insert_obj(s);

        return true;
    }

    private boolean insert_obj(MapSymbol p){

        if(this.all_obj.containsKey(p.getTag()) == true){
            return false;
        }

        this.all_obj.put(p.getTag(),p);

        return true;

    }

    public void remove(MapSymbol ms){

        //Remove from compelte database
        all_obj.remove(ms.getTag());

        //Remove from mapst
        this.maps.forEach((map_name, map) -> {
           map.remove(ms.getTag());
        });
    }

    public MapSymbol search_byTagId(long id){

        for (Map.Entry<Tag, MapSymbol> entry : this.all_obj.entrySet()) {
            Tag t = entry.getKey();
            MapSymbol obj = entry.getValue();
            if (t.getId() == id) {
                return obj;
            }
        }

        return null;
    }

    public MapSymbol search_byName(String name){

        for (Map.Entry<Tag, MapSymbol> entry : this.all_obj.entrySet()) {
            Tag t = entry.getKey();
            MapSymbol obj = entry.getValue();
            if (obj.getName() == name) {
                return obj;
            }
        }

        return null;
    }

    public boolean save(String filePath){

        try{
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;

            objectMapper.writeValue(new FileOutputStream(filePath+"maps.json"), this.maps);
            objectMapper.writeValue(new FileOutputStream(filePath+"objects.json"), this.all_obj);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean load(String filePath){

        try{
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);;

            objectMapper.readValue(new File(filePath+"maps.json"), this.maps.getClass());
            objectMapper.readValue(new File(filePath+"objects.json"), this.all_obj.getClass());
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<POI> getAllPOI(){
        ArrayList<POI> ret = new ArrayList<POI>();

        this.all_obj.forEach((t, ms) -> {
            if(ms instanceof POI){
                ret.add((POI) ms);
            }
        });

        return ret;
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> ret = new ArrayList<User>();

        this.all_obj.forEach((t, ms) -> {
            if(ms instanceof User){
                ret.add((User) ms);
            }
        });

        return ret;
    }

    public HashMap<String, HashMap<Tag, MapSymbol>> getAllMaps(){
        return this.maps;
    }
}
