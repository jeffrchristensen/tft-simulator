package org.tft;

import java.awt.image.AffineTransformOp;
import java.util.Random;

public class Battle {
    private Character character = null;
    private Character monster = null;

    private Character.Type winner = Character.Type.NONE;
    private int duration = 0;


    public Battle(Character c, Character m) {
        character = c;
        monster = m;
    }

    public void doBattle() {
        winner = Character.Type.NONE;
        Random rd = new Random();
        Character.BattleCharacter engchar = character.getBattlecharacter();
        Character.BattleCharacter engmonst = monster.getBattlecharacter();

        engchar.setEngaged(engmonst);
        engmonst.setEngaged(engchar);

        while (!(engchar.isDead() || engmonst.isDead())) {
            duration++;
            boolean charinitiative = rd.nextBoolean();
            Character.BattleCharacter first = null;
            Character.BattleCharacter second = null;
            if(character.getDexterityModified() > monster.getDexterityModified() ) {
                first = engchar;
                second = engmonst;
            } else if (monster.getDexterityModified() > character.getDexterityModified()) {
                first = engmonst;
                second = engchar;
            } else if (charinitiative) {
                first = engchar;
                second = engmonst;
            } else {
                first = engmonst;
                second = engchar;
            }
            first.attack();
            if(!second.isDead()) {
                second.attack();
                if(first.isDead()) {
                    // second is winner
                    winner = second.getCharacter().getType();
                    return;
                }
            } else {
                // first is winner
                winner = first.getCharacter().getType();
                return;
            }
            if(duration > 50) {
                return;
            }
        }
    }

    public Character.Type getWinner() {
        return winner;
    }

    public int getDuration() {
        return duration;
    }

}
