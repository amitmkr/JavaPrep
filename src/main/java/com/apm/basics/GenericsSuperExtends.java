package com.apm.basics;

public class GenericsSuperExtends {

  static abstract class Animal {
    public String name;

    Animal(String name) {
      this.name = name;
    }

    public abstract void saySomething();
  }

  static class Dog extends Animal {

    public Dog(String name) {
      super(name);
    }

    @Override
    public void saySomething() {
      System.out.println(this.getClass().getSimpleName() + " " + name + " says  BARK");
    }
  }

  static class Cat extends Animal {

    public Cat(String name) {
      super(name);
    }

    @Override
    public void saySomething() {
      System.out.println(this.getClass().getSimpleName() + " " + name + " says MEOW");
    }
  }

  static <T extends Animal> void AnimalSaySomething(T animal) {
    animal.saySomething();
  }

  //static <? super Animal> void AnimalSaySomething2(T animal) {
  //  animal.saySomething();
  //}

  public static void main(String[] args) {

    Dog dog = new Dog("Tommy");
    Cat cat = new Cat("Catty");

    AnimalSaySomething(dog);
    AnimalSaySomething(cat);
  }
}
