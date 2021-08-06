// https://leetcode.com/problems/can-place-flowers/

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int freeCount = 0;
        int emptyInARow = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) emptyInARow++;
            if (flowerbed[i] == 1) {
                freeCount += (emptyInARow)/2;
                emptyInARow = -1;
            }
        }
        freeCount += (emptyInARow + 1)/2;
        return (freeCount >= n);
    }
}
