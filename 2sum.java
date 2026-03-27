/*
 * PUSH TO REPOSITORY COMMANDS:
 * 
 * Stage changes:
 *   git add .
 * 
 * Commit changes:
 *   git commit -m "Your commit message here"
 * 
 * Push to GitHub:
 *   git push
 * 
 * Repository: https://github.com/Rajkaran-122/DSA.git
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> add = new HashMap<>();

       for(int i =0 ; i< nums.length ;i++){
        int comp = target - nums[i];
         if(add.containsKey(comp)){
            return new int[] {i,add.get(comp)};
         }
         add.put(nums[i],i);
       }
       return new int[]{};
    }
}