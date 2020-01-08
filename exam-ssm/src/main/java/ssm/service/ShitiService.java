package ssm.service;

import ssm.model.Shiti;

import java.util.ArrayList;
import java.util.List;

public interface ShitiService {
    public List<Shiti> findAll();//查询所有试题信息
    public ArrayList<Shiti> findAll2();
    public List<Shiti> getByShiTiId(int shitiid);
}
