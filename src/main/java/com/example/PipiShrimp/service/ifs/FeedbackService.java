package com.example.PipiShrimp.service.ifs;

import com.example.PipiShrimp.entity.Feedback;
import com.example.PipiShrimp.vo.FeedBackRes;

public interface FeedbackService {

	//�x�s�ϥΪ̶�g���^�X���
	public FeedBackRes sendFeedBack(Feedback feedBack);
	
	//��id�d������浧
	public FeedBackRes getFeedBackInfo(int id);
	
	//�����
	public FeedBackRes getAllFeedBackInfo();
	
	
	public FeedBackRes getUserFeedback(Feedback feedBack);
	
	//模糊搜尋使用者姓名
	public FeedBackRes getUserName(String name);

}