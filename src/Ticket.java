import java.util.Scanner;

public class Ticket {
    public static final String  MAN = "man";
    public static final String  WOMAN = "woman";


    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);


        while (scan.hasNext()) {
            Thread.sleep(200);
            String gender;
            Double age = scan.nextDouble();//by centimeters
            if (age < 0) {
                System.out.println("Invalid Age");
            } else {
                if (age < 7) {
                    System.out.println("Free");
                } else {

                    if (age < 15) {
                        gender = scan.next();
                        System.out.println(dis1(gender));
                    } else {
                        if (age < 60) {
                            System.out.println("No discount");
                        } else {
                            gender = scan.next();
                            System.out.println(dis2(gender));
                        }
                    }
                }
            }

        }

    }

    public static String dis1(String gender) {
        switch (gender) {
            case MAN -> {
                return "No discount";
            }
            case WOMAN -> {
                return "Discount 50%";
            }
            default -> throw new IllegalArgumentException("unknown type " + "\"" + gender + "\"");
        }
    }

    public static String dis2(String gender) {
        switch (gender) {
            case MAN -> {
                return "Discount 50%";
            }
            case WOMAN -> {
                return "Free";
            }
            default -> throw new IllegalArgumentException("unknown type " + "\"" + gender + "\"");
        }
    }

}