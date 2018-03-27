package com.revature.util;

import org.springframework.beans.BeanUtils;

import com.revature.beans.BatchTrainer;
import com.revature.beans.TrainerUser;
import com.revature.beans.User;

public class ClassUtil {
	
	public static TrainerUser merge(User u, BatchTrainer bt) {
		TrainerUser tu = new TrainerUser();
		BeanUtils.copyProperties(u, tu);
		tu.setTitle(bt.getTitle());
		tu.setTrainerId(bt.getTrainerId());
		return tu;
		
	}
	
}
