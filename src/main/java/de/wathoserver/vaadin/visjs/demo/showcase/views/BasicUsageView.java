package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.BasicUsageExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "basicUsage", layout = MainShowcaseLayout.class)
@Caption("basic usage")
@Icon(VaadinIcon.BOLD)
public class BasicUsageView extends AbstractExampleView {

  public BasicUsageView(@Autowired BasicUsageExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/basicUsage.html";
  }

}
