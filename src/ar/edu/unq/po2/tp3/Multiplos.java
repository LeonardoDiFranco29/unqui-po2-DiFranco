package ar.edu.unq.po2.tp3;

public class Multiplos {
	
	public static int mayorMultiploComun(int x, int y) {
        for (int i = 1000; i >= 1; i--) {
            if (i % x == 0 && i % y == 0) {
                return i;
            }
        }
        return -1;
    }
}