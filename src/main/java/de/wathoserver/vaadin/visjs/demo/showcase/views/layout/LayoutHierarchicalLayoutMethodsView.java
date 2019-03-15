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
import de.wathoserver.vaadin.visjs.demo.examples.LayoutHierarchicalLayoutMethodsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "layout_hierarchicalLayoutMethods", layout = MainShowcaseLayout.class)
@Caption("Different methods")
@Icon(VaadinIcon.CONNECT_O)
public class LayoutHierarchicalLayoutMethodsView extends AbstractExampleView {

  public LayoutHierarchicalLayoutMethodsView(
      @Autowired LayoutHierarchicalLayoutMethodsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/layout/hierarchicalLayoutMethods.html";
  }

  @Override
  protected Component getDescription() {
    final Paragraph warningP = new Paragraph(
        "The configuration beneath the diagram is not exactly the same as in the original javascript example, "
            + "cause defining functions as options is not possible yet.");
    warningP.getStyle().set("color", "red");

    return new VerticalLayout(new H2("Hierarchical layout difference"), new Paragraph(
        "This example shows a the effect of the different hierarchical layout methods. Hubsize is based on the amount of edges connected to a node. The node with the most connections (the largest hub) is drawn at the top of the tree. The direction method is based on the direction of the edges. Try switching between the methods with the dropdown box below the diagram."));
  }

}
