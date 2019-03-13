package de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesCustomGroupsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_customGroups", layout = MainShowcaseLayout.class)
@Caption("custom groups")
@Icon(VaadinIcon.USERS)
public class NodeStylesCustomGroupsView extends AbstractExampleView {

  public NodeStylesCustomGroupsView(@Autowired NodeStylesCustomGroupsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/customGroups.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("We use an icon once in the DOM so the CSS for fontAwesome is loaded.");
  }

}
