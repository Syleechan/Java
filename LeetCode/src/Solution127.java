import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/4/28 10:43
 * @description：
 */

public class Solution127 {

    @Test
    public void test(){
        Vector<Object> v = new Vector<>();
        List<Object> res = new ArrayList<>();
        while(true){
            res.add(new Object());
            System.out.println(res.size());
        }

//        String beginWord = "hit";
//        String endWord = "cog";
//        String[] strs = {"hot","dot","dog","lot","log","cog"};
//        List<String> wordList = Arrays.stream(strs).collect(Collectors.toList());
//        List<List<String>> res = findLadders(beginWord, endWord, wordList);
//        System.out.println(res.toString());
//        Set<String> set = new HashSet<>(wordList);
//        Iterator<String> it = set.iterator();
//        while(it.hasNext()){
//
//        }


    }


    boolean flag = false;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        List<List<String>> res = new ArrayList<>();//存结果
        HashMap<String, Set<String>> graph = new HashMap<>();//建图
        HashMap<String, Integer> steps = new HashMap<>();//记录步数，距离
        HashSet<String> dict = new HashSet<>(wordList);

        if(!dict.contains(endWord))return res;
        dict.remove(beginWord);

        steps.put(beginWord, 0);//起始step为0

        bfs(beginWord, endWord, steps, dict, graph);
        if(flag){
            Deque<String> path = new ArrayDeque<>();
            path.addFirst(endWord);//从结束单词往前找，因为graph存的key是出度
            dfs(path, graph, beginWord, endWord, res);

        }

        return res;


    }

    public void dfs(Deque<String> path, HashMap<String, Set<String>> graph, String beginWord, String curWord, List<List<String>> res){
        if(curWord.equals(beginWord)){
            res.add(new ArrayList<>(path));
            return;
        }

        for(String inWord : graph.get(curWord)){
            path.addFirst(inWord);
            dfs(path, graph, beginWord, inWord,res);
            path.removeFirst();
        }
    }


    public void bfs(String beginWord, String endWord, HashMap<String, Integer> steps, HashSet<String> dict, HashMap<String, Set<String>> graph){
        Queue<String> queue = new LinkedList<>();
        int step = 0;
        int len = beginWord.length();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                String curWord = queue.poll();
                char[] curArray = curWord.toCharArray();
                for(int j = 0; j < len; j++){
                    char origin = curArray[j];
                    for (char c = 'a'; c <= 'z'; c++){
                        curArray[j] = c;
                        String nextWord = String.valueOf(curArray);
                        if(steps.containsKey(nextWord) && step == steps.get(nextWord)){//如果节点相邻，把入度加入set
                            graph.get(nextWord).add(curWord);//出度在前，入度在后
                        }

                        if(!dict.contains(nextWord))continue;//词典中不存在该词

                        //已搜索到的词，防止重复搜索将距离变远，将词从dict移除，这一步很关键
                        dict.remove(nextWord);
                        //将其入队，继续建图
                        queue.offer(nextWord);
                        //放入图中，如果第一次放初始化一个set
                        graph.putIfAbsent(nextWord, new HashSet<>());
                        //添加它的入度节点
                        graph.get(nextWord).add(curWord);
                        //记录step
                        steps.put(nextWord, step);
                        //如果等于endWord,则表示有路径
                        if(nextWord.equals(endWord)){
                            flag = true;
                        }
                    }
                    curArray[j] = origin;//还原单词
                }
            }

        }
    }

    public boolean judgeDistance(String a, String b){
         int count = 0;
         for(int i = 0; i < a.length(); i++){
             if(a.charAt(i) != b.charAt(i)){
                 count++;
             }
         }

         return count == 1;
     }

























}
