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


    public void setHeight(double height){
        System.out.println("Enter height in meters");
        height = input.nextDouble();
        this.height = height;
        }



    public double getHeight() {
        return height;
    }
    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){
        System.out.println("Enter Weight in kilograms");
        weight = input.nextDouble();
        this.weight = weight;
    }

    public void setFullInfo(){
        setName(name);
        setAge(age);
        setGender(gender);
       setHeight(height);
        setWeight(weight);

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
//    public void calculateHeight(){
//        System.out.println("Enter Height in meters or feet");
//        double height = input.nextDouble();
//
//        switch ((int) height){
//            case 1:
//                System.out.println("Enter height in meters");
//                height = input.nextInt();
//                height = height * (1.0);
//                this.height = height;
//
//            case 2:
//                System.out.println("Enter height in foot");
//                height = input.nextInt();
//                height = height*(0.305);
//                this.height = height;
//
//
//        }
//    }

    public void calculateWeight(){

    }
    public static void main(String[] args) {
        BodyMassIndexCalculator bmiCalculator = new BodyMassIndexCalculator();
        Scanner userInput = new Scanner(System.in);
        int input;
        System.out.println("""
                Welcome to Jay's Bmi calculator
                Best Wishes
                                
                please press 1 to continue or 2 to cancel
                """);
        input = userInput.nextInt();
        while (input != 2) {
            switch (input) {
                case 1 -> {
                    bmiCalculator.setFullInfo();
                    System.out.println();
                    System.out.println(bmiCalculator);
                    System.out.println(bmiCalculator.bmi());


                }
                case 2 -> {
                    input = 1;

                }


            }
        }

    }
}







