package de.wathoserver.vaadin.visjs.demo.showcase.views.labels;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelMarginsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "labels_labelMargins", layout = MainShowcaseLayout.class)
@Caption("Margins")
@Icon(VaadinIcon.MARGIN)
public class LabelsLabelMarginsView extends AbstractExampleView {

  public LabelsLabelMarginsView(@Autowired LabelsLabelMarginsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/labelMargins.html";
  }

  @Override
  protected Component getDescription() {
    return new VerticalLayout(new Paragraph(
        "The labels of box, circle, database, icon and text nodes may have different margin values. Top, right, bottom and left margins may be different for each node."),
        new Paragraph(
            "Setting the margin value in the network's nodes property sets it as the default."),
        new Paragraph(
            "Setting a the value to a number uses that number for the margins. If the value is an object, a different value for each margin will be set."),
        new Paragraph("Note that negative values appropriately push labels outside the node."));
  }
}
