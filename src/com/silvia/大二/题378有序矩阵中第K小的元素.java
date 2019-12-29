package com.silvia.大二;

import java.util.Arrays;
//再看一遍！！！写博客！！！

/**
 * @Author: Silvia
 * @Date: 2019/12/22  19:17
 */
/*
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第k小元素，而不是第k个元素。

示例:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

返回 13。
 */
public class 题378有序矩阵中第K小的元素 {
    public int kthSmallest(int[][] matrix, int k) {
        int col = matrix[0].length;
        int row = matrix.length;
        int left = matrix[0][0];
        int right = matrix[row-1][col-1];

        if (k == 1) {
            return left;
        } else if (k == row * col) {
            return right;
        }

        while (left < right) {
            int mid = (left + right) / 2;
            int count = findNoBiggerThanMid(matrix, mid, row, col);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private int findNoBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = row - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < col) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    public int kthSmallest2(int[][] matrix, int k) {

        int[] int1d;
        int len = 0;
        for (int[] element : matrix) {
            len += element.length;
        }
        int1d = new int[len];
        int index = 0;
        for (int[] array : matrix) {
            for (int element : array) {
                int1d[index++] = element;
            }
        }

        Arrays.sort( int1d );

        return int1d[k-1];
    }
}
