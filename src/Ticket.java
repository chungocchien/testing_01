import java.util.Scanner;

public class Ticket {
    public static final String  MAN = "man";
    public static final String  WOMAN = "woman";


    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
            int age = scan.nextInt();
            String gender = scan.next();
            String discount;
            if (age < 0) {
                discount = "Invalid Age";
            } else {
                if (age < 7) {
                    discount = "Free";
                } else {
                    if (age < 15) {
                        if (gender.equals(MAN)) {
                                discount = "No discount";
                            } else {
                            if (gender.equals(WOMAN)) {
                                discount = "Discount 50%";
                            } else {
                            throw new IllegalArgumentException("unknown type " + "\"" + gender + "\"");
                        }
                        }
                    } else {
                        if (age < 60) {
                            discount = "No discount";
                        } else {
                            if (gender.equals(MAN)) {
                                discount = "No discount";
                            } else {
                                if (gender.equals(WOMAN)) {
                                    discount = "Discount 50%";
                                } else {
                                    throw new IllegalArgumentException("unknown type " + "\"" + gender + "\"");
                                }
                            }
                        }
                    }
                }
            }
        System.out.println(discount);
    }
}