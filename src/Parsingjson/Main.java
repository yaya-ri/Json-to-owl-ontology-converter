/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsingjson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import org.json.simple.parser.ParseException;

/**
 *
 * @author yaya
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("/home/yaya/skripsi/file.json")); //the location of the file
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray numbers = (JSONArray) jsonObject.get("numbers");
        //JSONArray natural = (JSONArray) jsonObject.get("narutal");
        
        for (Object number : numbers) {
            JSONObject jsonNumber = (JSONObject) number;
            String natural = (String) jsonNumber.get("natural");
            System.out.println(natural);
        }
        
    }

}
