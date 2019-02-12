package test;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author ljx
 * @Date Jan 10, 2019 2:41:55 PM
 *
 */
public class Test {

	public static void main(String[] args) {
//		BigDecimal bd = new BigDecimal("10.0001");
//		System.out.println(String.valueOf(bd));
//		System.out.println(bd.toString());
//		System.out.println(bd.subtract(new BigDecimal("8")));
//		System.out.println(bd.ZERO.toString());
//		System.out.println(String.valueOf("null"));
//		
//		List<Integer> in = new ArrayList<Integer>();
//		in = Arrays.asList(1,2,3,4,5,6);
//		in.forEach(v -> System.out.println(v));
		
//		for (int i = 1; i <= 10; i++) {
//			System.out.print(" " + i*10 + "%\b");
//			try {
//				Thread.sleep(100 / 10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//		System.out.print("Progress:");
//	    for (int i = 1; i <= 100; i++) {
//	        System.out.print(i + "%");
//	        try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//	 
//	        for (int j = 0; j <= String.valueOf(i).length(); j++) {
//	            System.out.print("\r");
//	        }
//	    }
//	    System.out.println();
		
		
		for(int j = 10;j<=100;j+=10) {
			int percent = j;
			StringBuilder bar = new StringBuilder("[");

		    for(int i = 0; i < 50; i++){
		        if( i < (percent/2)){
		            bar.append("=");
		        }else if( i == (percent/2)){
		            bar.append(">");
		        }else{
		            bar.append(" ");
		        }
		    }

		    bar.append("]   " + percent + "%     ");
		    System.out.print("\r" + bar.toString());
		}

	}
	
	
}
