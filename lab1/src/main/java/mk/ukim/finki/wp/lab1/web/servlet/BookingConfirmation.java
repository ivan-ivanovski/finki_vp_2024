package mk.ukim.finki.wp.lab1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet("/eventBooking")
public class BookingConfirmation extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;

    public BookingConfirmation(SpringTemplateEngine springTemplateEngine) {
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(webExchange);

        // Retrieve session attributes
        String selectedEvent = (String) req.getSession().getAttribute("selectedEvent");
        String attendeeName = (String) req.getSession().getAttribute("attendeeName");
        String numberOfTickets = (String) req.getSession().getAttribute("numberOfTickets");

        // Set these values in the context
        context.setVariable("event", selectedEvent);
        context.setVariable("attendee", attendeeName);
        context.setVariable("tickets", numberOfTickets);

        // Render the template
        springTemplateEngine.process("bookingConfirmation.html", context, resp.getWriter());

    }


}
