public class FinancialForecast {

    public static double forecast(double currentValue, double growthRate, int years) 
    {
        if (years == 0) {
            return currentValue;
        }
        return forecast(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;  
        double growthRate = 0.05;       
        int years = 5;                  

        double futureValue = forecast(initialValue, growthRate, years);
        System.out.println("Future Value after " + years + " years: " + futureValue);
    }
}
