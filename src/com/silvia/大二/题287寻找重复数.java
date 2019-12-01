package com.silvia.大二;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * 说明：
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 */
class 题287寻找重复数 {
    // 将数组看成链表，val是结点值也是下个节点的地址。因此这个问题就可以转换成判断链表有环，且找出入口节点

    /**
     * 设：slow指针移动速度为1，fast指针移动速度为2；slow指针在环内移动（非环部分）长度为a，slow指针在环内移动长度为b
     * 两指针相遇时候，slow指针移动距离为a+b，fast指针移动距离为2(a+b)，可知两指针距离差a+b即为整数倍的环长
     * 从head移动a的距离为入环点；由2可知从head开始移动a+(a+b)的距离也为入环点，即将A点继续移动距离a则可到达入环点
     * 将slow指针移动回head，同时同速移动两个指针，相遇点即为入环点
     */
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        } while (fast != slow);

        int find = 0;
        do {
            find = nums[find];
            slow = nums[slow];
        } while (find != slow);
        return find;
    }

}
