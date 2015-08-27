package com.sssystem.edu.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.search.SearchVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardServie;
	
	@RequestMapping("board/list")
	public String boardList(@RequestParam(value="pSearchWord", required=false)String searchWord,
			@RequestParam(value="board_gb",required=false)int board_gb, 
			@RequestParam(value="page",required=false)String page, Model model) {
		
		SearchBoardVO searchVO = new SearchBoardVO();
		searchVO.setSearchWord(searchWord);
		String pn = page;
		
		int page_no = 1;
	    ValidateParamChk chk = new ValidateParamChk();
	    if (!chk.isEmpty(pn)) if (chk.isNumeric(pn)) page_no = chk.toInteger(pn);
	    if (page_no > 0) searchVO.setPage_no(page_no);

		searchVO.setBoard_gb(board_gb);
		if (searchWord != null && !searchWord.equals("")){
			searchVO.setSearchWord(searchWord);
		}

	    int total = boardServie.selectCnt(searchVO);
	    searchVO.setTotal(total);

		List<BoardVO> list = boardServie.boardListSelectAll(searchVO,page_no);
		model.addAttribute("list", list);
		model.addAttribute("searchVO",searchVO);
		return "board/list";
	}
}
