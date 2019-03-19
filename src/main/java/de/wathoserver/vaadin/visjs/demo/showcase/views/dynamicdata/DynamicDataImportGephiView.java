package de.wathoserver.vaadin.visjs.demo.showcase.views.dynamicdata;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.DynamicDataImportGephiExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;
import de.wathoserver.vaadin.visjs.demo.showcase.StyledText;

@SuppressWarnings("serial")
@Route(value = "dynamicData_importGephi", layout = MainShowcaseLayout.class)
@Caption("Import from Gephi")
@Icon(VaadinIcon.INBOX)
public class DynamicDataImportGephiView extends AbstractExampleView {

  public DynamicDataImportGephiView(@Autowired DynamicDataImportGephiExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/data/importingFromGephi.html";
  }

  @Override
  protected Component getDescription() {
    return new StyledText(
        "This example shows how to import a JSON file exported by Gephi. The two options available for the import are available through the checkboxes. You can download the Gephi JSON exporter here: <a href=\"https://gephi.org/plugins/#/plugin/jsonexporter-plugin\" target=\"_blank\">https://gephi.org/plugins/#/plugin/jsonexporter-plugin</a>. All of Gephi's attributes are also contained within the node elements. This means you can access all of this data through the DataSet.");
  }

}
