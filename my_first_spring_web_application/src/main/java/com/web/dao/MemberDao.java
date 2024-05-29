package com.web.dao;

import java.util.List;

import com.web.beans.Member;

public interface MemberDao {
	public Member save(Member mem);

	public Member findById(Integer id);

	public boolean existsByUserId(String userId);

	public void update(Member mem);

	public void delete(Integer id);

	public List<Member> findAll();

}
