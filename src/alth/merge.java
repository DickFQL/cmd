package alth;

class merge {
    public  void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i=m+n-1,q=n-1,p=m-1;
        while(q>=0&&p>=0){
            if(nums2[q]>nums1[p]) nums1[i--]=nums2[q--];
            else nums1[i--] = nums1[p--];
        }
        while(q>=0) nums1[i--]= nums2[q--];
    }

    public static void main(String[] args) {
        merge merge = new merge();
        int[] nums1= new int[]{1, 1, 1,0,0,0};
        int[] nums2= new int[]{2, 2, 2};
        merge.merge1(nums1,3,nums2,3);
        for (int i : nums1) {
            System.out.println(nums1[i]);
        }

    }
}