import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;

public class Start {
    public static void main(String[] args)throws IOException {
        System.out.println("Welcome to Student Management App");
        while (true){
            BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Press 1 to ADD Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Student");
            System.out.println("Press 4 to exit Student");
            int c=Integer.parseInt(br.readLine());
            if(c==1){
                //add student...
                System.out.println("Enter user Name:");
                String name = br.readLine();

                System.out.println("Enter user phone: ");
                String phone =br.readLine();

                System.out.println("Enter user city");
                String city = br.readLine();

                //create student object to store student

                Student st = new Student(name,phone,city);
               boolean ans= StudentDao.insertStudentToDB(st);
               if(ans){
                   System.out.println("Student is added successfully...");
               }
               else{
                   System.out.println("something went wrong try again...");
               }
                System.out.println(st);

            }else if(c==2){
                //delete student...
                System.out.println("enter student id to delete");
                int userId = Integer.parseInt(br.readLine());
               boolean f= StudentDao.deleteStudent(userId);
               if(f){
                   System.out.println("Deleted...");
               }
               else{
                   System.out.println("something went wrong try again...");
               }
            }else if(c==3){
                //display student..
                StudentDao.showAllStudents();

            }else if (c==4){
                //exit...
                break;
            }else{

            }
        }
        System.out.println("Thank you for using my application");
        System.out.println("See you Soon");
    }
}
