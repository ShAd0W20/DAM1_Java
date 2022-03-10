package models;

import java.util.ArrayList;

public class Student {
	public boolean isDeleted = false; // 1 byte
	public String studentName; //22 bytes
	public ArrayList<Subject> subjects = new ArrayList<Subject>(); //(4 + 42) * 4 bytes
}
