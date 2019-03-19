package de.wathoserver.vaadin.visjs.demo.examples;

import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.prism.element.Language;
import com.google.common.collect.ImmutableSet;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep.LabelsPosition;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;

/**
 * <pre>
<script type="text/javascript">
    var nodes, edges, network;

        // convenience method to stringify a JSON object
        function toJSON(obj) {
            return JSON.stringify(obj, null, 4);
        }

        function addNode() {
            try {
                nodes.add({
                    id: document.getElementById('node-id').value,
                    label: document.getElementById('node-label').value
                });
            }
            catch (err) {
                alert(err);
            }
        }

        function updateNode() {
            try {
                nodes.update({
                    id: document.getElementById('node-id').value,
                    label: document.getElementById('node-label').value
                });
            }
            catch (err) {
                alert(err);
            }
        }
        function removeNode() {
            try {
                nodes.remove({id: document.getElementById('node-id').value});
            }
            catch (err) {
                alert(err);
            }
        }

        function addEdge() {
            try {
                edges.add({
                    id: document.getElementById('edge-id').value,
                    from: document.getElementById('edge-from').value,
                    to: document.getElementById('edge-to').value
                });
            }
            catch (err) {
                alert(err);
            }
        }
        function updateEdge() {
            try {
                edges.update({
                    id: document.getElementById('edge-id').value,
                    from: document.getElementById('edge-from').value,
                    to: document.getElementById('edge-to').value
                });
            }
            catch (err) {
                alert(err);
            }
        }
        function removeEdge() {
            try {
                edges.remove({id: document.getElementById('edge-id').value});
            }
            catch (err) {
                alert(err);
            }
        }

        function draw() {
            // create an array with nodes
            nodes = new vis.DataSet();
            nodes.on('*', function () {
                document.getElementById('nodes').innerHTML = JSON.stringify(nodes.get(), null, 4);
            });
            nodes.add([
                {id: '1', label: 'Node 1'},
                {id: '2', label: 'Node 2'},
                {id: '3', label: 'Node 3'},
                {id: '4', label: 'Node 4'},
                {id: '5', label: 'Node 5'}
            ]);

            // create an array with edges
            edges = new vis.DataSet();
            edges.on('*', function () {
                document.getElementById('edges').innerHTML = JSON.stringify(edges.get(), null, 4);
            });
            edges.add([
                {id: '1', from: '1', to: '2'},
                {id: '2', from: '1', to: '3'},
                {id: '3', from: '2', to: '4'},
                {id: '4', from: '2', to: '5'}
            ]);

            // create a network
            var container = document.getElementById('network');
            var data = {
                nodes: nodes,
                edges: edges
            };
            var options = {};
            network = new vis.Network(container, data, options);
        }
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class DynamicDataDynamicDataExample extends AbstractExample {

  private final NetworkDiagram nd;

  private final Set<Node> nodes;
  private final Set<Edge> edges;

  private Div nodesViewDiv;

  private Div edgesViewDiv;

  public DynamicDataDynamicDataExample() {
    nodes = ImmutableSet.of(new Node("1", "Node 1"), new Node("2", "Node 2"),
        new Node("3", "Node 3"), new Node("4", "Node 4"), new Node("5", "Node 5"));
    edges = ImmutableSet.of(new Edge("1", "1", "2", ""), new Edge("2", "1", "3", ""),
        new Edge("3", "2", "4", ""), new Edge("4", "2", "5", ""));
    nd = new NetworkDiagram();
    nd.setSize("350px", "400px");
    nd.setNodes(nodes);
    nd.setEdges(edges);
    nd.addNodesChangedListener(ev -> updateJsonViews());
    nd.addEdgesChangedListener(ev -> updateJsonViews());
    add(new HorizontalLayout(initNodesLayout(), initEdgesLayout()));
    add(new HorizontalLayout(initJsonViews(), nd));
  }

  private Component initNodesLayout() {
    final TextField idField = new TextField();
    final TextField labelField = new TextField();
    final FormLayout nodeForm = new FormLayout();
    nodeForm.addFormItem(idField, "Id");
    nodeForm.addFormItem(labelField, "Label");
    nodeForm
        .add(
            new HorizontalLayout(
                new Button("Add",
                    ev -> nd.addNodes(new Node(idField.getValue(), labelField.getValue()))),
                new Button("Update",
                    ev -> nd.updateNodes(new Node(idField.getValue(), labelField.getValue()))),
                new Button("Remove", ev -> nd.removeNodes(idField.getValue()))));
    nodeForm.setWidth("350px");
    nodeForm.setHeight("400px");
    nodeForm.setResponsiveSteps(new ResponsiveStep("0", 1, LabelsPosition.ASIDE));
    return new VerticalLayout(new H5("Node"), nodeForm);
  }

  private Component initEdgesLayout() {
    final TextField idField = new TextField();
    final TextField fromField = new TextField();
    final TextField toField = new TextField();
    final FormLayout nodeForm = new FormLayout();
    nodeForm.addFormItem(idField, "Id");
    nodeForm.addFormItem(fromField, "from");
    nodeForm.addFormItem(toField, "To");
    nodeForm
        .add(
            new HorizontalLayout(
                new Button("Add",
                    ev -> nd.addEdges(new Edge(idField.getValue(), fromField.getValue(),
                        toField.getValue(), ""))),
                new Button("Update",
                    ev -> nd.updateEdges(new Edge(idField.getValue(), fromField.getValue(),
                        toField.getValue(), ""))),
                new Button("Remove", ev -> nd.removeEdges(idField.getValue()))));
    nodeForm.setWidth("350px");
    return new VerticalLayout(new H5("Edge"), nodeForm);
  }

  private Component initJsonViews() {
    final VerticalLayout layout = new VerticalLayout();
    layout.setWidth("350px");
    nodesViewDiv = new Div();
    edgesViewDiv = new Div();
    layout.add(
        new VerticalLayout(new H5("View Nodes"), nodesViewDiv, new H5("View Edges"), edgesViewDiv));
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
    edgesViewDiv.removeAll();
    try {
      edgesViewDiv
          .add(new CodeExampleView(new CodeExample(nd.getMapper().writerWithDefaultPrettyPrinter()
              .writeValueAsString(nd.getEdges().values()), Language.json, "JSON")));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
