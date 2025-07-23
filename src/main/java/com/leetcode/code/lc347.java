package com.leetcode.code;

import java.util.*;

public class lc347 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent2(new int[]{1}, 1)));
    }
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        int[] valueSorted = map.values().stream().sorted().mapToInt(Integer::intValue).toArray();

        int[] res = new int[k];
        int n=0;
        // ... existing code ...
        for (int i = valueSorted.length - 1; i >= valueSorted.length - k; i--) {
            int value = valueSorted[i];

            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> entry = iterator.next();
                if (entry.getValue() == value) {
                    res[n] = entry.getKey();
                    n++;
                    iterator.remove(); // 安全地移除当前元素
                }
            }
        }

        return res;
    }
    //小顶堆 优先级队列
    public static int[] topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue()-o2.getValue();//负数选o1，正数o2
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(),count = entry.getValue();
            if (queue.size()==k){
                if (queue.peek().getValue()<count){
                    queue.poll();
                    queue.offer(new Map.Entry<Integer, Integer>() {
                        @Override
                        public Integer getKey() {
                            return num;
                        }

                        @Override
                        public Integer getValue() {
                            return count;
                        }

                        @Override
                        public Integer setValue(Integer value) {
                            return 0;
                        }
                    });
                }
            }else {
                queue.offer(new Map.Entry<Integer, Integer>() {
                    @Override
                    public Integer getKey() {
                        return num;
                    }

                    @Override
                    public Integer getValue() {
                        return count;
                    }

                    @Override
                    public Integer setValue(Integer value) {
                        return 0;
                    }
                });
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            int key = queue.poll().getKey();
            res[i] = key;
        }
        return res;
    }

}
