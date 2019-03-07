package me.abel.utils.commons;

import java.io.*;

/**
 * @program: automobile_dev
 * @description:
 * @author: able.li
 * @create: 2018-07-10 11:58
 */
public class StringUtil {

    public static String format(int src, int length){
        return String.format("%0"+length+"d", src);
    }

    public static String getStreamValue(InputStream inputStream){
        return getStreamValue(inputStream, "UTF-8");
    }

    public static String getStreamValue(InputStream inputStream, String charsetName){
        if(inputStream == null){return null;}
        InputStreamReader inReader = null;
        try {
            inReader = new InputStreamReader(inputStream, charsetName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BufferedReader bufferedReader = new BufferedReader(inReader);
        try {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String firstIndexToLowerCase(String src){
        char[] ch = src.toCharArray();
        ch[0] = (char) (ch[0] + ' ');//等价于ch[0] = (char) (ch[0] + 32);
        return new String(ch);
    }
}
