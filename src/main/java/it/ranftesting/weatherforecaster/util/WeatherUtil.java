package it.ranftesting.weatherforecaster.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherUtil {

    private WeatherUtil() {
    }

    // media circolare: la media normale degli angoli e' sbagliata (350 e 10 deve dare 0, non 180)
    public static Double circularMean(List<Integer> degrees) {
        if (degrees == null || degrees.isEmpty()) {
            return null;
        }
        double sumSin = 0;
        double sumCos = 0;
        int count = 0;
        for (Integer d : degrees) {
            if (d == null) {
                continue;
            }
            sumSin += Math.sin(Math.toRadians(d));
            sumCos += Math.cos(Math.toRadians(d));
            count++;
        }
        // direzioni opposte (es. 0 e 180) si annullano: nessuna media sensata
        if (count == 0 || Math.hypot(sumSin, sumCos) / count < 1e-9) {
            return null;
        }
        double mean = (Math.toDegrees(Math.atan2(sumSin, sumCos)) + 360) % 360;
        return round(mean) % 360;
    }

    // valore piu' frequente (a parita' vince il minore)
    public static String mostFrequent(List<String> values) {
        if (values == null) {
            return null;
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String v : values) {
            if (v != null) {
                counts.merge(v, 1, Integer::sum);
            }
        }
        String best = null;
        int bestCount = 0;
        for (Map.Entry<String, Integer> e : counts.entrySet()) {
            boolean moreFrequent = e.getValue() > bestCount;
            boolean tieButSmaller = e.getValue() == bestCount && e.getKey().compareTo(best) < 0;
            if (moreFrequent || tieButSmaller) {
                best = e.getKey();
                bestCount = e.getValue();
            }
        }
        return best;
    }

    public static Double round(Double value) {
        if (value == null) {
            return null;
        }
        return Math.round(value * 10.0) / 10.0;
    }
}