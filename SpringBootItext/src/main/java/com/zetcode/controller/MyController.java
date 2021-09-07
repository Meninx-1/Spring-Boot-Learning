package com.zetcode.controller;

import com.zetcode.bean.Car;
import com.zetcode.service.ICarService;
import com.zetcode.view.MyPdfView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @Autowired
    private ICarService carService;

    @RequestMapping(path = "/report", method = RequestMethod.GET)
    public ModelAndView report() {
        
        Map<String, Object> model = new HashMap<>();

        List<Car> cars = carService.findAll();
        model.put("cars", cars);

        return new ModelAndView(new MyPdfView(), model);
    }
}