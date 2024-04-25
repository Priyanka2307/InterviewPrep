import java.util.Arrays;

public class Arrays1 {
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public static void main(String[] args) {
        double[] lotteryNums = {54, 56, 67, 21};//new double[5];
        //accessing an array
        System.out.println(lotteryNums[2]);
        lotteryNums[2] = 40;
        System.out.println(lotteryNums[2]);


        int[] arr = new int[] {1,2,3,4};
        reverseArray(arr);

        Object[] arrRotate = new Object[]{1,2,3,4};
        System.out.println(Arrays.toString(rotateArray(arrRotate)));

        Object[] aarrMoveZero = new Object[]{0,0,1,1,1,0};
        System.out.println(Arrays.toString(moveZerosToEnd(aarrMoveZero)));

        Object[] aarrMoveZero1 = new Object[]{0,0,1,2,3,4,5,0};
        System.out.println(Arrays.toString(moveZerosToEnd(aarrMoveZero1)));

        Integer[] array = new Integer[]{1,2,3,4};
        displaysTriangle(array);

        Character[] charArray = new Character[]{'A', 'B', 'C', 'D', 'E'};
        displaysTriangle(charArray);

        String[] strArray = new String[]{"Hello","There","Friend"};
        displaysTriangle(strArray);

        for(int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
        System.out.println();

        for (int i = arr.length-1; i>=0; i--){
            System.out.println(arr[i]);
        }
        System.out.println();

        for (int i = arr.length-1; i>=0; i= i-2){
            System.out.println(arr[i]);
        }
        System.out.println();

        for (int item : arr){
            System.out.println(item);
        }
        System.out.println();

        java.util.Arrays.stream(arr).forEach(System.out::println);

        Integer[] arr1 = new Integer[]{10,9,77,9};
        System.out.println("largest item is : " +findLargestItem(arr1));

        Integer[] sample1 = new Integer[]{5, 8,3,2,6};
        System.out.println("Second Largest item is : " +findSecondLargestItem(sample1));

        Integer[] sample2 = new Integer[]{5, 8,3,2,6};
        System.out.println("Second smalled item is : " +findSecondSmallestItem(sample2));

        Integer[] arr2 = new Integer[]{3,3,3,3};
        System.out.println("Second smallest iten in arr2 is :" +findSecondSmallestItem(arr2));

        Integer[] arr3 = new Integer[]{};
        System.out.println("Second smallest iten in arr3 is :" +findSecondSmallestItem(arr3));

        Integer[] arr4 = new Integer[]{3};
        System.out.println("Second smallest iten in arr4 is :" +findSecondSmallestItem(arr4));
    }

    private static Integer findSecondSmallestItem2(Integer[] sample1) {
        if(sample1.length <= 1){
            return null;
        }
        else{
            for (int i = 0; i< sample1.length-1; i++){
                for (int j = i+1; j< sample1.length-1; j++){
                    int temp = 0;
                    if (sample1[j] < sample1[i]){
                        temp = sample1[j];
                        sample1[j] = sample1[i];
                        sample1[i] = temp;
                    }
                }
            }
        }
        for (int i =0; i<sample1.length - 1; i++){
            if(sample1[i] != sample1[i+1]){
                return sample1[i+1];
            }
        }
        return null;
    }

    private static Integer findSecondSmallestItem(Integer[] arr){
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int i = 0; i< arr.length; i++){
            int current = arr[i];
            if (current < smallest){
                secondSmallest = smallest;
                smallest = current;
            } else if (current < secondSmallest && current != smallest) {
                secondSmallest = current;
            }
        }
        if (secondSmallest == Integer.MAX_VALUE){
            return null;
        }
        return secondSmallest;
    }

    private static Integer[] findSecondLargestItem(Integer[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MIN_VALUE;

        for (int i = 0;i < arr.length;i++)
        {
            smallest = Math.min(smallest,arr[i]);
            largest = Math.max(largest,arr[i]);
        }
        for (int i = 0; i< arr.length; i++){
            int current = arr[i];
            if (current > secondLargest && current != largest ){
                secondLargest = current;
            }
            if (current < secondSmallest && current != smallest) {

            }
        }
        Integer[] result = new Integer[]{secondLargest, secondSmallest};
        return result;
    }

    private static Integer findLargestItem(Integer[] arr){
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i< arr.length; i++){
            int current = arr[i];
            if (current > largest){
                largest = current;
            }
        }
        if (largest == Integer.MAX_VALUE){
            return null;
        }
        return largest;
    }

//    private static void displaysTriangle(Integer[] arr){
//        for(int i =0; i<arr.length; i++){
//            for(int j= 0; j<= i; j++){
//                System.out.print(arr[j]);
//            }
//            System.out.println();
//        }
//    }

    private static void displaysTriangle(Object[] arr){
        for(int row =0; row<arr.length; row++){
            for(int col= 0; col<= row; col++){
                System.out.print(arr[col]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static Object[] rotateArray(Object[] arr){
        Object[] result = new Object[arr.length];
        for(int i=0; i< arr.length; i++){
            result[(i+1) % arr.length] = arr[i];
        }
        return result;
    }

    private static Object[] moveZerosToEnd(Object[] arr){
//        for(int i =0; i< arr.length; i++){
//            for (int j = i+1; j< arr.length; j++){
//                if (arr[i].equals(0) && !arr[j].equals(0)){
//                    arr[i] = arr[j];
//                    arr[j] = 0;
//                    break;
//                }
//            }
//        }
        int count = 0;
        for (int i =0; i<arr.length; i++){
            if (!arr[i].equals(0)){
                arr[count] = arr[i];
                count++;
            }
        }
        while (count < arr.length){
            arr[count] =0;
            count++;
        }
        return arr;
    }

    public static void reverseArray(int[] arr){
        for (int i = 0; i< arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
