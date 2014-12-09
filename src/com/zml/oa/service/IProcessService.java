package com.zml.oa.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.Execution;
import org.springframework.ui.Model;

import com.zml.oa.entity.BaseVO;
import com.zml.oa.entity.CommentVO;
import com.zml.oa.entity.SalaryAdjust;
import com.zml.oa.entity.User;

public interface IProcessService {
	
	/**
	 * 启动薪资调整
	 * @param user
	 * @param salary
	 * @param variables
	 * @return
	 * @throws Exception
	 */
	public String startSalaryAdjust(SalaryAdjust salary) throws Exception;
	/**
	 * 查询代办任务
	 * @param user
	 * @param model
	 * @return
	 */
	public List<BaseVO> findTodoTask(User user, Model model) throws Exception;
	
	/**
     * 查询待受理任务
     * @param user
     * @param model
     * @return
     */
    public List<BaseVO> findDoTask(User user, Model model) throws Exception;
	 
    /**
     * 签收任务
     * @param user
     * @param taskId
     */
    public void doClaim(User user, String taskId) throws Exception;
    
    /**
     * 获取评论
     * @param processInstanceId
     * @return
     * @throws Exception
     */
    public List<CommentVO> getComments(String processInstanceId) throws Exception;
    
    /**
     * 显示流程图,带流程跟踪
     * @param processInstanceId
     * @return
     */
    public InputStream getDiagram(String processInstanceId) throws Exception;
    
    /**
     * 显示图片，不带流程跟踪(没有乱码问题)
     * @param resourceType
     * @param processInstanceId
     * @return
     */
    public InputStream getDiagram_noTrace(String resourceType, String processInstanceId) throws Exception;

    /**
     * 读取已结束中的流程(待完善)
     *
     * @return
     */
    public String findFinishedProcessInstaces(Model model) throws Exception;
    
    /**
     * 查看正在运行的请假流程
     * @param user
     * @return
     * @throws Exception
     */
    public List<BaseVO> listRuningVacation(User user) throws Exception;
    
    /**
     * 查看正在运行的报销流程
     * @param user
     * @return
     * @throws Exception
     */
    public List<BaseVO> listRuningExpense(User user) throws Exception;
    
    /**
     * 查看正在运行的薪资跳转流程
     * @param user
     * @return
     * @throws Exception
     */
    public List<BaseVO> listRuningSalaryAdjust(User user) throws Exception;
    
    /**
     * 检查付款金额
     * @param exe
     */
    public void bankTransfer(Execution exe) throws Exception;

}