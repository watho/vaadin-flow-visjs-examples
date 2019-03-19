package de.wathoserver.vaadin.visjs.demo.examples;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import com.github.appreciated.css.grid.sizes.Flex;
import com.github.appreciated.css.grid.sizes.Length;
import com.github.appreciated.css.grid.sizes.MinMax;
import com.github.appreciated.css.grid.sizes.Repeat.RepeatMode;
import com.github.appreciated.layout.FlexibleGridLayout;
import com.google.common.collect.ImmutableSet;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;

/**
 * <pre>
<script type="text/javascript">
  var nodeIds, shadowState, nodesArray, nodes, edgesArray, edges, network;

    function startNetwork() {
        // this list is kept to remove a random node.. we do not add node 1 here because it's used for changes
        nodeIds = [2, 3, 4, 5];
        shadowState = false;


        // create an array with nodes
        nodesArray = [
            {id: 1, label: 'Node 1'},
            {id: 2, label: 'Node 2'},
            {id: 3, label: 'Node 3'},
            {id: 4, label: 'Node 4'},
            {id: 5, label: 'Node 5'}
        ];
        nodes = new vis.DataSet(nodesArray);

        // create an array with edges
        edgesArray = [
            {from: 1, to: 3},
            {from: 1, to: 2},
            {from: 2, to: 4},
            {from: 2, to: 5}
        ];
        edges = new vis.DataSet(edgesArray);

        // create a network
        var container = document.getElementById('mynetwork');
        var data = {
            nodes: nodes,
            edges: edges
        };
        var options = {};
        network = new vis.Network(container, data, options);
    }

    function addNode() {
        var newId = (Math.random() * 1e7).toString(32);
        nodes.add({id:newId, label:"I'm new!"});
        nodeIds.push(newId);
    }

    function changeNode1() {
        var newColor = '#' + Math.floor((Math.random() * 255 * 255 * 255)).toString(16);
        nodes.update([{id:1, color:{background:newColor}}]);
    }

    function removeRandomNode() {
        var randomNodeId = nodeIds[Math.floor(Math.random() * nodeIds.length)];
        nodes.remove({id:randomNodeId});

        var index = nodeIds.indexOf(randomNodeId);
        nodeIds.splice(index,1);
    }

    function changeOptions() {
        shadowState = !shadowState;
        network.setOptions({nodes:{shadow:shadowState},edges:{shadow:shadowState}});
    }

    function resetAllNodes() {
        nodes.clear();
        edges.clear();
        nodes.add(nodesArray);
        edges.add(edgesArray);
    }

    function resetAllNodesStabilize() {
        resetAllNodes();
        network.stabilize();
    }

    function setTheData() {
        nodes = new vis.DataSet(nodesArray);
        edges = new vis.DataSet(edgesArray);
        network.setData({nodes:nodes, edges:edges})
    }

    function resetAll() {
        if (network !== null) {
            network.destroy();
            network = null;
        }
        startNetwork();
    }

    startNetwork();
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class DynamicDataDatasetsExample extends AbstractExample {

  private final NetworkDiagram nd;
  private boolean shadowState = false;
  private final Options options;
  private final Set<Node> nodes;
  // this list is kept to remove a random node.. we do not add node 1 here because it's used for
  // changes
  private ArrayList<String> nodeIds;
  private final Set<Edge> edges;
  private final Random rand = new Random();

  public DynamicDataDatasetsExample() {
    nodes = ImmutableSet.of(new Node("1", "Node 1"), new Node("2", "Node 2"),
        new Node("3", "Node 3"), new Node("4", "Node 4"), new Node("5", "Node 5"));
    initNodeIds();
    edges = ImmutableSet.of(new Edge("1", "3"), new Edge("1", "2"), new Edge("2", "4"),
        new Edge("2", "5"));
    options = Options.builder() //
        .withNodes(Nodes.builder().withShadow(shadowState).build())//
        .withEdges(Edges.builder().withShadow(shadowState).build())//
        .build();
    nd = new NetworkDiagram(options);
    nd.setSize("600px", "400px");
    nd.setNodes(nodes);
    nd.setEdges(edges);
    add(nd);
    add(new H5("DataSet (change the data while it's loaded and initialzed):"));
    final FlexibleGridLayout dataBtnLayout = new FlexibleGridLayout()
        .withColumns(RepeatMode.AUTO_FILL, new MinMax(new Length("250px"), new Flex()))
        .withItems(new Button("add node dynamically", ev -> addNodeDynamically()),
            new Button("change nodes 1st color dynamically", ev -> changeNodeColor()),
            new Button("remove a random node", ev -> removeRandomNode()),
            new Button("reload all nodes", ev -> reloadAllNodes()),
            new Button("reload all nodes and stabilize", ev -> reloadAllNodesAndStabilize()));
    dataBtnLayout.setWidth("600px");
    add(dataBtnLayout);
    add(new HorizontalLayout(new H5("setOptions (change the global options):"),
        new Button("change the global options", ev -> changeOptions())));
    add(new HorizontalLayout(new H5("setData (reinitialize the data):"),
        new Button("setData. This stabilizes again if stabilization is true.", ev -> resetData())));
    add(new HorizontalLayout(new H5("Cleanly destroy the network and restart it:"),
        new Button("Destroy the network and restart it:", ev -> destroyAndRestart())));
  }

  private void initNodeIds() {
    nodeIds = new ArrayList<>();
    nodeIds.addAll(
        nodes.stream().map(Node::getId).filter(i -> !"1".equals(i)).collect(Collectors.toSet()));
  }

  private void addNodeDynamically() {
    final Node newNode = new Node(UUID.randomUUID().toString(), "I'm new!");
    nd.addNodes(newNode);
    nodeIds.add(newNode.getId());
  }

  private void changeNodeColor() {
    final int r = rand.nextInt(256);
    final int g = rand.nextInt(256);
    final int b = rand.nextInt(256);
    final String newColor =
        "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
    nd.updateNodes(new Node("1", Node.builder().withColor(newColor)));
  }

  private void changeOptions() {
    shadowState = !shadowState;
    options.getNodes().setShadow(shadowState);
    options.getEdges().setShadow(shadowState);
    nd.setOptions(options);
  }

  private void removeRandomNode() {
    if (nodeIds.size() > 0) {
      final int index = rand.nextInt(nodeIds.size());
      final String nodeId = nodeIds.remove(index);
      nd.removeNodes(nodeId);
    }
  }

  private void reloadAllNodes() {
    nd.setNodes(nodes);
    nd.setEdges(edges);
    initNodeIds();
  }

  private void reloadAllNodesAndStabilize() {
    reloadAllNodes();
    nd.stabilizeDiagram();
  }

  private void resetData() {
    nd.setData(nodes, edges);
    initNodeIds();
  }

  private void destroyAndRestart() {
    nd.resetDiagram();
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
