package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件类
 * @author cmt&gzq
 */
public class MyFile {

    /**
     * 将题目或答案写入当前目录下的文件
     * @param fileName 文件名
     * @param s 题目或答案
     */
    public static void write(String fileName, String s){
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            fw.write(s + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
