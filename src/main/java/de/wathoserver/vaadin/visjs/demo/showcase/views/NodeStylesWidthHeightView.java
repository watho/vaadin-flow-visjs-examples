package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesWidthHeightExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_widthHeight", layout = MainShowcaseLayout.class)
@Caption("width height")
@Icon(VaadinIcon.CUBE)
public class NodeStylesWidthHeightView extends AbstractExampleView {

  public NodeStylesWidthHeightView(@Autowired NodeStylesWidthHeightExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/widthHeight.html";
  }

  @Override
  protected Component getDescription() {
    final VerticalLayout layout = new VerticalLayout(new Paragraph(
        "Nodes may be set to have fixed, minimum and maximum widths and minimum heights. Nodes with minimum heights may also have a vertical alignment set."),
        new Paragraph("Edges may be set to have maximum widths."), new Paragraph(""),
        new Paragraph(
            "The widthConstraint: value option means a fixed width, the minimum and maximum width of the element are set to the value (respecting left and right margins). Lines exceeding the maximum width will be broken at space boundaries to fit."),
        new Paragraph(
            "The widthConstraint: { minimum: value } option sets the minimum width of the element to the value."),
        new Paragraph(
            "The widthConstraint: { maximum: value } option sets the maximum width of the element to the value (respecting left and right margins). Lines exceeding the maximum width will be broken at space boundaries to fit."),
        new Paragraph(
            "Minimum width line sizing is applied after maximum width line breaking, so counterintuitively, the minimum being greater than the maximum has a meaningful interpretation."),
        new Hr(),
        new Paragraph(
            "The heightConstraint: value option sets the minimum height of the element to the value (respecting top and bottom margins)."),
        new Paragraph(
            "The heightConstraint: { minimum: value } option also sets the minimum height of the element to the value (respecting top and bottom margins)."),
        new Paragraph(
            "The heightConstraint: { valign: value } option (with value 'top', 'middle', or 'bottom', sets the alignment of the text in the element's label to the elements top, middle or bottom (respecting top and bottom margins) when it's height is less than the minimum. The middle value is the default."),
        new Hr(),
        new Paragraph("Node width and height constraints may both be applied together, of course."),
        new Paragraph(
            "The constraint options may be applied to elements individually, or at the whole-set level. Whole-set node and edge constraints are exclusive."));
    layout.setSpacing(false);
    return layout;
  }

}
