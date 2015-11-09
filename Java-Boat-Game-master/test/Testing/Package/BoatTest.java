/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testing.Package;

import game.character.*;
import game.sprite.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author H3340
 */
public class BoatTest {
    private Boat boat;
    
    @Before
    public void runBeforeEachTest() {
        this.boat = new Boat();     
    }
    
    
    @Test
    public void testSetEnergy() {
        this.boat.setEnergy(10);
        this.boat.setEnergy(-25);
        this.boat.setEnergy(0);
        this.boat.setEnergy(-0);
    }
    
    @Test
    public void testSetSprite() {
        this.boat.setSprite(null);
    }
    
    @Test
    public void testPinAngle() {
        int kuukausi = 12;
        org.junit.Assert.assertTrue(kuukausi < 13 && kuukausi > 0);
    }
}
