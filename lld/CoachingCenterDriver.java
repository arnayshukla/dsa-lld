package com.practice.java.lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CoachingCenterDriver {
  public static void main(String[] args) {
    /*
     * Driver Program can be written using one's own input format
     */
  }
}


class CoachingCenter {
  private String id;
  private String name;
  private String pincode;
  
  public CoachingCenter() {}
  
  public CoachingCenter(String id, String name, String pincode) {
    super();
    this.id = id;
    this.name = name;
    this.pincode = pincode;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPincode() {
    return pincode;
  }

  public void setPincode(String pincode) {
    this.pincode = pincode;
  }

}

class Session {
   String id;
  int startTime;
  int endTime;
  boolean isbooked;

  
  public Session() {}

  public Session(String id, int startTime, int endTime, boolean isbooked) {
    super();
    this.id = id;
    this.startTime = startTime;
    this.endTime = endTime;
    this.isbooked = isbooked;
  }
  public int getStartTime() {
    return startTime;
  }

  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }

  public int getEndTime() {
    return endTime;
  }

  public void setEndTime(int endTime) {
    this.endTime = endTime;
  }

  public boolean getIsbooked() {
    return isbooked;
  }

  public void setIsbooked(boolean isbooked) {
    this.isbooked = isbooked;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}

class Teacher {
  private String id;
  private String coachingCenterId;
  private String name;
  private String subject;
  List<Session> doubtSessions;

  public Teacher() { }

  public Teacher(String id, String coachingCenterId, String name, String subject, List<Session> doubtSessions) {
    super();
    this.id = id;
    this.coachingCenterId = coachingCenterId;
    this.name = name;
    this.subject = subject;
    this.doubtSessions = doubtSessions;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getCoachingCenterId() {
    return coachingCenterId;
  }
  public void setCoachingCenterId(String coachingCenterId) {
    this.coachingCenterId = coachingCenterId;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public List<Session> getDoubtSessions() {
    return doubtSessions;
  }
  public void setDoubtSessions(List<Session> doubtSessions) {
    this.doubtSessions = doubtSessions;
  }

}

class Student {
  private String id;
  private String name;
  private List<Session> bookedSessions;
  private String coachingCenterId;

  public Student() {}

  public Student(String id, String name, List<Session> bookedSessions, String coachingCenterId) {
    this.id = id;
    this.name = name;
    this.bookedSessions = bookedSessions;
    this.coachingCenterId = coachingCenterId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Session> getBookedSessions() {
    return bookedSessions;
  }

  public void setBookedSessions(List<Session> bookedSessions) {
    this.bookedSessions = bookedSessions;
  }

  public String getCoachingCenterId() {
    return coachingCenterId;
  }

  public void setCoachingCenterId(String coachingCenterId) {
    this.coachingCenterId = coachingCenterId;
  }

}

class CoachingCenterService {
  private static Map<String, CoachingCenter> coachingCenters = new HashMap<>();

  void addCoachingCenter(String id, String name, String pincode) {
    CoachingCenter coachingCenter = new CoachingCenter();
    coachingCenter.setId(id);
    coachingCenter.setName(name);
    coachingCenter.setPincode(pincode);
    coachingCenters.put(coachingCenter.getId(), coachingCenter);
    System.out.println("created teacher with id: " + coachingCenter.getId());
  }

  CoachingCenter getCoachingCenterById(String coachingCenterId) {
    return coachingCenters.get(coachingCenterId);
  }

  List<CoachingCenter> getCoachingCenterList() {
    return new ArrayList<>(coachingCenters.values());
  }

}

class TeacherService {
  private static Map<String, Teacher> teachers = new HashMap<>();
  CoachingCenterService coachingCenterService = new CoachingCenterService();

  void addTeacher(String id, String name, String subject) {
    Teacher teacher = new Teacher();
    teacher.setId(id);
    teacher.setName(name);
    teacher.setSubject(subject);
    teacher.setCoachingCenterId(coachingCenterService.getCoachingCenterList().get(0).getId());
    teachers.put(teacher.getId(), teacher);
    System.out.println("created teacher with id: " + teacher.getId());
  }

  Teacher getTeacherById(String teacherId) {
    return teachers.get(teacherId);
  }

  List<Teacher> getTeacherList() {
    return new ArrayList<>(teachers.values());
  }

  void addSession(String teacherId, String sessionId, int startTime, int endTime) {
    Session session = new Session(sessionId, startTime, endTime, false);
    Teacher teacher = getTeacherById(teacherId);
    teacher.getDoubtSessions().add(session);
  }

}

class StudentService {

  private static Map<String, Student> students = new HashMap<>();
  CoachingCenterService coachingCenterService = new CoachingCenterService();

  void addStudent(String id, String name, String subject) {
    Student student = new Student();
    student.setId(id);
    student.setName(name);
    student.setCoachingCenterId(coachingCenterService.getCoachingCenterList().get(0).getId());
    students.put(student.getId(), student);
    System.out.println("created student with id: " + student.getId());
  }

  Student getStudentById(String studentId) {
    return students.get(studentId);
  }

  List<Student> getStudentList() {
    return new ArrayList<>(students.values());
  }
}
  
class SessionService {
  TeacherService teacherService = new TeacherService();
  StudentService studentService = new StudentService();

  void displayAllAvailableSessions() {
    List<Teacher> teachers = teacherService.getTeacherList();
    for (Teacher teacher : teachers) {
      System.out.println("Session for " + teacher.getSubject() + " with " + teacher.getName() + " are available as follows: - ");
      for (Session session : teacher.getDoubtSessions()) {
        if (!session.getIsbooked()) {
          System.out.println("Session Id: " + session.getId() + ", Start Time: " + session.getStartTime() + ", End Time: " + session.getEndTime());  
        }
      }
    }
  }

  void displayAllAvailableSessionsBySubject(String subject) {
    List<Teacher> teachers = teacherService.getTeacherList();
    for (Teacher teacher : teachers) {
      if (teacher.getSubject().equals(subject)) {
        System.out.println("Session for " + teacher.getSubject() + " with " + teacher.getName() + " are available as follows: - ");
        for (Session session : teacher.getDoubtSessions()) {
          if (!session.getIsbooked()) {
            System.out.println("Session Id: " + session.getId() + ", Start Time: " + session.getStartTime() + ", End Time: " + session.getEndTime());  
          }
        }
      }
    }
  }

  void bookASession(String studentId, String teacherId, String sessionId) {
    Teacher teacher = teacherService.getTeacherById(teacherId);
    Student student = studentService.getStudentById(studentId);
    Optional<Session> optionalSession = teacher.getDoubtSessions().stream().filter(s -> !s.getIsbooked() && s.getId().equals(sessionId)).findFirst();
    if (!optionalSession.isPresent()) {
      System.out.println("Either session is booked or details are incorrect. Please try again");
      return;
    }
    Session session = optionalSession.get();
    session.setIsbooked(true);
    student.getBookedSessions().add(session);
  }

}



