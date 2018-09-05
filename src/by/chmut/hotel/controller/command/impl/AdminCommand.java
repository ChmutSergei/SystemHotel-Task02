package by.chmut.hotel.controller.command.impl;

import by.chmut.hotel.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.chmut.hotel.controller.command.constant.Constants.MAIN_PAGE;

public class AdminCommand implements Command {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.getRequestDispatcher(MAIN_PAGE).forward(req,resp);
    }
}
