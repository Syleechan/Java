import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/7/5 16:40
 * @description：
 */

public class Solution336 {
    class Trie{
        Trie[] child;
        int idx;
        List<Integer> suffix;

        public Trie(){
            this.child = new Trie[26];
            this.idx = -1;
            this.suffix = new ArrayList();
        }
    }

    @Test
    public void test(){
        String[] strs = {"abcd","dcba","lls","s","sssll"};
        palindromePairs(strs);
    }


    Trie root = new Trie();
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> palindromePairs(String[] words) {
        addTrie(words);
        search(words);
        return res;
    }

    public void addTrie(String[] words){
        int len = words.length;
        Trie cur = root;
        for(int i = 0; i < len; i++){
            String r = new StringBuilder(words[i]).reverse().toString();
            if(isPalindrome(r))cur.suffix.add(i);
            for(int j = 0; j < r.length(); j++){
                if(cur.child[r.charAt(j) - 'a'] == null){
                    cur.child[r.charAt(j) - 'a'] = new Trie();
                }
                cur = cur.child[r.charAt(j) - 'a'];

                if(isPalindrome(r.substring(j + 1)))cur.suffix.add(i);
            }
            cur.idx = i;
        }
    }


    public void search(String[] words){
        int len = words.length;
        for(int i = 0; i < len; i++){
            Trie cur = root;
            String s = words[i];
            int j = 0;
            for(; j < s.length(); j++){
                if(isPalindrome(s.substring(j)) && cur.idx != -1){
                    res.add(Arrays.asList(i, cur.idx));
                }

                Trie next = cur.child[s.charAt(j) - 'a'];
                if(next == null)break;
                cur = next;
            }
            if(j == s.length()){
                for(int k : cur.suffix){
                    if(k != i)res.add(Arrays.asList(i, k));
                }
            }
        }
    }

    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }
}
