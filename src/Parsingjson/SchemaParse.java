/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsingjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

/**
 *
 * @author yaya
 */
public class SchemaParse {
    ArrayList<String> level0 =  new ArrayList<String>();
    
    public void parsing(JSONObject levNow[],int i,JSONObject properties[],int j,ArrayList<String>[] arraybef, int k,JSONObject iteratorKey[], int l){
       levNow[i] = (JSONObject) properties[j].get(arraybef[k].get(k));
       Iterator<?> iterator = iteratorKey[l].keySet().iterator();
       
       while(iterator.hasNext()){
            String a = (String) iterator.next();
            arraybef[k].add(a);
            System.out.println(a+ ": ");
            //System.out.println(dimention.get(a));
            
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        String a, b, c;
        JSONObject[] lev1 = new JSONObject[10];
//        lev1[0] = new JSONObject();
//        lev1[2] = null;
//        lev1[3] = new JSONObject();
//        lev1[4] = new JSONObject();
        ArrayList<String>[] listArray = new ArrayList[10];
        listArray[0] = new ArrayList<String>();
        listArray[1] = new ArrayList<String>();
        listArray[2] = new ArrayList<String>();
        listArray[3] = new ArrayList<String>();
        listArray[4] = new ArrayList<String>();
        listArray[5] = new ArrayList<String>();
        listArray[6] = new ArrayList<String>();
        listArray[7] = new ArrayList<String>();
        JSONObject[] lev2 = new JSONObject[10];
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/home/yaya/skripsi/schema1.json")); //the location of the file
        JSONObject jsonObject = (JSONObject) obj;
        //deklarasi objek root terluar yang diketahui
               
       
        
        //membuat iterator mengulang sesuai data yang ada
        JSONObject properties = (JSONObject) jsonObject.get("properties"); 
        Iterator<?> propertiesPointer = properties.keySet().iterator();
        

        //perulangan iterator untuk memasukan data ke dalam array list
        while(propertiesPointer.hasNext()){
            a = (String) propertiesPointer.next();
            listArray[0].add(a);
            //level0.add(a);
            //System.out.println(a);
           //System.out.println(a+": "+properties.get(a));
            
        }
        if(!listArray[0].isEmpty()){
            System.out.println("- level 0: ");
            System.out.println("-------------------------------------------");
            System.out.println(listArray[0].toString());
            
        }
        
        //System.out.println(level0.toString());
//        for (int i = 0; i < 6; i++) {
//            //System.out.println(level0.toString());
//            System.out.println(level0.get(i)+": ");
//            //System.out.println("");
//            JSONObject getLevel2 = (JSONObject) properties.get(level0.get(i));
//            Iterator<?> getLevel2Properties = getLevel2.keySet().iterator();
//            while (getLevel2Properties.hasNext()) {
//                a = (String) getLevel2Properties.next();
//                //level1.add(a);
//                //System.out.println(a);
//                //System.out.println(getLevel2.get(a));
//                //System.out.println(a+": "+getLevel2.get(a));
//            }
//            System.out.println("--------------------------------------------------");
//            System.out.println("");
//        }
        
        System.out.println("");
      
//        JSONObject dimention = (JSONObject) properties.get(level0.get(4));
//        Iterator<?> dimentionPointer = dimention.keySet().iterator();
        for (int i = 0; i < listArray[0].size(); i++) {
            lev1[1] = (JSONObject) properties.get(listArray[0].get(i));
            Iterator<?> dimentionPointer = lev1[1].keySet().iterator();
            //System.out.println(dimentionPointer);
            while (dimentionPointer.hasNext()) {
                a = (String) dimentionPointer.next();
                listArray[1].add(a);
                //System.out.println(a + ": ");
                //System.out.println(dimention.get(a));
            }
            
            listArray[1].add(listArray[0].get(i));
            listArray[1].add("break");
           // System.out.println("");
        }
        System.out.println("");
        if (!listArray[1].isEmpty()) {
            System.out.println("- level 1: ");
            System.out.println("-------------------------------------------");
            System.out.println(listArray[1].toString());
        }
        
        System.out.println("");
        //System.out.println(lev1[1].toString());   

        
        
        for (int i = 0; i < listArray[1].size(); i++) {
            
            try{
                if ((JSONObject) lev1[1].get(listArray[1].get(i)) != null) {
                    //System.out.println("y= " +i);
                    //System.out.println(i);
                    lev1[2] = (JSONObject) lev1[1].get(listArray[1].get(i));
                    Iterator<?> dimentionPointer1 = lev1[2].keySet().iterator();
                    while (dimentionPointer1.hasNext()) {
                        a = (String) dimentionPointer1.next();
                        listArray[2].add(a);
                    }
                    //System.out.println(listArray[0].get(5));
                    //System.out.println(listArray[1].get(i));
                    int j=i;
                    for (int k = i; k < listArray[1].size(); k++) {
                        if((listArray[1].get(k).equalsIgnoreCase("break"))){
                            listArray[2].add(listArray[1].get(k-1));
                            //System.out.println(k-1);
                            break;
                        }
                    }
                    
                    //listArray[2].add(listArray[0].get(i));
                    listArray[2].add(listArray[1].get(i));
                    listArray[2].add("break");
                }
            }catch (Exception e){
                
            }             
        }
        if (!listArray[2].isEmpty()) {
            System.out.println("- level 2: ");
            System.out.println("-------------------------------------------");
            System.out.println(listArray[2].toString());
        }
        System.out.println("");

        for (int i = 0; i < listArray[2].size(); i++) {

            try {
                if ((JSONObject) lev1[2].get(listArray[2].get(i)) != null) {
                    //System.out.println("y");
                    //System.out.println(i);
                    lev1[3] = (JSONObject) lev1[2].get(listArray[2].get(i));
                    Iterator<?> dimentionPointer1 = lev1[3].keySet().iterator();
                    while (dimentionPointer1.hasNext()) {
                        a = (String) dimentionPointer1.next();
                        listArray[3].add(a);
                    }
                    //System.out.println(listArray[0].get(5));
                    //System.out.println(listArray[1].get(i));
                    for (int k = i; k < listArray[2].size(); k++) {
                        if ((listArray[2].get(k).equalsIgnoreCase("break"))) {
                            for (int j = 1; j < 3; j++) {
                                listArray[3].add(listArray[2].get(k - 3 +j));
                            }
                            
                            //listArray[3].add(listArray[2].get(k - 1));
                            //System.out.println(k-1);
                            break;
                        }
                    }

                    //listArray[2].add(listArray[0].get(i));
                    listArray[3].add(listArray[2].get(i));
                    listArray[3].add("break");
                }
            } catch (Exception e) {

            }
        }
        if (!listArray[3].isEmpty()) {
            System.out.println("- level 3: ");
            System.out.println("-------------------------------------------");
            System.out.println(listArray[3].toString());
        }
        System.out.println("");
        
        //untuk cek panjang array list level sebelumnya
        for (int i = 0; i < listArray[3].size(); i++) {
            if(listArray[3].get(i).equalsIgnoreCase("break")){
                //System.out.println("i= "+i);
                for (int j = i-1; j >= 0; j--) {
                    if(listArray[3].get(j).equalsIgnoreCase("break")){
                        break;
                    }else{
                        if(j==i-1 || j==i-2 || j==i-3){
                           // System.out.println(j);
                        }else{
                            //System.out.println(j);
                            try {
                                if ((JSONObject) lev1[3].get(listArray[3].get(j)) != null) {
                                    //System.out.println("y = " + j);
//                                    System.out.print(i + "= ");
                                    //System.out.println(listArray[3].get(j));
                                    lev1[4] = (JSONObject) lev1[3].get(listArray[3].get(j));
                                    Iterator<?> dimentionPointer1 = lev1[4].keySet().iterator();
                                    while (dimentionPointer1.hasNext()) {
                                        a = (String) dimentionPointer1.next();
                                        listArray[4].add(a);
                                    }
                                    for (int k = j; k < listArray[3].size(); k++) {
                                        if ((listArray[3].get(k).equalsIgnoreCase("break"))) {
                                            for (int x = 1; x < 4; x++) {
                                                listArray[4].add(listArray[3].get(k - 4 + x));
                                            }
                                            break;
                                        }
                                    }
                                    listArray[4].add(listArray[3].get(j));
                                    listArray[4].add("break");
                                }
                            } catch (Exception e) {

                            }
                            
                        }
                        
                    }
                }
            }
        }
        if (!listArray[4].isEmpty()) {
            System.out.println("- level 4: ");
            System.out.println("-------------------------------------------");
            System.out.println(listArray[4].toString());
        }
        System.out.println("");
        
        for (int i = 0; i < listArray[4].size(); i++) {
            if (listArray[4].get(i).equalsIgnoreCase("break")) {
                //System.out.println("i= "+i);
                for (int j = i - 1; j >= 0; j--) {
                    if (listArray[4].get(j).equalsIgnoreCase("break")) {
                        break;
                    } else {
                        if (j == i - 1 || j == i - 2 || j == i - 3 || j == i - 4) {
                            // System.out.println(j);
                        } else {
                            //System.out.println(j);
                            //System.out.println(lev1[4].get(listArray[4].get(j)));
                            //break;
                            try {
                                if ((JSONObject) lev1[4].get(listArray[4].get(j)) != null) {
                                    //System.out.println("y");
//                                    System.out.print(i + "= ");
                                    //System.out.println(listArray[3].get(j));
                                    lev1[5] = (JSONObject) lev1[4].get(listArray[4].get(j));
                                    Iterator<?> dimentionPointer1 = lev1[5].keySet().iterator();
                                    while (dimentionPointer1.hasNext()) {
                                        a = (String) dimentionPointer1.next();
                                        listArray[5].add(a);
                                    }
                                    for (int k = j; k < listArray[4].size(); k++) {
                                        if ((listArray[4].get(k).equalsIgnoreCase("break"))) {
                                            for (int x = 1; x < 5; x++) {
                                                listArray[5].add(listArray[4].get(k - 5 + x));
                                            }
                                            break;
                                        }
                                    }
                                    listArray[5].add(listArray[4].get(j));
                                    listArray[5].add("break");
                                }
                            } catch (Exception e) {

                            }

                        }

                    }
                }
            }
        }
        if (!listArray[5].isEmpty()) {
            System.out.println("- level 5: ");
            System.out.println("-------------------------------------------");
            System.out.println(listArray[5].toString());
        }
    }
    
}
