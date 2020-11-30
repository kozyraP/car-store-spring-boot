package com.example.demo.gui;

import com.example.demo.CarDao;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class UpdateCarGui extends VerticalLayout {
    private TextField textFieldId;
    private TextField textFieldMark;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button button;
    private CarDao carDao;

    @Autowired
    public UpdateCarGui(CarDao carDao) {
        textFieldId = new TextField("Old Id");
        textFieldMark = new TextField(" New mark");
        textFieldModel = new TextField("New model");
        textFieldColor = new TextField("New color");
        button = new Button("Update");
        this.carDao = carDao;

        button.addClickListener(buttonClickEvent -> {
            carDao.updateById(textFieldMark.getValue(),
                    textFieldModel.getValue(),
                    textFieldColor.getValue(),
                    Integer.parseInt(textFieldId.getValue()));
        });


        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, button);
    }
}
