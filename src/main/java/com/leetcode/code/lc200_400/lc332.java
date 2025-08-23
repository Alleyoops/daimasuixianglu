package com.leetcode.code.lc200_400;

import java.util.*;

public class lc332 {
    List<String> path = new ArrayList<>();
    List<String> result = new ArrayList<>();
    boolean[] used;
    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        //对tickets进行排序
//        tickets.sort(new Comparator<List<String>>() {
//            @Override
//            public int compare(List<String> o1, List<String> o2) {
//                return o1.toString().compareTo(o2.toString());
//            }
//        });

        backTrack(tickets);
        return result;
    }
    private void backTrack(List<List<String>> tickets){
        //终止条件
        if (path.size()== tickets.size()+1){
            result = new ArrayList<>(path);
            return;
        }
        //处理逻辑
        for (int i = 0; i < tickets.size(); i++) {
            //找到符合当前起点的终点
            if (path.isEmpty()){
                //1.如果当前起点为空，则应该寻找JFK作为终点
                int index = 0;
                String minEnd = "ZZZZ";
                for (int j = 0; j < tickets.size(); j++) {
                    if (!used[j]&&tickets.get(j).getFirst().equals("JFK")){
                        if (tickets.get(j).getLast().compareTo(minEnd)<0){
                            minEnd = tickets.get(j).getLast();
                            index = j;
                        }
                    }
                }
                if (minEnd.equals("ZZZZ")) continue;
                path.add("JFK");
                path.add(minEnd);
                used[index]=true;
                backTrack(tickets);
                if (!result.isEmpty()) return;
                path.removeLast();
                path.removeLast();
                used[index]=false;
            }else {
                //2.如果当前节点不为空，选择之前行程的终点作为起点
                //找到终点
                String curStart = path.getLast();
                int index = 0;
                String minEnd = "ZZZZ";
                for (int j = 0; j < tickets.size(); j++) {
                    if (!used[j]&&tickets.get(j).getFirst().equals(curStart)){
                        if (tickets.get(j).getLast().compareTo(minEnd)<0){
                            minEnd = tickets.get(j).getLast();
                            index = j;
                        }
                    }
                }
                if (minEnd.equals("ZZZZ")) continue;
                path.add(minEnd);
                used[index]=true;
                backTrack(tickets);
                if (!result.isEmpty()) return;
                path.removeLast();
                used[index]=false;
            }

        }
    }
}
