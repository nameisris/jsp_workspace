package service;

import java.util.Map;

import dto.Board;

public interface BoardService {
	void boardWrite(Board board) throws Exception;
	Map<String, Object> boardListByPage(Integer page) throws Exception; // <key, value>
	Board boardDetail(Integer num) throws Exception;
	void boardModify(Board board) throws Exception;
	void boardRemove(Integer num) throws Exception;
	Map<String, Object> boardSearch(String type, String keyword, Integer page) throws Exception;
	
	String boardLike(String id, Integer num) throws Exception;
	
	Boolean isBoardLike(String id, Integer num) throws Exception;
}
