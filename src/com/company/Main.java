package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    //twoSum
    public int[] twoSum(int[] nums, int target) {
        List<Integer> smallerNumIndex = new ArrayList<Integer>();

        // for(int i = 0; i<nums.length;i++)
        // {
        //     if(nums[i]<=target)
        //     {
        //         smallerNumIndex.add(i);
        //     }
        // }
        // System.out.println(smallerNumIndex);

        int[] resultIndex = new int[2];

        for(int i = 0; i<nums.length;i++)
        {
            for(int j = i+1; j<nums.length;j++)
            {
                if(nums[i]+nums[j] == target)
                {
                    resultIndex[0]=i;
                    resultIndex[1]=j;
                }
            }
        }
        return resultIndex;
    }
    
//Todo: 0 detection
    class StringToInteger {
        public int myAtoi(String s) {

            //check if empty
            if(s.length()<1)
                return 0;

            //remove white space
            String noWhiteSpace = s.trim();

            if(noWhiteSpace.length()<1)
                return 0;

            //check sign
            boolean isNegative = false;
            char sign = noWhiteSpace.charAt(0);
            String signString = noWhiteSpace;

            if(sign == '-' ||sign == '+')
            {
                signString = noWhiteSpace.substring(1);
                if(sign == '-')
                {
                    isNegative = true;}
                if(sign == '+')
                {
                    isNegative = false;
                }
            }
            System.out.println(signString);

            //read digit
            List<Character> digit = new ArrayList<Character>();
            for(int i = 0; i<signString.length(); i++)
            {
                if(Character.isDigit(signString.charAt(i)))
                {
                    if(signString.charAt(i)!= '0')
                        digit.add(signString.charAt(i));
                }
                else
                    break;
            }
            System.out.println("digit "+digit);


            //convert to int
            StringBuilder sb = new StringBuilder();
            for(Character ch:digit)
            {
                sb.append(ch);
            }
            String numberString = sb.toString();

            int number;

            long input=0;

            if(digit.size()>0){
                if(digit.size()<11){
                    input = Long.parseLong(new String(numberString));
                }
                else
                {
                    input = (long)Math.pow(2,32);
                }
            }
            else
                number = 0;

            System.out.println("input "+input);

            //check if it is in the range
            if(isNegative)
            {
                input *= -1;
            }
            int upper = (int)Math.pow(2,31);
            int lower = (int)Math.pow(2,31)*(-1)-1;

            System.out.println("input after sign "+input);

            if(input < lower)
                number = lower;
            else if(input > upper)
                number = upper;
            else
                number = (int)input;

            return number;
        }


    }

    public static void main(String[] args) {
	// write your code here
    }
}
