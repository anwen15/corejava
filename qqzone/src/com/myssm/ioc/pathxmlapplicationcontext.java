package com.myssm.ioc;

import com.myssm.unti.StringUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class pathxmlapplicationcontext implements beanfactory{
    private Map<String,Object> beanmap = new HashMap<>();
    //private String path = "applicationContext.xml";
    public pathxmlapplicationcontext(){
        this("applicationContext.xml");
    }
    public pathxmlapplicationcontext(String path) {
        if (StringUtil.isEmpty(path)) {
            throw new RuntimeException("没有指定容器的配置文件");
        }
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            //1.创建DocumentBuilderFactory
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            //2.创建DocumentBuilder对象
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            //3.创建Document对象
            Document document = documentBuilder.parse(inputStream);

            //4.获取所有的bean节点
            NodeList beanNodeList = document.getElementsByTagName("bean");
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    String className = beanElement.getAttribute("class");
                    Class BeanClass = Class.forName(className);
                    //创建bean实例
                    Object beanObj = BeanClass.newInstance();
                    //放入map容器
                    beanmap.put(beanId, beanObj);
                    //此时bean之间的依赖关系还没有设置
                }
            }
            //设置bean之间的关系
            for (int i = 0; i < beanNodeList.getLength(); i++) {
                Node beanNode = beanNodeList.item(i);
                if (beanNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element beanElement = (Element) beanNode;
                    String beanId = beanElement.getAttribute("id");
                    NodeList childNodes = beanElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                        Node item = childNodes.item(j);
                        if(item.getNodeType() == Node.ELEMENT_NODE&& "property".equals(item.getNodeName())){
                            Element propertyElement = (Element) item;
                            String name = propertyElement.getAttribute("name");
                            String ref = propertyElement.getAttribute("ref");
                            //找到ref对应的实例
                            Object refobj = beanmap.get(ref);
                            //将ref设置到bean对应的property属性
                            Object beanobj = beanmap.get(beanId);
                            Class nameclass = beanobj.getClass();
                            Field namefield = nameclass.getDeclaredField(name);
                            namefield.setAccessible(true);
                            namefield.set(beanobj, refobj);
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public Object getBean(String id) {
        return beanmap.get(id);
    }
}
