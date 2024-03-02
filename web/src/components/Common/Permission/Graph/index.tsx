import React, { useEffect, useState} from 'react'
import { Graph } from '@antv/x6';
import {ForceLayout} from "@antv/layout";
import {MiniMap} from "@antv/x6-plugin-minimap";
import './index.less'
import {SimpleNodeView} from "@/components/Common/Permission/Graph/SimpleView";
import {getGraphView} from "@/request/api";



function MyEditor() {
    // 初始，mounted生命周期时, container组件还没挂载。
    const [container,setcontainer] = useState<HTMLElement>(document.createElement('content'));
    const [minimapContainer,setminimapContainer] = useState<HTMLElement>(document.createElement('map'));
    const [data, setData] = useState<any>({ nodes: [], edges: [] });

    const minimap = new MiniMap({
        width: 300,
        height: 300,
        container: minimapContainer,
        graphOptions: {
            createCellView(cell) {
                if (cell.isEdge()) {
                    return undefined;
                }
                if (cell.isNode()) {
                    return SimpleNodeView;
                }
            },
        },
    });
    const refContainer=(container: HTMLDivElement)=> {
        setcontainer(container);
    }
    const refMiniMapContainer = (container: HTMLDivElement) => {
        setminimapContainer(container)
    }

    useEffect(() => {
        const fetchData = async () => {
            if (!container || !minimapContainer) return;

            try {
                const response = getGraphView();
                const result = await response;
                setData(result.data);
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, []);

    //官方文档写的是componentDidMount，因为react取消了三个生命周期函数，所以使用useEffect
    useEffect(()=>{
        if (!container || !minimapContainer || !data.nodes.length || !data.edges.length) return;
        // 清空容器内容
        container.innerHTML = '';
        minimapContainer.innerHTML = ''
        Graph.registerEdge(
            'custom-edge-label',
            {
                inherit: 'edge',
                defaultLabel: {
                    markup: [
                        {
                            tagName: 'rect',
                            selector: 'body',
                        },
                        {
                            tagName: 'text',
                            selector: 'label',
                        },
                    ],
                    attrs: {
                        label: {
                            fill: '#000',
                            fontSize: 14,
                            textAnchor: 'middle',
                            textVerticalAnchor: 'middle',
                            pointerEvents: 'none',
                        },
                        body: {
                            ref: 'label',
                            fill: '#ffd591',
                            stroke: '#ffa940',
                            refWidth: '140%',
                            refHeight: '140%',
                            refX: '-20%',
                            refY: '-20%',
                        },
                    },
                    position: {
                        distance: 50,
                        options: {
                            absoluteDistance: true,
                            reverseDistance: true,
                        },
                    },
                },
            },
            true,
        )
        const graph=(new Graph({
            grid: true,
            container: container,
            width: 1000,
            height: 600,
            panning: true,
            mousewheel: true,

        }));


            graph.fromJSON(data);
            graph.use(minimap)

        const forceLayout = new ForceLayout({
            type: 'force',
            center: [369, 180],
            preventOverlap: true,
            linkDistance: (d) => {
                return 180
            },
            nodeStrength: (d) => {
                if (d.isLeaf) {
                    return -50
                }
                return -10
            },
            edgeStrength: (d) => {
                if (
                    d.source.id === 'node1' ||
                    d.source.id === 'node2' ||
                    d.source.id === 'node3'
                ) {
                    return 0.7
                }
                return 0.2
            },
            tick: () => {
                graph.fromJSON(data)
            },
        })
        forceLayout.layout(data)
        }
    , [data])

    return (
        <div className="minimap-app">
            <div id = "content" className="app-content" ref={refContainer} />
            <div id = "map" className="app-minimap" ref={refMiniMapContainer} />
        </div>
    )
}


export default MyEditor;



