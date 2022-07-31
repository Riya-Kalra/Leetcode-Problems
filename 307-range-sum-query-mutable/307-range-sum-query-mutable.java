class NumArray {
    int n;
    int nums[];
    int segmentTree[];
    public NumArray(int[] nums) {
        n=nums.length;
        this.nums=nums;
        segmentTree=new int[4*n];
        buildTree(0,0,n-1);
    }
    
    public void buildTree(int i,int low,int high){
        if(low==high){
            segmentTree[i]=nums[low];
            return;
        }
        int mid=(low+high)/2;
        buildTree(2*i+1,low,mid);
        buildTree(2*i+2,mid+1,high);
        segmentTree[i]=segmentTree[2*i+1]+segmentTree[2*i+2];
    }
    public void update(int index, int val) {
        updateST(index, 0, 0,n-1,val);
    }
    
    public void updateST(int i, int rootIndex, int low,int high, int val){
        if(low==high){
            segmentTree[rootIndex]=val;
            return;
        }
        int mid=(low+high)/2;
        if(i<=mid)
            updateST(i, 2*rootIndex+1,low,mid,val);
        else
            updateST(i, 2*rootIndex+2,mid+1,high,val);
        segmentTree[rootIndex]=segmentTree[2*rootIndex+1]+segmentTree[2*rootIndex+2];
    }
    public int sumRange(int left, int right) {
        return query(0,0,n-1,left,right);
    }
    public int query(int i,int low, int high,int l,int r){
        if(low>=l && high<=r)
            return segmentTree[i];
        else if(high<l || low>r)
            return 0;
        else{
            int mid=(low+high)/2;
            int left=query(2*i+1,low,mid,l,r);
            int right=query(2*i+2,mid+1,high,l,r);
            return (left + right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */