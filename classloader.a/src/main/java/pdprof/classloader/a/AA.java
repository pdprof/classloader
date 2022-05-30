package pdprof.classloader.a;

public class AA {
	public static void main(String args[]) {
		AA aa = new AA();
		aa.printClassLoader();
	}
	public void printClassLoader() {
		System.out.println(this.getClass().getName() + " is loaded from " + this.getClass().getClassLoader());
	}
	public void loadA() {
		try {
			Class.forName("pdprof.classloader.a.A");
			System.out.println("A is FOUND from " + this.getClass().getName());
		} catch (ClassNotFoundException e) {
			System.out.println("A is not found from " + this.getClass().getName());
		}
	}
	public void loadAA() {
		try {
			Class.forName("pdprof.classloader.a.AA");
			System.out.println("AA is FOUND from " + this.getClass().getName());
		} catch (ClassNotFoundException e) {
			System.out.println("AA is not found from " + this.getClass().getName());
		}
	}
	
	public void loadB() {
		try {
			Class.forName("pdprof.classloader.b.B");
			System.out.println("B is FOUND from " + this.getClass().getName());
		} catch (ClassNotFoundException e) {
			System.out.println("B is not found from " + this.getClass().getName());
		}
	}
	
	public void loadP() {
		try {
			Class.forName("pdprof.classloader.p.P");
			System.out.println("P is FOUND from " + this.getClass().getName());
		} catch (ClassNotFoundException e) {
			System.out.println("P is not found from " + this.getClass().getName());
		}
	}
}
