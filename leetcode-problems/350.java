// 

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // brute force
        List<Integer> result = new ArrayList();
        List<Integer> list2 = new ArrayList();
        for (int i : nums2) {
            list2.add(i);
        }
        
        for (int i : nums1) {
            if (list2.contains(i)) {
                result.add(i);
                list2.remove(list2.indexOf(i));
            }
        }
        
        int[] resultArr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
        
    }
}

// HashMap Solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // map of occurances of each num from num1
        Map<Integer, Integer> occur = new HashMap();
        for (int i : nums1) {
            if (occur.containsKey(i)) {
                occur.put(i, occur.get(i) + 1);
            }
            else {
                occur.put(i, 1);
            }
        }
        
        List<Integer> intersection = new ArrayList();
        for(int i : nums2) {
            if (occur.containsKey(i) && occur.get(i) > 0) {
                occur.put(i, occur.get(i) - 1);
                intersection.add(i);
            }
        }
        
        return intersection.stream().mapToInt(x -> x).toArray();
        
    }
}

// Sorted Arrays solution
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        // use two indices to trace through arrays
        int nums1Index = 0;
        int nums2Index = 0;
        
        List<Integer> result = new ArrayList();
        while (nums1Index <= nums1.length - 1 || nums2Index <= nums2.length - 1) {
            int num1Val = nums1[nums1Index];
            int num2Val = nums2[nums2Index];
            
            // if found match, add to result
            if (num1Val == num2Val) {
                result.add(num1Val);
                // increment num1Index/num2Index if possible. If at the end, won't have any matches left anyways so break
                if (nums1Index < nums1.length - 1) {
                    nums1Index++;
                }
                else {
                    break;
                }
                if (nums2Index < nums2.length - 1) {
                    nums2Index++;
                }
                else {
                    break;
                }
            }
            if (num1Val < num2Val) {
                if (nums1Index < nums1.length - 1) {
                    nums1Index++;
                }
                else {
                    break;
                }
            }
            if (num1Val > num2Val) {
                if (nums2Index < nums2.length - 1) {
                    nums2Index++;
                }
                else {
                    break;
                }
            }
        }
        
        return result.stream().mapToInt(x -> x).toArray();
    }
}
