package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesColorsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_colors", layout = MainShowcaseLayout.class)
@Caption("colors")
@Icon(VaadinIcon.COPYRIGHT)
public class NodeStylesColorsView extends AbstractExampleView {

  public NodeStylesColorsView(@Autowired NodeStylesColorsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/colors.html";
  }

}
