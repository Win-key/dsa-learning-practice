package archived.algorithms;

public class CountSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] stages = "STAGE_0,STAGE_0A,STAGE_0is,STAGE_I,STAGE_IA,STAGE_IA1,STAGE_IA2,STAGE_IB,STAGE_IB1,STAGE_IB2,STAGE_IC,STAGE_IE,STAGE_IS,STAGE_II,STAGE_IIA,STAGE_IIA1,STAGE_IIA2,STAGE_IIB,STAGE_IIC,STAGE_IIE,STAGE_IIS,STAGE_III,STAGE_IIIA,STAGE_IIIB,STAGE_IIIC,STAGE_IIIC1,STAGE_IIIC2,STAGE_IIIE,STAGE_IIIS,STAGE_IV,STAGE_IVA,STAGE_IVA1,STAGE_IVA2,STAGE_IVB,STAGE_IVC,STAGE_IVE,STAGE_IVS,STAGE_NOT_APPLICABLE,STAGE_Occult,STAGE_SNOMEDCT_UNKNOWN,STAGE_T1A1,STAGE_T1A2,STAGE_T1B,STAGE_T1B1,STAGE_T1B2,STAGE_UNKNOWN,STAGE_n,STAGE_X,STAGE_2A2,STAGE_2A1,STAGE_3C1,STAGE_3C2".split(",");
		for (int i=0; i< stages.length; i++){
		    System.out.println("INSERT INTO patientdb_public_stage (id, name) VALUES ('"+i+"','"+stages[i]+"');");
		} 

	}
	
	public int[] countSort(int[] unsorted) {
		
		// Create count array
		
		
		
		return unsorted;
	}

}
