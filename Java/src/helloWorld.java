interface Result{
	public double result(String source,int value,String target);
}

class convertToKelvin implements Result{
	
	public double result(String source,int value,String target)
	{
		double r=0;
		 if(source.equals("C"))
	        {
	         r=value+ 273.15;   
	        }
	        else if(source.equals("F"))
	        {
	            
	         r=(value-32)*(5/9);
	        }
	       
	        return r;
	}
	
}

public class helloWorld{
   
	
    
//    public static double convertToKelvin(int value, String source,String target)
//    {   
//        System.out.println(value);
//        
//        if(source.equals("C"))
//        {
//         result=value+ 273.15;   
//        }
//        else if(source.equals("F"))
//        {
//            
//         result=(value-32)*(5/9);
//        }
//       
//        return result;
//    }
    // public static void convertToCelsius(value, source, target)
    // {
        
    // }
    // public static void convertToFahrehheit(value, source, target)
    // {
        
    // }
    public static void main(String args[]) {
        // String a=args[0];
        String source=args[0];
        int value=Integer.parseInt(args[1]);
        String target=args[2];
        switch(target){
            case "K":
                System.out.println(convertToKelvin(value, source, target));
                break;
            // case C:
            //     convertToCelsius(value, source, target);
            //     break;
            // case F:
            //     convertToFahrehheit(value, source, target);
            default:
                break;
        }
        //  System.out.println();
        // System.out.println(value);
        // System.out.println(target);
    }
}