package com.kang.quartz.spring3.task;

import java.util.Date;
import java.util.concurrent.RejectedExecutionException;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class Task {

	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	String taskId = "";
	
	
	@Scheduled(cron="0/20   *   *     *   *     ?")
	public  void testTaskExecutor(){
		
		System.out.println("=============>["+Thread.currentThread().getId()+"]"+"线程池任务执行时间:"
				+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		
		
		java.util.Random rander = new java.util.Random();  
		
		taskId = rander.nextInt(999999)+"";  
		
		MainRun(taskId);
		
		System.out.println("=============>["+Thread.currentThread().getId()+"]"+"线程池任务完成时间:"
				+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
	
		
	}
	
	
	private void MainRun(String taskId){
		//只有线程都放到池队列中，spring定时任务才会执行完毕;
		for(int i =0;i<100;i++){
			while (true) {
			try {
				/**
				 * 外套循环处理是为了当线程池队列满的时候进行阻塞处理
				 */
					threadPoolTaskExecutor.execute(new RunThread(taskId));
					System.out.println("["+taskId+"]>>>>>>>>当前线程数为:"+ threadPoolTaskExecutor.getPoolSize()
							+",队列大小:"+threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().size());
				   break;
			} catch (RejectedExecutionException e) {
				//log.info(">>>>>>>>批扣核心代收交易业务线程池【"+batchChild.getPayCode()+"】队列已满......");
				System.out.println("队列已满！");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					//log.info("线程中断异常!", e1);
					System.out.println("线程中断异常");
				}
			}
			}
		}
	};
}

 class RunThread implements Runnable{

	 String taskId;
	 
	 public RunThread(String taskId){
		 this.taskId =taskId;
	 }
	 
	@Override
	public void run() {
			
		System.out.println("["+taskId+"]"+"["+Thread.currentThread().getId()+"]"+"睡眠时间:"
				+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		
		try {
			Thread.sleep(10000);

			System.out.println("["+taskId+"]"+"["+Thread.currentThread().getId()+"]"+"睡醒时间:"
				+DateFormatUtils.format(new Date(),"yyyy-MM-dd HH:mm:ss"));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 
	 
	 
	 
 }
