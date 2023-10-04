package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.BoardDao;
import dao.BoardDaoImpl;
import dto.Board;
import util.PageInfo;

public class BoardServiceImpl implements BoardService {
	private BoardDao boardDao;
	
	public BoardServiceImpl() {
		boardDao = new BoardDaoImpl();
	}
	
	@Override
	public void boardWrite(Board board) throws Exception {
		boardDao.insertBoard(board);
	}
	
	@Override
	public Map<String, Object> boardListByPage(Integer page) throws Exception {
		PageInfo pageInfo = new PageInfo();
		// 전체 게시글 개수 조회
		int boardCount = boardDao.selectBoardCount();
		int maxPage = (int) Math.ceil((double)boardCount / 10); // ceil은 무조건 올림 (소수점이 남아있으면 무조건 높은 정수로)
		// ex: 85개의 게시글이 있으면, maxPage는 9
		
		int startPage = (page - 1) / 10 * 10 + 1;// 현재 페이지를 기반한 시작 페이지 (n1)
		// -1을 해주는 이유는 1의 자리 숫자가 0인 페이지가 경계에 걸치는 것을 방지하기 위해 (ex: 11~20까지이므로, 10은 포함 안되도록)
		
		int endPage = startPage + 10 - 1;
		if(endPage > maxPage) endPage = maxPage;
		
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		// 현재 페이지 시작 row
		// ex: 3페이지면, row는 21번
		int row = (page - 1) * 10 + 1;
		
		// 특정 페이지의 
		List<Board> boardList = boardDao.selectBoardList(row - 1);

		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", pageInfo);
		map.put("boardList", boardList);
		return map;
	}
}
