package ua.edu.ucu.apps.tempseries;

public class TempSummaryStatistics {
    private double avgTemp;
    private double devTemp;
    private double minTemp;
    private double maxTemp;
    public TempSummaryStatistics(double[] arr) {
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(arr);
        this.avgTemp = analysis.average();
        this.devTemp = analysis.deviation();
        this.minTemp = analysis.min();
        this.maxTemp = analysis.max();
    }   
    @Override
    public String toString() {
        return "Avg.temp: " + avgTemp 
                + "\nDev.temp: " + devTemp
                + "\nMin.temp: " + minTemp 
                + "\nMax.temp: " + maxTemp;
    }
}
