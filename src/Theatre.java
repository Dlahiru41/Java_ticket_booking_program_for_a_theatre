import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Theatre {
    // arrays to store the information about seat
    static boolean[] firstRow = new boolean[12];
    static boolean[] secondRow = new boolean[16];
    static boolean[] thirdRow = new boolean[20];
    static boolean[][] cinemaHall = new boolean[3][];
//-----------------------------------------------------------
    //---------MAIN METHOD-----------
    public static void main(String[] args) {
        System.out.println("Welcome to the New Theatre");
        cinemaHall[0] = firstRow;
        cinemaHall[1] = secondRow;
        cinemaHall[2] = thirdRow;
        //----infinite validate user inputs-------
        while(true) {
            Scanner scanner = new Scanner(System.in);
            int command=20;
                try {
                    System.out.println("""
                            -------------------------------------------------
                             Please select an option:
                            1) Buy a ticket
                            2) Print seating area
                            3) Cancel ticket
                            4) List available seats
                            5) Save to file
                            6) Load from file
                            7) Print ticket information and total price
                            8) Sort tickets by price
                            0) Quit
                            -------------------------------------------------
                            Enter option:\s
                            """);

                    command = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                }

            if (command == 1) {
                buy_ticket(cinemaHall);
            } else if (command == 0) {
                break;
            } else if (command == 2) {
                print_seating_area(cinemaHall);
            } else if (command == 3) {
                cancel_ticket(cinemaHall);
            } else if (command == 4) {
                show_available(cinemaHall);
            } else if (command == 5) {
                save(firstRow, secondRow, thirdRow);
            } else if (command == 6) {
                load();
            } else {
                System.out.println("Invalid Command");
            }
        }

    }
    public static void  buy_ticket(boolean[][] cinemaHall) {
        int row;
        int seat;

   while(true) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the number of the row");
       row = scanner.nextInt();
       if (row>0&&row<=3){
           break;
       }
       else{
           System.out.println("invalid row number");
       }
   }
  while (true){
      Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of the seat");
        seat = scanner.nextInt();
        if (row==1){
            if (seat<=12&&seat>0){
                if(cinemaHall[row - 1][seat - 1]){
                    System.out.println("seat is already occupied");
                }
                else {
                    cinemaHall[row-1][seat-1]=true;
                    break;
                }
            }
            else{
                System.out.println("invalid seat number");
            }
        }
        else if(row==2){
            if(seat<=16 && seat>0){
                if(cinemaHall[row - 1][seat - 1]){
                    System.out.println("seat is already occupied");
                }
                else {
                    cinemaHall[row-1][seat-1]=true;
                    break;
                }
            }
            else{
                System.out.println("invalid seat number");
            }
        }
        else{
            if(seat<=20&&seat>0){
                if(cinemaHall[row - 1][seat - 1]){
                    System.out.println("seat is already occupied");
                }
                else {
                    cinemaHall[row-1][seat-1]=true;
                    break;
                }
            }
            else{
                System.out.println("Invalid Seat number");
            }
      }
  }

        cinemaHall[row - 1][seat - 1] = true;
        print_seating_area(cinemaHall);


    }
    public static void print_seating_area(boolean[][] cinemaHall){
        System.out.println(
                "    "+"*********** \n" +
                "    "+" * STAGE * \n" +
                "    "+"***********");
        for (boolean[] boolArray : cinemaHall) {
            if(boolArray.length==12){
                System.out.print("    ");
            }
            else if(boolArray.length==16){
                System.out.print("  ");
            }
            else if(boolArray.length==20){
                System.out.print("");
            }

//            for (boolean bool : boolArray)
            for (int i=0;i< boolArray.length;i++){
                    if (!boolArray[i]) {
                        System.out.print("O");
                        if(i==boolArray.length/2-1){
                            System.out.print(" ");
                        }
                    } else {
                        System.out.print("X");
                        if(i==boolArray.length/2){
                            System.out.print(" ");
                        }
                    }
            }
            System.out.println();
        }
    }
    public static void cancel_ticket(boolean[][] cinemaHall){
        int row;
        int seat;

        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of the row");
            row = scanner.nextInt();
            if (row>0&&row<=3){
                break;
            }
            else{
                System.out.println("invalid row number");
            }
        }
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of the seat you want cancel");
            seat = scanner.nextInt();
            if (row==1){
                if (seat<=12&&seat>0){
                    if(cinemaHall[row - 1][seat - 1]){
                        System.out.println("seat is already occupied");
                        System.out.println("Ticket is cancled...");
                        cinemaHall[row-1][seat-1]=false;
                        break;
                    }
                    else {
                        System.out.println("seat is not occupied");
                        break;
                    }
                }
                else{
                    System.out.println("invalid seat number");
                }
            }
            else if(row==2){
                if(seat<=16 && seat>0){
                    if(cinemaHall[row - 1][seat - 1]){
                        System.out.println("seat is already occupied");
                        System.out.println("Ticket is cancled...");
                        cinemaHall[row-1][seat-1]=false;
                        break;
                    }
                    else {
                        System.out.println("seat is not occupied");
                        break;
                    }
                }
                else{
                    System.out.println("invalid seat number");
                }
            }
            else{
                if(seat<=20&&seat>0){
                    if(cinemaHall[row - 1][seat - 1]){
                        System.out.println("seat is already occupied");
                        System.out.println("Ticket is cancled...");
                        cinemaHall[row-1][seat-1]=false;
                        break;
                    }
                    else {
                        System.out.println("seat is not occupied");
                        break;
                    }
                }
                else{
                    System.out.println("Invalid Seat number");
                }
            }
        }
    }
    public static void show_available(boolean[][] cinemaHall){
        for(int a=0;a<cinemaHall.length;a++){
            System.out.print("Seats available in row "+(a+1)+": ");
            for(int i=0;i<cinemaHall[a].length;i++){
                if(!cinemaHall[a][i]){
                    System.out.print(i+1+",");
                }
            }
            System.out.println();
        }
    }
    public static void save(boolean[]array1,boolean[] array2,boolean[] array3){
        try {
            FileWriter writer = new FileWriter("output.txt");
            BufferedWriter buffer = new BufferedWriter(writer);

            for (boolean b : array1) {
                buffer.write(b + " ");
            }
            buffer.newLine();

            for (boolean b : array2) {
                buffer.write(b + " ");
            }
            buffer.newLine();

            for (boolean b : array3) {
                buffer.write(b + " ");
            }
            buffer.newLine();

            buffer.close();
            writer.close();
            System.out.println("Data was successfully written to the file name 'output'");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public static void load(){

        try {
            File file = new File("output.txt");
            Scanner scanner = new Scanner(file);

            // Read the first array from the file
            String[] line = scanner.nextLine().split(" ");
            firstRow = new boolean[line.length];
            for (int i = 0; i < line.length; i++) {
                firstRow[i] = Boolean.parseBoolean(line[i]);
            }

            // Read the second array from the file
            line = scanner.nextLine().split(" ");
            secondRow = new boolean[line.length];
            for (int i = 0; i < line.length; i++) {
                secondRow[i] = Boolean.parseBoolean(line[i]);
            }

            // Read the third array from the file
            line = scanner.nextLine().split(" ");
            thirdRow = new boolean[line.length];
            for (int i = 0; i < line.length; i++) {
                thirdRow[i] = Boolean.parseBoolean(line[i]);
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        cinemaHall[0] = firstRow;
        cinemaHall[1] = secondRow;
        cinemaHall[2] = thirdRow;
        for(boolean bol:firstRow){
            System.out.print(bol+" ");
        }
    }
}
