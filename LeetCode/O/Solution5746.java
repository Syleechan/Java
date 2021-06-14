import org.junit.Test;

/**
 * @author ：LeeChan
 * @date ：Created in 2021/5/23 11:41
 * @description：
 */

public class Solution5746 {

    @Test
    public void test(){
        int[] dist = {9,5,10,6,10};
        minSpeedOnTime(dist, 16.75);
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int min = 100000 + 1, max = 10000000;
        int len = dist.length;
        for(int i = 0; i < len; i++){
            min = Math.min(min, dist[i]);
            max = Math.max(max, dist[i]);
        }


        int l = min, r = max;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(search(dist, mid, hour)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }

        if(!(search(dist, l,hour)))return -1;
        return l;


    }

    public boolean search(int[] dist, int k, double hour){
        double sum = 0.00;
        for(int i = 0; i < dist.length; i++){
            double temp = (double) dist[i] / (double) k * 1.00;
            if(i == dist.length - 1){
                sum += temp;
                break;
            }
            int a = (int)Math.ceil(temp);
            sum += a;
        }
        return sum <= hour;
    }
}
