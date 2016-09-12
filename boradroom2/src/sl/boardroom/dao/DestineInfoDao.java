package sl.boardroom.dao;

import java.util.List;

import sl.boardroom.entity.DestineInfoEntity;

public interface DestineInfoDao {
	public List<DestineInfoEntity> getAllInfoOrderByTime();
	
	public int addInfo(DestineInfoEntity die);

}
