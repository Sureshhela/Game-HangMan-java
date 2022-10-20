/* *********** HANG MAN GAME *********** */
/* Chose the coorect word or the man will hanged... */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class HangMan_Game{

    public static boolean printWordState(String word, List<Character> PlayerGuesses){
        int CorrectCount = 0;
        for(int i=0; i<word.length();i++){
            if(PlayerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                CorrectCount++;
            }
            else{
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == CorrectCount);
    }

    public static boolean getPlayerGuess(Scanner ki, String word, List<Character> PlayerGuesses ){
        System.out.println("Please Enter a letter to complete the word: ");
        String letterGuess =  ki.nextLine();
        PlayerGuesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);

    }
    public static void printHangedMan(int wrongCount){
        System.out.println(" -------");
        System.out.println(" |     |");
        if(wrongCount>=1){
            System.out.println(" O");
        }
        if(wrongCount>=2){
            System.out.print("\\ ");
            if(wrongCount>=3){
                System.out.println("/");
            }else{
                System.out.println("");
            }
        }
        if(wrongCount>=4){
            System.out.println(" |");
        }
        if(wrongCount>=5){
            System.out.print("/ ");
            if(wrongCount>=6){
                System.out.println("\\");
            }else{
                System.out.println("");
            }
        }
        System.out.println("");
        System.out.println("");

    }


    public static void main(String[] args) throws FileNotFoundException {
        Scanner ki = new Scanner(System.in);
        System.out.println("How many Plyers are there 1 or 2 ?");
        String players = ki.nextLine();
        String  word;
        if(players.equals("1")){
            Scanner fc =  new Scanner(new File("C:/Users/sureshhela05/OneDrive/Desktop/HangMan/WordLibrary.txt"));
            List<String> words = new ArrayList<>();
            while(fc.hasNext()){
                words.add((fc.nextLine()));
            }
            
            Random r = new Random();
            // taking a ramdom word from list "words".
            word = words.get(r.nextInt(words.size()));
        }
        else{
            System.out.println("Player 1 please enter your word: ");
            word = ki.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("Ready player 2! Good luck! ");
        }

        System.out.println(word);

        List<Character> PlayerGuesses =  new ArrayList<>();
        
        int wrongCount= 0;
        while(true){
            printHangedMan(wrongCount);
            if(wrongCount>=6){
                System.out.println("You lose! The MAN is Dead!");
                break;
            }
            printWordState(word, PlayerGuesses);
            if(!getPlayerGuess(ki,word,PlayerGuesses)){
                wrongCount++;
            }
        if(printWordState(word, PlayerGuesses)){
            System.out.println("You won! You are smart.");
            break;
         }
         System.out.println("Please enter your guess for the word");
         if(ki.nextLine().equals(word)){
            System.out.println("You won! You are smart.");
             break;
         }
         else{
             System.out.println("Nope! Please guess again");
         }
        }
        
       
    }//end of main method.
}//end of class.