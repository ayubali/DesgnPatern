package SingletonPattern;


/**
 * Simple Singleton example lazzy initialization process, works absolutely fine in a single threaded environment
 * @author ayub.ali
 */
class SingletonSimple {
	private static SingletonSimple singleton = null;

	private SingletonSimple() {
	}

	public static SingletonSimple getSingletonInstance() {
		if (null == singleton) {
			singleton = new SingletonSimple();
		}
		return singleton;
	}

	public void printSingleton() {
		System.out.println("SingletonSimple");
	}
}

/*
 * Simple Synchronized version
 * 
 */
class  SingletonExample2{
	private static SingletonExample2 singleton = null;

	private SingletonExample2() {
	}

	public static synchronized SingletonExample2 getSingletonInstance() {
		if (null == singleton) {
			singleton = new SingletonExample2();
		}
		return singleton;
	}
	public void printSingleton() {
		System.out.println("SingletonExample2");
	}
}


class SingletonExample3 {
	private static SingletonExample3 singleton=null;
	
	private SingletonExample3(){
		
	}
	private static SingletonExample3 getSingletonInstance()
	{
		if(null == singleton)
		{
			synchronized (SingletonExample3.class) {
				if(null== singleton)
				{
					singleton = new SingletonExample3();
				}
			}
		}
		return singleton;
	}
}

public class SingletonPattern {

	public static void main(String[] args) {
 
		
		SingletonSimple simple = SingletonSimple.getSingletonInstance();
		simple.printSingleton();
	}

}
