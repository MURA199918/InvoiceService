public class InvoiceGenerator {

    private static final double MIN_COST_PER_KM = 10.0;
    private static final int MIN_COST_PER_TIME = 1;

    public double calculateFare(double distance, int time) {
        double cost = (distance*MIN_COST_PER_KM) + (time*MIN_COST_PER_TIME);
        return cost;
    }
}
