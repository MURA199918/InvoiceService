import java.util.Objects;

public class InvoiceSummary {

    private final int numofRides;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numofRides, double totalFare) {
        this.numofRides = numofRides;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare/this.numofRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numofRides == that.numofRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.averageFare, averageFare) == 0;
    }

    @Override
    public String toString() {
        return "InvoiceSummary{" +
                "numofRides=" + numofRides +
                ", totalFare=" + totalFare +
                ", averageFare=" + averageFare +
                '}';
    }
}
