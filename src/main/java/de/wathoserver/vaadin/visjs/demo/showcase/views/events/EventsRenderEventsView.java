package de.wathoserver.vaadin.visjs.demo.showcase.views.events;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EventsRenderEventsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "events_render", layout = MainShowcaseLayout.class)
@Caption("rendering events, use to draw custom items")
@Icon(VaadinIcon.PENCIL)
public class EventsRenderEventsView extends AbstractExampleView {

  public EventsRenderEventsView(@Autowired EventsRenderEventsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/events/renderEvents.html";
  }

  @Override
  protected Component getDescription() {
    final Paragraph warningP = new Paragraph(
        "This example is not implementable yet, cause there is no way to set custom javascript functions as listener.");
    warningP.getStyle().set("color", "red");
    return new VerticalLayout(new Paragraph(
        "You can draw on the canvas using normal HTML5 canvas functions. The before drawing will be behind the network, the after drawing will be in front of the network."),
        warningP);
  }

}
