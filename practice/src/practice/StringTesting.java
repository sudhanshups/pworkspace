package practice;
enum EasySingleton{
    INSTANCE,
	BA;
	
	EasySingleton(){
	}
}

class StringTesting {
    public static void main(String args[])
    {
    	
    	System.out.println(EasySingleton.INSTANCE.ordinal());
    	System.out.println(EasySingleton.BA.ordinal());
	   	
    	
        String str = "abcd";
        String str1 = new String("abcd");
        String str2 = str.substring(0,2);
        String str3 = str.substring(0,2);
        String str4 = str.substring(0,str.length());
        String str5 = str1.substring(0,2);
        String str6 = str1.substring(0,2);
        String str7 = str1.substring(0,str1.length());

        System.out.println(str2 == str3);
        System.out.println(str == str4);
        System.out.println(str5 == str6);
        System.out.println(str1 == str7);
        
        System.out.println(Long.parseLong("0"));
    }
}