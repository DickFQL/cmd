package alth;

class removeelement {
    public int removeElement(int[] nums, int val) {
        int p=0,q=nums.length-1,num=0;
        while(q>=p){
            if(nums[p]==val){
                num++;
                while(nums[q]==val&&q>=p){
                    q--;
                }
                if(q>=p){
                    nums[p]=nums[q];
                    nums[q]=val;
                }
                else break;
            }
            else p++;
        }
        return nums.length-num;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        removeelement removeelement = new removeelement();
        System.out.println(removeelement.removeElement(nums,3));
    }
}