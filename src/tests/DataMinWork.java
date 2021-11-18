package tests;

import java.io.*;
import java.util.Vector;

public class DataMinWork {
    public static Vector<String> getFile() {
        File file = new File("src/tests/Titanic.csv");
        Vector<String> out = new Vector<>();
        String readString = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((readString=reader.readLine())!=null) {

               out.add(readString);

            }
            reader.close();

        } catch (FileNotFoundException fnfe) {

            System.out.println("文件不存在" + fnfe);

        } catch (IOException ioe) {

            System.out.println("I/O 错误: " + ioe);

        }
        return out;
    }
    public static float support(Vector<String> data){
        int totalNum = data.size()-1;
//        String classNum = "3rd";
//        String sex = "Male";
//        String age = "Adult";
//        String survival = "No";//0.17582917
//        String classNum = "Crew";
//        String sex = "Male";
//        String age = "Adult";
//        String survival = "Yes";//0.087233074
//        String classNum = "Crew";
//        String sex = "Male";
//        String age = "Adult";
//        String survival = "No";//0.3044071
        String classNum = "2nd";
        String sex = "Male";
        String age = "Adult";
        String survival = "No";//0.069968194
        int num = 0;
        for(String str:data){
            String[] manData = str.split(",");
            if(classNum.equals(manData[1])&&sex.equals(manData[2])&&age.equals(manData[3])&&survival.equals(manData[4])){
                ++num;
            }
        }
        return (float) (num*1.0/totalNum);
    }
    public static float support2(Vector<String> data,String s1,int index1,String s2,int index2,String s3,int index3,String s4,int index4){
        int totalNum = data.size()-1;
        int num = 0;
        for(String str:data){
            String[] manData = str.split(",");
            //System.out.println(manData[3]);
            if(s1.equals(manData[index1])&&s2.equals(manData[index2])&&s3.equals(manData[index3])&&s4.equals(manData[index4])){
                ++num;
            }
        }
        System.out.println(num);
        return (float) (num*1.0/totalNum);
    }
    static int  totalSurval =0;
    public static float supportLimted(Vector<String> data){
        totalSurval =0;
        String classNum = "1st";
        String sex = "Female";
        String age = "Adult";//0.19690576
//        String classNum = "2nd";
//        String sex = "Female";
//        String age = "Adult";//0.11251758
//        String classNum = "3rd";
//        String sex = "Male";
//        String age = "Adult";//0.10548523
//        String classNum = "Crew";
//        String sex = "Male";
//        String age = "Adult";//0.27004218

        int num = 0;
        for(String str:data){
            String[] manData = str.split(",");
            if(manData[4].equals("Yes")){
                ++totalSurval;
            }
            if(classNum.equals(manData[1])&&sex.equals(manData[2])&&age.equals(manData[3])&&manData[4].equals("Yes")){
                ++num;
            }
        }
        return (float) (num*1.0/totalSurval);
    }
    public static float lift(Vector<String> data,String s1,int index,String s2,int index2,String s3,int index3){
        int X = 0;
        int Y = 0;
        int YandX = 0;
        for(String str:data){
            String[] manData = str.split(",");
            boolean flag1 = false;
            boolean flag2 = false;
            if(s1.equals(manData[index])&&s2.equals(manData[index2])){
                flag1 = true;
                ++X;
            }
            if(s3.equals(manData[index3])){
                flag2 = true;
                ++Y;
            }
            if(flag1&&flag2){
                ++YandX;
            }
        }
        System.out.println(X+" "+Y+" "+ YandX);
        return (float)(YandX*1.0/X/Y);
    }
    public static float lift(Vector<String> data,String s1,int index,String s2,int index2,String s3,int index3,String s4,int index4){
        int X = 0;
        int Y = 0;
        int YandX = 0;
        for(String str:data){
            String[] manData = str.split(",");
            boolean flag1 = false;
            boolean flag2 = false;
            if(s1.equals(manData[index])&&s2.equals(manData[index2])&&s3.equals(manData[index3])){
                flag1 = true;
                ++X;
            }
            if(s4.equals(manData[index4])){
                flag2 = true;
                ++Y;
            }
            if(flag1&&flag2){
                ++YandX;
            }
        }
        System.out.println(X+" "+Y+" "+ YandX);
        return (float)(YandX*1.0/X/Y);
    }
    public static float confident(Vector<String> data,String s1,int index1,String s2,int index2){
        int totals1 = 0;
        int totals2 = 0;
        for(String sr:data){
            String[] manData = sr.split(",");
            if(s1.equals(manData[index1])){
                ++totals1;
                if(s2.equals(manData[index2])){
                    ++totals2;
                }
            }

        }
        return (float) ((float)totals2*1.0/totals1);
    }
    public static float confident(Vector<String> data,String s1,int index1,String s2,int index2,String s3,int index3){
        int totals1 = 0;
        int totals2 = 0;
        for(String sr:data){
            String[] manData = sr.split(",");
            if(s1.equals(manData[index1])&&s2.equals(manData[index2])){
                ++totals1;
                if(s3.equals(manData[index3])){
                    ++totals2;
                }
            }

        }
        return (float) ((float)totals2*1.0/totals1);
    }
    public static float confident(Vector<String> data,String s1,int index1,String s2,int index2,String s3,int index3,String s4,int index4){
        int totals1 = 0;
        int totals2 = 0;
        for(String sr:data){
            String[] manData = sr.split(",");
            if(s1.equals(manData[index1])&&s2.equals(manData[index2])&&s3.equals(manData[index3])){
                ++totals1;
                if(s4.equals(manData[index4])){
                    ++totals2;
                }
            }

        }
        return (float) ((float)totals2*1.0/totals1);
    }
    public static float lift(Vector<String> data,String s1,int index,String s2,int index2){
        int X = 0;
        int Y = 0;
        int YandX = 0;
        for(String str:data){
            String[] manData = str.split(",");
            boolean flag1 = false;
            boolean flag2 = false;
            if(s1.equals(manData[index])){
                flag1 = true;
                ++X;
            }
            if(s2.equals(manData[index2])){
                flag2 = true;
                ++Y;
            }
            if(flag1&&flag2){
                ++YandX;
            }
        }
        System.out.println(X+" "+Y+" "+ YandX);
        return (float)(YandX*1.0/X/Y);
    }
    public static void main(String[] args) {
        Vector<String> vector;
       vector = getFile();
        //"Crew",1,"No",4,"Male",2 5.7512557E-4
        //"3rd",1,"No",4,"Adult",3 4.309346E-4
        //"2nd",1,"Adult",3 4.3775787E-4
        //"2nd",1,"Male",2,"Adult",3,"No",4 6.1521254E-4
       System.out.println(confident(vector,"Male",2,"Adult",3,"2nd",1,"Yes",4));

    }
}
