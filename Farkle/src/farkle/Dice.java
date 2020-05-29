/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farkle;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
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
    
    private Scanner scan=new Scanner(System.in);
    
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
                + "The dice that you saved from a combination can no longer be resused. \n"
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
    public void rollUserDice()
    {
        for (int i=0; i<6; i++)
        {
            userDice.add(rand.nextInt(6)+1);
            System.out.println("Dice "+(i+1)+": " +userDice.get(i));
        }
    }
    public void rerollUserDice()
    {
        System.out.println("These are currently your dice, in numerical order: ");
        for(int i=0; i<userDice.size(); i++)
        {
            System.out.println("Dice #"+(i+1)+": "+userDice.get(i));
        }
        System.out.println("What dice would you like to reroll? Enter the dice number. When you are done, enter 0.");
        int temp=userDice.size();
        int counter=0;
        while(temp>0)
        {
            System.out.println("Enter your number: ");
            temp=scan.nextInt();
            if(temp!=0) counter++;
        }
        userDice.clear();
        for (int i=0; i<counter; i++)
        {
            userDice.add(rand.nextInt(6)+1);
        }
    }
    
    public void userTurn()
    {
        //will roll the dice and check for combinations, keeping them as the user wants
        System.out.println("These are your dice: ");
        rollUserDice();
        Combinations c=new Combinations(userDice);
        int[] combinations=c.getCombinations();
        boolean isCombinations=false;
        for(int i=0;i<combinations.length; i++)
        {
            if(combinations[i]>0)
            {
                isCombinations=true;
                break;
            }
        }
        if(isCombinations==false)System.out.println("You Farkled! You will not be getting any points for this turn.");
        else
        {
            System.out.println("What combination(s) would you like to keep? Enter the number of the combination below, or enter 0 if you are done:");
            System.out.println("Remeber: if you use a dice in one combination you cannot use it in another");
            int temp=combinations.length+1;
            while(temp>0)
            {
                System.out.println("Enter your number here: ");
                temp=scan.nextInt();
                try
                {
                    uTurnPoints+=combinations[temp-1];
                }
                catch(Exception e)
                {
                    if(temp-1<0)break;
                    System.out.println("That was not a valid number!");
                }
            }
            System.out.println("Your points right now are: "+uTurnPoints);
            System.out.println("Would you like to reroll any dice? \"Y\" for yes and \"N\" for no");
            String answer=scan.nextLine();
            if(answer.equals("N"))
            {
                uTotalPoints+=uTurnPoints;
                uTurnPoints=0;
                userDice.clear();
                System.out.println("Your Total Points: "+uTotalPoints);
                System.out.println("Computer Total Points: "+cTotalPoints);
            }
            else
            {
                while(answer.equals("Y"))
                {
                    rerollUserDice();
                    
                    c=new Combinations(userDice);
                    combinations=c.getCombinations();
                    isCombinations=false;
                    for(int i=0;i<combinations.length; i++)
                    {
                        if(combinations[i]>0)
                        {
                            isCombinations=true;
                            break;
                        }
                    }
                    if(isCombinations==false)System.out.println("You Farkled! You will not be getting any points for this turn.");
                    else
                    {
                        System.out.println("What combination(s) would you like to keep? Enter the number of the combination below, or enter 0 if you are done:");
                        System.out.println("Remeber: if you use a dice in one combination you cannot use it in another");
                        temp=combinations.length+1;
                        while(temp>0)
                        {
                            System.out.println("Enter your number here: ");
                            temp=scan.nextInt();
                            try
                            {
                                uTurnPoints+=combinations[temp-1];
                            }
                            catch(Exception e)
                            {
                                if(temp-1<0)break;
                                System.out.println("That was not a valid number!");
                            }
                        }
                    }
                    System.out.println("Would you like to reroll any other dice? \"Y\" for yes and \"N\" for no");
                    answer=scan.nextLine();
                }
            }
        }
    }
    
    public void computerTurn()
    {
        //will roll the dice and check for combinations, keeping the combination with the most points and only rerolling if there are 3 or more dice left
    }
    
    
}

