//package com.crud.btt.member.entity;
//
//import com.crud.btt.member.model.dto.MemberDto;
//import org.springframework.data.domain.Example;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.repository.query.FluentQuery;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//import java.util.Optional;
//import java.util.function.Function;
//
//@Repository
//
//public class JpaMemberRepository {
//
////    private final EntityManager em;
////
////    public JpaMemberRepository(EntityManager em) {
////        this.em = em;
////    }
////
////    @Override
////    public List<MemberEntity> findAll() {
////        return null;
////    }
////
////    @Override
////    public List<MemberEntity> findAll(Sort sort) {
////        return null;
////    }
////
////    @Override
////    public Page<MemberEntity> findAll(Pageable pageable) {
////        return null;
////    }
////
////    @Override
////    public List<MemberEntity> findAllById(Iterable<Long> longs) {
////        return null;
////    }
////
////    @Override
////    public long count() {
////        return 0;
////    }
////
////    @Override
////    public void deleteById(Long aLong) {
////
////    }
////
////    @Override
////    public void delete(MemberEntity entity) {
////
////    }
////
////    @Override
////    public void deleteAllById(Iterable<? extends Long> longs) {
////
////    }
////
////    @Override
////    public void deleteAll(Iterable<? extends MemberEntity> entities) {
////
////    }
////
////    @Override
////    public void deleteAll() {
////
////    }
////
//////    @Transactional
//////    public <S extends MemberEntity> S save(S entity) {
//////      em.persist(entity);
//////      return entity;
//////    }
////    @Override
////    public <S extends MemberEntity> S save(S entity) {
////
////        return null;
////    }
////
////    @Override
////    public <S extends MemberEntity> List<S> saveAll(Iterable<S> entities) {
////        return null;
////    }
////
////    @Override
////    public Optional<MemberEntity> findById(Long aLong) {
////        return Optional.empty();
////    }
////
////    @Override
////    public boolean existsById(Long aLong) {
////        return false;
////    }
////
////    @Override
////    public void flush() {
////
////    }
////
////    @Override
////    public <S extends MemberEntity> S saveAndFlush(S entity) {
////        return null;
////    }
////
////    @Override
////    public <S extends MemberEntity> List<S> saveAllAndFlush(Iterable<S> entities) {
////        return null;
////    }
////
////    @Override
////    public void deleteAllInBatch(Iterable<MemberEntity> entities) {
////
////    }
////
////    @Override
////    public void deleteAllByIdInBatch(Iterable<Long> longs) {
////
////    }
////
////    @Override
////    public void deleteAllInBatch() {
////
////    }
////
////    @Override
////    public MemberEntity getOne(Long aLong) {
////        return null;
////    }
////
////    @Override
////    public MemberEntity getById(Long aLong) {
////        return null;
////    }
////
////    @Override
////    public MemberEntity getReferenceById(Long aLong) {
////        return null;
////    }
////
////    @Override
////    public <S extends MemberEntity> Optional<S> findOne(Example<S> example) {
////        return Optional.empty();
////    }
////
////    @Override
////    public <S extends MemberEntity> List<S> findAll(Example<S> example) {
////        return null;
////    }
////
////    @Override
////    public <S extends MemberEntity> List<S> findAll(Example<S> example, Sort sort) {
////        return null;
////    }
////
////    @Override
////    public <S extends MemberEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
////        return null;
////    }
////
////    @Override
////    public <S extends MemberEntity> long count(Example<S> example) {
////        return 0;
////    }
////
////    @Override
////    public <S extends MemberEntity> boolean exists(Example<S> example) {
////        return false;
////    }
////
////    @Override
////    public <S extends MemberEntity, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
////        return null;
////    }
//
//
//}
