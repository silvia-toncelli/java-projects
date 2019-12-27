package calendar;
import java.util.Scanner;

public class date_time 
{
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute; 
    private int second;
    private boolean checker;
    private boolean checker2;
    
    private int Birthyear;
    private int Birthmonth;
    private int Birthday;
    private int Birthhour;
    private int Birthminute; 
    private int Birthsecond;
    
    private int diffyear;
    private int diffmonth;
    private int diffday;
    private int diffhour;
    private int diffminute; 
    private int diffsecond;
    
    public date_time() 
        {
            setYear();
            setMonth();
            setDay();
            setHour();
            setMinute();
            setSecond();
            check_date();
            check_time();
            
        }
    
    public int setYear()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the year:");
        year=scan.nextInt();
        return year;
    }
    public int setMonth()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the month (numerical) :");
        month=scan.nextInt();
        return month;
    }
    public int setDay()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the day (numerical) :");
        day=scan.nextInt();
        return day;
    }
    public int setHour()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the hour (military) :");
        hour=scan.nextInt();
        return hour;
    }
    public int setMinute()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the minute:");
        minute=scan.nextInt();
        return minute;
    }
    public int setSecond()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the second:");
        second=scan.nextInt();
        return second;
    }
    public int setBirthYear()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter your birth year:");
        Birthyear=scan.nextInt();
        return Birthyear;
    }
    public int setBirthMonth()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter your birth month (numerical) :");
        Birthmonth=scan.nextInt();
        return Birthmonth;
    }
    public int setBirthDay()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter your birth day (numerical) :");
        Birthday=scan.nextInt();
        return Birthday;
    }
    public int setBirthHour()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter your birth hour (military) :");
        Birthhour=scan.nextInt();
        return Birthhour;
    }
    public int setBirthMinute()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter your birth minute:");
        Birthminute=scan.nextInt();
        return Birthminute;
    }
    public int setBirthSecond()
    {
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter your birth second:");
        Birthsecond=scan.nextInt();
        return Birthsecond;
    }
    public boolean check_date()
    {
        if (month<=12)
        {
            if (month==1||month==3||month==5||month==7||month==8||month==10)
            {
                if (day<=31)
                {
                    checker=true;
                }
                else
                {
                    checker=false;
                    System.out.println("Invalid input; check day");
                }
            }
            if (month==4||month==6||month==9||month==11)
            {
                if (day<=30)
                {
                    checker=true;
                }
                else
                {
                    checker=false;
                    System.out.println("Invalid input; check day");
                }
            }
            if (month==2)
            {
                if (day<=28)
                {
                    checker=true;
                }
                else
                {
                    checker=false;
                    System.out.println("Invalid input; check day");
                }
            }
        }
        else
        {
            checker=false;
            System.out.println("Invalid input; check month");
        }
        return checker;
    }
    public boolean check_time()
    {
        if (hour<=23)
        {
            if (minute<=59)
            {
                if (second<=59)
            {
                checker2=true;
            }
            else
            {
                checker2=false;
                System.out.println("Invalid input; check second");
            }
            }
            else
            {
                checker2=false;
                System.out.println("Invalid input; check minute");
            }
        }
        else
        {
            checker2=false;
            System.out.println("Invalid input; check hour");
        }
        return checker2;
    }
    public void display_original()
    {
        if (checker==true&&checker2==true)
        {
            String minute1="";
            String second1="";
            String hour1="";
            if (hour<10)
            {
                hour1="0";
            }
            if (minute<10)
            {
                minute1="0";
            }
            if (second<10)
            {
                second1="0";
            }
            System.out.println("the date is "+month+"/"+day+"/"+year);
            System.out.println("the time is "+hour1+hour+":"+minute1+minute+":"+second1+second);
        }
    }
    public void display_originalBirth()
    {
        if (checker==true&&checker2==true)
        {
            String minute1="";
            String second1="";
            String hour1="";
            if (Birthhour<10)
            {
                hour1="0";
            }
            if (Birthminute<10)
            {
                minute1="0";
            }
            if (Birthsecond<10)
            {
                second1="0";
            }
            System.out.println("your birth date is "+Birthmonth+"/"+Birthday+"/"+Birthyear);
            System.out.println("your birth time is "+hour1+Birthhour+":"+minute1+Birthminute+":"+second1+Birthsecond);
        }
    }
    public void increment()
    {
        if (second==59)
        {
            if (minute==59)
            {
                if (hour==23)
                {
                    if (day==28)
                    {
                        if (month==2)
                        {
                            if (year%4==0)
                            {
                                day=day+1;
                                hour=00;
                                minute=00;
                                second=00;
                            }
                            else
                            {
                                month=3;
                                day=1;
                                hour=00;
                                minute=00;
                                second=00;
                            }
                        }
                        else
                        {
                            day=day+1;
                            hour=00;
                            minute=00;
                            second=00;
                        }
                    }
                    else if (day==30)
                    {
                        if (month==4||month==6||month==9||month==11)
                        {
                            month=month+1;
                            day=1;
                            hour=00;
                            minute=00;
                            second=00;
                        }
                        else
                        {
                            day=day+1;
                            hour=00;
                            minute=00;
                            second=00;
                        }
                    }
                    else if (day==31)
                    {
                        if (month==12)
                        {
                            year=year+1;
                            month=1;
                            day=1;
                            hour=00;
                            minute=00;
                            second=00;
                        }
                        else
                        {
                            month=month+1;
                            day=1;
                            hour=00;
                            minute=00;
                            second=00;
                        }
                    }
                    else
                    {
                        day=day+1;
                        hour=00;
                        minute=00;
                        second=00;
                    }
                }
                else
                {
                    hour=hour+1;
                    minute=00;
                    second=00;
                }
            }
            else
            {
                minute=minute+1;
                second=00;
            }
        }
        else
        {
            second=second+1;
        }
        
        String minute1="";
        String second1="";
        String hour1="";
        if (hour<10)
        {
            hour1="0";
        }
        if (minute<10)
        {
            minute1="0";
        }
        if (second<10)
        {
            second1="0";
        }
        
        System.out.println("the date in one second is "+month+"/"+day+"/"+year);
        System.out.println("the time in one second is "+hour1+hour+":"+minute1+minute+":"+second1+second);
    }
    public void decrement()
    {
        if (second==0)
        {
            if (minute==0)
            {
                if(hour==0)
                {
                    if (day==1)
                    {
                        if (month==1)
                        {
                            year=year-1;
                            month=12;
                            day=31;
                            hour=23;
                            minute=59;
                            second=59;
                        }
                        else if (month-1==4||month-1==6||month-1==9||month-1==11)
                        {
                            month=month-1;
                            day=30;
                            hour=23;
                            minute=59;
                            second=59;
                        }
                        else if (month-1==1||month-1==3||month-1==5||month-1==7||month-1==8||month-1==10)
                        {
                            month=month-1;
                            day=31;
                            hour=23;
                            minute=59;
                            second=59;
                        }
                        else if (month==3)
                        {
                            if (year%4==0)
                            {
                                month=month-1;
                                day=29;
                                hour=23;
                                minute=59;
                                second=59;
                            }
                            else
                            {
                                month=month-1;
                                day=28;
                                hour=23;
                                minute=59;
                                second=59;
                            }
                        }
                    }
                    else
                    {
                        day=day-1;
                        hour=23;
                        minute=59;
                        second=59;
                    }
                }
                else
                {
                    hour=hour-1;
                    minute=59;
                    second=59;
                }
            }
            else
            {
                minute=minute-1;
                second=59;
            }
        }
        else
        {
            second=second-1;
        }
        
        String minute1="";
        String second1="";
        String hour1="";
        if (hour<10)
        {
            hour1="0";
        }
        if (minute<10)
        {
            minute1="0";
        }
        if (second<10)
        {
            second1="0";
        }
        
        System.out.println("the date one second ago was "+month+"/"+day+"/"+year);
        System.out.println("the time one second ago was "+hour1+hour+":"+minute1+minute+":"+second1+second);
    }
    public void birthday()
    {
        diffsecond=second-Birthsecond;
        diffminute=minute-Birthminute;
        diffhour=hour-Birthhour;
        diffday=day-Birthday;
        diffmonth=month-Birthmonth;
        diffyear=year-Birthyear;
        if (diffsecond<0)
        {
            diffminute=diffminute-1;
            diffsecond=60+(second-Birthsecond);
        }
        if (diffminute<0)
        {
            diffhour=diffhour-1;
            diffminute=60+(minute-Birthminute);
        }
        if (diffhour<0)
        {
            diffday=diffday-1;
            diffhour=24+(hour-Birthhour);
        }
        if (diffday<0)
        {
            diffmonth=diffmonth-1;
            if (Birthmonth==1||Birthmonth==3||Birthmonth==5||Birthmonth==7||Birthmonth==8||Birthmonth==10||Birthmonth==12)
            {
                diffday=31+(day-Birthday);
            }
            if (Birthmonth==4||Birthmonth==6||Birthmonth==9||Birthmonth==11)
            {
                diffday=30+(day-Birthday);
            }
            if(Birthmonth==2)
            {
                diffday=28+(day-Birthday);
            }
        }
        if (diffmonth<0)
        {
            diffyear=diffyear-1;
            diffmonth=12+(month-Birthmonth)-1;
        }
        
        System.out.println("You are "+diffyear+" years "+diffmonth+" months "+diffday+" days "+diffhour+" hours "+diffminute+ " minutes "+ diffsecond+" seconds");
    }
    public void double_birthday()
    {
        year=year+diffyear;
        month=month+diffmonth;
        day=diffday+day;
        hour=diffhour+hour;
        minute=diffminute+minute;
        second=diffsecond+second;
        if (second>59)
        {
            minute=minute+1;
            second=second-60;
        }
        if (minute>59)
        {
            hour=hour+1;
            minute=minute-60;
        }
        if (hour>23)
        {
            day=day+1;
            hour=hour-24;
        }
        if (day>30)
        {
            month=month+1;
            day=day-31;
        }
        if (month>11)
        {
            year=year+1;
            month=month-12;
        }
        String minute1="";
        String second1="";
        String hour1="";
        if (hour<10)
        {
            hour1="0";
        }
        if (minute<10)
        {
            minute1="0";
        }
        if (second<10)
        {
            second1="0";
        }
        System.out.println("The date when you are double your age will be "+month+"/"+day+"/"+year);
        System.out.println("The time when you are double your age will be "+hour1+hour+":"+minute1+minute+":"+second1+second);
    }
    public void expiration_date()
    {
        Scanner scan1= new Scanner(System.in);
        System.out.println("How many years do you want to increment by?");
        diffyear=scan1.nextInt();
        System.out.println("How many month do you want to increment by?");
        diffmonth=scan1.nextInt();
        System.out.println("How many days do you want to increment by?");
        diffday=scan1.nextInt();
        System.out.println("How many hours do you want to increment by?");
        diffhour=scan1.nextInt();
        System.out.println("How many minutes do you want to increment by?");
        diffminute=scan1.nextInt();
        System.out.println("How many seconds do you want to increment by?");
        diffsecond=scan1.nextInt();
        
        int origmonth=month;
        
        year=year+diffyear;
        month=month+diffmonth;
        day=diffday+day;
        hour=diffhour+hour;
        minute=diffminute+minute;
        second=diffsecond+second;
        
        while (second>59)
        {
            minute=minute+1;
            second=second-60;
        }
        while (minute>59)
        {
            hour=hour+1;
            minute=minute-60;
        }
        while (hour>23)
        {
            day=day+1;
            hour=hour-24;
        }
        while (day>31)
        {
            if (day>27)
            {
                if (origmonth==2)
                {
                    day=day-28;
                    origmonth=3;
                }
            }
            if (day>29)
            {
                if (origmonth==4||origmonth==6||origmonth==9||origmonth==11)
                {
                    day=day-30;
                    origmonth=origmonth+1;
                }
            }
            if (day>30)
            {
                if (origmonth==1||origmonth==3||origmonth==7||origmonth==5||origmonth==8||origmonth==10)
                {
                    day=day-31;
                    origmonth=origmonth+1;
                }
                if(origmonth==12)
                {
                    day=day-31;
                    origmonth=1;
                }
            }
        }
        while (month>11)
        {
            year=year+1;
            month=month-12;
        }
        String minute1="";
        String second1="";
        String hour1="";
        if (hour<10)
        {
            hour1="0";
        }
        if (minute<10)
        {
            minute1="0";
        }
        if (second<10)
        {
            second1="0";
        }
        System.out.println("The date after your increment will be "+month+"/"+day+"/"+year);
        System.out.println("The time after your decrement will be "+hour1+hour+":"+minute1+minute+":"+second1+second);
        
    }
    public void any_decrement()
    {
        Scanner scan1= new Scanner(System.in);
        System.out.println("How many years do you want to decrement by?");
        year=year-scan1.nextInt();
        System.out.println("How many months do you want to decrement by?");
        month=month-scan1.nextInt();
        System.out.println("How many days do you want to decrement by?");
        diffday=scan1.nextInt();
        System.out.println("How many hours do you want to decrement by?");
        diffhour=scan1.nextInt();
        System.out.println("How many minutes do you want to decrement by?");
        diffminute=scan1.nextInt();
        System.out.println("How many seconds do you want to decrement by?");
        diffsecond=scan1.nextInt();
        
        int origmonth=month;
        
        year=year-diffyear;
        month=month-diffmonth;
        day=diffday-day;
        hour=diffhour-hour;
        minute=diffminute-minute;
        second=diffsecond-second;
        
        while (second<0)
        {
            minute=minute-1;
            second=second+59;
        }
        while (minute<0)
        {
            hour=hour-1;
            minute=minute+59;
        }
        while (hour<24)
        {
            day=day-1;
            hour=hour+23;
        }
        while (day<0)
        {
            if (origmonth==2)
            {
                day=day+28;
                origmonth=1;
            }

            if (origmonth==4||origmonth==6||origmonth==9||origmonth==11)
            {
                day=day+31;
                origmonth=origmonth-1;
            }

            if (origmonth==3||origmonth==7||origmonth==5||origmonth==12||origmonth==10)
            {
                day=day+30;
                origmonth=origmonth-1;
            }
            if(origmonth==8)
            {
                day=day+31;
                origmonth=7;
            }
            if (origmonth==1)
            {
                day=day+31;
                origmonth=12;
            }
        }
        while (month>0)
        {
            year=year-1;
            month=month+12;
        }
        
        String minute1="";
        String second1="";
        String hour1="";
        if (hour<10)
        {
            hour1="0";
        }
        if (minute<10)
        {
            minute1="0";
        }
        if (second<10)
        {
            second1="0";
        }
        System.out.println("The date after your decrement will be "+month+"/"+day+"/"+year);
        System.out.println("The time after your decrement will be "+hour1+hour+":"+minute1+minute+":"+second1+second);
    }
    public void standard_time()
    {
        if (hour>12)
        {
            String minute1="";
            String second1="";
            String hour1="";
            if (hour<10)
            {
                hour1="0";
            }
            if (minute<10)
            {
                minute1="0";
            }
            if (second<10)
            {
                second1="0";
            }
            hour=hour-12;
            System.out.println("The time is "+hour1+hour+":"+minute1+minute+":"+second1+second+" PM");
        }
        else if (hour==12)
        {
            System.out.println("The time is "+hour+":"+minute+":"+second+" PM");
        }
        else if (hour==0)
        {
            hour=12;
            System.out.println("The time is "+hour+":"+minute+":"+second+" AM");
        }
        else
        {
            String minute1="";
            String second1="";
            String hour1="";
            if (hour<10)
            {
                hour1="0";
            }
            if (minute<10)
            {
                minute1="0";
            }
            if (second<10)
            {
                second1="0";
            }
            System.out.println("The time is "+hour1+hour+":"+minute1+minute+":"+second1+second+" AM");
        }
        
    }
}