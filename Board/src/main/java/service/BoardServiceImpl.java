package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

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
		
		// 만일, 마지막 페이지에서 하나만 남은 게시글을 삭제했는데도 마지막 페이지일 경우, 삭제된 마지막 페이지가 아닌 전체 페이지(maxPage)로 해줌
		// 즉, 요청은 n페이지로 가도, n-1페이지로 가는 느낌
		if(page > maxPage) page = maxPage;
		
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
	
	@Override
	public Board boardDetail(Integer num) throws Exception {
		boardDao.updateBoardViewCount(num);
		return boardDao.selectBoard(num);
	}
	
	@Override
	public void boardModify(Board board) throws Exception {
		boardDao.updateBoard(board);
	}
	
	@Override
	public void boardRemove(Integer num) throws Exception {
		boardDao.deleteBoard(num);
	}
	
	@Override
	public Map<String, Object> boardSearch(String type, String keyword, Integer page) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("type", type);
		param.put("keyword", keyword);
		
		PageInfo pageInfo = new PageInfo();
		int boardCount = boardDao.searchBoardCount(param);
		int maxPage = (int) Math.ceil((double)boardCount / 10);
		int startPage = (page - 1) / 10 * 10 + 1;
		int endPage = startPage + 10 - 1;
		if(endPage > maxPage) endPage = maxPage;
		if(page > maxPage) page = maxPage;
		
		pageInfo.setAllPage(maxPage);
		pageInfo.setCurPage(page);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		
		// 검색 결과가 없을 떄??
		Map<String, Object> map = new HashMap<>();
		map.put("pageInfo", pageInfo);
		
		if(page == 0) {
			return map;
		}
		
		int row = (page - 1) * 10 + 1;
		param.put("row", row - 1);
		List<Board> boardList = boardDao.searchBoardList(param);


		map.put("boardList", boardList);
		map.put("type", type);
		map.put("keyword", keyword);
		
		return map;
	}
	
	@Override
	public String boardLike(String id, Integer num) throws Exception {
		// String 또는 Integer 모두를 포함할 수 있는 Object를 사용
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("num", num);
		
		// 1. BoardLike 테이블에 데이터 있는지 확인 (member_id, board_num)
		// likenum: id값
		Integer likenum = boardDao.selectBoardLike(param);
		
		Map<String, Object> res = new HashMap<>();
		
		if(likenum==null) { // 2-1. 없으면 BoardLike에 삽입
			boardDao.insertBoardLike(param);
			boardDao.plusBoardLikeCount(num); // 좋아요 수 증가
			res.put("select", true);
		} else { // 2-2. 있으면 BoardLike에서 삭제
			boardDao.deleteBoardLike(param);
			boardDao.minusBoardLikeCount(num); // 좋아요 수 감소
			res.put("select", false);
		}
		
		// 4. 좋아요 수 return
		Integer likecount = boardDao.selectBoardLikeCount(num);
		res.put("likecount", likecount);
		
		JSONObject jsonObj = new JSONObject(res);
		
		// key, value 쌍을 문자열로 변환하여 반환
		return jsonObj.toJSONString();
	}
	
	@Override
	public Boolean isBoardLike(String id, Integer num) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("num", num);
		Integer likenum = boardDao.selectBoardLike(param);
		
		// 좋아요가 눌러진 상태인지 아닌지
		if(likenum==null) return false;
		
		return true;
	}
}
