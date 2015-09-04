package com.sssystem.edu.control;

import java.awt.color.CMMException;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sssystem.edu.common.ConvertStr;
import com.sssystem.edu.common.ValidateParamChk;
import com.sssystem.edu.service.AttachFileService;
import com.sssystem.edu.service.BoardService;
import com.sssystem.edu.vo.AttachFileVO;
import com.sssystem.edu.vo.BoardVO;
import com.sssystem.edu.vo.ReplyVO;
import com.sssystem.edu.vo.search.SearchBoardVO;
import com.sssystem.edu.vo.support.SessionVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardServie;
	
	@Autowired
	AttachFileService attachFileService;
	
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
		boardVO.setUser_nm(boardServie.nmSelect(boardVO.getUser_no()));
		boardServie.upHits(no);	
		model.addAttribute("board", boardVO);
		List<AttachFileVO> list = attachFileService.selectFile(no);
		model.addAttribute("list",list);
		return "board/view";
	}
	
	@RequestMapping("board/write")
	public String boardWrite() {
		
		return "board/write";
	}
	
	@RequestMapping("board/writeForm")
	public String boardWrite (HttpSession session,Model model,
			MultipartHttpServletRequest request,
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
		
		if(!(board_no.isEmpty())){
			if(boardServie.boardUpdate(boardVO)){
				Map<String, MultipartFile> files = request.getFileMap();
				CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("uploadFile");//경로설정
				if(!(cmf.getOriginalFilename().equals(""))){
				String path = "E:/waagh/workspace/IES/src/main/webapp/images/"+cmf.getOriginalFilename();
				File file = new File(path);
				try {
					cmf.transferTo(file);
					AttachFileVO attahFileVO = new AttachFileVO();
					attahFileVO.setRef_no(boardServie.maxNoSelect());
					attahFileVO.setTable_nm("T_EDU_BOARD");
					attahFileVO.setAttach_file(cmf.getOriginalFilename());
					attachFileService.insert(attahFileVO);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				return "redirect:view?board_gb="+board_gb+"&no="+board_no;
			}
		}else{
			if(boardServie.boardInsert(boardVO)>0){
				
				Map<String, MultipartFile> files = request.getFileMap();
				CommonsMultipartFile cmf = (CommonsMultipartFile) files.get("uploadFile");//경로설정
				if(!(cmf.getOriginalFilename().equals(""))){

				String path = "E:/waagh/workspace/IES/src/main/webapp/images/"+cmf.getOriginalFilename();
				File file = new File(path);
				try {
					cmf.transferTo(file);
					AttachFileVO attahFileVO = new AttachFileVO();
					attahFileVO.setRef_no(boardServie.maxNoSelect());//임시값80임, insert후 진행하므로 board_no의 max값을 체크하면 됨.
					attahFileVO.setTable_nm("T_EDU_BOARD");
					attahFileVO.setAttach_file(cmf.getOriginalFilename());
					attachFileService.insert(attahFileVO);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				return "redirect:list?board_gb="+board_gb;
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
	public String boardReplyUpdate(Model model,HttpServletRequest requeset,
			@RequestParam(value="comment_no")int comment_no,
			@RequestParam(value="content")String content,
			@RequestParam(value="name")String name,
			@RequestParam(value="input_dt")Date input_dt){
		try {
			requeset.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReplyVO replyVO = new ReplyVO();
		replyVO.setContents(ConvertStr.toJS(content));
		replyVO.setComment_no(comment_no);
		if(boardServie.replyUpdate(replyVO)){
			replyVO.setUser_nm(name);
			replyVO.setInput_dt(input_dt);
			model.addAttribute("reply",replyVO);
		}
		
		return "board/replyUpdate";
	}
	
	@RequestMapping("board/replyInsert")
	public String boardReplyInsert(HttpSession session,Model model,HttpServletRequest request,
			@RequestParam(value="content")String content,
			@RequestParam(value="board_no")String board_no){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionVO sessionVO = (SessionVO) session.getAttribute("user");
		ReplyVO replyVO = new ReplyVO();
		replyVO.setUser_no(sessionVO.getUser_no());
		replyVO.setContents(ConvertStr.toJS(content));//8859_1체크해볼것
		replyVO.setBoard_no(Integer.parseInt(board_no));
		if(boardServie.replyInsert(replyVO)){
			replyVO.setComment_no(boardServie.selectMaxNo());
			ReplyVO rep = boardServie.replySelect(boardServie.selectMaxNo());
			model.addAttribute("reply",rep);
		}
		
		return "board/replyAdd";
	}
	
}	
