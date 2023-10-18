import java.util.HashSet;
import java.util.LinkedList;

public class CityVertex {
    LinkedList<CityVertex> toCities;  // List of its neighbors
    String name;

    public CityVertex(String nm) {
        this.name = nm;
        this.toCities = new LinkedList<CityVertex>();
    }

    public void addEdge(CityVertex toVertex) {
        this.toCities.add(toVertex);
    }

    // First try
    public boolean canReach1(CityVertex dest) {
        if (this.equals(dest)) {
            return true;
        }

        // Ask neighbors
        for (CityVertex neighbor : toCities) {
            if (neighbor.canReach(dest)) {
                return true;
            }
        }

        return false;
     }

     public boolean canReach(CityVertex dest) {
        return this.canReachHelper(dest, new HashSet<CityVertex>());
     }

    public boolean canReachHelper(CityVertex dest, HashSet<CityVertex> visited) {
        if (this.equals(dest)) {
            return true;
        }
        visited.add(this);

        // Ask neighbors
        for (CityVertex neighbor : toCities) {
            if (!visited.contains(neighbor)) { // Skip over cities we've already visited
                if (neighbor.canReachHelper(dest, visited)) {
                    return true;
                }
            }
        }

        return false;
    }


    public String toString() {
        String retstring = "City " + this.name + " goes to { ";
        for (CityVertex toCity : this.toCities) {
            retstring += toCity.name + " ";
        }
        retstring += "}";
        return retstring;
    }
}
