package edu.ufp.inf.aed2.NoWarPolis;

import edu.princeton.cs.algs4.*;
import edu.ufp.inf.aed2.NoWarPolis.Datatypes.*;

import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class MapQuery {

    private MapDatabase md;

    public MapQuery(String filepath){
        md = new MapDatabase();
        md.load(filepath);
    }

    public MapQuery(){
        md = new MapDatabase();
    }

    public ArrayList<POI> find_POI(boolean visited, Date init, Date end, ArrayList<User> users){
        ArrayList<POI> ret = new ArrayList<POI>();

        for(POI o: this.md.getAllPOI()){
            Boolean add = true;
            for(User u: users){

                //1. If user does not exist
                if(
                    o.getVisitedUsers().containsKey(u) == false && visited == true ||
                    o.getVisitedUsers().containsKey(u) == true && visited == false
                ){
                    add = false;
                    break;
                }
                //2. in case he visited and he is part of the history
                if(o.getVisitedUsers().containsKey(u) == true && visited == true){
                    Boolean found = false;

                    for(Date d:  o.getVisitedUsers().get(u) ){
                        if(d.compareTo(init) >= 0 && d.compareTo(end) <= 0 ){
                            found = true;
                        }
                    }

                    if(found == false)
                        add = false;
                }
            }

            if(add == true)
                ret.add(o);
        }


        return ret;
    }

    public ArrayList<POI> find_User_visitedPOI(boolean visited, Date init, Date end, User user){
       ArrayList<User> tmp = new ArrayList<User>();
       tmp.add(user);
       return this.find_POI(visited,init,end,tmp);
    }

    public ArrayList<User> top_Users(int rankN, Date init, Date end){
        ArrayList<User> ret = new ArrayList<User>();
        for(User u: User.getAllUsersWithVisitsWithinRange(this.md.getAllUsers(), init, end)){

            if(rankN <= 0){
                return ret;
            }

            ret.add(u);

            rankN--;
        }
        return ret;
    }

    public ArrayList<POI> top_POI(int rankN, Date init, Date end){
        ArrayList<POI> ret = new ArrayList<POI>();
        for(POI p: POI.getAllPoiWithVisitsWithinRange(this.md.getAllPOI(), init, end)){

            if(rankN <= 0){
                return ret;
            }

            ret.add(p);

            rankN--;
        }
        return ret;
    }

    public HashMap<String, MapSymbol> find_whereisPOI(POI p){
        HashMap<String, MapSymbol> ret = new HashMap<String, MapSymbol>();

        for(String mapName: this.md.getAllMaps().keySet()){
            if(this.md.getAllMaps().get(mapName).containsKey(p.getTag()) == true){
                ret.put(mapName,p.getLocation());
            }
        }

        return ret;
    }

    public ArrayList<Map.Entry<Node,Float>> getShortedPath(Node s, Node end){
        ArrayList<Map.Entry<Node,Float>> path = new ArrayList<Map.Entry<Node,Float>>();

        EdgeWeightedGraph g = this.md.mapToGraph();
        DijkstraUndirectedSP sp = new DijkstraUndirectedSP(
                g, this.md.nodeToInt(s));


        if(sp.hasPathTo(this.md.nodeToInt(end)) == true){

            for(Edge e: sp.pathTo(this.md.nodeToInt(end))){
                Float weight = (float) e.weight();
                path.add(new AbstractMap.SimpleEntry<Node,Float>(this.md.intToNode(e.either()), weight));
            }

            return path;
        }

        return null;
    }

    public float getWeightPath(ArrayList<Map.Entry<Node,Float>> m){
        float total = 0;
        for (Map.Entry<Node, Float> entry : m) {
            total+=entry.getValue();
        }
        return total;
    }

}
