package de.wathoserver.vaadin.visjs.demo.showcase.views.events;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EventsPhysicsEventsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "events_physics", layout = MainShowcaseLayout.class)
@Caption("Physics, stabilization etc.")
@Icon(VaadinIcon.LIGHTBULB)
public class EventsPhysicsEventsView extends AbstractExampleView {

  public EventsPhysicsEventsView(@Autowired EventsPhysicsEventsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/events/physicsEvents.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("Create a simple network with some nodes and edges.");
  }

}
