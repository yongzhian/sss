package cn.zain.util;

import com.sun.jndi.toolkit.dir.SearchFilter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

/**
 * 功能说明：jpa相关查询工具类
 *
 * @author Zain
 */
public final class JpaTool {

    public static PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType, String... properties) {
        return PageRequest.of(pageNumber, pageSize, new Sort(Sort.Direction.DESC, properties));
    }
}
