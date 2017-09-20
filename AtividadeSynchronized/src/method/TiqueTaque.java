package method;

public class TiqueTaque {
		
	boolean tique;
	
	synchronized void tique(boolean estaExecutanto)
	{	
		if(!estaExecutanto){
			tique = true;
			notify();
			return;
		}
		
		System.out.print("Tique");
		
		tique = true;
		
		//notify();
		
		try{
			while(tique){
				wait();
			}
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
	synchronized void taque(boolean estaExecutanto)
	{	
		if(!estaExecutanto){
			tique = false;
			//notify();
			return;
		}
		
		System.out.println("Taque");
		
		tique = false;
		
		notify();
		
		try{
			while(!tique){
				wait();
			}
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
}