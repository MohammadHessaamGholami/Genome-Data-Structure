
import java.io.NotSerializableException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by M.H.GH.K on 12/13/2017.
 */

public class main {
    public static void main(String[] args) {
        boolean flag = true;
        Error e1 = new Error();
        Map a1=new Map();


        myString a=new myString("a");
        myString b=new myString("b");
        myString c=new myString("c");
        myString d=new myString("d");

        a1.addGene(a,1,10);
        a1.addGene(b,1,15);
        a1.addGene(c,1,20);
        a1.addGene(d,1,25);
        a1.addEdge(a,b);
        a1.addEdge(a,c);
        a1.addEdge(a,d);

        a1.addEdge(b,a);
        a1.addEdge(b,c);
        a1.addEdge(b,d);

        a1.addEdge(c,a);
        a1.addEdge(c,b);
        a1.addEdge(c,d);


        a1.PrintGraph();

        a1.PrintGraph();
        Gene gene=a1.getMainDictionary().get(a);
        a1.doBFS(gene,10);

        //a1.addGenAlias(a,A);
        //Gene genn=a1.getMainDictionary().get(a);
        //Gene jen=a1.getMainDictionary().get(A);
        //a1.doBFS(genn,6);
        //a1.doBFS(jen,10);


        /*
        myString a=new myString("a");
        myString b=new myString("b");
        myString c=new myString("c");
        myString d=new myString("d");
        myString e=new myString("e");


        a1.addGene(a,1,10);
        a1.addGene(b,1,15);
        a1.addGene(c,1,20);
        a1.addGene(d,1,25);
        a1.addGene(e,1,30);
        a1.addEdge(a,b);
        a1.addEdge(a,c);
        a1.addEdge(b,e);
        a1.addEdge(b,c);

        a1.addEdge(c,e);
        a1.addEdge(c,d);
        a1.addEdge(d,e);
        a1.addEdge(d,a);
        a1.addEdge(e,a);


        Gene genn=a1.getMainDictionary().get(a);
        a1.doBFS(genn,6);

*/

        do{
            Scanner scn=new Scanner(System.in);
            String q=scn.nextLine();
            myString z1=new myString(q);
            myString[] temp=z1.doSplit();

            switch (temp[0].toString()){
                case "AddGene":{
                    if(temp[4]==null) {
                        a1.addGene(temp[1], Integer.parseInt(temp[2].toString()), Integer.parseInt(temp[3].toString()));
                    }
                    else{
                        e1.enterValidInput();
                    }
                    break;
                }
                case "AddGeneAlias":{
                    if(temp[3]==null) {
                        a1.addGenAlias(temp[1], temp[2]);
                    }
                    else {
                        e1.enterValidInput();
                    }
                    break;
                }
                case "RemoveAlias": {
                    if (temp[2]==null) {
                        a1.removeAlias(temp[1]);
                    }
                    else {
                        e1.enterValidInput();
                    }
                    break;
                }
                case "PrintGeneInfo": {
                    if(temp[2]==null) {
                        a1.printGeneInfo(temp[1]);
                    }
                    else {
                        e1.enterValidInput();
                    }
                    break;
                }
                case "Quit":{
                    if(temp[1]==null) {
                        flag = false;
                    }
                    else {
                        e1.enterValidInput();
                    }
                    break;
                }
                case "Regulates":{
                    if(temp[3]==null) {
                        a1.addEdge(temp[1], temp[2]);
                    }
                    else{
                        e1.enterValidInput();
                    }
                    break;
                }
                case "DonateRegulate":{
                    if(temp[3]==null) {
                        a1.RemoveEdge(temp[1], temp[2]);
                    }
                    else{
                        e1.enterValidInput();
                        }
                    break;

                }
                case "PrintGraph": {
                    if(temp[1]==null) {
                        a1.PrintGraph();
                    }
                    else {
                        e1.enterValidInput();
                    }
                    break;
                }
                case "PrintFeedBackLoops":{
                    if(temp[3]==null){
                        Gene gen=a1.getMainDictionary().get(temp[1]);
                        if(gen!=null ) {
                                //LinkedList<Gene> genesOfGraph=a1.getNodesOfGraph();
                                //int index=a1.changeFirst(temp[1]);
                                a1.doBFS(gen, Integer.parseInt(temp[2].toString()));
                                //a1.correctChange(index,gen);

                        }
                        else {
                            e1.inNotInDictionary(temp[1]);
                        }
                    }
                    else {
                        e1.enterValidInput();
                    }
                    break;
                }
                default:
                    e1.enterValidInput();
            }
        }
        while(flag);
    }
}
