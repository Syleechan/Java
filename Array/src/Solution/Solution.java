package Solution;

import javafx.util.Pair;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/2 22:25
 * @description：
 */

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;

        }

        ListNode(int x, ListNode next){
            val = x;
            this.next = next;
        }

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }




    public void reorderList(ListNode head) {
        ListNode cur = head;
        ListNode rightCur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }

        if(len <= 2)return;

        int pivot = (len + 1) / 2;

        while(--pivot > 0){
            rightCur = rightCur.next;
        }

        ListNode rightStart = rightCur.next;
        rightCur.next = null;
        ListNode leftStart = head;

        rightStart = headInsert(rightStart);
        head = reorder(leftStart, rightStart);

        return;
    }

    public ListNode headInsert(ListNode node){
        ListNode dummy = new ListNode(-1);
        while(node != null){
            ListNode next = node.next;
            node.next = dummy.next;
            dummy.next = node;
            node = next;
            if(next == null)break;
            next = next.next;
        }

        return dummy.next;
    }


    public ListNode reorder(ListNode leftStart, ListNode rightStart){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(leftStart != null && rightStart != null){
            cur.next = leftStart;
            leftStart = leftStart.next;
            cur = cur.next;
            cur.next = rightStart;
            rightStart = rightStart.next;
            cur = cur.next;
        }

        if(leftStart != null)cur.next = leftStart;

        return dummy.next;

    }



    @Test
    public void  test(){

        ListNode tail1 = new ListNode(3);
        ListNode tail = new ListNode(1, tail1);
        ListNode cur = new ListNode(2, tail);
        ListNode head = new ListNode(4, cur);


        //reorderList(head);
        System.out.println(head);

        //LinkedList<Integer> list = new LinkedList<>();

        System.out.println(sortList(head));

        int a = 23;


    }


    @Test
    public void test5(){
       String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        //System.out.println(evalRPN(tokens));

        String str = "  Bob    Loves  Alice   ";
        String[] strs = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();

    }

    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for(String str : tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                String b = stack.pop();
                String a = stack.pop();
                stack.push(String.valueOf(jugdge(str, a, b)));
            }else{
                stack.push(str);
            }
        }

        return Integer.parseInt(stack.pop());
    }



    public int jugdge(String str, String a, String b){
        int a1 = Integer.parseInt(a);
        int b1 = Integer.parseInt(b);
        switch(str){
            case "+" : return a1 + b1;
            case "-" : return a1 - b1;
            case "*" : return a1 * b1;
            case "/" : return a1 / b1;
        }

        return -1;
    }


    public ListNode sortList(ListNode head) {

        if(head == null || head.next == null)return head;

        ListNode rightStart = getRightStartNode(head);

        ListNode left = sortList(head);
        ListNode right = sortList(rightStart);

        return mergeSort(left, right);
    }

    public ListNode getRightStartNode(ListNode head){
        if(head == null || head.next == null)return head;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightStart = slow.next;
        slow.next = null;

        return rightStart;

    }

    public ListNode mergeSort(ListNode leftStart, ListNode rightStart){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(leftStart != null && rightStart != null){
            cur.next = leftStart.val < rightStart.val ? leftStart : rightStart;
            cur = cur.next;
            cur.next = leftStart.val >= rightStart.val ? rightStart : leftStart;
            cur = cur.next;

            leftStart = leftStart.next;
            rightStart = rightStart.next;
        }

        if(leftStart != null)cur.next = leftStart;
        if(rightStart != null)cur.next = rightStart;

        return dummy.next;

    }

    @Test
    public void Test1(){
        TreeNode node7 = new TreeNode(7);
        TreeNode node2= new TreeNode(2);
        TreeNode node11 = new TreeNode(11, node7, node2);
        TreeNode node4 = new TreeNode(4, node11,null);

//        Hashtable
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node44 = new TreeNode(4, node5, node1);
        TreeNode node13 = new TreeNode(13);
        TreeNode node8 = new TreeNode(8, node13, node44);

        TreeNode root = new TreeNode(5, node4, node8);
        
        List<Integer> list = new ArrayList<>();

        pathSum(root, 22);



        //System.out.println(pathSum(root, 22));

        System.out.println(sumNumbers(root));

        System.out.println(minDepth(root));

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.keySet();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer value = entry.getValue();
            Integer key = entry.getKey();

        }
    }


    public int minDepth(TreeNode root) {
        return preorder(root);
    }

    public int preorder(TreeNode root){
        if(root == null)return 0;

        int left = preorder(root.left) + 1;
        int right = preorder(root.right) + 1;

        if(root.left == null || root.right == null){
            return root.left == null ? right : left;
        }
        return Math.min(left, right);
    }


    public int sumNumbers(TreeNode root) {
        return preorder(root, 0);
    }

    public int preorder(TreeNode root, int num){
        if(root == null)return 0;
        int sum = num * 10 + root.val;

        if(root.left == null && root.right == null)return sum;

        int left = preorder(root.left, sum);
        int right = preorder(root.right, sum);

        return left + right;
    }
    
    

    @Test
    public void test3(){
        String str = "A man, a plan, a canal: Panama";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("cog");
        list.add("dot");
        list.add("dog");
        list.add("hit");
        list.add("lot");
        list.add("log");

//        list.add("tot");
//        list.add("hog");
//        list.add("hop");
//        list.add("pot");
//        list.add("dot");
        System.out.println(findLadders("hit", "cog", list));

        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7, nums);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int begin = 0, end = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        while(end < len){
            sum += nums[end++];
            while(sum >= target){
                minLen = Math.min(minLen, end - begin);
                sum -= nums[begin++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }




    List<List<String>> res = new ArrayList<>();
    List<String> list = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))return res;
        boolean[] visited = new boolean[wordList.size()];


        list.add(beginWord);
        dfs(wordList, 0, endWord, visited);
        return res.stream().filter(l -> l.size() <= min).collect(Collectors.toList());


    }

    public void dfs(List<String> wordList, int index, String endWord, boolean[] visited) {

        if (list.size() > min) return;
        if (list.get(list.size() - 1).equals(endWord)) {
            min = Math.min(list.size(), min);
            res.add(new ArrayList<>(list));
            return;
        }

        if (index >= wordList.size()) return;

        for (int i = 0; i < wordList.size(); i++) {
            String temp = wordList.get(i);
            if (visited[i]) continue;
            int count = judgeDistance(list.get(list.size() - 1), temp);
            if (count == 1) {
                list.add(temp);
                visited[i] = true;
                dfs(wordList, index + 1, endWord, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    public int judgeDistance(String a, String b){
        int count = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                count++;
            }
        }

        return count;
    }





    public boolean isPalindrome(String s) {
        String str = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        boolean res = true;
        while(i <= j){
            while((str.charAt(i) > '9' || str.charAt(i) < '0') && (str.charAt(i) < 'a' || str.charAt(i) > 'z')){
                i++;
            }

            while((str.charAt(j) > '9' && str.charAt(j) < '0') || (str.charAt(j) < 'a' && str.charAt(j) > 'z')){
                j--;
            }

            if(str.charAt(i) == str.charAt(j)){
                i++;
                j--;
            }else{
                res = false;
                break;
            }
        }

        return res;
    }


    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null)return res;

        dfs(res, list, root, targetSum, 0);

        return res;
    }


    public void dfs(List<List<Integer>> res, List<Integer> list, TreeNode root, int targetSum, int sum){
        if(root == null)return;

        list.add(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == targetSum){
            res.add(new ArrayList<>(list));
            //list.remove(list.size() - 1);
            //return;
        }

        dfs(res, list, root.left, targetSum, sum + root.val);

        dfs(res, list, root.right, targetSum, sum + root.val);
        list.remove(list.size() - 1);
    }


    int num = 1;
    public int[] reversePrint(ListNode head) {
        if(head == null)return null;

        ListNode node = reverse(head);
        int[] arr = new int[num];
        for(int j = 0; j < num; j++){
            arr[j] = node.val;
            node = node.next;
        }
        return arr;
    }

    public ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            num++;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    @Test
    public void test4(){
        String[] strs = new String[10];
        Comparator<String> com = (o1, o2) -> (o1 + o2).compareTo(o2 + o1);

        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        Arrays.toString(strs);
        //LinkedList;
    }

    @Test
    public void test6(){
        System.out.println(reverseBits(   964176192));

        Comparator<Integer> com = (o1, o2) -> o2 - o1;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(com);

    }

    public int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while(i > 0){
            res <<= 1;
            res += n & 1;
            n >>= 1;
            i--;
        }

        return res;
    }

    @Test
    public void test8(){
        int[] arr = {2,1,5,3,6,4,8,9,7};
        System.out.println(GetLeastNumbers_Solution(arr, 4).toString());

//        PriorityQueue;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int len = input.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(k > len || k == 0)return res;

        Comparator<Integer> com = Comparator.reverseOrder();
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, com);

        for(int i = 0; i < len; i++){
            if(heap.size() < k){
                heap.offer(input[i]);
            }else if(heap.peek() > input[i]){
                heap.poll();
                heap.offer(input[i]);
            }
        }

        for(int num : heap){
            res.add(num);
        }

        return res;

    }

    public int[] LIS (int[] arr) {
        if(arr == null || arr.length <= 0){
            return null;
        }

        int len = arr.length;
        int[] count = new int[len];             // 存长度
        int[] end = new int[len];               // 存最长递增子序列

        //init
        int index = 0;                          // end 数组下标
        end[index] = arr[0];
        count[0] = 1;

        for(int i = 0; i < len; i++){
            if(end[index] < arr[i]){
                end[++index] = arr[i];
                count[i] = index;
            }
            else{
                int left = 0, right = index;
                while(left <= right){
                    int mid = (left + right) >> 1;
                    if(end[mid] >= arr[i]){
                        right = mid - 1;
                    }
                    else{
                        left = mid + 1;
                    }
                }
                end[left] = arr[i];
                count[i] = left;
            }
        }

        //因为返回的数组要求是字典序，所以从后向前遍历
        int[] res = new int[index + 1];
        for(int i = len - 1; i >= 0; i--){
            if(count[i] == index){
                res[index--] = arr[i];
            }
        }
        return res;
    }


    public int atoi (String str) {
        // write code here
        if(str.length() == 0)return 0;
        int index = 0;
        long sum = 0;
        int sigin = 1;
        str = str.trim();
        if(str.charAt(0) == '+'){
            index++;
        }else if(str.charAt(0) == '-'){
            sigin = -1;
            index++;
        }

        for(int i = index; i < str.length(); i++){
            char c = str.charAt(i);
            if(index == i){
                while(c == '0'){//消除前导0
                    i++;
                    c = str.charAt(i);
                }
            }
            if(c >= '0' && c <= '9'){
                long num = (long)c - '0';
                sum = 10 * sum + num;
                if(sum * sigin >= Integer.MAX_VALUE)return Integer.MIN_VALUE;
                if(sum * sigin <= Integer.MIN_VALUE)return Integer.MAX_VALUE;

            }else{
                break;
            }
        }
        int res = (int) sum;
        return res * sigin;

    }

    public int getLongestPalindrome(String A, int n) {
        // write code here
        boolean[][] dp = new boolean[n][n];
        for(int j = 0; j < n; j++){
            for(int i = 0; i <= j; i++){
                if(A.charAt(i) == A.charAt(j)){
                    if(i == j)dp[i][j] = true;
                    if(j - i == 1)dp[i][j] = true;
                    if(j - i > 1)dp[i][j] = dp[i + 1][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return 1;
    }


    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");

        int len1 = ver1.length, len2 = ver2.length;
        int i = 0, j = 0;

        int a = -1, b = -1;
        while(i < len1 && j < len2){
            a = Integer.parseInt(ver1[i]);
            b = Integer.parseInt(ver2[j]);

            if(a < b)return -1;
            if(a > b)return 1;
            i++;
            j++;
        }

        while(i < len1){
            a = Integer.parseInt(ver1[i]);
            b = 0;
            if(a < b)return -1;
            if(a > b)return 1;
            i++;
        }

        while(j < len2){
            a = 0;
            b = Integer.parseInt(ver2[j]);
            if(a < b)return -1;
            if(a > b)return 1;
            j++;
        }

        return 0;


    }

    @Test
    public void test11(){
        calculate("(10+(24+5+2)-3)+(16+8)");

        Queue<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
    }



    public int calculate(String s) {
        int len = s.length();
        s = s.replaceAll(" ", "");
        s = s.replaceAll("\\(-", "(0-");
        s = s.replaceAll("\\(\\+", "(0+");

        Deque<Integer> nums = new ArrayDeque<>();
        Deque<Character> ops = new ArrayDeque<>();

        char[] cs = s.toCharArray();

        for (int i = 0; i < len ; i++) {
            char c = cs[i];
            if(c == '('){
                ops.addLast(c);//操作符入栈
            }else if(c == ')'){
                //计算到最近的一个左括号
                while(!ops.isEmpty()){
                    char op = ops.peekLast();
                    if(op != '('){
                        cal(ops, nums);
                    }else{
                        ops.pollLast();
                        break;//碰到左括号弹出终止循环
                    }
                }
            }else{//不是数字就是操作符
                if(Character.isDigit(c)){//是数字
                    int num = 0;
                    int j = i;
                    while(j < len && Character.isDigit(cs[j]))num = num * 10 + (int)(cs[j++] - '0');
                    i = j - 1;//结束循环j指向的不是数字了，i回退一位
                    nums.addLast(num);
                }else{//是操作符，则计算直到碰到左括
                    while(!ops.isEmpty() && ops.peekLast() != '(')cal(ops, nums);//碰到左括号停止
                    ops.addLast(c);//新操作符入栈
                }
            }
        }
        //最后两个栈都不为空时，只剩操作符+-和数字
        while(!ops.isEmpty())cal(ops, nums);

        return nums.peekLast();

    }

    public void cal(Deque<Character> ops, Deque<Integer> nums){
        if(ops.isEmpty() || nums.size() < 2)return;

        char op = ops.pollLast();
        int b = nums.pollLast(), a = nums.pollLast();
        nums.addLast(op == '+' ? a + b : a - b);

    }





























}
