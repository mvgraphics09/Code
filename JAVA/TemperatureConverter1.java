public class TemperatureConverter1 {
    public double fahrenheitToCelsius(double fahrenheit){
        return (fahrenheit-32)*5/9;
    }
    public double celsiusToFahrenheit(double celsius){
        return (celsius*9/5)+32;
    }
    public static void main(String[] args){
        TemperatureConverter1 obj=new TemperatureConverter1();
        System.out.println("fahrenheit to celsius is "+obj.fahrenheitToCelsius(100));
        System.out.println("celsius to fahrenheit is "+obj.celsiusToFahrenheit(100));

        
    }
}   
