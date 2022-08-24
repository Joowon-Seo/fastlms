package com.zerobase.fastlms.course.dto.admin.mapper;


import com.zerobase.fastlms.course.dto.admin.dto.CategoryDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    List<CategoryDto> select(CategoryDto parameter);

}
