import java.util.*;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected double points;

    Question(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points
    ) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQ extends Question {
    MCQ(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points
    ) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        return correctAnswer.equalsIgnoreCase(studentAnswer)
                ? points : 0;
    }
}

class TrueFalse extends Question {
    TrueFalse(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points
    ) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        return correctAnswer.equalsIgnoreCase(studentAnswer)
                ? points : 0;
    }
}

class Essay extends Question {
    Essay(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points
    ) {
        super(questionText, correctAnswer, studentAnswer, points);
    }

    @Override
    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matches = 0;

        for (String keyword : keywords) {
            String key = keyword.trim().toLowerCase();

            if (!key.isEmpty() &&
                    answer.contains(key)) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        } else if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class q4 {

    static String[] parseInputLine(String line) {
        List<String> tokens = new ArrayList<>();

        java.util.regex.Matcher matcher =
                java.util.regex.Pattern
                        .compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                tokens.add(matcher.group(1));
            } else {
                tokens.add(matcher.group(2));
            }
        }

        return tokens.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] input = parseInputLine(sc.nextLine());

            String type = input[0];
            String questionText = input[1];
            String correctAnswer = input[2];
            String studentAnswer = input[3];
            double points = Double.parseDouble(input[4]);

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                case "TF":
                    question = new TrueFalse(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                case "ESSAY":
                    question = new Essay(
                            questionText,
                            correctAnswer,
                            studentAnswer,
                            points
                    );
                    break;

                default:
                    continue;
            }

            double score = question.evaluate();

            System.out.printf("%s: %.2f%n", type, score);

            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);

        sc.close();
    }
}