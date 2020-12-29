package com.cg.optfs.service;

import com.cg.optfs.entity.Parent;

public interface ParentService {

	public Parent loginParent(String username, String password);

	public Parent addParent(Parent parent);

	public Parent viewParent(Integer parentId);

	public Parent updateParent(Parent parent);

}