public class Arrays1 {
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
    public static void main(String[] args) {
        double[] lotteryNums = {54, 56, 67, 21};//new double[5];
        //accessing an array
        System.out.println(lotteryNums[2]);
        lotteryNums[2] = 40;
        System.out.println(lotteryNums[2]);


        int[] arr = new int[] {92, 12, 38,74};

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

    private static Integer findSecondLargestItem(Integer[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i< arr.length; i++){
            int current = arr[i];
            if (current > largest){
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current != largest) {
                secondLargest = current;
            }
        }
        if (secondLargest == Integer.MAX_VALUE){
            return null;
        }
        return secondLargest;
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
}
