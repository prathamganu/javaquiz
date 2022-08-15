import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
    public class Game {
        private ArrayList<Question> questionSet;
        public Game(){
            questionSet = new ArrayList<Question>();
            String q= "What is the biggest continent on Earth?";
            String[] a = {"Antarctica","Asia","Europe","North America"};
            questionSet.add(new Question(q,a,"Asia") );
            q = "What is the highest peak on Earth?";
            a = new String[]{"Everest","Fuji","K2","Titlis"};
            questionSet.add(new Question(q,a,"Everest"));
            q = "How many oceans are there on Earth?";
            a = new String[]{"3","5","6","4"};
            questionSet.add(new Question(q,a,"4"));
            Collections.shuffle(questionSet, new Random());
        }
        public void start()
        {
            Scanner scan = new Scanner(System.in);
            int numCorrect = 0;
            for(int question=0;question<questionSet.size();question++)
            {
                System.out.println(questionSet.get(question).getQuestion());
                int numChoices = questionSet.get(question).getChoices().size();
                for (int choice=0;choice<numChoices;choice++)
                {
                    System.out.println((choice+1)+" : "+
                            questionSet.get(question).getChoices().get(choice));
                }
                int playerAnswer=scan.nextInt();
                ArrayList<String> choiceSet=
                        questionSet.get(question).getChoices();
                String correctAnswer= questionSet.get(question).getAnswer();
                int correctAnswerIndex= choiceSet.indexOf(correctAnswer);
                if(playerAnswer == correctAnswerIndex + 1 ){
                    numCorrect++;
                }
            }scan.close();
            System.out.println("You got "+numCorrect+" correct answer(s)");
            System.out.println("Your score is "+numCorrect*10);
        }

    }

