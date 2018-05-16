/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsingjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author yaya
 */
public class Coba {

    public void parsing(JSONObject levNow[], int i, JSONObject levBefore[], int j, ArrayList<String>[] arraybef, int k) {
        levNow[i] = (JSONObject) levBefore[j].get(arraybef[k].get(k));
        Iterator<?> iterator = levNow[i].keySet().iterator();
        //System.out.println(levNow[i].toJSONString());
        int array= k+1;
        System.out.println(array);
        arraybef[array] = new ArrayList<String>();
        while (iterator.hasNext()) {
            String a = (String) iterator.next();
            arraybef[array].add(a);
            //System.out.println(a);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        Coba objek = new Coba();
        JSONObject[] saveParsing =  new JSONObject[10];
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/home/yaya/skripsi/schema1.json")); //the location of the file
        JSONObject jsonObject = (JSONObject) obj;
        //deklarasi objek root terluar yang diketahui
        saveParsing[0] = (JSONObject) jsonObject.get("properties");
        
        
        
        
        
        //deklarasi array list tiap level 
        ArrayList<String>[] listArray =  new ArrayList[10];
        listArray[0] = new ArrayList<String>();
        //listArray[0].add("a");
        
        String a,b,c;
        b = (String) saveParsing[0].toJSONString();
       // System.out.println(b);
        //membuat iterator mengulang sesuai data yang ada
        Iterator<?> propertiesPointer = saveParsing[0].keySet().iterator();
        
        
        
        System.out.println("- level 0: ");
        System.out.println("-------------------------------------------");
        //perulangan iterator untuk memasukan data ke dalam array list dari level 0
        while(propertiesPointer.hasNext()){
            a = (String) propertiesPointer.next();
            listArray[0].add(a);            
        }
        
        System.out.println(listArray[0].toString());
        
        System.out.println("");
        
//        for (int i = 0; i < 4; i++) {
//            int j=i+1;
//            objek.parsing(saveParsing, j, saveParsing, i, listArray, i);
//        }
//        
//        System.out.println("level 1 + ");
//        System.out.println("-------------------------------------------");
//        for (int i = 1; i < 5; i++) {
//            System.out.println(listArray[1].toString());
//        }
        
        System.out.println("level 1-1 ");
        objek.parsing(saveParsing, 1, saveParsing, 0, listArray, 0);
        System.out.println(listArray[1].toString());
        System.out.println("");
        
        System.out.println("level 1-2 ");
        objek.parsing(saveParsing, 2, saveParsing, 1, listArray, 1);
        
        System.out.println(listArray[1].toString());
//        objek.parsing(saveParsing, 3, saveParsing, 2, listArray, 2);
//        objek.parsing(saveParsing, 4, saveParsing, 3, listArray, 3);
        
        
    }
    
}
