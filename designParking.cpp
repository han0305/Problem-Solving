/* Design a parking system for a parking lot. The parking lot has three kinds of parking spaces: big, medium, and small, with a fixed number of slots for each size.

Implement the ParkingSystem class:

ParkingSystem(int big, int medium, int small) Initializes object of the ParkingSystem class. The number of slots for each parking space are given as part of the constructor.
bool addCar(int carType) Checks whether there is a parking space of carType for the car that wants to get into the parking lot. carType can be of three kinds: big, medium, or small, which are represented by 1, 2, and 3 respectively. A car can only park in a parking space of its carType. If there is no space available, return false, else park the car in that size space and return true. */


class ParkingSystem {
public:
    
    int bigSize, mediumSize,smallSize;
    int bc,mc,sc;
    ParkingSystem(int big, int medium, int small) {
        this->bigSize = big;
        this->smallSize = small;
        this->mediumSize = medium;
        this->bc=this->mc=this->sc=0;
    }
    
    bool addCar(int carType) {
        if(carType == 1) {
            if(this->bc == this->bigSize) 
                return false;
            else {
                this->bc++;
                return true;
            }
        }
        else if(carType == 2) {
            if(this->mc == this->mediumSize) 
                return false;
            else {
                this->mc++;
                return true;
            }
        }
        else {
             if(this->sc == this->smallSize) 
                return false;
            else {
                this->sc++;
                return true;
            }
            
        }
    }
};

