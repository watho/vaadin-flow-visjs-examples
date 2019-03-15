package de.wathoserver.vaadin.visjs.demo.showcase.views.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LayoutHierarchicalLayoutUserDefinedExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "layout_hierarchicalLayoutUserDefined", layout = MainShowcaseLayout.class)
@Caption("User defined")
@Icon(VaadinIcon.USER)
public class LayoutHierarchicalLayoutUserDefinedView extends AbstractExampleView {

  public LayoutHierarchicalLayoutUserDefinedView(
      @Autowired LayoutHierarchicalLayoutUserDefinedExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/layout/hierarchicalLayoutUserdefined.html";
  }

  @Override
  protected Component getDescription() {
    return new VerticalLayout(new H2("Hierarchical Layout - User defined"), new Paragraph(
        "This example shows a user-defined hierarchical layout. If the user defines levels for nodes but does not do so for all nodes, an alert will show up and hierarchical layout will be disabled. Either all or none can be defined. If the smooth curves appear to be inverted, the direction of the edge is not in the same direction as the network."));
  }

}
