package de.wathoserver.vaadin.visjs.demo.showcase.views.dynamicdata;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.DynamicDataDynamicDataExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "dynamicData_dynamicData", layout = MainShowcaseLayout.class)
@Caption("Playground")
@Icon(VaadinIcon.PLAY)
public class DynamicDataDynamicDataView extends AbstractExampleView {

  public DynamicDataDynamicDataView(@Autowired DynamicDataDynamicDataExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/data/dynamicData.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "This example demonstrates dynamically adding, updating and removing nodes and edges using a DataSet.");
  }

}
