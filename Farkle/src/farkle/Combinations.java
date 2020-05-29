/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package farkle;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Rachel
 */
public class Combinations 
{
    private int[] combinations= new int[14]; //has all the combination types in order listed in riles, all items will be set to zero unless the combination is fulfiled with the dice
    private ArrayList<Integer> dice= new ArrayList<Integer>();
    
    public Combinations(ArrayList<Integer> dice)
    {
        this.dice=dice;
        Collections.sort(dice);
        for(int i=0; i<14; i++)
        {
            combinations[i]=0;
        }
        displayCombinations();
    }
    public void displayCombinations()
    {
        System.out.println("These are all possible combinations: ");
        System.out.println ("1. Ones:"+countOnes()*100+" \n"
                + "2. Fives:" +countFives()*50+"\n"
                + "3. Three Ones: "+threeOnes()+"\n"
                + "4. Three Twos: "+threeTwos()+"\n"
                + "5. Three Threes: "+threeThrees()+"\n"
                + "6. Three Fours: "+threeFours()+"\n"
                + "7. Three Fives: "+threeFives()+"\n"
                + "8. Three Sixes: "+threeSixes()+"\n"
                + "9. 1-2-3-4-5-6: "+oneToSix()+"\n"
                + "10. Three Pairs: "+threePairs()+"\n"
                + "11. 4 of a Kind: "+fourOfAKind()+"\n"
                + "12. 5 of a Kind: "+fiveOfAKind()+"\n"
                + "13. 6 of a Kind: "+sixOfAKind()+"\n"
                + "14. Two Triplets: "+twoTriplets()+"\n"
        );
    }
    public int[] getCombinations()
    {
        return combinations;
    }
    public int countOnes()
    {
        int count=0;
        for (int i=0; i<dice.size(); i++)
        {
            if (i==1)count++;
        }
        combinations[0]=count*100;
        return count;       
    }
    public int countFives()
    {
        int count=0;
        for (int i=0; i<dice.size(); i++)
        {
            if (i==5)count++;
        }
        combinations[1]=count*50;
        return count;       
    }
    public int threeOnes()
    {
        if (countOnes()==300)
        {
            combinations[2]=300;
            return 300;
        }
        return 0;
    }
    public int threeTwos()
    {
        int count=0;
        for (int i=0; i<dice.size(); i++)
        {
            if (i==2)count++;
        }
        if(count==3){combinations[3]=200; return 200;}
        return 0;
    }
    public int threeThrees()
    {
        int count=0;
        for (int i=0; i<dice.size(); i++)
        {
            if (i==3)count++;
        }
        if(count==3){combinations[4]=300; return 300;}
        return 0;
    }
    public int threeFours()
    {
        int count=0;
        for (int i=0; i<dice.size(); i++)
        {
            if (i==4)count++;
        }
        if(count==3){combinations[5]=400; return 400;}
        return 0;
    }
    public int threeFives()
    {
        if (countOnes()==150)
        {
            combinations[6]=500;
            return 500;
        }
        return 0;
    }
    public int threeSixes()
    {
        int count=0;
        for (int i=0; i<dice.size(); i++)
        {
            if (i==6)count++;
        }
        if(count==3){combinations[7]=600; return 600;}
        return 0;
    }
    public int oneToSix()
    {
        boolean boo=true;
        
        for(int i=0; i<5; i++)
        {
            if((dice.get(i)+1)!=dice.get(i+1))
            {
                boo=false;
                return 0;
            }
        }
        
        combinations[8]=1500;
        return 1500;
    }
    public int threePairs()
    {
        if(dice.get(0)==dice.get(1))
        {
            if (dice.get(2)==dice.get(3))
            {
                if (dice.get(4)==dice.get(5))
                {
                    combinations[9]=600;
                    return 600;
                }
            }
        }
        return 0;
    }
    public int fourOfAKind()
    {
        if (dice.get(0)==dice.get(1)&&dice.get(0)==dice.get(2)&&dice.get(0)==dice.get(3))
        {
            combinations[10]=2000;
            return 2000;
        }
        if(dice.get(1)==dice.get(2)&&dice.get(1)==dice.get(3)&&dice.get(1)==dice.get(4))
        {
            combinations[10]=2000;
            return 2000;
        }
        if(dice.get(2)==dice.get(3)&&dice.get(2)==dice.get(4)&&dice.get(2)==dice.get(5))
        {
            combinations[10]=2000;
            return 2000;
        }
        return 0;
    }
    public int fiveOfAKind()
    {
        if (dice.get(0)==dice.get(1)&&dice.get(0)==dice.get(2)&&dice.get(0)==dice.get(3)&&dice.get(0)==dice.get(4))
        {
            combinations[11]=4000;
            return 4000;
        }
        if(dice.get(1)==dice.get(2)&&dice.get(1)==dice.get(3)&&dice.get(1)==dice.get(4)&&dice.get(1)==dice.get(5))
        {
            combinations[11]=4000;
            return 4000;
        }
        return 0;
    }
    public int sixOfAKind()
    {
        for(int i=0; i<6; i++)
        {
            if(dice.get(0)!=dice.get(i))
            {
                return 0;
            }
        }
        combinations[12]=6000;
        return 6000;
    }
    public int twoTriplets()
    {
        if (dice.get(0)==dice.get(1)&&dice.get(0)==dice.get(2))
        {
            if(dice.get(3)==dice.get(4)&&dice.get(3)==dice.get(5))
            {
                combinations[13]=2500;
                return 2500;
            }
        }
        return 0;
    }
}
