public class pila {
    String arreglo[];
    int maxSize;
    int top;
    public pila(){
        arreglo= new String[2];
        top=0;
    }
    /*public pila(int n){
        maxSize=n;
        arreglo = new String[maxSize];
        top = 0;
    }*/
    public boolean empty(){
        if (top==0){
            return true;
        }
        else {
            return false;
        }
    }
    public void push(String str){
        /*if(top<maxSize){
            arreglo[top]=str;
            top++;
        }*/
        if(top<arreglo.length){
            arreglo[top]=str;
            top++;
        }else{
            String temporal[] = new String[arreglo.length+2];
            for(int i = 0; i<arreglo.length;i++){
                temporal[i]=arreglo[i];
            }
            arreglo = temporal;
            arreglo[top]=str;
            top++;
        }
    }
    public String peek(){
        if (top>0) {
            return arreglo[top-1];            
        } else {
            return null;
        }
    }
    public String pop(){
        String temp=null;
        if (top>0) {
            temp= arreglo[top-1];
            arreglo[top-1]=null;
            top--;            
        }
        return temp;
    }
    
}
