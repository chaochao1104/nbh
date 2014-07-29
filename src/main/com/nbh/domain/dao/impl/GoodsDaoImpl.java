package com.nbh.domain.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nbh.domain.dao.GoodsDao;
import com.nbh.domain.entity.profile.Goods;

@Repository("GoodsDao")
@Transactional
public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao {
	
}
