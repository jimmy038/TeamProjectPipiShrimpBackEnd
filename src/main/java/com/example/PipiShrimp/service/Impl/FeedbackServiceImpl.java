package com.example.PipiShrimp.service.Impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.PipiShrimp.constants.RtnCode;
import com.example.PipiShrimp.entity.Feedback;
import com.example.PipiShrimp.entity.Mail;
import com.example.PipiShrimp.repository.FeedbackDao;
import com.example.PipiShrimp.service.ifs.FeedbackService;
import com.example.PipiShrimp.vo.FeedBackRes;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	private FeedbackDao feedbackDao;
	
	/* org.slf4j.Logger */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Override //�x�s�Τ�N���^�X���
	public FeedBackRes sendFeedBack(Feedback feedBack) {
		// �ܤ֭n��J name�Bphone�Bemail�Bfeedback
		if(!StringUtils.hasText(feedBack.getName()) || !StringUtils.hasText(feedBack.getPhone())
			|| !StringUtils.hasText(feedBack.getEmail()) || !StringUtils.hasText(feedBack.getFeedback())) {
			return new FeedBackRes(RtnCode.PARAM_ERROR);
		}
		try {
			feedbackDao.save(feedBack);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new FeedBackRes(RtnCode.EMAIL_FORMAT_ERROR);
		}
		return new FeedBackRes(RtnCode.SUCCESSFUL);
	}


	@Override  //��ID ���ϥΪ̶�g���^�X���
	public FeedBackRes getFeedBackInfo(int id) {
		Optional<Feedback> op = feedbackDao.findById(id); 
		if(!op.isPresent()){
			return new FeedBackRes(RtnCode.FEEDBACK_ID_NOT_FOUND);
		}	
		Feedback feedback = op.get();			
		return new FeedBackRes(RtnCode.SUCCESSFUL,List.of(feedback));
	}


	@Override  //������
	public FeedBackRes getAllFeedBackInfo() {
		List<Feedback> feedbackList = feedbackDao.findAll();
		if(feedbackList.isEmpty()) {
			return new FeedBackRes(RtnCode.FEEDBACK_ID_NOT_FOUND);
		}else {
			return new FeedBackRes(RtnCode.SUCCESSFUL,feedbackList);
		}
	}


	@Override
	public FeedBackRes getUserFeedback(Feedback feedBack) {
		List<Feedback> userInfo = feedbackDao.searchFeedbackByUser(feedBack.getName(), feedBack.getPhone(), feedBack.getEmail());
		if(userInfo.isEmpty()) {
			return new FeedBackRes(RtnCode.PARAM_ERROR);		
		}
		return new FeedBackRes(RtnCode.SUCCESSFUL,userInfo);
	}


	@Override
	public FeedBackRes getUserName(String name) {
		List<Feedback> userList = feedbackDao.searchNameLike(name);
		//如果搜尋結果的list為空先回參數錯誤
		if(userList.isEmpty()) {
			return new FeedBackRes(RtnCode.PARAM_ERROR);
		}
		return new FeedBackRes(RtnCode.SUCCESSFUL,userList);
	}

}