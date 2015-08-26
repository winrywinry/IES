package com.sssystem.edu.control;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.CategoryService;
import com.sssystem.edu.vo.CategoryVO;
import com.sssystem.edu.vo.support.SessionVO;

@Controller
public class CategoryContoller {
	
	@Autowired
	CategoryService categoryService;
	@Autowired
	ValidateParamChk chk;
	
	@RequestMapping("/learn/category")
	public String category(
			  HttpSession session
			, CategoryVO bean
			, Model model){
		SessionVO sessionBean = (SessionVO) session.getAttribute("user");
		int dept_no = sessionBean.getDept_no();

		int category_no = 0;
		int ref_no = 0;
		int lev_no = 0;

		if (!chk.isEmpty(bean.getNo())){
			if (chk.isNumeric(bean.getNo())){
				category_no = chk.toInteger(bean.getNo());
				ref_no = category_no;
				lev_no = categoryService.selectLev(ref_no);
			}
		}
		bean.setCategory_no(category_no);
		bean.setRef_no(ref_no);
		bean.setLev_no(lev_no);
		bean.setCategory_nm(bean.getNm());
		bean.setDept_no(dept_no);

		if (bean.getAction().equals("add")){
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("dept_no", dept_no);
			map.put("category_nm", bean.getCategory_nm());
			if (!categoryService.selectNm(map)) {
				categoryService.insert(bean);
				model.addAttribute("categorylist", categoryService.selectAll(dept_no));
			} else {
				//msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("category.error.duplicate"));
			}
		} else if(bean.getAction().equals("del")){
			if(categoryService.delete(category_no)){
				model.addAttribute("categorylist", categoryService.selectAll(dept_no));
			} else {
				//msgs.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("category.error.delete"));
			}
		}

		return "learn/category";
	}
	
}
