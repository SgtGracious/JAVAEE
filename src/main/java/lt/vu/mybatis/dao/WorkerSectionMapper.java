package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.WorkerSection;
import org.mybatis.cdi.Mapper;

@Mapper
public interface WorkerSectionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER_SECTION
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    int insert(WorkerSection record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER_SECTION
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    List<WorkerSection> selectAll();
}