package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 两数相加
 * <p>
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Maintel
 * @create 2019-11-07 0:41
 **/
public class Day1 {

    public static void main(String[] args) {

        ListNode in1 = new ListNode(2);
        in1.next = new ListNode(4);
        in1.next.next = new ListNode(3);

        ListNode in2 = new ListNode(5);
        in2.next = new ListNode(6);
        in2.next.next = new ListNode(4);
//        ListNode out = addTwoNumbers(in1, in2);
//        ListNode out = addTwoNumbers2(in1, in2);
//        ListNode out = addTwoNumbers3(in1, in2);
        ListNode out = addTwoNumbers4(in1, in2);
        do {
            System.out.println(out.val);
            out = out.next;
        } while (out.next != null);
        System.out.println(out.val);
    }


    public static ListNode addTwoNumbers4(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            // curr相当于一个指针 在最开始的时候指向 dummyHead
            // 当 curr.next 的时候，也同时给 dummyHead 设置了 next，
            //  然后给curr 重新赋值，即 移动了curr 移动到 dummyHead.next
            // 当再次循环时， curr.next 赋值时，也同时给 dummyHead.next.next 赋值了。
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    /**
     * 解法三， 只进行一趟遍历，就把所有的值都求出来，并生成链表
     * 这个解法的问题之处在于，生成链表时的多趟查询问题，怎么能快速的生成链表将是解决问题的关键
     *  3 ms	45.3 MB  73.37%
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode out = null;
        boolean shouldAdd = false;
        do {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) {
                val = l2.val;
                l2 = l2.next;
            } else {
                val = l1.val;
                l1 = l1.next;
            }

            // 是否有进位
            if (shouldAdd) {
                val = val + 1;
                shouldAdd = false;
            }
            // 只取个位数
            if (val >= 10) {
                val = val - 10;
                shouldAdd = true;
            }

            if (out == null) {
                out = new ListNode(val);
            } else if (out.next == null) {
                out.next = new ListNode(val);
            } else {
                ListNode next = out.next;
                while (next.next != null) {
                    next = next.next;
                }
                next.next = new ListNode(val);
            }
        } while ((l1 != null && l1.next != null) || (l2 != null && l2.next != null));
        int val = 0;
        if (l1 != null && l2 != null) {
            val = l1.val + l2.val;
        } else if (l2 != null) {
            val = l2.val;
        } else if (l1 != null) {
            val = l1.val;
        }
        if (shouldAdd) {
            val = val + 1;
        }
        if (val >= 10) {
            val = val - 10; // 用减法比用 % 求余更快
            if (out.next == null) {
                out.next = new ListNode(val);
                out.next.next = new ListNode(1);
            } else {
                ListNode next = out.next;
                while (next.next != null) {
                    next = next.next;
                }
                next.next = new ListNode(val);
                next.next.next = new ListNode(1);
            }
        } else if (val != 0) {
            if (out.next == null) {
                out.next = new ListNode(val);
            } else {
                ListNode next = out.next;
                while (next.next != null) {
                    next = next.next;
                }
                next.next = new ListNode(val);
            }
        }
        return out;
    }

    /**
     * 解法二 逐位计算,并将计算结果放入一个 list 中，然后遍历 list 生成链表
     * 4 ms	43.9 MB   58.85%
     *
     * @param l1
     * @param l2
     * @return
     */

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        List<Integer> list = new ArrayList<>();
        boolean shouldAdd = false;
        do {
            int val = 0;
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l2 != null) {
                val = l2.val;
                l2 = l2.next;
            } else {
                val = l1.val;
                l1 = l1.next;
            }

            // 是否有进位
            if (shouldAdd) {
                val = val + 1;
                shouldAdd = false;
            }
            // 只取个位数
            if (val >= 10) {
                val = val - 10;
                shouldAdd = true;
            }
            list.add(val);
        } while ((l1 != null && l1.next != null) || (l2 != null && l2.next != null));
        int val = 0;
        if (l1 != null && l2 != null) {
            val = l1.val + l2.val;
        } else if (l2 != null) {
            val = l2.val;
        } else if (l1 != null) {
            val = l1.val;
        }
        if (shouldAdd) {
            val = val + 1;
        }
        if (val >= 10) {
            val = val - 10; // 用减法比用 % 求余更快
            list.add(val);
            list.add(1);
        } else if (val != 0) {
            list.add(val);
        }

        ListNode out = null;
        for (int i = list.size() - 1; i >= 0; i--) {
            ListNode listNode = new ListNode(list.get(i));
            listNode.next = out;
            out = listNode;
        }
        return out;
    }


    /**
     * 解法一 先将链表中的数放到字符串中，然后反转字符串，转换成int
     * 然后计算和，接着再把int 转成字符串倒叙放到链表中
     * <p>
     * 但是这个算法有问题，如果有超大的数，则会出现存不下的情况，所以不可行
     */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Long num = getNum(l1) + getNum(l2);
        System.out.println(num);
        StringBuffer s = new StringBuffer(String.valueOf(num));
        ListNode out = null;
        for (int i = 0; i < s.length(); i++) {
            ListNode listNode = new ListNode(Integer.parseInt(String.valueOf(s.charAt(i))));
            listNode.next = out;
            out = listNode;
        }
        return out;
    }

    public static Long getNum(ListNode in) {
        if (in == null) {
            return 0l;
        }
        StringBuffer s1 = new StringBuffer();
        do {
            s1.append(in.val);
            in = in.next;
        } while (in != null && in.next != null);
        if (in != null) {
            s1.append(in.val);
        }
        s1.reverse();
        System.out.println(s1.toString());
        return Long.parseLong(s1.toString());
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
