// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

// Find two lines that together with the x-axis form a container, such that the container contains the most water.

// Return the maximum amount of water a container can store.

// Notice that you may not slant the container.

 

// Example 1:


// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
// Example 2:

// Input: height = [1,1]
// Output: 1

// Solution
// Start with left=0 and right=n-1.

// Compute area = (right - left) * min(height[left], height[right]).

// Update max if larger.

// Always move the pointer at the smaller height, since moving the taller one cannot increase area.

// Continue until left >= right.
public class ContainerWithMostWater {
  public int maxArea(int[] height) {

    int lp = 0;
    int rp = height.length - 1;
    int max = 0;

    while (lp < rp) {
      int width = rp - lp;
      int hei = Math.min(height[lp], height[rp]);
      int water = width * hei;
      max = Math.max(water, max);
      if (height[lp] < height[rp]) {
        lp++;
      } else {
        rp--;
      }
    }
    return max;

  }
}
