package de.wathoserver.vaadin.visjs.demo.examples;

import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import elemental.json.JsonObject;
import elemental.json.impl.JsonUtil;

/**
 * <pre>
<script type="text/javascript">
   // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label: 'Node 1'},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3'},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5'}
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
  var options = {};
  var network = new vis.Network(container, data, options);

  network.on("startStabilizing", function (params) {
    document.getElementById('eventSpan').innerHTML = '<h3>Starting Stabilization</h3>';
    console.log("started")
  });
  network.on("stabilizationProgress", function (params) {
    document.getElementById('eventSpan').innerHTML = '<h3>Stabilization progress</h3>' + JSON.stringify(params, null, 4);
    console.log("progress:",params);
  });
  network.on("stabilizationIterationsDone", function (params) {
    document.getElementById('eventSpan').innerHTML = '<h3>Stabilization iterations complete</h3>';
    console.log("finished stabilization interations");
  });
  network.on("stabilized", function (params) {
    document.getElementById('eventSpan').innerHTML = '<h3>Stabilized!</h3>' + JSON.stringify(params, null, 4);
    console.log("stabilized!", params);
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
public class EventsPhysicsEventsExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Span eventSpan;

  public EventsPhysicsEventsExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1");
    final Node node2 = new Node("2", "Node 2");
    final Node node3 = new Node("3", "Node 3");
    final Node node4 = new Node("4", "Node 4");
    final Node node5 = new Node("5", "Node 5");

    nd = new NetworkDiagram();
    nd.diagramSetSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5);
    nd.setEdges("1", "3", "1", "2", "2", "4", "2", "5");
    add(nd);
    eventSpan = new Span();
    eventSpan.setWidth("500px");
    add(eventSpan);
    // Eventlistener
    nd.addStartStabilizingListener(ev -> showEvent("Start Stabilization", ev.getParams()));
    nd.addStabilizationProgressListener(ev -> showEvent("Stabilization Progress", ev.getParams()));
    nd.addStabilizationIterationsDoneListener(
        ev -> showEvent("Stabilization iterations complete", ev.getParams()));
    nd.addStabilizedListener(ev -> showEvent("Stabilized!", ev.getParams()));
  }

  private void showEvent(final String eventType, JsonObject params) {
    // eventSpan.removeAll();
    eventSpan.add(new H2(eventType));
    eventSpan.add(
        new CodeExampleView(new CodeExample(JsonUtil.stringify(params, 2), Language.json, "JSON")));
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
