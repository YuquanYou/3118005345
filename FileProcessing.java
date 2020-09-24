import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


public class FileProcessing {

    //文件读取
    public static List<File> readFiles(String path) {
        File root = new File(path);
        List<File> files = new ArrayList<File>();
        if (!root.isDirectory()) {
            files.add(root);
        } else {
            File[] subFiles = root.listFiles();
            for (File f : subFiles) {
                files.addAll(readFiles(f.getAbsolutePath()));
            }
        }
        return files;
    }

    //文本转String
    public static String TxtToString(String fileName) {
        File file = new File(fileName);
        long filelenth = file.length();
        byte[] fileContent = new byte[(int) filelenth];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            return new String(fileContent, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    //将答案写入文件
    public static void writeAnswer(double sum, String anstext) {//
        String ans = String.format("%.2f", sum);
        File f = new File(anstext);
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            fw.write("");
            fw.flush();
            fw.write(String.valueOf(ans));
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


