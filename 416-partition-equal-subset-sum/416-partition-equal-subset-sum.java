class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0,l = nums.length;
        for(int x = 0; x< l ; x++){
            sum += nums[x];
        }
        if(sum % 2 != 0)
            return false;
        int halfSum = sum/2;
        boolean arr[][] = new boolean[l+1][halfSum+1];
        arr[0][0] = true;
        for(int i = 1;i <= l;i++){
            int currentNum = nums[i-1];
            for(int j = 0; j <= halfSum; j++){
               if(currentNum <= j) 
                   arr[i][j] = arr[i-1][j] || arr[i-1][j-currentNum];
               else
                   arr[i][j] = arr[i-1][j];
               }
            }
        return arr[l][halfSum];
        }
    }