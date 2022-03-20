package lockeme;


public class Testing  {
	public void WelcomeScreen() {
		System.out.println();
		System.out.println("*************************************************");
		System.out.println("*               LockedMe.com                    *");
		System.out.println("*************************************************");
		System.out.println("*      DEVELOPED BY GUNTI VENAKTA SUMANTH       *");
		
		System.out.println("            sumanth26.sv@gmail.com               ");
		System.out.println("*************************************************");
		 
		
		System.out.println("\n\n");
		
		
	}

	public static void main(String[] args) {
		
		 Testing t=new Testing();
	        Operations menu = new Operations();
	        t.WelcomeScreen();
	        System.out.println("*************************************************");
	        System.out.println("DIRECTORY : "+ menu.path.getAbsolutePath()        );
	        System.out.println("*************************************************");
	        System.out.println("\n\n");
	      
	        menu.showPrimaryMenu(); 
	        
	        
	    }

	}


