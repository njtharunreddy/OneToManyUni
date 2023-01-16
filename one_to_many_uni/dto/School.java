package one_to_many_uni.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int sid;
private  String schoolName;
private String schoolAddress;
@OneToMany
private List<Student> list;
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSchoolName() {
	return schoolName;
}
public void setSchoolName(String schoolName) {
	this.schoolName = schoolName;
}
public String getSchoolAddress() {
	return schoolAddress;
}
public void setSchoolAddress(String schoolAddress) {
	this.schoolAddress = schoolAddress;
}
public List<Student> getList() {
	return list;
}
public void setList(List<Student> list) {
	this.list = list;
}
@Override
public String toString() {
	return "School [sid=" + sid + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress + ", list=" + list
			+ "]";
}

}
