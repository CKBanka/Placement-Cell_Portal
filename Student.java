import java.util.*;

public class Student {
    private String name;
    private int roll;
    private String branch;
    private double cgpa;
    public double newCgpa;
    private ArrayList<Comapny> applied = new ArrayList<Comapny>();
    private int noOfCompApplied;  // no of companies applied by the student at a particular time
    int placed; // 1 depicting placed and 0 depicting unplaced , -1 depicting debarred
    double ctcOffered;
//    private ArrayList<Comapny> allComps = new ArrayList<Comapny>();

    ArrayList<Comapny> offers = new ArrayList<Comapny>();
    Comapny presentCompany;
    public Student(){
        name="";
        roll=0;
        branch="";
        cgpa=0;
    }
    public Student(String n,int r,String b,double c){
        name=n;
        roll=r;
        branch=b;
        cgpa=c;
    }
    public void setCgpa(){
        cgpa=newCgpa;
    }
    public int getRoll(){
        return roll;
    }
    public String getName(){
        return name;
    }
    public Student  registerForPlaceC(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name : ");
        String n=sc.nextLine();
        System.out.println("Enter Roll Number : ");
        int r=sc.nextInt();
        System.out.println("Enter CGPA : ");
        double c=sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the branch : ");
        String b=sc.nextLine();
        placed=0;
        Student s=new Student(n,r,b,c);
        return s;

    }
    public void registerForC(Comapny c){
        if(cgpa>c.getReqCgpa()){
            if(placed==1 && ctcOffered*3<=c.getCtc()){
                applied.add(c);
            }
            else{
                applied.add(c);
            }
        }
    }
    public boolean isEligible(Comapny c){
        if(cgpa>c.getReqCgpa()){
            if(placed==1 && ctcOffered*3<=c.getCtc()){
                return true;
            }
            else{
                return true;
            }
        }
        return false;
    }
    public void printDetailsStudents(){
        System.out.println("Student Name "+name);
        System.out.println("Student Roll Number "+roll);
        System.out.println("Student Branch "+branch);
        System.out.println("Student CGPA "+cgpa);
        if(placed==1){
            System.out.println("Present company "+presentCompany.getNameCom());
        }
//        System.out.println("Student CGPA "+cgpa);
    }
    public void printStudentPlacementDetails(ArrayList<Comapny> allComps){
        int l=allComps.size();
        if(placed==1){
            for (Comapny allComp : allComps) {
                if (allComp == presentCompany) {
                    System.out.println(presentCompany + " Applied " + "Accepted");
                } else if (offers.contains(allComp)) {
                    System.out.println(presentCompany + " Applied " + "Rejected");
                } else {
                    System.out.println(presentCompany + " Not Applied " + "------");
                }
            }
        }
        else if(placed==0){
            for (Comapny allComp : allComps) {
                if (offers.contains(allComp)) {
                    System.out.println(presentCompany + " Applied " + "Rejected");
                } else {
                    System.out.println(presentCompany + " Not Applied " + "------");
                }
            }
        }
        else{
            for (Comapny allComp : allComps) {
                if (offers.contains(allComp)) {
                    System.out.println(presentCompany + " Applied " + "Rejected");
                } else {
                    System.out.println(presentCompany + " Not Applied " + "------");
                }
            }
        }
    }
    public void getAllAvailableCom(ArrayList<Comapny> c){
        for (Comapny comapny : c) {
            if (isEligible(comapny)) {
                System.out.println(comapny.getNameCom());
            }
        }
    }
    public void currentStatus(){
        if(placed==1){
            System.out.println(presentCompany);
        }
        else if(placed==0){
            System.out.println("No Current Offers");
        }
        else{
            System.out.println("You are Debarred from campus placement");
        }
    }

    public void updateCgpa(double c){
        cgpa=c;
    }
    public void acceptReject(Comapny c){
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<offers.size();i++){
            System.out.println("You have an offer from "+(i+1)+" "+c.getNameCom());
        }
        System.out.println("Enter the option number to accept that offer and reject all the other offers ");
        System.out.println("Enter 0 to reject all the offers, You will be debarred from the placement after this");
        int n=sc.nextInt();
        if(n!=0 && n<=offers.size()){
            placed =1;
            presentCompany=offers.get(n-1);

        }
        else if(n==0){
            if(placed==0){
                System.out.println("You have been debarred from the Campus Placements");
                placed=-1;
            }
        }
    }

    public void currentState() {
        if(offers.size()>0){
            for(int i=0;i<offers.size();i++){
                System.out.println(offers.get(i).getNameCom());
            }
        }
        else{
            System.out.println("No Current Offers");
        }
    }
}
