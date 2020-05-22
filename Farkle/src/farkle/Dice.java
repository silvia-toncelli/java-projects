/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farkle;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Rachel
 */
public class Dice 
{
    private ArrayList<Integer> userDice= new ArrayList<Integer>();
    
    private ArrayList<Integer> computerDice= new ArrayList<Integer>();
    
    private int uTurnPoints=0; //keeps track of how many points the user has on a turn, resets to 0 every turn
    private int cTurnPoints=0; //keeps track of how many points the computer has in a turn, resets to 0 every turn
    private int uTotalPoints=0; //keeps track of how many points the user has during the game
    private int cTotalPoints=0; //keeps track of how many points the computer has in the game
    
    private Random rand= new Random();
    
    public Dice()
    {
        displayRules();
    }
    public void displayRules()
    {
        System.out.println("Welcome! These are the rules of the game:\n"
                + "To play, you must roll the dice on your turn. You begin by rolling all 6 dice.\n"
                + "When you roll the dice, you have to look for combinations, which will be listed below. Combinations are worth points. \n"
                + "If you still have dice remaining after searching for combinations, you can reroll those dice to try to get more points.\n"
                + "However, if you do not get any combinations with the dice you roll, you Farkle and loose all points that you got during that turn.\n"
                + "All ones and fives are worth points on their own and you can keep them; they can save you from getting a Farkle. \n"
                + "When you've used all your dice, your turn is over. \n"
        );
        
        System.out.println("These are the combinations and points: \n");
        
        System.out.println ("Ones: 100 points\n"
                + "Fives: 50 points\n"
                + "Three Ones: 300 points\n"
                + "Three Twos: 200 points\n"
                + "Three Threes: 300 points\n"
                + "Three Fours: 400 points\n"
                + "Three Fives: 500 points\n"
                + "Three Sixes: 600 points\n"
                + "1-2-3-4-5-6: 1500 points\n"
                + "Three Pairs: 600 points\n"
                + "4 of a Kind: 2000 points\n"
                + "5 of a Kind: 4000 points\n"
                + "6 of a Kind: 6000 points\n"
                + "Two Triplets: 2500 points\n"
        );
        
        System.out.println("First Player to 10000 points wins. Enjoy!");
        
    }
    public void userTurn()
    {
        //will roll the dice and check for combinations, keeping them as the user wants
    }
    public void computerTurn()
    {
        //will roll the dice and check for combinations, keeping the combination with the most points and only rerolling if there are 3 or more dice left
    }
    
    
}
