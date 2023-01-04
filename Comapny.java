import java.util.ArrayList;
import java.util.Scanner;

public class Comapny {
    private String nameCom;
    private String role;
    private double ctc;
    private double reqCgpa;
    private String dateTime;
    ArrayList<Student> selected=new ArrayList<>();
    public double getReqCgpa(){
        return reqCgpa;
    }
    public void registerComp(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name of the company");
        nameCom=sc.nextLine();
        System.out.println("Enter the Role offered");
        role=sc.nextLine();
        System.out.println("Package Offered");
        ctc=sc.nextDouble();
        System.out.println("Enter The Required Cgpa");
        reqCgpa=sc.nextDouble();
    }
    public void updateRole(String r){
        role=r;
    }
    public void updatePackage(Double r){
        ctc=r;
    }
    public void updateCgpa(Double r){
        reqCgpa=r;
    }
    public double getCtc(){
        return ctc;
    }
    public String getNameCom(){
        return nameCom;
    }
    public void updateCriteria(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Choose The option to be updated");
        System.out.println("1. Role");
        System.out.println("2. CTC");
        System.out.println("3. Required CGPA");
        int op=sc.nextInt();
        if(op==1){
            sc.nextLine();
            role= sc.nextLine();
        }
        else if(op==2){
            ctc= sc.nextDouble();
        }
        else if(op==3){
            reqCgpa= sc.nextDouble();
        }
        else{
            System.out.println("Invalid Input");
        }
    }
    public void getSelectedCandidates(){
        int l=selected.size();
        System.out.println("The selected Candidates are ");
        for (Student student : selected) {
            student.printDetailsStudents();
        }
    }

    public void printDetails() {
        System.out.println("Name of Company "+nameCom);
        System.out.println("Role Offered "+role);
        System.out.println("Ctc Offered "+ctc);
        System.out.println("Cgpa Required "+reqCgpa);
    }
}
