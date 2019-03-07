package me.abel.exception;

import java.util.Arrays;

/**
 * @description:
 * @author: able.li
 * @create: 2018/12/21 16:33
 */
public class ExceptionPrint {

    public static void main (String[] args){
        try {
            int i = 1/0;
        } catch (Exception e) {
            System.out.println(Arrays.asList(e.getStackTrace()).toString());
            System.out.println(e.getClass().getName() + ":" + e.getLocalizedMessage());
        }
    }
}
