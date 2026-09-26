package week8.classwork;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExamQuestionGrader {

    abstract static class Question {
        private final String text;
        private final String correctAnswer;
        private final String studentAnswer;
        private final int points;

        Question(String text, String correctAnswer, String studentAnswer, int points) {
            this.text = text;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        String getText() {
            return text;
        }

        String getCorrectAnswer() {
            return correctAnswer;
        }

        String getStudentAnswer() {
            return studentAnswer;
        }

        int getPoints() {
            return points;
        }

        abstract String getType();

        abstract double evaluate();
    }

    static class MultipleChoiceQuestion extends Question {
        MultipleChoiceQuestion(String text, String correctAnswer, String studentAnswer, int points) {
            super(text, correctAnswer, studentAnswer, points);
        }

        @Override
        String getType() {
            return "MCQ";
        }

        @Override
        double evaluate() {
            return getStudentAnswer().equals(getCorrectAnswer()) ? getPoints() : 0;
        }
    }

    static class TrueFalseQuestion extends Question {
        TrueFalseQuestion(String text, String correctAnswer, String studentAnswer, int points) {
            super(text, correctAnswer, studentAnswer, points);
        }

        @Override
        String getType() {
            return "TF";
        }

        @Override
        double evaluate() {
            return getStudentAnswer().equals(getCorrectAnswer()) ? getPoints() : 0;
        }
    }

    static class EssayQuestion extends Question {
        EssayQuestion(String text, String correctAnswer, String studentAnswer, int points) {
            super(text, correctAnswer, studentAnswer, points);
        }

        @Override
        String getType() {
            return "ESSAY";
        }

        @Override
        double evaluate() {
            String answer = getStudentAnswer().toLowerCase();
            int matchedKeywords = 0;
            for (String keyword : getCorrectAnswer().split(",")) {
                String trimmedKeyword = keyword.trim().toLowerCase();
                if (!trimmedKeyword.isEmpty() && answer.contains(trimmedKeyword)) {
                    matchedKeywords++;
                }
            }
            if (matchedKeywords >= 2) {
                return getPoints() * 0.75;
            }
            if (matchedKeywords == 1) {
                return getPoints() * 0.50;
            }
            return 0;
        }
    }

    static Question createQuestion(String type, String text, String correctAnswer, String studentAnswer, int points) {
        switch (type) {
            case "MCQ":
                return new MultipleChoiceQuestion(text, correctAnswer, studentAnswer, points);
            case "TF":
                return new TrueFalseQuestion(text, correctAnswer, studentAnswer, points);
            case "ESSAY":
                return new EssayQuestion(text, correctAnswer, studentAnswer, points);
            default:
                throw new IllegalArgumentException("Unknown question type: " + type);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionCount = Integer.parseInt(scanner.nextLine().trim());
        Pattern linePattern = Pattern.compile("^(\\S+)\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+\"(.*?)\"\\s+(\\d+)$");
        List<Question> questions = new ArrayList<>();
        while (questions.size() < questionCount && scanner.hasNextLine()) {
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            Matcher matcher = linePattern.matcher(line);
            if (matcher.matches()) {
                questions.add(createQuestion(matcher.group(1), matcher.group(2), matcher.group(3),
                        matcher.group(4), Integer.parseInt(matcher.group(5))));
            }
        }

        double totalScore = 0;
        for (Question question : questions) {
            double score = question.evaluate();
            totalScore += score;
            System.out.printf("%s: %.2f%n", question.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
        scanner.close();
    }
}
