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
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelAlignmentExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "labels_labelAlignment", layout = MainShowcaseLayout.class)
@Caption("Alignment")
@Icon(VaadinIcon.ALIGN_LEFT)
public class LabelsLabelAlignmentView extends AbstractExampleView {

  public LabelsLabelAlignmentView(@Autowired LabelsLabelAlignmentExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/labelAlignment.html";
  }

  @Override
  protected Component getDescription() {
    final Paragraph warningP = new Paragraph(
        "The configuration beneath the diagram is not exactly the same as in the original javascript example, "
            + "cause defining functions as options is not possible yet.");
    warningP.getStyle().set("color", "red");

    return new VerticalLayout(
        new Paragraph("Labels of edges can be aligned to edges in various ways."),
        new Paragraph(
            "Text-alignment within node labels can be 'left' or 'center', other font alignments not implemented."),
        new Paragraph(
            "Label alignment (placement of label \"box\") for nodes (top, bottom, left, right, inside) is planned but not in vis yet."),
        new Paragraph(
            "The click event is captured and displayed to illustrate how the clicking on labels works. "
                + "You can drag the nodes over each other to see how this influences the click event values."));
  }

}
