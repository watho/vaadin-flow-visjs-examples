package de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesGroupsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_groups", layout = MainShowcaseLayout.class)
@Caption("groups")
@Icon(VaadinIcon.CLUSTER)
public class NodeStylesGroupsView extends AbstractExampleView {

  public NodeStylesGroupsView(@Autowired NodeStylesGroupsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/groups.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("Same styled nodes are defined through groups.");
  }

}
