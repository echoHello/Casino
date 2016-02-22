package codecrushermountaincasino;


import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Taylor on 1/30/16.
 */
public class Slots extends Game {
    private String[] payLine;
    HashMap<String,String> slotArt;
    private Art art = new Art();

    public Slots(Player player) {
        super(player);
        slotsEngine();

    }
    public void slotsEngine() {
        System.out.println("Welcome to\n  ______   __        ______    ______    ______    ______  ________   ______  \n" +
                " /      \\ |  \\      /      \\  /      \\  /      \\  /      \\|        \\ /      \\ \n" +
                "|  $$$$$$\\| $$     |  $$$$$$\\|  $$$$$$\\|  $$$$$$\\|  $$$$$$\\\\$$$$$$$$|  $$$$$$\\\n" +
                "| $$___\\$$| $$     | $$  | $$| $$ __\\$$| $$ __\\$$| $$__| $$  | $$   | $$___\\$$\n" +
                " \\$$    \\ | $$     | $$  | $$| $$|    \\| $$|    \\| $$    $$  | $$    \\$$    \\ \n" +
                " _\\$$$$$$\\| $$     | $$  | $$| $$ \\$$$$| $$ \\$$$$| $$$$$$$$  | $$    _\\$$$$$$\\\n" +
                "|  \\__| $$| $$_____| $$__/ $$| $$__| $$| $$__| $$| $$  | $$  | $$   |  \\__| $$\n" +
                " \\$$    $$| $$     \\\\$$    $$ \\$$    $$ \\$$    $$| $$  | $$  | $$    \\$$    $$\n" +
                "  \\$$$$$$  \\$$$$$$$$ \\$$$$$$   \\$$$$$$   \\$$$$$$  \\$$   \\$$   \\$$     \\$$$$$$ \nIt's 5 lorps a round.");

        while (getInPlay()) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Press 'z' to pull the lever, human.");
            if (scan.hasNext("z")) {
                if (player.getChips() >= 5) {
                    pullLever();
                    player.removeChips(5);
                    printSlots();
                    calculateScore();
                    System.out.println("You've got " + player.getChips() + " lorps. Amazing.");

                }else if(player.getChips() < 5){
                    System.out.println("Not enough lorps. Go away.");
                    toggleInPlay();
                } else {
                    toggleInPlay();
                }

            } else {
                toggleInPlay();
            }

        }

    }

    public void pullLever() {
        payLine = new String[3];
        for (int i = 0; i < payLine.length; i++) {
            Integer slotValue = (Integer) (int) (Math.random() * 3);
            payLine[i] = slotValue.toString(); //payline values are strings. Integers toString method

        }
    }

    public void calculateScore(){
        String firstPos = payLine[0];
        Player player = getPlayer();
        for(int i = 0; i < payLine.length; i++){
            if(firstPos.equals(payLine[1]) && firstPos.equals(payLine[2])) {
                player.addChips(50);
                System.out.println("You won 50 lorps.");
                break;
            }else if(firstPos.equals(payLine[1])) {
                player.addChips(15);
                System.out.println("You won 15 lorps.");
                break;
            } else {
                player.addChips(0);
                System.out.println("Worthless human. No lorps for you.");
                break;
            }
        }
    }

    public void printSlots() {
        art.processASCIIArt(art.loadPaylineArt(payLine), Art.SLOT_ART_ARRAY_LENGTH);
    }

}
