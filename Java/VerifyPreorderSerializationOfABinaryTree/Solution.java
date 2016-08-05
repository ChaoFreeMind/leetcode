public class Solution {
    public boolean isValidSerialization(String preorder) {
        int out = 0, in = -1;//Out degree and in degree
        //Root only provides 2 out degrees
        //Imagin we are building a tree. 
        for (String s: preorder.split(",")) {
            in++;
            if(in > out) return false;
            
            if(!s.equals("#")) {
                out += 2;
            }
        }
        
        return out == in;
    }
}