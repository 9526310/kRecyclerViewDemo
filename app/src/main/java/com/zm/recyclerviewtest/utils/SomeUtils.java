package com.zm.recyclerviewtest.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.widget.EditText;

import com.zm.recyclerviewtest.bean.Student;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SomeUtils {

    /**
     /**
     * 把EditText的光标移到末尾
     * @param editText
     */
    public static void moveFocus(EditText editText)
    {
        Editable editStr=editText.getText();
        Spannable spannable=editStr;
        Selection.setSelection(spannable, editStr.length());
    }

    /**
     * 模糊查找集合
     * @param name
     * @param list
     * @return
     */
    public static ArrayList<Student> fuzzyQuery (String name, ArrayList<Student> list){
        ArrayList<Student> fuzzyQueryList = new ArrayList<Student>();
        //大小写不敏感的时候，多加一个条件
        Pattern pattern = Pattern.compile(name,Pattern.CASE_INSENSITIVE);
        for(int i=0; i < list.size(); i++){
            //这里用toString来模糊查找比name查的范围大
            Matcher matcher = pattern.matcher((list.get(i)).toString());//list.get(i)).getName()
            if(matcher.find()){
                fuzzyQueryList.add(list.get(i));
            }
        }
        return fuzzyQueryList;
    }

}
