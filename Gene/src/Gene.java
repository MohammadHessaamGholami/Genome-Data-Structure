import java.util.LinkedList;

/**
 * Created by M.H.GH.K on 12/13/2017.
 */
public class Gene {
    private int x1,x2;
    private LinkedList<myString> listOfNames=new LinkedList<myString>();
    private LinkedList<Gene> adjacencyList=new LinkedList<>();
    private LinkedList<Gene> adjacencyListComeBack=new LinkedList<>();
    private boolean isChecked=false;
    /*private int path=-1;
    public int getPath() {
        return path;
    }
    public void setPath(int path) {
        this.path = path;
    }
*/
    public LinkedList<Gene> getAdjacencyListComeBack() {
        return adjacencyListComeBack;
    }
    public void setAdjacencyListComeBack(LinkedList<Gene> adjacencyListComeBack) {
        this.adjacencyListComeBack = adjacencyListComeBack;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }
    public Gene(int x1, int x2, myString name){
        this.x1 = x1;
        this.x2 = x2;
        listOfNames.add(name);
    }
    public LinkedList<Gene> getAdjacencyList() {
        return adjacencyList;
    }
    public void setAdjacencyList(LinkedList<Gene> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }
    public int getX2() {
        return x2;
    }
    public int getX1() {
        return x1;
    }
    public LinkedList<myString> getListOfNames() {
        return listOfNames;
    }
    public void setX1(int x1) {
        this.x1 = x1;
    }
    public void setX2(int x2) {
        this.x2 = x2;
    }
    public void setListOfNames(LinkedList<myString> listOfNames) {
        this.listOfNames = listOfNames;
    }
    public void addGene(myString name)  {
        listOfNames.add(name);
    }
    public void removeGene(myString name){
        for(int i=0;i<listOfNames.size();i++){
            if(listOfNames.get(i).compareTo(name)==0){
                listOfNames.remove(i);
                break;
            }
        }
    }
}
