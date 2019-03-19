package de.wathoserver.vaadin.visjs.demo.examples;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;

/**
 * <pre>
<script type="text/javascript">
  var network;

  var nodes = new vis.DataSet();
  var edges = new vis.DataSet();
  var gephiImported;
  var fixedCheckbox = document.getElementById('fixed');
  fixedCheckbox.onchange = redrawAll;

  var parseColorCheckbox = document.getElementById('parseColor');
  parseColorCheckbox.onchange = redrawAll;

  var nodeContent = document.getElementById('nodeContent');

  loadJSON('../datasources/WorldCup2014.json', redrawAll, function(err) {console.log('error')});

  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    nodes: {
      shape: 'dot',
      font: {
        face: 'Tahoma'
      }
    },
    edges: {
      width: 0.15,
      smooth: {
        type: 'continuous'
      }
    },
    interaction: {
      tooltipDelay: 200,
      hideEdgesOnDrag: true
    },
    physics: {
      stabilization: false,
      barnesHut: {
        gravitationalConstant: -10000,
        springConstant: 0.002,
        springLength: 150
      }
    }
  };

  network = new vis.Network(container, data, options);
  network.on('click', function (params) {
    if (params.nodes.length > 0) {
      var data = nodes.get(params.nodes[0]); // get the data from selected node
      nodeContent.innerHTML = JSON.stringify(data, undefined, 3); // show the data in the div
    }
  })

  /**
   * This function fills the DataSets. These DataSets will update the network.
   *
  function redrawAll(gephiJSON) {
    if (gephiJSON.nodes === undefined) {
      gephiJSON = gephiImported;
    }
    else {
      gephiImported = gephiJSON;
    }

    nodes.clear();
    edges.clear();

    var fixed = fixedCheckbox.checked;
    var parseColor = parseColorCheckbox.checked;

    var parsed = vis.network.gephiParser.parseGephi(gephiJSON, {
      fixed: fixed,
      parseColor: parseColor
    });

    // add the parsed data to the DataSets.
    nodes.add(parsed.nodes);
    edges.add(parsed.edges);

    var data = nodes.get(2); // get the data from node 2 as example
    nodeContent.innerHTML = JSON.stringify(data,undefined,3); // show the data in the div
    network.fit(); // zoom to fit
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class DynamicDataImportGephiExample extends AbstractExample {

  private final NetworkDiagram nd;

  private Div nodesViewDiv;

  public DynamicDataImportGephiExample() {
    nd = new NetworkDiagram();
    nd.setSize("350px", "400px");
    add(new HorizontalLayout(initJsonViews(), nd));
    // Loading json file
    // Does not work yet nd.convertGephi("frontend/src/WorldCup2014.json", new GephiOptions());
  }

  private Component initJsonViews() {
    final VerticalLayout layout = new VerticalLayout();
    layout.setWidth("350px");
    nodesViewDiv = new Div();
    layout.add(new VerticalLayout(new H5("View Nodes"), nodesViewDiv));
    updateJsonViews();
    return layout;
  }

  private void updateJsonViews() {
    nodesViewDiv.removeAll();
    try {
      nodesViewDiv
          .add(new CodeExampleView(new CodeExample(nd.getMapper().writerWithDefaultPrettyPrinter()
              .writeValueAsString(nd.getNodes().values()), Language.json, "JSON")));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
