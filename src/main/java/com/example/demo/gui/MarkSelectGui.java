package com.example.demo.gui;

import com.example.demo.CarDao;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Route
public class MarkSelectGui extends VerticalLayout {

    private TextField textFieldMark;
    private TextArea textArea;
    private Button button;
    private CarDao carDao;

    @Autowired
    public MarkSelectGui(CarDao carDao) {
        textFieldMark = new TextField("Enter the car mark");
        textArea = new TextArea();
        button = new Button("Search");
        this.carDao = carDao;

        button.addClickListener(buttonClickEvent -> {
            List<Map<String, Object>> maps = carDao.showByMark(textFieldMark.getValue());
            textArea.setSizeFull();
            textArea.setValue(maps.toString());
        });

        add(textFieldMark, textArea, button);
    }
}
