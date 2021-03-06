/*
 * 空間複雜度：
 * 行號21~24, 25~27, 29~35, 36~41, 46, 47~51, 55~56, 59~62只有一個儲存空間 Ｏ(1)
 * 行號63~67有(n + 1)Ｏ(1) ->Ｏ(n)
 * 
 * 
 * 時間複雜度：
 * 行號21~24, 25~27, 46, 47~51, 59~62執行n次, 55~56執行logn次 Ｏ(n)
 * 行號29~35執行n*n次, 行號36~41執行n*logn次 Ｏ(n^2)
 * 行號63~67執行2*n次 Ｏ(n)
 * 
 * 
 */
import java.util.Scanner;

public class TestSum
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);		
		while(true)
		{
			System.out.println("Please select the number, and type them: ");
			int num = scanner.nextInt();
			if(num >= 1 && num <= 10)
			{
				long[] output = new long[num];
				// input
				for(int i = 0 ; i < num ; i++)
				{
					long input = scanner.nextLong();
					if(num >= 1 && num <= (long)Math.pow(10, 16))
					{
						output[i] = input;
					}
					else
					{
						// retry
						i--;
						printError();
					}					
				}
				// separate
				System.out.println();
				// output
				int recheck = (int)Math.pow(10, 9) + 7;
				for(int i = 0 ; i < num ; i++)
				{
					long result = (long)Math.sqrt(sum(output[i]));
					System.out.println(((result % recheck) * (result % recheck)) % recheck);
				}				
				// separate
				System.out.println();
			}
			else
				printError();			
		}		
	}
	public static void printError()
	{
		System.out.println("Error! Try again.");
	}
	public static long sum(long n)
	{
		if(n > 1)
			return 2 * n - 1 + sum(n - 1);
		return 1;	
	}

}