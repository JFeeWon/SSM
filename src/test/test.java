package test;

import java.util.HashMap;
import java.util.Map;

public class test {
	public static void main(String[] args) {
//		Map map=new HashMap();
//		map.put("wjf","1");
//		System.out.println(map.put("wjf","2"));
//		System.out.println(map.size());
//		System.out.println(map.entrySet().size());
//		stu stu1=new stu();
//		stu1.id=1;
//		stu stu2=stu1;
//		System.out.println(stu1==stu2);
//		stu1=new stu();
//		System.out.println(stu1==stu2);
//		stu1.setId(2);
//		System.out.println(stu2.id);
		int n=6;
		 n |= n >>> 1;
	        n |= n >>> 2;
	        n |= n >>> 4;
	        n |= n >>> 8;
	        n |= n >>> 16;
		System.out.println(n+1);
	}
	static class stu{
		private int id;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
		
	}
}
