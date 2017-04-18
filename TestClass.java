package queue_depth;

public class TestClass {

	public static void main(String[] args) {
	
		try{  
			QueueManager QM = new QueueManager("LPLWARD3860", 1414, "TESTQM.SVRCONN", "TESTQM");
			int depth = QM.depthOf("TESTQUEUE");
			System.out.println(depth);
			if (depth>0){
				System.out.println("tak");
			}
			}catch(Exception e){System.out.println("rest of the code...");  }  

　
	}

}
