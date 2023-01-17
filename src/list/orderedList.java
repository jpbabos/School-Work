package list;

public class orderedList {
    int[] list;
    int numOfItems;

    public orderedList(int size){
        list = new int[size];
        numOfItems = 0;
    }
    public boolean isEmpty(){
        return numOfItems == 0;
    }
    public boolean isFull(){
        return numOfItems == list.length;
    }
    public int binarySearch(int key){
        int low = 0 ;
        int high = numOfItems -1;
        int mid;
        while(low <= high){
            mid = (low+high)/2;
            if(key == list[mid])
                return mid;
            else if(key < list[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
    public void insert(int value){
        if (!isFull()) {
            int index = binarySearch(value);
            // for (index = 0; index < numOfItems; index++) {
            //     if (list[index] > value) break;
            // }
            for (int i = numOfItems; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = value;
            numOfItems++;
        } else {
            System.out.println("List is full");
        }
    }
    public boolean delete(int value){
        if(!isEmpty()){
            int index = binarySearch(value);
            if(index == -1)
                return false;
            else{
                for(int i = index; i < numOfItems; i++){
                    list[i] = list[i+1];
                }
                numOfItems--;
                return true;
            }
        }
        else{
            return false;
        }
    }
    public void display(){
        for(int i = 0 ; i < numOfItems; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println("");
    }
    public void merge(int[] array1, int[] array2){
        for (int i = 0; i < array1.length; i++){
            this.insert(array1[i]);
        }
        for (int i = 0; i < array2.length; i++){
            this.insert(array2[i]);
        }
    }
}
