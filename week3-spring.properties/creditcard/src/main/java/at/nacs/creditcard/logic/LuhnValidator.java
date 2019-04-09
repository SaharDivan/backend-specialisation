package at.nacs.creditcard.logic;

public class LuhnValidator {


        public Boolean isValidCreditCard(String cardNumber){
            if(isLengthMatched(cardNumber)){
                Integer totalSum=findTheLuhnSum(cardNumber);
                return isAValdLuhnNumber(totalSum);
            }
            return false;
        }




        private boolean isLengthMatched(String cardNumber) {
            return (cardNumber.length()<17 && cardNumber.length()>=13);
        }


        private Integer findTheLuhnSum(String cardNumber){
            Integer sumTheDoubledDigits = sumTheDoubledDigits(cardNumber);
            Integer totalSum=sumAllDigits(cardNumber,sumTheDoubledDigits);
            return totalSum;
        }


        private Integer sumTheDoubledDigits(String cardNumber) {
            Integer sumOfDoubled=0;
            int posOfDoubledDigit=cardNumber.length()-2;

            while (posOfDoubledDigit >=0){
                Integer digit=Character.getNumericValue(cardNumber.charAt(posOfDoubledDigit));
                if((digit*2) < 10){
                    sumOfDoubled += digit*2;
                }
                else {
                    sumOfDoubled += ((digit*2) % 10) + ((digit*2)/10);
                }
                posOfDoubledDigit=posOfDoubledDigit-2;
            }
            return sumOfDoubled;
        }

        private Integer sumAllDigits(String cardNumber, Integer sumOfDoubled) {
            int posOfNonDoubledDigit=cardNumber.length()-1;
            Integer sumOfNonDoubled=0;

            while (posOfNonDoubledDigit >=0){
                Integer digit=Character.getNumericValue(cardNumber.charAt(posOfNonDoubledDigit));
                sumOfNonDoubled += digit;
                posOfNonDoubledDigit=posOfNonDoubledDigit-2;
            }
            return sumOfDoubled+sumOfNonDoubled;
        }

        private Boolean isAValdLuhnNumber(Integer totalSum) {
            return totalSum % 10 == 0;
        }

    }


