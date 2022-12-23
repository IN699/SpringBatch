package Assignment;

public class interfaceImplementation {
    static double result=0;
    public static double convertToKelvin(Double value, String source,String target)
    {   
        
        
        if(source.equals("C"))
        {
         result=value+ 273.15;   
        }
        if(source.equals("F"))
        {
            
         result=(value-32)*5/9+273.15;
        }
        return result;
    }
    public static double convertToCelsius(Double value, String source, String target)
    {
        if(source.equals("F"))
        {
            result=(value-32)*5/9;
        }
        if(source.equals("K"))
        {
            result=value-273.15;
            
        }
        return result;
        
    }
    public static double convertToFahrehheit(Double value,String source,String target)
    {
        if(source.equals("C"))
        {
            result=(double)((9*value)/5)+32;
        }
        if(source.equals("K"))
        {
            result=((value-273.15)*9)/5+32;
        }
        return result;
        
    }
    public static void main(String args[]) {
        // String a=args[0];
        String source=args[0].toUpperCase();
        String val=args[1];
        String target=args[2].toUpperCase();
        
        String sep="=";
        
		int a=source.indexOf(sep);
        int b=target.indexOf(sep);
        int c=val.indexOf(sep);
        
        source=source.substring(a+1,a+2);
        target=target.substring(b+1,b+2);
        val=val.substring(c+1);
        
        
        double value=Double.parseDouble(val);
        
        switch(target){
            case "K":
                System.out.println(value+" Degrees Celsius is equal to "+convertToKelvin(value, source, target));
                break;
            case "C":
                System.out.println(value+" Degrees Celsius is equal to "+convertToCelsius(value, source, target));
                break;
             case "F":
                 System.out.println(value+" Degrees Celsius is equal to "+convertToFahrehheit(value, source, target));
            default:
                break;
        }

    }
}