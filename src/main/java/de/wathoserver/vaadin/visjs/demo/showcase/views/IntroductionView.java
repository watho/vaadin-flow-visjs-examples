package de.wathoserver.vaadin.visjs.demo.showcase.views;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;

@SuppressWarnings("serial")
@Route(value = "intro", layout = MainShowcaseLayout.class)
@Caption("Introduction")
@Icon(VaadinIcon.HOME)
public class IntroductionView extends VerticalLayout {

  public IntroductionView() {
    final Anchor anchor = new Anchor("http://visjs.org/network_examples.html",
        "http://visjs.org/network_examples.html");
    anchor.setTarget("_blank");
    add(new Paragraph(
        "This showcase tries to reimplement every example of the original javascript library."),
        new Paragraph(new Text("See: "), anchor));
  }

}
