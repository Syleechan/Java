import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/3/15 17:52
 * @description：
 */

public class Merge {


    @Test
    public void test1(){
        int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);

        StringBuilder sb = new StringBuilder();

        StringBuffer stringBuffer = new StringBuffer();

        HashMap<Character, int[]> map = new HashMap<>();

        int a = 'a' - 65;
        System.out.println(a);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(String.join(".", list));
        String.join(".", list);


        int[] nums = {1,2,3,0,0,0};
        int[] nums1 = {2,5,6};
        //System.out.println(largestRectangleArea(nums));

        char[][] matrix = {{'1','0','1','0','0'},{'1', '0', '1', '1', '1'},{'1', '0', '1', '1', '1'},{'1','0','0','1','0'}};

        merge(nums, 3, nums1, 3);
        System.out.println(5 << 1);

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // if(n == 0)return;
        // int i = 0, j = 0;
        // while(i < m + n && j < n){
        //     while(nums1[i] <= nums2[j] && i < m){
        //         i++;
        //     }

        //     for(int k = m - 1; k >= i; k--){
        //         nums1[k + 1] = nums1[k];
        //     }
        //     m++;
        //     nums1[i] = nums2[j];
        //     j++;


        // }
        int i = 0, j = 0;
        int[] temp = new int[m + n];
        for(int k = 0; k < temp.length; k++){
            if(nums1[i] <= nums2[j] && i < m){
                temp[k] = nums1[i++];
            }else{
                temp[k] = nums2[j++];
            }
        }
        int[] ints = Arrays.copyOf(temp, m + n);

    }


    public int maximalRectangle(char[][] matrix) {
        //暴力 37.26
        // if(matrix.length == 0)return  0;
        // int row = matrix.length;
        // int col = matrix[0].length;
        // int[][] nums = new int[row][col + 1];
        // for(int i = 0; i < row; i++){
        //     for(int j = 1; j < col + 1; j++){
        //         if(matrix[i][j - 1] == '1'){
        //             nums[i][j] = nums[i][j - 1] + 1;
        //         }else{
        //             nums[i][j] = 0;
        //         }
        //     }
        // }

        // int res = 0;
        // for(int i = row - 1; i >= 0; i--){
        //     for(int j = col; j > 0; j--){
        //         if(nums[i][j] == 0)continue;
        //         int len = nums[i][j];
        //         int width = 0;
        //         for(int k = i - 1; k >=0; k--){
        //             len = Math.min(len, nums[k][j]);
        //             width = i - k + 1;
        //             res = Math.max(res, len * width);
        //         }
        //         //计算完再和自身比较
        //         res = Math.max(res, nums[i][j]);
        //     }
        // }

        // return res;

        if(matrix.length == 0)return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] heights = new int[col];

        int res = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }

            res = Math.max(res, getMaxArea(heights));
        }

        return res;

    }

    public int getMaxArea(int[] nums){
        int len = nums.length;

        int res = 0;
        Deque<Integer> st = new ArrayDeque<>();

        int[] heights = new int[len + 2];
        heights[0] = 0;
        for(int i = 1; i < len + 1; i++){
            heights[i] = nums[i - 1];
        }
        heights[len + 1] = 0;

        st.addLast(0);
        for(int i = 1; i < len; i++){
            while(heights[i] < heights[st.peekLast()]){
                int height = heights[st.removeLast()];
                int width = i - st.peekLast() - 1;
                res = Math.max(res, height * width);
            }
            st.addLast(i);
        }

        return res;
    }



    public int largestRectangleArea(int[] heights) {
        // int len = heights.length;
        // int leftMax = 0, rightMax = 0, res = 0;

        // for(int i = 0; i < len; i++){
        //     int left = i - 1;
        //     while(left >= 0 && heights[left] >= heights[i]){
        //         left--;
        //     }
        //     int right = i + 1;
        //     while(right <= len - 1 && heights[right] >= heights[i]){
        //         right++;
        //     }
        //     res = Math.max((right - left - 1) * heights[i], res);
        // }

        // return res;

        int len = heights.length;
        if(len == 0)return 0;
        if(len == 1)return heights[0];

        int res = 0;

        Deque<Integer> st = new ArrayDeque<>();


        for(int i = 0; i < len; i++){
            int height = 0;
            while(!st.isEmpty() && heights[i] <= heights[st.peekLast()]){
                height = heights[st.removeLast()];
            }
            int width = st.isEmpty() ? i : i - st.peekLast() - 1;
            res = Math.max(res, width * height);
            st.addLast(i);
        }

        while(!st.isEmpty()){
            int height = heights[st.peekLast()];
            int width = st.isEmpty() ? len : len - st.peekLast() - 1;
            res = Math.max(res, width * height);
        }

        return res;



    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int left = 0, right = 1;
        int len = nums.length;
        int count = 0;
        while(right < len){
          if(nums[left] == nums[right]){
              left++;
              right++;
              int pivot = left + 1;
              while(nums[left] == nums[right] && right < len){
                  right++;
                  count++;
              }
              while(right < len){
                  nums[pivot++] = nums[right++];
              }
              len -= count;
              count = 0;
              right = left + 1;
          }else{
              left++;
              right++;
          }
        }
        return len;


    }




    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];


        dfs(res, list, nums, 0, visited);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums, int i, boolean[] visited){
        if(i <= nums.length) {
            res.add(new ArrayList<>(list));
        }

            if(i > nums.length){
                return;
            }

            while(i < nums.length){
                if(!visited[i]){
                    visited[i] = true;
                    list.add(nums[i]);
                    dfs(res, list, nums, i + 1, visited);
                }
                visited[i] = false;
                list.remove(list.size() -1);
                i++;

            }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        // 为了防止底层动态数组扩容，初始化的时候传入最大长度
        Deque<Integer> path = new ArrayDeque<>(k);
        //dfs(1, n, k, path, res);
        return res;
    }

//    private void dfs(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> res) {
//        if (k == 0) {
//            res.add(new ArrayList<>(path));
//            return;
//        }
//
//        // 基础版本的递归终止条件：if (begin == n + 1) {
//        if (begin > n - k + 1) {
//            return;
//        }
//        // 不选当前考虑的数 begin，直接递归到下一层
//        dfs(begin + 1, n, k, path, res);
//
//        // 不选当前考虑的数 begin，递归到下一层的时候 k - 1，这里 k 表示还需要选多少个数
//        path.addLast(begin);
//        dfs(begin + 1, n, k - 1, path, res);
//        // 深度优先遍历有回头的过程，因此需要撤销选择
//        path.removeLast();
//    }



//    public void recursive(List<List<Integer>> res, List<Integer> list, int[] arr, int index, boolean[] visited){
//        if(list.size() == arr[0] - 1){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for(int i = index; i < arr.length; i++){
////            if(visited[arr[i]])break;
////            visited[arr[i]] = true;
//            list.add(arr[i]);
//            recursive(res, list, arr, i + 1, visited);
//            list.remove(list.size() - 1);
////            visited[arr[i]] = false;
//        }
//    }



    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;


        int start = 0, end = row - 1;
        int mid = (start + end) / 2;
        while(start <= end){
            mid = (start + end) / 2;
            if(matrix[mid][0] < target){
                start = mid + 1;
            }else if(matrix[mid][0] > target){
                end = mid - 1;
            }else{
                return true;
            }
        }

        int pivot = mid;
        start = 0;
        end = col - 1;
        while(start <= end){
            mid = (start + end) / 2;
            if(matrix[pivot][mid] < target){
                start = mid + 1;
            }else if(matrix[pivot][mid] > target){
                end = mid - 1;
            }else{
                return true;
            }
        }

        return false;


    }

    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "/";
        }
        int len = path.length();
        List<String> names = new ArrayList<>();
        //获取每个目录名称
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) != '/') {
                int j = i;
                while (j < len && path.charAt(j) != '/') {
                    j++;
                }
                names.add(path.substring(i, j));
                i = j;

            }
        }
        List<String> res = new ArrayList<>();
        //构造路径
        for (int i = 0; i < names.size(); i++) {
            //如果目录名称为"..",需要特殊判断
            if (names.get(i).equals("..")) {
                //如果此时路径还有目录,则返回上一级;否则,忽略它
                if (res.size() > 0)
                    res.remove(res.size() - 1);
            } else if (!names.get(i).equals(".")) {
                //如果目录名称不为"."(即当前目录),则加入路径
                res.add(names.get(i));
            }
            //如果上述情况都没匹配到,则说明该目录名称为"."(即当前目录),直接忽略
        }
        return "/" + String.join("/", res);
    }





    public String addBinary(String a, String b) {
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int res = 0;
        while(len1 >= 0 && len2 >= 0){
            int num1 = a.charAt(len1) - '0';
            int num2 = b.charAt(len2) - '0';
            int num = num1 + num2;
            res = num / 2;
            num %= 2;
            sb.append(num);
            len1--;
            len2--;
        }

        while(len1 >= 0){
            int num1 = a.charAt(len1) - '0';
            int num = num1 + res;
            res = num / 2;
            num %= 2;
            sb.append(num);
            len1--;
        }

        while(len2 >= 0){
            int num2 = b.charAt(len1) - '0';
            int num = num2 + res;
            res = num / 2;
            num %= 2;
            sb.append(num);
            len2--;
        }

        if(res == 1)sb.append(res);

        return sb.reverse().toString();




    }


    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int res = 0;
        int[] num = new int[len + 1];
        digits[len - 1] += 1;
        for(int i = len - 1; i >= 0; i--){
            if(digits[i] + res >= 10){
                digits[i] = digits[i] + res;
                res = digits[i] / 10;
                num[i] = digits[i] % 10;
            }else{
                res = 0;
                num[i] = digits[i];
            }
        }

        if(num[0] == 0){
            digits = Arrays.copyOfRange(num, 1, len + 1);
            return digits;
        }else{
            return num;
        }
    }


    public boolean isNumber(String s) {
        s = s.trim();

        boolean pointSeen = false;//.
        boolean eSeen = false;//e or E
        boolean numberSeen = false;//0 -9
        boolean numberAfterE = true;// e 后面 0- 9
        boolean sign = false;
        for(int i=0; i<s.length(); i++) {
            if('0' <= s.charAt(i) && s.charAt(i) <= '9') {//数字
                numberSeen = true;
                numberAfterE = true;
            } else if(s.charAt(i) == '.') {//小数
                if(eSeen || pointSeen) {//多个点，e在点前面
                    return false;
                }
                pointSeen = true;
            } else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(eSeen || !numberSeen) {//e前面没有数字或已经出现了e
                    return false;
                }
                numberAfterE = false;//置为false，方便后面看是出现数字
                eSeen = true;
            } else if(s.charAt(i) == '-' || s.charAt(i) == '+') {
                if(i != 0) {//+-不在首位 且+-前面不是e,之前已经判断了e前面有数字
                    char ch = s.charAt(i - 1);
                    if(ch != 'e' || ch != 'E')
                        return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }





    public String getPermutation(int n, int k) {
        // StringBuilder sb = new StringBuilder();
        // List<String> list = new ArrayList<>();

        // int[] arr = new int[n];
        // for(int i = n - 1; i >= 0; i--){
        //     arr[i] = n--;
        // }

        // permutation(list, arr, sb, 0);

        // List<String> res = list.stream().sorted().collect(Collectors.toList());

        // return res.get(k - 1);
        int[] pos = new int[n];
        pos[0] = 1;
        for(int i = 1; i < pos.length; i++){
            pos[i] = pos[i - 1] * i;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        k--;
        for(int i = n - 1; i >= 0; i--){
            int index = k / pos[i];
            int t = list.remove(index);
            sb.append(t);

            k -= pos[i] * index;
        }

        return sb.toString();



    }

    public int[][] merge(int[][] intervals){
        int size = intervals.length;
        List<int[]> list = new ArrayList<>();
        boolean[] flag = new boolean[size];
        for (int i = 0; i < intervals.length; i++) {
            for(int j = i + 1; j < intervals.length; j++){
                if(intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][0] ){
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    flag[i] = true;
                    break;
                }else if(intervals[i][0] >= intervals[j][0] && intervals[i][0] <= intervals[j][1] ){
                    intervals[j][0] = Math.min(intervals[i][0], intervals[j][0]);
                    intervals[j][1] = Math.max(intervals[i][1], intervals[j][1]);
                    flag[i] = true;
                    break;
                }
            }
        }
        int count = 0;
        for(int i = 0; i < intervals.length; i++){
            if(!flag[i]){
                count++;
            }
        }
        int[][] res = new int[count][2];
        count = 0;
        for (int i = 0; i < intervals.length; i++){
            if(!flag[i]){
                res[count++] = intervals[i];
            }
        }

        return res;
    }



    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        if(intervals.length == 0){
            list.add(newInterval);
            return (int[][]) list.toArray();
        }

        for(int i = 0; i < intervals.length; i++){
            if(intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]){
                newInterval[0] = intervals[i][0];
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }else if(intervals[i][0] <= newInterval[1] && newInterval[1] <= intervals[i][1]){
                newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
                newInterval[1] = intervals[i][1];
            }else if(intervals[i][0] > newInterval[1]){
                list.add(newInterval);
            }else if(intervals[i][1] < newInterval[0]){
                list.add(intervals[i]);
            }
        }

        return (int[][]) list.toArray();
    }
}