/**
 * Created by M.H.GH.K on 12/13/2017.
 */
public class Error {
    public void isDuplicateName(myString name1){
        System.out.printf("%s is here in our Dictionary. please enter another name : Error",name1);
        System.out.println();
    }
    public void inNotInDictionary(myString name1){
        System.out.printf("%s is not in our Dictionary. please enter correct name : Error",name1);
        System.out.println();
    }
    public void isNotInGraph(myString name){
        System.out.printf("%s is not in Graph. please enter correct name : Error",name);
        System.out.println();
    }
    public void isEdge(myString name1,myString name2){
        System.out.printf("There is  edge between %s and %s : Error",name1,name2);
        System.out.println();
    }
    public void isNotEdge(myString name1,myString name2) {
        System.out.printf("There is no edge between %s and %s : Error", name1, name2);
        System.out.println();
    }
    public void enterValidInput(){
        System.out.printf("Enter valid input please!");
        System.out.println();
    }
    public void isInOneGene(myString name1,myString name2){
        System.out.printf("%s and %s is in One Structure and you can not connect them!",name1,name2);
        System.out.println();
    }
}
