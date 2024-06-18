package com.example.PipiShrimp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.PipiShrimp.entity.Feedback;
import com.example.PipiShrimp.service.ifs.FeedbackService;
import com.example.PipiShrimp.vo.FeedBackRes;

@CrossOrigin
@RestController
public class FeedBackController {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@PostMapping(value = "/feedBack/sendFeedBack")
	public FeedBackRes sendFeedBack(@RequestBody Feedback feedBack){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("qtp1520@gmail.com"); // �}�o�� mail �H�c
		message.setSubject("�s���N���^�X");
		message.setText("�m�W: " + feedBack.getName() + "\n�p���q��: " + feedBack.getPhone() + "\nE-mail: "
				+ feedBack.getEmail() + "\n�N���P�^�X: " + feedBack.getFeedback());

		return feedbackService.sendFeedBack(feedBack);
	}
	
	@GetMapping(value = "/feedBack/getFeedBackInfo")
	public FeedBackRes getFeedBackInfo(@RequestParam int id) {
		return feedbackService.getFeedBackInfo(id);	
	}
	
	@GetMapping(value = "/feedBack/getAllFeedBackInfo")
	public FeedBackRes getAllFeedBackInfo() {
		return feedbackService.getAllFeedBackInfo();	
	}

	
	@GetMapping(value = "/feedBack/getUserFeedback")
	public FeedBackRes getUserFeedback(@RequestParam Feedback feedBack) {
		return feedbackService.getUserFeedback(feedBack);
	}
	
	//模糊搜尋使用者姓名
	@GetMapping(value = "/feedBack/getUserName")
	public FeedBackRes getUserName(
			@RequestParam(value = "name")  String name) {
		return feedbackService.getUserName(name);
	}
	
}
