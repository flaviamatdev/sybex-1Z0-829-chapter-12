package zoo.tours.reservations;

import java.util.*;
import zoo.tours.api.*;

public class TourFinder {

    public static Tour findSingleTour() {
        ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
        for (Tour tour : loader) {
            return tour;
        }
        return null;
    }

    public static List<Tour> findAllTours() {
        List<Tour> tours = new ArrayList<>();
        ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
        for (Tour tour : loader) {
            tours.add(tour);
        }
        return tours;
    }

    public static List<Tour> findAllToursUsingStream() {
        ServiceLoader<Tour> loader = ServiceLoader.load(Tour.class);
        return loader.stream()
            .map(ServiceLoader.Provider::get)
            .toList();
    }
}
