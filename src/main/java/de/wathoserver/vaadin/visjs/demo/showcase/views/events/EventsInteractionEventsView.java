package de.wathoserver.vaadin.visjs.demo.showcase.views.events;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EventsInteractionEventsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "evtents_interaction", layout = MainShowcaseLayout.class)
@Caption("Interaction click rightclick etc.")
@Icon(VaadinIcon.POINTER)
public class EventsInteractionEventsView extends AbstractExampleView {

  public EventsInteractionEventsView(@Autowired EventsInteractionEventsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/events/interactionEvents.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Create a simple network with some nodes and edges. Some of the events are logged in the console in improve readability.");
  }

}
