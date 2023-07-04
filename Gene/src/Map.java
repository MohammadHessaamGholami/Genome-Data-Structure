/**
 * Created by M.H.GH.K on 12/17/2017.
 */
import java.util.LinkedList;

public class Map{
    private SplayBST<myString,Gene> mainDictionary;
    private Error error=new Error();

    public LinkedList<Gene> getNodesOfGraph() {
        return NodesOfGraph;
    }

    private LinkedList<Gene> NodesOfGraph=new LinkedList<Gene>();
    private Queue<Gene> ResultsOfBFS=new Queue<>();
    private Queue<Gene> axillaryForBFS =new Queue<>();
    private MyArrayList<MyArrayList<Gene>> Masir;
    private Gene veryImportantGene;
    private int cycle=-1;

    public SplayBST<myString, Gene> getMainDictionary() {
        return mainDictionary;
    }
    public void setMainDictionary(SplayBST<myString, Gene> mainDictionary) {
        this.mainDictionary = mainDictionary;
    }
    public Map(){
        mainDictionary=new SplayBST<myString,Gene>();
    }
    public Gene find(int x1,int x2,SplayBST.Node root) {
        if (root != null) {
            Gene valueOfGene = (Gene) root.getValue();
            if (valueOfGene.getX1() == x1 && valueOfGene.getX2() == x2) {
                return valueOfGene;

            }
            if (root.getRight() != null) {
                if (find(x1, x2, root.getRight()) != null) {
                    return (Gene) root.getRight().getValue();
                }
            }
            if (root.getLeft() != null) {
                if (find(x1, x2, root.getLeft()) != null) {
                    return (Gene) root.getLeft().getValue();
                }

            }
        } else {
            return null;
        }


        return null;
    }
    public void addGene(myString name,int x1,int x2){

        boolean state1=mainDictionary.contains(name);
        Gene state2=find(x1,x2,mainDictionary.getRoot());
        if(!state1){
            if(state2==null){
                Gene newGene=new Gene(x1,x2,name);
                mainDictionary.put(name,newGene);
            }
            else{
                state2.addGene(name);
                mainDictionary.put(name,state2);
            }
        }
        else{

            error.isDuplicateName(name);
        }



        /*SplayBST<myString,Gene> secondDictionary=(SplayBST<myString,Gene>) mainDictionary.clone();
        System.out.print(find(x1,x2,mainDictionary.getRoot()));
        if (mainDictionary.size()==0){
            mainDictionary.put(name,new Gene(x1,x2,name));
        }
        else {
            if (mainDictionary.contains(name)==false) {
                while (true) {
                    if (secondDictionary.size() == 0) {
                        mainDictionary.put(name, new Gene(x1, x2, name));
                        break;
                    }
                    Gene obj1 = secondDictionary.getValue(secondDictionary.getRoot());
                    secondDictionary.remove(secondDictionary.getkey(secondDictionary.getRoot()));
                    if (obj1.getX1() == x1 & obj1.getX2() == x2) {
                        //System.out.println("5");
                        obj1.addGene(name);
                        mainDictionary.put(name, obj1);
                        break;
                    }
                }
            } else {//tekrari name
                error.isDuplicateName(name);
            }
        }
        */
    }
    public void addGenAlias(myString name1,myString name2)   {
        boolean state1=mainDictionary.contains(name1);
        boolean state2=mainDictionary.contains(name2);
        if(!state1){
            error.inNotInDictionary(name1);
        }
        if(state2){
            error.isDuplicateName(name2);
        }
        if(state1 && !state2) {
            Gene object = mainDictionary.get(name1);
            object.addGene(name2);
            mainDictionary.put(name2, object);
        }
    }
    public void removeAlias(myString name) {
        boolean state1=mainDictionary.contains(name);
        if (state1) {
            //for(int i=0;i<mainDictionary.)
            Gene object = mainDictionary.get(name);
            //System.out.print(object.getListOfNames().size());
            object.removeGene(name);
            //System.out.print(object.getListOfNames().size());
            if (object.getListOfNames().size() == 0) {
                for(int i=0;i<object.getAdjacencyList().size();i++){
                    Gene myGene=object.getAdjacencyList().get(i);
                    myGene.getAdjacencyListComeBack().remove(object);
                    if(myGene.getAdjacencyList().size()==0 && myGene.getAdjacencyListComeBack().size()==0){
                        myGene=null;
                    }
                }
                for(int i=0;i<object.getAdjacencyListComeBack().size();i++){
                    Gene myGene=object.getAdjacencyListComeBack().get(i);
                    myGene.getAdjacencyList().remove(object);
                    if(myGene.getAdjacencyList().size()==0 && myGene.getAdjacencyListComeBack().size()==0){
                        myGene=null;
                    }
                }

                object = null;
            } else {

                mainDictionary.put(name,object);
                //object.setListOfNames(listOfNames);
            }
            mainDictionary.remove(name);

        } else {
            error.inNotInDictionary(name);

        }


    }
    public void printGeneInfo(myString name) {
        if(mainDictionary.size()!=0) {
            if (mainDictionary.contains(name) == true) {
                Gene objectOfGene = mainDictionary.get(name);
                System.out.printf("%d     %d     ", objectOfGene.getX1(), objectOfGene.getX2());
                LinkedList<myString> listOfNames = objectOfGene.getListOfNames();
                for (int i = 0; i < listOfNames.size(); i++) {
                    System.out.printf("%s     ", listOfNames.get(i));

                }
                System.out.println();


            } else {
                error.inNotInDictionary(name);
            }
        }
        else{
            error.inNotInDictionary(name);
        }
    }
    public void addEdge(myString name1,myString name2){
        boolean case1=mainDictionary.contains(name1);
        boolean case2=mainDictionary.contains(name2);
        if(!case1){
            error.inNotInDictionary(name1);
        }
        if(!case2){
            error.inNotInDictionary(name2);
        }
        if(case1 && case2){
            Gene geneOfName2=mainDictionary.get(name2);
            Gene geneOfname1=mainDictionary.get(name1);
            if(!geneOfname1.equals(geneOfName2)) {
                boolean case3 = mainDictionary.get(name1).getAdjacencyList().contains(geneOfName2);
                if (case3) {
                    error.isEdge(name1, name2);

                } else {
                    Gene GenOfName2 = mainDictionary.get(name2);
                    mainDictionary.get(name1).getAdjacencyList().add(GenOfName2);
                    /////////////////////////////////////////////////////////////////////////////
                    mainDictionary.get(name2).getAdjacencyListComeBack().add(geneOfname1);

                    ////////////

                    if(!NodesOfGraph.contains(GenOfName2)) {
                        NodesOfGraph.add(GenOfName2);
                    }
                    if(!NodesOfGraph.contains(geneOfname1)) {
                        NodesOfGraph.add(geneOfname1);
                    }
                    //System.out.println(NodesOfGraph.size());

                    ////////////////
                    /////////////////////////////////////////////////////////////////////////////

                }
            }
            else{
                error.isInOneGene(name1,name2);
            }
            //System.out.println();
        }

    }
    public void RemoveEdge(myString name1,myString name2){
        boolean case1=mainDictionary.contains(name1);
        boolean case2=mainDictionary.contains(name2);
        if(!case1){
            error.inNotInDictionary(name1);
        }
        if(!case2){
            error.inNotInDictionary(name2);
        }

        if(case1 && case2){

            Gene geneOfName1=mainDictionary.get(name1);
            Gene geneOfName2=mainDictionary.get(name2);
            boolean case3=mainDictionary.get(name1).getAdjacencyList().contains(geneOfName2);
            if (case3){
                mainDictionary.get(name1).getAdjacencyList().remove(geneOfName2);
                mainDictionary.get(name2).getAdjacencyListComeBack().remove(geneOfName1);
                if(geneOfName1.getAdjacencyList().size()==0){
                    //System.out.println("********");
                    NodesOfGraph.remove(geneOfName1);
                }
                if(geneOfName2.getAdjacencyListComeBack().size()==0){
                    NodesOfGraph.remove(geneOfName2);
                    //System.out.println("////////");

                }
                ////////////////////////////////////////////////////////////////////////
                //System.out.println(NodesOfGraph.size());
                //NodesOfGraph.remove(geneOfName2);
                //System.out.println(NodesOfGraph.size());


                ////////////////////////////////////////////////////////////////////////
            }
            else {
                error.isNotEdge(name1,name2);
            }

        }
        /*
        System.out.println();
        System.out.println("********");
        System.out.println(NodesOfGraph.size());
        */

    }
    public void PrintGraph(){
        System.out.printf("Disgraph G { ");

        System.out.println();
        SplayBST.Node root =mainDictionary.getRoot();
        auxiliaryPrintGraph(root);
        beCheckedFalse(root);

        /*
        System.out.println();
        for(int i=0;i<NodesOfGraph.size();i++){
            Gene myGeneInGraph=NodesOfGraph.get(i);
            for(int j=0;j<myGeneInGraph.getAdjacencyList().size();j++){
                System.out.printf("    %s -> %s ",myGeneInGraph.getListOfNames().get(0),myGeneInGraph.getAdjacencyList().get(j).getListOfNames().get(0));
                System.out.println();
            }
        }
        */
        System.out.printf("}");
        System.out.println();
        //System.out.print(NodesOfGraph.size());
    }
    private void auxiliaryPrintGraph(SplayBST.Node root){
        //if(root)
        if(root!=null) {


                Gene myGene = (Gene) root.getValue();
                if(!myGene.isChecked()) {
                    myString nameOfGen1 = myGene.getListOfNames().getFirst();
                    for (int i = 0; i < myGene.getAdjacencyList().size(); i++) {
                        System.out.printf("    %s -> %s ", nameOfGen1, myGene.getAdjacencyList().get(i).getListOfNames().getFirst());
                        System.out.println();
                    }
                    myGene.setChecked(true);
                    if (root.getLeft() != null) {
                        auxiliaryPrintGraph(root.getLeft());
                    }
                    if (root.getRight() != null) {
                        auxiliaryPrintGraph(root.getRight());
                    }
                }

        }
    }
    private void beCheckedFalse(SplayBST.Node root){
        if(root!=null){
            Gene myGene = (Gene) root.getValue();
            myGene.setChecked(false);
            if(root.getLeft()!=null) {
                beCheckedFalse(root.getLeft());
            }
            if(root.getRight()!=null){
                beCheckedFalse(root.getRight());
            }

        }


    }
    public Queue<Gene> BFS(Gene startGene){
            boolean flag=false;
            do {
                if (!startGene.isChecked()) {
                    ResultsOfBFS.Add(startGene);
                    axillaryForBFS.Add(startGene);

                    MyArrayList<Gene> o1 = new MyArrayList<>();
                    o1.add(startGene);
                    Masir.add(o1);

                    veryImportantGene = startGene;
                    startGene.setChecked(true);
                }
                for (int u = 0; u < startGene.getAdjacencyList().size(); u++) {
                    Gene adjaceny = startGene.getAdjacencyList().get(u);
                    if (adjaceny.isChecked() && !adjaceny.equals(veryImportantGene)) {
                        for (int j = 0; j < Masir.Size(); j++) {
                            MyArrayList<Gene> oneOfArrayOfGeneType = Masir.get(j);
                            if (oneOfArrayOfGeneType.getLast() == startGene) {
                                MyArrayList<Gene> NewArrayOfGeneType = new MyArrayList<>();
                                for (int k = 0; k < oneOfArrayOfGeneType.Size(); k++) {
                                    NewArrayOfGeneType.add(oneOfArrayOfGeneType.get(k));
                                    if(oneOfArrayOfGeneType.get(k)==startGene.getAdjacencyList().get(u)){
                                        flag=true;

                                    }
                                }
                                if(!flag) {
                                    NewArrayOfGeneType.add(startGene.getAdjacencyList().get(u));
                                    Masir.add(NewArrayOfGeneType);
                                    if (isEdge(NewArrayOfGeneType.getLast(), veryImportantGene) && NewArrayOfGeneType.Size() <= cycle) {
                                        //System.out.println("/////");
                                        for (int z = 0; z < NewArrayOfGeneType.Size(); z++) {
                                            System.out.printf(" %s", NewArrayOfGeneType.get(z).getListOfNames().getFirst().toString());
                                        }
                                        System.out.printf(";");
                                    }
                                }
                                flag=false;
                            }
                        }
                    }
                }
                for (int i = 0; i < startGene.getAdjacencyList().size(); i++) {
                    if (!startGene.getAdjacencyList().get(i).isChecked()) {
                        ResultsOfBFS.Add(startGene.getAdjacencyList().get(i));
                        axillaryForBFS.Add(startGene.getAdjacencyList().get(i));
                        startGene.getAdjacencyList().get(i).setChecked(true);
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                        for (int j = 0; j < Masir.Size(); j++) {
                            MyArrayList<Gene> oneOfArrayOfGeneType = Masir.get(j);
                            if (oneOfArrayOfGeneType.getLast() == startGene) {
                                MyArrayList<Gene> NewArrayOfGeneType = new MyArrayList<>();
                                for (int k = 0; k < oneOfArrayOfGeneType.Size(); k++) {
                                    NewArrayOfGeneType.add(oneOfArrayOfGeneType.get(k));
                                }
                                NewArrayOfGeneType.add(startGene.getAdjacencyList().get(i));
                                Masir.add(NewArrayOfGeneType);
                                if (isEdge(NewArrayOfGeneType.getLast(), veryImportantGene) && NewArrayOfGeneType.Size() <= cycle) {
                                    for (int z = 0; z < NewArrayOfGeneType.Size(); z++) {
                                        System.out.printf(" %s", NewArrayOfGeneType.get(z).getListOfNames().getFirst().toString());
                                    }
                                    System.out.printf(";");
                                }
                            }
                        }
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    }
                }
                axillaryForBFS.Remove();
                if (axillaryForBFS.length() != 0) {
                    BFS(axillaryForBFS.peek());
                }
            }
            while (ResultsOfBFS.length() != 0 && axillaryForBFS.length() != 0);
            return ResultsOfBFS;
    }
    public void doBFS(Gene gen,int cycle) {
        Masir = new MyArrayList<MyArrayList<Gene>>();
        veryImportantGene = gen;
        this.cycle = cycle;
        Queue my = BFS(gen);
        System.out.println();
        Masir = null;
        veryImportantGene = null;
        for (int i = 0; i < NodesOfGraph.size(); i++) {
            Gene myGene = NodesOfGraph.get(i);
            myGene.setChecked(false);
        }
        this.cycle = -1;
    }
    public boolean isEdge(Gene gen1,Gene gen2){
        if(gen1.equals(gen2)){
            return false;
        }
        boolean case1=NodesOfGraph.contains(gen1);
        boolean case2=NodesOfGraph.contains(gen2);
        if(case1 && case2){
            int indexOfGen1=NodesOfGraph.indexOf(gen1);
            int indexOfGen2=NodesOfGraph.indexOf(gen2);
            boolean case3=NodesOfGraph.get(indexOfGen1).getAdjacencyList().contains(gen2);
            boolean case4=NodesOfGraph.get(indexOfGen2).getAdjacencyListComeBack().contains(gen1);
            if( case3&& case4){
                return true;
            }
            else {
                return false;
            }
        }
        else{
            return false;
        }

    }

    /*
    public int changeFirst(myString oneOfName){
        Gene gene=mainDictionary.get(oneOfName);
        LinkedList<myString> listOfNames=gene.getListOfNames();
        int indexOfName=0;
        for(int i=0;i<listOfNames.size();i++){
            if(listOfNames.get(i).toString().equals(oneOfName.toString())){
                indexOfName=i;
                break;

            }
        }
        myString a1=listOfNames.get(0);
        listOfNames.add(indexOfName,a1);
        listOfNames.add(0,oneOfName);
        gene.setListOfNames(listOfNames);
        return indexOfName;
    }
    public void correctChange(int indexOfName,Gene gene){
        LinkedList<myString> listOfNames=gene.getListOfNames();
        myString a1=listOfNames.get(0);
        myString a2=listOfNames.get(indexOfName);
        listOfNames.add(indexOfName,a1);
        listOfNames.add(0,a2);
        gene.setListOfNames(listOfNames);
    }
    */
}






