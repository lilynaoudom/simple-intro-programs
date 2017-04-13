
public class Student {

		String name;
		String id;
		int grade;
		
		public Student(String n, String i, int g){
			name = n;
			id = i;
			grade = g;
		}
		
		public String toString(){
			return "Name: " + name + "\nID: " + id + "\nGrade: " + grade;
		}
		
		//promote student to the next class grade
		public boolean promote(){
			grade++;
			return !(grade > 12);
		}
		
		public String getName(){
			return name;
		}
		public String getID(){
			return id;
		}
		
}
