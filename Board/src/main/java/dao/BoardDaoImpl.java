package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Board;
import util.MybatisSqlSessionFactory;

public class BoardDaoImpl implements BoardDao {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	@Override
	public void insertBoard(Board board) throws Exception {
		sqlSession.insert("mapper.board.insertBoard", board);
		sqlSession.commit();
	}
	
	@Override
	public List<Board> selectBoardList(Integer row) throws Exception {
		return sqlSession.selectList("mapper.board.selectBoardList", row);
	}
	
	// 전체 게시글 수 조회
	@Override
	public Integer selectBoardCount() throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardCount");
	}
	
	// 특정 num에 해당하는 게시글의 모든 정보 조회
	@Override
	public Board selectBoard(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoard", num);
	}
	
	@Override
	public void updateBoard(Board board) throws Exception {
		sqlSession.update("mapper.board.updateBoard", board);
		sqlSession.commit();
	}
	
	@Override
	public void deleteBoard(Integer num) throws Exception {
		sqlSession.delete("mapper.board.deleteBoard", num);
		sqlSession.commit();
	}

	@Override
	public Integer searchBoardCount(Map<String, Object> param) throws Exception {
		return sqlSession.selectOne("mapper.board.searchBoardCount", param);
	}
	
	@Override
	public List<Board> searchBoardList(Map<String, Object> param) throws Exception {
		return sqlSession.selectList("mapper.board.searchBoardList", param);
	}

	@Override
	public void updateBoardViewCount(Integer num) throws Exception {
		sqlSession.update("mapper.board.updateBoardViewCount", num);
		sqlSession.commit();
	}

	@Override
	public Integer selectBoardLikeCount(Integer num) throws Exception {
		return sqlSession.selectOne("mapper.board.selectBoardLikeCount", num);
	}

	@Override
	public void plusBoardLikeCount(Integer num) throws Exception {
		sqlSession.update("mapper.board.plusBoardLikeCount", num);
		sqlSession.commit();
	}
	
	@Override
	public void minusBoardLikeCount(Integer num) throws Exception {
		sqlSession.update("mapper.board.minusBoardLikeCount", num);
		sqlSession.commit();
		
	}
	
	@Override
	public Integer selectBoardLike(Map<String, Object> param) throws Exception {
		return sqlSession.selectOne("mapper.boardlike.selectBoardLike", param);
	}

	@Override
	public void insertBoardLike(Map<String, Object> param) throws Exception {
		sqlSession.insert("mapper.boardlike.insertBoardLike", param);
		sqlSession.commit();
	}
	
	@Override
	public void deleteBoardLike(Map<String, Object> param) throws Exception {
		sqlSession.delete("mapper.boardlike.deleteBoardLike", param);
		sqlSession.commit();
	}
}
