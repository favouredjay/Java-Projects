package CheckOutApp;

public class Conversion {
        private static final String[] units = {
                "",
                "One ",
                "Two ",
                "Three ",
                "Four ",
                "Five ",
                "Six ",
                "Seven ",
                "Eight ",
                "Nine "
        };

        private static final String[] tensToNineteen = {
                "Ten ",
                "Eleven ",
                "Twelve ",
                "Thirteen ",
                "Fourteen ",
                "Fifteen ",
                "Sixteen ",
                "Seventeen ",
                "Eighteen ",
                "Nineteen ",
        };

        private static final String[] tensToNinety = {
                "",
                "",
                "Twenty",
                "Thirty",
                "Forty",
                "Fifty",
                "Sixty",
                "Seventy",
                "Eighty",
                "Ninety",
        };
        private static final String[] unitsForHundreds = {
                "",
                "One hundred ",
                "Two hundred ",
                "Three hundred and ",
                "Four hundred and ",
                "Five hundred ",
                "Six hundred and ",
                "Seven hundred and ",
                "Eight hundred and ",
                "Nine hundred "
        };

        private static final String[] zerothValue = {
                "",
                "Thousand ",
                "Million ",
                "Billion ",
        };

        public static void main(String[] args) {




            System.out.println(mainConversion(20000000));


        }

        public static String mainConversion(long number){
            StringBuilder output = new StringBuilder();
            int counter = 0;

            while (number > 0){
                int num = (int) (number % 1000);
                if (num != 0){
                    String newOutput = thousandOperation(num);
                    output.insert(0, newOutput + zerothValue[counter] + "Naira only");
                }

                number = number / 1000;
                counter++;
            }

            return output.toString();

        }


        public static String thousandOperation(long number){
            int num = (int) number % 100;
            String outputString = "";
            if (num < 10){
                outputString = outputString + units[num];
            }
            else if (num < 20){
                outputString = outputString + tensToNineteen[num % 10];
            }
            else{

                outputString = tensToNinety[num / 10] + " " + units[num % 10];
            }

            if (number / 100  > 0)
                return unitsForHundreds[(int) (number / 100)] + outputString;
            else
                return outputString;
        }
    }


