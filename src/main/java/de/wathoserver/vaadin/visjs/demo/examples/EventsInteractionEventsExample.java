package de.wathoserver.vaadin.visjs.demo.examples;

import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.demo.showcase.StyledText;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Interaction;
import de.wathoserver.vaadin.visjs.network.options.Manipulation;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes.Builder;
import elemental.json.JsonObject;
import elemental.json.impl.JsonUtil;

/**
 * <pre>
<script type="text/javascript">
   // create an array with nodes
    var nodes = new vis.DataSet([
        {id: 1, label: 'Node 1', title: 'I have a popup!'},
        {id: 2, label: 'Node 2', title: 'I have a popup!'},
        {id: 3, label: 'Node 3', title: 'I have a popup!'},
        {id: 4, label: 'Node 4', title: 'I have a popup!'},
        {id: 5, label: 'Node 5', title: 'I have a popup!'}
    ]);

    // create an array with edges
    var edges = new vis.DataSet([
        {from: 1, to: 3},
        {from: 1, to: 2},
        {from: 2, to: 4},
        {from: 2, to: 5}
    ]);

    // create a network
    var container = document.getElementById('mynetwork');
    var data = {
        nodes: nodes,
        edges: edges
    };

    var options = {
            interaction:{hover:true},
            manipulation: {
                enabled: true
            }
        };

    var network = new vis.Network(container, data, options);

    network.on("click", function (params) {
        params.event = "[original event]";
        document.getElementById('eventSpan').innerHTML = '<h2>Click event:</h2>' + JSON.stringify(params, null, 4);
        console.log('click event, getNodeAt returns: ' + this.getNodeAt(params.pointer.DOM));
    });
    network.on("doubleClick", function (params) {
        params.event = "[original event]";
        document.getElementById('eventSpan').innerHTML = '<h2>doubleClick event:</h2>' + JSON.stringify(params, null, 4);
    });
    network.on("oncontext", function (params) {
        params.event = "[original event]";
        document.getElementById('eventSpan').innerHTML = '<h2>oncontext (right click) event:</h2>' + JSON.stringify(params, null, 4);
    });
    network.on("dragStart", function (params) {
        // There's no point in displaying this event on screen, it gets immediately overwritten
        params.event = "[original event]";
        console.log('dragStart Event:', params);
        console.log('dragStart event, getNodeAt returns: ' + this.getNodeAt(params.pointer.DOM));
    });
    network.on("dragging", function (params) {
        params.event = "[original event]";
        document.getElementById('eventSpan').innerHTML = '<h2>dragging event:</h2>' + JSON.stringify(params, null, 4);
    });
    network.on("dragEnd", function (params) {
        params.event = "[original event]";
        document.getElementById('eventSpan').innerHTML = '<h2>dragEnd event:</h2>' + JSON.stringify(params, null, 4);
        console.log('dragEnd Event:', params);
        console.log('dragEnd event, getNodeAt returns: ' + this.getNodeAt(params.pointer.DOM));
    });
    network.on("zoom", function (params) {
        document.getElementById('eventSpan').innerHTML = '<h2>zoom event:</h2>' + JSON.stringify(params, null, 4);
    });
    network.on("showPopup", function (params) {
        document.getElementById('eventSpan').innerHTML = '<h2>showPopup event: </h2>' + JSON.stringify(params, null, 4);
    });
    network.on("hidePopup", function () {
        console.log('hidePopup Event');
    });
    network.on("select", function (params) {
        console.log('select Event:', params);
    });
    network.on("selectNode", function (params) {
        console.log('selectNode Event:', params);
    });
    network.on("selectEdge", function (params) {
        console.log('selectEdge Event:', params);
    });
    network.on("deselectNode", function (params) {
        console.log('deselectNode Event:', params);
    });
    network.on("deselectEdge", function (params) {
        console.log('deselectEdge Event:', params);
    });
    network.on("hoverNode", function (params) {
        console.log('hoverNode Event:', params);
    });
    network.on("hoverEdge", function (params) {
        console.log('hoverEdge Event:', params);
    });
    network.on("blurNode", function (params) {
        console.log('blurNode Event:', params);
    });
    network.on("blurEdge", function (params) {
        console.log('blurEdge Event:', params);
    });
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class EventsInteractionEventsExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Span eventSpan;
  private final TextArea eventLog;

  public EventsInteractionEventsExample() {
    // Set Nodes
    final Builder nodeBuilder = Node.builder().withTitle("I have a popup!");
    final Node node1 = new Node("1", "Node 1", nodeBuilder);
    final Node node2 = new Node("2", "Node 2", nodeBuilder);
    final Node node3 = new Node("3", "Node 3", nodeBuilder);
    final Node node4 = new Node("4", "Node 4", nodeBuilder);
    final Node node5 = new Node("5", "Node 5", nodeBuilder);

    nd = new NetworkDiagram(Options.builder() //
        .withInteraction(Interaction.builder().withHover(true).build()) //
        .withManipulation(Manipulation.builder().withEnabled(true).build()) //
        .build());
    nd.setSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5);
    nd.setEdges("1", "3", "1", "2", "2", "4", "2", "5");
    add(nd);
    eventSpan = new Span();
    eventSpan.setWidth("300px");
    eventLog = new TextArea();
    eventLog.setWidth("300px");
    eventLog.setHeight("300px");
    add(new HorizontalLayout(eventSpan, eventLog));
    // Eventlistener
    nd.addClickListener(ev -> showEvent("Click event", ev.getParams()));
    nd.addDoubleClickListener(ev -> showEvent("DoubleClick event", ev.getParams()));
    nd.addOnContextListener(ev -> showEvent("oncontext event", ev.getParams()));
    // There's no point in displaying this event on screen, it gets immediately overwritten
    nd.addDragStartListener(ev -> logEvent("dragStart", ev.getParams()));
    nd.addDraggingListener(ev -> showEvent("dragging event:", ev.getParams()));
    nd.addDragEndListener(ev -> showEvent("gradEnd event:", ev.getParams()));
    nd.addZoomListener(ev -> showEvent("zoom event:", ev.getParams()));
    nd.addShowPopupListener(ev -> showEvent("showPopup event:", "ItemId=" + ev.getItemId()));
    nd.addHidePopupListener(ev -> logEvent("hidePopup event:", ev.getParams()));
    // There's no point in displaying this event on screen, it gets immediately overwritten
    nd.addSelectListener(ev -> logEvent("select event:", ev.getParams()));
    // There's no point in displaying this event on screen, it gets immediately overwritten
    nd.addSelectNodeListener(ev -> logEvent("selectNode event:", ev.getParams()));
    // There's no point in displaying this event on screen, it gets immediately overwritten
    nd.addSelectEdgeListener(ev -> logEvent("selectEdge event:", ev.getParams()));
    // There's no point in displaying this event on screen, it gets immediately overwritten
    nd.addDeselectNodeListener(ev -> logEvent("deselectNode event:", ev.getParams()));
    // There's no point in displaying this event on screen, it gets immediately overwritten
    nd.addDeselectEdgeListener(ev -> logEvent("deselectEdge event:", ev.getParams()));
    nd.addHoverNodeListener(ev -> showEvent("hoverNode event:", ev.getParams()));
    nd.addHoverEdgeListener(ev -> showEvent("hoverEdge event:", ev.getParams()));
    nd.addBlurNodeListener(ev -> showEvent("blurNode event:", ev.getParams()));
    nd.addBlurEdgeListener(ev -> showEvent("blurEdge event:", ev.getParams()));
  }

  private void showEvent(final String eventType, JsonObject params) {
    eventSpan.removeAll();
    eventSpan.add(new H2(eventType));
    eventSpan.add(
        new CodeExampleView(new CodeExample(JsonUtil.stringify(params, 2), Language.json, "JSON")));
  }

  private void showEvent(final String eventType, String params) {
    eventSpan.removeAll();
    eventSpan.add(new H2(eventType));
    eventSpan.add(new StyledText(params));
  }

  private void logEvent(final String eventType, final JsonObject params) {
    eventLog.setValue(eventType + ": " + JsonUtil.stringify(params, 2) + "\n###############\n"
        + eventLog.getValue());
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
