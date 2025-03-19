import java.io.*;

public class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    // Constructor
    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    // toString method to display student details
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', gpa=" + gpa + "}";
    }

    public static void main(String[] args) {
        Student student = new Student(1, "John Doe", 3.75);

        // Serialize the student object to a file
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("student.ser"))) {
            out.writeObject(student);  // Serialize student object
            System.out.println("Student serialized to student.ser");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
        }

        // Deserialize the student object from the file
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student deserializedStudent = (Student) in.readObject();  // Deserialize student object
            System.out.println("Deserialized Student: " + deserializedStudent);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
        }
    }
}

//OUTPUT

//Student serialized to student.ser
//Deserialized Student: Student{id=1, name='John Doe', gpa=3.75}
