package Assignment;

interface abc{
	void Result(double value,String source,String target);
}

class Kelvin implements abc{
	public void Result(double value,String source,String target)
	{
		
	}
	
}
class Fahrenheit implements abc{
	public void Result(double value,String source,String target)
	{
		
	}
	
}
class Celsius implements abc{
	public void Result(double value,String source,String target)
	{
		
	}
	
}
public class withDesignPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String 
		
		String source=args[0];
        Double value=Double.parseDouble(args[2]);
        String target=args[1];
        
        switch(target){
        case "K":
            //System.out.println(convertToKelvin(value, source, target));
        	
        	
            break;
        case "C":
            //System.out.println(convertToCelsius(value, source, target));
            break;
         case "F":
             //System.out.println(convertToFahrehheit(value, source, target));
        default:
            break;
    }
	}

}
