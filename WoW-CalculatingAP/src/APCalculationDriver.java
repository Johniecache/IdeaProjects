import java.util.*;

public class APCalculationDriver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter [str agi stam int spirit class race]: ");

            int str = sc.nextInt();
            int agi = sc.nextInt();
            int stam = sc.nextInt();
            int intel = sc.nextInt();
            int spi = sc.nextInt();
            String c = sc.next();
            String race = sc.next();

            Stats s = new Stats(str,agi,stam,intel,spi,c,race);
            s.toString();
        } catch (InputMismatchException e) {
            System.out.print(">>Input mismatch when entering stats: " + e);
        }
    }
}