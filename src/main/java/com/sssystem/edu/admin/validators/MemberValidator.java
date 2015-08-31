package com.sssystem.edu.admin.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sssystem.edu.admin.vo.MemberVO;
import com.sssystem.edu.common.ValidateParamChk;

public class MemberValidator implements Validator {
  ValidateParamChk chk;
  public MemberValidator() {
    chk = new ValidateParamChk();
  }
  @Override
  public boolean supports(Class<?> arg0) {
    return false;
  }

  @Override
  public void validate(Object obj, Errors err) {
    MemberVO memberVO = (MemberVO) obj;
    if (chk.isEmpty(memberVO.getNo())) {
    } else {
      if (chk.isNumeric(memberVO.getNo())){
        memberVO.setUser_no(chk.toInteger(memberVO.getNo()));
        if (memberVO.getUser_no() == 0) {
          memberVO.setUser_no(0);
          memberVO.setNo("");
        }
      } else {
        memberVO.setNo("");
      }
    }
    if (chk.isEmpty(memberVO.getNo())){
      if (chk.isEmpty(memberVO.getUser_nm())) {
        err.rejectValue("user_nm", "membererror.user_nm");
      }
      if (chk.isEmpty(memberVO.getBirth())) {
        err.rejectValue("birth", "membererror.birth");
      } else if (chk.isDate(memberVO.getBirth())){
        memberVO.setBirth_dt(chk.toDate(memberVO.getBirth()));
      } else {
        err.rejectValue("birth_dt", "membererror.birth_dt");
      }
      if (chk.isEmpty(memberVO.getGender_yn())) {
        err.rejectValue("gender_yn", "membererror.gender_yn");
      }
      if (chk.isEmpty(memberVO.getHire())) {
        err.rejectValue("hire", "membererror.hire");
      } else if (chk.isDate(memberVO.getHire())){
        memberVO.setHiredate(chk.toDate(memberVO.getHire()));
      } else {
        err.rejectValue("hiredate", "membererror.hiredate");
      }
    }
    if (chk.isEmpty(memberVO.getDept())){
      err.rejectValue("dept", "membererror.dept");
    } else if (chk.isNumeric(memberVO.getDept())){
      memberVO.setDept_no(chk.toInteger(memberVO.getDept()));
    } else {
      err.rejectValue("dept_no", "membererror.dept_no");
    }
    if (chk.isEmpty(memberVO.getJob())){
      err.rejectValue("job", "membererror.job");
    } else if (chk.isNumeric(memberVO.getJob())){
      memberVO.setJob_no(chk.toInteger(memberVO.getJob()));
    } else {
      err.rejectValue("job_no", "membererror.job_no");
    }
    if (chk.isEmpty(memberVO.getLine_no())) {
      err.rejectValue("line_no", "membererror.line_no");
    }
    if (chk.isEmpty(memberVO.getPhone_no())) {
      err.rejectValue("phone_no", "membererror.phone_no");
    }
    if (chk.isEmpty(memberVO.getSecond_no())) {
      err.rejectValue("second_no", "membererror.second_no");
    }
    if (chk.isEmpty(memberVO.getPost())) {
      err.rejectValue("post", "membererror.post");
    }
    if (chk.isEmpty(memberVO.getAddress())) {
      err.rejectValue("address", "membererror.address");
    }
    if (chk.isEmpty(memberVO.getEmail())) {
      err.rejectValue("email", "membererror.email");
    }
    if (chk.isEmpty(memberVO.getAdmin_yn())) {
      memberVO.setAdmin_yn("0");
    }
    if (chk.isEmpty(memberVO.getManage_yn())) {
      memberVO.setManage_yn("0");
    }
  }
  
}
