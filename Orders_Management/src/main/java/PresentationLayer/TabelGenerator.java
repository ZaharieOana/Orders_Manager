package PresentationLayer;

import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;

public class TabelGenerator<T> {
    public JTable setTable(ArrayList<T> list){
        try{
            String[] headers = new String[list.get(0).getClass().getDeclaredFields().length];
            Object[][] data = new Object[list.size()][list.get(0).getClass().getDeclaredFields().length];
            int i = 0, j = 0;
            for (Object t : list) {
                j=0;
                for (Field field : t.getClass().getDeclaredFields()) {
                    field.setAccessible(true);
                    if(i==0)
                        headers[j]=field.getName();
                    data[i][j]=field.get(t);
                    j++;
                }
                i++;
            }

            JTable table = new JTable(data, headers);
            return table;
        }catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
