public class RadixSort {
    static int findMax(int arr []){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    static void display(int [] arr){
        for (int i =0 ;i <arr.length;i++){
            System.out.println(arr[i]);
        }
    }



    static void countSort(int arr[],int place) {
        int max = findMax(arr);
        int n = arr.length;
//frequency array
        int [] arr1=new int[10];
        for(int i=0;i<n;i++){
            arr1[(arr[i]/place)%10]++;
        }

//        prefix sum
        int sum=0;
        for(int i =1 ; i < arr1.length;i++){
            arr1[i]=arr1[i]+arr1[i-1];
        }

        int [] arr2=new int[n];
        int i=n-1;
        for (;i>=0;i--){
            arr2[arr1[(arr[i]/place)%10]-1]=arr[i];
            arr1[(arr[i]/place)%10]--;
        }
//        copying similar elements in initial array
        for(i =0;i<n;i++){
            arr[i]=arr2[i];
        }
    }

    static void RadixSort(int arr []){
        int place=1;
        int max=findMax(arr);

        for(;max/place>0;place*=10){
            countSort(arr,place);
        }

    }

    public static void main(String[] args) {
        int arr [] = {312,324,802,201,103,21};


        RadixSort(arr);
        display(arr);
    }
}
