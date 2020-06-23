package org.tft;

public class Shield {
    String label = "";
    int hitsstopped = 0;
    public Shield(String l, int hs) {
        label = l;
        hitsstopped = hs;
    }
    public int getHitsstopped() {
        return hitsstopped;
    }
    public int getDexterityModifier() {
        return -(hitsstopped - 1);
    }
    public void displayShield() {
        System.out.print(label + "(" + hitsstopped + ")");
        System.out.print(" {" + Integer.toString(getDexterityModifier()) + " DX}");
    }
}
