package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;

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

  network.on("initRedraw", function () {
    // do something like move some custom elements?
  });
  network.on("beforeDrawing", function (ctx) {
    var nodeId = 1;
    var nodePosition = network.getPositions([nodeId]);
    ctx.strokeStyle = '#A6D5F7';
    ctx.fillStyle = '#294475';
    ctx.circle(nodePosition[nodeId].x, nodePosition[nodeId].y,50);
    ctx.fill();
    ctx.stroke();
  });
  network.on("afterDrawing", function (ctx) {
    var nodeId = 1;
    var nodePosition = network.getPositions([nodeId]);
    ctx.strokeStyle = '#294475';
    ctx.lineWidth = 4;
    ctx.fillStyle = '#A6D5F7';
    ctx.circle(nodePosition[nodeId].x, nodePosition[nodeId].y,20);
    ctx.fill();
    ctx.stroke();
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
public class EventsRenderEventsExample extends AbstractExample {

  private final NetworkDiagram nd;

  public EventsRenderEventsExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1");
    final Node node2 = new Node("2", "Node 2");
    final Node node3 = new Node("3", "Node 3");
    final Node node4 = new Node("4", "Node 4");
    final Node node5 = new Node("5", "Node 5");

    nd = new NetworkDiagram();
    nd.setSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5);
    nd.setEdges("1", "3", "1", "2", "2", "4", "2", "5");
    add(nd);
    // example not implementable yet cause there is no way to set custom javascript function as
    // listener
    nd.addBeforeDrawingListener(ev -> {
      log.info("Before: " + ev.getParams());
    });
    nd.addAfterDrawingListener(ev -> {
      log.info("After: " + ev.getParams());
    });
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
