import java.util.Scanner;

/**
 * @author  Alex Kapajika
 * @version 1.0
 * @since   2025-02-25
 */

final class Microwave {
    /**
     * @exception IllegalStateException
     * @see IllegalStateException
     */
    private Microwave() {
        throw new IllegalStateException("Utility class");
    }
    /** Time Divide. */
    private static final int TIME_DIVIDE = 60;
    /** Maximum Amount. */
    private static final int MAXIMUM_AMOUNT = 3;
    /** Minimum Amount. */
    private static final int MINIMUM_AMOUNT = 2;
    /** Sub Time. */
    private static final int SUB_TIME = 60;
    /** Pizza Time. */
    private static final int PIZZA_TIME = 45;
    /** Soup Time. */
    private static final int SOUP_TIME = 105;

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What are you heating? sub, pizza or soup?");
        String userAnswer = scanner.nextLine().toLowerCase();
        if (!userAnswer.equals("sub")
         && !userAnswer.equals("pizza") && !userAnswer.equals("soup")) {
            System.out.println("This is not a valid item. Try again.");
            return;
        }
        System.out.println("Enter the amount of "
         + userAnswer + "(s) (1, 2, or 3):");
        int itemAmount;
        try {
            itemAmount = Integer.parseInt(scanner.nextLine());
            if (itemAmount < 1 || itemAmount > MAXIMUM_AMOUNT) {
                System.out.println("Invalid amount. "
                 + "You can only choose 1, 2, or 3.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input only (1, 2, or 3).");
            return;
        }
        int baseTime = 0;
        if (userAnswer.equals("sub")) {
            baseTime = SUB_TIME;
        } else if (userAnswer.equals("pizza")) {
            baseTime = PIZZA_TIME;
        } else if (userAnswer.equals("soup")) {
            baseTime = SOUP_TIME;
        }
        int totalTime = baseTime;
        if (itemAmount == MINIMUM_AMOUNT) {
            totalTime = (int) (baseTime * 1.5);
        } else if (itemAmount == MAXIMUM_AMOUNT) {
            totalTime = baseTime * MINIMUM_AMOUNT;
        }
        int minutes = totalTime / TIME_DIVIDE;
        int seconds = totalTime % TIME_DIVIDE;
        System.out.println("Heating time for "
        + itemAmount + " " + userAnswer + "(s): "
         + minutes + " minute(s) and " + seconds + " second(s). ");
    }
}
