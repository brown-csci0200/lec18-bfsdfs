import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestCityGraph {
    BusGraph neBuses;
    CityVertex man, bos, pvd, wos, har;

    @Before
    public void setup() {
        neBuses = new BusGraph();

        man = new CityVertex("Manchester");
        neBuses.addCity(man);
        bos = new CityVertex("Boston");
        neBuses.addCity(bos);
        pvd = new CityVertex("Providence");
        neBuses.addCity(pvd);
        wos = new CityVertex("Worcester");
        neBuses.addCity(wos);
        har = new CityVertex("Hartford");
        neBuses.addCity(har);

        neBuses.addRoute(man, bos);
        neBuses.addRoute(bos, pvd);
        neBuses.addRoute(bos, wos);
        neBuses.addRoute(pvd, bos);
        neBuses.addRoute(wos, har);
    }

    @Test
    public void testCanReach() {

        System.out.println(man);
        System.out.println(bos);

    }

}
