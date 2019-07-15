//package DataStructure.ArrayList;
//import java.util.*;
//
//public class _690_EmployeeImportance_Recursion{
//
//	    public int getImportance(List<Employee> employees, int id) {
//        int importance = 0;
//        List<DataStructure.Integer> subordinates = new DataStructure.ArrayList<DataStructure.Integer>();
//        for(Employee e : employees){
//            if(e.id == id){
//                importance = e.importance;
//                subordinates = e.subordinates;
//                for(DataStructure.Integer i : subordinates)
//                    importance = importance + getImportance(employees,i);
//                    break;
//            }
//
//        }
//        return importance;
//    }
//}