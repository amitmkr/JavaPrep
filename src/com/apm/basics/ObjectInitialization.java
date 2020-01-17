package com.apm.basics;

import static com.apm.utils.Compare.*;

class Vehicle {
  public int vinNo;

  public Vehicle(int vinNo) {
    this.vinNo = vinNo;
  }
}

class Car extends Vehicle {

  public int fuelLevel;
  public boolean isGoodCondition;
  public Integer registrationNo;

  public int initializationBlockInit;

  public static int someOtherStatic;
  public static int initializationBlockInitStatic;

  static {
    initializationBlockInitStatic = 111; // Executed ONCE, when the CLASS is LOADED
  }

  {
    initializationBlockInit = 100; // Executed EVERY TIME an object is CONSTRUCTED

    initializationBlockInitStatic = 222;
  }

  public Car() {
    super(-1); // Have to call this as NO DEFAULT CTOR in parent
  }

  public Car(int vinNo, int fuelLevel, boolean isGoodCondition, int registrationNo) {
    super(vinNo);
    this.fuelLevel = fuelLevel;
    this.isGoodCondition = isGoodCondition;
    this.registrationNo = registrationNo;
  }

}

public class ObjectInitialization {

  public static void main(String[] args) {

    System.out.println(ObjectInitialization.class.getName());

    verifyEquality(Car.initializationBlockInitStatic, 111); // STATIC BLOCK INIT

    // DEFAULT INIT done for member variables not explicitly set
    // DOESNT HAPPEN for LOCAL variables
    Car defaultInitCar = new Car();
    verifyEquality(defaultInitCar.fuelLevel, 0);
    verifyEquality(defaultInitCar.isGoodCondition, false);
    verifyEquality(defaultInitCar.registrationNo, null);
    verifyEquality(defaultInitCar.initializationBlockInit, 100);

    verifyEquality(Car.someOtherStatic, 0);
    verifyEquality(Car.initializationBlockInitStatic, 222); // NON-STATIC BLOCK INIT
  }
}
