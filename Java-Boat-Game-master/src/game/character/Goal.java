package game.character;

import game.GameEngine;
import java.util.*;
class Goal extends Stationary {

    @Override
    public boolean detectCollision(ArrayList<Character> moving) {
        boolean collision = false;
        int length = moving.size();

        for (int i = 0; i < length; i++) {
            Character c = moving.get(i);

            if (collision = collides(c)) {
                if (c.equals(GameEngine.getCharacter("Boat"))) {
                    GameEngine.getInstance().win();

                } else {
                    c.collide();
                }
            }

        }
        
        return collision;
    }
}
