package pruebaThrow;


public class ProbExcep {

	public void metodo1() {
		try {
			metodo2();
		}	
		catch (Exception e){
			System.out.println("Metodo 1" + e.getMessage());
		}
	
	}
	
	private void metodo2() throws Exception {
		try {
			metodo3();
		}
		catch (Exception e){
			throw e;
		}
	}

	private void metodo3() throws Exception{
		try {
			int division = 1/0;
		}
		catch (Exception e){
			throw e;
		}
	}

}

