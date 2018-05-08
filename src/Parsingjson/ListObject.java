/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsingjson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.apache.jena.*;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import static org.apache.jena.ontology.OntModelSpec.OWL_MEM;
import static org.apache.jena.ontology.OntModelSpec.OWL_MEM_MICRO_RULE_INF;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
/**
 *
 * @author yaya
 */
public class ListObject {
    public static void main(String[] args) {
        String[][] level0 = new String[100][4];
        String[][] level1 = new String[100][4];
        String[][] level2 = new String[100][4];
        String[][] level3 = new String[100][4];
        Scanner sc  = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
            System.out.println("List ke-"+(i+1)+": ");
            for (int j = 0; j < 4; j++) {
                if (j==0) {
                    System.out.print("Masukan Calon Super class    = ");
                }else if(j==1){
                    System.out.print("Masukan Tipe data Super Class = ");
                }else if(j==2){
                    System.out.print("Masukan Calon Sub Class       = ");
                }else{
                    System.out.print("Masukan Tipe data Sub Class   = ");
                }
                level0[i][j]=sc.next();
            }
            System.out.println("");
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("ISi list");
        
        for (int i = 0; i < 4; i++) {
            System.out.println("List Ke-"+(i+1)+": ");
            for (int j = 0; j < 4; j++) {
                if (j==0) {
                    System.out.print("Super class   = ");
                }else if(j==1){
                    System.out.print("Tipe data     = ");
                }else if(j==2){
                    System.out.print("Sub Class     = ");
                }else{
                    System.out.print("Tipe data     = ");
                }
                System.out.println(level0[i][j]);
            }
            System.out.println("");
        }
        
        String SOURCE = "http://www.eswc2006.org/technologies/ontology";
        String NS = SOURCE + "#";
        
        OntModel  base = ModelFactory.createOntologyModel( OWL_MEM );
        base.read(SOURCE,"RDF/XML");
        
        // create the reasoning model using the base
        OntModel inf = ModelFactory.createOntologyModel(OWL_MEM_MICRO_RULE_INF, base);

// create a dummy paper for this example
        OntClass paper = base.getOntClass(NS + "Paper");
        Individual p1 = base.createIndividual(NS + "paper1", paper);

// list the asserted types
        for (Iterator<Resource> i = p1.listRDFTypes(true); i.hasNext();) {
            System.out.println(p1.getURI() + " is asserted in class " + i.next());
        }

// list the inferred types
        p1 = inf.getIndividual(NS + "paper1");
        for (Iterator<Resource> i = p1.listRDFTypes(true); i.hasNext();) {
            System.out.println(p1.getURI() + " is inferred to be in class " + i.next());
        }


        
        
    }
}
