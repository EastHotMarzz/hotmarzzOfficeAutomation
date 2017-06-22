package com.hotmarzz.oa.buzz;

import java.util.List;

import com.hotmarzz.basic.dao.BaseQuery;
import com.hotmarzz.oa.pojo.Emp;

public interface EmpBuzz {
	void add(Emp emp) throws Exception;
	BaseQuery getList(BaseQuery bq) throws Exception;
}
