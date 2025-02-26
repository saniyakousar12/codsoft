import java.util.*;
public class numberGame{
    public static int getrandN(int min,int max) {
        return ((int)(Math.random()*(max-min+1)+min));
    } 
    public static void main(String args[]){
   Scanner sc = new Scanner(System.in);    
 int chances=10;
 int finals=0;
 boolean playAgain=true;
 System.out.println("welcome to Number Game!!");
 System.out.println("Hey player to have "+ chances+ "to win the game.");
 while(playAgain)
 {
    int randNum=getrandN(1,100);
    boolean guess=false;
    for(int i=0;i<chances;i++){
    System.out.println("chance "+(i+1)+" Enter your guess");
    int user=sc.nextInt();
    if(user==randNum){
        guess=true;
        finals+=1;
        System.out.println("You won it!!");
        break;
    }
    else if(user>randNum){
         System.out.println("Too High");
    }
    else
    {
        System.out.println("Too Low");
    }
}
if(guess==false)
{
    System.out.println("Sorry player. You lost the chances.The Number is "+randNum);
}
System.out.println("Do you want to  play again?(y/n)");
String pa=sc.next();
playAgain=pa.equalsIgnoreCase("y");
}
 double winrate=(double)finals/chances*100;
 System.out.printf("Your winrate is %.2f%%\n",winrate);
System.out.println("Here is your score"+finals);
sc.close();
    }  
}
