package practice.basic;
import java.lang.reflect.Method;
class CrunchifyReflectionTest {

	public void getCompany() {
		System.out.println("getCompany(): Value => no param");
	}
	public void getCompanyName(String companyName) {
		System.out.println("getCompanyName(): Value => " + companyName);
	}
	public void getCompanyPhone(String companyPhone,Integer companyId) {
		System.out.println("getCompanyPhone(): Value => " + companyPhone);
		System.out.println("getCompanyId(): Value => " + companyId );
	} 
}

public class ReflectionExample { 
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// no paramater
		Class<?> noparams[] = {};
		System.out.println("class name" + ReflectionExample.class.getName()); 
		// String parameter
		Class[] paramString = new Class[1];
		paramString[0] = String.class;
		// String parameter
		Class[] paramStringInt = new Class[2];
		paramStringInt[0] = String.class;
		paramStringInt[1] = Integer.class;
		
		try {
			// Load CrunchifyReflectionTest Class at runtime
			Class<?> cls = Class.forName("practice.basic.CrunchifyReflectionTest");
			Object obj = cls.newInstance();
 
			Method method = cls.getDeclaredMethod("getCompany", noparams);
			method.invoke(obj);
 
			method = cls.getDeclaredMethod("getCompanyName", paramString);
			method.invoke(obj, new String("Google"));
 
			method = cls.getDeclaredMethod("getCompanyPhone", paramStringInt);
			method.invoke(obj, new String("408.111.1111"),new Integer( 10) );
 
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
