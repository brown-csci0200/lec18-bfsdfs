import java.util.HashSet;
import java.util.LinkedList;

public class CityVertex {
    LinkedList<CityVertex> toCities;
    String name;

    public CityVertex(String nm) {
        this.name = nm;
        this.toCities = new LinkedList<CityVertex>();
    }

    public void addEdge(CityVertex toVertex) {
        this.toCities.add(toVertex);
    }

    public LinkedList<CityVertex> getNeighbors() { return this.toCities; }

    public boolean canReach(CityVertex dest) {
        // to start, visited set is empty
        return this.canReachHelper(dest, new HashSet<CityVertex>());
    }
    
    public boolean canReachHelper(CityVertex dest, HashSet<CityVertex> visited) {
            if (this.equals(dest)) {
                return true;
            }

            visited.add(this);

            for (CityVertex neighbor : this.toCities) {
                if (!visited.contains(neighbor)) {

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
