package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import java.util.InputMismatchException;

import org.junit.Test;

import ua.edu.ucu.apps.tempseries.TempSummaryStatistics;
import ua.edu.ucu.apps.tempseries.TemperatureSeriesAnalysis;

public class TemperatureSeriesAnalysisTest {
    @Test
    public void test() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }
    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }
    @Test
    public void testDeviation() {
        double[] tempSeries = {1, 2, 6};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double expectedDeviation = 2.6457513110646;
        assertEquals(expectedDeviation, analysis.deviation(), 0.00001);
    }

    @Test
    public void testMin() {
        double[] tempSeries = {1, 2, 6};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double expected = 1.0;
        assertEquals(expected, analysis.min(), 0.00001);
    }
    @Test
    public void testMax() {
        double[] tempSeries = {1, 2, 6};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double expected = 6.0;
        assertEquals(expected, analysis.max(), 0.00001);
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] tempSeries = {-2.0, 10, 2.0};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double expected = 2.0;
        assertEquals(expected, analysis.findTempClosestToZero(), 0.00001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] tempSeries = {-1, 5, 2, 3.5};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double expected = 2.0;
        assertEquals(expected, analysis.findTempClosestToValue(2.5), 0.00001);
    }

    @Test
    public void testFindTempsLessThan() {
        double[] tempSeries = {10, 15, 5};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double[] expected = {5};
        assertArrayEquals(expected, analysis.findTempsLessThen(10), 0.00001);
    }

    @Test
    public void testFindTempsGreaterThan() {
        double[] tempSeries = {10, 15, 5};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double[] expected = {15};
        assertArrayEquals(expected, analysis.findTempsGreaterThen(10), 0.00001);
    }

    @Test
    public void testSortTemps() {
        double[] tempSeries = {10, 5, 15};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(tempSeries);
        double[] expected = {5, 10, 15};
        assertArrayEquals(expected, analysis.sortTemps(), 0.00001);
    }

    @Test
    public void testAddTemps() {
        double[] initialTemps = {10, 15};
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis(initialTemps);
        int totalCount = analysis.addTemps(20, 25);
        assertEquals(4, totalCount);

        double[] expectedTemps = {10, 15, 20, 25};
        assertArrayEquals(expectedTemps, analysis.sortTemps(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        TemperatureSeriesAnalysis analysis = new TemperatureSeriesAnalysis();
        analysis.summaryStatistics();
    }
    
    @Test
    public void SummaryStatistics(){
        double[] temperatureSeries = {6, 0, -1, 7, -5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics summary = seriesAnalysis.summaryStatistics();
        String summar = summary.toString();
        assertEquals(summar, "Avg.temp: 1.4\n" + //
                        "Dev.temp: 5.029910535983717\n" + //
                        "Min.temp: -5.0\n" + //
                        "Max.temp: 7.0");
    }
   

}
