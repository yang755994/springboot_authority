package net.sppan.base.common.utils;

import com.google.common.collect.Lists;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * 用于补录价格数据
 * @author: yangzhigang
 * @Description:
 * @Date: 2018/4/24 11:20
 */
public class FileUtils {

    /**
     * 创建文件
     * @param fileName
     * @return
     */
    public static boolean createFile(File fileName)throws Exception{
        try{
            if(!fileName.exists()){
                fileName.createNewFile();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return true;
    }

    public static List<String> readTextFile(File file) {
        List<String> result = Lists.newArrayList();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
                result.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static List<BigDecimal> readTextFileForBig(File file) {
        List<BigDecimal> result = Lists.newArrayList();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
                result.add(BigDecimalUtils.add(new BigDecimal(s), BigDecimal.ZERO));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *读取TXT内容
     * @param file
     * @return
     */
    public static List<String> readTxtFileForPrice_condition(File file){
        List<String> result = Lists.newArrayList();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
                //String temp = "select id,good_sn,price_md5 from price_" + TableHashRouteUtils.doSelect(s);
                String temp = "select count(1) cc from price_" + TableHashRouteUtils.doSelect(s) + " union ";
                //System.out.println(temp);
                result.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *读取TXT内容
     * @param file
     * @return
     */
    public static List<String> readTxtFileForPrice_delete(File file){
        List<String> result = Lists.newArrayList();
        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file),"UTF-8");
            BufferedReader br = new BufferedReader(reader);
            String s = null;
            while((s=br.readLine())!=null){
                result.add("price_" + TableHashRouteUtils.doSelect(s) + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 写入TXT，覆盖原内容
     * @param results
     * @param fileName
     * @return
     * @throws Exception
     */
    public static boolean writeTxtFile(List<String> results, File fileName)throws Exception{
        RandomAccessFile mm=null;
        boolean flag=false;
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            for (String content : results) {
                fileOutputStream.write(content.getBytes("utf-8"));
            }
            fileOutputStream.close();
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 批量写入TXT，追加写入
     * @param contents
     * @param filePath
     */
    public static void fileChaseFWBatch(List<String> contents, String filePath) {
        try {
            //构造函数中的第二个参数true表示以追加形式写文件
            FileWriter fw = new FileWriter(filePath,true);
            for (String content : contents) {
                fw.write(content);
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("文件写入失败！" + e);
        }
    }


    /**
     * 写入TXT，追加写入
     * @param filePath
     * @param content
     */
    public static void fileChaseFW(String filePath, String content) {
        try {
            //构造函数中的第二个参数true表示以追加形式写文件
            FileWriter fw = new FileWriter(filePath,true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            System.out.println("文件写入失败！" + e);
        }
    }



    public static void main(String[] args) throws Exception{
//        File file = new File("c:\\priceId.txt");
//        createFile(file);
        //List<String> results = readTxtFileForPrice_condition(file);
        //writeTxtFile(results, new File("c:\\price_condition.txt"));
        //System.out.println(readTextFile(new File("c:\\price_fixed.txt")));
        System.out.println(readTxtFileForPrice_condition(new File("c:\\price_fixed.txt")));
    }
}