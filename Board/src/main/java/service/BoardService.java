package service;

import java.util.Map;

import dto.Board;

public interface BoardService {
	void boardWrite(Board board) throws Exception;
	Map<String, Object> boardListByPage(Integer page) throws Exception; // <key, value>
}
