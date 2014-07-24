package tools;

public class TempConvert {
	
	public float CToF ( String C ){
		
		float celsius=Float.valueOf(C).floatValue();
	    return (celsius * 9 / 5) + 32;
	  }

	  public float FToC ( String F  ){
		  
		float farenheit=Float.valueOf(F).floatValue();
	    return (farenheit - 32) * 5 / 9;
	  }


}
