package HospitalProjects.BMI;


import java.util.Scanner;

public class BodyMassIndexCalculator {
    private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;
    Scanner input = new Scanner(System.in);

    public void setName(String name){
        this.name = name;
        System.out.println("Hello, please Enter your name");
        this.name = input.next();
        System.out.println("Hello" +" " + this.name);
    }

    public String getName() {
        return name;
    }

    public void setAge(int age){

        System.out.println("How old are you?");
        age = input.nextInt();
        this.age = age;
    }

    public void setGender(String gender){
        System.out.println("Enter your gender");
        gender = input.next();
        this.gender = gender;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight(){
        return weight;
    }


    public void setFullInfo(){
        setName(name);
        setAge(age);
        setGender(gender);
       calculateHeight();
       calculateWeight();

    }
    public String toString(){
        System.out.println();
        return (name + "\n"+ "Your BMI is " + this.bmi());
    }
    public double bmi() {

        double bmi = getWeight() / (Math.pow(getHeight(), 2));


        if (bmi < 18.5) {
            System.out.println("Underweight");
        }
        if (bmi >= 18.5 && bmi <= 24.5) {
            System.out.println("Normal");
        }
        if (bmi >= 25 && bmi < 30) {
            System.out.println("Underweight");
        } else if (bmi >= 30){
            System.out.println("Obese");
        }
        System.out.println("BMI VALUES");
        System.out.println("Underweight: \tless than 18.5");
        System.out.println("Normal: \tbetween 18.5 and 24.9");
        System.out.println("Overweight: \tbetween 25 and 29.9");
        System.out.println("Obese: \t\t30 or greater");
return bmi;
    }
    public void calculateHeight(){
        System.out.println("""
                Enter Height in meters or foot
                Press 1 to enter height in meters
                Press 2 to enter height in foot
                """);

        int heightInput = input.nextInt();

        switch (heightInput){
            case 1-> {

                System.out.println("Enter height in meters");
                height = input.nextDouble();
//                setHeight(height);
                System.out.println(height);
            }

            case 2-> {
                System.out.println("Enter height in foot");
                height = input.nextDouble();
//                setHeight(height);
                height = height * (0.305);
                System.out.println(height);
            }
            default-> System.out.println();

        }
    }

    public void calculateWeight() {
        System.out.println("""
                Enter Weight in kg or pounds
                Press 1 to enter weight in pound
                Press 2 to enter weight in kg
                """);

        int weightInput = input.nextInt();

        switch (weightInput) {
            case 1 -> {

                System.out.println("Enter weight in kg");
                weight = input.nextDouble();
                System.out.println(weight);
            }

            case 2 -> {
                System.out.println("Enter weight in pounds");
                weight = input.nextDouble();
                weight = weight * (2.20462);
                System.out.println(weight);
            }
            default -> System.out.println();

        }
    }
    public static void main(String[] args) {
        BodyMassIndexCalculator bmiCalculator = new BodyMassIndexCalculator();
        Scanner userInput = new Scanner(System.in);
        int input;
        boolean quit = false;
        System.out.println("""
                Welcome to Jay's Bmi calculator
                Best Wishes
                                
                please press 1 to continue or 2 to cancel
                """);
        input = userInput.nextInt();
        while (!quit) {
            switch (input) {
                case 1 -> {
                    bmiCalculator.setFullInfo();
                    System.out.println();
                    System.out.println(bmiCalculator);
                    System.out.println(bmiCalculator.bmi());

break;
                }
                case 2 -> quit = true;


            }
        }

    }
}







