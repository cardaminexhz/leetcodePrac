二分查找的时间复杂度T(n)=O(logn)
作者回复: 哈哈 你要是看到我讲的散列那一篇你就知道了 像java里的hashmap是比较耗内存的 你用到的解决方案是一种用时间复杂度换空间复杂度的思路 我们专栏也会讲的 不过你现在的解决办法还可以更高效 利用hash函数 我们专栏也会讲到 还有二分是logn的时间复杂度 是非常高效的一种时间复杂度 2的64次方个有序数据二分查找也顶多循环64次 有没有觉得logn这个复杂度很奇妙
https://time.geekbang.org/column/intro/100017301

https://blog.csdn.net/qq_35641192/article/details/88914998


https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/

二分查找的核心永远是丢掉不可能有答案的那一半，middle+1的时候是middle不可能为答案的时候，middle不+1的时候是不能排除middle是否为答案的时候

当 while (left < right) 时，对应的更新式是 left = middle + 1 ， right = middle

当 while (left <= right) 时，对应的更新式是 left = middle + 1，right = middle - 1

本题由于【当区间长度为1时，即可停止二分查找】，所以是 while (left < right) ，所以是 left = middle + 1，right = middle


使用mid = left + (right - left) / 2; 而不是 mid = (left + right) / 2;
可避免left right之和过大导致溢出。