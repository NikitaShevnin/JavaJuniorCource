package Sem2;

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public void makeSound() {
        System.out.println("Woof!");
    }

    public void fetchBall() {
        System.out.println(name + " is fetching the ball.");
    }
}