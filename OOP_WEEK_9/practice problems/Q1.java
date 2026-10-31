
import java.util.Scanner;
public class TicketCounter {


    abstract class Ticket {
        static final double CONVENIENCE_FEE = 20;
        int count;

        Ticket(int count) {
            this.count = count;
        }

        abstract double getPrice();

        abstract String getSeat();

        double calculateAmount() {
            return count * (getPrice() + CONVENIENCE_FEE);
        }
    }

    class RegularTicket extends Ticket {
        RegularTicket(int count) {
            super(count);
        }

        double getPrice() {
            return 150;
        }

        String getSeat() {
            return "REGULAR";
        }
    }

    class PremiumTicket extends Ticket {
        PremiumTicket(int count) {
            super(count);
        }

        double getPrice() {
            return 250;
        }

        String getSeat() {
            return "PREMIUM";
        }
    }

    class ReclinerTicket extends Ticket {
        ReclinerTicket(int count) {
            super(count);
        }

        double getPrice() {
            return 400;
        }

        String getSeat() {
            return "RECLINER";
        }
    }

    public class Q1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            Ticket[] tickets = new Ticket[n];
            double total = 0;

            for (int i = 0; i < n; i++) {
                String type = sc.next();
                int count = sc.nextInt();

                switch (type) {
                    case "REGULAR":
                        tickets[i] = new RegularTicket(count);
                        break;
                    case "PREMIUM":
                        tickets[i] = new PremiumTicket(count);
                        break;
                    case "RECLINER":
                        tickets[i] = new ReclinerTicket(count);
                        break;
                }
            }

            for (Ticket ticket : tickets) {
                double amount = ticket.calculateAmount();
                total += amount;

                System.out.printf("%s: %.2f%n",
                        ticket.getSeat(), amount);
            }

            System.out.printf("Total: %.2f%n", total);
            sc.close();
        }
    }

    {
    }
}
