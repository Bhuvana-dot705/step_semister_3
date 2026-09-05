import java.util.Arrays;

class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    // Composite score
    public double getCompositeScore() {
        return cgpa * 10 + codingScore * 0.5;
    }

    // Overloaded method - CGPA only
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.0;
    }

    // Overloaded method - CGPA + coding score
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.8 && cgpa < 7.0 && codingScore >= 60;
    }


    public int compareTo(Candidate other) {
        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }


    public String toString() {
        return name + " (" + getCompositeScore() + ")";
    }
}

public class PlacementDrive {

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted =
                new Candidate[candidates.length];

        int count = 0;

        for (Candidate candidate : candidates) {

            boolean eligible;

            if (Candidate.isEligible(candidate.getCgpa())) {
                eligible = true;
            }
            else {
                eligible = Candidate.isEligible(
                        candidate.getCgpa(),
                        candidate.getCodingScore()
                );
            }

            if (eligible) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] result = new Candidate[count];

        for (int i = 0; i < count; i++) {
            result[i] = shortlisted[i];
        }

        Arrays.sort(result);

        String output = "";

        for (int i = 0; i < result.length; i++) {

            output = output + (i + 1) + ". " + result[i];

            if (i < result.length - 1) {
                output = output + " | ";
            }
        }

        return output;
    }

    public static void main(String[] args) {

        Candidate[] candidates = {

                new Candidate("Aisha", 8.2, 40),

                new Candidate("Rohit", 6.8, 65),

                new Candidate("Meena", 6.9, 90),

                new Candidate("Karan", 7.5, 20)
        };

        System.out.println(
                shortlistAndRank(candidates)
        );
    }
}