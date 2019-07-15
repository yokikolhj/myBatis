package com.shirly.service;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.shirly.data.model.DataResponse;

public class HomePageService {
	private static Logger LOGGER = LoggerFactory.getLogger(HomePageService.class);
	
	private static HomePageService service;

	private HomePageService() {
		super();
	}

	public static HomePageService getInstance() {
		if (service == null) {
			synchronized (HomePageService.class) {
				if (service == null) {
					service = new HomePageService();
				}
			}
		}
		return service;
	}

	/**
	 * 获取办公设施维修记录
	 * @param req
	 * @param response
	 * @return
	 */
	public DataResponse getAllUser(HttpServletRequest req, DataResponse response) {
		try {
			
		} catch (Exception e) {
			response.setCode("");
			response.setMsg("");
			response.setData(e.getMessage());
			LOGGER.error(e.getMessage());
		}
		return response;
	}
	
}
