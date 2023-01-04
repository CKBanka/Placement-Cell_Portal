import java.util.*;
import java.io.*;
import java.util.Date;
import java.util.Locale;
import java.text.*;
public class Main {
    public int[] breakIntoPieces(String s){
        String[] ars =s.split(" ");
        int l;
        int[] ar =new int[5];
        ar[0]=s.charAt(0)-48;
        if(ars[0].length()==4){
            ar[0]=ar[0]*10+s.charAt(1)-48;
        }
        if(ars[1].equals("January")){
            ar[1]=1;
        }
        else if(ars[1].equals("February")){
            ar[1]=2;
        }
        else if(ars[1].equals("March")){
            ar[1]=3;
        }
        else if(ars[1].equals("April")){
            ar[1]=4;
        }
        else if(ars[1].equals("May")){
            ar[1]=5;
        }
        else if(ars[1].equals("June")){
            ar[1]=6;
        }
        else if(ars[1].equals("July")){
            ar[1]=7;
        }
        else if(ars[1].equals("August")){
            ar[1]=8;
        }
        else if(ars[1].equals("September")){
            ar[1]=9;
        }
        else if(ars[1].equals("October")){
            ar[1]=10;
        }
        else if(ars[1].equals("November")){
            ar[1]=11;
        }
        else if(ars[1].equals("December")){
            ar[1]=12;
        }
        ar[2]=Integer.parseInt(ars[2].substring(0,4));
        String[] t1 =ars[3].split(":");
        ar[3]=Integer.parseInt(t1[0]);
        ar[4]=Integer.parseInt(t1[1]);
        return ar;
    }
    public boolean check(String start,String end){
        int[] ar1 =breakIntoPieces(start);
//        int ar2[]=breakIntoPieces(studentEndDateTime);

        int[] ar3 =breakIntoPieces(end);
//        int ar4[]=breakIntoPieces(compEndDateTime);
        for(int i=0;i<5;i++){
            if(ar1[i]==ar3[i]){
                continue;
            }
            else if(ar1[i]>ar3[i]){
                break;
            }
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        //System.setIn(new FileInputStream(new File("C:\\Users\\HP\\IdeaProjects\\AP_ass1\\src\\input.txt")));
        try{

            Main m=new Main();
            Scanner sc=new Scanner(System.in);
            int op1,op2,op3,op4,op5,op6,op7;
            PlacementCell p=new PlacementCell();
            Student s=new Student();
            ArrayList<Student> regS=new ArrayList<>();
            ArrayList<Comapny> regC=new ArrayList<>();
            Comapny c=new Comapny();
//        Date date = new Date();
//        SimpleDateFormat formatter ;
//        String strDate;
//        formatter = new SimpleDateFormat("dd MMMM yyyy, HH:mm a");
//        strDate = formatter.format(date);
            while(true){
                System.out.println("1)  Enter the Application");
                System.out.println("2) Exit the Application");
                op1=sc.nextInt();
                if(op1==2){
                    System.out.println("Thank you for using Future Builder");
                    break;
                }
                else if(op1==1){
                    while(true){
                        System.out.println("Choose the mode you want to enter in : ");
                        System.out.println("1) Enter as Student Mode");
                        System.out.println("2) Enter as Company Mode");
                        System.out.println("3) Enter as Placement Cell Mode");
                        System.out.println("4) Return to Main Application");
                        op2=sc.nextInt();
                        if(op2==1){
                            while(true){
                                System.out.println("1) Enter as a Student(Give Student Name, and Roll No.)");
                                System.out.println("2) Add Students");
                                System.out.println("3) Back");
                                op5=sc.nextInt();
                                if(op5==1){
                                    sc.nextLine();
                                    String[] info =sc.nextLine().split(" ");
                                    int r=Integer.parseInt(info[info.length-1].trim());
                                    for (Student reg : regS) {
                                        if (reg.getRoll() == r) {
                                            s = reg;
                                        }
                                    }
                                    while(true){
                                        System.out.println("Welcome "+s.getName());
                                        System.out.println("1) Register for placement drive");
                                        System.out.println("2) Register for a Company");
                                        System.out.println("3) Get all available Companies");
                                        System.out.println("4) Get current status");
                                        System.out.println("5) Update Cgpa");
                                        System.out.println("6) Accept/Reject Offer");
                                        System.out.println("7) Reject all Offer");
                                        System.out.println("8) Back");
                                        op3=sc.nextInt();
                                        if(op3==1){
                                            sc.nextLine();
                                            System.out.println("Enter The Registration Time");
                                            String RegTime=sc.nextLine();
                                            if(m.check(p.getStudentEndDateTime(),RegTime)){
                                                p.appliedStudent.add(s);
//                                            p.appliedCompanies.add(c);
                                                System.out.println("You have been successfully registered for placements IIITD");
//                                            System.out.println("Registered Successfully");
                                            }
                                            else{
                                                System.out.println("You are Late for Registration");
                                            }
//                                        String checkTime=sc.nextLine();
                                            s.printDetailsStudents();
                                        }
                                        else if(op3==2){
                                            int l=p.appliedCompanies.size();
                                            System.out.println("Enter the option to apply for that company");
                                            for(int i=0;i<l;i++){
                                                System.out.println((i+1)+" "+p.appliedCompanies.get(i).getNameCom());
                                            }
                                            op4= sc.nextInt();
                                            s.registerForC(p.appliedCompanies.get(op4-1));
                                        }
                                        else if(op3==3){
                                            int l=p.appliedCompanies.size();
//                                        System.out.println("Enter the option to apply for that company");
                                            for(int i=0;i<l;i++){
                                                System.out.println((i+1)+" "+p.appliedCompanies.get(i).getNameCom());
                                            }
                                        }
                                        else if(op3==4){
                                            s.currentState();
                                        }
                                        else if (op3==5){
                                            System.out.println("Enter the new cgpa");
                                            s.newCgpa=sc.nextDouble();
                                            p.cgpaReq.add(s);
                                            System.out.println("Your Request has been Noted by Placement Office");
                                        }
                                        else if(op3==6){
                                            for(int i=0;i<s.offers.size();i++){
                                                System.out.println((i+1)+" "+s.offers.get(i).getNameCom());
                                            }
                                            System.out.println("Enter the option to be accepted");
                                            op5=sc.nextInt();
                                            s.presentCompany=s.offers.get(op5-1);
                                            s.placed=1;
                                            s.ctcOffered=s.offers.get(op5-1).getCtc();
                                            System.out.println("This offer has been accepted and rest all the offers has been rejected");
                                        }
                                        else if(op3==7){
                                            for(int i=0;i<s.offers.size();i++){
                                                System.out.println((i+1)+" "+s.offers.get(i).getNameCom());
                                            }
                                            System.out.println("Do You want to reject all the offers");
                                            System.out.println("Press 1 to confirm 2 to go back");
                                            op5=sc.nextInt();
                                            if(op5==1){
                                                s.presentCompany=null;
                                                s.placed=-1;
                                                System.out.println("You have been debarred from campus placements");
                                            }
                                            else{
                                                System.out.println("Going back");
                                            }

                                        }
                                        else if(op3==8){
                                            break;
                                        }

                                    }
                                }
                                else if(op5==2){
                                    System.out.println("Enter Number of students to add");
                                    op6=sc.nextInt();
                                    while(--op6>=0){
                                        s=s.registerForPlaceC();
                                        regS.add(s);
                                        System.out.println("Registered Successfully!");
//                                    System.out.println("Date Format with dd MMMM yyyy : "+strDate);
                                        System.out.println();
                                    }
                                }
                                else if(op5==3){
                                    break;
                                }
                                else{
                                    System.out.println("Invalid Input");
                                }
                            }
                        }
                        else if(op2==2){
                            System.out.println("Choose the company query to perform :  :");
                            System.out.println("1) Add Company and Details");
                            System.out.println("2) Choose Company");
                            System.out.println("3) Get Available Companies");
                            System.out.println("4) Back");
                            op5=sc.nextInt();
                            if(op5==1){
                                c.registerComp();
//                          p.appliedCompanies.add(c);
                                regC.add(c);
                            }
                            else if(op5==2) {
                                System.out.println("Enter The option number  to choose that company");
                                for (int i = 0; i < regC.size(); i++) {
                                    System.out.println((i + 1) + " " + regC.get(i).getNameCom());
                                }
                                op6 = sc.nextInt();
                                c = regC.get(op6 - 1);
                                while(true) {
                                    System.out.println("Welcome " + c.getNameCom());
                                    System.out.println("1) Update Role");
                                    System.out.println("2) Update Package");
                                    System.out.println("3) Update CGPA criteria");
                                    System.out.println("4) Register To Institute Drive");
                                    System.out.println("5) Back");
                                    op7 = sc.nextInt();
                                    if(op7==1){
                                        System.out.println("Enter the New Role");
                                        String r=sc.next();
                                        c.updateRole(r);
                                    }
                                    else if(op7==2){
                                        System.out.println("Enter the New Package");
                                        Double np=sc.nextDouble();
                                        c.updatePackage(np);
                                    }
                                    else if(op7==3){
                                        System.out.println("Enter the Required cgpa");
                                        Double np=sc.nextDouble();
                                        c.updateCgpa(np);
                                    }
                                    else if(op7 ==4){
                                        System.out.println("Enter The time of Registration");
                                        sc.nextLine();
                                        String RegTime=sc.nextLine();
                                        if(m.check(p.getCompEndDateTime(),RegTime)){
                                            p.appliedCompanies.add(c);
                                            System.out.println("Registered Successfully");
                                        }
                                        else{
                                            System.out.println("You are Late for Registration");
                                        }
                                    }
                                    else if(op7==5){
                                        break;
                                    }
                                    else{
                                        System.out.println("invalid Input");
                                    }
                                }
                            }
                            else if(op5==3){
                                System.out.println("Available companies are as follows :");
                                for (int i = 0; i < regC.size(); i++) {
                                    System.out.println((i + 1) + " " + regC.get(i).getNameCom());
                                }
                            }
                            else if(op5==4){
                                break;
                            }
                            else{
                                System.out.println("Invalid Input");
                            }
                        }
                        else if(op2==3){
                            System.out.println("Welcome to IIITD placement cell :  :");
                            System.out.println("1) Open Student Registrations");
                            System.out.println("2) Open Company Registrations");
                            System.out.println("3) Get Number of Student Registrations");
                            System.out.println("4) Get Number of Company Registrations");
                            System.out.println("5) Get Number of Offered/Unoffered/Blocked Students");
                            System.out.println("6) Get Student Details");
                            System.out.println("7) Get Company Details");
                            System.out.println("8) Get Average Package");
                            System.out.println("9) Get Company Process Results");
                            System.out.println("10 Update CGPA requests");
                            System.out.println("11) Back");
                            op3=sc.nextInt();
                            if(op3==1){
                                p.openStudentRegistration();
                            }
                            else if(op3==2){
                                p.openCompanyRegistration();
                            }
                            else if(op3==3){
                                System.out.println("Number of registered Students is "+p.appliedStudent.size());
                            }
                            else if(op3==4){
                                System.out.println("Number of registered Companies is "+p.appliedCompanies.size());
                            }
                            else if(op3==5){
                                p.placementStatus();
                            }
                            else if(op3==6){
                                System.out.println("Enter The roll Number");
                                int r=sc.nextInt();
                                for (Student reg : regS) {
                                    if (reg.getRoll() == r) {
                                        reg.printDetailsStudents();
                                        break;
                                    }
                                }
                            }
                            else if(op3==7){
                                System.out.println("Enter The Name");
                                String nc=sc.next();
                                for (Comapny comapny : regC) {
                                    if (comapny.getNameCom().equals(nc)) {
                                        comapny.printDetails();
                                        break;
                                    }
                                }
                            }
                            else if(op3==8){
                                p.printAveragePackage();
                            }
                            else if(op3==9){
                                for(int i=0;i<p.appliedCompanies.size();i++){
                                    System.out.println(p.appliedCompanies.get(i).getNameCom());
                                    System.out.println();
                                    p.getCompanyProcessDetails(c);
                                }
                            }
                            else if(op3==10){
                                System.out.println("1. To confirm all cgpa requests");
                                System.out.println("2. Exit");
                                int reqNum=sc.nextInt();
                                if(reqNum==1){
                                    for(int i=0;i<p.cgpaReq.size();i++){
                                        p.cgpaReq.get(i).setCgpa();
                                    }
                                    System.out.println("Request has been executed");
                                }
                            }
                            else if(op3==11){
                                break;
                            }
                            else{
                                System.out.println("Invalid Input");
                            }
                        }
                        else if(op2==4){
                            break;
                        }
                        else{
                            System.out.println("Invalid Input");
                        }
                    }

                }
                else{
                    System.out.println("Invalid Option");
                }

            }
        }
        catch (Exception e){
            System.out.println("Some error occurred , Please run again");
        }
    }
}