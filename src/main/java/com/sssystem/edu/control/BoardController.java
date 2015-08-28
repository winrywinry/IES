package com.sssystem.edu.control;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sssystem.edu.common.ConvertStr;
import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.ReplyVO;
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
			@RequestParam (value="board_no", required=false)String board_no) {
		BoardVO boardVO = new BoardVO();
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		
		boardVO.setUser_no(sessionVO.getUser_no());
		boardVO.setBoard_gb(board_gb);
		boardVO.setTitle(title);
		boardVO.setContents(contents);
		if(!(board_no.isEmpty())){
			boardVO.setBoard_no(Integer.parseInt(board_no));
		}

		if(board_gb.equals("10")){
			if(!(board_no.isEmpty())){
				if(boardServie.boardUpdate(boardVO)){
					return "redirect:view?board_gb="+board_gb+"&no="+board_no;
				}
			}else{
				if(boardServie.boardInsert(boardVO)){
					return "redirect:list?board_gb="+board_gb;
				}
			}
		}else if(board_gb.equals("20")){
			if(!(board_no.isEmpty())){
				if(boardServie.boardUpdate(boardVO)){
					return "redirect:view?board_gb="+board_gb+"&no="+board_no;
				}
			}else{
				if(boardServie.boardInsert(boardVO)){
					return "redirect:list?board_gb="+board_gb;
				}
			}
		}else if(board_gb.equals("30")){
			if(!(board_no.isEmpty())){
				if(boardServie.boardUpdate(boardVO)){
					return "redirect:view?board_gb="+board_gb+"&no="+board_no;
				}
			}else{
				if(boardServie.boardInsert(boardVO)){
					return "redirect:list?board_gb="+board_gb;
				}
			}
		}
		
		return "board/list";
	}
	
	@RequestMapping("board/update")
	public String boardUpdate(HttpSession session, Model model,
			@RequestParam (value="no", required=false)int no,
			@RequestParam (value="board_gb", required=false)int board_gb) {
		
			int board_no = no;
			BoardVO boardVO = boardServie.boardDetailSelect(board_no, board_gb);
			model.addAttribute("board",boardVO);
		
		return "board/write";
	}
	
	@RequestMapping("board/delete")
	public String boardDelete(HttpSession session, Model model,
			@RequestParam (value="no", required=false)int no,
			@RequestParam (value="board_gb", required=false)int board_gb) {
		System.out.println("no="+no);
		System.out.println("board_gb="+board_gb);

		boardServie.boardDelete(no);
		
		return "redirect:list?board_gb="+board_gb;
	}
	
	@RequestMapping("board/replyList")
	public String boardReplyList(HttpSession session, Model model,
			@RequestParam(value="no",required=false)int no){
			List<ReplyVO> list = boardServie.replyList(no);
			model.addAttribute("list",list);
			return "board/replyList";
		}
	
	@RequestMapping("board/replyDelete")
	public String boardReplyDelete(Model model,
			@RequestParam(value="comment_no")int comment_no){
		if(boardServie.replyDelete(comment_no)){
			model.addAttribute("comment_no",comment_no);
		}
		
		return "board/replyDelete";
	}
	
	@RequestMapping("board/replyUpdate")
	public String boardReplyUpdate(Model model,
			@RequestParam(value="comment_no")int comment_no,
			@RequestParam(value="content")String content,
			@RequestParam(value="name")String name,
			@RequestParam(value="input_dt")Date input_dt){
		ReplyVO replyVO = new ReplyVO();
		System.out.println("기본 = "+content);
		System.out.println("변형 = "+ConvertStr.toJS(content));
		replyVO.setContents(ConvertStr.toJS(content));
		replyVO.setComment_no(comment_no);
		if(boardServie.replyUpdate(replyVO)){
			replyVO.setUser_nm(name);
			replyVO.setInput_dt(input_dt);
			model.addAttribute("reply",replyVO);
		}
		
		return "board/replyUpdate";
	}

}	
