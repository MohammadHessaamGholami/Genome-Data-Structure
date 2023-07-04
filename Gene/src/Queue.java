/**
 * Created by M.H.GH.K on 12/20/2017.
 */
public class Queue<T> {
    private T[] mainArray;
    private int SizeOfFactory=15;
    private int length=0;
    public Queue(){
        mainArray=(T[]) new Object[SizeOfFactory];
    }

    public void Add(T object){
        if(length<SizeOfFactory) {
            mainArray[length] = object;
            length = length + 1;
        }
        else{
            increaseSizeOfQueue();
            mainArray[length]=object;
            length = length + 1;
        }

    }
    private void increaseSizeOfQueue(){
        SizeOfFactory=SizeOfFactory+15;
        T[] secondArray=(T[]) new Object[SizeOfFactory];
        for(int i=0;i<mainArray.length;i++){
            secondArray[i]=mainArray[i];
        }
        this.mainArray=secondArray;
    }
    public T poll(){
        //Removes and returns the head of the queue. Returns null if queue is empty.
        if(length==0){
            return null;
        }
        T head=mainArray[0];
        length=length-1;
        for(int i=0;i<length;i++){
            mainArray[i]=mainArray[i+1];
        }
        return head;

    }
    public T peek(){
        //To view the head of queue without removing it. Returns null if queue is empty.

        if(length>0){
        return mainArray[0];
        }
        else{
            return null;
        }
    }
    public int length(){
        return length;
    }
    public void Remove(){
        if(length==0){

        }
        else {
            T head = mainArray[0];
            length = length - 1;
            for (int i = 0; i < length; i++) {
                mainArray[i] = mainArray[i + 1];
            }
        }

    }
    public T get(int index){
        return mainArray[index];
    }





}
