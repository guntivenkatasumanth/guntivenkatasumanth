package lockeme;
	import java.io.File;
    import java.io.IOException;
	import java.util.Arrays;
	import java.util.Scanner;

	public class Operations {
	
		public void MainMenu() {
			System.out.println("=====================================");
			System.out.println("|            MAIN MENU              |");
			System.out.println("=====================================");
			System.out.println("| Select any one of the following:  |");
		    System.out.println("| 1 - List All Files                |");
		    System.out.println("| 2 - Add , Delete or Search a File |");
		    System.out.println("| 3 - Exit                          |");
		    System.out.println("=====================================");
		    System.out.println("Enter your choice : ");
		}
		
		public void subMenu() {
			
			System.out.println("=====================================");
			System.out.println("|            SUB MENU               |");
			System.out.println("=====================================");
			System.out.println("| Select any one of the following:  |");
		    System.out.println("|   a - Add a file                  |");
		    System.out.println("|   b - Delete a file               |");
		    System.out.println("|   c - Search a file               |");
		    System.out.println("|   d - Go Back to Main Menu        |");
		    System.out.println("=====================================");
		    System.out.println("Enter your choice : ");
			
		}
		//Method to exit the application
		public void exitScreen() {
			char decision=0;
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n Are you sure you want to exit ? ");
			System.out.println("  (Y) ==> Yes    (N) ==> No        ");
			decision =  scanner.nextLine().toUpperCase().charAt(0);
			if(decision == 'Y') {
				System.out.println("\n");
			
			System.out.println("*************************************************");
			System.out.println("*                                               *");
			System.out.println("*    THANK YOU FOR VISITING LockedMe.com        *");
			System.out.println("*                                               *");
			System.out.println("*************************************************");
			
			System.out.println("\n\n");
			System.exit(0);
			
			}
			else if(decision == 'N') {
				System.out.println("\n");
				showPrimaryMenu();
			}else {
				System.out.println("\nInvalid Input \nValid Inputs :(Y/N)\n");
				showPrimaryMenu();
			}
	}
	    // Options to Select from Main Menu
		void showPrimaryMenu() {
			MainMenu();
	        try{
	            Scanner scan = new Scanner(System.in);
	            
	            int option = scan.nextInt();
	            
	            switch (option){
	                case 1 : 
	                    ShowAllFiles();
	                    showPrimaryMenu();
	                    
	                
	                case 2 : 
	                    showSecondaryMenu();
	                    
	                
	                case 3 : 
	                	exitScreen();
	                	
	              
	                default: 
	                	System.out.println("Please enter 1, 2 or 3");
	                
	               
	            }showPrimaryMenu();
	            
	        }
	        catch (Exception e){
	            System.out.println("Please enter 1, 2 or 3");
	            showPrimaryMenu();
	        }
	    }

		//Options to select from Sub Menu
	    void showSecondaryMenu() {
	    	subMenu();
	       
	        try{
	            Scanner scanner = new Scanner(System.in);
	            
	            String option = scanner.nextLine().toLowerCase();
	            char decision=0;

	            switch (option){
	                case "a" : {
	                    System.out.print(" Adding a file...Please Enter the File Name : ");
	                    String filename = scanner.next().trim().toLowerCase();
	                    addFile(filename);
	                    break;
	                }
	                case "b" : {
	                	
	                	System.out.println("\n Are you sure you want to delete a File ? ");
						System.out.println("  (Y) ==> Yes    (N) ==> No        ");
						decision =  scanner.nextLine().toUpperCase().charAt(0);
						if(decision == 'Y') {
							System.out.println("\n");
							System.out.print(" Deleting a file...Please Enter the File Name : ");
		                    String filename = scanner.next().trim();
		                    deleteFile(filename);
		                    
							
						}else if(decision == 'N') {
							System.out.println("\n");
							showSecondaryMenu();
						}else {
							System.out.println("\nInvalid Input \nValid Inputs :(Y/N)\n");
							showSecondaryMenu();
						}
						break;
					
	                   
	                }
	                case "c" : {
	                    System.out.print(" Searching for a file...Please Enter the File Name : ");
	                    String filename = scanner.next().trim();
	                    searchFile(filename);
	                    break;
	                    
	                }
	                case "d": {
	                    System.out.println("Going Back to the Main Menu");
	                    showPrimaryMenu();
	                    break;
	                    
	                }
	                
	                default : System.out.println("Please enter a, b, c or d");
	                

	            }	showSecondaryMenu();
	        }
	        catch (Exception e){
	            System.out.println("Please enter a, b, c or d");
	            showSecondaryMenu();
	        }
	    }
	    String  DIRECTORY = System.getProperty("user.dir");
	      File  path = new File(DIRECTORY+"/files");
	      
	    // Method to show all Files in Ascending order
	    void ShowAllFiles() {
	        if (path.list().length==0)
	            System.out.println("EMPTY FOLDER");
	        else {
	            String[] list = path.list();
	            System.out.println("The files in "+ path +" are :");
	            Arrays.sort(list);
	            for (String str:list) {
	                System.out.println(str);
	            }
	            System.out.println("\nTotal Number of files: "+ list.length);	
	        }
	    }
         
	    //Method to add a File
	    void addFile(String filename) throws IOException {
	        File filepath = new File(path +"/"+filename);
	        String[] list = path.list();
	        for (String file: list) {
	            if (filename.equalsIgnoreCase(file)) {
	                System.out.println("File " + filename + " already created in " + path);
	                return;
	            }
	        }
	        filepath.createNewFile();
	        System.out.println("File "+filename+" added to "+ path);
	    }
        
	    //Method to remove a File
	    void deleteFile(String filename) {
	        File filepath = new File(path +"/"+filename);
	        String[] list = path.list();
	        for (String file: list) {
	            if (filename.equals(file) && filepath.delete()) {
	                System.out.println("File " + filename + " deleted from " + path +" Successfully");
	                return;
	            }
	        }
	        System.out.println(" FILE NOT FOUND (FNF)");
	    }
         
	    //Method to search a File
	    void searchFile(String filename) {
	        String[] list = path.list();
	        for (String file: list) {
	            if (filename.equals(file)) {
	                System.out.println("FOUND : File " + filename + " exists at " + path);
	                return;
	            }
	        }
	        System.out.println("FILE NOT FOUND (FNF)");
	    }

	}
		
		

	    