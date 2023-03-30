// This is a very simple program that I made to help me and my friends have a Mario Kart tournament. There
// currently are not many safeguards or exception catches, but given the circumstance this was being used in
// I didn't spend more than about 20 minutes on it.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MarioKart {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String p = "";
        ArrayList<Player> players = new ArrayList<>();
        while (!p.equals("done")) {
            System.out.print("Enter player name: ('done' to stop) ");
            p = scnr.nextLine();
            p = p.replaceAll("\\s", "");
            if (!p.equals("done") && p.length() > 0) {
                players.add(new Player(p));
            }
        }
        System.out.println();
        int i = 1;
        while (anyLives(players)) {
            Collections.shuffle(players);
            Player p1 = players.get(0);
            Player p2;
            try {
                p2 = players.get(1);
            } catch (Exception e) {
                System.out.printf("%s wins!\n", p1.getName());
                break;
            }
            System.out.printf("Round %d: %s VS %s\n", i, p1.getName(), p2.getName());
            System.out.println("Who won? ");
            String winner = scnr.nextLine();
            if (winner.equals(p1.getName())) {
                p2.loseLife();
                if (!p2.checkLives()) {
                    players.remove(p2);
                }
            } else {
                p1.loseLife();
                if (!p1.checkLives()) {
                    players.remove(p1);
                }
            }
            System.out.println();
            i++;
        }
    }

    public static boolean anyLives(ArrayList<Player> players) {
        for (Player player : players) {
            if (!player.checkLives()) {
                return false;
            }
        }
        return true;
    }

}
