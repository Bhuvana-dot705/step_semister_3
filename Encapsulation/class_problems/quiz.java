class Scorecard {
    private final boolean[] results;
    private int answerCount;

    public Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            throw new IllegalArgumentException(
                    "Question count cannot be negative"
            );
        }

        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    public void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        } else {
            System.out.println("All questions have been recorded");
        }
    }

    public int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }
}

public class quiz {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Final Score: " + sc.getScore());
    }
}