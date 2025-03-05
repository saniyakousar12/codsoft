import java.util.Scanner6;
public class studentGradecalcu {
    public static void main(String args[])
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Student Grade Calculator");
        System.out.println("Enter the no of Subjects");
        int ns = s.nextInt();
        int total=0;
        for(int i=0;i<ns;i++)
        {
            System.out.println("Enter marks obtained in "+i+": ");
            int marks=s.nextInt();
            total+=marks;
        }
    double averp=(double)total/ns;
    char grade;
    if(averp>=90)
    {
        grade='o';
    }
    else if(averp>=80)
    {
        grade='A';
    }
    else if(averp>=70)
    {
        grade='B';
    }
    else if(averp>=60)
    {
        grade='C';
    }
    else if(averp>=50)
    {
        grade='D';
    }
    else if(averp>=40)
    {
        grade='E';
    }
    else{
        grade='F';
    }
    System.out.println("Total marks scored is "+total);
    System.out.println("Average percentage Gained is "+averp+"%");
    System.out.println("Grade "+grade);
    }
}
