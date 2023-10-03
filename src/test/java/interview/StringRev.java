package interview;

public class StringRev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "Hello Java";
		String revstr = "";
		
		for(int i=str.length()-1;i>=0;i--)
		{
			revstr = revstr + str.charAt(i);
		}
		
		System.out.println(revstr);

	}

}
