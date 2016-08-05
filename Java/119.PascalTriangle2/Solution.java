import java.util.ArrayList;
import java.util.List;

//Only keep track of the previous row
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        //kth row have k+1 elements
        List<Integer> row = new ArrayList<>();
        for(int i = 0; i < rowIndex + 1; i++) {
            //Fill up the array reversely so that we will not mess up with the following number
            for(int j = i-1; j > 0; j--)
                row.set(j, row.get(j-1) + row.get(j));
            row.add(1);
        }
        
        return row;
    }
}