import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.Exception;


public final class FileFactor{

    public FileFactor() {

    }

    public static ArrayList<Student> readFile(final String p) {

        Student student = new Student();
        ArrayList<Student> listStudent = new ArrayList<Student>();

        try {
            
            FileInputStream fileInputStream = new FileInputStream(p);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {

                String[] arr = line.split(",");
                if (arr.length == Constants.NumberOfFields) {
					
                    student = new Student();

                    student.setID(Integer.parseInt(arr[Constants.StudentIdPosition]));
                    student.setName(arr[Constants.NamePosition]);
                    student.setMarks(Float.parseFloat(arr[Constants.MarksPosition]));
                    student.setMobileNo(arr[Constants.MobileNoPosition]);
                    student.setAddress(arr[Constants.AddressPosition]);
                    student.setDescription(arr[Constants.StuDescriptionPosition]);

                    listStudent.add(student);
                }

                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            inputStreamReader.close();
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Sorry, an error occured!!!");
            listStudent.clear();
        }

        return listStudent;
    }

    public static Boolean writeFile(final ArrayList<Student> list,
            final String p) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(p);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(
                    fileOutputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(
                    outputStreamWriter);

            
            bufferedWriter.write(Constants.FileHeader);
            bufferedWriter.newLine();

            
            for (Student student : list) {
                String data = student.toStringSaveFile();
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }

           
            bufferedWriter.close();
            outputStreamWriter.close();
            fileOutputStream.close();

            return true;
        } catch (Exception e) {
            System.out.println("Sorry, an error occured");
        }

        
        return false;
    }

    
    public static ArrayList<Student> readFileBinary(final String p) {
        Student student = new Student();
        ArrayList<Student> listStudent = new ArrayList<Student>();

        try {
           
            DataInputStream in = new DataInputStream(
                    new FileInputStream(new File(p)));

            
            int size = in.readInt();

            
            for (int i = 0; i < size; i++) {
                student = new Student();
                student.setID(in.readInt());
                student.setName(in.readUTF());
                student.setMarks(in.readFloat());
                student.setMobileNo(in.readUTF());
                student.setAddress(in.readUTF());
                student.setDescription(in.readUTF());

                listStudent.add(student);
            }

            in.close();

        } catch (Exception e) {
            
            System.out.println("Sorry, an error occured");
            listStudent.clear();
        }

        
        return listStudent;
    }

    
    public static Boolean writeFileBinary(final ArrayList<Student> list,
            final String p) {
        try {
            
            DataOutputStream on = new DataOutputStream(
                    new FileOutputStream(new File(p)));

            
            on.writeInt(list.size());

            
            for (Student student : list) {
                on.writeInt(student.getID());
                on.writeUTF(student.getName());
                on.writeFloat(student.getMarks());
                on.writeUTF(student.getMobileNo());
                on.writeUTF(student.getAddress());
                on.writeUTF(student.getDescription());
            }

           
            on.flush();
            on.close();

            return true;
        } catch (Exception e) {
            
            System.out.println("Sorry, an error occured");
        }

        
        return false;
    }

}