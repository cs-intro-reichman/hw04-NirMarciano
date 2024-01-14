public class ArrayOps {
    public static void main(String[] args) { 
        
        int[] arr1 = {3 , 0 , 2};
        int[] arr2 = {0 ,1 ,2, 3, 4, 6};
        int[] arr3 = {0};
        int[] arr4 = {5 ,3 ,1, 6, 4, 2};
        int[] arr5 = {6 ,5 ,4, 3, 2, 1};
        int[] arr6 = {5 ,3 ,1, 6, 4, 2 , 5, 6, 2, 1, 1, 1};
        int[] arr7 = {6 ,5 ,5, 4 ,4, 3, 2, 1};

        /* 
        System.out.println(findMissingInt(arr1) + " " + secondMaxValue(arr1) + " " + maxValue(arr1));
        System.out.println(findMissingInt(arr2) + " " + secondMaxValue(arr2) + " " + maxValue(arr2));
        System.out.println(findMissingInt(arr3) + " " + secondMaxValue(arr3) + " " + maxValue(arr3));
        System.out.println(findMissingInt(arr4) + " " + secondMaxValue(arr4) + " " + maxValue(arr4));
        */

        System.out.println(secondMaxValue(new int[] {6, 9, 4, 7, 3, 4}));
        System.out.println(secondMaxValue(new int[] {1, 2, 3, 4, 5}));
        System.out.println(secondMaxValue(new int[] {2, 8, 3, 7, 8}));
        System.out.println(secondMaxValue(new int[] {1, -2, 3, -4, 5}));
        System.out.println(secondMaxValue(new int[] {-202, 48, 13, 7, 8})); 

        /*
        System.out.println(containsTheSameElements(arr1, arr2));
        System.out.println(containsTheSameElements(arr1, arr3));
        System.out.println(containsTheSameElements(arr2, arr4));
        System.out.println(containsTheSameElements(arr4, arr5));
        System.out.println(containsTheSameElements(arr4, arr6));
        */
        

        //System.out.println(isSorted(arr1) + " " +  isSorted(arr2) + " " +  isSorted(arr3));
        //System.out.println(isSorted(arr4) + " " + isSorted(arr5) + " " +  isSorted(arr6) + " " +  isSorted(arr7));
        
    }
    
    public static int findMissingInt (int [] array) {
        int[] test = new int[array.length+1];
        int num = -2;
        
        for(int q = 0; q < test.length; q++) {
            test[q] = -1;
        }

        for(int i = 0; i < array.length; i++) {
            test[array[i]] = array[i];    
        }

        for(int j = 0; j < test.length; j++ ) {
            if(test[j] == -1)
            num = j;
        }
        return num;
    }

    public static int secondMaxValue(int [] array) {
        int[] newArr = new int[array.length];
        int max = maxValue(array);
        int n = indexOfArr(array, max);
        for(int i = 0; i < array.length; i++) {
            if(array[i] < max)
            newArr[i] = array[i];
            else if(i != n) 
                    return max;
        }

        return maxValue(newArr);
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean check = arrContainsArr(array1, array2) && arrContainsArr(array2, array1);
        return check;
    }

    public static boolean isSorted(int [] array) {
        boolean checkAccend = true;
        boolean checkDeccend = true;
        int n = 1;
        int m = 1;

        if(array.length == 1) return true;

        while(checkAccend && (n < array.length)) {
            if(array[n - 1] < array[n]) 
                checkAccend = false;
            n++;
        }

        while(checkDeccend && (m < array.length)) {
            if(array[m - 1] > array[m])
                checkDeccend = false;
            m++;
        }

        boolean sorted = (checkAccend || checkDeccend);
        return sorted;
    }

    public static int maxValue(int [] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            max = Math.max(max, array[i]);
        }
        return max;
    }

    public static int indexOfArr(int arr[], int n) { 
        for(int i = 0; i < arr.length; i++) { 
            if (arr[i] == n) { 
                return i; 
            } 
        } 
        return -1; 
    } 

    public static boolean arrContainsArr (int[] array1, int[] array2) {
        boolean test = true;
        boolean exist;
        
        for(int i = 0; i < array1.length; i++) {
            exist = false;
            for(int j = 0; j < array2.length; j++) {
                if(array1[i] == array2[j])
                    exist = true;
            }
            test = test && exist;
        }
        return test;
    }

}
