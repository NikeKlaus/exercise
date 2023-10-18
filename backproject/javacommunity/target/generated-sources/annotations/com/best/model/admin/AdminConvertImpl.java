package com.best.model.admin;

import com.best.common.PageEntity;
import com.best.dto.ConditionDTO;
import com.best.entity.Admin;
import com.best.vo.AdminVO;
import com.best.vo.ConditionVO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-08T22:32:43+0800",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class AdminConvertImpl implements AdminConvert {

    @Override
    public PageEntity<AdminVO.ListAdminVO> toAdminListVOList(PageEntity<Admin> adminList) {
        if ( adminList == null ) {
            return null;
        }

        PageEntity<AdminVO.ListAdminVO> pageEntity = new PageEntity<AdminVO.ListAdminVO>();

        pageEntity.setPageNo( adminList.getPageNo() );
        pageEntity.setPageSize( adminList.getPageSize() );
        pageEntity.setRecords( toAdminListVOList( adminList.getRecords() ) );
        pageEntity.setTotal( adminList.getTotal() );

        return pageEntity;
    }

    @Override
    public List<AdminVO.ListAdminVO> toAdminListVOList(List<Admin> adminList) {
        if ( adminList == null ) {
            return null;
        }

        List<AdminVO.ListAdminVO> list = new ArrayList<AdminVO.ListAdminVO>( adminList.size() );
        for ( Admin admin : adminList ) {
            list.add( adminToListAdminVO( admin ) );
        }

        return list;
    }

    @Override
    public Admin toAdmin(AdminVO.UpdateAdminInfoVO updateAdminInfoVO) {
        if ( updateAdminInfoVO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setAdminId( updateAdminInfoVO.getAdminId() );
        admin.setName( updateAdminInfoVO.getName() );
        admin.setPassword( updateAdminInfoVO.getPassword() );

        return admin;
    }

    @Override
    public Admin toAdmin(AdminVO.SaveAdminVO saveAdminVO) {
        if ( saveAdminVO == null ) {
            return null;
        }

        Admin admin = new Admin();

        admin.setName( saveAdminVO.getName() );
        admin.setPassword( saveAdminVO.getPassword() );

        return admin;
    }

    @Override
    public ConditionDTO toConditionDTO(ConditionVO conditionVO) {
        if ( conditionVO == null ) {
            return null;
        }

        ConditionDTO conditionDTO = new ConditionDTO();

        conditionDTO.setId( conditionVO.getId() );
        conditionDTO.setName( conditionVO.getName() );
        conditionDTO.setStartTime( conditionVO.getStartTime() );
        conditionDTO.setEndTime( conditionVO.getEndTime() );

        return conditionDTO;
    }

    protected AdminVO.ListAdminVO adminToListAdminVO(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminVO.ListAdminVO listAdminVO = new AdminVO.ListAdminVO();

        listAdminVO.setAdminId( admin.getAdminId() );
        listAdminVO.setName( admin.getName() );
        listAdminVO.setPassword( admin.getPassword() );
        listAdminVO.setCreateTime( admin.getCreateTime() );
        listAdminVO.setUpdateTime( admin.getUpdateTime() );
        listAdminVO.setDeleted( admin.getDeleted() );

        return listAdminVO;
    }
}
