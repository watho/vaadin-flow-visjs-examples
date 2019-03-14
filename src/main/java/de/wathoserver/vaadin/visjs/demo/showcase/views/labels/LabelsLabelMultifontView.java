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
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelMultifontExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;
import de.wathoserver.vaadin.visjs.demo.showcase.StyledText;

@SuppressWarnings("serial")
@Route(value = "labels_labelMultifont", layout = MainShowcaseLayout.class)
@Caption("Multiple fonts")
@Icon(VaadinIcon.FONT)
public class LabelsLabelMultifontView extends AbstractExampleView {

  public LabelsLabelMultifontView(@Autowired LabelsLabelMultifontExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/labelMultifont.html";
  }

  @Override
  protected Component getDescription() {
    return new VerticalLayout(
        new Paragraph("Node and edge labels may be marked up to be drawn with multiple fonts."),
        new StyledText(
            "<p>The value of the <code>font.multi</code> property may be set to <code>'html'</code>, <code>'markdown'</code> or a boolean.</p>\n"
                + "<table class=\"indented\">\n"
                + "  <tr><th colspan='4'>Embedded Font Markup</th></tr>\n"
                + "  <tr><th rowspan=2>font mod</th><th colspan=3><code>font.multi</code> setting</th></tr>\n"
                + "  <tr><th><code>'html'</code> or <code>true</code></th><th><code>'markdown'</code> or <code>'md'</code></th><th><code>false<code></th></tr>\n"
                + "  <tr><th>bold</th><td><code>&lt;b&gt;</code> ... <code>&lt;/b></code></td><td><code>&nbsp;*</code> ... <code>*&nbsp;</code></td><td>n/a</td></tr>\n"
                + "  <tr><th>italic</th><td><code>&lt;i&gt;</code> ... <code>&lt;/i></code></td><td><code>&nbsp;_</code> ... <code>_&nbsp;</code></td><td>n/a</td></tr>\n"
                + "  <tr><th>mono-spaced</th><td><code>&lt;code&gt;</code> ... <code>&lt;/code&gt;</code></td><td><code>&nbsp;`</code> ... <code>`&nbsp;</code></td><td>n/a</td></tr>\n"
                + "</table>\n" + "\n" + "<p>\n"
                + "The <code>html</code> and <code>markdown</code> rendering is limited: bolds may be embedded in italics, italics may be embedded in bolds, and mono-spaced may be embedded in bold or italic, but will not be altered by those font mods, nor will embedded bolds or italics be handled.\n"
                + "The only entities that will be observed in html are <code>&amp;lt;</code> and <code>&amp;amp;</code> and in <code>markdown</code> a backslash will escape the following character (including a backslash) from special processing.\n"
                + "Any font mod that is started in a label line will be implicitly terminated at the end of that line.\n"
                + "While this interpretation may not exactly match <i>official</i> rendering standards, it is a consistent compromise for drawing multifont strings in the non-multifont html canvas element underlying vis.\n"
                + "</p>\n" + "\n"
                + "<p>This implies that four additional sets of font properties will be recognized in label processing.</p>\n"
                + "<p class=\"indented\"><code>font.bold</code> designates the font used for rendering bold font mods.\n"
                + "<br/><code>font.ital</code> designates the font used for rendering italic font mods.\n"
                + "<br/><code>font.boldital</code> designates the font used for rendering bold-<b><i>and</i></b>-italic font mods.\n"
                + "<br/><code>font.mono</code> designates the font used for rendering monospaced font mods.</p>\n"
                + "<p>Any font mod without a matching font will be rendered using the normal <code>font</code> (or default) value.</p>\n"
                + "\n"
                + "<p>The <code>font.multi</code> and extended font settings may be set in the network's <code>nodes</code> or <code>edges</code> properties, or on individual nodes and edges.\n"
                + "Node and edge label fonts are separate.</p>"));
  }

}
