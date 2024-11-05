package umc.spring.repository.StoreRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QStore;
import umc.spring.domain.Store;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float score){
        BooleanBuilder predicte = new BooleanBuilder();

        if(name != null){
            predicte.and(store.name.eq(name));
        }
        if(score != null){
            predicte.and(store.score.goe(4.0f));
        }
        return jpaQueryFactory
                .selectFrom(store)
                .where(predicte)
                .fetch();
    }
}
