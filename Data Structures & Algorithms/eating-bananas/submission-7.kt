/*
Given piles of bananas
h is number of hours we have to eat every pile
can decide k: how many bananas to eat per hour
We are limited to eating from one pile per hour

need to minimise k

h must be >= length of piles, otherwise there is 
no way to eat all the pile seven with infinite k

if h > piles.length we still optimise for h = piles.length
the extra time makes no difference to minimising k, because if we
find optimal k for h, then that k is still optimal for any value
greater than h

k can't be zero, as no bananas would be eaten
the maximum 'possibly optimal' k is maxOf(piles), because that 
k would get through every pile in one hour guaranteed. Higher
k than that would not lead to a faster result.

so 1 <= k <= maxOf(piles)

to get the optimal k we can use binary search.
A range of k values can satisfy the time <= h condition
So even when we find the start of that k range (from the larger side working down)
we need to keep iterating to ensure we find the minimum k
so we keep going until our left pointer is greater than the right pointer
Once we have reached that point, whatever the best k we found so far is 
the minimum k
*/

class Solution {

    fun minEatingSpeed(
        piles: IntArray,
        h: Int,
    ): Int {
     var l = 1
     var r = piles.max()
     var answer = r

     while (l <= r) {
        val k = l + (r - l) / 2
        val time = piles.sumOf { ceil(it.toDouble() / k).toInt() }

        if (time > h) {
            l = k + 1
        }
        else {
            answer = minOf(answer, k)
            r = k - 1
        }
        
     }

     return answer


    }
}




















