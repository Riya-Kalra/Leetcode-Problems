class Solution {
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue <int[]> pq =new PriorityQueue<>((p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] *p2[0] - p2[1] * p2[1]);
        for (int i=0;i<points.length;i++){
            
            pq.add(new int []{points[i][0],points[i][1]});
        }
        int ar[][]=new int[k][2];
        for (int i=0;i<k;i++){
            int a[]= pq.poll();
            ar[i]=a;
        }
        return ar;
    }
}