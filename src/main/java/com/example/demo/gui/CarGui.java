package com.example.demo.gui;

import com.example.demo.Car;
import com.example.demo.CarDao;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class CarGui extends VerticalLayout {
    private TextField textFieldId;
    private TextField textFieldMark;
    private TextField textFieldModel;
    private TextField textFieldColor;
    private Button button;
    private CarDao carDao;

    @Autowired
    public CarGui(CarDao carDao) {
        textFieldId = new TextField("Id");
        textFieldMark = new TextField("Mark");
        textFieldModel = new TextField("Model");
        textFieldColor = new TextField("Color");
        button = new Button("Save");
        this.carDao = carDao;

        button.addClickListener(buttonClickEvent -> {
            Car car = new Car(Integer.parseInt(textFieldId.getValue()),
                    textFieldMark.getValue(),
                    textFieldModel.getValue(),
                    textFieldColor.getValue());
            carDao.save(car);
        });


        add(textFieldId, textFieldMark, textFieldModel, textFieldColor, button);
    }
}
