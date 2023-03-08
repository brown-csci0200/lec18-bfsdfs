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

    public boolean canReach(CityVertex dest) {
        return false; // TODO
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
