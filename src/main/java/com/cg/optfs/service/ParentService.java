package com.cg.optfs.service;

import java.util.List;
import java.util.Optional;

import com.cg.optfs.entity.Parent;
import com.cg.optfs.entity.Tutor;

public interface ParentService {

	public Parent loginParent(String username, String password);

	public Parent addParent(Parent parent);

	public Parent viewParent(Integer parentId);

	public Parent updateParent(Parent parent);

	public List<Tutor> viewAllTutor();

	public Parent getParentById(Integer id);

}