package org.propproj.web.model;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("searchStrategyFactory")
public class SearchStrategyFactory {

    @Resource(name = "searchByNameStrategy")
    private SearchStrategy searchByNameStrategy;
    @Resource(name = "searchByTypeStrategy")
    private SearchStrategy searchByTypeStrategy;
    @Resource(name = "searchByDescriptionStrategy")
    private SearchStrategy searchByDescriptionStrategy;
    @Resource(name = "searchByIDStrategy")
    private SearchStrategy searchByIDStrategy;

    public SearchStrategy getSearchStrategy(SearchStrategyType searchStrategyType) {
        switch (searchStrategyType) {
            case BYNAME: return searchByNameStrategy;
            case BYTYPE: return searchByTypeStrategy;
            case BYDESCRIPTION: return searchByDescriptionStrategy;
            case BYID: return searchByIDStrategy;
            default: return null;
        }
    }

}
