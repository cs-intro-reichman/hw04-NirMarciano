public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String str1 = "Hello     World";
        String str2 = "One two   tHRee   orld";
        String str3 = "vowels are   fun";
        String str4 = "intro  AND   yelloW";
        String str5 = "    Intro    to    coMPUter    sCIEncE      ";

        
        System.out.println(capVowelsLowRest(str1));
        System.out.println(capVowelsLowRest(str2));
        System.out.println(capVowelsLowRest(str3));
        System.out.println(capVowelsLowRest(str4));
        
        
        System.out.println(camelCase(str1));
        System.out.println(camelCase(str2));
        System.out.println(camelCase(str3));
        System.out.println(camelCase(str4));
        System.out.println(camelCase(str5));
        System.out.println(camelCase("AasJiaj"));
        

        allIndexOf(str1,'l');
        allIndexOf(str2,'e');
        allIndexOf(str3,' ');
        allIndexOf(str4,'D');
        allIndexOf(str5,'r');
        
    }

    public static String capVowelsLowRest (String string) {
        String Bigvowels = "AEIOU";
        String Smallvowels = "aeiou";
        String newStr = "";
        char c;

        for(int i = 0 ; i < string.length(); i++) {
            c = string.charAt(i);
            if(c == ' ') 
                newStr = newStr + " ";
            else if(Bigvowels.indexOf(c) != -1)
                    newStr = newStr + c;
                else if(Smallvowels.indexOf(c) != -1)
                        newStr = newStr + (char)(c - 32);
                    else if(c > 64 && c < 91) 
                            newStr = newStr + (char)(c + 32);
                        else newStr = newStr + c;
            } 
        
        return newStr;
    }

    public static String camelCase (String string) {
        String newStr = "";
        String changeStr = clearStartSpace(string);
        String word;

        if(changeStr.indexOf(' ') != -1) {
            word = changeStr.substring(0, changeStr.indexOf(' '));
            word = lowerCase(word);
        }
        else 
            word = lowerCase(changeStr);

        newStr = newStr + word;
        changeStr = changeStr.substring(word.length());

        while(changeStr != null && !justSpace(changeStr)) {
            changeStr = clearStartSpace(changeStr);
            if(changeStr.indexOf(' ') != -1) {
                word = changeStr.substring(0, changeStr.indexOf(' '));
                word = turnWord(word);
            }
            else 
                word = turnWord(changeStr);

            newStr = newStr + word;
            changeStr = changeStr.substring(word.length());
        }

        return newStr;
    }

    public static int[] allIndexOf (String string, char chr) {
        int count = 0;
        String str1 = string;
        String str2 = string;
        while(str1.indexOf(chr) != -1) {
            count++;
            str1 = str1.substring(str1.indexOf(chr) + 1);
        }

        int[] array = new int[count];
        int n;
        int m = 0;
        System.out.print("[");
        for(int i = 0; i < count; i++) {
            n = str2.indexOf(chr);
            m = m + n + 1;
            array[i] = m;
            str2 = str2.substring(n + 1);
           
            if(i == count - 1)
            System.out.print(array[i] + "]");
            else
            System.out.print(array[i] + ", ");
        }
        
        System.out.println();
        return array;
    }

    public static String lowerCase (String string) {
        String newStr = "";

        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) > 64 && string.charAt(i) < 91) 
                newStr = newStr + (char)(string.charAt(i) + 32);
            else 
                newStr = newStr + (char)(string.charAt(i));
        
        }
    return newStr;
    }

    public static String turnWord (String string) {
        String newStr = "";
        if(string.charAt(0) > 96 && string.charAt(0) < 123)
            newStr = newStr + (char)(string.charAt(0) - 32);
        else newStr = newStr +(char)(string.charAt(0));
        
        for(int i = 1; i < string.length(); i++) {
            if(string.charAt(i) > 64 && string.charAt(i) < 91) 
                newStr = newStr + (char)(string.charAt(i) + 32);
            else 
                newStr = newStr + (char)(string.charAt(i));
        }

        return newStr;
    }
    
    public static String clearStartSpace (String string) {
        String newStr;
        int n = 0;
        while(string.charAt(n) == ' ' && n < string.length()) {
            n++;
        }
        newStr = string.substring(n);
        return newStr; 
    }

    public static boolean justSpace (String string) {
        boolean check = true;
        boolean test = true;

        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ')
            check = false;
        test = test && check;
        }
        return test;
    }
}
