public class Student {
  private int id;
  private String name;
  private String grade;
  Student(int id,String name,String grade){
    this.id=id;
    this.name=name;
    this.grade=grade;
  }

  public int getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public String getGrade(){
    return this.grade;
  }

  public void setId(int id){
    this.id=id;
  }

  
  public void setName(String name){
     this.name=name;
  }

  public void setGrade(String grade){
    this.grade=grade;
  }
}
