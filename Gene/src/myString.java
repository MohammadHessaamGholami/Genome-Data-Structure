
/**
 * Created by M.H.GH.K on 12/18/2017.
 */

public class myString {
    private MyArrayList<Character> mainString=new MyArrayList<Character>();
    private int SizeOfMyString=0;
    public myString(String string){
        int i = 0;
        try {
            while (true) {
                char char_i = string.charAt(i);
                mainString.add(char_i);
                i = i + 1;
            }
        }
        catch (StringIndexOutOfBoundsException e) {
            this.SizeOfMyString = i;
        }
    }
    public int lenght(){
        return SizeOfMyString;
    }
    public int compareTo(myString string2){
        int SizeOfString1=SizeOfMyString;
        int SizeofString2=string2.lenght();
        int index=0;
        while(true){
            if(index==SizeOfString1 || index==SizeofString2){
                return(SizeOfString1-SizeofString2);
            }
            //System.out.println(index);
            if(mainString.get(index)!=string2.charTo(index)){
                int comp=mainString.get(index).compareTo(string2.charTo(index));
                return comp;
            }
            index=index+1;
        }
    }
    public Character charTo(int i){
        return mainString.get(i);
    }
    public myString[] doSplit(){
        myString[] finalString=new myString[5];
        Character[] help=new Character[50];
        int i=0;
        while (i<mainString.Size()) {
            help[i] = mainString.get(i);
            i = i + 1;
        }
        int j=0;
        int k=0;
        int space=0;
        while (k<=5) {
            while (true) {
                if(j==mainString.Size()){
                    String result= "";
                    for (; space < j; space++) {
                        result =result+help[space].toString();
                    }
                    space = j+1;
                    myString res=new myString(result);
                    finalString[k]=res;
                }
                if(help[j]==null){
                    break;
                }
                if (help[j] == ' ') {
                    String result ="";
                    for (; space < j; space++) {

                        result =result+help[space].toString();
                    }
                    space = j+1;
                    myString res=new myString(result);
                    finalString[k]=res;
                    j=j+1;
                    k=k+1;
                    break;
                }
                j=j+1;
            }
            if(help[j]==null) {
                break;
            }
        }
        return finalString;

    }
    public myString tomyString(Character oneChar){
        myString my=new myString(oneChar.toString());
        return my;

    }

    public String toString(){
        MyArrayList<Character> mychar=this.mainString;
        String resault="";
        for (int i=0;i<mychar.Size();i++){
            resault=resault+mychar.get(i);
        }
        return resault;
    }
}
