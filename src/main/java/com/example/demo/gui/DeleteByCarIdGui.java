package com.example.demo.gui;

import com.example.demo.CarDao;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class DeleteByCarIdGui extends VerticalLayout {
    private TextField textFieldId;

    private Button button;
    private CarDao carDao;

    @Autowired
    public DeleteByCarIdGui(CarDao carDao) {
        textFieldId = new TextField("Write Id of car to delete");

        button = new Button("Delete");
        this.carDao = carDao;

        button.addClickListener(buttonClickEvent -> {
            carDao.deleteById(Integer.parseInt(textFieldId.getValue()));
        });

        add(textFieldId, button);
    }
}
