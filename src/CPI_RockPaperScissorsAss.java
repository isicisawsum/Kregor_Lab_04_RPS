import java.util.Scanner; //importing Scanner
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CPI_RockPaperScissorsAss {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String Player1 = "";
        String Player2 = "";
        String Playing = "Y";
        do {
            System.out.println("Player 1: Choose Rock (R), Paper(P) or Scissors (S)");
            Player1 = in.nextLine();
            System.out.println("Player 2: Choose Rock (R), Paper(P) or Scissors (S)");
            Player2 = in.nextLine();
            if (Player1.equals(Player2)) {
                System.out.println("It’s a tie! Play again? (Y or N)");
                Playing = in.nextLine();
            }
            else if (Player1.equals("R") && Player2.equals("P")) {
                System.out.println("Paper covers rock. Player 2 wins! Play again ? (Y or N)");
                Playing = in.nextLine();
            }
            else if (Player1.equals("P") && Player2.equals("R")) {
                System.out.println("Paper covers rock. Player 1 wins! Play again ? (Y or N)");
                Playing = in.nextLine();
            }
            else if (Player1.equals("R") && Player2.equals("S")) {
                System.out.println("Rock breaks scissors. Player 1 wins! Play again ? (Y or N)");
                Playing = in.nextLine();
            }
            else if (Player1.equals("S") && Player2.equals("R")) {
                System.out.println("Rock breaks scissors. Player 2 wins! Play again ? (Y or N)");
                Playing = in.nextLine();
            }
            else if (Player1.equals("S")  && Player2.equals("P")) {
                System.out.println("Scissors cuts paper. Player 1 wins! Play again ? (Y or N)");
                Playing = in.nextLine();
            }
            else if (Player1.equals("P") && Player2.equals("S")) {
                System.out.println("Scissors cuts paper. Player 2 wins! Play again ? (Y or N)");
                Playing = in.nextLine();
            }
        }
        while (Playing.equals("Y"));
        System.out.println("Thanks for playing!");

    }
}