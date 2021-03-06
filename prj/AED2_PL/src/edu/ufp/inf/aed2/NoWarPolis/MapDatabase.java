package edu.ufp.inf.aed2.NoWarPolis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.*;

import java.io.*;
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

    public ArrayList<Node> getAllNodes(){
        ArrayList<Node> ret = new ArrayList<Node>();

        for (Map.Entry<Tag, MapSymbol> entry : this.all_obj.entrySet()) {
            Tag t = entry.getKey();
            if(entry instanceof Node){
                ret.add((Node) entry);
            }
        }

        return ret;
    }
    public ArrayList<Way> getAllWays(){

        ArrayList<Way> ret = new ArrayList<Way>();

        for (Map.Entry<Tag, MapSymbol> entry : this.all_obj.entrySet()) {
            Tag t = entry.getKey();
            if(entry instanceof Way){
                ret.add((Way) entry);
            }
        }

        return ret;
    }

    public int nodeToInt(Node n){
        int i = 0;
        for(Node k: this.getAllNodes()){
            if(k.equals(n) == true){
                return i;
            }
            i++;
        }
        return -1;
    }

    public Node intToNode(int n){
        int i = 0;
        for(Node k: this.getAllNodes()){
            if(i == n){
                return k;
            }
            i++;
        }
        return null;
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
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(this.maps);
            objectOut.writeObject(this.all_obj);
            objectOut.close();

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean load(String filePath){

        try{
            FileInputStream fileIn = new FileInputStream(filePath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            this.maps = (HashMap<String, HashMap<Tag, MapSymbol>>) objectIn.readObject();
            this.all_obj = (HashMap<Tag, MapSymbol>) objectIn.readObject();
            objectIn.close();
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

    public EdgeWeightedGraph mapToGraph(){
        ArrayList<Node> nds = this.getAllNodes();
        ArrayList<Way> ways = this.getAllWays();

        EdgeWeightedGraph ret = new EdgeWeightedGraph(nds.size());

        for(Way w: ways){
            ret.addEdge(
                    new Edge(
                            this.nodeToInt(w.getNodeStart()),
                            this.nodeToInt(w.getNodeEnd()),
                            w.getWeight()
                    )
            );

        }

        return ret;

    }
}
