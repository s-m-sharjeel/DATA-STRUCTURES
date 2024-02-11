package Labs.Lab10;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Driver {

    public static void main(String[] args) {

        // Task 1:

        HashT<Student> table = new HashT<>(20);

        Student std1 = new Student("roohallah", 27082);
        Student std2 = new Student("sharjeel", 26932);
        Student std3 = new Student("ali", 24532);
        Student std4 = new Student("ahmed", 17932);
        Student std5 = new Student("muhammmad", 26312);
        Student std6 = new Student("deebaj", 27012);
        Student std7 = new Student("saad", 25873);
        Student std8 = new Student("hamza", 17843);
        Student std9 = new Student("daniyal", 11111);

        table.insert(std1);
        table.insert(std2);
        table.insert(std3);
        table.insert(std4);
        table.insert(std5);
        table.insert(std6);
        table.insert(std7);
        table.insert(std8);
        table.insert(std9);

        table.displayTable();

        // Task 2:

        String filePath = "./src/Labs/Lab10/Dictionary.csv";

        // for linear probing:

        HashingOpenAdd HLinear=new HashingOpenAdd(35000, true);

        try{
            FileInputStream fstream = new FileInputStream(filePath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null){
                String[] word=strLine.split(",");
                HLinear.insert(word[0]);
            }
            in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(HLinear.displayTable());
        System.out.println("total collisions for linear: " + HLinear.getTotalCollisions());

        // for quadratic probing:

        HashingOpenAdd HQuadratic=new HashingOpenAdd(35000, false);

        try{
            FileInputStream fstream = new FileInputStream(filePath);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null){
                String[] word=strLine.split(",");
                HQuadratic.insert(word[0]);
            }
            in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(HQuadratic.displayTable());
        System.out.println("total collisions for quadratic: " + HQuadratic.getTotalCollisions());


    }

}
