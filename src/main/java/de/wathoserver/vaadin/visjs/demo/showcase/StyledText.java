package de.wathoserver.vaadin.visjs.demo.showcase;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.HasText;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Span;

/**
 * A component to show HTML text. See https://vaadin.com/forum/thread/17072019/17508926
 *
 * @author Syam
 */
@SuppressWarnings("serial")
public class StyledText extends Composite<Span> implements HasText {

    private final Span content = new Span();
    private String text;

    public StyledText(String htmlText) {
        setText(htmlText);
    }

    @Override
    protected Span initContent() {
        return content;
    }

    @Override
    public void setText(String htmlText) {
        if(htmlText == null) {
            htmlText = "";
        }
        if(htmlText.equals(text)) {
            return;
        }
        text = htmlText;
        content.removeAll();
        content.add(new Html("<span>" + htmlText + "</span>"));
    }

    @Override
    public String getText() {
        return text;
    }
}