public class Solution {
	//This is a bad attempt...
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);

        //One on top of the other
        if(E > A && F > B && G < C && H < D) return area1;
        if(A > E && B > F && C < G && D < H) return area2;
        //No intersection
        if((D < F) || (E > C) || (H < B) || (A > G)) return 0;

        //Partially overlap
        return area1 + area2 - Math.min(G - A, C - E) * Math.min(H - B, D - F);
    }


    //Correct one
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        //No intersection
        if((D < F) || (E > C) || (H < B) || (A > G)) return area1 + area2;
        
        int left = Math.max(E, A);
        int right = Math.min(G, C);
        int top = Math.min(D, H);
        int bottom = Math.max(B, F);
        int overlap = (right - left) * (top - bottom);
        
        return area1 + area2 - overlap;
    }

}