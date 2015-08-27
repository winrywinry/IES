package com.sssystem.edu.control;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;

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
	
	@RequestMapping("board/view")
	public String boardView (HttpSession session,Model model, 
			@RequestParam (value="no", required=false)int no,
			@RequestParam(value="board_gb", required=false)int gb) {

			
		BoardVO boardVO = boardServie.boardDetailSelect(no, gb);
		boardServie.upHits(no);	
		System.out.println("board_title="+boardVO.getTitle());
		model.addAttribute("board", boardVO);
		return "board/view";
	}
	
	@RequestMapping("board/write")
	public String boardWrite() {
		
		return "board/write";
	}
	
	@RequestMapping("board/writeForm")
	public String boardWrite (HttpSession session,Model model, 
			@RequestParam (value="board_gb", required=false)String board_gb,
			@RequestParam (value="title", required=false)String title,
			@RequestParam (value="contents", required=false)String contents,
			@RequestParam (value="board_no", required=false)int board_no) {
		
		BoardVO boardVO = new BoardVO();
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		System.out.println("board_no"+board_no);
		
		boardVO.setBoard_no(board_no);
		boardVO.setUser_no(sessionVO.getUser_no());
		boardVO.setBoard_gb(board_gb);
		boardVO.setTitle(title);
		boardVO.setContents(contents);
		
		
/*		if(!(board_no.isEmpty())) {
			boardVO.setBoard_no(board_no);
		}*/
		
		
		
		
		
		return "board/writeForm";
	}
	
	@RequestMapping("board/update")
	public String boardUpdate(HttpSession session, Model model,
			@RequestParam (value="no", required=false)int no,
			@RequestParam (value="board_gb", required=false)int board_gb) {
		
			
		
		return "board/update";
	}
	
	@RequestMapping("board/delete")
	public String boardDelete(HttpSession session, Model model,
			@RequestParam (value="no", required=false)int no,
			@RequestParam (value="board_gb", required=false)int board_gb) {
		
		return "board/delete";
	}
	
	@RequestMapping("board/reply")
	public String boardReply(HttpSession session, Model model,
			@RequestParam (value="action", required=false)String action) {
		
		
		return "board/reply";
	}
	
}	
