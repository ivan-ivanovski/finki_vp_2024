package mk.ukim.finki.wp.lab1.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.wp.lab1.service.EventService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet("/events")
public class EventListServlet extends HttpServlet {
    private final SpringTemplateEngine springTemplateEngine;
    private final EventService eventService;

    public EventListServlet(SpringTemplateEngine springTemplateEngine,EventService eventService) {
        this.springTemplateEngine = springTemplateEngine;
        this.eventService = eventService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(req.getServletContext()).buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);

        context.setVariable("userAgent",req.getHeader("user-agent"));
        context.setVariable("ipAddress",req.getRemoteUser());
        context.setVariable("eventsList",eventService.listAll());
        springTemplateEngine.process("events.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Retrieve form parameters
        String selectedEvent = req.getParameter("selectedEvent");
        String attendeeName = req.getParameter("attendeeName");
        String numberOfTickets = req.getParameter("numberOfTickets");
        if(selectedEvent==null || selectedEvent.isEmpty() && attendeeName==null || attendeeName.isEmpty() && numberOfTickets==null || numberOfTickets.isEmpty()){
            resp.sendRedirect("/events");
        }
        else{
            // Store them in the session
            req.getSession().setAttribute("selectedEvent", selectedEvent);
            req.getSession().setAttribute("attendeeName", attendeeName);
            req.getSession().setAttribute("numberOfTickets", numberOfTickets);

            // Redirect to the confirmation page
            resp.sendRedirect("/eventBooking");
        }

    }
}
