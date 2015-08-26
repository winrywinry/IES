package com.sssystem.edu.admin.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCommonController {
  

@RequestMapping("/admin/include/header")
public String header(){
  return "admin/include/header";
}

@RequestMapping("/admin/include/footer")
public String footer(){
  return "admin/include/footer";
}

@RequestMapping("/admin/include/left_menu")
public String left_menu(){
  return "admin/include/left_menu";
}

}
