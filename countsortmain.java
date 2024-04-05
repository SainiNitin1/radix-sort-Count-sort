public class countsortmain {
    static int [] countSort(int arr[],int n) {
        //  Find the maximum element in array.
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
//frequency array
        int [] arr1=new int[max+1];
        for(int i=0;i<n;i++){
            arr1[arr[i]]++;
        }

//        prefix sum
        int sum=0;
        for(int i =1 ; i < arr1.length;i++){
            arr1[i]=arr1[i]+arr1[i-1];
        }

        int [] arr2=new int[n];
        int i=n-1;
        for (;i>=0;i--){
            arr2[arr1[arr[i]]-1]=arr[i];
            arr1[arr[i]]=arr1[arr[i]]-1;
        }
        return arr2;



    }
    static void display(int [] arr){
        for (int i =0 ;i <arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void main(String[] args) {
        int arr []={1,4,5,2,2,5};
        int [] arr1 = countSort(arr, 6);
        display(arr1);



    }
}
