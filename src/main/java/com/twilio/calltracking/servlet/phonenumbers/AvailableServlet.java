package com.twilio.calltracking.servlet.phonenumbers;

import com.twilio.calltracking.lib.services.TwilioServices;
import com.twilio.calltracking.servlet.WebAppServlet;
import com.twilio.sdk.verbs.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.stream.Collectors;

public class AvailableServlet extends WebAppServlet {

    private TwilioServices twilioServices;

    public AvailableServlet() {
        this(new TwilioServices());
    }

    public AvailableServlet(TwilioServices twilioServices) {
        this.twilioServices = twilioServices;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String areaCode = request.getParameter("areaCode");
        areaCode ="";
        System.out.println(twilioServices.SearchPhoneNumbers(areaCode).stream().limit(10).collect(Collectors.toList()).size());
        request.setAttribute("phoneNumbers",
                twilioServices.SearchPhoneNumbers(areaCode).stream().limit(10).collect(Collectors.toList()));
        request.getRequestDispatcher("/available_phone_numbers.jsp").forward(request, response);
    }
}