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

        int[] count = new int[]{1,0,1,1,0,1};
        countMaxConsecutiveOnes(count);

        int[] arrMiss = new int[]{3,0,1};
        missingNumbers(arrMiss);

        int[] arrSingleElement = new int[]{2,2,1};
        getSingleElement(arrSingleElement);

//        int[] leftArray = new int[]{7, 5, 2, 11, 2, 43, 1, 1};
//        int[] leftArray = new int[]{5, 6, 7, 8};
        int[] leftArray = new int[]{1,2,3,4,5,6,7};
        System.out.println(Arrays.toString(rotateArrayLeft(leftArray, 3)));

        int [] majorArray = new int[]{2,2,1,1,1,2,2};
//        int [] majorArray = new int[]{3,2,3};
        int majorElement = majorityElement(majorArray);
        System.out.println("Major element" +majorElement);

        int[] a = new int[] {1,1,2,2,2,3,3};
        int k = checkDuplicates(a);
        System.out.println("Duplicates Removed from array and its size is " +k );

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

    private static boolean checkSortedArray(int[] a){
        boolean flag = true;

        for(int i = 0; i<a.length - 1; i++){
            if(a[i] > a[i+1]){
                flag = false;
            }
        }
        return flag;
    }

    private static int checkDuplicates(int[] a){
        int i = 0;
        for(int j = 1; j<a.length; j++){
            if(a[i] != a[j]){
                i++;
                a[i] = a[j];
            }
        }
        return i+1;
    }

    private static int[] rotateArrayLeft(int[] arr, int k){
//        int n = arr.length;
//        int[] result = new int[arr.length];
//        for(int i = n-1; i >= 0; i--){
//            result[i % arr.length] = arr[n % arr.length];
//            n--;
//        }
//        return result;
        for(int j = 0; j<k; j++){
            int temp = arr[0];
            for(int i = 0; i<arr.length- 1; i++){
                arr[i] = arr[i+1];
            }
            arr[arr.length - 1] = temp;
        }
        return arr;
    }

    private static int majorityElement(int[] a){
        int majorElementSize = a.length / 2;
        int count = 1;
        int majorElement= 0;
//        for(int i = 0; i< a.length; i++){
//            for (int j = i+1; j<a.length -1; j++){
//                int temp = a[i];
//                if(a[j] < a[i]){
//                    a[i] = a[j];
//                    a[j] = temp;
//                }
//            }
//        }
//        for (int i =0; i< a.length; i++){
//            for(int j =i+1; j< a.length -1; j++){
//                if(a[i] == a[j]){
//                    count ++;
//                } else if (a[i] != a[j]) {
//                    if(count > majorElementSize){
//                        majorElement = a[i];
//                    } else{
//                        count = 1;
//                        i= j;
//                        break;
//                    }
//                }
//            }
//
//        }
        for(int i = 0; i< a.length; i++){
            for(int j =i+1; j< a.length -1; j++){
                if(a[i]== a[j]){
                    count++;
                }
            }
            if(count > a.length/2){
                majorElement = a[i];
            }
        }
        System.out.println("major" + Arrays.toString(a));
        return majorElement;
    }

    private static int missingNumbersMyApproach(int[] a){
        int missingNUm = 0;
        for(int i = 0; i< a.length; i++){
            for (int j = i+1; j<a.length; j++){
                int temp = a[i];
                if(a[j] < a[i]){
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        for (int i =0; i< a.length - 1;i++){
            if(a[i+1] != a[i] + 1){
                missingNUm = a[i] +1;
            }
        }
        System.out.println("missingNBUmber" +missingNUm);
        return missingNUm;
    }

    private static void missingNumbers(int[] a){
        int sum =0;
        int max= (a.length*(a.length +1))/2;
        for(int i = 0;i < a.length; i++){
            sum+=a[i];
        }
        System.out.println("Missing Numbers: "+(max-sum));
    }

    private static void countMaxConsecutiveOnes(int[] a){
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i<a.length;i++){
            if(a[i] == 1){
                count++;
            }else {
                count =0;
            }
            if(count > maxCount){
                maxCount = count;
            }
        }
        System.out.println("Maximum consecutive One's: "+maxCount);
    }

    private static void getSingleElement(int[] a){
        int xorr = 0;
        for (int i = 0; i < a.length; i++) {
            xorr = xorr ^ a[i];
        }
        System.out.println("single element: "+xorr);
    }
}
