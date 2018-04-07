package sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] list = {1, 4, 5, 5, 6, 8, 3, 3, 2, 9};

        int[] slist = bubbleSort(list);
        System.out.println(Arrays.toString(slist));
    }

    public static int[] bubbleSort(int[] list) {
        int[] resp = list;
        int len = list.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (resp[i] > resp[j]) {
                    int tmp = resp[i];
                    resp[i] = resp[j];
                    resp[j] = tmp;
                }
            }
        }
        return resp;
    }
}
