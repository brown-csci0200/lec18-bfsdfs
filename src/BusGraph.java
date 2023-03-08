import java.util.LinkedList;

public class BusGraph {
    LinkedList<CityVertex> cities;

    public BusGraph() {
        this.cities = new LinkedList<CityVertex>();
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

    public boolean canReach(CityVertex source, CityVertex dest) {
        return source.canReach(dest);
    }

}
