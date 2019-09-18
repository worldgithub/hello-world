package com.asiainfo.findMedianSortedArrays;

import java.util.Arrays;

/**
 * 寻找两个有序数组的中位数 算法时间复杂度为O(log(m+n))
 * nums1 = [1, 3]; nums2=[2]  result=2.0
 * nums1 = [1, 2]; nums2=[3, 4]  result=(2+3)/2 = 2.5
 * @author yl_bu
 *
 */
public class Solution {
	/**
	 * 时间复杂度为m+n
	 * 空间复杂度为O(m+n)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int mLen = nums1.length;
		int nLen = nums2.length;
		
		int[] nums = new int[mLen + nLen];
		
		//nums1为空 nums2不为空
		if (mLen == 0) {
			if (nLen % 2 == 0) {
				return (nums2[nLen / 2 - 1] + nums2[nLen / 2]) / 2.0;
			} else {
				return nums2[nLen / 2];
			}
		}
		
		if (nLen == 0) {
			if (mLen % 2 == 0) {
				return (nums1[nLen / 2 - 1] + nums1[nLen / 2]) / 2.0;
			} else {
				return nums1[nLen / 2];
			}
		}
		
		int count = 0;
		int i = 0;
		int j = 0;
		while (count < mLen + nLen) {
			if (i == mLen) {
				while (j < nLen) {
					nums[count++] = nums2[j++];
				}
				break;
			}
			if (j == nLen) {
				while (i < mLen) {
					nums[count++] = nums1[i++];
				}
				break;
			}
			
			if (nums1[i] < nums2[j]) {
				nums[count++] = nums1[i++];
			}else {
				nums[count++] = nums2[j++];
			}
		}
		System.out.println(Arrays.toString(nums));
		if (nums.length % 2 == 0) {
			return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
		}else {
			return nums[count / 2];
		}
	}
	
	/**
	 * 时间复杂度O(m+n)
	 * 空间复杂度O(1)
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
		int mLen = nums1.length;
		int nLen = nums2.length;
		
		int len = mLen + nLen;
		int left = -1;
		int right = -1;
		
		int mStart = 0;
		int nStart = 0;
		
		for (int i=0; i<len / 2 + 1; i++) {
			left = right;
			if (mStart < mLen && nStart < nLen && nums1[mStart] < nums2[nStart]) {
				right = nums1[mStart++];
			} else {
				right = nums2[nStart++];
			}
		}
		if ((len & 1) == 0) {
			//偶数
			return (left + right) / 2.0;
		}else {
			//奇数
			return right;
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {1, 3};
		int[] nums2 = {2};
		System.out.println(findMedianSortedArrays1(nums1, nums2));
		
		int[] nums11 = {1, 2};
		int[] nums22 = {3, 4};
		System.out.println(findMedianSortedArrays1(nums11, nums22));
	}
}
