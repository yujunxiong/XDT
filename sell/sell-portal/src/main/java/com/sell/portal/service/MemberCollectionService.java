package com.sell.portal.service;


import java.util.List;

import com.sell.portal.dto.MemberCollection;

/**
 * 会员收藏Service
 * Created by macro on 2018/8/2.
 */
public interface MemberCollectionService {
    int addProduct(MemberCollection productCollection);

    int deleteProduct(Long memberId, Long productId);

    List<MemberCollection> listProduct(Long memberId);
}
