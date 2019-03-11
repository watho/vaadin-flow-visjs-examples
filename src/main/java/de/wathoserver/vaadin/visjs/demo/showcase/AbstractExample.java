package de.wathoserver.vaadin.visjs.demo.showcase;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@SuppressWarnings("serial")
public abstract class AbstractExample extends VerticalLayout implements HasNetworkDiagram {

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);
    this.getNetworkDiagram().getStyle().set("border", "1px solid #444444");
  }
}
