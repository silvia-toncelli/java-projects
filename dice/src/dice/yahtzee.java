
package dice;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


public class yahtzee 
{
    private Random rand= new Random();
    //rand.nextInt(6)+1;
    private int[] dice= new int[5];
    private int points=0;
    private ArrayList<Integer> list= new ArrayList<Integer>();
    private ArrayList<Integer> list2= new ArrayList<Integer>();
    
    public yahtzee()
    {
        //don't run set_dice in here
    }
    
    public int [] set_dice()
    {
        int temp;
        for (int i=0; i<5; i++)
        {
            dice[i]=rand.nextInt(6)+1;
        }
        for (int p = 0; p < 4; p++) 
        {
            for (int j = p + 1; j < 5; j++) 
            {
                if (dice[j]<dice[p])
                {
                    temp=dice[j];
                    dice[j]=dice[p];
                    dice[p]=temp;
                }
            }
        }
        for (int i=0; i<5; i++)
        {
            System.out.println("Dice "+(i+1)+":"+dice[i]);
        }
        return dice;
    }
    public int ones()
    {
        int count=0;
        for (int i=0; i<5; i++)
        {
            if (dice[i]==1)
            {
                count++;
            }
        }
        System.out.println("Ones: "+ count);
        return count;
    }
    public int twos()
    {
        int count=0;
        for (int i=0; i<5; i++)
        {
            if (dice[i]==2)
            {
                count++;
            }
        }
        System.out.println("Twos: "+ count);
        return count;
    }
    public int threes()
    {
        int count=0;
        for (int i=0; i<5; i++)
        {
            if (dice[i]==3)
            {
                count++;
            }
        }
        System.out.println("Threes: "+ count);
        return count;
    }
    public int fours()
    {
        int count=0;
        for (int i=0; i<5; i++)
        {
            if (dice[i]==4)
            {
                count++;
            }
        }
        System.out.println("Fours: "+ count);
        return count;
    }
    public int fives()
    {
        int count=0;
        for (int i=0; i<5; i++)
        {
            if (dice[i]==5)
            {
                count++;
            }
        }
        System.out.println("Fives: "+ count);
        return count;
    }
    public int sixes()
    {
        int count=0;
        for (int i=0; i<5; i++)
        {
            if (dice[i]==6)
            {
                count++;
            }
        }
        System.out.println("Sixes: "+ count);
        return count;
    }
    public boolean three_kind()
    {
        boolean bool=false;
        for (int i=0; i<3; i++)
        {
            for (int j=i+1; j<4; j++)
            {
                for (int k=j+1; k<5; k++)
                {
                    if (dice[i]==dice[j]&&dice[j]==dice[k])
                    {
                        bool=true; 
                        break;
                    }
                }
            }
        }
        System.out.println("Three of a Kind: "+bool);
        return bool;
    }
    public boolean four_kind()
    {
        boolean bool=false;
        for (int i=0; i<2; i++)
        {
            for (int j=i+1; j<3; j++)
            {
                for (int k=j+1; k<4; k++)
                {
                    for (int p=k+1; p<5; p++)
                    {
                        if (dice[i]==dice[j]&&dice[j]==dice[k]&&dice[k]==dice[p])
                        {
                            bool=true; 
                            break;
                        }
                    }
                }
            }
        }
        System.out.println("Four of a Kind: "+bool);
        return bool;
    }
    public boolean yahtzee()
    {
        boolean bool=false;
        for (int q=0; q<1; q++)
        {
            for (int i=q+1; i<2; i++)
            {
                for (int j=i+1; j<3; j++)
                {
                    for (int k=j+1; k<4; k++)
                    {
                        for (int p=k+1; p<5; p++)
                        {
                            if (dice[q]==dice[i]&&dice[i]==dice[j]&&dice[j]==dice[k]&&dice[k]==dice[p])
                            {
                                bool=true; 
                                break;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Yahtzee: "+bool);
        return bool;
    }
    public boolean full_house()
    {
        boolean bool=false;
        if ((dice[0]==dice[1]&&dice[2]==dice[1])||(dice[3]==dice[2]&&dice[4]==dice[2]))
        {
            if (dice[0]==dice[1]||dice[3]==dice[4])
            {
                bool=true;
            }
        }
        System.out.println("Full House: "+bool);
        return bool;
    }
    public boolean small_straight()
    {
        boolean bool=false;
        for (int q = 0; q < 3; q++)
        {
            if (dice[q]==dice[q+1]-1)
            {
                bool=true;
            }
            else
            {
                bool=false;
                break;
            }
        }
        for (int q = 1; q < 4; q++)
        {
            if (dice[q]==dice[q+1]-1)
            {
                bool=true;
            }
            else
            {
                bool=false;
                break;
            }
        }
        System.out.println("Small Straight: "+bool);
        return bool;
    }
    public boolean large_straight()
    {
        boolean bool=false;
        for (int q = 0; q < 4; q++)
        {
            if (dice[q]==dice[q+1]-1)
            {
                bool=true;
            }
            else
            {
                bool=false;
                break;
            }
        }
        System.out.println("Large Straight: "+bool);
        return bool;
    }
    public int chance()
    {
        int chance=0; 
        for (int d:dice)
        {
            chance=chance+d;
        }
        System.out.println("Chance: "+chance);
        return chance;
    }  
    public int[] re_roll()
    {
        System.out.println("Type in the dice number if you want to reroll it. type in 0 if not");
        Scanner scan=new Scanner(System.in);
        System.out.println("Do you want to reroll dice #1:");
        if (scan.nextInt()==1)
        {
            list.add(1);
        }
        System.out.println("Do you want to reroll dice #2:");
        if (scan.nextInt()==2)
        {
            list.add(2);
        }
        System.out.println("Do you want to reroll dice #3:");
        if (scan.nextInt()==3)
        {
            list.add(3);
        }
        System.out.println("Do you want to reroll dice #4:");
        if (scan.nextInt()==4)
        {
            list.add(4);
        }
        System.out.println("Do you want to reroll dice #5:");
        if (scan.nextInt()==5)
        {
            list.add(5);
        }
        for (int i:list)
        {
            dice[i-1]=rand.nextInt(6)+1;
        }
        int temp;
        for (int p = 0; p < 4; p++) 
        {
            for (int j = p + 1; j < 5; j++) 
            {
                if (dice[j]<dice[p])
                {
                    temp=dice[j];
                    dice[j]=dice[p];
                    dice[p]=temp;
                }
            }
        }
        System.out.println("The dice will be displayed in numerical order; "
                + "any dice you have chosen to keep will still be there but may be in a different location.");
        for (int i=0; i<5; i++)
        {
            System.out.println("Dice "+(i+1)+":"+dice[i]);
        }
        return dice;
        
    }
    public int[] re_roll2()
    {
        System.out.println("Type in the dice number if you want to reroll it. type in 0 if not");
        Scanner scan=new Scanner(System.in);
        System.out.println("Do you want to reroll dice #1:");
        if (scan.nextInt()==1)
        {
            list2.add(1);
        }
        System.out.println("Do you want to reroll dice #2:");
        if (scan.nextInt()==2)
        {
            list2.add(2);
        }
        System.out.println("Do you want to reroll dice #3:");
        if (scan.nextInt()==3)
        {
            list2.add(3);
        }
        System.out.println("Do you want to reroll dice #4:");
        if (scan.nextInt()==4)
        {
            list2.add(4);
        }
        System.out.println("Do you want to reroll dice #5:");
        if (scan.nextInt()==5)
        {
            list2.add(5);
        }
        for (int i:list2)
        {
            dice[i-1]=rand.nextInt(6)+1;
        }
        int temp;
        for (int p = 0; p < 4; p++) 
        {
            for (int j = p + 1; j < 5; j++) 
            {
                if (dice[j]<dice[p])
                {
                    temp=dice[j];
                    dice[j]=dice[p];
                    dice[p]=temp;
                }
            }
        }
        System.out.println("The dice will be displayed in numerical order; "
                + "any dice you have chosen to keep will still be there but may be in a different location.");
        for (int i=0; i<5; i++)
        {
            System.out.println("Dice "+(i+1)+":"+dice[i]);
        }
        return dice;
        
    }
    public int[] rolls()
    {
        set_dice();
        Scanner scan=new Scanner(System.in);
        System.out.println("Do you want to reroll the dice? (0-no; 1-yes)");
        int answer=scan.nextInt();
        if (answer==1)
        {
            re_roll();
        }
        System.out.println("Do you want to reroll the dice? (0-no; 1-yes)");
        int answer2=scan.nextInt();
        if (answer2==1)
        {
            re_roll2();
        }
        return dice;
    }
    public void turns()
    {
        Scanner scan=new Scanner (System.in);
        int ones_i=0; int twos_i=0; int threes_i=0; int fours_i=0; int fives_i=0; int sixes_i=0;
        boolean ones=false; boolean twos=false; boolean threes=false; boolean fours=false; boolean fives=false; boolean sixes=false;
        boolean three=false; boolean four=false; int three_i=0; int four_i=0;
        boolean full=false; boolean small=false; boolean large=false; boolean yah=false; 
        int full_i=0; int small_i=0; int large_i=0; int yah_i=0;
        boolean chance=false; int chance_i=0;
        for (int x=0; x<13; x++)  
        {
            rolls();
            while(three==false)
            {
                three=three_kind();
                if (three==true)
                {
                    System.out.println("You got three of a kind, do you want to keep that? (0-no, 1-yes)");
                    if (scan.nextInt()==1)
                    {
                        for (int d:dice)
                        {
                            three_i=three_i+d;
                        }
                        three=true;
                        break;
                    }
                    else
                    {
                        three=false;
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            while(four==false)
            {
                four=four_kind();
                if (four==true)
                {
                    System.out.println("You got four of a kind, do you want to keep that? (0-no, 1-yes)");
                    if (scan.nextInt()==1)
                    {
                        for (int d:dice)
                        {
                            four_i=four_i+d;
                        }
                        four=true;
                        break;
                    }
                    else
                    {
                        four=false;
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            while (full==false)
            {
                full=full_house();
                if (full==true)
                {
                    System.out.println("You got a full house, do you want to keep that? (0-no, 1-yes)");
                    if (scan.nextInt()==1)
                    {
                        full=true;
                        full_i=25;
                        break;
                    }
                    else
                    {
                        full=false;
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            while (small==false)
            {
                small=small_straight();
                if (small==true)
                {
                    System.out.println("You got a small straight, do you want to keep that? (0-no, 1-yes)");
                    if (scan.nextInt()==1)
                    {
                        small=true;
                        small_i=30;
                        break;
                    }
                    else
                    {
                        small=false;
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            while (large==false)
            {
                large=large_straight();
                if (large==true)
                {
                    System.out.println("You got a large straight, do you want to keep that? (0-no, 1-yes)");
                    if (scan.nextInt()==1)
                    {
                        large=true;
                        large_i=40;
                        break;
                    }
                    else
                    {
                        large=false;
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            while (yah==false)
            {
                yah=yahtzee();
                if (yah==true)
                {
                    System.out.println("You got a yahtzee, do you want to keep that? (0-no, 1-yes)");
                    if (scan.nextInt()==1)
                    {
                        yah=true;
                        yah_i=50;
                        break;
                    }
                    else
                    {
                        yah=false;
                        break;
                    }
                }
                else
                {
                    break;
                }
            }
            while (ones==false)
            {
                ones_i=ones();
                System.out.println("You got "+ones_i+" ones. Do you want to keep them? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    ones=true;
                    break;
                }
                else
                {
                    ones_i=0;
                    break;
                }
            }
            while (twos==false)
            {
                twos_i=twos();
                System.out.println("You got "+twos_i+" twos. Do you want to keep them? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    twos=true;
                    break;
                }
                else
                {
                    twos_i=0;
                    break;
                }
            }
            while (threes==false)
            {
                threes_i=threes();
                System.out.println("You got "+threes_i+" threes. Do you want to keep them? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    threes=true;
                    break;
                }
                else
                {
                    threes_i=0;
                    break;
                }
            }
            while (fours==false)
            {
                fours_i=fours();
                System.out.println("You got "+fours_i+" fours. Do you want to keep them? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    fours=true;
                    break;
                }
                else
                {
                    fours_i=0;
                    break;
                }
            }
            while (fives==false)
            {
                fives_i=fives();
                System.out.println("You got "+fives_i+" fives. Do you want to keep them? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    fives=true;
                    break;
                }
                else
                {
                    fives_i=0;
                    break;
                }
            }
            while (sixes==false)
            {
                sixes_i=sixes();
                System.out.println("You got "+sixes_i+" sixes. Do you want to keep them? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    sixes=true;
                    break;
                }
                else
                {
                    sixes_i=0;
                    break;
                }
            }
            while (chance==false)
            {
                chance_i=chance();
                System.out.println("This is your chance: "+chance_i+". Do you want to keep it? (0-no; 1-yes)");
                if (scan.nextInt()==1)
                {
                    chance=true;
                    break;
                }
                else
                {
                    chance_i=0;
                    break;
                }
            }
            System.out.println("Score Card: ");
            System.out.println("Ones: "+ones_i);
            System.out.println("Twos: "+twos_i);
            System.out.println("Threes: "+threes_i);
            System.out.println("Fours: "+fours_i);
            System.out.println("Fives: "+fives_i);
            System.out.println("Sixes: "+sixes_i);
            int bonus=(1*ones_i)+(twos_i*2)+(threes_i*3)+(fours_i*4)+(fives_i*5)+(sixes_i*6);
            if (bonus>62)
            {
                System.out.println("Bonus: "+35);
                bonus=35;
            }
            else
            {
                System.out.println("Bonus: "+0);
                bonus=0;
            }
            System.out.println("Three of a Kind: "+three_i);
            System.out.println("Four of a Kind: "+four_i);
            System.out.println("Full House: "+full_i);
            System.out.println("Small Straight: "+small_i);
            System.out.println("Large Straight: "+large_i);
            System.out.println("Chance: "+chance_i);
            System.out.println("Yahtzee: "+yah_i);
            int total=bonus+three_i+four_i+full_i+small_i+large_i+chance_i+yah_i;
            System.out.println("Total Score: "+total);
        }
        System.out.println("Score Card: ");
        System.out.println("Ones: "+ones_i);
        System.out.println("Twos: "+twos_i);
        System.out.println("Threes: "+threes_i);
        System.out.println("Fours: "+fours_i);
        System.out.println("Fives: "+fives_i);
        System.out.println("Sixes: "+sixes_i);
        int bonus=(1*ones_i)+(twos_i*2)+(threes_i*3)+(fours_i*4)+(fives_i*5)+(sixes_i*6);
        if (bonus>62)
        {
            System.out.println("Bonus: "+35);
            bonus=35;
        }
        else
        {
            System.out.println("Bonus: "+0);
            bonus=0;
        }
        System.out.println("Three of a Kind: "+three_i);
        System.out.println("Four of a Kind: "+four_i);
        System.out.println("Full House: "+full_i);
        System.out.println("Small Straight: "+small_i);
        System.out.println("Large Straight: "+large_i);
        System.out.println("Chance: "+chance_i);
        System.out.println("Yahtzee: "+yah_i);
        int total=bonus+three_i+four_i+full_i+small_i+large_i+chance_i+yah_i;
        System.out.println("Total Score: "+total);
        System.out.println("Good Game!!");
    }
    
}
