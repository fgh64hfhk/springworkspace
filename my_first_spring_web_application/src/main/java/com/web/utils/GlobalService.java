package com.web.utils;

import java.util.ArrayList;
import java.util.List;

import com.web.beans.Member;

public class GlobalService {
	static private List<Member> members = new ArrayList<Member>();
	
	static String database_type = "mysql";
	
	public static List<Member> getMembers() {
		return members;
	}

	public static String getDatabase_type() {
		return database_type;
	}

	public static void setMembers(List<Member> members) {
		GlobalService.members = members;
	}
	
}
