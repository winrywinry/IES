package com.sssystem.edu.admin.service.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.sssystem.edu.admin.service.AdminMemberService;
import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.admin.vo.PageVO;
import com.sssystem.edu.vo.DeptVO;
import com.sssystem.edu.vo.JobVO;

public class AdminMemberServiceImpl implements AdminMemberService {
  
  @Autowired
  private SqlSession session;

  @Override
  public List<MemberVO> selectAll(PageVO pageVO, int page) {
    List<MemberVO> list = session.selectList("admin.member.selectAll",pageVO,new RowBounds(page*10-10,10));
    return list;
  }

  @Override
  public int selectDuple(MemberVO member) {
    int t = session.selectOne("admin.member.selectDuple",member);
    return t;
  }

  @Override
  public int selectTotal(PageVO pageVO) {
    int cnt = session.selectOne("admin.member.selectTotal",pageVO);
    return cnt;
  }

  @Override
  public List<DeptVO> selectDept() {
    List<DeptVO> list = session.selectList("dept.selectAll");
    return list;
  }

  @Override
  public List<JobVO> selectJob() {
    List<JobVO> list = session.selectList("job.selectAll");
    return list;
  }

  @Override
  public MemberVO insert(MemberVO member) {
    session.insert("admin.member.insert",member);
    return member;
  }

  @Override
  public MemberVO select(int user_no) {
    MemberVO member = session.selectOne("admin.member.select",user_no);
    return member;
  }

  @Override
  public boolean delete(int no) {
    int t = session.delete("admin.member.delete",no);
    if(t > 0) return true;
    return false;
  }

  @Override
  public boolean update(MemberVO member) {
    int t = session.update("admin.member.update",member);
    if(t > 0) return true;
    return false;
  }

}
