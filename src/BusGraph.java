import java.util.HashSet;
import java.util.LinkedList;

public class BusGraph { // Container for the graph itself
    // All we need to do with this data is:
    // - add something to the set
    // - check if something is in the set
    // We don't care about the order of vertices, just need a collection of them
    // => Use a set, which lets us add/check if nodes in the set in constant time
    HashSet<CityVertex> cities;  // All vertices in the graph

    public BusGraph() {
        this.cities = new HashSet<CityVertex>();
    }

    public void addCity(CityVertex cv) {
        this.cities.add(cv);
    }

    public void addRoute(CityVertex fromCity, CityVertex toCity) {
        if (this.cities.contains(fromCity) && this.cities.contains(toCity)) {
            fromCity.addEdge(toCity);
        }
        // throw a CityNotFound exception otherwise
    }

    public boolean canReachDFS(CityVertex source, CityVertex dest) {
        // Keep track of a **list** of nodes we want to check
        HashSet<CityVertex> visited = new HashSet<CityVertex>();
        LinkedList<CityVertex> toCheck = new LinkedList<CityVertex>();

        visited.add(source);
        toCheck.add(source);

        while(!toCheck.isEmpty()) {
            // Remove a city from the list and check it
            CityVertex checkingCity = toCheck.removeLast();
            if (checkingCity.equals(dest)) {
                return true;
            }
            // Otherwise, check neighbors
            for (CityVertex neighbor : checkingCity.toCities) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    toCheck.addLast(neighbor);
                }
            }
        }

        return false;
    }

    public boolean canReach(CityVertex source, CityVertex dest) {
        return source.canReach(dest);
    }

}
