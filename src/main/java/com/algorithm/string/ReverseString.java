package com.algorithm.string;

/**
 * @version 1.0
 * @ProjectName: learning
 * @Package: com.algorithm.string
 * @ClassName: ReverseString
 * @Author: Administrator
 * @CreateDate: 2019/11/23 16:49
 * @Description: 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题
 *
 * 不考虑编码问题
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseString {
    public void solution(char[] str) {

        char c;
        for (int i = 0, j = str.length - 1; i < j; i ++, j --){
            c = str[i];
            str[i] = str[j];
            str[j] = c;
        }
    }
}
