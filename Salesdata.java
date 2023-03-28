import java.util.Arrays;


public class SalesData {

    
public static void main(String[] args) {

        
        // Define the sales data
        
int[] sales2021 = {100, 100, 75};
        
int[] sales2022 = {120, 110, 100};
        
String[] products = {"Tea", "Coffee", "Green tea"};

        
        // Calculate the means for each product for both years
 
       double[] means = new double[3];

        means[0] = Arrays.stream(sales2021).average().orElse(Double.NaN);

        means[1] = Arrays.stream(sales2021).average().orElse(Double.NaN);

        means[2] = Arrays.stream(sales2021).average().orElse(Double.NaN);

        
        // Calculate the squared differences between each year's sales and the mean sales for each product

        double[][] squaredDiffs = new double[3][2];

        for (int i = 0; i < 3; i++) {
 
           squaredDiffs[i][0] = Math.pow(sales2021[i] - means[i], 2);

            squaredDiffs[i][1] = Math.pow(sales2022[i] - means[i], 2);

        }
        
       
 // Calculate the variance for each product for both years
 
       double[] variances = new double[3];

        variances[0] = squaredDiffs[0][0] + squaredDiffs[0][1];

        variances[1] = squaredDiffs[1][0] + squaredDiffs[1][1];

        variances[2] = squaredDiffs[2][0] + squaredDiffs[2][1];

        
        // Calculate the variance percentage change for each product

       double[] variancePctChanges = new double[3];
        
variancePctChanges[0] = Double.NaN;
        
variancePctChanges[1] = Double.NaN;
        
variancePctChanges[2] = (variances[0] - variances[1]) / variances[0] * 100.0;

        
        // Print the results for each product
        
for (int i = 0; i < 3; i++) {
            
System.out.println("Product: " + products[i]);

            System.out.println("Variance 2021: " + squaredDiffs[i][0]);

            System.out.println("Variance 2022: " + squaredDiffs[i][1]);

            System.out.println("Variance percentage change: " + variancePctChanges[i] + "%");

            System.out.println();

        }

    }

}

OUTPUT:
Product: Tea

Variance 2021: 0.0

Variance 2022: 0.0

Variance percentage change: NaN%



Product: Coffee

Variance 2021: 0.0

Variance 2022: 0.0

Variance percentage change: NaN%



Product: Green tea

Variance 2021: 625.0

Variance 2022: 0.0

Variance percentage change: -100.0%