package Practice;

//import java.util.Scanner;

public class practiceOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc=new Scanner(System.in);
//		char ch=sc.next().charAt(0);
//		System.out.println(ch);
//		String s=args[7];
		 //returns he  as a substring  
//		String source=args[0].toUpperCase();
//		String sep="=";
//		int a=source.indexOf(sep);
//		int b=target
//		System.out.println(source.substring(a+1,a+2));
		
//		String source=args[0].toUpperCase();
//        String sep="=";
//		int a=source.indexOf(sep);
//        String value=args[1];
//        String target=args[2].toUpperCase();
//        int b=target.indexOf(sep);
//        int c=value.indexOf(sep);
//        int val=Integer.parseInt(value.substring(c+1));
//        System.out.println(source.substring(a+1,a+2));
//        System.out.println(target.substring(b+1,b+2));
//        System.out.println(val);
		
		String source=args[0].toUpperCase();
        String val=args[1].toUpperCase();
        String target=args[2].toUpperCase();
        
//        for(int i=0;i<3;i++)
//        {
////        	Double.parseDouble(args[i])
//        	if()
//        	{
//        		
//        	}
//        }
//        
        String sep="=";
        
		int a=source.indexOf(sep);
        int b=target.indexOf(sep);
        int c=val.indexOf(sep);
        
        
        
        source=source.substring(a+1,a+2);
        target=target.substring(b+1,b+2);
        val=val.substring(c+1);
        
        System.out.println(source);
        System.out.println(target);
        System.out.println(val);
        
		//String source=args[0].toUpperCase();
        //String sep="=";
		//int a=source.indexOf(sep);
//        String val=args[1];
//        String target=args[2].toUpperCase();
//        int b=target.indexOf(sep);
//        int c=val.indexOf(sep);
//        target=target.substring(a+1,a+2);
        //source=source.substring(a+1,a+2);
//        val=val.substring(c+1,c+2);
//        int value=Integer.parseInt(val.substring(c+1));
        //System.out.println(source);
//        System.out.println(target.substring(b+1,b+2));
//        System.out.println(val);
		
		
		
//		System.out.println(a);

	}

}
