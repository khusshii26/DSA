class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
      int totalgas=0;
      for(int num : gas){
        totalgas+=num;
      }  
      int totalcost=0;
      for(int n : cost){
        totalcost+=n;
      }
     if(totalgas<totalcost){
        return -1;
     }
    int start =0, currentcost=0;
    for(int i=0;i<gas.length;i++){
        currentcost += (gas[i]-cost[i]);
        if(currentcost <0){
            start=i+1;
            currentcost=0;
        }
    }
    return start;

    }
}