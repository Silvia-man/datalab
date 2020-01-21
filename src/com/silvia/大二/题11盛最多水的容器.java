package com.silvia.大二;

/**
 * @Author: Silvia
 * @Date: 2020/1/21  21:43
 */
/*
暴力法的优化可以得到双指针法。

我们首先看暴力法，遍历两个数i, j(我们假定i是左边索引，j是右边索引, 方便起见，把两个数看成一个坐标[i, j])
所以我们需要遍历的所有坐标是:

[0, 1], [0, 2], [0, 3] ...[0, n]
[1, 2], [1, 3] ...[1, n]
...
[n-1, n]

如果按以上遍历顺序，我们会发现改进遍历的顺序，会产生非常好的效果，拿第一行来说， 我们遍历到[0,1]坐标时，这个坐标的信息（0和1谁的高度小）不能为我们省去遍历步数， 因为无论这个信息如何，[0,2]比[0,1]宽度增加了一，那[0,2]对应的最大容量就有可能大于[0,1],这种可能是我们必须再必须遍历[0,2]的原因。
但是，如果我们倒转每一行的遍历顺序呢，按以下顺序遍历:
[0, n], [0, n-1], [0, n-2] ...[0, 1]
[1, n], [1, n-1] ...[1, 2]
...
[n, n-1]

首先我们遍历到[0, n], 有两种可能:
第一种可能: 0的高度小于等于n的高度。 这种情况下我们无需再遍历[0, n-1], [0, n-2] ...[0, 1]了，因为后面坐标对应的矩形，首先在宽度上在逐渐减小，高度上又不能比0的大（高度取决于两边最小的高度），所以后面坐标形成的矩形面积不会比[0,n]大了， 即当i=0的坐标，都可以不用遍历了，这其实是削减了i的遍历范围， 从刚开始的0<=i <= n-1 变成了 1<= i <= n-1， 这本质上就是双指针算法里面的左指针右移。

第二种可能：0的高度大于等于n的高度。这种情况下我们无需再遍历 [1, n], [2, n], [3, n] ... [0,n]了， 原因同上， 宽度在逐渐减小， 高度不会大于n对应的高度。即当j=n的坐标都不会遍历了，这其实是削减了j的遍历范围, 从刚开始的1 <=j <= n 变成了 1<= i <= n-1,
这本质上就是双指针算法里面的右指针左移。
我们把以上思路写成代码：
int h[n+1] = { X, X, X, X...}
int i = 0;
int j = n;
int max_value = 0;
while (i < j){
int value = (j-i)*min(h[i], h[j]);
if (value > max_value) max_value = value;
if (h[i] >=h[j]) i++;
else j--;
}

我们发现，这就是双指针算法。
 */
public class 题11盛最多水的容器 {
    //普通做法
    public int maxArea(int[] height) {
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            for(int j = i+1; j <height.length; j++) {
                int min = height[j]>height[i]?height[i]:height[j];
                if ((j-i)*min > max) {
                    max = (j-i)*min;
                }
            }
        }
        return max;
    }

    //双指针法
    public int maxArea2(int[] height) {
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }


}
