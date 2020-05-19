package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Worker;
import org.mybatis.cdi.Mapper;

@Mapper
public interface WorkerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    int insert(Worker record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    Worker selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    List<Worker> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.WORKER
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    int updateByPrimaryKey(Worker record);
}