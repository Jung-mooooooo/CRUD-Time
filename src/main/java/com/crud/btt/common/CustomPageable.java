package com.crud.btt.common;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CustomPageable implements Pageable {
    private Pageable pageable;
    public CustomPageable(Pageable pageable){
        this.pageable = pageable;
    }
    @Override
    public int getPageNumber() {
        return pageable.getPageNumber() == 0 ? 1 : pageable.getPageNumber();
    }

    @Override
    public int getPageSize() {
        return pageable.getPageSize();
    }

    @Override
    public long getOffset() {
        return pageable.getPageNumber() == 0 ? 0 : (pageable.getPageNumber()-1) * pageable.getPageSize();
    }

    @Override
    public Sort getSort() {
        return pageable.getSort();
    }

    @Override
    public Pageable next() {
        return pageable.next();
    }

    @Override
    public Pageable previousOrFirst() {
        return pageable.previousOrFirst();
    }

    @Override
    public Pageable first() {
        return pageable.first();
    }

    @Override
    public Pageable withPage(int pageNumber) {
        return pageable.withPage(pageNumber);
    }

    @Override
    public boolean hasPrevious() {
        return pageable.hasPrevious();
    }
}