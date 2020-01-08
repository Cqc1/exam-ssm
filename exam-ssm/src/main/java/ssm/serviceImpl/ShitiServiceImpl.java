package ssm.serviceImpl;

import org.springframework.stereotype.Service;
import ssm.dao.ShitiMapper;
import ssm.model.Shiti;
import ssm.service.ShitiService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("ShitiService")
public class ShitiServiceImpl implements ShitiService {
    @Resource(name ="shitiMapper")
    private ShitiMapper shitiMapper;
    @Override
    public List<Shiti> findAll() {
        return shitiMapper.findAll();
    }

    @Override
    public ArrayList<Shiti> findAll2() {
        return shitiMapper.findAll2();
    }

    @Override
    public List<Shiti> getByShiTiId(int shitiid) {
        return shitiMapper.getByShiTiId(shitiid);
    }
}
