package com.ezadmin.modules.system.service.impl;

import com.ezadmin.modules.system.entity.Dept;
import com.ezadmin.modules.system.mapper.DeptMapper;
import com.ezadmin.modules.system.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门信息表 服务实现类
 * </p>
 *
 * @author shenyang
 * @since 2025-03-13
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
