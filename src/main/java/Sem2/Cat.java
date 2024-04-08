package Sem2;

class Cat extends Animal {
    private int livesLeft;

    public Cat(String name, int age, int livesLeft) {
        super(name, age);
        this.livesLeft = livesLeft;
    }

    public void makeSound() {
        System.out.println("Meow!");
    }

    public void climbTree() {
        System.out.println(name + " is climbing a tree.");
    }
}