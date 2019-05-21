package intranet.naruka.config;

public class Test {

	public static void main(String[] args) {
			
		boolean flag= true;
		for(int x=1; x<=6; x++ )
		{
			for (int j=1; j<=x+5;j++  )
			{
			
			if (j<= (6-x) )
				System.out.print("T");
			else
			{	if(flag)
				{
					
				System.out.print(" ");
				}
				else
				{
					System.out.print("*");
				}
			flag=!flag;
			}
			}
			System.out.println();
		}
		
   /*
  
  -----* 
  ----* *
  ---* * *
  --* * * *
  -* * * * *
  * * * * * *
   
    
    *
    * *
    * * *
    * * * *
    * * * * * 
     
    */
		
/*		System.out.println( x + " X " + 2 + " = " + x * 2);
		System.out.println( x + " X " + 3 + " = " + x * 3);
		System.out.println( x + " X " + 4 + " = " + x * 4);
		System.out.println( x + " X " + 5 + " = " + x * 5);
		System.out.println( x + " X " + 6 + " = " + x * 6);
		System.out.println( x + " X " + 7 + " = " + x * 7);
		System.out.println( x + " X " + 8 + " = " + x * 8);
		System.out.println( x + " X " + 9 + " = " + x * 9);
		System.out.println( x + " X " + 10 + " = " + x * 10);
*/		

	}

}
