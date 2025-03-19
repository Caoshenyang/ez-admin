package com.ezadmin.model.mpstruct;

import com.ezadmin.model.dto.UserCreateDTO;
import com.ezadmin.model.vo.UserInfoVO;
import com.ezadmin.modules.system.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * 类名: MsUserMapper
 * 功能描述: 用户实体转化类
 *
 * @author shenyang
 * @since 2025/3/17 13:41
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MsUserMapper {
    MsUserMapper INSTANCE = Mappers.getMapper(MsUserMapper.class);

     UserInfoVO userToUserInfoVO(User user);

    User UserCreateDTO2User(UserCreateDTO userCreateDTO);
}

