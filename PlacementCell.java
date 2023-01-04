import java.util.*;
public class PlacementCell {
    Scanner sc=new Scanner(System.in);
    ArrayList<Student> cgpaReq=new ArrayList<>();
    private String studentEndDateTime;
    private String studentStartDateTime;
    private String compEndDateTime;

    public String getStudentEndDateTime() {
        return studentEndDateTime;
    }

    public String getCompEndDateTime() {
        return compEndDateTime;
    }

    ArrayList<Student> appliedStudent=new ArrayList<Student>();
    ArrayList<Comapny> appliedCompanies=new ArrayList<Comapny>();
    public void registerStudent(Student s){
        appliedStudent.add(s);
    }
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
    public boolean check(){
        int[] ar1 =breakIntoPieces(studentStartDateTime);
//        int ar2[]=breakIntoPieces(studentEndDateTime);
        int[] ar3 =breakIntoPieces(compEndDateTime);
//        int ar4[]=breakIntoPieces(compEndDateTime);
        for(int i=0;i<5;i++){
//            System.out.println(ar1[i]+" "+ar3[i]);
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
    public void openStudentRegistration(){
        System.out.println("Enter the Start Date-Time for Registration\n");
        System.out.println("Example Format-\"18th September 2022, 17:00 PM\"");
        studentStartDateTime=sc.nextLine();
        if(!check()){
            System.out.println("registrations for students can’t open before company registrations end.");
            studentStartDateTime="";
            return;
        }
        System.out.println("Enter the End Date-Time for Registration");
        System.out.println("Example Format-\"18th September 2022, 17:00 PM\"");
        studentEndDateTime = sc.nextLine();
        System.out.println("Students can now register for placements from "+studentStartDateTime+" to "+ studentEndDateTime);
    }
    public void openCompanyRegistration(){
        System.out.println("Enter the Start Date-Time for Registration\n");
        System.out.println("Example Format-\"18th September 2022, 17:00 PM\"");
        String compStartDateTime = sc.nextLine();
        System.out.println("Enter the End Date-Time for Registration");
        System.out.println("Example Format-\"18th September 2022, 17:00 PM\"");
        compEndDateTime=sc.nextLine();
        System.out.println("Companies can now register for placements from "+ compStartDateTime +" to "+compEndDateTime);
    }
    public  void studentsRegistered(){
        System.out.println("Number of Students Applied for placements are "+appliedStudent.size());
    }
    public void companiesRegistered(){
        System.out.println("Number of Companies Registered for placements is "+appliedCompanies);
    }
    public void placementStatus(){
        int l=appliedStudent.size();
        int p=0,b=0,up=0;     //placed=p    unplaced=up       blocked=b
        int k;
        for (Student student : appliedStudent) {
            k = student.placed;
            if (k == 1) {
                p++;
                student.printDetailsStudents();
            } else if (k == 0) {
                up++;
            } else {
                b++;
            }
        }
        System.out.println("Placed Students "+p);
        System.out.println("Unplaced Students "+up);
        System.out.println("Blocked Students "+b);
    }
    public void placementStatusStudent(String n,int r){
        int l=appliedStudent.size();
        int k;
        for (Student student : appliedStudent) {
            if (student.getRoll() == r) {
                student.printStudentPlacementDetails(appliedCompanies);
                break;
            }
        }
    }
    public void companyDetails(String n){
        int l=appliedCompanies.size();
        int k;
        for (Comapny comp : appliedCompanies) {
            if (comp.getNameCom().equals(n)) {
                comp.printDetails();
                comp.getSelectedCandidates();
                break;
            }
        }

    }
    public void printAveragePackage(){
        int c=0;
        double avgCtc=0;
        for (Student student : appliedStudent) {
            if(student.placed==1){
                avgCtc+=student.ctcOffered;
                c++;
            }
        }
        if(c>0){
            avgCtc/=c;
        }
        System.out.println("Average Package is "+avgCtc);
    }
    public void getCompanyProcessDetails(Comapny c){
        for (Student student : appliedStudent) {
            if (student.isEligible(c)) {
                c.selected.add(student);
            }
        }
        int l=c.selected.size();
        if(l>0){
            System.out.println("The Students Selected are ");
            for(int i=0;i<l;i++){
                System.out.println((i+1));
                c.selected.get(i).printDetailsStudents();
                c.selected.get(i).offers.add(c);
            }
        }
        else{
            System.out.println("No Student Selected");
        }
    }
}
