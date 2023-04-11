package Company.Stubhub.LocalDateTime;

import java.time.LocalDateTime;
import java.util.*;

class Event {
    String id;
    String name;
    String city;
    LocalDateTime eventDate;

    public Event(String id, String name, String city, LocalDateTime eventDate){
        this.id = id;
        this.name = name;
        this.city = city;
        this.eventDate = eventDate;
    }

    public LocalDateTime getTime(){
        return this.eventDate;
    }
}   

class Customer {
    String id;
    String name;
    String city;
    LocalDateTime birthDate;

    public Customer(String id, String name, String city, LocalDateTime birthDate){
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

    private void sendCustomerNotifications(Customer customer){
        for (Event event : events){
            if (event.city.equals(customer.city)) {
                System.out.println(
                    String.format("find out matched event : id is %s, name is %s, city is %s",
                     event.id, event.name, event.city));
            }
        }
    }

    private void sendCustomerNotificationsBasedOnBirthday(Customer customer){
        // get next birth day
        LocalDateTime curDateTime = LocalDateTime.now();
        int nextYear = curDateTime.getYear();
        if (curDateTime.getDayOfYear() > customer.birthDate.getDayOfYear()) {
            nextYear ++;
        }

        LocalDateTime nextBirthDate = LocalDateTime.of(nextYear, customer.birthDate.getMonthValue(), customer.birthDate.getDayOfMonth(), 0, 0, 0);

        Collections.sort(events, (e1, e2) -> (e1.eventDate.toString().compareTo(e2.eventDate.toString())));


        for (Event event : events){
            if (event.eventDate.isAfter(nextBirthDate)) {
                System.out.println(
                    String.format("*** find out matched event : id is %s, name is %s, city is %s, time is %s",
                     event.id, event.name, event.city,  event.eventDate));
                     return;
            }
        }

        System.out.println(String.format("no  matched event"));
    }

    private void sendCustomerNotificationsBirthday_MinCompare(Customer customer){
        // get next birth day
        LocalDateTime curDateTime = LocalDateTime.now();
        int nextYear = curDateTime.getYear();
        int maxDay = Integer.MAX_VALUE;
        int curD = curDateTime.getDayOfYear();
        int cursD = customer.birthDate.getDayOfYear();
        if (curDateTime.getDayOfYear() > customer.birthDate.getDayOfYear()) {
            nextYear ++;
        }

        LocalDateTime nextBirthDate = LocalDateTime.of(nextYear, customer.birthDate.getMonthValue(), customer.birthDate.getDayOfMonth(), 0, 0, 0);
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

    
    private void sendCustomerNotificationsBirthday_PQ(Customer customer){
        // get next birth day
        LocalDateTime curDateTime = LocalDateTime.now();
        int nextYear = curDateTime.getYear();
        if (curDateTime.getDayOfYear() > customer.birthDate.getDayOfYear()) {
            nextYear ++;
        }

        // String newTime = String.format("%d-%d-%d", nextYear, customer.birthDate.getMonthValue(), customer.birthDate.getDayOfMonth());
        LocalDateTime nextBirthDate = LocalDateTime.of(nextYear, customer.birthDate.getMonthValue(), customer.birthDate.getDayOfMonth(), 0, 0, 0);
        
        PriorityQueue<Event> pq = new PriorityQueue<Event>(new Comparator<Event>() {
            @Override
            public int compare(Event e1, Event e2){
                String gap1 = e1.eventDate.toString();
                String gap2 = e2.eventDate.toString();
                return gap1.compareTo(gap2);
            }
        });

        for (Event event : events){
            if (event.eventDate.isAfter(nextBirthDate)) {
                pq.add(event);
                if (pq.size() > count) {
                    pq.poll();
                }
            }
        }

        while(!pq.isEmpty()){
            Event event = pq.poll();
            System.out.println(
                    String.format("find out matched event : id is %s, name is %s, city is %s, time is %s",
                     event.id, event.name, event.city,  event.eventDate));
        }
    }

    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();

        events.add(new Event("1", "Phantom of the Opera", "New York",  LocalDateTime.parse("2023-12-30T19:34:50.63")));
        events.add(new Event("2", "Metallica", "Los Angeles", LocalDateTime.parse("2023-12-20T19:34:50.63")));
        events.add(new Event("3", "Metallica", "New York",  LocalDateTime.parse("2023-11-18T19:34:50.63")));
        events.add(new Event("4", "Metallica", "Boston", LocalDateTime.parse("2023-11-15T19:34:50.63")));
        events.add(new Event("5", "LadyGaGa", "New York", LocalDateTime.parse("2023-11-10T19:34:50.63")));
        events.add(new Event("6", "LadyGaGa", "Boston", LocalDateTime.parse("2023-10-25T19:34:50.63")));
        events.add(new Event("7", "LadyGaGa", "Chicago", LocalDateTime.parse("2023-09-26T19:34:50.63")));
        events.add(new Event("8", "LadyGaGa", "San Francisco", LocalDateTime.parse("2023-07-23T19:34:50.63")));
        events.add(new Event("9", "LadyGaGa", "Washington", LocalDateTime.parse("2022-11-23T19:34:50.63")));
        events.add(new Event("10", "Metallica", "Chicago", LocalDateTime.parse("2022-09-23T19:34:50.63")));
        events.add(new Event("11", "Phantom of the Opera", "San Francisco", LocalDateTime.parse("2022-08-23T19:34:50.63")));

        Map<String, City> cities = new HashMap<>();
        cities.put("a", new City("1", "a", 2, 2)); // 8
        cities.put("b", new City("2", "b", 3, 2)); // 13
        cities.put("c", new City("3", "c", 6, 2)); // 40
        cities.put("d", new City("4", "d", 1, 7)); // 50
        cities.put("e", new City("5", "e", 8, 2)); // 68
        cities.put("f", new City("7", "f", 1, 1)); // 2
        cities.put("g", new City("8", "g", 1, 0)); // 1
        cities.put("h", new City("9", "h", 4, 4)); // 32
        cities.put("New York", new City("6", "New York", 2, 2)); // 8


        Customer customer = new Customer("1", "John", "New York", LocalDateTime.parse("1992-10-08T19:34:50.63"));
        // Customer customer2 = new Customer("1", "John", "New York", LocalDate.parse("2024-10-08"));

        MarketEngine engine = new MarketEngine(events);
        MarketEngine engine2 = new MarketEngine(events, cities);

        engine.sendCustomerNotifications(customer);

        engine2.sendCustomerNotificationsBasedOnBirthday(customer);
        
        engine2.sendCustomerNotificationsBasedOnDistance("New York");

        engine2.sendCustomerNotificationsBirthday_MinCompare(customer);
    }
}
