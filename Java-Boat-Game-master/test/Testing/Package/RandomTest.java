/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Package;
import game.movement.AngledAcceleration;
import game.movement.Random;
import game.movement.Location;
import org.junit.*;
import static org.junit.Assert.*;


/**
 *
 * @author H3340
 */
public class RandomTest {
    private Random random;
    
    @Before
    public void runBeforeEachTest() {
        this.random = new Random(new AngledAcceleration());     
    }
    
    @Test
    public void testRandomLocation() {
        for (int i = -3; i < 100000; i++) {
            random.go(new Location(i,(i+1)));
        }
    }
}
