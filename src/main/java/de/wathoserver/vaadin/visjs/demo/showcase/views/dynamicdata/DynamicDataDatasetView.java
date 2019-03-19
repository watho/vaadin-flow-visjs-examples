package de.wathoserver.vaadin.visjs.demo.showcase.views.dynamicdata;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.DynamicDataDatasetsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "dynamicData_dataset", layout = MainShowcaseLayout.class)
@Caption("Dataset")
@Icon(VaadinIcon.BULLETS)
public class DynamicDataDatasetView extends AbstractExampleView {

  public DynamicDataDatasetView(@Autowired DynamicDataDatasetsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/data/datasets.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "You can change any settings you want while the network is initialized using the vis Dataset, setOptions and setData. Finally you can destroy the network and completely reinitialize it.");
  }

}
