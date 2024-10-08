package in.bottomhalf.data.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.bottomhalf.data.utils.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class DbManager {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    DbUtils dbUtils;

    @Autowired
    ObjectMapper mapper;


    @Autowired
    DbManager(Template template) {
        jdbcTemplate = template.getTemplate();
    }

    public <T> void save(T instance) throws Exception {
        String query = dbUtils.save(instance);
        jdbcTemplate.execute(query);
    }

    public <T> List<T> get(Class<T> type) throws Exception {
        String query = dbUtils.get(type);
        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        return mapper.convertValue(result, new TypeReference<List<T>>() {});
    }

    public <T> T getById(T instance, Class<T> type) throws Exception {
        String query = dbUtils.getById(type);

        T emp = jdbcTemplate.queryForObject(query, type);

        List<Map<String, Object>> result = jdbcTemplate.queryForList(query);

        return mapper.convertValue(result, new TypeReference<T>() {});
    }
}
