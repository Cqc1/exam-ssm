package ssm.dao;

import ssm.model.Shiti;

import java.util.ArrayList;
import java.util.List;

public interface ShitiMapper {
    public List<Shiti> findAll();

    public ArrayList<Shiti> findAll2();

    public List<Shiti> getByShiTiId(int shitiid);


}
