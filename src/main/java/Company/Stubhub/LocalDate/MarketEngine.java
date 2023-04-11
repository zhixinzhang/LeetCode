package Company.Stubhub.LocalDate;

import java.time.*;
import java.util.*;

class Event {
    String id;
    String name;
    String city;
    LocalDate eventDate;

    public Event(String id, String name, String city, LocalDate eventDate){
        this.id = id;
        this.name = name;
        this.city = city;
        this.eventDate = eventDate;
    }

    public LocalDate getTime(){
        return this.eventDate;
    }
}   

class Customer {
    String id;
    String name;
    String city;
    LocalDate birthDate;

    public Customer(String id, String name, String city, LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.city = city;
        this.birthDate = birthDate;
    }
}

class City {
    public String id;
    public String name;
    public int x;
    public int y;

    public City(String id, String name, int x, int y){
        this.id = id;
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

public class MarketEngine {
    static List<Event> events = new ArrayList<>();
    static Map<String, City> cities = new HashMap<>();
    static int count = 5;
    
    public MarketEngine(List<Event> events){
        this.events = events;
    }

    public MarketEngine(List<Event> events, Map<String, City> cities){
        this.events = events;
        this.cities = cities;
    }

    private void sendCustomerNotifications(Customer customer){
        for (Event event : events){
            if (event.city.equals(customer.city)) {
                System.out.println(
                    String.format("find out matched event : id is %s, name is %s, city is %s",
                     event.id, event.name, event.city));
            }
        }
    }

    private void sendCustomerNotificationsBasedOnDistance(String cityName){
        List<City> cityList = new ArrayList<>(cities.values());
        City curCity = cities.get(cityName);
        Double disCity = Math.pow(curCity.x, 2) + Math.pow(curCity.y, 2);

        PriorityQueue<City> pq = new PriorityQueue<City>(new Comparator<City>() {
            @Override
            public int compare(City c1, City c2){
                Double dis1 = Math.pow(c1.x, 2) + Math.pow(c1.y, 2);
                Double dis2 = Math.pow(c2.x, 2) + Math.pow(c2.y, 2);

                return Double.compare(Math.abs(disCity - dis2), Math.abs(disCity - dis1));
            }
        });

        for (City c : cityList){
            pq.add(c);
            if (pq.size() > count) {
                pq.poll();
            }
        }

        while(!pq.isEmpty()){
            City city = pq.poll();
            System.out.println(
                String.format("find out matched city : id is %s, name is %s, x is %d,  y is %d",
                city.id, city.name, city.x, city.y));
        }
    }

    private void sendCustomerNotificationsBirthday_MinCompare(Customer customer){
        // get next birth day
        LocalDate curDateTime = LocalDate.now();
        int nextYear = curDateTime.getYear();
        int maxDay = Integer.MAX_VALUE;
        if (curDateTime.getDayOfYear() > customer.birthDate.getDayOfYear()) {
            nextYear ++;
        }

        LocalDate nextBirthDate = LocalDate.of(nextYear, customer.birthDate.getMonthValue(), customer.birthDate.getDayOfMonth());
        Event nearestEvent = null;
        for (Event event : events){
            if (event.eventDate.isAfter(nextBirthDate) || event.eventDate.isEqual(nextBirthDate)) {
                int day = event.eventDate.getDayOfYear();
                if (day < maxDay) {
                    nearestEvent = event;
                    maxDay = day;
                }
            }
        }

        if (nearestEvent != null) {
            System.out.println(String.format("sendCustomerNotificationsBirthday_MinCompare : nearest event is  %s,  event date is %s", nearestEvent.id, nearestEvent.eventDate));
        } else {
            System.out.println("no matched event");
        }
    }

    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();

        events.add(new Event("1", "Phantom of the Opera", "New York",  LocalDate.parse("2023-12-23")));
        events.add(new Event("2", "Metallica", "Los Angeles", LocalDate.parse("2023-12-20")));
        events.add(new Event("3", "Metallica", "New York",  LocalDate.parse("2023-11-18")));
        events.add(new Event("4", "Metallica", "Boston", LocalDate.parse("2023-11-15")));
        events.add(new Event("5", "LadyGaGa", "New York", LocalDate.parse("2023-11-10")));
        events.add(new Event("6", "LadyGaGa", "Boston", LocalDate.parse("2023-10-25")));
        events.add(new Event("7", "LadyGaGa", "Chicago", LocalDate.parse("2023-09-26")));
        events.add(new Event("8", "LadyGaGa", "San Francisco", LocalDate.parse("2023-07-23")));
        events.add(new Event("9", "LadyGaGa", "Washington", LocalDate.parse("2022-11-23")));
        events.add(new Event("10", "Metallica", "Chicago", LocalDate.parse("2022-09-23")));
        events.add(new Event("11", "Phantom of the Opera", "San Francisco", LocalDate.parse("2022-08-23")));

        Map<String, City> cities = new HashMap<>();
        cities.put("a", new City("1", "a", 2, 2)); // 8
        cities.put("b", new City("2", "b", 3, 2)); // 13
        cities.put("c", new City("3", "c", 6, 2)); // 40
        cities.put("d", new City("4", "d", 1, 7)); // 50
        cities.put("e", new City("5", "e", 8, 2)); // 68
        cities.put("f", new City("7", "f", 1, 1)); // 2
        cities.put("g", new City("8", "g", 1, 0)); // 1
        cities.put("h", new City("9", "h", 4, 4)); // 32
        cities.put("i", new City("9", "i", 8, 4)); // 80
        cities.put("j", new City("9", "j", 8, 1)); // 65
        cities.put("New York", new City("6", "New York", 8, 3)); // 64 + 9 - 73


        Customer customer = new Customer("1", "John", "New York", LocalDate.parse("1992-10-08"));
        // Customer customer2 = new Customer("1", "John", "New York", LocalDate.parse("2024-10-08"));

        MarketEngine engine = new MarketEngine(events);
        MarketEngine engine2 = new MarketEngine(events, cities);
        engine.sendCustomerNotifications(customer);

        engine2.sendCustomerNotificationsBirthday_MinCompare(customer);

        engine2.sendCustomerNotificationsBasedOnDistance("New York");

    }
}
