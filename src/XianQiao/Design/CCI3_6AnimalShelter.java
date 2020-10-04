//package XianQiao.Design;
//
//import java.util.LinkedList;
//
///**
// * @Author: Xianqiao
// * @Date: 6/22/20 22:27
// */
//
///** 设计 */
//
///** Animal Shelter: An animal shelter, which holds only dogs and cats, operates on a strictly"first in, first out"basis.
// *  People must adopt either the"oldest"(based on arrival time) of all animals at the shelter, or they can select whether
// *  they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot select which
// *  specific animal they would like. Create the data structures to maintain this system and implement operations such as
// *  enqueue, dequeueAny, dequeueDog, and dequeueCat. You may use the built-in LinkedList data structure. */
//
//public class CCI3_6AnimalShelter {
//    abstract class Animal {
//        private int order; //attributes 属性
//        protected String name;
//
//        public Animal(String name) { //构造函数（constructor function）只要创建一个animal就要往里放name
//            this.name = name;
//        }
//        public void setOrder(int order) {
//            this.order = order;
//        }
//        public int getOrder() {
//            return order;
//        }
//        public boolean isOlderThan(Animal a) {
//            return this.order < a.getOrder();
//        }
//
//
//        }
//    }
//// extends: 继承
//    class Dog extends CCI3_6AnimalShelter {
//        public Dog(String name) {
//            super(name);
//        }
//    }
//    class Cat extends CCI3_6AnimalShelter {
//        public Cat(String name) {
//            super(name);
//    }
//
//    public class AnimalShelter {
//            LinkedList<Dog> dog = new LinkedList<>();
//            LinkedList<Cat> cat = new LinkedList<>();
//            private int order = 0;
//
//            public void enqueue(CCI3_6AnimalShelter.Animal a) {
//                a.setOrder(order);
//                order++;
//                if (a instanceof Dog) {
//                    dog.addLast((Dog) a);
//                }
//                if (a instanceof Cat) {
//                    cat.addLast((Cat) a);
//                }
//            }
//
//            public CCI3_6AnimalShelter.Animal dequeueAny() {
//                if (dog.size() == 0 && cat.size() == 0) {
//                    return null;
//                }
//                if (dog.size() == 0) {
//                    return dequeueCat();
//                }
//                if (cat.size() == 0) {
//                    return dequeueDog();
//                }
//                Dog dogs = dog.peek();
//                Cat cats = cat.peek();
//                if (dogs.isOlderThan(cats)) {
//                    return dequeueDog();
//                } else {
//                    return dequeueCat();
//                }
//            }
//
//            public CCI3_6AnimalShelter.Animal dequeueCat() {
//                return cat.poll();
//            }
//            public CCI3_6AnimalShelter.Animal dequeueDog() {
//                return dog.poll();
//            }
//    }
//}
