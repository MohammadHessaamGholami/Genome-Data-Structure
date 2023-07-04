/**
 * Created by M.H.GH.K on 12/15/2017.
 */

public class MyArrayList<T> {
    private static final int SIZE_FACTOR=20;
    private T[] data;

    public int Size() {
        return index;
    }

    private int index;
    private int size;
    public MyArrayList(){
        this.data=(T[]) new Object[SIZE_FACTOR];
        this.size=SIZE_FACTOR;
    }
    public void add(T obj){
        if(this.index==this.size-1){
            //we need to increase the size of data[]
            increaseSizeAndReallocate();
        }
        data[this.index]=obj;
        this.index++;
    }
    private void increaseSizeAndReallocate() {
        this.size=this.size+SIZE_FACTOR;
        T newData[]=(T[]) new Object[this.size];
        for(int i=0; i<data.length;i++){
            newData[i]=data[i];
        }
        this.data=newData;
    }
    public T get(int index){
        try{
            return this.data[index];
        }
        catch (Exception e){

        }
        return null;
        /*
        if(index>this.index-1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(index<0){
            throw new Exception("Negative Value");
        }
        */


    }
    public void remove(int index) throws Exception{
        if(index>this.index-1){
            throw new Exception("ArrayIndexOutOfBound");
        }
        if(index<0){
            throw new Exception("Negative Value");
        }
        for(int x=index; x<this.data.length-1;x++){
            data[x]=data[x+1];
        }
        this.index--;
    }

    public boolean contains(T object){
        for(int i=0; i<data.length;i++){
            if (data[i]==object){
                return true;
            }
        }
        return false;
    }

    public T getLast(){
        return data[index-1];
    }
}
