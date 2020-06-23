package org.tft;

import java.io.*;
import java.util.Arrays;

public class Run {
    private Character character = null;
    private Character monster = null;
    private int battlecnt = 0;

    int victories_char = 0;
    int victories_monst = 0;
    int victories_tie = 0;
    int rounds_total = 0;
    int durationcnts[] = new int[50];


    public Run(Character c, Character m, int r) {
        character = c;
        monster = m;
        battlecnt = r;
        Arrays.fill(durationcnts,0);
    }

    public void doRun() {
        for(int i = 0; i < battlecnt; i++) {
            //System.out.println("battle: " + Integer.toString(i));
            Battle b = new Battle(character,monster);
            b.doBattle();
            rounds_total += b.getDuration();
            durationcnts[b.getDuration()]++;
            if(b.getWinner() == Character.Type.CHARACTER) {
                victories_char++;
            } else if (b.getWinner() == Character.Type.MONSTER) {
                victories_monst++;
            } else {
                victories_tie++;
            }

        }
    }

    public void displayResults() {
        System.out.println("------------------------------------------------------------------------");
        character.displayCharacter();
        monster.displayCharacter();
        System.out.println("BATTLE COUNT: " + Integer.toString(battlecnt));
        System.out.println("CHARACTER WINS=" + Integer.toString(victories_char));
        System.out.println("MONSTER WINS=" + Integer.toString(victories_monst));
        System.out.println("TIES=" + Integer.toString(victories_tie));
        int averageduration = rounds_total / battlecnt;
        System.out.println("AVERAGE DURATION=" + Integer.toString(averageduration));
        System.out.print("DURATION DIST:");
        for(int i = 0; i < 40; i++) {
            System.out.print(Integer.toString(durationcnts[i]) + " ");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------");

    }
}
