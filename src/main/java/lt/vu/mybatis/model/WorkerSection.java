package lt.vu.mybatis.model;

public class WorkerSection {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.WORKER_SECTION.WORKER_ID
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    private Integer workerId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.WORKER_SECTION.SECTION_ID
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    private Integer sectionId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.WORKER_SECTION.WORKER_ID
     *
     * @return the value of PUBLIC.WORKER_SECTION.WORKER_ID
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    public Integer getWorkerId() {
        return workerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.WORKER_SECTION.WORKER_ID
     *
     * @param workerId the value for PUBLIC.WORKER_SECTION.WORKER_ID
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.WORKER_SECTION.SECTION_ID
     *
     * @return the value of PUBLIC.WORKER_SECTION.SECTION_ID
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.WORKER_SECTION.SECTION_ID
     *
     * @param sectionId the value for PUBLIC.WORKER_SECTION.SECTION_ID
     *
     * @mbg.generated Sun May 17 19:10:23 EEST 2020
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }
}