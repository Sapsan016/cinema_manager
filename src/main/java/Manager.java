import java.util.Scanner;

public class Manager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();
        String[][] seatsArray = createArray(rows, seatsInRow);

        boolean isContinue = true;
        int command = -1;
        while (isContinue) {
            printMenu();
            command = scanner.nextInt();
            switch (command) {
                case 1 -> {
                    printArray(seatsArray, rows, seatsInRow);
                    break;
                }
                case 2 -> {
                    System.out.println("Enter a row number:");
                    int rowNumber = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seatNumber = scanner.nextInt();
                    calculatePrice(rows, seatsInRow, rowNumber);
                    changeArray(seatsArray, rowNumber, seatNumber);
                    break;
                }
                case 0 -> {
                    isContinue = false;
                }
            }
        }
    }

    public static void calculatePrice(int n, int m, int r) {
        int seats = m * n;
        int halfRows = n / 2;
        int ticketPrice = 0;
        if (seats <= 60) {
            ticketPrice = 10;
        } else {
            if (r <= halfRows) {
                ticketPrice = 10;
            } else {
                ticketPrice = 8;
            }
        }
        System.out.println("Ticket price:");
        System.out.println("$" + ticketPrice);
    }

    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
    }

    public static String[][] createArray(int n, int m) {
        String[][] array = new String[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {

            for (int j = 1; j < m + 1; j++) {
                array[i][j] = "S";
            }
        }
        return array;
    }

    public static void printArray(String[][] array, int n, int m) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= m; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print("");

        for (int i = 1; i < n + 1; i++) {
            System.out.print(i + " ");
            for (int j = 1; j < m + 1; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void changeArray(String[][] array, int r, int s) {
        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (i == r && j == s) {
                    array[i][j] = "B";
                }
            }
        }
    }
}


