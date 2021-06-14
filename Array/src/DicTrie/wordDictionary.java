package DicTrie;

import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/19 20:01
 * @description：
 */

public class wordDictionary {

    class TrieNode{
        private boolean isWord;
        private TrieNode[] next;

        public TrieNode(){
            this.next = new TrieNode[26];
            this.isWord = false;
        }
    }

    private TrieNode root;

    public wordDictionary(){
        root = new TrieNode();
    }

    public void addWord(String word){
        int len = word.length();
        TrieNode cur = root;
        for(int i = 0; i < len; i++){
            if(cur.next[word.charAt(i) - 'a'] == null){
                cur.next[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.next[word.charAt(i) - 'a'];
        }
        if(!cur.isWord) cur.isWord = true;

        System.out.println("null");

    }

    public boolean search(String word){
        return judgeWord(word, root, 0);
    }

    private boolean judgeWord(String word, TrieNode root, int index){
        if(index == word.length()){
            return root.isWord;
        }

        char c = word.charAt(index);
        if(c == '.'){
            for(int i = 0; i < 26; i++){
                if(root.next[i] != null && judgeWord(word, root.next[i], index + 1 )){
                    return true;
                }
            }
            return false;
        }else{
            if(root.next[c - 'a'] == null)return false;

            return judgeWord(word, root.next[c - 'a'], index + 1);
        }
    }

    @Test
    public void test(){
//        wordDictionary wd = new wordDictionary();
//        wd.addWord("at");
//        wd.addWord("and");
//        wd.addWord("an");
//        wd.addWord("add");
//        wd.search("a");
//
//        StringBuilder sb = new StringBuilder("a");

        System.out.println(shortestPalindrome("abb"));

    }


    public String shortestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int minIndex = 0, maxLen = 0;

        for(int j = 0; j < len; j++){
            for(int i = 0; i <= j; i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(i == j)dp[i][j] = true;
                    if(j - i == 1)dp[i][j] = true;
                    if(j - i > 1)dp[i][j] = dp[i + 1][j - 1];
                }else{
                    dp[i][j] = false;
                }
                if(dp[i][j] && i == 0){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        minIndex = i;
                    }
                }

            }
        }

//        for(int i = 0; i < len; i++){
//            for(int j = 0; j < len; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }


        StringBuilder sb1 = new StringBuilder(s.substring(0, minIndex));
        StringBuilder sb2 = new StringBuilder(s.substring(maxLen + minIndex));

        String res = sb2.reverse().toString() + s + sb1.reverse().toString();

        return res;


    }




















}
