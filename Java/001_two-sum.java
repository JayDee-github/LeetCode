class Solution {
  public int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> differences = new HashMap();

    for (int i=0; i<nums.length; i++) {
      int currentValue = nums[i];
      int currentDiff = target - currentValue;

      if (differences.containsKey(currentValue))
        return new int[] {
          differences.get(currentValue),
          i
         };

      differences.put(currentDiff, i);
    }

    throw new IllegalArgumentException("Solution not found");
  }
}
