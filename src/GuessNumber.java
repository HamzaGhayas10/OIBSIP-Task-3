import javax.swing.*;
 
public class GuessNumber {
    public static void main(String[] args) {
        int Number = (int) (Math.random()*100 + 1);
        int userAnswer = 0;
        int count = 1;

        while (userAnswer != Number)
        {
            String response = JOptionPane.showInputDialog(null,"Enter a guess between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, Number, count));
            count++;
        }  
    }

    public static String determineGuess(int userAnswer, int Number, int count){
        if (userAnswer <=0 || userAnswer >100) {
            return "Your guess is invalid";
        }
        else if (userAnswer == Number ){
            return "Correct!\nTotal Guesses: " + count;
        }
        else if (userAnswer > Number) {
            return "Your guess is higher than the number, try again.\nNumber of tries : " + count;
        }
        else if (userAnswer < Number) {
            return "Your guess is lower than the number, try again.\nNumber of tries : " + count;
        }
        else {
            return "Your guess is incorrect\nNumber of tries : " + count;
        }
    }
}