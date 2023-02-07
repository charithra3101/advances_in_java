/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mcacnj
 */ 
import java.io.*;
import java.sql.*;

public class Sample {
   Sample s=new Sample();
   static Connection con=null;
   static Statement st=null;
   static ResultSet rs = null;
   static void DbConnection()
   {
       try{
           System.out.println("Inside try");
           Class.forName("org.apache.derby.jdbc.ClientDriver");
           System.out.println("inside try after class,forname");
           con=DriverManager.getConnection("jdbc:derby://localhost:1527/students","user1","123");
           st = con.createStatement();
           System.out.println(con);
       }
       
       catch(ClassNotFoundException e1)
       {
           System.out.println("error"+e1.getMessage());
       }
       catch(SQLException e2)
       {
           System.out.println(e2.getMessage());
       }
       
         
       }
   

static void InsertRecord() throws IOException,SQLException
{
System.out.println("comes");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter USN");
String s1=br.readLine();
System.out.println("Enter Name");
String s2=br.readLine();
System.out.println("Enter Sem");
int s3=Integer.parseInt(br.readLine());
System.out.println("Enter age");
int s4=Integer.parseInt(br.readLine());
System.out.println(s2 + " " + s2 + " " + s3 + s4);
st.executeUpdate("insert into user1.STUD values('"+s1+"','"+s2+"',"+s3+","+s4+")");

//while(rs.next()){
//    System.out.println(rs.getString(1));
//}
System.out.println("record inserted");
}

static void DeleteRecord() throws IOException,SQLException{

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
Sample.ViewRecord();
System.out.println("Enter USN to delete");
String s1=br.readLine();
int a=st.executeUpdate("delete from USER1.STUD where USN='"+s1+"'");
if(a>0)
    System.out.println("Record Deleted");
else
   System.out.println("USN NOT FOUND");
}

static void UpdateRecord()
{
    try
    {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      Sample.ViewRecord();
      System.out.println("Enter USN update");
      String s1=br.readLine();
      System.out.println("Enter Name update");
      String s2=br.readLine();
      System.out.println("Enter sem update");
      int  s3=Integer.parseInt(br.readLine());
       System.out.println("Enter age update");
      int s4=Integer.parseInt(br.readLine());
      int executeUpdate=st.executeUpdate("update USER1.STUD SET NAME='"+s2+"',SEM="+s3+",AGE="+s4+" where USN='"+s1+"'");
      if(executeUpdate>0)
        System.out.println("Record upadted");
      else
       System.out.println("Record not upadted");
    }
    catch(SQLException e)
    {
        System.out.println(e.getMessage());
    }
    catch(IOException e)
    {
        System.out.println(e.getMessage());
    }
}

static void ViewRecord() throws IOException,SQLException{
    rs=st.executeQuery("SELECT * FROM USER1.STUD");
    Boolean t=rs.next();
    System.out.println("Coming" + t);
    if(!t)
        System.out.println("No records");
    else
    {
       System.out.println("USN NAME SEMESTER AGE");
       do
       {
           System.out.println(""+rs.getString(1)+"---"+""+rs.getString(2)+"---"+""+rs.getString(3)+"---"+""+rs.getString(4));
           
       } while(rs.next());
    }
}

public static void main(String[] args)
{
    try
    {
        DbConnection();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            System.out.println("1.Insert Record");
            System.out.println("2.Delete Record");
            System.out.println("3.View Record");
            System.out.println("4.Update Record");
            System.out.println("5.Exit");
            System.out.println("6.Enter your choice");
            int ch=Integer.parseInt(br.readLine());
            switch(ch) {
                case 1:InsertRecord();
                        break;
                case 2:DeleteRecord();
                break;
                case 3:
                    ViewRecord();
                    break;
                case 4:
                    UpdateRecord();
                    break;
                case 5:
                    System.exit(0);
                default:break;
            }
        }
    } catch(Exception e) {
        e.getMessage();
    }
}
}


