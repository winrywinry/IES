package com.sssystem.edu.admin.service.impl;

import java.util.List;

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
  public List<MemberVO> selectAll(PageVO pageVO) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int selectDuple(MemberVO member) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int selectTotal(PageVO pageVO) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public List<DeptVO> selectDept() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<JobVO> selectJob() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean insert(MemberVO member) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public MemberVO select(int user_no) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean delete(int no) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean update(MemberVO member) {
    // TODO Auto-generated method stub
    return false;
  }

}
