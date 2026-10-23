class Solution { // Bucket sort
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new List[nums.length + 1]; 
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>(); 
        }

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey(); 
            int frequency = entry.getValue();
            buckets[frequency].add(num); 
        }

        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int j = 0; j < buckets[i].size(); j++) { 
                result[index++] = buckets[i].get(j); 
                if (index == k)
                    break;
            }
        }

        return result; 
    }
}