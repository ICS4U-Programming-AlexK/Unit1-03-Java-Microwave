import java.util.Scanner;

/**
 * @author  Alex Kapajika
 * @version 1.0
 * @since   2025-02-25
 */
public final class Microwave {
    
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("What are you heating? sub, pizza or soup?");
        // A minute is 60 seconds, so I converted it.
        int subTime = 60;
        int pizzaTime = 45;
        int soupTime = 105;
        
        String userAnswer = scanner.nextLine().toLowerCase();
        
        if (!userAnswer.equals("sub") && !userAnswer.equals("pizza") && !userAnswer.equals("soup")) {
            System.out.println("This is not a valid item. Try again.");
            return;
        }
        
        System.out.println("Enter the amount of " + userAnswer + "(s) (1, 2, or 3):");
        
        int itemAmount;
        try {
            itemAmount = Integer.parseInt(scanner.nextLine());
            if (itemAmount < 1 || itemAmount > 3) {
                System.out.println("Invalid amount. You can only choose 1, 2, or 3.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only (1, 2, or 3).");
            return;
        }
        
        int baseTime = 0;
        if (userAnswer.equals("sub")) {
            baseTime = subTime;
        } else if (userAnswer.equals("pizza")) {
            baseTime = pizzaTime;
        } else if (userAnswer.equals("soup")) {
            baseTime = soupTime;
        }
        
        int totalTime = baseTime;
        if (itemAmount == 2) {
            totalTime = (int) (baseTime * 1.5);
        } else if (itemAmount == 3) {
            totalTime = baseTime * 2;
        }
        
        int minutes = totalTime / 60;
        int seconds = totalTime % 60;
        
        System.out.println("Heating time for " + itemAmount + " " + userAnswer + "(s): " + minutes + " minute(s) and " + seconds + " second(s). ");
    }
}