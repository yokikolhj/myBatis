package com.shirly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shirly.data.base.Menu;
import com.shirly.data.base.MenuExample;
import com.shirly.data.base.Menutype;
import com.shirly.data.general.MenuTypeInfo;
import com.shirly.data.mapper.MenuMapper;
import com.shirly.data.mapper.MenutypeMapper;
import com.shirly.data.model.DataResponse;
import com.shirly.service.HomePageService;

@Service
public class HomePageServiceImpl implements HomePageService {
	private static Logger LOGGER = LoggerFactory.getLogger(HomePageServiceImpl.class);
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private MenutypeMapper typeMapper;
	
	/*private static HomePageServiceImpl service;

	private HomePageServiceImpl() {
		super();
	}

	public static HomePageServiceImpl getInstance() {
		if (service == null) {
			synchronized (HomePageServiceImpl.class) {
				if (service == null) {
					service = new HomePageServiceImpl();
				}
			}
		}
		return service;
	}*/

	@Override
	public DataResponse getMenus() {
		DataResponse response = new DataResponse();
		try {
			MenuExample example = new MenuExample();
			List<Menu> menus = menuMapper.selectByExample(example);
			if (menus != null && menus.size() > 0) {
				List<MenuTypeInfo> menuTypes = new ArrayList<>();
				for (int i=0; i<menus.size(); i++) {
					MenuTypeInfo info = new MenuTypeInfo();
					info.setMenuId(menus.get(i).getMenuid());
					info.setmName(menus.get(i).getMname());
					info.setMtId(menus.get(i).getMtid());
					info.setOfferPrice(menus.get(i).getOfferprice());
					info.setPrice(menus.get(i).getPrice());
					info.setUrl(menus.get(i).getUrl());
					Menutype type = typeMapper.selectByPrimaryKey(menus.get(i).getMtid());
					info.setTypeName(type.getTypename());
					menuTypes.add(info);
				}
				response.setData(menuTypes);
				response.setCount(menuTypes.size());
			} else {
				response.setData(menus);
			}
		} catch (Exception e) {
			response.setMsg(e.getMessage());
			LOGGER.error(e.getMessage());
		}
		return response;
	}
	
}
