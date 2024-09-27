package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.kh.upload.model.vo.Board;
import com.kh.upload.model.vo.Paging;

@Mapper
public interface BoardMapper {
	
	void add(Board board);
	
	ArrayList<Board> list(Paging paging);
	
	int total();
	
	Board select(int no);
	
	void update(Board vo); 
	
	void delete(int no);
	

}
