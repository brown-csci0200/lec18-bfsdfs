import java.util.HashSet;
import java.util.LinkedList;

public class BusGraph {
    HashSet<CityVertex> cities;

    public BusGraph() {
        // Use Hash set to keep list of cities--faster since we just need to if cities are in set
        this.cities = new HashSet<CityVertex>();
    }

    public void addCity(CityVertex cv) {
        this.cities.add(cv);
    }

    public void addRoute(CityVertex fromCity, CityVertex toCity) {
        if (this.cities.contains(fromCity) && this.cities.contains(toCity)) {
            fromCity.addEdge(toCity);
        }
        // Omitted:  throw a CityNotFound exception otherwise
    }

    /**
     * Recursive (original) version of canReach
     * canReach checks if there is a path from the source node to the destination
     * @param source Starting (or "source") node
     * @param dest Destination
     * @return true if there is a path from source to destination
     */
    public boolean canReach(CityVertex source, CityVertex dest) {
        return source.canReach(dest);
    }

    /**
     *
     * canReach implementation using Depth-First Search (DFS)
     * @param source Starting (or "source") node
     * @param dest Destination
     * @return true if there is a path from source to destination
     */
    public boolean canReachDFS(CityVertex source, CityVertex dest) {
        HashSet<CityVertex> visited = new HashSet<CityVertex>();

        // Instead of writing this recursively, we use a linked list
        // to keep track of nodes that still need to be checked
        LinkedList<CityVertex> toCheck = new LinkedList<CityVertex>();

        // Start: add source node toCheck
        visited.add(source);
        toCheck.addLast(source);

        while (!toCheck.isEmpty()) {
            // On each loop, remove the last element from the list
            // and check it (checking process is same as recursive version)
            CityVertex checkingCity = toCheck.removeLast();

            // If this city is our destination, we're done
            if (checkingCity.equals(dest)) {
                return true;
            }

            // If checkingCity wasn't our destination, we consider its neighbors
            // by adding them to toCheck (if they haven't already been visisted
            // (More accurately, we "queue" unvisited neighbors so
            for (CityVertex neighbor : checkingCity.getNeighbors()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    toCheck.addLast(neighbor);
                }
            }
        }

        // If toCheck is empty and we haven't already found an answer,
        // we can't reach this city => return false
        return false;
    }
}
