package ru.iteco.account.homeworkTwo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.iteco.account.homeworkTwo.CacheResult;
import ru.iteco.account.homeworkTwo.ExternalInfo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ExternalServiceImpl implements ExternalService {
    private final Map<Integer, ExternalInfo> externalInfoMap = new HashMap<>();

    @Value("${id-not-process}")
    private Integer id;

    public ExternalServiceImpl() {
    }

    @CacheResult
    public ExternalInfo getExternalInfo(Integer id) {
        return externalInfoMap.get(id);
    }

    @PostConstruct
    public void init() {
        externalInfoMap.put(1, new ExternalInfo(1, "hasInfo"));
        externalInfoMap.put(2, new ExternalInfo(2, null));
        externalInfoMap.put(3, new ExternalInfo(3, "info"));
        externalInfoMap.put(4, new ExternalInfo(4, "information"));
    }

    @PreDestroy
    public void destroy() {
        log.info("Map before clear:  {}", externalInfoMap);
        externalInfoMap.clear();
        log.info("Map after clear:  {}", externalInfoMap);
    }
}
