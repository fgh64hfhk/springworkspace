package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.web.beans.Member;
import com.web.dao.MemberDao;

@Service("memberServiceInMemory")
public class MemberServiceInMemoryImpl implements MemberService {

	@Autowired
	@Qualifier("MemberRepositoryInMemory")
	MemberDao memberDao;

	@Override
	public Member save(Member member) {
		return memberDao.save(member);
	}

	@Override
	public Member findById(Integer id) {
		return memberDao.findById(id);
	}

	@Override
	public boolean existsByUserId(String userId) {
		return memberDao.existsByUserId(userId);
	}

	@Override
	public void update(Member member) {
		memberDao.update(member);
	}

	@Override
	public void delete(Integer id) {
		memberDao.delete(id);
	}

	@Override
	public List<Member> findAll() {
		return memberDao.findAll();
	}

}
