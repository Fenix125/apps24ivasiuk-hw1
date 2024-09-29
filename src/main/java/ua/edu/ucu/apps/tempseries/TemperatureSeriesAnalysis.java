package ua.edu.ucu.apps.tempseries;
import java.util.InputMismatchException; 

public class TemperatureSeriesAnalysis {
    private double[] arraytemp = {};
    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.arraytemp = temperatureSeries;
    }

    public double average() {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double avr = 0d;
        for (double el : arraytemp) {
            avr += el;
        }
        return avr/arraytemp.length;
    }

    public double deviation() {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double dev = 0;
        double mean = average();
        for (double el : arraytemp) {
            dev += (el - mean)*(el - mean);
        }
        dev = dev / (arraytemp.length-1);
        return Math.sqrt(dev);
    }

    public double min() {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double min = arraytemp[0];
        for (double el : arraytemp) {
            if (el < min) {
                min = el;
            }
        }
        return min;
    }

    public double max() {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double max = arraytemp[0];
        for (double el : arraytemp) {
            if (el > max) {
                max = el;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double closest = arraytemp[0];
        for (int el = 1; el < arraytemp.length; el++) {
            if (Math.abs(arraytemp[el]) <= Math.abs(closest)) {
                if (Math.abs(arraytemp[el]) == Math.abs(closest)) {
                    closest = Math.abs(arraytemp[el]);
                }
                else {
                    closest = arraytemp[el];
                }
            }
        }
        return closest;
    }

    public double findTempClosestToValue(double tempValue) {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestNum = arraytemp[0];
        double closestLen = Math.abs(closestNum - tempValue);
        for (int el = 1; el < arraytemp.length; el++) {
            if (Math.abs(arraytemp[el]-tempValue) < closestLen) {
                closestLen = Math.abs(arraytemp[el]-tempValue);
                closestNum = arraytemp[el];
            }
            
        }
        return closestNum;
    }

    public double[] findTempsLessThen(double tempValue) {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] temp = new double[arraytemp.length];
        int count = 0;
        for (double el : arraytemp) {
            if (el < tempValue) {
                temp[count] = el;
                count += 1;
            }
        }
        double[] res = new double[count];
        System.arraycopy(temp, 0, res, 0, count);
        return res;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] temp = new double[arraytemp.length];
        int count = 0;
        for (double el : arraytemp) {
            if (el > tempValue) {
                temp[count] = el;
                count += 1;
            }
        }
        double[] res = new double[count];
        System.arraycopy(temp, 0, res, 0, count);
        return res;
    }

    public double[] findTempsInRange(double lowerBound, double upperBound) {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] temp = new double[arraytemp.length];
        int count = 0;
        for (double el : arraytemp) {
            if (upperBound > el && el > lowerBound) {
                temp[count] = el;
                count += 1;
            }
        }
        double[] res = new double[count];
        System.arraycopy(temp, 0, res, 0, count);
        return res;
    }

    public void reset() {
        this.arraytemp = new double[0];

    }

    public double[] sortTemps() {
        if (arraytemp.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] res = arraytemp;
        for (int i = 0; i < res.length; i++) {
            double key = res[i];
            int j = i - 1;
            while (j >= 0 && res[j] > key) {
                res[j + 1] = res[j];
                j--;

            }
            res[j+1] = key;
        }
        return res;
    }

    public TempSummaryStatistics summaryStatistics() {
        if (arraytemp.length == 0 ) {
            throw new IllegalArgumentException();
        }
        TempSummaryStatistics summaryStatistics
        = new TempSummaryStatistics(arraytemp);
        return summaryStatistics;
    }

    public int addTemps(double... temps) {
        for (double el : arraytemp) {
            if (el <= -272.0) {
                throw new InputMismatchException();
            }
        }
        int total = arraytemp.length + temps.length;
        double[] newArr = new double[arraytemp.length + temps.length];
        System.arraycopy(arraytemp, 0, newArr, 0, arraytemp.length);
        int idx = 0;
        for (int i = arraytemp.length; i < newArr.length; i++) {
            newArr[i] = temps[idx];
            idx += 1;
        }
        arraytemp = newArr;
        return total;
    }
}
