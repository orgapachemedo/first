package ShiYanYi.BSearchTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther lwm
 * @Time 2020 - 09 - 15 - 20:39
 */
public class BSearch {

        public static void main(String[] args) {
            int[] arr = {61, 12, 333, 867, 90, 97, 108, 561};
            Arrays.sort(arr);
            for (int i = 0; i <arr.length - 1 ; i++) {
                System.out.println(arr[i]);
            }
            Scanner in = new Scanner(System.in);
            System.out.println("请输入需要查找的数字：");
            System.out.println(binarySearch(arr, 0, arr.length - 1, in.nextInt()));
        }


          private static int binarySearch(int[] arr, int start, int end, int key) {

            if (key < arr[start] || key > arr[end] || start > end) {
                return -1;
            }

            int mid = (start + end) / 2;
            if (key > arr[mid]) {
                return binarySearch(arr, mid + 1, end, key);
            } else if (key < arr[mid]) {
                return binarySearch(arr, start, mid - 1, key);
            } else {
                return mid + 1;
            }
        }
    }

