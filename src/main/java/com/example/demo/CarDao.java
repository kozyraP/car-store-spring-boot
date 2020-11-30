package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CarDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Car car) {
        String sql = "INSERT INTO Cars(id,mark,model,color) VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, car.getCardId(),
                car.getMark(),
                car.getModel(),
                car.getColor());
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM Cars WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Map<String, Object>> showByMark(String mark) {
        String sql = "SELECT * FROM Cars WHERE mark LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{mark});
    }

    public void updateById(String mark, String model, String color, int id) {
        String sql = "UPDATE Cars SET mark = ?, model = ?, color = ? WHERE id = ?";
        jdbcTemplate.update(sql, mark, model, color, id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void dbNewItem() {
        save(new Car(1, "Audi", "R8", "Green"));
        save(new Car(2, "Volvo", "XC90", "White"));
        save(new Car(3, "Ford", "Mondeo", "Black"));
    }
}
