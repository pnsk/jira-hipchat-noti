package jp.pnsk.pj;

import jp.pnsk.pj.data.dao.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by okuda_junko on 14/06/25.
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public boolean exists(String code) {
        return projectDao.exists(code);
    }

}
