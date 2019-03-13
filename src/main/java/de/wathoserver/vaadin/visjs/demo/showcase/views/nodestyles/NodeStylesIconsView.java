package de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesIconsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_icons", layout = MainShowcaseLayout.class)
@Caption("icons")
@Icon(VaadinIcon.BUILDING)
public class NodeStylesIconsView extends AbstractExampleView {

  public NodeStylesIconsView(@Autowired NodeStylesIconsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/icons.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Icons can be used for nodes as well. This example shows Icons from fontAwesome and Ionicons but it should work with similar packages as well. It uses unicode and css to define the icons.\n"
            + "\n"
            + "Remember! Unicode in javascript is done like this: \\uf274 for the unicode f274. \n"
            + "If a node is shown as a rectangle, it means the css is not loaded (or not yet loaded). A redraw will fix that.");
  }

}
