
//code of surveysystem interncroud name gauresh khope
import java.util.ArrayList;
import java.util.Scanner;

public class SurveySystem {

    public static void main(String[] args) {
        Scanner canner = new Scanner(System.in);

        // create a list of questions
        ArrayList<String> questions = new ArrayList<String>();
        System.out.print("How many numeric answer questions do you want to include in the survey? ");
        int numOfQuestions = canner.nextInt();
        canner.nextLine();
        for (int i = 1; i <= numOfQuestions; i++) {
            System.out.print("Enter question " + i + ": ");
            questions.add(canner.nextLine());
        }

        // create an array to store the answers
        int[] answerCounts = new int[numOfQuestions];

        // prompt the user to take the survey
        System.out.println("Welcome to our survey!");
        System.out.println(
                "Please answer the following questions with a number from 1 to 5, where 1 is strongly disagree and 5 is strongly agree.");

        int numOfRespondents = 0;
        boolean continueTakingSurvey = true;

        while (continueTakingSurvey) {
            numOfRespondents++;

            // ask each question and get the user's answer
            for (int i = 0; i < questions.size(); i++) {
                System.out.print(questions.get(i) + " ");
                int answer = canner.nextInt();
                answerCounts[i] += answer;
            }

            // ask the user if they want to continue taking the survey
            System.out.print("Thank you for taking the survey! Do you want to continue? (yes or no) ");
            String continueAnswer = canner.next();
            if (continueAnswer.equals("no")) {
                continueTakingSurvey = false;
            }
        }

        // print out the results
        System.out.println("\nSurvey Results:");
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(questions.get(i) + " Average Rating: " + (answerCounts[i] / (double) numOfRespondents));
        }
        canner.close();
    }

}
